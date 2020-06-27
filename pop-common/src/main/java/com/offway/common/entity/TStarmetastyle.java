package com.offway.common.entity;

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
public class TStarmetastyle extends Model<TStarmetastyle> {

    private static final long serialVersionUID = 1L;

    /**
     * 风格表的主键
     */
    private Integer styleId;

    /**
     * 明星的id
     */
    private Integer starId;

    /**
     * 热度
     */
    private Integer heat;

    private Integer goodId;

    public Integer getStyleId() {
        return styleId;
    }

    public void setStyleId(Integer styleId) {
        this.styleId = styleId;
    }
    public Integer getStarId() {
        return starId;
    }

    public void setStarId(Integer starId) {
        this.starId = starId;
    }
    public Integer getHeat() {
        return heat;
    }

    public void setHeat(Integer heat) {
        this.heat = heat;
    }
    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "TStarmetastyle{" +
            "styleId=" + styleId +
            ", starId=" + starId +
            ", heat=" + heat +
            ", goodId=" + goodId +
        "}";
    }
}
