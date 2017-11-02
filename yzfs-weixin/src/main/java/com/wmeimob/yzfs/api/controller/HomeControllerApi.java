package com.wmeimob.yzfs.api.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.wmeimob.yzfs.api.service.HomeServiceApi;
import com.wmeimob.yzfs.model.GoodsComment;
import com.wmeimob.yzfs.vo.GoodsCommentVO;
import com.wmeimob.yzfs.vo.HomeCategoryVO;
import com.wmeimob.yzfs.vo.SilderPicVO;

@Controller
@RequestMapping("/home/api")
@CrossOrigin
public class HomeControllerApi {

    @Autowired
    private HomeServiceApi homeServiceApi;
	
	
	/**
	 * 查询首页轮播图
	 * @return
	 */
	@RequestMapping(value = "/homeSilderList", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject homeSilderList(HttpServletRequest request) {
		JSONObject  data = new JSONObject();
		int code=404;
		try {
			List<SilderPicVO> silderList = homeServiceApi.querySilderListFromWX(request);
			if (silderList != null && silderList.size() > 0) {
				code = 100;
				data.put("data", silderList);
				data.put("message", "success");
			} else {
				code = 200;
				data.put("data", null);
				data.put("message", "empty");
			} 
		} catch (Exception e) {
		    data.put("data", "");
		    data.put("message", e.getMessage());
		}
		data.put("code", code);
		return data;
	}
	
	/**
	 * 查询首页分类以及商品详情列表
	 * @return
	 */
	@RequestMapping(value = "/homeCategoryList", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject homeCategoryList(HttpServletRequest request) {
		JSONObject  data = new JSONObject();
		List<HomeCategoryVO> homeCategoryList=homeServiceApi.selectHomeCategory();
		int code=404;
		try {
			if (homeCategoryList != null && homeCategoryList.size() > 0) {
				code = 100;
				data.put("data", homeCategoryList);
				data.put("message", "success");
			}else{
				code = 200;
				data.put("code", null);
				data.put("message", "empty");
			} 
		}catch (Exception e){
		    data.put("data", "");
		    data.put("message", e.getMessage());
		}
		data.put("code", code);
		return data;
	}
	
	/**
	 * 首页查询精彩评论
	 * @return
	 */
	@RequestMapping(value = "/homeCommentList", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject homeCommentList(HttpServletRequest request) {
		JSONObject  data = new JSONObject();
		GoodsComment params = new GoodsComment();
		params.setIsWonderful(true);
        int code=404;
		try {
			List<GoodsCommentVO> commentList = homeServiceApi.queryCommentsInfo(params);
			
			if (commentList != null && commentList.size() > 0) {
				code = 100;
				data.put("data", commentList);
				data.put("message", "success");
			} else {
				code = 200;
				data.put("data", null);
				data.put("message", "empty");
			} 
		} catch (Exception e) {
		    data.put("data", "");
		    data.put("message", e.getMessage());
		}
		data.put("code", code);
		return data;
	}
	
	/**
	 * 商品详情评论
	 * @return
	 */
	@RequestMapping(value = "/goodCommentById", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject homeCommentList(HttpServletRequest request,String id) {
		JSONObject  data = new JSONObject();
		GoodsComment params = new GoodsComment();
		int code=404;
		try {
			if (!StringUtils.isEmpty(id)) {
				params.setGoodId(id);
				List<GoodsCommentVO> commentList = homeServiceApi.queryCommentsInfo(params);
				if (commentList != null && commentList.size() > 0) {
					code = 100;
					data.put("data", commentList);
					data.put("message", "success");
				} else {
					code = 200;
					data.put("data", null);
					data.put("message", "empty");
				}
			} else {
				code = 404;
				data.put("data", "data is null");
				data.put("message", "Parameter is not legal");
			} 
		}catch (Exception e) {
		    data.put("data", "");
		    data.put("message", e.getMessage());
		}
		data.put("code", code);
		return data;
	}
	
	
	
	
}
