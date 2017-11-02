package com.wmeimob.yzfs.dao;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.wmeimob.yzfs.model.Cart;
import com.wmeimob.yzfs.vo.CartOrderItemVO;

public interface CartMapper {
	
	int deleteByPrimaryKey(String id);

	/**
	 * 创建购物车
	 * @param record
	 * @return
	 */
	int insert(Cart record);

	int insertSelective(Cart record);

	Cart selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(Cart record);

	int updateByPrimaryKey(Cart record);

	/**
	 * 通过cart查询
	 * 
	 * @param example
	 * @return
	 */
	List<Cart> selectByCart(Cart example);

	/**
	 * 通过cartId 查询购物车明细
	 * 
	 * @param cartId
	 * @param userId TODO
	 * @return
	 */
	List<CartOrderItemVO> selectCartItemById(@Param("cartId")String cartId, @Param("userId")String userId);

	/**
	 * 通过item id 删除item
	 * 
	 * @param orderItemIds
	 * @return
	 */
	int deleteByItemIds(String[] orderItemIds);
}