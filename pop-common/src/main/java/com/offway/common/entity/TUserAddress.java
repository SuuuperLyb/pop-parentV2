package com.offway.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * <p>
 * 用户地址表
 * </p>
 *
 * @author LYB
 * @since 2020-06-25
 */
public class TUserAddress extends Model<TUserAddress> {

    private static final long serialVersionUID = 1L;

    /**
     * 地址id
     */
    @TableId(value = "ua_id", type = IdType.AUTO)
    private Integer uaId;

    /**
     * 收货人姓名
     */
    private String uaName;

    /**
     * 收货人手机号
     */
    private Integer uaPhone;

    /**
     * 省份
     */
    private String uaProvince;

    /**
     * 市级
     */
    private String uaCity;

    /**
     * 县级
     */
    private String uaDistrict;

    /**
     * 详细门牌号
     */
    private String uaDescription;

    /**
     * 状态（是否存在）
     */
    private Integer uaStatus;

    /**
     * 用户id
     */
    private Integer uId;

    public Integer getUaId() {
        return uaId;
    }

    public void setUaId(Integer uaId) {
        this.uaId = uaId;
    }
    public String getUaName() {
        return uaName;
    }

    public void setUaName(String uaName) {
        this.uaName = uaName;
    }
    public Integer getUaPhone() {
        return uaPhone;
    }

    public void setUaPhone(Integer uaPhone) {
        this.uaPhone = uaPhone;
    }
    public String getUaProvince() {
        return uaProvince;
    }

    public void setUaProvince(String uaProvince) {
        this.uaProvince = uaProvince;
    }
    public String getUaCity() {
        return uaCity;
    }

    public void setUaCity(String uaCity) {
        this.uaCity = uaCity;
    }
    public String getUaDistrict() {
        return uaDistrict;
    }

    public void setUaDistrict(String uaDistrict) {
        this.uaDistrict = uaDistrict;
    }
    public String getUaDescription() {
        return uaDescription;
    }

    public void setUaDescription(String uaDescription) {
        this.uaDescription = uaDescription;
    }
    public Integer getUaStatus() {
        return uaStatus;
    }

    public void setUaStatus(Integer uaStatus) {
        this.uaStatus = uaStatus;
    }
    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    @Override
    protected Serializable pkVal() {
        return this.uaId;
    }

    @Override
    public String toString() {
        return "TUserAddress{" +
            "uaId=" + uaId +
            ", uaName=" + uaName +
            ", uaPhone=" + uaPhone +
            ", uaProvince=" + uaProvince +
            ", uaCity=" + uaCity +
            ", uaDistrict=" + uaDistrict +
            ", uaDescription=" + uaDescription +
            ", uaStatus=" + uaStatus +
            ", uId=" + uId +
        "}";
    }
}
