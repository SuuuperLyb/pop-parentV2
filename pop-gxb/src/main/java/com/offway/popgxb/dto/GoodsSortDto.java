package com.offway.popgxb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @PackgeName: com.offway.popgxb.dto
 * @ClassName: GoodsSortDto
 * @Author: gxb
 * Date: 2020/6/25 17:42:54
 * project name: pop-parent
 * @Version:
 * @Description: 通过商品分类进行模糊查询的数据传输对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsSortDto {
    private String goodsSort;
    private int page;
    private int size;
}
