package com.wmeimob.yzfs.service;

import java.util.List;

import com.wmeimob.yzfs.model.Admin;
import com.wmeimob.yzfs.vo.AdminVO;
import com.wmeimob.yzfs.vo.ResultVO;

public interface AdminService {

	/**
	 * 查询管理员列表
	 * 
	 * @return
	 */
	List<AdminVO> lsitAdmin(Admin example);

	/**
	 * 保存 编辑或者添加的管理员
	 * 
	 * @return
	 */
	ResultVO saveAdmin(Admin admin);

	/***
	 * 删除
	 * 
	 * @param adminId
	 * @return
	 */
	ResultVO removeAdmin(String adminId);

}
