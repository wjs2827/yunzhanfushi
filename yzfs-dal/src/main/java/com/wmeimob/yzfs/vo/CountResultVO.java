package com.wmeimob.yzfs.vo;

import java.util.Date;

/**
 * 统计VO
 */
public class CountResultVO {

	/**
	 * 总数
	 */
	private Integer count;

	/**
	 * 最小值
	 */
	private Integer minNum;

	/**
	 * 最大值
	 */
	private Integer maxNum;
	
	/**
	 * 统计时间
	 */
	private Date  countTime;
	
	public Date getCountTime() {
		return countTime;
	}

	public void setCountTime(Date countTime) {
		this.countTime = countTime;
	}


	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getMinNum() {
		return minNum;
	}

	public void setMinNum(Integer minNum) {
		this.minNum = minNum;
	}

	public Integer getMaxNum() {
		return maxNum;
	}

	public void setMaxNum(Integer maxNum) {
		this.maxNum = maxNum;
	}

}
