package com.offway.popgxb.controller;

import com.offway.common.entity.R;
import com.offway.common.entity.TFirsttype;
import com.offway.common.util.Rutil;
import com.offway.popgxb.dto.GoodsDetailDto;
import com.offway.popgxb.dto.GoodsSortDto;
import com.offway.popgxb.dto.UpdateGoodsDetailDto;
import com.offway.popgxb.service.ITGoodsDetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @PackgeName: com.offway.popgxb.controller
 * @ClassName: GoodsDetailController
 * @Author: gxb
 * Date: 2020/6/26 10:06:50
 * project name: pop-parent
 * @Version:
 * @Description:
 */
@RestController
@CrossOrigin // 解决跨域问题
@Api(tags = "商品相关接口")
public class GoodsDetailController {

    @Resource
    private ITGoodsDetailService itGoodsDetailService;

    /**
     * 查询所有商品信息
     *
     * @return
     */
    @GetMapping("/api/goodsdetail/selectallgoods.do")
    @ApiOperation(value = "查询所有商品信息")
    public R selectAllGoods() {
        R r = itGoodsDetailService.selectAllTGoods();

        return r;
    }

    /**
     * 通过商品名字模糊查询商品信息集合
     *
     * @param goodsDetailDto
     * @return
     */
    @GetMapping("/api/goodsdetail/selectbyname.do")
    @ApiOperation(value = "根据商品的名称进行模糊查询")
//    @ApiImplicitParam(paramType = "query", name = "goodsDetailDto", value = "商品的数据传输对象", required = true, dataType = "goodsDetailDto")
    public R selectByName(GoodsDetailDto goodsDetailDto) {
        R r = itGoodsDetailService.selectByName(goodsDetailDto);

        return r;
    }

    /**
     * 根据商品的分类模糊查询商品信息
     *
     * @param goodsSortDto
     * @return
     */
    @GetMapping("api/goodsdetail/selectbygoodssort.do")
    @ApiOperation(value = "根据商品的分类模糊查询商品信息")
//    @ApiImplicitParam(paramType = "query", name = "goodsSortDto", value = "商品的分类数据传输对象", required = true, dataType = "goodsSortDto")
    public R selectByGoodsSort(GoodsSortDto goodsSortDto) {
        R r = itGoodsDetailService.selectByGoodsSort(goodsSortDto);

        return r;
    }

    /**
     * 根据商品id查询商品的信息
     *
     * @param gid
     * @return
     */
    @GetMapping("api/goodsdetail/selectgoodsdetailbygid.do")
    @ApiOperation(value = "根据商品id查询商品的信息")
//    @ApiImplicitParam(paramType = "query", name = "gid", value = "商品的id", required = true, dataType = "int")
    public R selectGoodsDetailByGid(int gid) {
        R r = itGoodsDetailService.selectGoodsDetailByGid(gid);

        return r;
    }

    /**
     * 通过商品的id修改指定的商品信息
     *
     * @param updateGoodsDetailDto
     * @return
     */
    @PutMapping("api/goodsdetail/updategoodsdetailbygid.do")
    @ApiOperation(value = "通过商品的id修改指定的商品信息")
    public R updateGoodsDetailByGid(@RequestBody UpdateGoodsDetailDto updateGoodsDetailDto) {
        R r = itGoodsDetailService.updateGoodsDetailByGid(updateGoodsDetailDto);

        return r;
    }

    /**
     * 通过商品的ID删除商品
     *
     * @param gid
     * @return
     */
    @DeleteMapping("/api/goodsdetail/deleteGoodsDetailByGid.do/{gid}")
    @ApiOperation(value = "通过商品的ID删除商品")
//    @ApiImplicitParam(paramType = "path", name = "gid", value = "商品的id", required = true, dataType = "int")
    public R deleteGoodsDetailByGid(@PathVariable("gid") int gid) {
        R r = itGoodsDetailService.deleteGoodsDetailByGid(gid);

        return r;
    }

    /**
     * 添加商品信息
     *
     * @param updateGoodsDetailDto
     * @return
     */
    @PostMapping("/api/goodsdetail/insertgoodsdetail.do")
    @ApiOperation(value = "添加商品信息")
    public R insertGoodsDetail(UpdateGoodsDetailDto updateGoodsDetailDto) {
        R r = itGoodsDetailService.insertGoodsDetail(updateGoodsDetailDto);

        return r;
    }

    /**
     * 通过t_sectype_id查询该二级商品的数量
     *
     * @return
     */
    @GetMapping("/api/goodsdetail/selectgoodsdetailbysectype.do/{tSectypeId}")
    @ApiOperation(value = "通过t_sectype_id查询该二级商品的数量")
//    @ApiImplicitParam(paramType = "path", name = "tSectypeId", value = "商品的二级级别id", required = true, dataType = "Integer")
    public R selectGoodsDetailBySectype(@PathVariable("tSectypeId") Integer tSectypeId) {
        R r = itGoodsDetailService.selectGoodsDetailBySectype(tSectypeId);

        return r;
    }

    /**
     * 根据二级商品的ID查询商品的详细信息
     *
     * @param tSectypeId
     * @return
     */
    @GetMapping("/api/goodsdetail/selectgoodsdetailbygsectype.do")
    @ApiOperation(value = "根据二级商品的ID查询商品的详细信息")
//    @ApiImplicitParam(paramType = "query", name = "tSectypeId", value = "商品的二级级别id", required = true, dataType = "String")
    public R selectGoodsDetailByGsectype(String tSectypeId) {
        R r = itGoodsDetailService.selectGoodsDetailByGsectype(tSectypeId);

        return r;
    }

    /**
     * 查询商品的一级名称的列表信息
     *
     * @return
     */
    @GetMapping("/api/goodsdetail/selectgoodsdetailfirsttype.do")
    @ApiOperation(value = "查询商品的一级名称的列表信息")
    public R selectGoodsDetailFirsttype() {
        R r = itGoodsDetailService.selectGoodsDetailFirsttype();

        return r;
    }

    /**
     * 删除商品的一级名称信息
     *
     * @param tFirsttypeId
     * @return
     */
    @DeleteMapping("/api/goodsdetail/deletegoodsdetailfirsttype.do/{tFirsttypeId}")
    @ApiOperation(value = "删除商品的一级名称信息")
    public R deleteGoodsDetailFirsttype(@PathVariable("tFirsttypeId") int tFirsttypeId) {
        R r = itGoodsDetailService.deleteGoodsDetailFirsttype(tFirsttypeId);

        return r;
    }

    /**
     * 添加商品的一级级别信息
     *
     * @param tFirsttype
     * @return
     */
    @PostMapping("/api/goodsdetail/insertGoodsFirsttype.do")
    @ApiOperation(value = "添加商品的一级级别信息")
    public R insertGoodsFirsttype(TFirsttype tFirsttype) {
        R r = itGoodsDetailService.insertGoodsFirsttype(tFirsttype);

        return Rutil.Ok(r);
    }

    /**
     * 根据商品一级级别id查询商品二级级别信息
     *
     * @param tFirsttypeId 商品的以及级别id
     * @return
     */
    @GetMapping("/api/goodsdetail/selecttSectypefromfirsttype.do/{tFirsttypeId}")
    @ApiOperation(value = "根据商品一级级别id查询商品二级级别信息")
    public R selectTSectypefromFirsttype(@PathVariable("tFirsttypeId") int tFirsttypeId) {
        R r = itGoodsDetailService.selectTSectypefromFirsttype(tFirsttypeId);

        return Rutil.Ok(r);
    }
}