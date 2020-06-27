package com.offway.popgxb.dao;

import com.offway.common.entity.TSectype;

import java.util.List;

/**
 * @PackgeName: com.offway.popgxb.dao
 * @ClassName: TSectypeDao
 * @Author: gxb
 * Date: 2020/6/26 21:49:22
 * project name: pop-parent
 * @Version:
 * @Description:
 */
public interface TSectypeDao {

    /**
     * 根据商品一级级别id查询商品二级级别信息
     *
     * @return
     */
    List<TSectype> selectTSectypefromFirsttype(int tFirsttypeId);
}
