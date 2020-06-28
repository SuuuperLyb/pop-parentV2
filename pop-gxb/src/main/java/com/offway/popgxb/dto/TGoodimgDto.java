package com.offway.popgxb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @PackgeName: com.offway.popgxb.dto
 * @ClassName: TGoodimgDao
 * @Author: gxb
 * Date: 2020/6/28 14:25:18
 * project name: pop-parent
 * @Version:
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TGoodimgDto {
    /**
     * 图片排序
     */
    private Integer iSort;
    /**
     * 是否主图
     */
    private Integer iMainimg;
    /**
     * 图片链接
     */
    private String iImgurl;
    /**
     * 商品id
     */
    private Integer goodsId;
}
