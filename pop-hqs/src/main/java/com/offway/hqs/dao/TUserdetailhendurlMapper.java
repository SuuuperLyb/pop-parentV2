package com.offway.hqs.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.offway.hqs.dto.TUserDetailsDto;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 * 用户详情 Mapper 接口 相当于dao接口
 * </p>
 *
 */
public interface TUserdetailhendurlMapper extends BaseMapper<TUserDetailsDto> {

    @Update("update t_user_details set ud_haardurl = #{url} where u_id = #{uid}")
    int updateHeadUrl(@Param("uid") int uid,
                      @Param("url") String url);
}
