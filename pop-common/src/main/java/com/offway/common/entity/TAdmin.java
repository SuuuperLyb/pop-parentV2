package com.offway.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author LYB
 * @since 2020-06-25
 */
public class TAdmin extends Model<TAdmin> {

    private static final long serialVersionUID = 1L;

    /**
     * 管理员账号，主键
     */
    @TableId(value = "a_id", type = IdType.AUTO)
    private Integer aId;

    /**
     * 管理员密码
     */
    private String aPassword;

    /**
     * 管理员支付账号
     */
    private Integer aPaynum;

    /**
     * 店铺ID
     */
    private Integer sId;

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }
    public String getaPassword() {
        return aPassword;
    }

    public void setaPassword(String aPassword) {
        this.aPassword = aPassword;
    }
    public Integer getaPaynum() {
        return aPaynum;
    }

    public void setaPaynum(Integer aPaynum) {
        this.aPaynum = aPaynum;
    }
    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    @Override
    protected Serializable pkVal() {
        return this.aId;
    }

    @Override
    public String toString() {
        return "TAdmin{" +
            "aId=" + aId +
            ", aPassword=" + aPassword +
            ", aPaynum=" + aPaynum +
            ", sId=" + sId +
        "}";
    }
}
