package com.offway.popgxb.dao;

import com.offway.common.entity.TFirsttype;
import com.offway.common.entity.TGoodsDetail;
import com.offway.popgxb.dto.UpdateGoodsDetailDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * @PackgeName: com.offway.popgxb.dao
 * @ClassName: TGoodsDetailDao
 * @Author: gxb
 * Date: 2020/6/26 15:22:53
 * project name: pop-parent
 * @Version:
 * @Description:
 */
@Mapper
public interface TGoodsDetailDao {

    /**
     * 通过商品的id修改指定的商品信息
     *
     * @param updateGoodsDetailDto
     * @return
     */
    int updateGoodsDetailByGid(UpdateGoodsDetailDto updateGoodsDetailDto);

    /**
     * 添加商品信息
     *
     * @param updateGoodsDetailDto1
     * @return
     */
    int insertGoodsDetail(UpdateGoodsDetailDto updateGoodsDetailDto1);

    /**
     * 通过t_sectype_id分组查询商品信息
     *
     * @return
     */
    Integer selectGoodsDetailBySectype(Integer tSectypeId);

    /**
     * 根据二级商品的ID查询商品的详细信息
     *
     * @return
     */
//    @Select("select * from t_goods_detail where t_sectype_id = #{tSectypeId}")
    List<TGoodsDetail> selectGoodsDetailByGsectype(String tSectypeId);
}
