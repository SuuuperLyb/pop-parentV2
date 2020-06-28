package com.offway.dyh.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.offway.common.entity.R;
import com.offway.common.entity.TGoodsDetail;

public interface IAdminGoodsDetailService extends IService<TGoodsDetail> {
   //查询有效的商品数量
    R goodsNum();
    //查询无效的商品数量
    R goodsNull();
    //查询商品总数
    R selectGoods();
    //查询商品库存低于50de
    R selectGoodsFew();

}
