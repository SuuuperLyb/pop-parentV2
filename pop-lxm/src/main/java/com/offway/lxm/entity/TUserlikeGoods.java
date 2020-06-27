package com.offway.lxm.entity;

import java.time.LocalDate;

/**
 * @Author LXM
 * @Date 2020/6/25 0025
 */
public class TUserlikeGoods {
    /**
     * 用户喜欢id
     */
    private Integer lId;

    /**
     * 商品id(可以为空)
     */
    private Integer gId;

    /**
     * 商品名称
     */
    private String tGoodsName;
    /**
     * 商品主图
     */
    private String iImgurl;

    /**
     * 创建时间
     */
    private LocalDate lCreateTime;

    /**
     * 用户喜欢状态(存在1,删除0)
     */
    private Integer lStatus;

    public Integer getlId() {
        return lId;
    }

    public void setlId(Integer lId) {
        this.lId = lId;
    }

    public Integer getgId() {
        return gId;
    }

    public void setgId(Integer gId) {
        this.gId = gId;
    }

    public String gettGoodsName() {
        return tGoodsName;
    }

    public void settGoodsName(String tGoodsName) {
        this.tGoodsName = tGoodsName;
    }

    public String getiImgurl() {
        return iImgurl;
    }

    public void setiImgurl(String iImgurl) {
        this.iImgurl = iImgurl;
    }

    public LocalDate getlCreateTime() {
        return lCreateTime;
    }

    public void setlCreateTime(LocalDate lCreateTime) {
        this.lCreateTime = lCreateTime;
    }

    public Integer getlStatus() {
        return lStatus;
    }

    public void setlStatus(Integer lStatus) {
        this.lStatus = lStatus;
    }
}
