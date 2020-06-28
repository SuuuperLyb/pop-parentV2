package com.offway.dyh.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.offway.common.entity.R;
import com.offway.common.entity.TStyle;

public interface ITStyleService extends IService<TStyle> {
    R getStyleList();


    R postStyle(TStyle ts);
}
