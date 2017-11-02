package com.wmeimob.yzfs.api.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wmeimob.yzfs.dao.GoodsMapper;
import com.wmeimob.yzfs.dao.GoodsShowMapper;
import com.wmeimob.yzfs.dao.UsersMapper;
import com.wmeimob.yzfs.exception.CustomException;
import com.wmeimob.yzfs.model.Goods;
import com.wmeimob.yzfs.model.GoodsShow;
import com.wmeimob.yzfs.model.OrderItem;
import com.wmeimob.yzfs.model.Thumbs;
import com.wmeimob.yzfs.model.User;
import com.wmeimob.yzfs.util.HttpUtil;
import com.wmeimob.yzfs.util.JwtTokenUtil;
import com.wmeimob.yzfs.weixin.CheckError;

@Service
@Transactional
public class GoodsShowServiceApi {

	@Autowired
	private JwtTokenUtil	jwtTokenUtil;

	@Autowired
	private GoodsShowMapper	goodsShowMapper;
	@Autowired
	GoodsMapper goodsMapper;
	@Autowired
	UsersMapper usersMapper;
	/**
	 * 买家秀列表
	 * 
	 * @param request
	 * @return
	 */
	public JSONObject getGoodsShowList(HttpServletRequest request) throws CustomException {
		JSONObject data = new JSONObject();
		String token = request.getHeader(jwtTokenUtil.tokenHeader);// 获取前端传来的TOKEN
		String userId = jwtTokenUtil.getIdFromToken(token);
		String xmlString = HttpUtil.requestGetBody(request);
//		Map<String, Object> maps = (Map<String, Object>) JSON.parse(xmlString);
		Integer queryType = Integer.parseInt(request.getParameter("type"));// 查询类型：1我的买家秀列表，0所有买家秀列表

		int pageIndex = 1;
		int pageSize = 20;
		if (StringUtils.isEmpty(request.getParameter("pageIndex") + "")) {
			pageIndex = 1;
		} else {
			pageIndex = Integer.parseInt(request.getParameter("pageIndex").toString());
		}
		if (StringUtils.isEmpty(request.getParameter("pageSize") + "")) {
			pageSize = 20;
		} else {
			pageSize = Integer.parseInt(request.getParameter("pageSize").toString());
		}
		try {
			GoodsShow params = new GoodsShow();
			if (pageIndex >= 1) {
				params.setPageIndex(pageIndex - 1);
			}
			params.setPageSize(pageIndex * pageSize);
			params.setUserId(userId);
			params.setQueryType(queryType);

			List<GoodsShow> goodsShowList = goodsShowMapper.queryShowListByParamsFromWX(params);
			data.put("code", CheckError.SUCCESS.value);
			data.put("data", goodsShowList);
			data.put("message", "success");
		} catch (Exception e) {
			throw new CustomException(CheckError.SYSTEM_ERROR.value, "SYSTEM IS ERROR");
		}
		return data;
	}
	/**
	 * 已完成订单列表（未发布买家秀的）
	 * 
	 * @param request
	 * @return
	 */
	public JSONObject getOrderItemList(HttpServletRequest request) throws CustomException {
		JSONObject data = new JSONObject();
		String token = request.getHeader(jwtTokenUtil.tokenHeader);// 获取前端传来的TOKEN
		String userId = jwtTokenUtil.getIdFromToken(token);
		String xmlString = HttpUtil.requestGetBody(request);
		Map<String, Object> maps = (Map<String, Object>) JSON.parse(xmlString);

		int pageIndex = 1;
		int pageSize = 20;
		if (StringUtils.isEmpty(request.getParameter("pageIndex") + "")) {
			pageIndex = 1;
		} else {
			pageIndex = Integer.parseInt(request.getParameter("pageIndex").toString());
		}
		if (StringUtils.isEmpty(request.getParameter("pageSize") + "")) {
			pageSize = 20;
		} else {
			pageSize = Integer.parseInt(request.getParameter("pageSize").toString());
		}
		try {
			OrderItem param = new OrderItem();
			if (pageIndex >= 1) {
				param.setPageIndex(pageIndex - 1);
			}
			param.setPageSize(pageIndex * pageSize);
			param.setUserId(userId);
			
			List<OrderItem> list = goodsShowMapper.queryOrderItemListByParamsFromWX(param);
			data.put("code", CheckError.SUCCESS.value);
			data.put("data", list);
			data.put("message", "success");
		} catch (Exception e) {
			throw new CustomException(CheckError.SYSTEM_ERROR.value, "SYSTEM IS ERROR");
		}
		return data;
	}
	/**
	 * 发布买家秀
	 * 
	 * @param request
	 * @return
	 */
	public JSONObject addGoodsShow(HttpServletRequest request) throws CustomException {
		JSONObject data = new JSONObject();
		String token = request.getHeader(jwtTokenUtil.tokenHeader);// 获取前端传来的TOKEN
		String userId = jwtTokenUtil.getIdFromToken(token);
		String xmlString = HttpUtil.requestGetBody(request);
		Map<String, Object> maps = (Map<String, Object>) JSON.parse(xmlString);
		String picKey = maps.get("picKey") + "";// 七牛图片key
		String templateId = maps.get("templateId") + "";// 模板id
		String goodsId = maps.get("goodsId") + "";// 商品id
		String orderItemId = maps.get("orderItemId") + "";// 订单明细id
		try{	
			GoodsShow params = new GoodsShow();
			params.setPicKey(picKey);// 图片的七牛key
			params.setShowTempleateId(templateId);// 买家秀模板 ID
			
			User pu = new User();
			pu.setId(userId);
			User ru = usersMapper.selectByPrimaryKey(pu);
			Goods rg = goodsMapper.selectByPrimaryKey(goodsId);
			params.setGoodId(goodsId);// 商品ID
			params.setGoodName(rg.getName());// 商品名称
			params.setUserId(userId);
			params.setOrderItemId(orderItemId);
			params.setNickName(ru.getNickName());
			params.setGoodsShowId(UUID.randomUUID().toString());// 表ID
			params.setThumbsCount(0);// 点赞次数

			params.setCreatedAt(new Date());
			params.setUpdatedAt(new Date());
			if(goodsShowMapper.insertSelective(params) > 0){
				data.put("code", CheckError.SUCCESS.value);
				data.put("data", "");
				data.put("message", "success");
			}else{
				data.put("code", CheckError.SYSTEM_ERROR.value);
				data.put("data", "");
				data.put("message", "error");
			}
			
		} catch (Exception e) {
			throw new CustomException(CheckError.SYSTEM_ERROR.value, "SYSTEM IS ERROR");
		}
		return data;
	}
	
	/**
	 * 查询买家秀详情
	 * 
	 * @param request
	 * @return
	 */
	public JSONObject getGoodsShowDetail(HttpServletRequest request) throws CustomException {
		JSONObject data = new JSONObject();
		String token = request.getHeader(jwtTokenUtil.tokenHeader);// 获取前端传来的TOKEN
		String userId = jwtTokenUtil.getIdFromToken(token);
		String xmlString = HttpUtil.requestGetBody(request);
		Map<String, Object> maps = (Map<String, Object>) JSON.parse(xmlString);
		String goodsShowId = request.getParameter("goodsShowId") + "";// 买家秀id
		try{
			GoodsShow param = new GoodsShow();
			param.setGoodsShowId(goodsShowId);
			param.setUserId(userId);
			GoodsShow goodsShow = goodsShowMapper.selectByPrimaryKey(param);
			data.put("code", CheckError.SUCCESS.value);
			data.put("data", goodsShow);
			data.put("message", "success");
		} catch (Exception e) {
			throw new CustomException(CheckError.SYSTEM_ERROR.value, "SYSTEM IS ERROR");
		}
		return data;
	}
	
	/**
	 * 买家秀点赞
	 * 
	 * @param request
	 * @return
	 */
	public JSONObject thumbsGoodsShow(HttpServletRequest request) throws CustomException {
		JSONObject data = new JSONObject();
		String token = request.getHeader(jwtTokenUtil.tokenHeader);// 获取前端传来的TOKEN
		String userId = jwtTokenUtil.getIdFromToken(token);
		String xmlString = HttpUtil.requestGetBody(request);
		Map<String, Object> maps = (Map<String, Object>) JSON.parse(xmlString);
		String goodsShowId = maps.get("goodsShowId") + "";// 买家秀id
		String type = maps.get("type") + "";// 1点赞0取消赞

		try {
			GoodsShow pgs = new GoodsShow();
			pgs.setGoodsShowId(goodsShowId);
			pgs.setUserId(userId);
			GoodsShow r = goodsShowMapper.selectByPrimaryKey(pgs);
			if (!StringUtils.isEmpty(type)) {
				GoodsShow p = new GoodsShow();
				p.setGoodsShowId(goodsShowId);
				
				Thumbs param = new Thumbs();
				param.setUserId(userId);
				param.setGoodsShowId(goodsShowId);
				Thumbs t = goodsShowMapper.selectThumbs(param);

				if (type.equals("1")) {// 赞
					if (r.getIsThumbs() == 1) {// 已经赞过了
						data.put("code", CheckError.SYSTEM_ERROR.value);
						data.put("data", "already thumbs!");
						data.put("message", "error");
						return data;
					}
					// 添加或修改一条赞的记录
					if (t != null) {
						t.setStatus(1);// 设置为赞
						goodsShowMapper.updateThumbsByPrimaryKeySelective(t);
					} else {
						Thumbs t2 = new Thumbs();
						t2.setGoodsShowId(goodsShowId);
						t2.setUserId(userId);
						t2.setCreatedAt(new Date());
						t2.setStatus(1);// 设置为赞
						t2.setId(UUID.randomUUID().toString());
						goodsShowMapper.insertSelectiveThumbs(t2);
					}
					// 增加赞次数
					p.setThumbsCount(r.getThumbsCount() + 1);
				} else {// 取消赞
					// 修改赞的记录为取消
					if (t != null) {
						t.setStatus(0);// 设置为取消赞
						goodsShowMapper.updateThumbsByPrimaryKeySelective(t);
					} else {
						Thumbs t2 = new Thumbs();
						t2.setGoodsShowId(goodsShowId);
						t2.setUserId(userId);
						t2.setCreatedAt(new Date());
						t2.setStatus(0);// 设置为取消赞
						t2.setId(UUID.randomUUID().toString());
						goodsShowMapper.insertSelectiveThumbs(t2);
					}
					// 减少赞次数
					p.setThumbsCount(r.getThumbsCount() - 1);
				}
				if (goodsShowMapper.updateByPrimaryKeySelective(p) < 0) {
					throw new CustomException(CheckError.SYSTEM_ERROR.value, "SYSTEM IS ERROR");
				}
			}
			GoodsShow param = new GoodsShow();
			param.setGoodsShowId(goodsShowId);
			param.setUserId(userId);
			GoodsShow goodsShow = goodsShowMapper.selectByPrimaryKey(param);
			Map<String ,Object> map = new HashMap<String, Object>();
			map.put("thumbsList", goodsShow.getThumbsList());
			map.put("thumbsCount", goodsShow.getThumbsCount());
			
			data.put("code", CheckError.SUCCESS.value);
			data.put("data", map);
			data.put("message", "success");
		} catch (Exception e) {
			throw new CustomException(CheckError.SYSTEM_ERROR.value, "SYSTEM IS ERROR");
		}
		return data;
	}
	
	
}
