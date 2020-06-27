package com.offway.zyn.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.offway.common.entity.TStarStyle;
import com.offway.common.entity.TStylePhotos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * @author starzyn
 * @className:StarInfo
 * @date : 2020/6/26
 * @description: 展示一张照片的明星穿搭dto类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StarInfo {
    private Integer starId;//明星id

    /**
     * 明星名字
     */
    private String starName;

    /**
     * 明星穿搭描述
     */
    private String starWeardescription;


    /**
     * 风格描述
     */
    private String styleDesc;

    /**
     * 表的id
     */
//    @TableId(value = "star_style_id", type = IdType.AUTO)
    private Integer starStyleId;

    /**
     * 喜欢的数量
     */
    private Integer likeNum;

    /**
     * 对应的所属风格
     */
    private Integer styleId;

    private String StyleName;

    /**
     * 图的id
     */
//    @TableId(value = "photo_id", type = IdType.AUTO)
    private Integer photoId;

    /**
     * 创建时间
     */
    private LocalDate createTime;

    /**
     * 明星style 图片url
     */
    private String starimgUrl;
}
