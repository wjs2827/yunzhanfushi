package com.wmeimob.yzfs.dao;

import java.util.List;

import com.wmeimob.yzfs.model.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    /**
	 * 通过example查询
	 * 
	 * @param example
	 * @return
	 */
	List<Role> selectByExample(Role example);
}