package com.offway.lxm.entity;

import java.time.LocalDate;

/**
 * @Author LXM
 * @Date 2020/6/25 0025
 */
public class TUserlikeStore {
    /**
     * 用户喜欢id
     */
    private Integer lId;

    /**
     * 店铺
     */
    private int sId;
    /**
     * 店铺主图
     */
    private String sImg;
    /**
     * 店铺名称
     */
    private String sName;
    /**
     * 店铺logo
     */
    private String sLogo;

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

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getsImg() {
        return sImg;
    }

    public void setsImg(String sImg) {
        this.sImg = sImg;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsLogo() {
        return sLogo;
    }

    public void setsLogo(String sLogo) {
        this.sLogo = sLogo;
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
