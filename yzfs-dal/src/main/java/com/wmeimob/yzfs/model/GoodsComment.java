package com.wmeimob.yzfs.model;

import java.util.Date;
import java.util.List;

public class GoodsComment {
	private String id;

    private String userId;

    private String orderItemId;

    private String content;

    private String replyTo;

    private Byte grade;

    private Date createdAt;

    private Date updatedAt;

    private Boolean status;
    
    private Boolean isWonderful;//是否精彩评论
    
    private String goodId;//商品ID
    
    public String getGoodId() {
		return goodId;
	}

	public void setGoodId(String goodId) {
		this.goodId = goodId;
	}

	private String goodsName;//商品名称
    
    private String userNickName;//用户昵称
    
    private String skuName;//商品SKU名称
    
    private String picKey;//商品SKU图片
    private Boolean single;//是否匿名 1是 0否
    
    public Boolean getSingle() {
		return single;
	}

	public void setSingle(Boolean single) {
		this.single = single;
	}

	public String getPicKey() {
		return picKey;
	}

	public void setPicKey(String picKey) {
		this.picKey = picKey;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getUserNickName() {
		return userNickName;
	}

	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}

	public String getSkuName() {
		return skuName;
	}

	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}

	public String getHeadImg() {
		return headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	private String headImg;//用户头像
    
    public Boolean getIsWonderful() {
		return isWonderful;
	}

	public void setIsWonderful(Boolean isWonderful) {
		this.isWonderful = isWonderful;
	}

	private List<GoodsCommentPic> goodsCommentPicList;///评论图片列表

    public List<GoodsCommentPic> getGoodsCommentPicList() {
		return goodsCommentPicList;
	}

	public void setGoodsCommentPicList(List<GoodsCommentPic> goodsCommentPicList) {
		this.goodsCommentPicList = goodsCommentPicList;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(String orderItemId) {
        this.orderItemId = orderItemId == null ? null : orderItemId.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(String replyTo) {
        this.replyTo = replyTo == null ? null : replyTo.trim();
    }

    public Byte getGrade() {
        return grade;
    }

    public void setGrade(Byte grade) {
        this.grade = grade;
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