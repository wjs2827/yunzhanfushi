package com.wmeimob.yzfs.service.impl;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.wmeimob.yzfs.dao.AreaMapper;
import com.wmeimob.yzfs.dao.ExpressTempAreaMapper;
import com.wmeimob.yzfs.dao.ExpressTempDetailsMapper;
import com.wmeimob.yzfs.dao.ExpressTemplateMapper;
import com.wmeimob.yzfs.exception.CustomException;
import com.wmeimob.yzfs.model.Area;
import com.wmeimob.yzfs.model.ExpressTempArea;
import com.wmeimob.yzfs.model.ExpressTempDetails;
import com.wmeimob.yzfs.model.ExpressTemplate;
import com.wmeimob.yzfs.service.FreeService;
import com.wmeimob.yzfs.util.CheckUtils;



@Service
@Transactional(rollbackFor=Exception.class)
public class FreeServiceImpl implements FreeService {
	 
	@Autowired
	private  AreaMapper areaMapper;
	@Autowired
	private  ExpressTemplateMapper expressTemplateMapper;
	@Autowired
	private  ExpressTempDetailsMapper expressTempDetailsMapper;
	@Autowired
	private  ExpressTempAreaMapper expressTempAreaMapper;

	 
	/**
	 * 根据参数查询区域信息列表
	 */
	@Override
	public List<Area> selectByPrimaryKey(Area params) {
		return areaMapper.selectByPrimaryKey(params);
	}
	
	/**
	 * 根据参数查询运费模板信息
	 */
	@Override
	public ExpressTemplate selectTemplateByPrimaryKey(ExpressTemplate params) {
		return expressTemplateMapper.selectByPrimaryKey(params.getId());
	}
	
	/**
	 * 根据模板ID查询模板详情列表
	 */
	@Override
	public List<ExpressTempDetails> selectByPrimaryKeyList(ExpressTempDetails params) {
		return expressTempDetailsMapper.selectByPrimaryKeyList(params.getTempId());
	}
	
	
	
    
    /**
     * 保存运费模板信息
     * @param request
     * @return
     */
	@Override
	public Map<String,Object>  saveTemp(HttpServletRequest request,ExpressTemplate temp) throws CustomException{
		//获取模板参数信息
		Map<String,Object>  result=new HashMap<String, Object>();
		try {
				//校验运费模板是否选择区域地址
			    int tempId=100000;
			    int tempLength=0;
				String districtList = "";
				String dataSelectedName = "";
				ExpressTempDetails paramsDetails =null;
				ExpressTempArea expressTempArea=null;
				List<ExpressTempArea> ExpressTempAreaList =null;
				//删除原始数据
				expressTempDetailsMapper.deleteByPrimaryKey(1001);
				expressTempAreaMapper.deleteByPrimaryKey(10000);
				for (int n = 0; n < temp.getTempLength(); n++) {
					int row=n+1;
					paramsDetails = new ExpressTempDetails();
					paramsDetails.setTempId(tempId);
					districtList = request.getParameter("dataSelectedCID" + n);
					dataSelectedName= request.getParameter("dataSelectedName" + n);
					if(temp.getIsUsed()){
						if(n!=0){
							if (StringUtils.isEmpty(districtList)) {
								result.put("code", 200);
								result.put("msg", "亲!第" + row + "行未设置区域!");
								result.put("sign", "dataSelectedCID" + n);
								result.put("row", n);
								return result;
							}else{
								paramsDetails.setAreaIdList(districtList);
								paramsDetails.setAreaNameList(dataSelectedName);
							}
					     }
						if (!CheckUtils.IsIntDoubleInteger(request.getParameter("firstWeight" + n))) {
							result.put("code", 200);
							result.put("msg", "亲!第" +row+ "行首重最多只保留小数点后2位的正数!");
							result.put("sign", "firstWeight" + n);
							result.put("row", n);
							return result;
						}else{
							paramsDetails.setFirstNum(new BigDecimal(request.getParameter("firstWeight" + n)));
						}
						if (!CheckUtils.IsIntDoubleInteger(request.getParameter("firstPrice" + n))) {
							result.put("code", 200);
							result.put("msg", "亲!第" +row + "行首重运费最多只保留小数点后2位的正数!");
							result.put("sign", "firstPrice" + n);
							result.put("row", n);
							return result;
						}else{
							paramsDetails.setFirstPrice(new BigDecimal(request.getParameter("firstPrice" + n)));
						}
						if (!CheckUtils.IsIntDoubleInteger(request.getParameter("secondWeight" + n))) {
							result.put("code", 200);
							result.put("msg", "亲!第" +row+ "行须重最多只保留小数点后2位的正数!");
							result.put("sign", "secondWeight" + n);
							result.put("row", n);
							return result;
						}else{
							paramsDetails.setNextNum(new BigDecimal(request.getParameter("secondWeight" + n)));
						}
						if (!CheckUtils.IsIntDoubleInteger(request.getParameter("secondPrice" + n))) {
							result.put("code", 200);
							result.put("msg", "亲!第" +row+ "行须重运费最多只保留小数点后2位的正数!");
							result.put("sign", "secondPrice" + n);
							result.put("row", n);
							return result;
						}else{
							paramsDetails.setNextPrice(new BigDecimal(request.getParameter("secondPrice" + n)));
						}
						if(n==0){
							paramsDetails.setId(1001);
							paramsDetails.setIsDeleted(temp.getIsUsed());
							expressTempDetailsMapper.updateByPrimaryKeySelective(paramsDetails);
							tempLength+=tempLength+1;
						}else{
							//保存数据信息
							int tempDetailsId=expressTempDetailsMapper.insertSelective(paramsDetails);
							if(tempDetailsId>0){
								expressTempArea=new ExpressTempArea();
							    ExpressTempAreaList = new ArrayList<ExpressTempArea>();
								String[] tempAreaList=districtList.split(",");
								for(int j=0;j<tempAreaList.length;j++){
									expressTempArea.setExpressTempDetailsId(tempDetailsId);
									expressTempArea.setExpressLv(2);
									if(!StringUtils.isEmpty(tempAreaList[j])){
										expressTempArea.setAreaId(Integer.parseInt(tempAreaList[j]));
									}
									expressTempArea.setCreatedAt(new Date());
									expressTempArea.setUpdatedAt(new Date());
									expressTempArea.setStatus(true);
									ExpressTempAreaList.add(expressTempArea);
								}
								if(expressTempAreaMapper.insertBatch(ExpressTempAreaList)>0){
									tempLength+=tempLength+1;
								}
							}
						}
					}else{
						if(n==0){
							paramsDetails.setId(1001);
							paramsDetails.setIsDeleted(temp.getIsUsed());
							expressTempDetailsMapper.updateByPrimaryKeySelective(paramsDetails);
							tempLength+=tempLength+1;
						}else{
							if (StringUtils.isEmpty(districtList)) {
								result.put("code", 200);
								result.put("msg", "亲!第" + row+ "行未设置区域!");
								result.put("sign", "dataSelectedCID" + n);
								result.put("row", n);
								return result;
							}else{
								paramsDetails.setAreaIdList(districtList);
								paramsDetails.setAreaNameList(dataSelectedName);
							}
							if (!CheckUtils.IsIntDoubleInteger(request.getParameter("firstWeight" + n))) {
								result.put("code", 200);
								result.put("msg", "亲!第" +row+ "行首重最多只保留小数点后2位的正数!");
								result.put("sign", "firstWeight" + n);
								result.put("row", n);
								return result;
							}else{
								paramsDetails.setFirstNum(new BigDecimal(request.getParameter("firstWeight" + n)));
							}
							if (!CheckUtils.IsIntDoubleInteger(request.getParameter("firstPrice" + n))) {
								result.put("code", 200);
								result.put("msg", "亲!第" +row + "行首重运费最多只保留小数点后2位的正数!");
								result.put("sign", "firstPrice" + n);
								result.put("row", n);
								return result;
							}else{
								paramsDetails.setFirstPrice(new BigDecimal(request.getParameter("firstPrice" + n)));
							}
							if (!CheckUtils.IsIntDoubleInteger(request.getParameter("secondWeight" + n))) {
								result.put("code", 200);
								result.put("msg", "亲!第" +row+ "行须重最多只保留小数点后2位的正数!");
								result.put("sign", "secondWeight" + n);
								result.put("row", n);
								return result;
							}else{
								paramsDetails.setNextNum(new BigDecimal(request.getParameter("secondWeight" + n)));
							}
							if (!CheckUtils.IsIntDoubleInteger(request.getParameter("secondPrice" + n))) {
								result.put("code", 200);
								result.put("msg", "亲!第" +row+ "行须重运费最多只保留小数点后2位的正数!");
								result.put("sign", "secondPrice" + n);
								result.put("row", n);
								return result;
							}else{
								paramsDetails.setNextPrice(new BigDecimal(request.getParameter("secondPrice" + n)));
							}
							//保存数据信息
							int tempDetailsId=expressTempDetailsMapper.insertSelective(paramsDetails);
							if(tempDetailsId>0){
								expressTempArea=new ExpressTempArea();
							    ExpressTempAreaList = new ArrayList<ExpressTempArea>();
								String[] tempAreaList=districtList.split(",");
								for(int j=0;j<tempAreaList.length;j++){
									expressTempArea.setExpressTempDetailsId(tempDetailsId);
									expressTempArea.setExpressLv(2);
									if(!StringUtils.isEmpty(tempAreaList[j])){
										expressTempArea.setAreaId(Integer.parseInt(tempAreaList[j]));
									}
									expressTempArea.setCreatedAt(new Date());
									expressTempArea.setUpdatedAt(new Date());
									expressTempArea.setStatus(true);
									ExpressTempAreaList.add(expressTempArea);
								}
								if(expressTempAreaMapper.insertBatch(ExpressTempAreaList)>0){
									tempLength+=tempLength+1;
								}
							}
						}
					}
			} 
			result.put("code", 100);
			result.put("msg", "设置成功");
			return result;	
		} catch (Exception e) {
			result.put("code", 200);
			result.put("msg", "系统异常");
			return result;
		}
    }
	
	
	/**
	 * 根据参数获取商品基本信息
	 * @param goodsInfoVo
	 * @param
	 * @return
	 */
	public Map<String,Object> getTempInfoByParams(final ExpressTemplate temp){
		Map<String,Object>  result=new HashMap<String, Object>();
		if(StringUtils.isEmpty(temp.getTempName())){
			result.put("code", 200);
			result.put("msg", "模板名称不能为空!");
			result.put("sign", "tempName");
			result.put("error", "expressNameError");
		}else{
		    result.put("code", "spuSuccess");
		}
		return result;
	}



	
}
