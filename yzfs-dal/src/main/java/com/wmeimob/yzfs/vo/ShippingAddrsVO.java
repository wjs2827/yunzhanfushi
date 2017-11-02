package com.wmeimob.yzfs.vo;

import com.wmeimob.yzfs.model.ShippingAddrs;


/**
 * 收货地址VO
 *
 */
public class ShippingAddrsVO  extends ShippingAddrs{
	
	private String pName;//省份名称
	
	private String cName;//城市名称
	
	private String dName;//区名称

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}
	
	
	

}