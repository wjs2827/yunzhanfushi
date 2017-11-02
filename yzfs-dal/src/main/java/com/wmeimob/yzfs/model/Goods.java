package com.wmeimob.yzfs.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 写入商品数据使用
 *
 * @author WMM08
 */
public class Goods {

    private String id;//表ID
    
    private String shopId;//店铺ID
    
    private Integer rank;//排序值
    
    private String spuCode;//商品编码
    
    private String skuCode;//SKU编码
    
    private String skuName;//商品SKU名称
    
	private String classesId;//商品分类ID
    
    private String name;//商品名称
    
    private String spuKeysValue;//商品图片KEY
    
    private List<GoodsPics> goodsPicses;// 商品图片
    
    private Boolean spuType;//是否可改装
    
    private int neckTitleLength;//可改装SKU标题长度
    
    private int  neckLength;//可改装SKU行数
    
    private Boolean isUnifiedSpecs;//0多规格，1统一规格
    
    private int skuTitleLength;//商品SKU标题长度
    
    private int skuLength;//商品SKU组合长度

    private String className;//商品分类名称

    private String descriptions;//商品描述

    private BigDecimal salePrice;//销售价格

    private Integer salePoints;//销售积分 (销售积分:0表示不能使用积分，大于0表示可使用的积分数)

    private Boolean isSale;//0下架，1上架

    private Integer stockCount;//库存
    
    private BigDecimal weight;//商品重量

    private Integer lockCount;//锁定库存量（订单库存量）

    private Integer saleCount;//售出数量

    private Integer customizeStockCount;//自定义销量

    private Date createdAt;//创建时间

    private Date updatedAt;//修改时间

    private Boolean status;//状态(0无效，1有效)

    private String classPName;//一级分类名称

    private String classCName;//二级分类名称

    private String parentId;//父级分类ID

    private String createStart;//订单开始时间

    private String createEnd;//订单结束时间

    private String sortType;//排序类型（销量，金额等）

    private BigDecimal marketPrice;//市场价，为0则不显示

    private String sort;//排序：aprice_sort(价格降序) dprice_sort(价格升序) asale_sort(销量降序) dsale_sort(销量升序)
    
    private List<EcGoodSku> goodSkuList;//商品SKU列表
    
    private List<EcNeckSku> neckSkuList;//商品私人定制SKU列表
    
	private List<GoodsPics> goodPicsList;//商品图片列表

	public String getId() {
		return id;
	}

	public List<EcNeckSku> getNeckSkuList() {
		return neckSkuList;
	}

	public void setNeckSkuList(List<EcNeckSku> neckSkuList) {
		this.neckSkuList = neckSkuList;
	}

	public void setId(String id) {
		this.id = id;
	}
	
    public String getSkuName() {
		return skuName;
	}

	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public String getSpuCode() {
		return spuCode;
	}

	public void setSpuCode(String spuCode) {
		this.spuCode = spuCode;
	}

	public String getClassesId() {
		return classesId;
	}

	public void setClassesId(String classesId) {
		this.classesId = classesId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpuKeysValue() {
		return spuKeysValue;
	}

	public void setSpuKeysValue(String spuKeysValue) {
		this.spuKeysValue = spuKeysValue;
	}

	public List<GoodsPics> getGoodsPicses() {
		return goodsPicses;
	}

	public void setGoodsPicses(List<GoodsPics> goodsPicses) {
		this.goodsPicses = goodsPicses;
	}

	public Boolean getSpuType() {
		return spuType;
	}

	public void setSpuType(Boolean spuType) {
		this.spuType = spuType;
	}

	public int getNeckTitleLength() {
		return neckTitleLength;
	}

	public void setNeckTitleLength(int neckTitleLength) {
		this.neckTitleLength = neckTitleLength;
	}

	public int getNeckLength() {
		return neckLength;
	}

	public void setNeckLength(int neckLength) {
		this.neckLength = neckLength;
	}

	public Boolean getIsUnifiedSpecs() {
		return isUnifiedSpecs;
	}

	public void setIsUnifiedSpecs(Boolean isUnifiedSpecs) {
		this.isUnifiedSpecs = isUnifiedSpecs;
	}

	public int getSkuTitleLength() {
		return skuTitleLength;
	}

	public void setSkuTitleLength(int skuTitleLength) {
		this.skuTitleLength = skuTitleLength;
	}

	public int getSkuLength() {
		return skuLength;
	}

	public void setSkuLength(int skuLength) {
		this.skuLength = skuLength;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public BigDecimal getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	public Integer getSalePoints() {
		return salePoints;
	}

	public void setSalePoints(Integer salePoints) {
		this.salePoints = salePoints;
	}

	public Boolean getIsSale() {
		return isSale;
	}

	public void setIsSale(Boolean isSale) {
		this.isSale = isSale;
	}

	public Integer getStockCount() {
		return stockCount;
	}

	public void setStockCount(Integer stockCount) {
		this.stockCount = stockCount;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public Integer getLockCount() {
		return lockCount;
	}

	public void setLockCount(Integer lockCount) {
		this.lockCount = lockCount;
	}

	public Integer getSaleCount() {
		return saleCount;
	}

	public void setSaleCount(Integer saleCount) {
		this.saleCount = saleCount;
	}

	public Integer getCustomizeStockCount() {
		return customizeStockCount;
	}

	public void setCustomizeStockCount(Integer customizeStockCount) {
		this.customizeStockCount = customizeStockCount;
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

	public String getClassPName() {
		return classPName;
	}

	public void setClassPName(String classPName) {
		this.classPName = classPName;
	}

	public String getClassCName() {
		return classCName;
	}

	public void setClassCName(String classCName) {
		this.classCName = classCName;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getCreateStart() {
		return createStart;
	}

	public void setCreateStart(String createStart) {
		this.createStart = createStart;
	}

	public String getCreateEnd() {
		return createEnd;
	}

	public void setCreateEnd(String createEnd) {
		this.createEnd = createEnd;
	}

	public String getSortType() {
		return sortType;
	}

	public void setSortType(String sortType) {
		this.sortType = sortType;
	}

	public BigDecimal getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(BigDecimal marketPrice) {
		this.marketPrice = marketPrice;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public List<GoodsPics> getGoodPicsList() {
		return goodPicsList;
	}

	public void setGoodPicsList(List<GoodsPics> goodPicsList) {
		this.goodPicsList = goodPicsList;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getSkuCode() {
		return skuCode;
	}

	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}
	
    public List<EcGoodSku> getGoodSkuList() {
		return goodSkuList;
	}

	public void setGoodSkuList(List<EcGoodSku> goodSkuList) {
		this.goodSkuList = goodSkuList;
	}

}