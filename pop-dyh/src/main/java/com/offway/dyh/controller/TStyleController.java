package com.offway.dyh.controller;

import com.offway.common.entity.R;
import com.offway.common.entity.TStyle;
import com.offway.dyh.service.ITStyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 明星Style描述类型
 */
@RestController
public class TStyleController {
    @Autowired
    private ITStyleService service;
    //查询style风格表
    @GetMapping("/api/offway/getstylelist.do")
    public R getStyleList(){
        return service.getStyleList();
    }
    @PostMapping ("/api/offway/poststyle.do")
    public R postStyle(@RequestBody TStyle ts){
        return service.postStyle(ts);
    }

}
