package com.offway.zyn.dto;

import com.offway.common.entity.TStarStyle;
import com.offway.common.entity.TStylePhotos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author starzyn
 * @className:HotStarInf
 * @date : 2020/6/25
 * @description: 高热度明星的展示信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotStarInf {
    private TStarStyle tss;
    private List<TStylePhotos> photos;
}
