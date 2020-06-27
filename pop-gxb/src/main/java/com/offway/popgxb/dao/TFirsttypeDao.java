package com.offway.popgxb.dao;

import com.offway.common.entity.TFirsttype;
import com.offway.common.entity.TSectype;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @PackgeName: com.offway.popgxb.dao
 * @ClassName: TfirsttypeDao
 * @Author: gxb
 * Date: 2020/6/26 15:43:43
 * project name: pop-parent
 * @Version:
 * @Description:
 */
@Mapper
public interface TFirsttypeDao {

    /**
     * 查询商品的一级名称的列表信息
     *
     * @return
     */
//    @Select("select * from t_firsttype")
    List<TFirsttype> selectGoodsDetailFirsttype();

    /**
     * 删除指定商品一级名称信息
     *
     * @return
     */
//    @Delete("delete from t_firsttype where t_firsttype_id = #{}")
    int deleteGoodsDetailFirsttype(int tFirsttypeId);

    /**
     * 添加商品的一级级别
     *
     * @return
     */
    int insertGoodsFirsttype(TFirsttype tFirsttype);
}
