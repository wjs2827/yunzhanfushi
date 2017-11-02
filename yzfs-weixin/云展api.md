##  <a name='index'>顶部</a>
<!-- vscode-markdown-toc -->
测试域名：wangjs.iego.net
* 1. [homeSilderList 查询首页轮播图](#homeSilderList)
* 2. [homeCategoryList 查询首页分类以及商品详情列表](#homeCategoryList)
* 3. [homeCommentList 查询首页精彩评论列表](#homeCommentList)
* 4. [goodList 查询商品列表](#goodList)
* 5. [goodCategoryList 查询商品分类](#goodCategoryList)
* 6. [id 根据商品ID查询商品明细(商品图片列表或者私人定制图片列表)](#id)
* 7. [descriptions 根据商品ID查询商品详情文本信息](#descriptions)
* 8. [goodCommentById 商品详情评论](#goodCommentById)
* 9. [queryEcGoodSkuPropertiesFromWX 查询商品下SKU属性值](#queryEcGoodSkuPropertiesFromWX)
* 10.[queryEcGoodSkuFromWX 根据商品ID和组合sku编码查询商品SKU信息](#queryEcGoodSkuFromWX)
* 11.[queryEcGoodNeckSkuPropertiesFromWX 查询可改装SKU属性值](#queryEcGoodNeckSkuPropertiesFromWX)
* 12.[queryEcGoodNeckSkuFromWX 根据商品ID和组合可改装sku编码查询商品可改装SKU信息](#queryEcGoodNeckSkuFromWX)
* 13.[addCart 加入购物车](#addCart)
* 13-1.[buyNow 立即购买](#buyNow)
* 14.[listCart 购物车查询](#listCart)
* 14-1.[queryCartNumber 购物车数量查询](#queryCartNumber)
* 15.[addAndSub 购物车数量加减](#addAndSub)
* 16.[deleteCartById 删除购物车商品](#deleteCartById)
* 17.[settlement 去结算](#settlement)
* 18.[queryAddressList 查询用户地址列表](#queryAddressList)
* 19.[queryAddressById 根据ID查询地址信息](#queryAddressById)
* 20.[uddateAddressById 修改或者新增地址信息](#uddateAddressById)
* 21.[setAddressIsDefault  设置为默认地址](#setAddressIsDefault)
* 22.[deleteAddressById  根据ID删除地址](#deleteAddressById)
* 23.[saveOrder  提交订单](#saveOrder)
* 23-1.[balaceCallBack  余额支付回掉](#balaceCallBack)
* 24.[register  注册](#register)
* 24-1.[sendSmsCode  发送短信验证码](#sendSmsCode)
* 25.[savePaypasswd  设置支付密码](#savePaypasswd)
* 26.[myCenter  个人中心](#myCenter)
* 27.[ordreList  我的订单查询列表](#ordreList)
* 27-1.[orderItemById  根据订单ID查询我的订单详情](#orderItemById)
* 27-2.[goPay  立即支付](#goPay)
* 27-3.[cancleOrder  取消订单](#cancleOrder)
* 27-4.[confirmReceipt  确认收货](#confirmReceipt)
* 27-5.[queryOrderItemInfoById  申请售后根据订单明细ID查询订单信息](#queryOrderItemInfoById)
* 27-6.[applyReturnOrder  申请售后提交](#applyReturnOrder)
* 27-7.[goCommentByOrderId  去评价](#goCommentByOrderId)
* 27-8.[saveComment  提交评价](#saveComment)
* 28.[rightsOrdreList  售后列表](#rightsOrdreList)
* 28-1.[rightsOrderItemById  根据订单ID查询我的售后订单详情](#rightsOrderItemById)
* 29.[recharge  查询充值卡类型列表](#recharge)
* 30.[saveRecharge  确认充值](#saveRecharge)
* 31.[myBalaceRecord  余额记录](#myBalaceRecord)
* 32.[myCardLogRecord  T金记录](#myCardLogRecord)
* 33.[myCommission  我的佣金](#myCommission)
* 34.[myCommissionRecord  佣金记录](#myCommissionRecord)
* 35.[saveOrder  我的买家秀列表](#saveOrder)
* 36.[qiniuToken  获取七牛Token](#qiniuToken)
* 37.[getSdkConfig  获取JSSDK config信息](#getSdkConfig)
* 38.[removeOrder  删除订单](#removeOrder)
* 39.[withdrawals  提现](#withdrawals)
* 40.[getMyQRCode  获取我的二维码](#getMyQRCode)

##  1. <a name='homeSilderList'></a> 查询首页轮播图: [返回顶部](#index)

>1.接口信息<br>

>     协议      | 请求方式           | 请求地址        
     ------------- | ---------------| --------------  
     HTTP          | get        |  http://wangjs.iego.net/yzfs-weixin/home/api/homeSilderList
     
>2.请求参数<br>

>     参数名称      | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
      token          | String        | Y               | 识别身份的秘钥

>3.返回值,如下


>     英文名       | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     code          | String        | Y               | 状态码 100：成功、403：未登录、200:暂无数据 ，404:系统异常
     message       | String        | N               | 成功或错误的消息提示，错误时可用做弹窗提示
     data    | List          | Y                |返回接口数据名称
     

>5.data数据格式如下

>     英文名              | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     id           | String        | Y		      | 数据ID
     picKey       | String        | Y		      | 轮播图七牛KEY
     targetType   | String        | Y		      | 轮播图类型 0 指定商品  2 链接
     targetId     | String        | Y		      | 商品id
     linkUrl      | String        | Y		      | 链接
     
##  2. <a name='homeCategoryList'></a> 查询首页分类以及商品详情列表: [返回顶部](#index)

>1.接口信息<br>

>     协议      | 请求方式           | 请求地址        
     ------------- | ---------------| --------------  
     HTTP          | get        |  http://wangjs.iego.net/yzfs-weixin/home/api/homeCategoryList            

>2.请求参数<br>

>     参数名称      | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     token          | String        | Y               | 识别身份的秘钥

>3.返回值,如下


>     英文名       | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     code          | String        | Y               | 状态码 100：成功、403：未登录、200:暂无数据 ，404:系统异常
     message       | String        | N               | 成功或错误的消息提示，错误时可用做弹窗提示
     data          |List           |Y                |返回接口数据名称
     

>4.data数据格式如下

>     英文名              | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     id           | String        | Y		      | 数据ID
     isUse       | Boolean        | Y		      | 是否启用  true 启用 false 停用
     type   | int        | Y		      | 分类级别  1 一级分类 2 二级分类 3  三级分类
     categoryId     | String        | Y		      | 分类ID
     name      | String        | Y		      | 分类名称
     homeCategoryProductVo | List 
     
>5.homeCategoryProductVo数据格式如下

>     英文名              | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     id           | String        | Y		      | 数据ID
     homeCategoryId       | String         | Y		      | 上级ID
     spuId   | String      | Y		      | 商品ID
     spuKey     | String        | Y		      | 分类商品图片KEY
     name      | String        | Y		      | 商品名称
     markket_price | decimal  | Y | 市场价
     show_price | decimal |   Y|   销售价
     sale_count |   int       |    Y| 销量
      
## 3. <a name='homeCommentList'></a> 查询首页精彩评论列表: [返回顶部](#index)

>1.接口信息<br>

>     协议      | 请求方式           | 请求地址        
     ------------- | ---------------| --------------  
     HTTP          | get        |  http://wangjs.iego.net/yzfs-weixin/home/api/homeCommentList            

>2.请求参数<br>

>     参数名称      | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
      token          | String        | Y               | 识别身份的秘钥

>3.返回值,如下


>     英文名       | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     code          | String        | Y               | 状态码 100：成功、403：未登录、200:暂无数据 ，404:系统异常
     message       | String        | N               | 成功或错误的消息提示，错误时可用做弹窗提示
     data          |List           |Y                |返回接口数据名称
     

>4.data数据格式如下

>     英文名              | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     headImg           | String        | Y		      | 用户头像
     userNickName       | String        | Y		      | 昵称
     grade     | String        | Y		      | 等级  1： 一星   2：两星 .....5:五星
     content      | String        | Y		      | 评分内容
     goodsName   | String        | Y		      | 商品名称
     picKey      | String        | Y		      | 商品图片
     skuName      | String        | Y		      | 商品SKU属性 例如：褐色+L
     goodsCommentPicList | List                  |商品评论图片列表
     
>5.goodsCommentPicList数据格式如下

>     英文名              | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     id           | String        | Y		      | 数据ID
     picKey       | String         | Y		      | 评论图片
     
     
## 4. <a name='goodList'></a> 查询商品列表: [返回顶部](#index)

>1.接口信息<br>

>     协议      | 请求方式           | 请求地址        
     ------------- | ---------------| --------------  
     HTTP          | get        |  http://wangjs.iego.net/yzfs-weixin/good/api/goodList            

>2.请求参数<br>

>     参数名称      | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
      token          | String        | Y               | 识别身份的秘钥
      classesId          | String        | Y               | 二级分类ID
      name          | String        | Y               | 商品名称

>3.返回值,如下


>     英文名       | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     code          | String        | Y               | 状态码 100：成功、403：未登录、200:暂无数据 ，404:系统异常
     message       | String        | N               | 成功或错误的消息提示，错误时可用做弹窗提示
     data          |List           |Y                |返回接口数据名称
     

>4.data数据格式如下

>     英文名              | 类型           | 是否必须        | 备注
     -------------| --------------| ------------| -------------
     id           | String        | Y		      | 商品ID
     spuKeysValue | String        | Y		      | 商品图片
     name         | String        | Y		      | 商品名称
     marketPrice  | decimal       | Y		      | 市场价
     salePrice    | decimal       | Y		      | 销售价
     saleCount    | int           | Y		      | 销售量
     
## 5. <a name='goodCategoryList'></a> 查询商品分类: [返回顶部](#index)

>1.接口信息<br>

>     协议      | 请求方式           | 请求地址        
     ------------- | ---------------| --------------  
     HTTP          | get        |  http://wangjs.iego.net/yzfs-weixin/good/api/goodCategoryList            

>2.请求参数<br>

>     参数名称      | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
      token          | String        | Y               | 识别身份的秘钥

>3.返回值,如下


>     英文名       | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     code          | String        | Y               | 状态码 100：成功、403：未登录、200:暂无数据 ，404:系统异常
     message       | String        | N               | 成功或错误的消息提示，错误时可用做弹窗提示
     data          |List           |Y                |返回接口数据名称
     

>4.data数据格式如下

>     英文名              | 类型           | 是否必须        | 备注
     -------------| --------------| ------------| -------------
     id           | String        | Y		      | 一级分类ID
     name         | String        | Y		      | 一级分类名称
     picKey       | String        | Y		      | 一级分类图片
     secondCategoryList       | List        | Y		      | 二级分类列表
     
>5.secondCategoryList数据格式如下

>     英文名              | 类型           | 是否必须        | 备注
     -------------| --------------| ------------| -------------
     id           | String        | Y		      | 二级级分类ID
     name         | String        | Y		      | 二级分类名称
     picKey       | String        | Y		      | 二级分类图片
     parentId       | String        | Y		      | 父类ID
     
## 6. <a name='id'></a> 根据商品ID查询商品明细(商品图片列表或者私人定制图片列表): [返回顶部](#index)

>1.接口信息<br>

>     协议      | 请求方式           | 请求地址        
     ------------- | ---------------| --------------  
     HTTP          | get        |  http://wangjs.iego.net/yzfs-weixin/good/api/商品ID            

>2.请求参数<br>

>     参数名称      | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
      token          | String        | Y               | 识别身份的秘钥
      isMade          | String        | Y               | 是否私人订制  0 否 1 是

>3.返回值,如下


>     英文名       | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     code          | String        | Y               | 状态码 100：成功、403：未登录、200:暂无数据 、404:系统异常
     message       | String        | N               | 成功或错误的消息提示，错误时可用做弹窗提示
     data          |List           |Y                |返回接口数据名称
     

>4.data数据格式如下

>     英文名              | 类型           | 是否必须        | 备注
     -------------| --------------| ------------| -------------
     id           | String        | Y		      | 商品ID
     classesId           | String        | Y		      | 商品分类ID
     spuType           | Boolean        | Y		      | 是否可改装 true  可改装; false 不可改装
     isUnifiedSpecs           | Boolean        | Y		      | 是否多规格  false 单规格; true 多规格
     spuCode         | String        | Y		      | 商品编码
     skuName       | String        | Y		      | 商品SKU组合编码
     skuCode       | String        | Y		      | 商品SKU组合名称
     name       | String        | Y		      | 商品名称
     salePrice       | decimal        | Y		      | 默认SKU销售价
     marketPrice       | decimal        | Y		      | 默认SKU市场价
     stockCount       | int        | Y		      | 默认SKU库存
     saleCount       | int        | Y		      | 销量
     goodPicsList       | List        | Y		      | 商品图片列表
     neckSkuList       | List        | Y		      | 私人定制图片列表
     
>5.goodPicsList数据格式如下

>     英文名              | 类型           | 是否必须        | 备注
     -------------| --------------| ------------| -------------
     id           | String        | Y		      | ID
     goodId         | String        | Y		      | 商品ID
     picKey       | String        | Y		      | 商品图片KEY
     
>6.neckSkuList 私人定制数据格式如下

>     英文名              | 类型           | 是否必须        | 备注
     -------------| --------------| ------------| -------------
     id           | String        | Y		      | ID
     spuId         | String        | Y		      | 商品ID
     spuCode         | String        | Y		      | 商品编码
     skuCode         | String        | Y		      | 商品私人定制SKU编码
     skuName         | String        | Y		      | 商品私人定制SKU名称 
     picKey       | String        | Y		      | 商品私人定制衣服图片KEY
     salePrice       | decimal        | Y		      | 商品私人定制加价
     
     
## 7. <a name='descriptions'></a> 根据商品ID查询商品详情文本信息: [返回顶部](#index)

>1.接口信息<br>

>     协议      | 请求方式           | 请求地址        
     ------------- | ---------------| --------------  
     HTTP          | get        |  http://wangjs.iego.net/yzfs-weixin/good/api/descriptions      

>2.请求参数<br>

>     参数名称      | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     token          | String        | Y               | 识别身份的秘钥
     id          | String        | Y               | 商品ID

>3.返回值,如下


>     英文名       | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     code          | String        | Y               | 状态码 100：成功、403：未登录、200:暂无数据 ，404:系统异常
     message       | String        | N               | 成功或错误的消息提示，错误时可用做弹窗提示
     data          |List           |Y                |返回接口数据名称
     

>4.data数据格式如下

>     英文名              | 类型           | 是否必须        | 备注
     -------------| --------------| ------------| -------------
     description           | String        | Y		      | 商品详情介绍
     
## 8. <a name='goodCommentById'></a> 商品详情评论: [返回顶部](#index)

>1.接口信息<br>

>     协议      | 请求方式           | 请求地址        
     ------------- | ---------------| --------------  
     HTTP          | get        |  http://wangjs.iego.net/yzfs-weixin/home/api/goodCommentById          

>2.请求参数<br>

>     参数名称      | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     token          | String        | Y               | 识别身份的秘钥
     id          | String        | Y               | 商品ID


>3.返回值,如下


>     英文名       | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     code          | String        | Y               | 状态码 100：成功、403：未登录、200:暂无数据 ，404:系统异常
     message       | String        | N               | 成功或错误的消息提示，错误时可用做弹窗提示
     data          |List           |Y                |返回接口数据名称
     

>4.data数据格式如下

>     英文名              | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     headImg           | String        | Y		      | 用户头像
     userNickName       | String        | Y		      | 昵称
     grade     | String        | Y		      | 等级  1： 一星   2：两星 .....5:五星
     content      | String        | Y		      | 评分内容
     goodsName   | String        | Y		      | 商品名称
     picKey      | String        | Y		      | 商品图片
     skuName      | String        | Y		      | 商品SKU属性 例如：褐色+L
     goodsCommentPicList | List                  |商品评论图片列表
     
## 9. <a name='queryEcGoodSkuPropertiesFromWX'></a> 查询商品分类下SKU属性值: [返回顶部](#index)

>1.接口信息<br>

>     协议      | 请求方式           | 请求地址        
     ------------- | ---------------| --------------  
     HTTP          | get        |  http://wangjs.iego.net/yzfs-weixin/good/api/queryEcGoodSkuPropertiesFromWX    

>2.请求参数<br>

>     参数名称      | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     token          | String        | Y               | 识别身份的秘钥
     classId          | String        | Y               | 分类ID
     spuId          | String        | Y               | 商品ID


>3.返回值,如下


>     英文名       | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     code          | String        | Y               | 状态码 100：成功、403：未登录、200:暂无数据 ，404:系统异常
     message       | String        | N               | 成功或错误的消息提示，错误时可用做弹窗提示
     data          |List           |Y                |返回接口数据名称
     

>4.data数据格式如下

>     英文名              | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     key           | int        | Y		      | SKU父级ID  如颜色ID 1001
     val       | String        | Y		      | SKU父级名称  如颜色
     skuItem       | List        | Y		      | SKU父级下的属性列表
         
     
>5.skuItem数据格式如下

>     英文名              | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     key           | int        | Y		      | SKU父级ID  如颜色ID 1001
     val       | String        | Y		      | SKU父级名称  如颜色
      
     
## 10. <a name='queryEcGoodSkuFromWX'></a> 根据商品ID和组合sku编码查询商品SKU信息: [返回顶部](#index)

>1.接口信息<br>

>     协议      | 请求方式           | 请求地址        
     ------------- | ---------------| --------------  
     HTTP          | get        |  http://wangjs.iego.net/yzfs-weixin/good/api/queryEcGoodSkuFromWX        

>2.请求参数<br>

>     参数名称      | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     token          | String        | Y               | 识别身份的秘钥
     skuCode          | String        | Y               | sku编码
     id          | String        | Y               | 商品ID


>3.返回值,如下


>     英文名       | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     code          | String        | Y               | 状态码 100：成功、403：未登录、200:暂无数据 ，404:系统异常
     message       | String        | N               | 成功或错误的消息提示，错误时可用做弹窗提示
     data          |List           |Y                |返回接口数据名称
     

>4.data数据格式如下

>     英文名              | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     id           | int        | Y		      | ID
     spuId       | String        | Y		      | 商品ID
     spuCode     | String        | Y		      | 商品编码
     skuCode   | String         | Y		      | SKU编码
     skuName   | String         | Y		      | SKU名称
     price   | decimal         | Y		      | 价格
     marketPrice   | decimal         | Y		      |市场价
     picKey   | String         | Y		      | SKU图片KEY
     stockCount   | int         | Y		      | SKU库存
     
     
     
## 11. <a name='queryEcGoodNeckSkuPropertiesFromWX'></a> 查询所有私人定制属性信息: [返回顶部](#index)

>1.接口信息<br>

>     协议      | 请求方式           | 请求地址        
     ------------- | ---------------| --------------  
     HTTP          | get        |  http://wangjs.iego.net/yzfs-weixin/good/api/queryEcGoodNeckSkuPropertiesFromWX     

>2.请求参数<br>

>     参数名称      | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     token          | String        | Y               | 识别身份的秘钥
     spuId          | String        | Y               | 商品ID


>3.返回值,如下


>     英文名       | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     code          | String        | Y               | 状态码 100：成功、403：未登录、200:暂无数据 ，404:系统异常
     message       | String        | N               | 成功或错误的消息提示，错误时可用做弹窗提示
     data          |List           |Y                |返回接口数据名称
     

>4.data数据格式如下

>     英文名              | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     neckLine           | int        | Y		      | 领口列表
     neckFabric       | String        | Y		      | 布料列表
         
     
>5.neckLine数据格式如下

>     英文名              | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     id           | int        | Y		      | ID
     neckName       | String        | Y		      | 名称  如V领
     picKey       | String        | Y		      |图片key
     
>6.neckFabric数据格式如下

>     英文名              | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     id           | int        | Y		      | ID
     fabricName       | String        | Y		      | 名称  如丝绸
     picKey       | String        | Y		      |图片key
     
     
## 12. <a name='queryEcGoodNeckSkuFromWX'></a> 根据商品ID和组合sku编码查询商品SKU信息: [返回顶部](#index)

>1.接口信息<br>

>     协议      | 请求方式           | 请求地址        
     ------------- | ---------------| --------------  
     HTTP        | get      |  http://wangjs.iego.net/yzfs-weixin/good/api/queryEcGoodNeckSkuFromWX        

>2.请求参数<br>

>     参数名称      | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     token          | String        | Y               | 识别身份的秘钥
     skuCode          | String        | Y               | sku编码
     id          | String        | Y               | 商品ID


>3.返回值,如下


>     英文名       | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     code          | String        | Y               | 状态码 100：成功、403：未登录、200:暂无数据 ，404:系统异常
     message       | String        | N               | 成功或错误的消息提示，错误时可用做弹窗提示
     data          |List           |Y                |返回接口数据名称
     

>4.data数据格式如下

>     英文名              | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     id           | int        | Y		      | ID
     spuId       | String        | Y		      | 商品ID
     spuCode     | String        | Y		      | 商品编码
     skuCode   | String         | Y		      | SKU编码
     skuName   | String         | Y		      | SKU名称
     salePrice   | decimal         | Y		      | 加价
     
## 13. <a name='addCart'></a> 加入购物车: [返回顶部](#index)

>1.接口信息<br>

>     协议      | 请求方式           | 请求地址        
     ------------- | ---------------| --------------  
     HTTP        | get      |  http://wangjs.iego.net/yzfs-weixin/cart/api/addCart   

>2.请求参数<br>

>     参数名称      | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     token          | String        | Y               | 识别身份的秘钥
     skuCode          | String        | Y               | sku编码
     neckSkuCode          | String        | Y               | 定制sku编码
     id          | String        | Y               | 商品ID
     number          | int        | Y               | 商品数量
     isMade          | Boolean        | Y               | 是否私人订制:1 是（true）   0： 否(false)


>3.返回值,如下


>     英文名       | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     code          | String        | Y               | 状态码 100：成功、403：未登录、200:暂无数据 ，404:系统异常
     message       | String        | N               | 成功或错误的消息提示，错误时可用做弹窗提示
     

>4.code返回编码以及提示内容

>     英文名（code编码）              | 提示   （message内容）     
     ------------- | ---------------
     100           | 成功添加购物车     
     200       | 添加购物车失败!
     300     | 库存不足     
     404   | message  
     
## 13-1. <a name='buyNow'></a> 立即购买: [返回顶部](#index)

>1.接口信息<br>

>     协议      | 请求方式           | 请求地址        
     ------------- | ---------------| --------------  
     HTTP        | post      |  http://wangjs.iego.net/yzfs-weixin/order/api/buyNow   

>2.请求参数<br>

>     参数名称      | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     token          | String        | Y               | 识别身份的秘钥
     skuCode          | String        | Y               | sku编码
     neckSkuCode          | String        | Y               | 定制sku编码
     goodId          | String        | Y               | 商品ID
     isMade          | int        | Y               | 是否私人订制:1 是   0： 否


>3.返回值,如下


>     英文名       | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     code          | String        | Y               | 状态码 100：成功、403：未登录、200:暂无数据 ，404:系统异常
     message       | String        | N               | 成功或错误的消息提示，错误时可用做弹窗提示
     data       | String        | N               | 数据
     
>4.data数据格式如下

>     英文名              | 类型           | 是否必须        | 备注
     -------------| --------------| ------------| -------------
     itemId          | String        | Y               | ID
     

>5.code返回编码以及提示内容

>     英文名（code编码）              | 提示   （message内容）     
     ------------- | ---------------
     100           | 成功     
     200       |异常!
     300     | 库存不足     
     404   | 参数错误 
     
## 14. <a name='listCart'></a> 购物车查询: [返回顶部](#index)

>1.接口信息<br>

>     协议      | 请求方式           | 请求地址        
     ------------- | ---------------| --------------  
     HTTP        | get      |  http://wangjs.iego.net/yzfs-weixin/cart/api/listCart    

>2.请求参数<br>

>     参数名称      | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     token          | String        | Y               | 识别身份的秘钥


>3.返回值,如下


>     英文名       | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     code          | String        | Y               | 状态码 100：成功、403：未登录、200:暂无数据 ，404:系统异常
     message       | String        | N               | 成功或错误的消息提示，错误时可用做弹窗提示
     data          |List           |Y                |返回接口数据名称
     
>3.data数据格式如下

>     英文名              | 类型           | 是否必须        | 备注
     -------------| --------------| ------------| -------------
     id           | String        | Y		      | ID
     containerId           | String        | Y		      | 购物车ID
     isMade           | Boolean        | Y		      | 是否可改装 true  可改装; false 不可改装
     quantity           | int        | Y		      | 商
     salePrice       | decimal        | Y		      | 默认SKU销售价
     farePrice       | decimal        | Y		      | 加价
     skuProperties       | String        | Y		      | 商品SKU属性名称
     picKey       | String        | Y		      | 商品SKU图片
     neckProperties       | String        | Y		      | 商品定制SKU属性名称
     neckPickey       | String        | Y		      | 商品定制SKU图片
     skuCode       | String        | Y		      | 商品SKU组合编码
     spuCode       | String        | Y		      | 商品编码
     
## 14-1. <a name='queryCartNumber'></a> 购物车数量查询: [返回顶部](#index)

>1.接口信息<br>

>     协议      | 请求方式           | 请求地址        
     ------------- | ---------------| --------------  
     HTTP        | get      |  http://wangjs.iego.net/yzfs-weixin/cart/api/queryCartNumber    

>2.请求参数<br>

>     参数名称      | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     token          | String        | Y               | 识别身份的秘钥


>3.返回值,如下


>     英文名       | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     code          | String        | Y               | 状态码 100：成功、403：未登录、200:暂无数据 ，404:系统异常
     message       | String        | N               | 成功或错误的消息提示，错误时可用做弹窗提示
     data          |int           |Y                | 购物车数量或者异常message
     
     
## 15. <a name='addAndSub'></a> 购物车数量加减: [返回顶部](#index)

>1.接口信息<br>

>     协议      | 请求方式           | 请求地址        
     ------------- | ---------------| --------------  
     HTTP        | get      |  http://wangjs.iego.net/yzfs-weixin/cart/api/addAndSub

>2.请求参数<br>

>     参数名称      | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     token          | String        | Y               | 识别身份的秘钥
     id          | String        | Y               | 购物车明细ID
     number          | int        | Y               | 增加数量
     


>3.返回值,如下


>     英文名       | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     code          | String        | Y               | 状态码 100：成功、403：未登录、200:暂无数据 ，404:系统异常
     message       | String        | N               | 成功或错误的消息提示，错误时可用做弹窗提示
     data          |List           |Y                |返回接口数据名称
     
>3.data数据格式如下

>     英文名（code编码）              | 提示   （message内容）     
     ------------- | ---------------
     100           | 成功
     404   | message  
     isContinueAddAndSub | false 购物车加号不可加  或者减号不可减
     
## 16. <a name='deleteCartById'></a>  删除购物车商品: [返回顶部](#index)

>1.接口信息<br>

>     协议      | 请求方式           | 请求地址        
     ------------- | ---------------| --------------  
     HTTP        | get      |  http://wangjs.iego.net/yzfs-weixin/cart/api/deleteCartById

>2.请求参数<br>

>     参数名称      | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     token          | String        | Y               | 识别身份的秘钥
     itemId          | String        | Y               | 已选择的商品ID(拼装购物车ID,中间用逗号分隔)
     


>3.返回值,如下


>     英文名       | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     code          | String        | Y               | 状态码 100：成功、403：未登录、200:暂无数据 ，404:系统异常
     message       | String        | N               | 成功或错误的消息提示，错误时可用做弹窗提示
     data          |List           |Y                |返回接口数据名称
     
>3.data数据格式如下

>     英文名（code编码）              | 提示   （message内容）     
     ------------- | ---------------
     100           | 成功
     200   | 失败  
     404 | Parameter is not legal
     
## 17. <a name='settlement'></a>  去结算: [返回顶部](#index)

>1.接口信息<br>

>     协议      | 请求方式           | 请求地址        
     ------------- | ---------------| --------------  
     HTTP        | get      |  http://wangjs.iego.net/yzfs-weixin/order/api/settlement

>2.请求参数<br>

>     参数名称      | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     token          | String        | Y               | 识别身份的秘钥
     itemId          | String        | Y               | 已选择的商品ID(拼装购物车ID,中间用逗号分隔)
     


>3.返回值,如下


>     英文名       | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     data          |List           |Y                |返回接口数据名称
     
>3.data数据格式如下

>     英文名              | 类型           | 是否必须        | 备注
     -------------| --------------| ------------| -------------
     code          | String        | Y               | 状态码 100：成功、403：未登录、200:暂无数据 ，404:系统异常
     message       | String        | N               | 成功或错误的消息提示，错误时可用做弹窗提示
     data          |List           |Y                |返回接口数据名称
  
>4.data数据格式如下

>     英文名              | 类型           | 是否必须        | 备注
     -------------| --------------| ------------| -------------
     address          | 实体类        | Y               | 默认地址信息
     shippingFree       | decimal        | Y              |运费
     orderAmount          |decimal           |Y                |商品总金额
     deductAmount          |int           |Y                |T金兑换金额
     deductAmount          |int           |Y                |T金兑换金额
     accountAmount          |decimal           |Y                |账户余额
     accountPoints          |int           |Y                |账户T金
     sumAmount          |decimal           |Y                |订单总金额 =商品总金额+运费-T金兑换金额
     orderItemList          |List           |Y                |商品信息列表
     
>4.address数据格式如下

>     英文名              | 类型           | 是否必须        | 备注
     -------------| --------------| ------------| -------------
     id          | String        | Y               | 默认地址ID
     shippingName       | String        | Y              |联系人
     pId          |int           |Y                |省份ID
     cId          |int           |Y                |城市ID
     dId          |int           |Y                |区域ID
     pName          |String           |Y                |省份名称
     cName          |String           |Y                |城市名称
     dName         |String           |Y                |区域名称
     shippingAddress      |String           |Y                |详细地址
     mobile          |String           |Y                |手机号码
     userId          |String           |Y                |用户ID
     isDefault          |Boolean           |Y                |是否默认地址
     
>4.orderItemList数据格式如下

>     英文名              | 类型           | 是否必须        | 备注
     -------------| --------------| ------------| -------------
     id          | String        | Y               | 默认地址信息
     containerId       | String        | Y              |购物车ID或者订单ID
     isMade          |Boolean           |Y                |是否私人订制  0 非私人订制  1 私人订制
     goodId          |String           |Y                |商品ID
     skuCode          |String           |Y                |商品SKU编码
     neckSkuCode          |String           |Y                |可改装SKU编码
     stockCount          |int           |Y                |库存
     goodSpecId          |int           |Y                |订单商品SKU属性
     goodNeckId          |int           |Y                |订单商品可改装SKU属性
     goodName          |String           |Y                |商品名称
     picKey          |String           |Y                |商品图片
     spuCode          |String           |Y                |商品编码
     skuProperties          |String           |Y                |SKU属性名称
     neckProperties          |String           |Y                |可改装SKU属性名称
     salePrice          |decimal           |Y                |销售价格
     farePrice          |decimal           |Y                |私人订制加价
     quantity          |int           |Y                |数量
     
     
## 18. <a name='queryAddressList'></a> 查询用户地址列表: [返回顶部](#index)

>1.接口信息<br>

>     协议      | 请求方式           | 请求地址        
     ------------- | ---------------| --------------  
     HTTP        | get      |  http://wangjs.iego.net/yzfs-weixin/address/api/queryAddressList   

>2.请求参数<br>

>     参数名称      | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     token          | String        | Y               | 识别身份的秘钥


>3.返回值,如下


>     英文名       | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     code          | String        | Y               | 状态码 100：成功、403：未登录、200:暂无数据 ，404:系统异常
     message       | String        | N               | 成功或错误的消息提示，错误时可用做弹窗提示
     data          |List           |Y                |返回接口数据名称
     
>3.data数据格式如下

>     英文名              | 类型           | 是否必须        | 备注
     -------------| --------------| ------------| -------------
     id          | String        | Y               | 默认地址ID
     shippingName       | String        | Y              |联系人
     pId          |int           |Y                |省份ID
     cId          |int           |Y                |城市ID
     dId          |int           |Y                |区域ID
     shippingAddress      |String           |Y                |详细地址
     mobile          |String           |Y                |手机号码
     userId          |String           |Y                |用户ID
     isDefault          |Boolean           |Y                |是否默认地址
     
## 19. <a name='queryAddressById'></a> 根据ID查询地址信息: [返回顶部](#index)

>1.接口信息<br>

>     协议      | 请求方式           | 请求地址        
     ------------- | ---------------| --------------  
     HTTP        | get      |  http://wangjs.iego.net/yzfs-weixin/address/api/queryAddressById   

>2.请求参数<br>

>     参数名称      | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     token          | String        | Y               | 识别身份的秘钥
     id          | String        | Y               | 地址ID


>3.返回值,如下


>     英文名       | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     code          | String        | Y               | 状态码 100：成功、403：未登录、200:暂无数据 ，404:系统异常
     message       | String        | N               | 成功或错误的消息提示，错误时可用做弹窗提示
     data          |List           |Y                |返回接口数据名称
     
>3.data数据格式如下

>     英文名              | 类型           | 是否必须        | 备注
     -------------| --------------| ------------| -------------
     id          | String        | Y               | 默认地址ID
     shippingName       | String        | Y              |联系人
     pId          |int           |Y                |省份ID
     cId          |int           |Y                |城市ID
     dId          |int           |Y                |区域ID
     shippingAddress      |String           |Y                |详细地址
     mobile          |String           |Y                |手机号码
     userId          |String           |Y                |用户ID
     isDefault          |Boolean           |Y                |是否默认地址
     
     
## 20. <a name='uddateAddressById'></a>  修改或者新增地址信息: [返回顶部](#index)

>1.接口信息<br>

>     协议      | 请求方式           | 请求地址        
     ------------- | ---------------| --------------  
     HTTP        | get      |  http://wangjs.iego.net/yzfs-weixin/address/api/uddateAddressById

>2.请求参数<br>

>     参数名称      | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     token          | String        | Y               | 识别身份的秘钥
     id          | String        | N               | 新增该值为空 ， 修改 带ID值
     shippingName       | String        | Y              |联系人
     pId          |int           |Y                |省份ID
     cId          |int           |Y                |城市ID
     dId          |int           |Y                |区域ID
     itemAddress      |String           |Y                |详细地址
     mobile          |String           |Y                |手机号码
     userId          |String           |Y                |用户ID
     isDefault          |Boolean           |Y                |是否默认地址
     


>3.返回值,如下


>     英文名       | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     code          | String        | Y               | 状态码 100：成功、403：未登录、200:暂无数据 ，404:系统异常
     message       | String        | N               | 成功或错误的消息提示，错误时可用做弹窗提示
     
>3.data数据格式如下

>     英文名（code编码）              | 提示   （message内容）     
     ------------- | ---------------
     100           | 成功
     200   | 参数不合法  
     403 | 未登录 
     404 | Parameter is not legal  
     
## 21. <a name='setAddressIsDefault'></a>  设置为默认地址: [返回顶部](#index)

>1.接口信息<br>

>     协议      | 请求方式           | 请求地址        
     ------------- | ---------------| --------------  
     HTTP        | get      |  http://wangjs.iego.net/yzfs-weixin/address/api/setAddressIsDefault

>2.请求参数<br>

>     参数名称      | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     token          | String        | Y               | 识别身份的秘钥
     id          | String        | N               | 新增该值为空 ， 修改 带ID值


>3.返回值,如下


>     英文名       | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     code          | String        | Y               | 状态码 100：成功、403：未登录、200:暂无数据 ，404:系统异常
     message       | String        | N               | 成功或错误的消息提示，错误时可用做弹窗提示
     
>3.data数据格式如下

>     英文名（code编码）              | 提示   （message内容）     
     ------------- | ---------------
     100           | 成功
     200   | 参数不合法  
     403 | 未登录 
     404 | Parameter is not legal  
     
## 22. <a name='deleteAddressById'></a>  根据ID删除地址: [返回顶部](#index)

>1.接口信息<br>

>     协议      | 请求方式           | 请求地址        
     ------------- | ---------------| --------------  
     HTTP        | get      |  http://wangjs.iego.net/yzfs-weixin/address/api/deleteAddressById

>2.请求参数<br>

>     参数名称      | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     token          | String        | Y               | 识别身份的秘钥
     id          | String        | N               | 新增该值为空 ， 修改 带ID值


>3.返回值,如下


>     英文名       | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     code          | String        | Y               | 状态码 100：成功、403：未登录、200:暂无数据 ，404:系统异常
     message       | String        | N               | 成功或错误的消息提示，错误时可用做弹窗提示
     
>3.data数据格式如下

>     英文名（code编码）              | 提示   （message内容）     
     ------------- | ---------------
     100           | 成功
     200   | 参数不合法  
     403 | 未登录 
     404 | 系统异常  
     
     
## 23. <a name='saveOrder'></a>  提交订单: [返回顶部](#index)

>1.接口信息<br>

>     协议      | 请求方式           | 请求地址        
     ------------- | ---------------| --------------  
     HTTP        | post      |  http://wangjs.iego.net/yzfs-weixin/order/api/saveOrder

>2.请求参数<br>

>     参数名称      | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     token          | String        | Y               | 识别身份的秘钥
     JSON格式传入          | 消息包        | Y               |body消息参数
     
>2.参数实例<br>

>     参数名称      | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     payPasswd          | String        | Y               | 支付密码
     payType          | int      | Y               |支付类型     1微信支付  2余额支付
     addressId          | String       | Y               |地址ID 
     itemId          | String        | Y               |商品详情ID,逗号分隔 
     isUsePoints          | int       | Y               |是否使用T金  0 不使用  1 使用
     remark          |String        | N              |备注


>3.返回值,如下


>     英文名       | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     code          | String        | Y               | 状态码 
     message       | String        | N               | 成功或错误的消息提示，错误时可用做弹窗提示
     
>3.code编码如下

>     英文名（code编码）              | 提示   （message内容）     
     ------------- | ---------------
     100           | 成功
     200   | 参数错误
     401   | 未设置支付密码
     402 | 未注册
     403 | 未登录
	 404 | 系统异常
	 405 | 未设置支付密码  
	 406 | 未选择地址   
	 
>4.code==100返回参数

>     英文名              | 类型           | 是否必须        | 备注
     -------------| --------------| ------------| -------------
     code          |int        | Y               | code编码 100
     data          |List         | Y               | 微信支付，存放微信支付参数，余额支付为空
     payNo          |String         | Y               | 订单流水号，微信支付时该值为空  余额支付不为空
     payMethod          |int        | Y               | 支付方式  1 微信支付  2 余额支付
     message          |String        | Y               | 消息
     
>3.data返回参数

>     英文名              | 类型           | 是否必须        | 备注
     -------------| --------------| ------------| -------------
     appId          |String        | Y               | 微信支付分配的公众账号ID
     timeStamp          |String         | Y               | 时间戳，自1970年以来的秒数     
     nonceStr          |String         | Y               | 随机串     
     signType          |String        | Y               | 微信签名方式
     paySign          |String        | Y               | 支付签名
     package2          |String        | Y               |   package: '', // 统一支付接口返回的prepay_id参数值，提交格式如：prepay_id=***）
     
     
## 23-1. <a name='balaceCallBack'></a>  余额支付回掉: [返回顶部](#index)

>1.接口信息<br>

>     协议      | 请求方式           | 请求地址        
     ------------- | ---------------| --------------  
     HTTP        | post      |  http://wangjs.iego.net/yzfs-weixin/core/auth/balaceCallBack

>2.请求参数<br>

>     参数名称      | 类型           | 是否必须        | 备注(参数以JSON格式传入)
     ------------- | ---------------| --------------  | -------------
     token          | String        | Y               | 识别身份的秘钥
     payNo          | String        | Y               | 下单流水号

	 
## 24. <a name='register'></a>  注册: [返回顶部](#index)

>1.接口信息<br>

>     协议      | 请求方式           | 请求地址        
     ------------- | ---------------| --------------  
     HTTP        | post      |  http://wangjs.iego.net/yzfs-weixin/register/api/register

>2.请求参数<br>

>     参数名称      | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     token          | String        | Y               | 识别身份的秘钥
     mobile          | String        | Y               | 手机号码
	 regCode          | String        | Y               | 手机号码验证码
	 pOpenid          | String        | Y               | 分享人的openid


>3.返回值,如下


>     英文名       | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     code          | String        | Y               | 状态码 
     message       | String        | N               | 成功或错误的消息提示，错误时可用做弹窗提示
     
>3.data数据格式如下

>     英文名（code编码）              | 提示   （message内容）     
     ------------- | ---------------
     100           | 注册成功
     200   | 手机号码已经注册
     1004   | 手机号码不合法	 
     3001 | 手机验证码过期
     3002 | 手机验证码为空 
	 3003 | 手机验证码错误 
	 404 | 系统异常  

## 24-1. <a name='sendSmsCode'></a>  发送短信验证码: [返回顶部](#index)

>1.接口信息<br>

>     协议      | 请求方式           | 请求地址        
     ------------- | ---------------| --------------  
     HTTP        | post      |  http://wangjs.iego.net/yzfs-weixin/core/auth/sendSmsCode

>2.请求参数<br>

>     参数名称      | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     token          | String        | Y               | 识别身份的秘钥
     mobile          | String        | Y               | 手机号码


>3.返回值,如下


>     英文名       | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     code          | String        | Y               | 状态码 100：成功、403：未登录、200:暂无数据 ，404:系统异常
     message       | String        | N               | 成功或错误的消息提示，错误时可用做弹窗提示
     
>3.data数据格式如下

>     英文名（code编码）              | 提示   （message内容）     
     ------------- | ---------------
     100           | 发送成功
     200   | 手机号码已经注册
     1004   | 手机号码不合法	 
     404 | 系统异常  
	 
## 25. <a name='savePaypasswd'></a>  保存支付密码: [返回顶部](#index)

>1.接口信息<br>

>     协议      | 请求方式           | 请求地址        
     ------------- | ---------------| --------------  
     HTTP        | post      |  http://wangjs.iego.net/yzfs-weixin/register/api/savePaypasswd

>2.请求参数<br>

>     参数名称      | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     token          | String        | Y               | 识别身份的秘钥
     password          | MD5加密        | N               | MD5加密的支付密码


>3.返回值,如下


>     英文名       | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     code          | String        | Y               | 状态码 
     message       | String        | N               | 成功或错误的消息提示，错误时可用做弹窗提示
     
>3.data数据格式如下

>     英文名（code编码）              | 提示   （message内容）     
     ------------- | ---------------
     100           | 注册成功
     404   | 系统异常

 
## 26. <a name='myCenter'></a>  个人中心]: [返回顶部](#index)

>1.接口信息<br>

>     协议      | 请求方式           | 请求地址        
     ------------- | ---------------| --------------  
     HTTP        | get      |  http://wangjs.iego.net/yzfs-weixin/center/api/myCenter

>2.请求参数<br>

>     参数名称      | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     token          | String        | Y               | 识别身份的秘钥
     
>3.返回值,如下


>     英文名       | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     code          | String        | Y               | 状态码 100：成功、403：未登录、200:暂无数据 ，404:系统异常
     message       | String        | N               | 成功或错误的消息提示，错误时可用做弹窗提示
     data          |List           |Y                |返回接口数据名称
     
>3.data数据格式如下

>     英文名              | 类型           | 是否必须        | 备注
     -------------| --------------| ------------| -------------
     user          | 实体类        | Y               | 用户信息
     orderCount       | 实体类        | Y              |订单状态信息
     
>3.user数据格式如下

>     英文名              | 类型           | 是否必须        | 备注
     -------------| --------------| ------------| -------------
     nickName          | String        | Y               | 用户昵称
     sex          | String        | Y               | 用户性别  0 女  1男
     headImg          | String        | Y               | 用户头像
     accountAmount          | String        | Y               | 账户余额
     accountPoints          | String        | Y               | 账户T金
   
>4.orderCount数据格式如下

>     英文名              | 类型           | 是否必须        | 备注
     -------------| --------------| ------------| -------------
     unPay          |int        | Y               | 待支付订单数量
     waitShipping          |int        | Y               | 待发货订单数量
     waitReceipt          |int        | Y               | 待收货订单数量
     waitEvaluate          |int        | Y               | 待评价订单
     cartNumber          |int        | Y               | 购物车数量
	 
## 27. <a name='ordreList'></a>  我的订单列表]: [返回顶部](#index)

>1.接口信息<br>

>     协议      | 请求方式           | 请求地址        
     ------------- | ---------------| --------------  
     HTTP        | POST      |  http://wangjs.iego.net/yzfs-weixin/center/api/ordreList

>2.请求参数<br>

>     参数名称      | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     token          | String        | Y               | 识别身份的秘钥
	 ordreStatus          | int        | Y               | 订单状态
	 pageIndex          | int        | Y               | 当前页数
	 pageSize          | int        | Y               | 每页行数
     
>3.返回值,如下


>     英文名       | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     code          | String        | Y               | 状态码 100：成功、403：未登录、200:暂无数据 ，404:系统异常
     message       | String        | N               | 成功或错误的消息提示，错误时可用做弹窗提示
     data          |List           |Y                |返回接口数据名称
     
>3.data数据格式如下

>     英文名              | 类型           | 是否必须        | 备注
     -------------| --------------| ------------| -------------
     orderCount          | 实体类        | Y               | 各个状态订单数量
     orderList       | 实体类        | Y              |订单信息包括商品明细
  
>3.orderCount数据格式如下

>     英文名              | 类型           | 是否必须        | 备注
     -------------| --------------| ------------| -------------
     unPay          |int        | Y               | 待支付订单数量
     waitShipping          |int        | Y               | 待发货订单数量
     waitReceipt          |int        | Y               | 待收货订单数量
     waitEvaluate          |int        | Y               | 待评价订单
     cartNumber          |int        | Y               | 购物车数量   
     
>4.orderList数据格式如下

>     英文名              | 类型           | 是否必须        | 备注
     -------------| --------------| ------------| -------------
     id          | String        | Y               | 用户昵称
     shippingFee          | String        | Y               | 运费
     orderAmount          | String        | Y               | 商品总金额
     payPoints          | String        | Y               | 积分抵扣金额
     payAmount          | String        | Y               | 实际支付金额
     sumQuantity          | int        | Y               | 订单总数量
     payType          | String        | Y               | 支付类型: 1微信支付，2余额支付，3积分支付，4支付宝
     orderStatus          | String        | Y               | 订单状态
     orderItems          | List        | Y               | 商品明细
   
>5.orderItems数据格式如下

>     英文名              | 类型           | 是否必须        | 备注
     -------------| --------------| ------------| -------------
     id          | String        | Y               | 商品明细ID
     isMade          | Boolean        | Y               | 是否私人订制  true  是  false 否
     goodName          | String        | Y               |商品名称
     picKey          | String        | Y               | 商品图片KEY
     skuProperties          | String        | Y               | sku名称
     neckProperties          | String        | Y               | 私人订制布料名称
     salePrice          | decimal        | Y               | 销售价格
     farePrice          | decimal        | Y               | 加价
     quantity          | int        | Y               | 数量
     refundsStatus          | int        | Y               | 退款状态
     
## 27-1. <a name='orderItemById'></a> 根据订单ID查询我的订单详情]: [返回顶部](#index)

>1.接口信息<br>

>     协议      | 请求方式           | 请求地址        
     ------------- | ---------------| --------------  
     HTTP        | GET      |  http://wangjs.iego.net/yzfs-weixin/center/api/orderItemById

>2.请求参数<br>

>     参数名称      | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
      token          | String        | Y               | 识别身份的秘钥
	  orderId          | String         | Y               | 订单ID
     
>3.返回值,如下


>     英文名       | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     code          | String        | Y               | 状态码 100：成功、403：未登录、200:暂无数据 ，404:系统异常
     message       | String        | N               | 成功或错误的消息提示，错误时可用做弹窗提示
     data          |List           |Y                |返回接口数据名称
     
>3.data数据格式如下

>     英文名              | 类型           | 是否必须        | 备注
     -------------| --------------| ------------| -------------
     id          | String        | Y               | 订单ID
     ownerId          | String        | Y               | 用户ID
     orderType          | String        | Y               | 订单类型 0单店铺订单，1多店铺订单
     orderNo          | String        | Y               | 订单号
     shippingName          | String        | Y               | 收货人
     pName          | String        | Y               | 省份
     cName          | String        | Y               | 城市
     dName          | String        | Y               | 地区
     shippingAddress          | String        | Y               | 详细地址
     mobile          | String        | Y               | 用户手机
     shippingFee          | decimal        | Y               | 运费
     orderAmount          | decimal        | Y               | 商品总金额
     payPoints          | int        | Y               | 积分抵扣金额
     payAmount          | decimal        | Y               | 实际支付金额
     payType          | int        | Y               | 支付类型: 1微信支付，2余额支付，3积分支付，4支付宝
     orderStatus          | int        | Y               | 订单状态
     userComments          | String        | Y               | 购买留言备注
     createdAt          | date        | Y               | 下单时间
     payAt          | date        | Y               | 支付时间
     settledAt          | date        | Y               | 关闭时间
     orderItems          | List        | Y               | 订单商品明细
     
>3.orderItems数据格式如下

>     英文名              | 类型           | 是否必须        | 备注
     -------------| --------------| ------------| -------------
     id          | String        | Y               | ID
     containerId       | String        | Y              |购物车ID或者订单ID
     isMade          |Boolean           |Y                |是否私人订制  0 非私人订制  1 私人订制
     goodId          |String           |Y                |商品ID
     skuCode          |String           |Y                |商品SKU编码
     neckSkuCode          |String           |Y                |可改装SKU编码
     stockCount          |int           |Y                |库存
     goodSpecId          |int           |Y                |订单商品SKU属性
     goodNeckId          |int           |Y                |订单商品可改装SKU属性
     goodName          |String           |Y                |商品名称
     picKey          |String           |Y                |商品图片
     spuCode          |String           |Y                |商品编码
     skuProperties          |String           |Y                |SKU属性名称
     neckProperties          |String           |Y                |可改装SKU属性名称
     salePrice          |decimal           |Y                |销售价格
     farePrice          |decimal           |Y                |私人订制加价
     quantity          |int           |Y                |数量
   
     
## 27-2. <a name='goPay'></a>  立即支付]: [返回顶部](#index)

>1.接口信息<br>

>     协议      | 请求方式           | 请求地址        
     ------------- | ---------------| --------------  
     HTTP        | post      |  http://wangjs.iego.net/yzfs-weixin/order/api/goPay

>2.请求参数<br>

>     参数名称      | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     token          | String        | Y               | 识别身份的秘钥
     orderId          | String        | Y               | 订单ID
     
>4.返回参数

>     英文名              | 类型           | 是否必须        | 备注
     -------------| --------------| ------------| -------------
     code          |int        | Y               | code编码 100
     data          |List         | Y               | 微信支付，存放微信支付参数，余额支付为空
     payNo          |String         | Y               | 订单流水号，微信支付时该值为空  余额支付不为空
     payMethod          |int        | Y               | 支付方式  1 微信支付  2 余额支付
     message          |String        | Y               | 消息
     
>5.data返回参数

>     英文名              | 类型           | 是否必须        | 备注
     -------------| --------------| ------------| -------------
     appId          |String        | Y               | 微信支付分配的公众账号ID
     timeStamp          |String         | Y               | 时间戳，自1970年以来的秒数     
     nonceStr          |String         | Y               | 随机串     
     signType          |String        | Y               | 微信签名方式
     paySign          |String        | Y               | 支付签名
     
## 27-3. <a name='cancleOrder'></a>  取消订单: [返回顶部](#index)

>1.接口信息<br>

>     协议      | 请求方式           | 请求地址        
     ------------- | ---------------| --------------  
     HTTP        | post      |  http://wangjs.iego.net/yzfs-weixin/order/api/cancleOrder

>2.请求参数<br>

>     参数名称      | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     token          | String        | Y               | 识别身份的秘钥
     orderId          | String        | Y              | 订单ID


>3.返回值,如下


>     英文名       | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     code          | String        | Y               | 状态码 
     message       | String        | Y              | 成功或错误的消息提示，错误时可用做弹窗提示
     data       | String        | Y               | 如果状态为已支付，并且是微信支付，返回data参数
     
>4.data返回参数

>     英文名              | 类型           | 是否必须        | 备注
     -------------| --------------| ------------| -------------
     appId          |String        | Y               | 微信支付分配的公众账号ID
     timeStamp          |String         | Y               | 时间戳，自1970年以来的秒数     
     nonceStr          |String         | Y               | 随机串     
     signType          |String        | Y               | 微信签名方式
     paySign          |String        | Y               | 支付签名
     
## 27-4. <a name='confirmReceipt'></a>  确认收货: [返回顶部](#index)

>1.接口信息<br>

>     协议      | 请求方式           | 请求地址        
     ------------- | ---------------| --------------  
     HTTP        | post      |  http://wangjs.iego.net/yzfs-weixin/order/api/confirmReceipt

>2.请求参数<br>

>     参数名称      | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     token          | String        | Y               | 识别身份的秘钥
     orderId          | String        | Y              | 订单ID


>3.返回值,如下


>     英文名       | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     code          | String        | Y               | 状态码 
     message       | String        | Y              | 成功或错误的消息提示，错误时可用做弹窗提示
     data       | String        | Y               | 如果状态为已支付，并且是微信支付，返回data参数
     
>3.data返回参数

>     英文名（code编码）              | 提示   （message内容）     
     ------------- | ---------------
     100           | 成功
     1001   | 已经收货
     404   | 参数错误
     
## 27-5. <a name='queryOrderItemInfoById'></a> 申请售后根据订单明细ID查询订单信息]: [返回顶部](#index)

>1.接口信息<br>

>     协议      | 请求方式           | 请求地址        
     ------------- | ---------------| --------------  
     HTTP        | get      |  http://wangjs.iego.net/yzfs-weixin/order/api/queryOrderItemInfoById

>2.请求参数<br>

>     参数名称      | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
      token          | String        | Y               | 识别身份的秘钥
	  itemId          | String         | Y               | 订单明细ID
     
>3.返回值,如下


>     英文名       | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     code          | String        | Y               | 状态码 100：成功、403：未登录、200:暂无数据 ，404:系统异常
     message       | String        | N               | 成功或错误的消息提示，错误时可用做弹窗提示
     data          |List           |Y                |返回接口数据名称
     
>3.data数据格式如下

>     英文名              | 类型           | 是否必须        | 备注
     -------------| --------------| ------------| -------------
     id          | String        | Y               | 默认地址信息
     containerId       | String        | Y              |购物车ID或者订单ID
     isMade          |Boolean           |Y                |是否私人订制  0 非私人订制  1 私人订制
     goodName          |String           |Y                |商品名称
     picKey          |String           |Y                |商品图片
     spuCode          |String           |Y                |商品编码
     skuProperties          |String           |Y                |SKU属性名称
     neckProperties          |String           |Y                |可改装SKU属性名称
     quantity          |int           |Y                |数量
     salePrice          |decimal           |Y                |销售价格
     farePrice          |decimal           |Y                |私人订制加价

                    
## 27-6. <a name='applyReturnOrder'></a> 申请售后: [返回顶部](#index)

>1.接口信息<br>

>     协议      | 请求方式           | 请求地址        
     ------------- | ---------------| --------------  
     HTTP        | post      |  http://wangjs.iego.net/yzfs-weixin/order/api/applyReturnOrder

>2.请求参数<br>

>     参数名称      | 类型           | 是否必须        | 备注(参数以JSON格式传入)
     ------------- | ---------------| --------------  | -------------
     token          | String        | Y               | 识别身份的秘钥
     itemId          | String        | N               | 订单明细ID
     remark          | String        | N               | 退换货说明
     type          | int         | N               | 类型 0 退款 1换货

>3.返回值,如下


>     英文名       | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     code          | String        | Y               | 状态码 
     message       | String        | N               | 成功或错误的消息提示，错误时可用做弹窗提示
     data       | String        | N               | 成功或错误的消息提示，错误时可用做弹窗提示
     
>3.data数据格式如下

>     英文名（code编码）              | 提示   （message内容）     
     ------------- | ---------------
     100           | 成功
     1001   | 已经提交申请
     404   | 参数错误
     
## 27-7. <a name='goCommentByOrderId'></a> 去评论: [返回顶部](#index)

>1.接口信息<br>

>     协议      | 请求方式           | 请求地址        
     ------------- | ---------------| --------------  
     HTTP        | GET      |  http://wangjs.iego.net/yzfs-weixin/order/api/goCommentByOrderId

>2.请求参数<br>

>     参数名称      | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     token          | String        | Y               | 识别身份的秘钥
     orderId          | String        | N               | 订单ID

>3.返回值,如下


>     英文名       | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     code          | String        | Y               | 状态码 
     message       | String        | N               | 成功或错误的消息提示，错误时可用做弹窗提示
     data       | String        | N               | 成功或错误的消息提示，错误时可用做弹窗提示
     
>3.data数据格式如下

>     英文名              | 类型           | 是否必须        | 备注
     -------------| --------------| ------------| -------------
     id          | String        | Y               | ID
     containerId       | String        | Y              |购物车ID或者订单ID
     isMade          |Boolean           |Y                |是否私人订制  0 非私人订制  1 私人订制
     goodId          |String           |Y                |商品ID
     skuCode          |String           |Y                |商品SKU编码
     neckSkuCode          |String           |Y                |可改装SKU编码
     stockCount          |int           |Y                |库存
     goodSpecId          |int           |Y                |订单商品SKU属性
     goodNeckId          |int           |Y                |订单商品可改装SKU属性
     goodName          |String           |Y                |商品名称
     picKey          |String           |Y                |商品图片
     spuCode          |String           |Y                |商品编码
     skuProperties          |String           |Y                |SKU属性名称
     neckProperties          |String           |Y                |可改装SKU属性名称
     salePrice          |decimal           |Y                |销售价格
     farePrice          |decimal           |Y                |私人订制加价
     quantity          |int           |Y                |数量
     
## 27-8. <a name='saveComment'></a> 保存评论: [返回顶部](#index)

>1.接口信息<br>

>     协议      | 请求方式           | 请求地址        
     ------------- | ---------------| --------------  
     HTTP        | post      |  http://wangjs.iego.net/yzfs-weixin/order/api/saveCommentInfo

>2.请求参数<br>

>     参数名称      | 类型           | 是否必须        | 备注(参数以JSON格式传入)
     ------------- | ---------------| --------------  | -------------
     token          | String        | Y               | 识别身份的秘钥
     content          | String        | N               | 评价内容
     level          | String        | N               | 评论等级
     orderId          | String         | N               | 订单明细ID
     picKey          | String         | N               | 评论图片key,逗号隔开

>3.返回值,如下


>     英文名       | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     code          | String        | Y               | 状态码 
     message       | String        | N               | 成功或错误的消息提示，错误时可用做弹窗提示
     data       | String        | N               | 成功或错误的消息提示，错误时可用做弹窗提示
     
>3.data数据格式如下

>     英文名（code编码）              | 提示   （message内容）     
     ------------- | ---------------
     100           | 成功
     404   | 参数错误
     
     
## 28. <a name='rightsOrdreList'></a> 我的售后列表]: [返回顶部](#index)

>1.接口信息<br>

>     协议      | 请求方式           | 请求地址        
     ------------- | ---------------| --------------  
     HTTP        | post      |  http://wangjs.iego.net/yzfs-weixin/center/api/rightsOrdreList

>2.请求参数<br>

>     参数名称      | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
       token          | String        | Y               | 识别身份的秘钥
	   pageIndex          | int        | Y               | 当前页数
	   pageSize          | int        | Y               | 每页行数
     
>3.返回值,如下


>     英文名       | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     code          | String        | Y               | 状态码 100：成功、403：未登录、200:暂无数据 ，404:系统异常
     message       | String        | N               | 成功或错误的消息提示，错误时可用做弹窗提示
     data          |List           |Y                |返回接口数据名称
     
>3.data数据格式如下

>     英文名              | 类型           | 是否必须        | 备注
     -------------| --------------| ------------| -------------
     id          | String        | Y               | id
     rightsOrderNo       | String        | Y              |维权单号
     createdAt          |Boolean           |Y                |创建时间
     remark          |String           |Y                |下单留言
     type          |String           |Y                |0 退款退货  1换货
     goodName          |String           |Y                |SKU属性名称
     picKey          |String           |Y                |图片
     quantity          |int           |Y                |数量
     skuName          |decimal           |Y                |SKU名称
     salePrice          |decimal           |Y                |销售价
     quantity          |decimal           |Y                |数量
     returnAmount          |decimal           |Y                |退换金额
     refundsStatus          |int           |Y                |退款状态 0未退货，1退款申请，2商家处理中，3退款成功，4待换货5已换货6已拒绝
     orderStatus          |int           |Y                |订单状态 0未付款，1待发货，2待收货，3完成，4已取消，5已评论
     
## 28-1. <a name='rightsOrderItemById'></a> 根据订单ID查询我的售后订单详情]: [返回顶部](#index)

>1.接口信息<br>

>     协议      | 请求方式           | 请求地址        
     ------------- | ---------------| --------------  
     HTTP        | get      |  http://wangjs.iego.net/yzfs-weixin/center/api/rightsOrderItemById

>2.请求参数<br>

>     参数名称      | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
      token          | String        | Y               | 识别身份的秘钥
	  id          | String         | Y               | 退货订单ID
     
>3.返回值,如下


>     英文名       | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     code          | String        | Y               | 状态码 100：成功、403：未登录、200:暂无数据 ，404:系统异常
     message       | String        | N               | 成功或错误的消息提示，错误时可用做弹窗提示
     data          |List           |Y                |返回接口数据名称
     
>3.data数据格式如下

>     英文名              | 类型           | 是否必须        | 备注
     -------------| --------------| ------------| -------------
     id          | String        | Y               | id
     shippingName          | String        | Y               | 收货人
     mobile          | String        | Y               | 手机
     pName          | String        | Y               | 省份名称
     cName          | String        | Y               | 城市名称
     dName          | String        | Y               | 区名称
     shippingAddress          | String        | Y               | 详细地址
     goodName          |String           |Y                |商品名称
     picKey          |String           |Y                |图片
     skuProperties          |String           |Y                |SKU名称
     neckProperties          |String           |Y                |可改装SKU名称
     salePrice          |decimal           |Y                |销售价
     quantity          |int           |Y                |数量
     returnAmount          |decimal           |Y                |退款总金额 
     userComments          |String           |Y                |下单留言
     orderNo          |String           |Y                |订单编号
     orderTime          |date           |Y                |下单时间
     payTime          |date           |Y                |支付时间
     shippingAt          |date           |Y                |发货时间
     receiptAt          |date           |Y                |收货时间
     shippingNo          |String           |Y                |运单号
     shippingVendor          |String           |Y                |快递公司	
     rightsOrderNo       | String        | Y              |维权单号
     createdAt          |date           |Y                |申请时间
     auditAt          |date           |Y                |审核时间
     returnAt          |date           |Y                |完成时间
     remark          |String           |Y                |退款说明
     rejectReason          |String           |Y                |驳回原因
     type          |int           |Y                |0 退款退货  1换货
     refundsStatus          |int           |Y                |退款状态 0未退货，1退款申请，2商家处理中，3退款成功，4待换货5已换货6已拒绝
     orderStatus          |int           |Y                |订单状态  0未付款，1待发货，2待收货，3完成，4已取消，5已评论
     
## 29. <a name='recharge'></a>  查询充值卡类型列表]: [返回顶部](#index)

>1.接口信息<br>

>     协议      | 请求方式           | 请求地址        
     ------------- | ---------------| --------------  
     HTTP        | get      |  http://wangjs.iego.net/yzfs-weixin/center/api/recharge

>2.请求参数<br>

>     参数名称      | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     token          | String        | Y               | 识别身份的秘钥
     
>3.返回值,如下


>     英文名       | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     code          | String        | Y               | 状态码 100：成功、403：未登录、200:暂无数据 ，404:系统异常
     message       | String        | N               | 成功或错误的消息提示，错误时可用做弹窗提示
     data          |List           |Y                |返回接口数据名称
     
>3.data数据格式如下

>     英文名              | 类型           | 是否必须        | 备注
     -------------| --------------| ------------| -------------
     id          | String        | Y               | 充值类型ID
     remark       | String        | Y              |备注
     rechargeAmount       | decimal        | Y              |充值金额
     attachAmount       | decimal        | Y              |送金额
     isUsed       | boolean        | Y              |是否启用 true  启用 false 禁用
     
  
## 30. <a name='saveRecharge'></a>  确认充值]: [返回顶部](#index)

>1.接口信息<br>

>     协议      | 请求方式           | 请求地址        
     ------------- | ---------------| --------------  
     HTTP        | post      |  http://wangjs.iego.net/yzfs-weixin/recharge/api/saveRecharge

>2.请求参数<br>

>     参数名称      | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     token          | String        | Y               | 识别身份的秘钥
     rechargeId          | String        | Y               | 充值套餐ID
     
>4.返回参数

>     英文名              | 类型           | 是否必须        | 备注
     -------------| --------------| ------------| -------------
     code          |int        | Y               | code编码 100
     data          |List         | Y               | 微信支付，存放微信支付参数，余额支付为空
     payNo          |String         | Y               | 订单流水号，微信支付时该值为空  余额支付不为空
     payMethod          |int        | Y               | 支付方式  1 微信支付  2 余额支付
     message          |String        | Y               | 消息
     
>5.data返回参数

>     英文名              | 类型           | 是否必须        | 备注
     -------------| --------------| ------------| -------------
     appId          |String        | Y               | 微信支付分配的公众账号ID
     timeStamp          |String         | Y               | 时间戳，自1970年以来的秒数     
     nonceStr          |String         | Y               | 随机串     
     signType          |String        | Y               | 微信签名方式
     paySign          |String        | Y               | 支付签名
     
   
## 31. <a name='myBalaceRecord'></a> 余额记录]: [返回顶部](#index)

>1.接口信息<br>

>     协议      | 请求方式           | 请求地址        
     ------------- | ---------------| --------------  
     HTTP        | POST      |  http://wangjs.iego.net/yzfs-weixin/center/api/myBalaceRecord

>2.请求参数<br>

>     参数名称      | 类型           | 是否必须        | 备注（参数以JSON格式传入）
     ------------- | ---------------| --------------  | -------------
     token          | String        | Y               | 识别身份的秘钥
     pageIndex          | int        | Y               | 当前页数
     pageSize          | int        | Y               | 每页显示行数
     
     
>3.返回值,如下


>     英文名       | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     code          | String        | Y               | 状态码 100：成功、403：未登录、200:暂无数据 ，404:系统异常
     message       | String        | N               | 成功或错误的消息提示，错误时可用做弹窗提示
     data          |List           |Y                |返回接口数据名称
     
>3.data数据格式如下

>     英文名              | 类型           | 是否必须        | 备注
     -------------| --------------| ------------| -------------
     recordType          | boolean        | Y               | true 收入  false 支出
     changeType          | String        | Y               | 变动类型
     changeAmount          | decimal        | Y               | 账户变化余额
     attachAmount          | decimal        | Y               | 赠送金额
     payAmount          | decimal        | Y               | 实际充值金额
     createdTime       | String        | Y              |时间
     changeNote       | String        | Y              |备注  购买商品返T金

## 32. <a name='myCardLogRecord'></a> T金记录]: [返回顶部](#index)

>1.接口信息<br>

>     协议      | 请求方式           | 请求地址        
     ------------- | ---------------| --------------  
     HTTP        | POST      |  http://wangjs.iego.net/yzfs-weixin/center/api/myCardLogRecord

>2.请求参数<br>

>     参数名称      | 类型           | 是否必须        | 备注（参数以JSON格式传入）
     ------------- | ---------------| --------------  | -------------
     token          | String        | Y               | 识别身份的秘钥
     pageIndex          | int        | Y               | 当前页数
     pageSize          | int        | Y               | 每页显示行数
     
     
>3.返回值,如下


>     英文名       | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     code          | String        | Y               | 状态码 100：成功、403：未登录、200:暂无数据 ，404:系统异常
     message       | String        | N               | 成功或错误的消息提示，错误时可用做弹窗提示
     data          |List           |Y                |返回接口数据名称
     
>3.data数据格式如下

>     英文名              | 类型           | 是否必须        | 备注
     -------------| --------------| ------------| -------------
     recordType          | boolean        | Y               | true 收入  false 支出
     changePoints          | int        | Y               | 变换T金
     createdTime       | String        | Y              |时间
     changeNote       | String        | Y              |备注  购买商品返T金

    
     
## 33. <a name='myCommission'></a> 我的佣金]: [返回顶部](#index)

>1.接口信息<br>

>     协议      | 请求方式           | 请求地址        
     ------------- | ---------------| --------------  
     HTTP        | GET      |  http://wangjs.iego.net/yzfs-weixin/center/api/myCommission

>2.请求参数<br>

>     参数名称      | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     token          | String        | Y               | 识别身份的秘钥
     
>3.返回值,如下


>     英文名       | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     code          | String        | Y               | 状态码 100：成功、403：未登录、200:暂无数据 ，404:系统异常
     message       | String        | N               | 成功或错误的消息提示，错误时可用做弹窗提示
     data          |List           |Y                |返回接口数据名称
     
>3.data数据格式如下

>     英文名              | 类型           | 是否必须        | 备注
     -------------| --------------| ------------| -------------
     amount          | decimal        | Y               | 账户佣金
     todayAmount       | decimal        | Y              |今日所得佣金
     historyAmount       | decimal        | Y              |历史累计佣金
     
## 34. <a name='myCommissionRecord'></a> 佣金记录]: [返回顶部](#index)

>1.接口信息<br>

>     协议      | 请求方式           | 请求地址        
     ------------- | ---------------| --------------  
     HTTP        | POST      |  http://wangjs.iego.net/yzfs-weixin/center/api/myCommissionRecord

>2.请求参数<br>

>     参数名称      | 类型           | 是否必须        | 备注（参数以JSON格式传入）
     ------------- | ---------------| --------------  | -------------
     token          | String        | Y               | 识别身份的秘钥
     recordType          | int        | Y               | 状态   0 支出 1 收入
     pageIndex          | int        | Y               | 当前页数
     pageSize          | int        | Y               | 每页显示行数
     
     
>3.返回值,如下


>     英文名       | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     code          | String        | Y               | 状态码 100：成功、403：未登录、200:暂无数据 ，404:系统异常
     message       | String        | N               | 成功或错误的消息提示，错误时可用做弹窗提示
     data          |List           |Y                |返回接口数据名称
     
>3.data数据格式如下

>     英文名              | 类型           | 是否必须        | 备注
     -------------| --------------| ------------| -------------
     recordType          | boolean        | Y               | true 收入  false 支出
     changeAmount          | decimal        | Y               | 变换佣金
     createdTime       | decimal        | Y              |时间
     changeNote       | decimal        | Y              |备注   会员逐月消费1000元
     
## 36. <a name='qiniuToken'></a> 获取七牛token]: [返回顶部](#index)

>1.接口信息<br>

>     协议      | 请求方式           | 请求地址        
     ------------- | ---------------| --------------  
     HTTP        | POST      |  http://wangjs.iego.net/yzfs-weixin/core/auth/qiniuToken

>2.请求参数<br>无

     
>3.返回值,如下


>     英文名       | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     code          | String        | Y               | 状态码 100：成功、403：未登录、200:暂无数据 ，404:系统异常
     message       | String        | N               | 成功或错误的消息提示，错误时可用做弹窗提示
     data          | map           |Y                |返回接口数据名称
     
>4.data返回值,如下
     
>     英文名              | 类型           | 是否必须        | 备注
     -------------| --------------| ------------| -------------
     uptoken          | String        | Y               | 七牛token
     
## 37. <a name='getSdkConfig'></a> 获取JSSDK config信息]: [返回顶部](#index)

>1.接口信息<br>

>     协议      | 请求方式           | 请求地址        
     ------------- | ---------------| --------------  
     HTTP        | POST      |  http://wangjs.iego.net/yzfs-weixin/core/auth/getSdkConfig

>2.请求参数<br>

>     参数名称      | 类型           | 是否必须        | 备注（参数以JSON格式传入）
     ------------- | ---------------| --------------  | -------------
     url          | String        | Y               | 当前请求路径

     
>3.返回值,如下


>     英文名       | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     code          | String        | Y               | 状态码 100：成功、403：未登录、200:暂无数据 ，404:系统异常
     message       | String        | N               | 成功或错误的消息提示，错误时可用做弹窗提示
     data          | map           |Y                |返回接口数据名称
     
>4.data返回值,如下
     
>     英文名              | 类型           | 是否必须        | 备注
     -------------| --------------| ------------| -------------
     appid          | String        | Y               | 微信APP ID
     timestamp          | String        | Y               | 时间戳(秒)
     nonceStr          | String        | Y               | 随机字符串
     signature          | String        | Y               | 签名

## 38. <a name='removeOrder'></a> 删除订单]: [返回顶部](#index)

>1.接口信息<br>

>     协议      | 请求方式           | 请求地址        
     ------------- | ---------------| --------------  
     HTTP        | post      |  http://wangjs.iego.net/yzfs-weixin/order/api/removeOrder

>2.请求参数<br>

>     参数名称      | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     token          | String        | Y               | 识别身份的秘钥
     orderId          | String        | Y              | 订单ID


>3.返回值,如下


>     英文名       | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     code          | String        | Y               | 状态码 
     message       | String        | Y              | 成功或错误的消息提示，错误时可用做弹窗提示
     data       | String        | Y               | 如果状态为已支付，并且是微信支付，返回data参数
     
>4.data返回参数

>     英文名              | 类型           | 是否必须        | 备注
     -------------| --------------| ------------| -------------
     appId          |String        | Y               | 微信支付分配的公众账号ID
     timeStamp          |String         | Y               | 时间戳，自1970年以来的秒数     
     nonceStr          |String         | Y               | 随机串     
     signType          |String        | Y               | 微信签名方式
     paySign          |String        | Y               | 支付签名

## 39. <a name='withdrawals'></a> 提现]: [返回顶部](#index)

>1.接口信息<br>

>     协议      | 请求方式           | 请求地址        
     ------------- | ---------------| --------------  
     HTTP        | post      |  http://wangjs.iego.net/yzfs-weixin/center/api/withdrawals

>2.请求参数<br>

>     参数名称      | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     token          | String        | Y               | 识别身份的秘钥
     money          | String        | Y              | 要提现的金额


>3.返回值,如下


>     英文名       | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     code          | String        | Y               | 状态码 
     message       | String        | Y              | 成功或错误的消息提示，错误时可用做弹窗提示
     
## 40. <a name='getMyQRCode'></a> 获取我的二维码]: [返回顶部](#index)

>1.接口信息<br>

>     协议      | 请求方式           | 请求地址        
     ------------- | ---------------| --------------  
     HTTP        | post      |  http://wangjs.iego.net/yzfs-weixin/center/api/getMyQRCode

>2.请求参数<br>

>     参数名称      | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     token          | String        | Y               | 识别身份的秘钥


>3.返回值,如下


>     英文名       | 类型           | 是否必须        | 备注
     ------------- | ---------------| --------------  | -------------
     code          | String        | Y               | 状态码 
     data          | String        | Y              | 二维码七牛key
     message       | String        | Y              | 成功或错误的消息提示，错误时可用做弹窗提示
