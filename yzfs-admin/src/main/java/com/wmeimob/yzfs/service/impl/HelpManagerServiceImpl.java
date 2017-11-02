package com.wmeimob.yzfs.service.impl;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import com.wmeimob.yzfs.dao.HelpManagerMapper;
import com.wmeimob.yzfs.exception.CustomException;
import com.wmeimob.yzfs.model.HelpManager;
import com.wmeimob.yzfs.service.HelpManagerService;
import com.wmeimob.yzfs.util.UUIDUtil;
import com.wmeimob.yzfs.vo.HelpManagerVO;

/**
 *
 * @Date 2016/7/27 11:23
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class HelpManagerServiceImpl implements HelpManagerService {
	
	
	@Autowired
	private HelpManagerMapper  helpManagerMapper;
	
	
	/**
	 * 查询帮助推广页信息
	 * @return
	 */
	@Override
	public HelpManagerVO queryHelpList(HelpManager params) {
		HelpManagerVO helpManager = helpManagerMapper.queryHelpList(params);
		return helpManager;
	}

	/**
	 * 编辑新增帮助推广页信息
	 * @param record
	 * @return
	 */
	@Override
	public Map<String,Object> editAndSaveHelpManagerInfo(HttpServletRequest request) throws CustomException{
		Map<String,Object> resultVo =new HashMap<String,Object>();
		HelpManager record= new HelpManager();
		try {
			record = getPublicParamsByReq(request);
			if (StringUtils.isEmpty(record.getTitle())) {
				resultVo.put("code", "200");
				resultVo.put("msg", "标题不能为空!");
				return resultVo;
			}
			if (StringUtils.isEmpty(record.getContent())) {
				resultVo.put("code", "200");
				resultVo.put("msg", "内容不能为空!");
				return resultVo;
			}
			if (StringUtils.isEmpty(record.getId())) {
				record.setId(UUIDUtil.generateUUID());
				record.setCreatedAt(new Date());
				record.setUpdatedAt(new Date());
				record.setStatus(true);
				if (helpManagerMapper.insertSelective(record) > 0) {
					resultVo.put("code", "100");
					resultVo.put("msg", "新增成功!");
				} else {
					resultVo.put("code", "100");
					resultVo.put("msg", "新增失败!");
				}
			} else {
				record.setUpdatedAt(new Date());
				if (helpManagerMapper.updateByPrimaryKeySelective(record) > 0) {
					resultVo.put("code", "100");
					resultVo.put("msg", "编辑成功!");
				} else {
					resultVo.put("code", "100");
					resultVo.put("msg", "编辑失败!");
				}
			} 
		} catch (Exception e) {
			 throw new CustomException(200,"网络异常,请稍后...");
		}
		return resultVo;
	}
	
	/**
	 * 编辑或者新增帮助推广页公共参数
	 * @param request
	 * @return
	 */
	public HelpManager getPublicParamsByReq(HttpServletRequest request){
		HelpManager record= new HelpManager();
		String id=request.getParameter("id");//分类ID
		String type=request.getParameter("type");//类型
		String title=request.getParameter("title");//标题
		String content=request.getParameter("desContent");//内容
		record.setId(id);
		if(!StringUtils.isEmpty(type)){
			record.setType(Integer.parseInt(type));
		}else
			record.setType(0);;
		record.setTitle(title);
		record.setContent(content);
		return record;
	}
	
	

}
