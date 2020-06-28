package com.offway.dyh.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.offway.common.entity.R;
import com.offway.common.entity.TStarStyle;

public interface ITStarStyleService extends IService<TStarStyle> {

    R postStarStyle(TStarStyle tStarStyle);
}
