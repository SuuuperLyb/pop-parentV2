package com.offway.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 * 用户详情表
 * </p>
 *
 * @author LYB
 * @since 2020-06-25
 */
public class TUserDetails extends Model<TUserDetails> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户详情id
     */
    @TableId(value = "ud_id", type = IdType.AUTO)
    private Integer udId;

    /**
     * 用户id
     */
    private Integer uId;

    /**
     * 用户昵称
     */
    private String udName;

    /**
     * 用户头像
     */
    private String udHaardurl;

    /**
     * 用户性别
     */
    private Integer udSex;

    /**
     * 用户生日
     */
    private LocalDate udBrithday;

    /**
     * 用户身高
     */
    private String udHeight;

    /**
     * 用户体重
     */
    private String udWeight;

    /**
     * 创建时间
     */
    private LocalDate udCreateTime;

    /**
     * 是否删除
     */
    private Integer udIsDeleted;

    public Integer getUdId() {
        return udId;
    }

    public void setUdId(Integer udId) {
        this.udId = udId;
    }
    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }
    public String getUdName() {
        return udName;
    }

    public void setUdName(String udName) {
        this.udName = udName;
    }
    public String getUdHaardurl() {
        return udHaardurl;
    }

    public void setUdHaardurl(String udHaardurl) {
        this.udHaardurl = udHaardurl;
    }
    public Integer getUdSex() {
        return udSex;
    }

    public void setUdSex(Integer udSex) {
        this.udSex = udSex;
    }
    public LocalDate getUdBrithday() {
        return udBrithday;
    }

    public void setUdBrithday(LocalDate udBrithday) {
        this.udBrithday = udBrithday;
    }
    public String getUdHeight() {
        return udHeight;
    }

    public void setUdHeight(String udHeight) {
        this.udHeight = udHeight;
    }
    public String getUdWeight() {
        return udWeight;
    }

    public void setUdWeight(String udWeight) {
        this.udWeight = udWeight;
    }
    public LocalDate getUdCreateTime() {
        return udCreateTime;
    }

    public void setUdCreateTime(LocalDate udCreateTime) {
        this.udCreateTime = udCreateTime;
    }
    public Integer getUdIsDeleted() {
        return udIsDeleted;
    }

    public void setUdIsDeleted(Integer udIsDeleted) {
        this.udIsDeleted = udIsDeleted;
    }

    @Override
    protected Serializable pkVal() {
        return this.udId;
    }

    @Override
    public String toString() {
        return "TUserDetails{" +
            "udId=" + udId +
            ", uId=" + uId +
            ", udName=" + udName +
            ", udHaardurl=" + udHaardurl +
            ", udSex=" + udSex +
            ", udBrithday=" + udBrithday +
            ", udHeight=" + udHeight +
            ", udWeight=" + udWeight +
            ", udCreateTime=" + udCreateTime +
            ", udIsDeleted=" + udIsDeleted +
        "}";
    }
}
