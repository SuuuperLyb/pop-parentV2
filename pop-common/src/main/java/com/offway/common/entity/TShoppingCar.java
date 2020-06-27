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
public class TShoppingCar extends Model<TShoppingCar> {

    private static final long serialVersionUID = 1L;

    /**
     * 购物车id
     */
    @TableId(value = "sc_id", type = IdType.AUTO)
    private Integer scId;

    /**
     * 购物车金额
     */
    private Double scAllmoney;

    /**
     * 购物车商品数量
     */
    private Integer scGoodsnum;

    /**
     * 用户id
     */
    private Integer uId;

    /**
     * 商品id
     */
    private Integer goodsId;

    public Integer getScId() {
        return scId;
    }

    public void setScId(Integer scId) {
        this.scId = scId;
    }
    public Double getScAllmoney() {
        return scAllmoney;
    }

    public void setScAllmoney(Double scAllmoney) {
        this.scAllmoney = scAllmoney;
    }
    public Integer getScGoodsnum() {
        return scGoodsnum;
    }

    public void setScGoodsnum(Integer scGoodsnum) {
        this.scGoodsnum = scGoodsnum;
    }
    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }
    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    @Override
    protected Serializable pkVal() {
        return this.scId;
    }

    @Override
    public String toString() {
        return "TShoppingCar{" +
            "scId=" + scId +
            ", scAllmoney=" + scAllmoney +
            ", scGoodsnum=" + scGoodsnum +
            ", uId=" + uId +
            ", goodsId=" + goodsId +
        "}";
    }
}
