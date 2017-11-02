package com.wmeimob.yzfs.weixin;

/**
 * 订单状态枚举
 * @author WMM08
 *
 */
public enum OrderStatus {
	
	//未付款
	REQUIRED_UNPAID(0,"REQUIRED_UNPAID"),
	//待发货
	SHIPMENT_PENDING(1,"SHIPMENT_PENDING"),
	//待收货
	REQUIRED_RECEIVED(2,"REQUIRED_RECEIVED"),
	//完成
	REQUIRED_FINISHED(3,"REQUIRED_FINISHED"),
	//已取消
	REQUIRED_CANCLE(4,"REQUIRED_CANCLE"),
	//已评论
	REQUIRED_COMMENT(5,"REQUIRED_COMMENT"),
	//已删除
	REQUIRED_REMOVE(6,"REQUIRED_REMOVE"),
	//未退款
    RETURN_DRAWBACK(0,"RETURN_DRAWBACK"),
	//申请退款
    RETURN_APPLY(1,"RETURN_APPLY"),
	//商家处理中
    RETURN_PROESS(2,"RETURN_PROESS"),
	//退款成功
    RETURN_SUCCESS(3,"RETURN_SUCCESS"),
	//待换货
    EXCHANGE_BARTER(4,"EXCHANGE_BARTER"),
	//已换货
    EXCHANGE_SUCCESS(5,"EXCHANGE_SUCCESS"),
	//换货成功
    EXCHANGE_REFUSE(5,"EXCHANGE_REFUSE");
	
	public int value;
    public String msg;  
   

    OrderStatus(int value,String msg) {  
        this.value = value; 
        this.msg=msg;
    }  
}
