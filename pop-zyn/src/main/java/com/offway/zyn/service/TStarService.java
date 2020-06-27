package com.offway.zyn.service;

import com.offway.common.entity.R;

public interface TStarService {

    R getHotStyle();
    R listAll(int startPage,int pageSize);
    R listByName(String starName,int startPage,int pageSize);
}
