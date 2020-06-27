package com.offway.zyn.service;

import com.offway.common.entity.R;

public interface StarDetailService {
    R addLike(int id, String token);
    R dislike(int id,String token);
    R showDetail(int starStyleId);
}
