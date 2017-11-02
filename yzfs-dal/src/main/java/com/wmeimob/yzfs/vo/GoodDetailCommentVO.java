package com.wmeimob.yzfs.vo;

/**
 * 商品评论列表类
 */
public class GoodDetailCommentVO {
	private String commentId;

	private String userId;

	private String userName;
	
	private String headImgUrl;

	private String content;

	private String replyTo;

	private Byte grade;
	
	private String commentTime;
	
	private String commentSpceName;

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReplyTo() {
		return replyTo;
	}

	public void setReplyTo(String replyTo) {
		this.replyTo = replyTo;
	}

	public Byte getGrade() {
		return grade;
	}

	public void setGrade(Byte grade) {
		this.grade = grade;
	}

	public String getHeadImgUrl() {
		return headImgUrl;
	}

	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}

	public String getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}

	public String getCommentSpceName() {
		return commentSpceName;
	}

	public void setCommentSpceName(String commentSpceName) {
		this.commentSpceName = commentSpceName;
	}

}
