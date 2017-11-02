package com.wmeimob.yzfs.vo;
import java.util.List;
import com.wmeimob.yzfs.model.EcSkuProperties;
import com.wmeimob.yzfs.model.Goods;
import com.wmeimob.yzfs.model.GoodsPics;

/**
 * 读取商品信息使用
 * @author WMM08
 *
 */
public class GoodsVO extends Goods {
	
	private String parentName;//父类名称
	
	private String classesName;//分类名称
	
    private Integer stock_count;//统一规格库存
    
    private String specId;//规格ID
    
	private Integer customizeStock;// 自定义销量
	
	private String shopId;//商铺ID
	
    private List<EcSkuProperties> goodsSpecses;//商品规格
    
    private List<GoodsPics> goodsPicses;// 商品图片
    
    

	public String getClassesName() {
		return classesName;
	}

	public void setClassesName(String classesName) {
		this.classesName = classesName;
	}

	public Integer getStock_count() {
		return stock_count;
	}

	public void setStock_count(Integer stock_count) {
		this.stock_count = stock_count;
	}

	public String getSpecId() {
		return specId;
	}

	public void setSpecId(String specId) {
		this.specId = specId;
	}

	public Integer getCustomizeStock() {
		return customizeStock;
	}

	public void setCustomizeStock(Integer customizeStock) {
		this.customizeStock = customizeStock;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public List<GoodsPics> getGoodsPicses() {
		return goodsPicses;
	}

	public void setGoodsPicses(List<GoodsPics> goodsPicses) {
		this.goodsPicses = goodsPicses;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public List<EcSkuProperties> getGoodsSpecses() {
		return goodsSpecses;
	}

	public void setGoodsSpecses(List<EcSkuProperties> goodsSpecses) {
		this.goodsSpecses = goodsSpecses;
	}
	

	
	
}
