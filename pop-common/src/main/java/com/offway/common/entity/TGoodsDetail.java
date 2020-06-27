package com.offway.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 * 
 * </p>
 *
 * @author LYB
 * @since 2020-06-25
 */
public class TGoodsDetail extends Model<TGoodsDetail> {

    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    @TableId(value = "t_goods_id", type = IdType.AUTO)
    private Integer tGoodsId;

    /**
     * 名称
     */
    private String tGoodsName;

    /**
     * 英文名称
     */
    private String tGoodsEngname;

    /**
     * 商品尺寸
     */
    private String tGoodsSize;

    /**
     * 商品价格
     */
    private Double tGoodsPrice;

    /**
     * 商品折扣
     */
    private Double tGoodsDiscount;

    /**
     * 商品现价
     */
    private Double tGoodsCurPrice;

    /**
     * 商品库存
     */
    private Integer tGoodsStock;

    /**
     * 商品销量
     */
    private Integer tGoodsSales;

    /**
     * 商铺id
     */
    private Integer tStoreId;

    /**
     * 商品材质
     */
    private String tGoodsSort;

    /**
     * 排列位置
     */
    private Integer tGoodsRank;

    /**
     * 商品二级id
     */
    private String tSectypeId;

    /**
     * 是否有效
     */



    private Integer tGoodsIsvalid;
    /**
     * 商品颜色
     */
    private String tGoodsColor;

    /**
     * 商品上架时间
     * @return
     */
    private LocalDate tCreatTime;

    @Override
    public String toString() {
        return "TGoodsDetail{" +
                "tGoodsId=" + tGoodsId +
                ", tGoodsName='" + tGoodsName + '\'' +
                ", tGoodsEngname='" + tGoodsEngname + '\'' +
                ", tGoodsSize='" + tGoodsSize + '\'' +
                ", tGoodsPrice=" + tGoodsPrice +
                ", tGoodsDiscount=" + tGoodsDiscount +
                ", tGoodsCurPrice=" + tGoodsCurPrice +
                ", tGoodsStock=" + tGoodsStock +
                ", tGoodsSales=" + tGoodsSales +
                ", tStoreId=" + tStoreId +
                ", tGoodsSort='" + tGoodsSort + '\'' +
                ", tGoodsRank=" + tGoodsRank +
                ", tSectypeId='" + tSectypeId + '\'' +
                ", tGoodsIsvalid=" + tGoodsIsvalid +
                ", tGoodsColor='" + tGoodsColor + '\'' +
                ", tCreatTime=" + tCreatTime +
                '}';
    }

    public String gettGoodsColor() {
        return tGoodsColor;
    }

    public void settGoodsColor(String tGoodsColor) {
        this.tGoodsColor = tGoodsColor;
    }

    public LocalDate gettCreatTime() {
        return tCreatTime;
    }

    public void settCreatTime(LocalDate tCreatTime) {
        this.tCreatTime = tCreatTime;
    }

    public Integer gettGoodsId() {
        return tGoodsId;
    }

    public void settGoodsId(Integer tGoodsId) {
        this.tGoodsId = tGoodsId;
    }
    public String gettGoodsName() {
        return tGoodsName;
    }

    public void settGoodsName(String tGoodsName) {
        this.tGoodsName = tGoodsName;
    }
    public String gettGoodsEngname() {
        return tGoodsEngname;
    }

    public void settGoodsEngname(String tGoodsEngname) {
        this.tGoodsEngname = tGoodsEngname;
    }
    public String gettGoodsSize() {
        return tGoodsSize;
    }

    public void settGoodsSize(String tGoodsSize) {
        this.tGoodsSize = tGoodsSize;
    }
    public Double gettGoodsPrice() {
        return tGoodsPrice;
    }

    public void settGoodsPrice(Double tGoodsPrice) {
        this.tGoodsPrice = tGoodsPrice;
    }
    public Double gettGoodsDiscount() {
        return tGoodsDiscount;
    }

    public void settGoodsDiscount(Double tGoodsDiscount) {
        this.tGoodsDiscount = tGoodsDiscount;
    }
    public Double gettGoodsCurPrice() {
        return tGoodsCurPrice;
    }

    public void settGoodsCurPrice(Double tGoodsCurPrice) {
        this.tGoodsCurPrice = tGoodsCurPrice;
    }
    public Integer gettGoodsSales() {
        return tGoodsSales;
    }

    public Integer gettGoodsStock() {
        return tGoodsStock;
    }
    public void settGoodsStock(Integer tGoodsStock) {
        this.tGoodsStock = tGoodsStock;
    }

    public void settGoodsSales(Integer tGoodsSales) {
        this.tGoodsSales = tGoodsSales;
    }
    public Integer gettStoreId() {
        return tStoreId;
    }

    public void settStoreId(Integer tStoreId) {
        this.tStoreId = tStoreId;
    }
    public String gettGoodsSort() {
        return tGoodsSort;
    }

    public void settGoodsSort(String tGoodsSort) {
        this.tGoodsSort = tGoodsSort;
    }
    public Integer gettGoodsRank() {
        return tGoodsRank;
    }

    public void settGoodsRank(Integer tGoodsRank) {
        this.tGoodsRank = tGoodsRank;
    }
    public String gettSectypeId() {
        return tSectypeId;
    }

    public void settSectypeId(String tSectypeId) {
        this.tSectypeId = tSectypeId;
    }
    public Integer gettGoodsIsvalid() {
        return tGoodsIsvalid;
    }

    public void settGoodsIsvalid(Integer tGoodsIsvalid) {
        this.tGoodsIsvalid = tGoodsIsvalid;
    }

    @Override
    protected Serializable pkVal() {
        return this.tGoodsId;
    }

}
