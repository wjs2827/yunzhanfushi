package com.wmeimob.yzfs.dao;

import org.apache.ibatis.annotations.Param;

import com.wmeimob.yzfs.model.ExpressTemplate;

public interface ExpressTemplateMapper {

	/**
	 * 查询运费模板
	 * @param id
	 * @return
	 */
    ExpressTemplate selectByPrimaryKey(@Param("id")Integer id);
}