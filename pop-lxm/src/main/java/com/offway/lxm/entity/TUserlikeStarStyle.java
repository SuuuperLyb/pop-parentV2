package com.offway.lxm.entity;

import java.time.LocalDate;
import java.util.List;

/**
 * @Author LXM
 * @Date 2020/6/25 0025
 */
public class TUserlikeStarStyle {
    /**
     * 用户喜欢id
     */
    private Integer lId;
    /**
     * 明星穿搭id
     */
    private int starStyleId;
    /**
     * 明星穿搭图片
     */
    private String starimgUrl;
    /**
     * 明星姓名
     */
    private String starName;

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

    public int getStarStyleId() {
        return starStyleId;
    }

    public void setStarStyleId(int starStyleId) {
        this.starStyleId = starStyleId;
    }

    public String getStarimgUrl() {
        return starimgUrl;
    }

    public void setStarimgUrl(String starimgUrl) {
        this.starimgUrl = starimgUrl;
    }

    public String getStarName() {
        return starName;
    }

    public void setStarName(String starName) {
        this.starName = starName;
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
