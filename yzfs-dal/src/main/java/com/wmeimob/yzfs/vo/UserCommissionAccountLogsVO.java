package com.wmeimob.yzfs.vo;

import com.wmeimob.yzfs.model.UserCommissionAccountLogs;

public class UserCommissionAccountLogsVO extends UserCommissionAccountLogs{
	
	private String userId;//用户ID

	private String startTime;//创建开始时间
    
    private String endTime;//创建结束时间
    
    private String nickName;//用户昵称
    
    private String mobile;//用户手机号码
    
    private Integer pageSize;//每页显示行数
    
    private Integer pageIndex;//页数

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
    
	private String  createdTime;
	
    public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	} 
	
}