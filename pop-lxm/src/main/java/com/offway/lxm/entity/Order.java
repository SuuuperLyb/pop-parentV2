package com.offway.lxm.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;

/**
 * @Author LXM
 * @Date 2020/6/26 0026
 */
public class Order {

    /**
     * 主键id
     */
    private Integer oId;


    /**
     * 商品id
     */
    private Integer gId;
    /**
     *商品图片
     */
    private String iImgurl;
    /**
     * 商品标题
     */
    private String tGoodsName;
    /**
     * 商品现价
     */
    private Double tGoodsCurPrice;

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

    public Integer getgId() {
        return gId;
    }

    public void setgId(Integer gId) {
        this.gId = gId;
    }

    public String getiImgurl() {
        return iImgurl;
    }

    public void setiImgurl(String iImgurl) {
        this.iImgurl = iImgurl;
    }

    public String gettGoodsName() {
        return tGoodsName;
    }

    public void settGoodsName(String tGoodsName) {
        this.tGoodsName = tGoodsName;
    }

    public Double gettGoodsCurPrice() {
        return tGoodsCurPrice;
    }

    public void settGoodsCurPrice(Double tGoodsCurPrice) {
        this.tGoodsCurPrice = tGoodsCurPrice;
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
}
