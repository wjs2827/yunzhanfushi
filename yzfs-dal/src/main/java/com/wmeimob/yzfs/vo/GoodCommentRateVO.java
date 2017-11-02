package com.wmeimob.yzfs.vo;

public class GoodCommentRateVO {
	private Integer commentCount;

	private Integer niceCommentCount;

	private String niceCommentRate;// String类型，不用转换

	public Integer getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}

	public Integer getNiceCommentCount() {
		return niceCommentCount;
	}

	public void setNiceCommentCount(Integer niceCommentCount) {
		this.niceCommentCount = niceCommentCount;
	}

	public String getNiceCommentRate() {
		return niceCommentRate;
	}

	public void setNiceCommentRate(String niceCommentRate) {
		this.niceCommentRate = niceCommentRate;
	}

}
