package com.offway.lxm.entity;

/**
 * @Author LXM
 * @Date 2020/6/25 0025
 */
public class ShoppingCar {
    /**
     * 主键id
     */
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
     * 商品id
     */
    private Integer tGoodsId;

    /**
     * 商品主图
     */
    private String iImgurl;
    /**
     * 商品标题
     */
    private String tGoodsName;
    /**
     * 商品价格
     */
    private Double tGoodsPrice;

    /**
     * 商品折扣
     */
    private Double tGoodsDiscount;

    /**
     * 商品现价
     */
    private Double tGoodsCurPrice;

    public String getiImgurl() {
        return iImgurl;
    }

    public void setiImgurl(String iImgurl) {
        this.iImgurl = iImgurl;
    }

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

    public Integer gettGoodsId() {
        return tGoodsId;
    }

    public void settGoodsId(Integer tGoodsId) {
        this.tGoodsId = tGoodsId;
    }

    public String gettGoodsName() {
        return tGoodsName;
    }

    public void settGoodsName(String tGoodsName) {
        this.tGoodsName = tGoodsName;
    }

    public Double gettGoodsPrice() {
        return tGoodsPrice;
    }

    public void settGoodsPrice(Double tGoodsPrice) {
        this.tGoodsPrice = tGoodsPrice;
    }

    public Double gettGoodsDiscount() {
        return tGoodsDiscount;
    }

    public void settGoodsDiscount(Double tGoodsDiscount) {
        this.tGoodsDiscount = tGoodsDiscount;
    }

    public Double gettGoodsCurPrice() {
        return tGoodsCurPrice;
    }

    public void settGoodsCurPrice(Double tGoodsCurPrice) {
        this.tGoodsCurPrice = tGoodsCurPrice;
    }
}
