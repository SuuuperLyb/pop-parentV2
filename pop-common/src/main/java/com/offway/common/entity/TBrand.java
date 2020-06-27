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
public class TBrand extends Model<TBrand> {

    private static final long serialVersionUID = 1L;

    /**
     * 品牌ID，主键
     */
    @TableId(value = "b_id", type = IdType.AUTO)
    private Integer bId;

    /**
     * 品牌名称
     */
    private String bName;

    /**
     * 品牌logo
     */
    private String bLogo;

    /**
     * 品牌描述
     */
    private String bDescribe;

    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
    }
    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }
    public String getbLogo() {
        return bLogo;
    }

    public void setbLogo(String bLogo) {
        this.bLogo = bLogo;
    }
    public String getbDescribe() {
        return bDescribe;
    }

    public void setbDescribe(String bDescribe) {
        this.bDescribe = bDescribe;
    }

    @Override
    protected Serializable pkVal() {
        return this.bId;
    }

    @Override
    public String toString() {
        return "TBrand{" +
            "bId=" + bId +
            ", bName=" + bName +
            ", bLogo=" + bLogo +
            ", bDescribe=" + bDescribe +
        "}";
    }
}
