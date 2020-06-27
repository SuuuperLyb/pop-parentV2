package com.offway.zyn.service;

import com.offway.common.entity.R;

public interface GoodDetailService {
    R show(int goodid, String token);
    R addLike(int goodid,String token);
    R addCar(int goodid,String token);
}
