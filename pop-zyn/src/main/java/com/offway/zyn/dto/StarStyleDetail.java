package com.offway.zyn.dto;

import com.offway.common.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author starzyn
 * @className:StarStyleDetail
 * @date : 2020/6/26
 * @description: 明星穿搭风格详情输出模板
 */
@Data
@AllArgsConstructor
public class StarStyleDetail {
    private TStarStyle tStarStyle;
    private TStar tStar;
    private TStore tStore;
    private TGoodsDetail tGoodsDetail;
    private List<TStylePhotos> photos;
}
