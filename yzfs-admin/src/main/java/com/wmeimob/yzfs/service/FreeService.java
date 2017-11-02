package com.wmeimob.yzfs.service;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.wmeimob.yzfs.exception.CustomException;
import com.wmeimob.yzfs.model.Area;
import com.wmeimob.yzfs.model.ExpressTempDetails;
import com.wmeimob.yzfs.model.ExpressTemplate;

public interface FreeService {

    
    /**
     * 根据参数查询区域信息列表
     * @param id
     * @return
     */
    List<Area> selectByPrimaryKey(Area params);
    
    /**
     * 根据参数查询运费模板信息
     * @param params
     * @return
     */
	ExpressTemplate selectTemplateByPrimaryKey(ExpressTemplate params);


	/**
	 * 根据模板ID查询模板详情列表
	 * @param params
	 * @return
	 */
	List<ExpressTempDetails> selectByPrimaryKeyList(ExpressTempDetails params);
	
    
    
    /**
     * 保存运费模板信息
     * @param request
     * @return
     * @throws CustomException 
     */
    Map<String,Object>   saveTemp(HttpServletRequest request,ExpressTemplate temp) throws CustomException;
    
}
