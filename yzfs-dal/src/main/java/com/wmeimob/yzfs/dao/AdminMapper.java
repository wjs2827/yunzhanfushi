package com.wmeimob.yzfs.dao;

import java.util.List;

import com.wmeimob.yzfs.model.Admin;
import com.wmeimob.yzfs.vo.AdminVO;

public interface AdminMapper {
    int deleteByPrimaryKey(String id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
    
    /**
     * 通过Example查询
     * 
     * @param example
     * @return
     */
    List<Admin> selectByExample(Admin example);

    /**
     * 查询Admin列表，包括roleName
     */
    List<AdminVO> selectAdminWithRole(Admin example);
    
}