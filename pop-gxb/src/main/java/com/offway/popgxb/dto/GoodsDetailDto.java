package com.offway.popgxb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @PackgeName: com.offway.popgxb.dto
 * @ClassName: GoodsDetailDto
 * @Author: gxb
 * Date: 2020/6/25 17:33:18
 * project name: pop-parent
 * @Version:
 * @Description: 通过名字进行模糊查询的数据传输对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsDetailDto {
    private String name;
    private int page;
    private int size;
}
