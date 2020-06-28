package com.offway.dyh.controller;

import com.offway.common.entity.R;
import com.offway.common.entity.TStar;
import com.offway.dyh.service.ITStarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
 * 明星
 */
@RestController
@CrossOrigin
public class TStarControllerdyh {
    @Autowired
    @Qualifier("ITStarServicedyh")
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
