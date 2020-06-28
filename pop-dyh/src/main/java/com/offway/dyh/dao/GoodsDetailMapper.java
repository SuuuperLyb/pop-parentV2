package com.offway.dyh.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.offway.common.entity.TGoodsDetail;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author LYB
 * @since 2020-06-25
 */
@Repository
public interface GoodsDetailMapper extends BaseMapper<TGoodsDetail> {
    //查询有效的商品数量
    int goodsNum();
    //查询无效的商品数量
    int goodsNull();
    //查询库存低于50的商品数量
    int selectGoodsFew();
}
