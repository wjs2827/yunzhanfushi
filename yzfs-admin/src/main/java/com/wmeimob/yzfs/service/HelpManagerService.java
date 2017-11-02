package com.wmeimob.yzfs.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.wmeimob.yzfs.exception.CustomException;
import com.wmeimob.yzfs.model.HelpManager;
import com.wmeimob.yzfs.vo.HelpManagerVO;

/**
 * Created by WMM07 on 2016/7/27.
 */
public interface HelpManagerService {
	/**
	 * 根据参数修改帮助或者推广页信息
	 * @param record
	 * @return
	 */
	HelpManagerVO queryHelpList(HelpManager record);
	
	/**
	 * 新增编辑帮助或者推广页内容信息
	 * @param record
	 * @return
	 * @throws CustomException 
	 */
	Map<String,Object> editAndSaveHelpManagerInfo(HttpServletRequest request) throws CustomException;
    

}
