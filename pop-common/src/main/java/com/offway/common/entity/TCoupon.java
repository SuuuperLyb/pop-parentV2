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
public class TCoupon extends Model<TCoupon> {

    private static final long serialVersionUID = 1L;

    /**
     * 活动ID,主键
     */
    @TableId(value = "c_id", type = IdType.AUTO)
    private Integer cId;

    /**
     * 活动名称
     */
    private String cName;

    /**
     * 活动图片
     */
    private String cImg;

    /**
     * 活动内容
     */
    private String cContent;

    /**
     * 店铺ID，
     */
    private Integer sId;

    private Integer cSort;

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }
    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }
    public String getcImg() {
        return cImg;
    }

    public void setcImg(String cImg) {
        this.cImg = cImg;
    }
    public String getcContent() {
        return cContent;
    }

    public void setcContent(String cContent) {
        this.cContent = cContent;
    }
    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }
    public Integer getcSort() {
        return cSort;
    }

    public void setcSort(Integer cSort) {
        this.cSort = cSort;
    }

    @Override
    protected Serializable pkVal() {
        return this.cId;
    }

    @Override
    public String toString() {
        return "TCoupon{" +
            "cId=" + cId +
            ", cName=" + cName +
            ", cImg=" + cImg +
            ", cContent=" + cContent +
            ", sId=" + sId +
            ", cSort=" + cSort +
        "}";
    }
}
