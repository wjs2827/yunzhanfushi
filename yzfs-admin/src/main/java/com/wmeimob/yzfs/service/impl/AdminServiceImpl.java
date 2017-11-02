package com.wmeimob.yzfs.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wmeimob.yzfs.dao.AdminMapper;
import com.wmeimob.yzfs.model.Admin;
import com.wmeimob.yzfs.service.AdminService;
import com.wmeimob.yzfs.util.Md5Util;
import com.wmeimob.yzfs.vo.AdminVO;
import com.wmeimob.yzfs.vo.ResultVO;


@Service
public class AdminServiceImpl implements AdminService {

	private static final String PASSWORD = "888888";
	@Autowired
	private AdminMapper adminMapper;

	@Override
	public List<AdminVO> lsitAdmin(Admin example) {
		List<AdminVO> admins = adminMapper.selectAdminWithRole(example);
		return admins;
	}

	@Override
	public ResultVO saveAdmin(Admin admin) {
		ResultVO result = new ResultVO();
		Date now = new Date();
		Admin example = new Admin();
		example.setLoginName(admin.getLoginName());
		List<Admin> exists = adminMapper.selectByExample(example);
		if (StringUtils.isEmpty(admin.getId())) {
			// 新增
			if (exists != null && exists.size() > 0) {
				result.setCode(12);
				result.setMessage("登录名已经存在");
				return result;
			}
			admin.setId(UUID.randomUUID().toString());
			admin.setCreateTime(now);
			admin.setIsDisable(false);
			admin.setIsFixed(false);
			admin.setPassword(Md5Util.Md5(PASSWORD));
			admin.setStatus(true);
			admin.setUpdateTime(now);
			adminMapper.insertSelective(admin);
		} else {
			// 编辑
			Admin a = adminMapper.selectByPrimaryKey(admin.getId());
			if (a == null) {
				result.setCode(11);
				result.setMessage("管理员不存在");
				return result;
			}
			// 判断用户名是否重复
			if (exists != null && exists.size() > 0) {
				Admin exist=exists.get(0);
				if (!exist.getId().equals(a.getId())) {
					result.setCode(12);
					result.setMessage("登录名已经存在");
					return result;
				}
			}
			adminMapper.updateByPrimaryKeySelective(admin);
		}
		result.setCode(0);
		return result;
	}

	@Override
	public ResultVO removeAdmin(String adminId) {
		ResultVO result = new ResultVO();
		Admin selectByPrimaryKey = adminMapper.selectByPrimaryKey(adminId);
		if (selectByPrimaryKey == null) {
			result.setCode(11);
			result.setMessage("用户不存在");
			return result;
		}
		//该用户的菜单是否应同时删除
		selectByPrimaryKey.setStatus(false);
		int count = adminMapper.updateByPrimaryKeySelective(selectByPrimaryKey);
		if (count > 0) {
			result.setCode(0);
		} else {
			result.setCode(12);
			result.setMessage("保存数据失败，请重试");
		}
		return result;
	}

}
