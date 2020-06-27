package com.offway.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author LYB
 * @since 2020-06-25
 */
public class TStarStyle extends Model<TStarStyle> {

    private static final long serialVersionUID = 1L;

    /**
     * 明星id
     */
    private Integer starId;

    /**
     * 风格描述
     */
    private String styleDesc;

    /**
     * 表的id
     */
    @TableId(value = "star_style_id", type = IdType.AUTO)
    private Integer starStyleId;

    /**
     * 喜欢的数量
     */
    private Integer likeNum;

    /**
     * 对应的所属风格
     */
    private Integer styleId;

    public Integer getStarId() {
        return starId;
    }

    public void setStarId(Integer starId) {
        this.starId = starId;
    }
    public String getStyleDesc() {
        return styleDesc;
    }

    public void setStyleDesc(String styleDesc) {
        this.styleDesc = styleDesc;
    }
    public Integer getStarStyleId() {
        return starStyleId;
    }

    public void setStarStyleId(Integer starStyleId) {
        this.starStyleId = starStyleId;
    }
    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }
    public Integer getStyleId() {
        return styleId;
    }

    public void setStyleId(Integer styleId) {
        this.styleId = styleId;
    }

    @Override
    protected Serializable pkVal() {
        return this.starStyleId;
    }

    @Override
    public String toString() {
        return "TStarStyle{" +
            "starId=" + starId +
            ", styleDesc=" + styleDesc +
            ", starStyleId=" + starStyleId +
            ", likeNum=" + likeNum +
            ", styleId=" + styleId +
        "}";
    }
}
