package com.wmeimob.yzfs.api.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.wmeimob.yzfs.dao.CartMapper;
import com.wmeimob.yzfs.dao.EcGoodSkuMapper;
import com.wmeimob.yzfs.dao.EcNeckSkuMapper;
import com.wmeimob.yzfs.dao.GoodsMapper;
import com.wmeimob.yzfs.dao.OrderItemSkuMapper;
import com.wmeimob.yzfs.dao.OrderItemsMapper;
import com.wmeimob.yzfs.dao.UsersMapper;
import com.wmeimob.yzfs.exception.CustomException;
import com.wmeimob.yzfs.model.Cart;
import com.wmeimob.yzfs.model.EcGoodSku;
import com.wmeimob.yzfs.model.EcNeckSku;
import com.wmeimob.yzfs.model.Goods;
import com.wmeimob.yzfs.model.OrderItemSku;
import com.wmeimob.yzfs.model.OrderItems;
import com.wmeimob.yzfs.util.JwtTokenUtil;

@Service
@Transactional
public class CartServiceApi {
	
	@Autowired
    private JwtTokenUtil jwtTokenUtil;

	@Autowired
	EcGoodSkuMapper ecGoodSkuMapper;
	
	@Autowired
	EcNeckSkuMapper ecNeckSkuMapper;
	
	@Autowired
	UsersMapper usersMapper;
	
	@Autowired
	GoodsMapper goodsMapper;
	
	@Autowired
	CartMapper cartMapper;
	
	@Autowired
	OrderItemsMapper orderItemsMapper;
	
	@Autowired
	OrderItemSkuMapper orderItemSkuMapper;
	
	
	/**
	 * 查询购物车列表
	 * @param request
	 * @return
	 */
	public JSONObject queryListCartFromWX(HttpServletRequest request) throws CustomException{
		JSONObject  data = new JSONObject();
		String token = request.getHeader(jwtTokenUtil.tokenHeader);//获取前端传来的TOKEN
		String userId = jwtTokenUtil.getIdFromToken(token);
		try {
			if (userId == null || StringUtils.isEmpty(userId)) {
				data.put("code", 404);
				data.put("data", "data is null");
				data.put("message", "用户不存在，非法请求!");
				return data;
			}
			//查询购物车 ，如果不存在，则创建购物车
			Cart cart = getUserCart(userId);
			//根据商品ID和购物车ID查询该商品是否存在
			OrderItems oi = new OrderItems();
			oi.setContainerId(cart.getId());
			List<OrderItems> oiList = orderItemsMapper.selectCartListByCartIdFromWX(oi);
			if (oiList != null && oiList.size() > 0) {
				data.put("code", 100);
				data.put("data", oiList);
				data.put("message", "success");
			} else {
				data.put("code", 200);
				data.put("data", "data is empty");
				data.put("message", "购物车空空如也啊!");
			} 
		} catch (Exception e) {
			throw new  CustomException(404,"Network anomaly");
		}
		return data;
	}
	
	
	
	
	/**
	 * 加入购物车
	 * @param request
     * @param skuCode 商品SKU编码
     * @param neckSkuCode 定制SKU编码
     * @param id 商品ID
     * @param number 商品数量
     * @param isMade 是否私人定制   true 是 ； false 或者null  非；
	 * @return
	 * @throws CustomException
	 */
	public JSONObject addCart(HttpServletRequest request,String skuCode,String neckSkuCode,String goodId,int quantity,String snCode,Boolean isMade) throws CustomException{
		JSONObject  data = new JSONObject();
		String token = request.getHeader(jwtTokenUtil.tokenHeader);//获取前端传来的TOKEN
		String userId = jwtTokenUtil.getIdFromToken(token);
		EcGoodSku sku =null;
		EcNeckSku neckSku =null;
		Goods good=null;
		//线程锁
		synchronized (snCode) {
			try {
				//查询用户是否存在
				if (StringUtils.isEmpty(goodId)) {
					data.put("code", 404);
					data.put("data", "data is null");
					data.put("message", "非法的参数!");
					return data;
				}
				if (!StringUtils.isEmpty(goodId)) {
					//根据商品ID查询商品信息
					good = goodsMapper.queryGoodExistById(goodId);
					if (good == null || StringUtils.isEmpty(good.getSpuCode())) {
						data.put("code", 404);
						data.put("data", "data is null");
						data.put("message", "非法的参数!");
						return data;
					}
				}
				if (userId == null || StringUtils.isEmpty(userId)) {
					data.put("code", 403);
					data.put("data", "data is null");
					data.put("message", "用户不存在，非法请求!");
					return data;
				}
				//是否私人定制
				if(isMade){
					neckSku=ecNeckSkuMapper.queryGoodNeckSkuBySkuCode(neckSkuCode, goodId);
					if (neckSku == null || StringUtils.isEmpty(neckSku.getSkuCode())) {
						data.put("code", 404);
						data.put("data", "data is null");
						data.put("message", "定制SKU不存在!");
						return data;
					}
				}
				//根据商品ID和SKU编码查询商品SKU信息
				sku = ecGoodSkuMapper.queryGoodSkuBySkuCode(skuCode, goodId);
				if (sku == null || StringUtils.isEmpty(sku.getSkuCode())) {
					data.put("code", 404);
					data.put("data", "data is null");
					data.put("message", "商品SKU不存在!");
					return data;
				}
				//验证库存是否满足
				if(sku.getStockCount() - (sku.getLockCount()+sku.getSaleCount())-quantity > 0) {
					//查询购物车 ，如果不存在，则创建购物车
					Cart cart =this.getUserCart(userId);
					//购物车信息
					OrderItems oi = new OrderItems();
					oi.setContainerId(cart.getId());
					oi.setGoodId(goodId);
					oi.setSkuCode(skuCode);
					oi.setNeckSkuCode(neckSkuCode);
					oi.setIsMade(isMade);
					int count = 0;
					int goodNeckId=0;
					int goodSpecId=0;
					//根据商品ID和购物车ID查询当前购物车商品列表
					oi= orderItemsMapper.selectByOrderItemsByGoodId(oi);
					if (oi!=null) {
						if (oi.getQuantity() + quantity >= sku.getStockCount()) {
							oi.setQuantity(sku.getStockCount());
						} else {
							oi.setQuantity(oi.getQuantity() + quantity);
						}
						count = orderItemsMapper.updateByPrimaryKeySelective(oi);
					}else{
						oi = new OrderItems();
						oi.setContainerId(cart.getId());
						oi.setGoodId(goodId);
						oi.setSalePrice(sku.getPrice());
						oi.setSalePoint(0);
						oi.setQuantity(quantity);
						oi.setShippingFee(new BigDecimal(0));
						oi.setCommission(new BigDecimal(0));
						oi.setGetPoints(new BigDecimal(0));
						oi.setRefundsStatus(0);
						// false 订单； true 购物车
						oi.setContainerType(true);
						oi.setStatus(true);
						//商品SKU信息
						OrderItemSku skuProperties = new OrderItemSku();
						skuProperties.setCreatedAt(new Date());
						skuProperties.setUpdatedAt(new Date());
						skuProperties.setStatus(true);
						//是否私人定制
						if(isMade){
							oi.setFarePrice(neckSku.getSalePrice());
							skuProperties.setOrderItemSkuName(neckSku.getSkuName());//定制名称
							skuProperties.setSpuId(goodId);
							skuProperties.setSkuCode(neckSkuCode);//定制编码
							skuProperties.setPicKey(neckSku.getPicKey());//定制图片
							//新增可改装信息
							orderItemSkuMapper.insertSelective(skuProperties);
							goodNeckId=skuProperties.getId();
						}
						skuProperties.setOrderItemSkuName(sku.getSkuName());//SKU名称
						skuProperties.setSpuId(goodId);
						skuProperties.setSkuCode(skuCode);//SKU编码
						skuProperties.setPicKey(sku.getPicKey());//SKU商品图片
						//新增SKU信息
						orderItemSkuMapper.insertSelective(skuProperties);
						goodSpecId = skuProperties.getId();
						oi.setId(UUID.randomUUID().toString());
						oi.setGoodSpecId(goodSpecId);
						oi.setGoodNeckId(goodNeckId);
						oi.setCreatedAt(new Date());
						oi.setUpdatedAt(new Date());
						oi.setIsMade(isMade);
						//新增购物车信息
						count = orderItemsMapper.insertSelective(oi);
					}
					if (count > 0) {
						data.put("code", 100);
						data.put("data", "success");
						data.put("message", "成功添加购物车");
						return data;
					} else {
						data.put("code", 200);
						data.put("data", "error");
						data.put("message", "添加购物车失败!");
						return data;
					}
				} else {
					data.put("code", 300);
					data.put("data", "stock is  empty");
					data.put("message", "库存不足!");
					return data;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				throw new  CustomException(404,"Network anomaly");
			}
		}
	}
	
	/**
	 * 创建或者查询购物车
	 * @param userId
	 * @return
	 */
    public Cart getUserCart(String userId) {
        Cart cond = new Cart();
        cond.setOwnerId(userId);
        cond.setStatus(true);
        List<Cart> cartList = cartMapper.selectByCart(cond);
        Cart cart = new Cart();
        if (cartList == null || cartList.isEmpty()) {
            // cart 不存在 插入
            cart.setId(UUID.randomUUID().toString());
            cart.setOwnerId(userId);
            cart.setStatus(true);
            cart.setUpdatedAt(new Date());
            cart.setCreatedAt(new Date());
            cartMapper.insert(cart);
        } else {
            // cart 存在直接返回
            cart = cartList.get(0);
        }
        return cart;
    }
    
	/**
	 * 购物车数量加减
	 * @param userId
	 * @return
	 */
    public JSONObject addAndSub(HttpServletRequest request,String itemId,int number) throws CustomException{
    	JSONObject  data = new JSONObject();
		OrderItems orderItem=new OrderItems();
		EcGoodSku sku =new EcGoodSku();
		boolean isContinueAddAndSub=true;//是否继续添加或者减
		try {
			orderItem.setId(itemId);
			orderItem = orderItemsMapper.selectOrderItemByIdFromWX(orderItem);
			if (orderItem != null && !StringUtils.isEmpty(orderItem.getId()) && itemId.equals(orderItem.getId())) {
				sku.setId(orderItem.getGoodSpecId());
				if(number>=orderItem.getStockCount()){
					if(orderItem.getStockCount()>0){
					  orderItem.setQuantity(orderItem.getStockCount());
					  data.put("stockCount",orderItem.getStockCount());
					}else{
					  data.put("stockCount",1);
					}
					 isContinueAddAndSub=false;
				}else{
					if(number<=1){
						orderItem.setQuantity(1);
					}else{
						orderItem.setQuantity(number);
					}
				}
				if (orderItemsMapper.updateByPrimaryKeySelective(orderItem) > 0) {
					data.put("code", 100);
					data.put("data", "成功");
					data.put("message", "success");
					data.put("isContinueAddAndSub",isContinueAddAndSub);
					return data;
				} else {
					data.put("code", 404);
					data.put("data", "失败");
					data.put("message", "error!");
					data.put("isContinueAddAndSub","");
					return data;
				}
			} 
		} catch (Exception e) {
			throw new  CustomException(404,"Network anomaly");
		}
		return data;
    }
    
    
	/**
	 * 批量删除购物车信息
	 * @param userId
	 * @return
	 */
    public JSONObject deleteCartById(HttpServletRequest request,String itemId) throws CustomException{
    	JSONObject  data = new JSONObject();
		try {
			if(StringUtils.isEmpty(itemId)){
				data.put("code", 404);
				data.put("data","Parameter is not legal");
				data.put("message", "error!");
				return data;
			}
			String[] itemIds=itemId.split(",");
			List<String> paramsList= new ArrayList<String>();
			for(int i=0;i<itemIds.length;i++){
			    //根据明细ID查询已选中的商品
				paramsList.add(itemIds[i]);
		    }
			if(orderItemsMapper.deleteCartByItemId(paramsList)>0){
				//删除对于的SKU信息
				orderItemSkuMapper.deleteSkuCodeByItemId(paramsList);
				orderItemSkuMapper.deleteNeckSkuCodeByItemId(paramsList);
				data.put("code", 100);
				data.put("data", "移除成功");
				data.put("message", "success");
				return data;
			}else{
				data.put("code", 200);
				data.put("data", "移除失败");
				data.put("message", "error");
				return data;
			}
		} catch (Exception e) {
			throw new  CustomException(404,"Network anomaly");
		}
    }
    
	/**
	 * 查询购物车数量
	 * @param userId
	 * @return
	 */
    public JSONObject queryCartNumber(HttpServletRequest request) throws CustomException{
    	JSONObject  data = new JSONObject();
    	String token = request.getHeader(jwtTokenUtil.tokenHeader);//获取前端传来的TOKEN
    	String userId = jwtTokenUtil.getIdFromToken(token);
		try {
			if(StringUtils.isEmpty(userId)){
				data.put("code", 403);
				data.put("data","userId is not legal");
				data.put("message", "error!");
				return data;
			}
	        Cart cond = new Cart();
	        cond.setOwnerId(userId);
	        cond.setStatus(true);
	        List<Cart> cartList = cartMapper.selectByCart(cond);
			if(cartList !=null && cartList.size()>0){
				cond=cartList.get(0);
				//删除对于的SKU信息
				List<OrderItems> list=orderItemsMapper.queryCartNumber(cond.getId());
				if(list !=null && list.size()>0){
					data.put("code", 100);
					data.put("data", list.size());
					data.put("message", "success");
					return data;
				}else{
					data.put("code", 100);
					data.put("data", 0);
					data.put("message", "success");
					return data;
				}
			}else{
				data.put("code", 100);
				data.put("data", 0);
				data.put("message", "error");
				return data;
			}
		} catch (Exception e) {
			throw new  CustomException(404,"Network anomaly");
		}
    }
    
    
	
	
}
