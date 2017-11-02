package com.wmeimob.yzfs.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wmeimob.yzfs.model.ReadingRewards;
import com.wmeimob.yzfs.model.ReadingRewardsRecord;
import com.wmeimob.yzfs.service.ReadingRewardsService;
import com.wmeimob.yzfs.vo.ReadingRewardsRecordVO;
import com.wmeimob.yzfs.vo.ReadingRewardsVO;



/**
 * 阅读文章Controller
 */
@Controller
@RequestMapping("/admin/read")
public class ReadingRewardsController{


	@Autowired
	private ReadingRewardsService readingRewardsService;
	
	/**
	 * 查询阅读任务页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("read/read_list");
		ReadingRewards record = new ReadingRewards();
		record=getQueryReadPublicParamsByReq(request);
		List<ReadingRewardsVO> readList=readingRewardsService.queryReadingRewardsListByParams(record);
		mv.addObject("readList", readList);
		mv.addObject("params", record);
		return mv;
	}
	
	/**
	 * 查询阅读任务共有参数
	 * @param request
	 * @return
	 */
	public ReadingRewards getQueryReadPublicParamsByReq(HttpServletRequest request){
		ReadingRewards params= new ReadingRewards();
		String startTime=request.getParameter("startTime");//开始时间
		String endTime =request.getParameter("endTime");//结束时间
		String title=request.getParameter("paramTitle");//文章标题
		if(StringUtils.isEmpty(title))
		    params.setTitle(null);
		else
			params.setTitle(title);
		if(StringUtils.isEmpty(startTime))
		    params.setStartTime(null);
		else
			params.setStartTime(startTime);
		if(StringUtils.isEmpty(endTime))
		    params.setEndTime(null);
		else
			params.setEndTime(endTime);
		return params;
	}
	
	/**
	 * 编辑新增阅读任务信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/edit")
	@ResponseBody
	public Map<String, Object> edit(HttpServletRequest request) {
		Map<String, Object> resultVo=new HashMap<String, Object>();
		resultVo=readingRewardsService.editAndSaveReadingRewardsInfo(request);
		return resultVo;
	}
	
	/**
	 * 启用关闭或者删除
	 * @param request
	 * @return
	 */
	@RequestMapping("/isUse")
	@ResponseBody
	public Map<String, Object> isUse(HttpServletRequest request,String id,Boolean isUse,Boolean isDeleted) {
		Map<String, Object> resultVo=new HashMap<String, Object>();
		resultVo=readingRewardsService.isUse(id, isUse, isDeleted);
		return resultVo;
	}
	
	/**
	 * 查询阅读记录页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/recordList")
	public ModelAndView recordList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("read/read_record_list");
		ReadingRewardsRecord record =new ReadingRewardsRecord();
		record=getQueryReadingRecordPublicParamsByReq(request);
		List<ReadingRewardsRecordVO> recordList=readingRewardsService.queryReadingRewardsRecordListByParams(record);
		mv.addObject("recordList", recordList);
		mv.addObject("params", record);
		return mv;
	}
	
	/**
	 * 查询阅读记录共有参数
	 * @param request
	 * @return
	 */
	public ReadingRewardsRecord getQueryReadingRecordPublicParamsByReq(HttpServletRequest request){
		ReadingRewardsRecord params= new ReadingRewardsRecord();
		String title=request.getParameter("paramTitle");//文章标题
		String startTime=request.getParameter("startTime");//开始时间
		String endTime =request.getParameter("endTime");//结束时间
		String nickName=request.getParameter("nickName");//昵称
		if(StringUtils.isEmpty(title))
		    params.setTitle(null);
		else
			params.setTitle(title);
		if(StringUtils.isEmpty(startTime))
		    params.setStartTime(null);
		else
			params.setStartTime(startTime);
		if(StringUtils.isEmpty(endTime))
		    params.setEndTime(null);
		else
			params.setEndTime(endTime);
		if(StringUtils.isEmpty(nickName))
		    params.setNickName(null);
		else
			params.setNickName(nickName);
		
		return params;
	}
	

}
