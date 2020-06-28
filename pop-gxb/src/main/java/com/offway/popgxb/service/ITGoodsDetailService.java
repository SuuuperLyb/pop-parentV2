package com.offway.popgxb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.offway.common.entity.R;
import com.offway.common.entity.TFirsttype;
import com.offway.common.entity.TGoodsDetail;
import com.offway.popgxb.dto.GoodsDetailDto;
import com.offway.popgxb.dto.GoodsSortDto;
import com.offway.popgxb.dto.UpdateGoodsDetailDto;
import org.springframework.web.multipart.MultipartFile;

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
     * @param goodsDetailDto 商品名称的数据传输类
     * @return
     */
    R selectByName(GoodsDetailDto goodsDetailDto);

    /**
     * 根据商品的分类查询商品信息
     *
     * @param goodsSort 商品分类的数据传输类
     * @return
     */
    R selectByGoodsSort(GoodsSortDto goodsSort);

    /**
     * 通过商品的id查找指定的商品信息
     *
     * @param gid 商品的id
     * @return
     */
    R selectGoodsDetailByGid(int gid);

    /**
     * 通过商品的id修改指定的商品信息
     *
     * @param updateGoodsDetailDto 商品的数据传输类
     * @return
     */
    R updateGoodsDetailByGid(UpdateGoodsDetailDto updateGoodsDetailDto);

    /**
     * 通过商品的ID删除商品信息
     *
     * @param gid 商品的id
     * @return
     */
    R deleteGoodsDetailByGid(int gid);

    /**
     * 添加商品信息，并添加对应的图片信息
     *
     * @param updateGoodsDetailDto 数据传输对象类
     * @param file                 要上传的图片文件
     * @return
     */
    R insertGoodsDetail(UpdateGoodsDetailDto updateGoodsDetailDto, MultipartFile file);

    /**
     * 通过t_sectype_id查询该二级商品的数量
     *
     * @param tSectypeId 商品的二级级别id
     * @return
     */
    R selectGoodsDetailBySectype(Integer tSectypeId);

    /**
     * 根据二级商品的ID查询商品的详细信息
     *
     * @param tSectypeId 商品的二级级别id
     * @return
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
     * @param tFirsttypeId 商品的一级级别id
     * @return
     */
    R deleteGoodsDetailFirsttype(int tFirsttypeId);

    /**
     * 添加商品的一级级别信息
     *
     * @param tFirsttype 商品一级级别信息对象
     * @return
     */
    R insertGoodsFirsttype(TFirsttype tFirsttype);

    /**
     * 根据商品一级级别id查询商品二级级别信息
     *
     * @param tFirsttypeId 商品的一级级别id
     * @return
     */
    R selectTSectypefromFirsttype(int tFirsttypeId);
}
