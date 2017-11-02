package com.wmeimob.yzfs.service.impl;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.wmeimob.yzfs.dao.EcGoodSkuMapper;
import com.wmeimob.yzfs.dao.EcNeckSkuMapper;
import com.wmeimob.yzfs.dao.GoodsMapper;
import com.wmeimob.yzfs.dao.GoodsPicsMapper;
import com.wmeimob.yzfs.exception.CustomException;
import com.wmeimob.yzfs.model.EcGoodSku;
import com.wmeimob.yzfs.model.EcNeckSku;
import com.wmeimob.yzfs.model.Goods;
import com.wmeimob.yzfs.model.GoodsPics;
import com.wmeimob.yzfs.service.GoodsService;
import com.wmeimob.yzfs.util.CheckUtils;
import com.wmeimob.yzfs.vo.GoodsVO;
import com.wmeimob.yzfs.vo.ResultVO;

/**
 * 商品管理
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class GoodsServiceImpl implements GoodsService {
	
	
	@Autowired
	private GoodsMapper goodsMapper;
	@Autowired
	private GoodsPicsMapper picsMapper;
	@Autowired
	private EcNeckSkuMapper ecNeckSkuMapper;
	@Autowired
	private EcGoodSkuMapper ecGoodSkuMapper;
	
	
	/**
	 * 查询商品列表标准化
	 * @return
	 */
	@Override
	public List<GoodsVO> queryGoodsList(Goods goods) {
		List<GoodsVO> GoodsVOs = goodsMapper.queryGoodsList(goods);
		return GoodsVOs;
	}

	/**
	 * 编辑或者新增商品信息
	 */
	@Override
	public Map<String,Object> operateGoods(Goods goods,HttpServletRequest request) throws CustomException{
		String msg="新增失败";
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			//获取商品基本信息方法
			result = getGoodsInfoByParams(goods);
			boolean isTrue = false;
			if ("spuSuccess".equals(result.get("code"))) {
				//校验是否可改装
				if (goods.getSpuType()) {
					for (int n = 0; n < goods.getNeckLength(); n++) {
						if (!CheckUtils.IsIntDoubleInteger(request.getParameter("neck_price" + n))) {
							result.put("code", 200);
							result.put("msg", "最多只保留小数点后2位的正数!");
							result.put("sign", "neck_price" + n);
							result.put("error", "errorTitle" + n);
							return result;
						}
					}
				}
				//校验是否多规格
				if (goods.getIsUnifiedSpecs()) {
					for (int n = 0; n < goods.getSkuLength(); n++) {
						if (!CheckUtils.IsIntDoubleInteger(request.getParameter("sku_price" + n))) {
							result.put("code", 200);
							result.put("msg", "最多只保留小数点后2位的正数!");
							result.put("sign", "sku_price" + n);
							result.put("error", "skuErrorTitle" + n);
							return result;
						}
//						if (!CheckUtils.IsIntDoubleInteger(request.getParameter("sku_market" + n))) {
//							result.put("code", 200);
//							result.put("msg", "最多只保留小数点后2位的正数!");
//							result.put("sign", "sku_market" + n);
//							result.put("error", "skuMarketTitle" + n);
//							return result;
//						}
						if (!CheckUtils.isPositiveInteger(request.getParameter("sku_stock" + n))) {
							result.put("code", 200);
							result.put("msg", "必须为大于0正整数!");
							result.put("sign", "sku_stock" + n);
							result.put("error", "skuStockTitle" + n);
							return result;
						}
					}
				} else {
					if (!CheckUtils.IsIntDoubleInteger(request.getParameter("sku_price"))) {
						result.put("code", 200);
						result.put("msg", "最多只保留小数点后2位的正数!");
						result.put("sign", "sku_price");
						result.put("error", "skuErrorTitle");
						return result;
					}
//					if (!CheckUtils.IsIntDoubleInteger(request.getParameter("sku_market"))) {
//						result.put("code", 200);
//						result.put("msg", "最多只保留小数点后2位的正数!");
//						result.put("sign", "sku_market");
//						result.put("error", "skuMarketTitle");
//						return result;
//					}
					if (!CheckUtils.isPositiveInteger(request.getParameter("sku_stock"))) {
						result.put("code", 200);
						result.put("msg", "必须为大于0正整数!");
						result.put("sign", "sku_stock");
						result.put("error", "skuStockTitle");
						return result;
					}

				}
				//如果商品ID为空则为新增商品，否则编辑商品
				if (StringUtils.isEmpty(goods) || StringUtils.isEmpty(goods.getId())) {
					//商品ID
					goods.setId(UUID.randomUUID().toString());
					goods.setCreatedAt(new Date());
					goods.setUpdatedAt(new Date());
					if (goodsMapper.insertSelective(goods) > 0) {
						isTrue = true;
						msg = "新增成功";
					}
				} else {
					goods.setUpdatedAt(new Date());
					if (goodsMapper.updateByPrimaryKeySelective(goods) > 0) {
						isTrue = true;
						msg = "编辑成功";
					}
				}
			}
			if (isTrue) {
				/*##########商品图片开始##########*/
				//删除原始图片数据
				picsMapper.deleteByGoodsId(goods.getId());
				//新增图片信息
				List<GoodsPics> picList = saveGoodsPic(goods);
				if (picList != null && picList.size() > 0) {
					if (picsMapper.insertBatch(picList) <= 0) {
						throw new CustomException(200, msg);
					}
				}
				/*##########商品图片结束##########*/
				/*##########商品可改装SKU开始##########*/
				if (goods.getSpuType()) {
					List<EcNeckSku> paramsNeckSku = saveGoodsNeckSku(goods, request);
					//删除原始SKU数据
					ecNeckSkuMapper.deleteByPrimaryKey(goods.getId());
					if (paramsNeckSku != null && paramsNeckSku.size() > 0) {
						//新增该属性
						if (ecNeckSkuMapper.insertBatch(paramsNeckSku) <= 0) {
							throw new CustomException(200, msg);
						}
					}
				}
				/*##########商品可改装SKU结束##########*/

				/*##########商品SKU开始##########*/
				//多规格
				EcGoodSku  skuItem = null;
				if (goods.getIsUnifiedSpecs()) {
					List<EcGoodSku> paramsGoodsSku = saveGoodsSku(goods, request);
					if (StringUtils.isEmpty(goods) || StringUtils.isEmpty(goods.getId())) {
						//验证该SKU是否存在， 如果存在，则编辑，不存在，则新增
						if (paramsGoodsSku != null && paramsGoodsSku.size() > 0) {
							//新增该属性
							if (ecGoodSkuMapper.insertBatch(paramsGoodsSku) <= 0) {
								throw new CustomException(200, msg);
							}
						}
					}else{
						for(EcGoodSku sku:paramsGoodsSku){
							skuItem = new EcGoodSku();
							skuItem=ecGoodSkuMapper.queryGoodSkuBySkuCode(sku.getSkuCode(),goods.getId());
							//编辑SKU
						    if(skuItem!=null && !StringUtils.isEmpty(skuItem.getId())){
						    	skuItem.setUpdatedAt(new Date());
						    	skuItem.setMarketPrice(sku.getMarketPrice());
						    	skuItem.setPicKey(sku.getPicKey());
						    	skuItem.setPrice(sku.getPrice());
						    	skuItem.setStockCount(sku.getStockCount()+skuItem.getLockCount()+skuItem.getSaleCount());
						    	ecGoodSkuMapper.updateByPrimaryKeySelective(skuItem);
						    }else{
								//删除原始SKU数据
								ecGoodSkuMapper.deleteByPrimaryKey(goods.getId());
								if (paramsGoodsSku != null && paramsGoodsSku.size() > 0) {
									//新增该属性
									if (ecGoodSkuMapper.insertBatch(paramsGoodsSku) <= 0) {
										throw new CustomException(200, msg);
									}
								}
						    }

						}
					}
				}else {
					//统一规格
					EcGoodSku specSku = new EcGoodSku();
					specSku.setSpuId(goods.getId());
					specSku.setSpuCode(goods.getSpuCode());
					specSku.setSkuCode(goods.getSpuCode());
					specSku.setSkuName("");
					specSku.setPrice(new BigDecimal(request.getParameter("sku_price")));
					specSku.setMarketPrice(new BigDecimal(request.getParameter("sku_market")));
					specSku.setStockCount(Integer.parseInt(request.getParameter("sku_stock")));
					specSku.setPicKey(goods.getSpuKeysValue());
					specSku.setIsUsed(true);
					specSku.setStatus(true);
					skuItem=ecGoodSkuMapper.queryGoodSkuBySkuCode(goods.getSkuCode(),goods.getId());
				    if(skuItem !=null &&!StringUtils.isEmpty(skuItem.getId())){
				    	specSku.setId(skuItem.getId());
				    	skuItem.setStockCount(specSku.getStockCount()+skuItem.getLockCount()+skuItem.getSaleCount());
				    	specSku.setUpdatedAt(new Date());
				    	ecGoodSkuMapper.updateByPrimaryKeySelective(specSku);
				    }else{
						//删除原始SKU数据
						ecGoodSkuMapper.deleteByPrimaryKey(goods.getId());
						specSku.setLockCount(0);
						specSku.setSaleCount(0);
				    	specSku.setCreatedAt(new Date());
				    	ecGoodSkuMapper.insertSelective(specSku);
				    }
				}
				/*##########商品SKU结束##########*/
				result.put("code", 100);
				result.put("msg", msg);
			}
		} catch (Exception e) {
			System.out.println("################"+e.getMessage());
			result.put("code", 300);
			result.put("msg", "系统异常");
		}
		return result;
	}
	
	/**
	 * 根据参数获取商品基本信息
	 * @param goodsInfoVo
	 * @param
	 * @return
	 */
	public Map<String,Object> getGoodsInfoByParams(final Goods goods){
		Map<String,Object>  result=new HashMap<String, Object>();
		//商品排序
		if(StringUtils.isEmpty(goods.getRank())){
			goods.setRank(0);
		}
		//验证商品编码
		if(StringUtils.isEmpty(goods.getSpuCode())){
			result.put("code", 200);
			result.put("msg", "商品编码不能为空!");
			result.put("sign", "spuCode");
			result.put("error", "spuCodeError");
			return result;
		}else{
			List<GoodsVO> list=goodsMapper.queryGoodsListBySpuCodeVerifyExist(goods);
			if(list!=null && list.size()>0){
				result.put("code", 200);
				result.put("msg", "商品编码已经存在!");
				result.put("sign", "spuCode");
				result.put("error", "spuCodeError");
				return result;
			}
		}
		goods.setClassesId(goods.getClassesId());
		//商品名称
		if(StringUtils.isEmpty(goods.getName())){
			result.put("code", 200);
			result.put("msg", "商品名称不能为空!");
			result.put("sign", "name");
			result.put("error", "goodNameError");
			return result;
		}
		//商品状态false删除 true正常
		goods.setStatus(true);
		result.put("code", "spuSuccess");
		return result;
	}

	
	
	/**
	 * 保存可改装SKU数据
	 * @param goodsInfoVo
	 * @param goods
	 * @param
	 * @return
	 */
	public List<EcNeckSku> saveGoodsNeckSku(Goods goods,HttpServletRequest request){
		List<EcNeckSku> neckSkuParams=new ArrayList<EcNeckSku>();
			try {
				//可改装SKU属性
				if (goods.getSpuType()) {
					//SKU属性动态值
					for (int n = 0; n < goods.getNeckLength(); n++) {
						EcNeckSku neckSku = new EcNeckSku();
						neckSku.setSpuId(goods.getId());//商品ID
						neckSku.setSpuCode(goods.getSpuCode());//商品编码
						String skuCode="";
						String neckId = "";//领口ID或者布料ID
						String neckName = "";//领口名称或者布料ID
						neckSku.setSkuName("");
						//根据动态列的长度获取SKU动态值
						for (int t = 0; t < goods.getNeckTitleLength(); t++) {
							neckId = request.getParameter("neck" + t + "key" + n)+"_";
							neckName = request.getParameter("neck" + t + "val" + n);
							skuCode=skuCode+neckId;
							neckSku.setSkuName(neckSku.getSkuName().concat(neckName));
							//如果不等于1 则最后以为拼接不会拼接-
							if (goods.getNeckTitleLength() - t != 1) {
								//SKU组合名称 例如：Iphone+玫瑰金+164G
								neckSku.setSkuName(neckSku.getSkuName().concat("+"));
							}
						}
						String skuCodes=skuCode.substring(0,skuCode.length()-1);
						neckSku.setSkuCode(skuCodes);
						//SKU价格
						neckSku.setSalePrice(new BigDecimal(request.getParameter("neck_price" + n)));
						//SKU衣服布料KEY
						neckSku.setPicKey(request.getParameter("neckimg-keys" + n));
						//创建时间
						neckSku.setCreatedAt(new Date());
						//修改时间
						neckSku.setUpdatedAt(new Date());
						neckSku.setStatus(true);
						neckSkuParams.add(neckSku);
					}
				} 
			} catch (Exception e) {
				e.getMessage();
			}
			return neckSkuParams;
	}
	
	
	/**
	 * 保存商品SKU数据
	 * @param goodsInfoVo
	 * @param goods
	 * @param
	 * @return
	 */
	public List<EcGoodSku> saveGoodsSku(Goods goods,HttpServletRequest request){
		List<EcGoodSku> neckSkuParams=new ArrayList<EcGoodSku>();
			try {
				//可改装SKU属性
				if (goods.getIsUnifiedSpecs()) {
					for (int n = 0; n < goods.getSkuLength(); n++) {
						EcGoodSku neckSku = new EcGoodSku();
						neckSku.setSpuId(goods.getId());//商品ID
						neckSku.setSpuCode(goods.getSpuCode());//商品编码
						String skuCode = "";//领口ID或者布料ID
						String neckId = "";//领口ID或者布料ID
						String neckName = "";//领口名称或者布料ID
						neckSku.setSkuName("");
						//根据动态列的长度获取SKU动态值
						for (int t = 0; t < goods.getSkuTitleLength(); t++) {
							String skuTitleId=request.getParameter("skuTitleVal"+t)+"_";
							neckId = request.getParameter("sku"+t+"key"+n)+"_";
							skuCode=skuCode+skuTitleId+neckId;
							neckName = request.getParameter("sku"+t+"val"+n);
							neckSku.setSkuName(neckSku.getSkuName().concat(neckName));
							//如果不等于1 则最后以为拼接不会拼接-
							if (goods.getSkuTitleLength() - t != 1) {
								//SKU组合名称 例如：Iphone+玫瑰金+164G
								neckSku.setSkuName(neckSku.getSkuName().concat("+"));
							}
						}
						String skuCodes=skuCode.substring(0,skuCode.length()-1);
						neckSku.setSkuCode(skuCodes);
						//SKU规格图片KEY
						neckSku.setPicKey(request.getParameter("skuImg-keys" + n));
						//SKU价格
						neckSku.setPrice(new BigDecimal(request.getParameter("sku_price" + n)));
						//SKU市场价
						neckSku.setMarketPrice(new BigDecimal(request.getParameter("sku_market" + n)));
						//SKU库存
						neckSku.setStockCount(Integer.parseInt(request.getParameter("sku_stock" + n)));
						//创建时间
						neckSku.setCreatedAt(new Date());
						//修改时间
						neckSku.setUpdatedAt(new Date());
						neckSku.setStatus(true);
						neckSkuParams.add(neckSku);
					}
				} 
			} catch (Exception e) {
				e.getMessage();
			}
			return neckSkuParams;
	}
	
	
	/**
	 * 图片参数处理
	 * @param goodsInfoVo
	 * @param goods
	 * @param
	 * @return
	 */
	public List<GoodsPics> saveGoodsPic(Goods goods){
		List<GoodsPics> picList = new ArrayList<GoodsPics>();
		if(!StringUtils.isEmpty(goods.getGoodsPicses())){
			for (int i=0;i<goods.getGoodsPicses().size();i++) {
				GoodsPics pics = new GoodsPics();
				pics=goods.getGoodsPicses().get(i);
				if (!StringUtils.isEmpty(pics.getPicKey())&&!pics.getPicKey().equals("")) {
					pics.setId(UUID.randomUUID().toString());
					pics.setGoodId(goods.getId());
					pics.setPicKey(pics.getPicKey());
					pics.setRank(i);
					pics.setCreatedAt(new Date());
					picList.add(pics);
				}		
			}
		}
		return picList;
	}
	
	
	
	/**
	 * 根据一级或者二级分类查询所有的商品
	 * @param classId
	 * @param type
	 * @return
	 */
	@Override
	public List<Goods> selectGoodListByCategoryId(String classId,String type) {
		GoodsVO params= new GoodsVO();
		if(!StringUtils.isEmpty(type)&& "1".equals(type))
			params.setParentId(classId);
		else
			params.setClassesId(classId);
		return goodsMapper.selectGoodListByCategoryId(params);
	}

	/**
	 *  验证商品编码是否存在
	 */
	@Override
	public Map<String,Object> queryGoodsListBySpuCodeVerifyExist(Goods goods) {
		Map<String,Object> map = new HashMap<String, Object>();
		List<GoodsVO> list=goodsMapper.queryGoodsListBySpuCodeVerifyExist(goods);
		if(list !=null && list.size()>0){
			map.put("code", 200);
			map.put("msg", "亲!商品编码已存在!");
		}else{
			map.put("code", 100);
		}
		return map;
	}
	
	
	/**
	 * 根据商品ID查询商品信息
	 * 
	 * @param goods
	 * @return
	 */
	@Override
	public GoodsVO queryGoodById(Goods goods){
		return goodsMapper.queryGoodById(goods);
	}

	/**
	 * 根据分类ID查询商品
	 */
	@Override
	public List<Goods> listGoods(String classId) {
		return goodsMapper.selectByShopId(classId);
	}

	/**
	 * 根据商品ID查询商品对应的SKU列表信息
	 */
	@Override
	public Map<String, Object> queryGoodSkuListBySpuId(String spuId) {
		List<EcGoodSku> skuList=ecGoodSkuMapper.selectByPrimaryKey(spuId);
		//解析JSON数据
		//获取标题MAP集合
		return JSONInfoTOSKU(skuList);
	}
	
	/**
	 * 根据商品ID查询商品对应的统一规格SKU信息
	 */
	@Override
	public EcGoodSku queryGoodSkuBySpuId(String spuId) {
		List<EcGoodSku> skuList=ecGoodSkuMapper.selectByPrimaryKey(spuId);
		if(skuList!=null && skuList.size()>0)
			return skuList.get(0);
		return null;
	}
	
	/**
	 * JSON转换成列表
	 * @return
	 */
	public  Map<String, Object> JSONInfoTOSKU(List<EcGoodSku> skuList){
		Map<String, Object> mapTitle = new HashMap<String,Object>();
		List<Map<String, Object>> mapItemValueList = new ArrayList<Map<String,Object>>();
		try {
			Map<String, Object> mapItemValue = null;
			for(EcGoodSku sku:skuList){
				if(!StringUtils.isEmpty(sku.getSkuCode())){
					System.out.println(sku.getSkuCode());
					String[] arraySku=sku.getSkuCode().split("_");
					for(int i=0;i<arraySku.length;i++)
					{
						mapItemValue = new HashMap<String, Object>();
						int idx=0;
						if(mapItemValueList!=null && mapItemValueList.size()>0){
							for(Map<String, Object> map:mapItemValueList){
								if(map.containsValue(arraySku[i])){
									idx++;
								}
							}
							if(idx==0){
								mapItemValue.put("key",arraySku[i]);
							}else{
								mapItemValue.put("key","empty");
							}
						}else{
							mapItemValue.put("key", arraySku[i]);
						}
						if(!mapItemValue.get("key").equals("empty")){
							mapItemValueList.add(mapItemValue);
						}
					}
				}
			}
			mapTitle.put("skuValueList", mapItemValueList);
			mapTitle.put("skuList", skuList);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return mapTitle;
	}

	/**
	 * 根据商品ID删除商品信息
	 */
	@Override
	public ResultVO deleteGoodById(String spuId) throws CustomException{
		ResultVO rs = new ResultVO();
		try {
			if (StringUtils.isEmpty(spuId)) {
				rs.setCode(200);
				rs.setMessage("商品参数不合法!");
				return rs;
			}
			Goods params = new Goods();
			params.setId(spuId);
			params.setUpdatedAt(new Date());
			params.setIsSale(false);
			params.setStatus(false);
			//删除商品
			if (goodsMapper.updateIsSale(params) > 0) {
				//删除商品图片
				//删除原始图片数据
				picsMapper.deleteByGoodsId(spuId);
				//删除商品SKU
				//删除原始SKU数据
				ecNeckSkuMapper.deleteByPrimaryKey(spuId);
				ecGoodSkuMapper.deleteByPrimaryKey(spuId);
				rs.setCode(100);
				rs.setMessage("删除成功");
				return rs;
			} else {
				rs.setCode(200);
				rs.setMessage("删除失败");
				return rs;
			} 
		} catch (Exception e) {
			throw new CustomException(200,"删除失败");
		}
	}

	@Override
	public boolean updateIsSale(Goods goods) throws CustomException {
		return goodsMapper.updateIsSale(goods) > 0;
	}

}
