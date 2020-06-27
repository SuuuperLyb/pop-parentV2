package com.offway.lxm.dao;

import com.offway.lxm.entity.TUserlikeGoods;
import com.offway.lxm.entity.TUserlikeStarStyle;
import com.offway.lxm.entity.TUserlikeStore;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LikeMapper {

    /**
     * 查询用户喜欢的商品
     * @param uId
     * @return
     */
    List<TUserlikeGoods> selectgoods(@Param("uId") Integer uId);



    /**
     * 查询用户喜欢的店铺
     * @param uId
     * @return
     */
    List<TUserlikeStore> selectstores(Integer uId);

    /**
     * 查询用户喜欢的明星穿搭
     * @param uId
     * @return
     */
    List<TUserlikeStarStyle> selectstar(Integer uId);


}
