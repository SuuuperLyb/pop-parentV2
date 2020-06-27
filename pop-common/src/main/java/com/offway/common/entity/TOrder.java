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
public class TOrder extends Model<TOrder> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id(自增)
     */
    @TableId(value = "o_id", type = IdType.AUTO)
    private Integer oId;

    /**
     * 用户id
     */
    private Integer uId;

    /**
     * 商品id
     */
    private Integer gId;

    /**
     * 收货人id
     */
    private Integer udId;

    /**
     * 优惠券id
     */
    private Integer cId;

    /**
     * 订单编号(系统随机生成)
     */
    private String oNum;

    /**
     * 订单类型(待付款1,待发货2,待收货3,待评价4)
     */
    private Integer oType;

    /**
     * 购买商品数量
     */
    private Integer oGoodsNum;

    /**
     * 订单创建时间
     */
    private LocalDate oCreateTime;

    /**
     * 订单结算时间
     */
    private LocalDate oFinalTime;

    /**
     * 优惠前订单总金额
     */
    private Double oTotalMoney;

    /**
     * 实际付款金额
     */
    private Double oActualMoney;

    /**
     * 订单状态(存在1,删除0)
     */
    private Integer oStatus;

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }
    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }
    public Integer getgId() {
        return gId;
    }

    public void setgId(Integer gId) {
        this.gId = gId;
    }
    public Integer getUdId() {
        return udId;
    }

    public void setUdId(Integer udId) {
        this.udId = udId;
    }
    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }
    public String getoNum() {
        return oNum;
    }

    public void setoNum(String oNum) {
        this.oNum = oNum;
    }
    public Integer getoType() {
        return oType;
    }

    public void setoType(Integer oType) {
        this.oType = oType;
    }
    public Integer getoGoodsNum() {
        return oGoodsNum;
    }

    public void setoGoodsNum(Integer oGoodsNum) {
        this.oGoodsNum = oGoodsNum;
    }
    public LocalDate getoCreateTime() {
        return oCreateTime;
    }

    public void setoCreateTime(LocalDate oCreateTime) {
        this.oCreateTime = oCreateTime;
    }
    public LocalDate getoFinalTime() {
        return oFinalTime;
    }

    public void setoFinalTime(LocalDate oFinalTime) {
        this.oFinalTime = oFinalTime;
    }
    public Double getoTotalMoney() {
        return oTotalMoney;
    }

    public void setoTotalMoney(Double oTotalMoney) {
        this.oTotalMoney = oTotalMoney;
    }
    public Double getoActualMoney() {
        return oActualMoney;
    }

    public void setoActualMoney(Double oActualMoney) {
        this.oActualMoney = oActualMoney;
    }
    public Integer getoStatus() {
        return oStatus;
    }

    public void setoStatus(Integer oStatus) {
        this.oStatus = oStatus;
    }

    @Override
    protected Serializable pkVal() {
        return this.oId;
    }

    @Override
    public String toString() {
        return "TOrder{" +
            "oId=" + oId +
            ", uId=" + uId +
            ", gId=" + gId +
            ", udId=" + udId +
            ", cId=" + cId +
            ", oNum=" + oNum +
            ", oType=" + oType +
            ", oGoodsNum=" + oGoodsNum +
            ", oCreateTime=" + oCreateTime +
            ", oFinalTime=" + oFinalTime +
            ", oTotalMoney=" + oTotalMoney +
            ", oActualMoney=" + oActualMoney +
            ", oStatus=" + oStatus +
        "}";
    }
}
