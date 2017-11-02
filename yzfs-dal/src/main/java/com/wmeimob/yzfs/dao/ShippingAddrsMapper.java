package com.wmeimob.yzfs.dao;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.wmeimob.yzfs.model.ShippingAddrs;
import com.wmeimob.yzfs.vo.ShippingAddrsVO;

public interface ShippingAddrsMapper {
    int deleteByPrimaryKey(String id);

    int insert(ShippingAddrs record);

    /**
     * 新增地址信息
     * @param record
     * @return
     */
    int insertSelective(ShippingAddrs record);

    ShippingAddrs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ShippingAddrs record);
    
    int updateByPrimaryKey(ShippingAddrs record);

    /**
     * 将用户不在该ID参数下的地址设置为非默认地址
     * @param record
     * @return
     */
    int updateAddressIsDefault(ShippingAddrs record);

    /**
     * 查询用用户的收货地址
     * @param add
     * @return
     */
    List<ShippingAddrsVO>  queryAddrsByConditions(ShippingAddrsVO add);

    /**
     * 根据用户Id查询默认用户
     * @param userId
     * @param isDefault 条件 =1
     * @return
     */
    ShippingAddrs queryAddrsByUserIdAndisDefault(@Param("userId") String userId);
}