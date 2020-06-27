package com.offway.hqs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * <p>
 * 用户详情表
 * </p>
 *
 * @author LYB
 * @since 2020-06-23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TUserDetailsDto{

    /**
     * 用户id
     */
    private Integer uId;

    /**
     * 用户昵称
     */
    private String udName;

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
     * 用户头像
     */
    private String udHaardurl;

    /**
     * 用户体重
     */
    private String udWeight;

    /**
     * 创建时间
     */
    private LocalDate udCreateTime;


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

    public TUserDetailsDto(Integer uId, String udName, Integer udSex, LocalDate udBrithday, String udHeight, String udWeight, LocalDate udCreateTime) {
        this.uId = uId;
        this.udName = udName;
        this.udSex = udSex;
        this.udBrithday = udBrithday;
        this.udHeight = udHeight;
        this.udWeight = udWeight;
        this.udCreateTime = udCreateTime;
    }



    public TUserDetailsDto(Integer uId, String udHaardurl) {
        this.uId = uId;
        this.udHaardurl = udHaardurl;
    }

}
