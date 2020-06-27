package com.offway.zyn.dto;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.offway.common.entity.TCommentUser;
import com.offway.common.entity.TGoodsDetail;
import com.offway.common.entity.TStore;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author starzyn
 * @className:GoodDetail
 * @date : 2020/6/27
 * @description: 商品详情的输出模板
 */
@Data
@AllArgsConstructor
public class GoodDetail {
    TGoodsDetail tGoodsDetail;
    //查询商品对应的评论
    List<TCommentUser> tCommentUser;
    //查询对应的店铺
    TStore tStore;
}
