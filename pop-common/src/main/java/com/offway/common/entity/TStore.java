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
public class TStore extends Model<TStore> {

    private static final long serialVersionUID = 1L;

    /**
     * 店铺ID，主键
     */
    @TableId(value = "s_id", type = IdType.AUTO)
    private Integer sId;

    /**
     * 店铺logo
     */
    private String sLogo;

    /**
     * 店铺描述
     */
    private String sDescribe;

    /**
     * 店铺主图
     */
    private String sImg;

    /**
     * 品牌ID
     */
    private Integer bId;

    /**
     * 店铺名称
     */
    private String sName;

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }
    public String getsLogo() {
        return sLogo;
    }

    public void setsLogo(String sLogo) {
        this.sLogo = sLogo;
    }
    public String getsDescribe() {
        return sDescribe;
    }

    public void setsDescribe(String sDescribe) {
        this.sDescribe = sDescribe;
    }
    public String getsImg() {
        return sImg;
    }

    public void setsImg(String sImg) {
        this.sImg = sImg;
    }
    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
    }
    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    @Override
    protected Serializable pkVal() {
        return this.sId;
    }

    @Override
    public String toString() {
        return "TStore{" +
            "sId=" + sId +
            ", sLogo=" + sLogo +
            ", sDescribe=" + sDescribe +
            ", sImg=" + sImg +
            ", bId=" + bId +
            ", sName=" + sName +
        "}";
    }
}
