package com.offway.dyh.controller;

import com.offway.common.entity.R;
import com.offway.common.entity.TStarStyle;
import com.offway.dyh.service.ITStarStyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 明星描述
 */
@RestController
public class TStarStyleController {
    @Autowired
    private ITStarStyleService service;

    /**
     * 增加starstyle
     * @param tStarStyle
     * @return
     */
    @PostMapping("/api/offway/poststarstyle.do")
    public R postStarStyle(@RequestBody TStarStyle tStarStyle){
        return service.postStarStyle(tStarStyle);
    }
}
