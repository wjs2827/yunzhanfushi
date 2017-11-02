package com.wmeimob.yzfs.model;

import java.math.BigDecimal;
import java.util.Date;

public class ReadingRewardsRecord {
	
    private String id;//阅读记录表ID

    private String readingRewardsId;//阅读文章表ID
    
    private String title;//文章标题

    private String openId;//微信OPENID
    
    private String userId;//用户ID

    private String nickName;//昵称
    
    private Integer getPoints;//所的积分

    private String superOpenId;//上级openId

    private String superNickName;//上级昵称

    private Integer superGetPoints;//上级所得积分

    private Date createdAt;//创建时间

    private Date updatedAt;//修改时间

    private Boolean status;//状态
    
    private String startTime;//开始时间
    
    private String endTime;//结束时间
    
	private  Integer isToday;//是否为今天
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getReadingRewardsId() {
		return readingRewardsId;
	}

	public void setReadingRewardsId(String readingRewardsId) {
		this.readingRewardsId = readingRewardsId;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Integer getGetPoints() {
		return getPoints;
	}

	public void setGetPoints(Integer getPoints) {
		this.getPoints = getPoints;
	}

	public String getSuperOpenId() {
		return superOpenId;
	}

	public void setSuperOpenId(String superOpenId) {
		this.superOpenId = superOpenId;
	}

	public String getSuperNickName() {
		return superNickName;
	}

	public void setSuperNickName(String superNickName) {
		this.superNickName = superNickName;
	}

	public Integer getSuperGetPoints() {
		return superGetPoints;
	}

	public void setSuperGetPoints(Integer superGetPoints) {
		this.superGetPoints = superGetPoints;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
    
	public Integer getIsToday() {
		return isToday;
	}

	public void setIsToday(Integer isToday) {
		this.isToday = isToday;
	}
    

}