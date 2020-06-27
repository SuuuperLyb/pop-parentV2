package com.offway.lxm.dao;

import com.offway.lxm.entity.ShoppingCar;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShoppingCarMapper {
    /**
     * 查询用户购物车中详细信息
     * @param uId
     * @return
     */
    List<ShoppingCar> selectAll(Integer uId);

    /**
     * 修改购物车商品数量
     * @param scId
     * @param gNum
     * @return
     */
    int updatenum(@Param("scId") int scId,@Param("gNum") int gNum);

    /**
     * 查询当前该商品的库存
     * @param scId
     * @return
     */
    int selectgoodsCount(int scId);
}
