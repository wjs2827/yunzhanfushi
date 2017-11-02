package com.wmeimob.yzfs.service.impl;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.wmeimob.yzfs.dao.ReadingRewardsMapper;
import com.wmeimob.yzfs.model.ReadingRewards;
import com.wmeimob.yzfs.model.ReadingRewardsRecord;
import com.wmeimob.yzfs.service.ReadingRewardsService;
import com.wmeimob.yzfs.util.CheckUtils;
import com.wmeimob.yzfs.util.UUIDUtil;
import com.wmeimob.yzfs.vo.ReadingRewardsRecordVO;
import com.wmeimob.yzfs.vo.ReadingRewardsVO;

/**
 * 阅读文章实现类
 */
@Service
public class ReadingRewardsServiceImpl implements ReadingRewardsService {
	
	 @Autowired
	 private  ReadingRewardsMapper readingRewardsMapper;

	/**
	 * 编辑新增阅读任务信息
	 * @param record
	 * @return
	 */
	@Override
	public Map<String,Object> editAndSaveReadingRewardsInfo(HttpServletRequest request) {
		Map<String,Object> resultVo =new HashMap<String,Object>();
		ReadingRewards record=new ReadingRewards();
		record=getPublicParamsByReq(request);
		if(StringUtils.isEmpty(record.getTitle())){
			resultVo.put("code", "200");
			resultVo.put("msg", "文章标题不能为空!");
			return resultVo;
		}
		if(!StringUtils.isEmpty(record.getTitle())){
/*			if(!CheckUtils.IsSpecial(record.getTitle())){
				resultVo.put("code", "200");
				resultVo.put("msg", "文章标题含有非法特殊字符!");
				return resultVo;
			}*/
		}
		if(StringUtils.isEmpty(record.getLink())){
			resultVo.put("code", "200");
			resultVo.put("msg", "文章链接不能为空!");
			return resultVo;
		}
		if(!StringUtils.isEmpty(record.getLink())){
			if(!CheckUtils.IsUrl(record.getLink())){
				resultVo.put("code", "200");
				resultVo.put("msg", "文章链接不合法!（示例http://www.baidu.com）");
				return resultVo;
			}
		}
		if(StringUtils.isEmpty(record.getId())){
			record.setId(UUIDUtil.generateUUID());
			record.setIsUse(false);//未启用
			record.setIsDeleted(true);
			record.setCreatedAt(new Date());
			record.setUpdatedAt(new Date());
			if(readingRewardsMapper.insertSelective(record)>0){
				resultVo.put("code", "100");
				resultVo.put("msg", "新增成功!加载中...");
			}else{
				resultVo.put("code", "100");
				resultVo.put("msg", "新增失败!");
			}
	    }else{
	    	record.setUpdatedAt(new Date());
			if(readingRewardsMapper.updateByPrimaryKeySelective(record)>0){
				resultVo.put("code", "100");
				resultVo.put("msg", "编辑成功!加载中...");
			}else{
				resultVo.put("code", "100");
				resultVo.put("msg", "编辑失败!");
			}
	    }
		return resultVo;
	}
	
	/**
	 * 编辑阅读文章共有参数
	 * @param request
	 * @return
	 */
	public ReadingRewards getPublicParamsByReq(HttpServletRequest request){
		ReadingRewards params= new ReadingRewards();
		String id=request.getParameter("id");//文章ID
		String title=request.getParameter("title");//文章标题
		String link=request.getParameter("link");//文章链接
		params.setId(id);
		params.setTitle(title);
		params.setLink(link);
		return params;
	}
	
	/**
	 * 删除或者启用关闭阅读任务
	 * @param record
	 * @return
	 */
	@Override
	public Map<String,Object> isUse(String id,Boolean isUse,Boolean  isDeleted) {
		Map<String,Object> resultVo =new HashMap<String,Object>();
		ReadingRewards record=new ReadingRewards();
		record.setId(id);
		record.setIsUse(isUse);
		record.setIsDeleted(isDeleted);
    	record.setUpdatedAt(new Date());
		if(readingRewardsMapper.updateByPrimaryKeySelective(record)>0){
			resultVo.put("code", "100");
			resultVo.put("msg", "操作成功!");
		}else{
			resultVo.put("code", "100");
			resultVo.put("msg", "操作失败!");
		}
		return resultVo;
	}

	/**
	 * 根据参数查询单个阅读任务信息
	 */
	@Override
	public ReadingRewardsVO queryReadingRewardsByParams(ReadingRewards record) {
		return readingRewardsMapper.queryReadingRewardsByParams(record);
	}

	/**
	 * 根据参数查询阅读任务列表信息
	 */
	@Override
	public List<ReadingRewardsVO> queryReadingRewardsListByParams(ReadingRewards record) {
		return readingRewardsMapper.queryReadingRewardsListByParams(record);
	}
	
	/**
	 * 根据参数查询多条阅读记录信息
	 * @param request
	 * @return
	 */
	@Override
	public List<ReadingRewardsRecordVO> queryReadingRewardsRecordListByParams(ReadingRewardsRecord record ) {
		return readingRewardsMapper.queryReadingRewardsRecordListByParams(record);
	}
	


	
}
