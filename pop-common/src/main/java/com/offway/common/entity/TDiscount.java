package com.offway.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 * 
 * </p>
 *
 * @author LYB
 * @since 2020-06-25
 */
public class TDiscount extends Model<TDiscount> {

    private static final long serialVersionUID = 1L;

    /**
     * 优惠券ID，主键
     */
    @TableId(value = "d_id", type = IdType.AUTO)
    private Integer dId;

    /**
     * 优惠券开始日期
     */
    private LocalDate dStarttime;

    /**
     * 优惠券结束日期
     */
    private LocalDate dEndtime;

    /**
     * 优惠券数量
     */
    private Integer dCount;

    /**
     * 优惠券使用门槛
     */
    private Integer dSill;

    /**
     * 活动ID
     */
    private Integer cId;

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }
    public LocalDate getdStarttime() {
        return dStarttime;
    }

    public void setdStarttime(LocalDate dStarttime) {
        this.dStarttime = dStarttime;
    }
    public LocalDate getdEndtime() {
        return dEndtime;
    }

    public void setdEndtime(LocalDate dEndtime) {
        this.dEndtime = dEndtime;
    }
    public Integer getdCount() {
        return dCount;
    }

    public void setdCount(Integer dCount) {
        this.dCount = dCount;
    }
    public Integer getdSill() {
        return dSill;
    }

    public void setdSill(Integer dSill) {
        this.dSill = dSill;
    }
    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    @Override
    protected Serializable pkVal() {
        return this.dId;
    }

    @Override
    public String toString() {
        return "TDiscount{" +
            "dId=" + dId +
            ", dStarttime=" + dStarttime +
            ", dEndtime=" + dEndtime +
            ", dCount=" + dCount +
            ", dSill=" + dSill +
            ", cId=" + cId +
        "}";
    }
}
