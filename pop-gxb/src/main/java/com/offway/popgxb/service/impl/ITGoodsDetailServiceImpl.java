package com.offway.popgxb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.offway.common.entity.*;
import com.offway.common.mapper.TGoodimgMapper;
import com.offway.common.mapper.TGoodsDetailMapper;
import com.offway.common.util.Rutil;
import com.offway.popgxb.dao.TFirsttypeDao;
import com.offway.popgxb.dao.TGoodsDetailDao;
import com.offway.popgxb.dao.TSectypeDao;
import com.offway.popgxb.dto.GoodsDetailDto;
import com.offway.popgxb.dto.GoodsSortDto;
import com.offway.popgxb.dto.UpdateGoodsDetailDto;
import com.offway.popgxb.service.ITGoodsDetailService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * @PackgeName: com.offway.popgxb.service
 * @ClassName: ITGoodsDetailServiceImpl
 * @Author: gxb
 * Date: 2020/6/25 17:00:48
 * project name: pop-parent
 * @Version:
 * @Description:
 */
@Service("iTGoodsDetailServiceImplgxb")
public class ITGoodsDetailServiceImpl extends ServiceImpl<TGoodsDetailMapper, TGoodsDetail> implements ITGoodsDetailService {

    @Resource
    private TGoodsDetailMapper tGoodsDetailMapper;
    @Resource
    private TGoodsDetailDao tGoodsDetailDao;
    @Resource
    private TFirsttypeDao tFirsttypeDao;
    @Resource
    private TSectypeDao tSectypeDao;
    @Resource
    private TGoodimgMapper tGoodimgMapper;
    @Resource
    private ResourceossServiceImpl resourceossServiceimpl;

    /**
     * 查询所有商品信息
     *
     * @return
     */
    @Override
    public R selectAllTGoods() {
        List<TGoodsDetail> tGoodsDetails = tGoodsDetailMapper.selectList(new QueryWrapper<TGoodsDetail>());

        return Rutil.Ok(tGoodsDetails);
    }

    /**
     * 通过商品名字模糊查询商品信息集合
     *
     * @param goodsDetailDto 商品名称的数据传输类
     * @return
     */
    @Override
    public R selectByName(GoodsDetailDto goodsDetailDto) {
//        Page<TGoodsDetail> page = new Page<>(goodsDetailDto.getPage(), goodsDetailDto.getSize());
//
//        // 将TGoodsDetail封装到QueryWrapper类中
//        QueryWrapper<TGoodsDetail> queryWrapper = new QueryWrapper<>();
//
//        if (goodsDetailDto.getName() != null && goodsDetailDto.getName().length() > 0) {
//            queryWrapper.like("t_goods_name", goodsDetailDto.getName());
//        }
//
//        QueryWrapper<TGoodsDetail> queryWrapper = new QueryWrapper<>();
//        QueryWrapper<TGoodsDetail> t_goods_name = queryWrapper.like("t_goods_name", goodsName);
//        List<TGoodsDetail> list = tGoodsDetailMapper.selectList(new QueryWrapper<TGoodsDetail>().like("t_goods_name", goodsName));

//        Page<TGoodsDetail> page =
//                tGoodsDetailMapper.selectPage(new Page<TGoodsDetail>(goodsDetailDto.getPage(), goodsDetailDto.getSize()),
//                        new QueryWrapper<TGoodsDetail>().like("t_goods_name", goodsDetailDto.getName()));

        Page<TGoodsDetail> page = new Page<>();
        QueryWrapper<TGoodsDetail> queryWrapper = new QueryWrapper<>();

        if (goodsDetailDto.getName() != null && goodsDetailDto.getName().length() > 0) {
            QueryWrapper<TGoodsDetail> t_goods_name = queryWrapper.like("t_goods_name", goodsDetailDto.getName());
            Page<TGoodsDetail> tGoodsDetailPage = tGoodsDetailMapper.selectPage(page, t_goods_name);

            return Rutil.Ok(tGoodsDetailPage);
        } else {
            return Rutil.err("您输入的内容为空，请您重新输入~~~");
        }
    }

    /**
     * 根据商品的分类模糊查询商品信息
     *
     * @param goodsSortDto 数据传输对象
     * @return
     */
    @Override
    public R selectByGoodsSort(GoodsSortDto goodsSortDto) {
        // page对象包含分页的 当前页码 和 当前的记录数
        Page<TGoodsDetail> page = new Page<>(goodsSortDto.getPage(), goodsSortDto.getSize());
        // queryWrapper为封装类，可以对数据进行条件查询
        QueryWrapper<TGoodsDetail> queryWrapper = new QueryWrapper<>();

        if (goodsSortDto.getGoodsSort() != null && goodsSortDto.getGoodsSort().length() > 0) {
            QueryWrapper<TGoodsDetail> t_goods_sort = queryWrapper.like("t_goods_sort", goodsSortDto.getGoodsSort());
            Page<TGoodsDetail> tGoodsDetailPage = tGoodsDetailMapper.selectPage(page, t_goods_sort);

            return Rutil.Ok(tGoodsDetailPage);
        } else {
            return Rutil.err("您输入的信息为空，请重新输入");
        }
    }

    /**
     * 根据商品id查询商品的信息
     *
     * @param gid 商品的id
     * @return
     */
    @Override
    public R selectGoodsDetailByGid(int gid) {
        TGoodsDetail tGoodsDetail = tGoodsDetailMapper.selectById(gid);

        return Rutil.Ok(tGoodsDetail);
    }

    /**
     * 通过商品的id修改指定的商品信息
     *
     * @param updateGoodsDetailDto 商品的数据传输类
     * @return
     */
    @Override
    public R updateGoodsDetailByGid(UpdateGoodsDetailDto updateGoodsDetailDto) {
        int i = tGoodsDetailDao.updateGoodsDetailByGid(updateGoodsDetailDto);

        return Rutil.Ok(i);
    }

    /**
     * 通过商品的ID删除商品
     *
     * @param gid 商品的id
     * @return
     */
    @Override
    public R deleteGoodsDetailByGid(int gid) {
        int i = tGoodsDetailMapper.deleteById(gid);

        return Rutil.Ok(i);
    }

    /**
     * 添加商品信息，并添加对应的图片信息
     *
     * @param updateGoodsDetailDto 数据传输对象类
     * @param file                 要上传的图片文件
     * @return
     */
    @Override
    public R insertGoodsDetail(UpdateGoodsDetailDto updateGoodsDetailDto, MultipartFile file) {
        int i = tGoodsDetailDao.insertGoodsDetail(updateGoodsDetailDto);
        String pictureUrl = (String) resourceossServiceimpl.sendFile(file).getObject();

        TGoodimg tGoodimgDto1 = new TGoodimg();
        tGoodimgDto1.setiSort(updateGoodsDetailDto.gettGoodsRank());
        tGoodimgDto1.setiMainimg(1);
        tGoodimgDto1.setiImgurl(pictureUrl);
        tGoodimgDto1.setGoodsId(updateGoodsDetailDto.gettGoodsId());

        int j = tGoodimgMapper.insert(tGoodimgDto1);

        return Rutil.Ok(j);
    }

    /**
     * 通过t_sectype_id查询该二级商品的数量
     *
     * @param tSectypeId 商品的二级级别id
     * @return
     */
    @Override
    public R selectGoodsDetailBySectype(Integer tSectypeId) {
        Integer i = tGoodsDetailDao.selectGoodsDetailBySectype(tSectypeId);

        return Rutil.Ok(i);
    }

    /**
     * 根据二级商品的ID查询商品的详细信息
     *
     * @param tSectypeId 商品的二级级别id
     * @return
     */
    @Override
    public R selectGoodsDetailByGsectype(String tSectypeId) {
        List<TGoodsDetail> tGoodsDetails = tGoodsDetailDao.selectGoodsDetailByGsectype(tSectypeId);

        return Rutil.Ok(tGoodsDetails);
    }

    /**
     * 查询商品的一级名称的列表信息
     *
     * @return
     */
    @Override
    public R selectGoodsDetailFirsttype() {
        List<TFirsttype> tFirsttypes = tFirsttypeDao.selectGoodsDetailFirsttype();

        return Rutil.Ok(tFirsttypes);
    }

    /**
     * 删除商品的一级名称信息
     *
     * @param tFirsttypeId 商品的一级级别id
     * @return
     */
    @Override
    public R deleteGoodsDetailFirsttype(int tFirsttypeId) {
        int i = tFirsttypeDao.deleteGoodsDetailFirsttype(tFirsttypeId);

        return Rutil.Ok(i);
    }

    /**
     * 添加商品的一级级别信息
     *
     * @param tFirsttype 商品一级级别信息对象
     * @return
     */
    @Override
    public R insertGoodsFirsttype(TFirsttype tFirsttype) {
        int i = tFirsttypeDao.insertGoodsFirsttype(tFirsttype);

        return Rutil.Ok(i);
    }

    /**
     * 根据商品一级级别id查询商品二级级别信息
     *
     * @param tFirsttypeId 商品的一级级别id
     * @return
     */
    @Override
    public R selectTSectypefromFirsttype(int tFirsttypeId) {
        List<TSectype> tSectypes = tSectypeDao.selectTSectypefromFirsttype(tFirsttypeId);

        return Rutil.Ok(tSectypes);
    }
}
