package com.offway.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author LYB
 * @since 2020-06-25
 */
public class TUser extends Model<TUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId(value = "u_id", type = IdType.AUTO)
    private Integer uId;

    /**
     * 用户昵称
     */
    private String uName;

    /**
     * 用户手机号
     */
    private Integer uPhone;

    /**
     * 用户密码
     */
    private String uPassword;

    /**
     * 是否存在
     */
    private Integer uIsDelete;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }
    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }
    public Integer getuPhone() {
        return uPhone;
    }

    public void setuPhone(Integer uPhone) {
        this.uPhone = uPhone;
    }
    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }
    public Integer getuIsDelete() {
        return uIsDelete;
    }

    public void setuIsDelete(Integer uIsDelete) {
        this.uIsDelete = uIsDelete;
    }

    @Override
    protected Serializable pkVal() {
        return this.uId;
    }

    @Override
    public String toString() {
        return "TUser{" +
            "uId=" + uId +
            ", uName=" + uName +
            ", uPhone=" + uPhone +
            ", uPassword=" + uPassword +
            ", uIsDelete=" + uIsDelete +
        "}";
    }
}
