package com.wmeimob.yzfs.vo;

public class OrderStatusCount {
	// 0未付款，1待发货，2待收货，3完成，4撤消，5已评论
	// UNPAID("未付款",(byte)0),
	// WAIT_SHIPPING("待发货",(byte)1),
	// WAIT_RECEIPT("待收货",(byte)2),
	// CONFIRM_RECEIPT("完成",(byte)3),
	// CANCEL("撤消",(byte)4),
	// COMMENT("已评论",(byte)5);

	private Integer unPay;// 待支付订单数量
	private Integer waitShipping;// 待发货订单数量
	private Integer waitReceipt;// 待收货订单数量
	private Integer waitEvaluate;// 待评价订单
	private Integer refunding;// 退后中的账单数量
	private Integer refundSuccess;// 退货成功的账单数量
	private Integer refundFailed;// 退货失败的账单数量
	private Integer refund;//退货中的数量，即上面退货三项的总和
	private Integer allOrder;//所有订单数量
	private Integer cartNumber;//购物车数量

	public Integer getCartNumber() {
		return cartNumber;
	}

	public void setCartNumber(Integer cartNumber) {
		this.cartNumber = cartNumber;
	}

	public Integer getUnPay() {
		return unPay;
	}

	public void setUnPay(Integer unPay) {
		this.unPay = unPay;
	}

	public Integer getWaitShipping() {
		return waitShipping;
	}

	public void setWaitShipping(Integer waitShipping) {
		this.waitShipping = waitShipping;
	}

	public Integer getWaitReceipt() {
		return waitReceipt;
	}

	public void setWaitReceipt(Integer waitReceipt) {
		this.waitReceipt = waitReceipt;
	}

	public Integer getWaitEvaluate() {
		return waitEvaluate;
	}

	public void setWaitEvaluate(Integer waitEvaluate) {
		this.waitEvaluate = waitEvaluate;
	}

	public Integer getRefunding() {
		return refunding;
	}

	public void setRefunding(Integer refunding) {
		this.refunding = refunding;
	}

	public Integer getRefundSuccess() {
		return refundSuccess;
	}

	public void setRefundSuccess(Integer refundSuccess) {
		this.refundSuccess = refundSuccess;
	}

	public Integer getRefundFailed() {
		return refundFailed;
	}

	public void setRefundFailed(Integer refundFailed) {
		this.refundFailed = refundFailed;
	}

	public Integer getRefund() {
		return refund;
	}

	public void setRefund(Integer refund) {
		this.refund = refund;
	}

	public Integer getAllOrder() {
		return allOrder;
	}

	public void setAllOrder(Integer allOrder) {
		this.allOrder = allOrder;
	}

}
