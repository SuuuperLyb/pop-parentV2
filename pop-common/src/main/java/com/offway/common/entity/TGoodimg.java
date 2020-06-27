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
public class TGoodimg extends Model<TGoodimg> {

    private static final long serialVersionUID = 1L;

    /**
     * 图片id
     */
    @TableId(value = "i_id", type = IdType.AUTO)
    private Integer iId;

    /**
     * 图片排序
     */
    private Integer iSort;

    /**
     * 是否主图 
     */
    private Integer iMainimg;

    /**
     * 图片链接
     */
    private String iImgurl;

    /**
     * 商品id
     */
    private Integer goodsId;

    public Integer getiId() {
        return iId;
    }

    public void setiId(Integer iId) {
        this.iId = iId;
    }
    public Integer getiSort() {
        return iSort;
    }

    public void setiSort(Integer iSort) {
        this.iSort = iSort;
    }
    public Integer getiMainimg() {
        return iMainimg;
    }

    public void setiMainimg(Integer iMainimg) {
        this.iMainimg = iMainimg;
    }
    public String getiImgurl() {
        return iImgurl;
    }

    public void setiImgurl(String iImgurl) {
        this.iImgurl = iImgurl;
    }
    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    @Override
    protected Serializable pkVal() {
        return this.iId;
    }

    @Override
    public String toString() {
        return "TGoodimg{" +
            "iId=" + iId +
            ", iSort=" + iSort +
            ", iMainimg=" + iMainimg +
            ", iImgurl=" + iImgurl +
            ", goodsId=" + goodsId +
        "}";
    }
}
