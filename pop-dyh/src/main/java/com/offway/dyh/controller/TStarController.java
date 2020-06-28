package com.offway.dyh.controller;

import com.offway.common.entity.R;
import com.offway.common.entity.TStar;
import com.offway.dyh.service.ITStarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 明星
 */
@RestController
public class TStarController {
    @Autowired
    private ITStarService service;

    /**
     * 查询明星明细
     * @return
     */
    @GetMapping("/api/offway/getstarList.do")
    public R getstarList(){
        return service.getstarList();
    }
    /**
     * 新增明星
     */
    @PostMapping("/api/offway/poststar.do")
    public R postStar(@RequestBody TStar star){
        return service.postStar(star);

    }
}
