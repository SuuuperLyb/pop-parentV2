package com.offway.common.entity;

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
public class TAdmindetail extends Model<TAdmindetail> {

    private static final long serialVersionUID = 1L;

    /**
     * 后台管理员账号，主键
     */
    private String aName;

    private Integer aId;

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }
    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    @Override
    protected Serializable pkVal() {
        return this.aName;
    }

    @Override
    public String toString() {
        return "TAdmindetail{" +
            "aName=" + aName +
            ", aId=" + aId +
        "}";
    }
}
