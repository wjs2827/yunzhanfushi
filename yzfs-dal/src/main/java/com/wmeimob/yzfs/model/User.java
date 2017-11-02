package com.wmeimob.yzfs.model;

import java.math.BigDecimal;
import java.util.Date;

public class User {
	
    private String id;

    private Boolean type;

    private String shopId;

    private String loginName;

    private String nickName;

    private String passwd;

    private Boolean sex;

    private String headImg;

    private String mobile;

    private String province;

    private String city;

    private String district;

    private String address;

    private String payPasswd;

    private String wxOpenId;

    private String qrcodeTicket;

    private Integer recommendQty;

    private String recommendUserId;

    private String invitateCode;

    private Boolean isUsed;

    private Date createdAt;

    private Date updatedAt;

    private Boolean status;
    
    private String accountId;//账户ID
    
    private BigDecimal accountAmount;//账户余额
    private BigDecimal historyAmount;//历史总余额
    private BigDecimal withdrawAmount;//累计使用余额

    private String cardId;//会员卡ID
	private Integer accountPoints;//会员T金
    
    private String qrcodeKey;//个人二维码key
    
    private String commissionId;//佣金账户id

    private BigDecimal commissionAmount;//账户佣金
    private BigDecimal commissionWithdrawAmount;//历史总佣金
    private BigDecimal commissionHistoryAmount;//累计提现佣金
    
    
    public BigDecimal getCommissionAmount() {
		return commissionAmount;
	}

	public void setCommissionAmount(BigDecimal commissionAmount) {
		this.commissionAmount = commissionAmount;
	}

	public String getCommissionId() {
		return commissionId;
	}

	public void setCommissionId(String commissionId) {
		this.commissionId = commissionId;
	}

	public BigDecimal getCommissionWithdrawAmount() {
		return commissionWithdrawAmount;
	}

	public void setCommissionWithdrawAmount(BigDecimal commissionWithdrawAmount) {
		this.commissionWithdrawAmount = commissionWithdrawAmount;
	}

	public BigDecimal getCommissionHistoryAmount() {
		return commissionHistoryAmount;
	}

	public void setCommissionHistoryAmount(BigDecimal commissionHistoryAmount) {
		this.commissionHistoryAmount = commissionHistoryAmount;
	}

	public BigDecimal getHistoryAmount() {
		return historyAmount;
	}

	public void setHistoryAmount(BigDecimal historyAmount) {
		this.historyAmount = historyAmount;
	}

	public BigDecimal getWithdrawAmount() {
		return withdrawAmount;
	}

	public void setWithdrawAmount(BigDecimal withdrawAmount) {
		this.withdrawAmount = withdrawAmount;
	}

	public String getQrcodeKey() {
		return qrcodeKey;
	}

	public void setQrcodeKey(String qrcodeKey) {
		this.qrcodeKey = qrcodeKey;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}


	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}


    
    public BigDecimal getAccountAmount() {
		return accountAmount;
	}

	public void setAccountAmount(BigDecimal accountAmount) {
		this.accountAmount = accountAmount;
	}

	public Integer getAccountPoints() {
		return accountPoints;
	}

	public void setAccountPoints(Integer accountPoints) {
		this.accountPoints = accountPoints;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd == null ? null : passwd.trim();
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg == null ? null : headImg.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPayPasswd() {
        return payPasswd;
    }

    public void setPayPasswd(String payPasswd) {
        this.payPasswd = payPasswd == null ? null : payPasswd.trim();
    }

    public String getWxOpenId() {
        return wxOpenId;
    }

    public void setWxOpenId(String wxOpenId) {
        this.wxOpenId = wxOpenId == null ? null : wxOpenId.trim();
    }

    public String getQrcodeTicket() {
        return qrcodeTicket;
    }

    public void setQrcodeTicket(String qrcodeTicket) {
        this.qrcodeTicket = qrcodeTicket == null ? null : qrcodeTicket.trim();
    }

    public Integer getRecommendQty() {
        return recommendQty;
    }

    public void setRecommendQty(Integer recommendQty) {
        this.recommendQty = recommendQty;
    }

    public String getRecommendUserId() {
        return recommendUserId;
    }

    public void setRecommendUserId(String recommendUserId) {
        this.recommendUserId = recommendUserId == null ? null : recommendUserId.trim();
    }

    public String getInvitateCode() {
        return invitateCode;
    }

    public void setInvitateCode(String invitateCode) {
        this.invitateCode = invitateCode == null ? null : invitateCode.trim();
    }

    public Boolean getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(Boolean isUsed) {
        this.isUsed = isUsed;
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