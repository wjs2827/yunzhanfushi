package com.wmeimob.yzfs.model;

import java.util.Date;
import java.util.List;

/**
 * 买家秀
 *
 * @author guoq
 */
public class GoodsShow {

	private String goodsShowId;// 表ID
	private String showTempleateId;// 买家秀模板 ID
	private String orderItemId;// 订单明细id
	private String goodId;// 商品ID
	private String goodName;// 商品名称
	private String skuName;// 商品SKU名称
	private String neckName;// 私人订制属性名称
	private String userId;// 用户ID
	private String nickName;// 用户昵称
	private Date createdAt;//
	private Date updatedAt;//
	private Boolean status;// 状态 0 禁用 1 启用
	private String picKey;// 图片的七牛key
	private Integer thumbsCount;// 点赞次数
	private String headImg;// 
	private String goodsPickeys;// 
	
	
	

	private List<Thumbs> thumbsList;// 点赞人的列表
	
	private Integer isThumbs;// 是否点赞
	private Integer queryType;// 查询类型：1我的买家秀列表，0所有买家秀列表
	// 查询参数
	private Integer pageSize;// 每页显示行数
	private Integer pageIndex;// 页数

	
	public String getGoodsPickeys() {
		return goodsPickeys;
	}

	public void setGoodsPickeys(String goodsPickeys) {
		this.goodsPickeys = goodsPickeys;
	}

	public List<Thumbs> getThumbsList() {
		return thumbsList;
	}

	public void setThumbsList(List<Thumbs> thumbsList) {
		this.thumbsList = thumbsList;
	}

	public String getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(String orderItemId) {
		this.orderItemId = orderItemId;
	}

	public String getHeadImg() {
		return headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	public Integer getIsThumbs() {
		return isThumbs;
	}

	public void setIsThumbs(Integer isThumbs) {
		this.isThumbs = isThumbs;
	}

	public Integer getThumbsCount() {
		return thumbsCount;
	}

	public void setThumbsCount(Integer thumbsCount) {
		this.thumbsCount = thumbsCount;
	}

	public Integer getQueryType() {
		return queryType;
	}

	public void setQueryType(Integer queryType) {
		this.queryType = queryType;
	}

	public String getPicKey() {
		return picKey;
	}

	public void setPicKey(String picKey) {
		this.picKey = picKey;
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


	public String getGoodsShowId() {
		return goodsShowId;
	}

	public void setGoodsShowId(String goodsShowId) {
		this.goodsShowId = goodsShowId;
	}

	public String getShowTempleateId() {
		return showTempleateId;
	}

	public void setShowTempleateId(String showTempleateId) {
		this.showTempleateId = showTempleateId;
	}

	public String getGoodId() {
		return goodId;
	}

	public void setGoodId(String goodId) {
		this.goodId = goodId;
	}

	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public String getSkuName() {
		return skuName;
	}

	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}

	public String getNeckName() {
		return neckName;
	}

	public void setNeckName(String neckName) {
		this.neckName = neckName;
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

}