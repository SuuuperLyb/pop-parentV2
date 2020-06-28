package com.offway.dyh.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.offway.common.entity.R;
import com.offway.common.entity.TStar;

public interface ITStarService extends IService<TStar> {
    R getstarList();


    R postStar(TStar star);
}
