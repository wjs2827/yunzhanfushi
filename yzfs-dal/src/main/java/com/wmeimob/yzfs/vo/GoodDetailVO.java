package com.wmeimob.yzfs.vo;
import java.util.List;

import com.wmeimob.yzfs.model.EcSkuProperties;
import com.wmeimob.yzfs.model.Goods;
import com.wmeimob.yzfs.model.GoodsPics;

/**
 * 商品详情页面VO
 */
public class GoodDetailVO extends Goods {

    private List<GoodsPics> pics;//轮播图

    private List<EcSkuProperties> specs;//规格

    private Boolean isLimited;//是否限购

    private int lastCount;//限购情况下，剩余购买数量

    public List<GoodsPics> getPics() {
        return pics;
    }

    public void setPics(List<GoodsPics> pics) {
        this.pics = pics;
    }
    
    public int getLastCount() {
        return lastCount;
    }

    public void setLastCount(int lastCount) {
        this.lastCount = lastCount;
    }

    public Boolean getIsLimited() {
        return isLimited;
    }

    public void setIsLimited(Boolean isLimited) {
        this.isLimited = isLimited;
    }

	public List<EcSkuProperties> getSpecs() {
		return specs;
	}

	public void setSpecs(List<EcSkuProperties> specs) {
		this.specs = specs;
	}
}
