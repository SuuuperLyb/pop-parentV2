package com.offway.zyn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.offway.zyn.dto.StarInfo;
import javafx.scene.control.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StarInfoMapper extends BaseMapper<StarInfo>{

    /**
     * @Author starzyn
     * @Description 分页查询输出模板
     * @Date 15:37 2020/6/26
     * @Param [page]
     * @return java.util.List<com.offway.zyn.dto.StarInfo>
     **/
    @Select("select DISTINCT t_star_style.star_style_id," +
            "t_star.id starId,t_star.star_name," +
            "t_star.star_weardescription,t_star_style.style_desc," +
            "t_style.style_name," +
            "t_style_photos.photo_id," +
            "t_style_photos.create_time," +
            "t_style_photos.starimg_url," +
            "t_star_style.like_num," +
            "t_star_style.style_id " +
            "from t_star,t_style,t_star_style,t_style_photos,t_starmetastyle " +
            "where  t_starmetastyle.star_id=t_star_style.star_id " +
            "and t_starmetastyle.style_id=t_star_style.style_id " +
            "and t_style_photos.stat_style_id=t_star_style.star_style_id " +
            "and t_star.id=t_starmetastyle.star_id " +
            "and t_style.id=t_starmetastyle.style_id  " +
            "GROUP BY t_style_photos.stat_style_id ")
    List<StarInfo> getStarInfoByPage(Page<StarInfo> page);

    @Select("select DISTINCT t_star_style.star_style_id," +
            "t_star.id starId,t_star.star_name," +
            "t_star.star_weardescription,t_star_style.style_desc," +
            "t_style.style_name," +
            "t_style_photos.photo_id," +
            "t_style_photos.create_time," +
            "t_style_photos.starimg_url, " +
            "t_star_style.like_num," +
            "t_star_style.style_id " +
            "from t_star,t_style,t_star_style,t_style_photos,t_starmetastyle " +
            "where  t_starmetastyle.star_id=t_star_style.star_id " +
            "and t_starmetastyle.style_id=t_star_style.style_id " +
            "and t_style_photos.stat_style_id=t_star_style.star_style_id " +
            "and t_star.id=t_starmetastyle.star_id " +
            "and t_style.id=t_starmetastyle.style_id  " +
            "and t_star.star_name=#{starName}" +
            "GROUP BY t_style_photos.stat_style_id ")
    List<StarInfo> getStarInfoByPageWithName(Page<StarInfo> page,@Param("starName") String starName);
}
