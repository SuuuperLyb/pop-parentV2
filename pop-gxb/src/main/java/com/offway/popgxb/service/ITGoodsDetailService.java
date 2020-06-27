package com.offway.popgxb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.offway.common.entity.R;
import com.offway.common.entity.TFirsttype;
import com.offway.common.entity.TGoodsDetail;
import com.offway.popgxb.dto.GoodsDetailDto;
import com.offway.popgxb.dto.GoodsSortDto;
import com.offway.popgxb.dto.UpdateGoodsDetailDto;

/**
 * @PackgeName: com.offway.popgxb.service
 * @ClassName: ITGoodsDetailService
 * @Author: gxb
 * Date: 2020/6/25 16:59:37
 * project name: pop-parent
 * @Version:
 * @Description:
 */
public interface ITGoodsDetailService extends IService<TGoodsDetail> {

    /**
     * 查询所有商品信息
     *
     * @return
     */
    R selectAllTGoods();

    /**
     * 通过商品名字模糊查询商品信息集合
     *
     * @return
     */
    R selectByName(GoodsDetailDto goodsDetailDto);

    /**
     * 根据商品的分类查询商品信息
     *
     * @param goodsSort
     * @return
     */
    R selectByGoodsSort(GoodsSortDto goodsSort);

    /**
     * 通过商品的id查找指定的商品信息
     *
     * @return
     */
    R selectGoodsDetailByGid(int gid);

    /**
     * 通过商品的id修改指定的商品信息
     *
     * @param updateGoodsDetailDto
     * @return
     */
    R updateGoodsDetailByGid(UpdateGoodsDetailDto updateGoodsDetailDto);

    /**
     * 通过商品的ID删除商品信息
     *
     * @return
     */
    R deleteGoodsDetailByGid(int gid);

    /**
     * 添加商品信息
     *
     * @return
     */
    R insertGoodsDetail(UpdateGoodsDetailDto updateGoodsDetailDto);

    /**
     * 通过t_sectype_id查询该二级商品的数量
     */
    R selectGoodsDetailBySectype(Integer tSectypeId);

    /**
     * 根据二级商品的ID查询商品的详细信息
     */
    R selectGoodsDetailByGsectype(String tSectypeId);

    /**
     * 查询商品的一级名称的列表信息
     *
     * @return
     */
    R selectGoodsDetailFirsttype();

    /**
     * 删除商品的一级名称信息
     *
     * @return
     */
    R deleteGoodsDetailFirsttype(int tFirsttypeId);

    /**
     * 添加商品的一级级别信息
     *
     * @param tFirsttype
     * @return
     */
    R insertGoodsFirsttype(TFirsttype tFirsttype);

    /**
     * 根据商品一级级别id查询商品二级级别信息
     *
     * @return
     */
    R selectTSectypefromFirsttype(int tFirsttypeId);
}
