package com.offway.popgxb.dto;

import lombok.Data;
import java.util.Date;

/**
 * @PackgeName: com.offway.popgxb.dto
 * @ClassName: UpdateGoodsDetailDto
 * @Author: gxb
 * Date: 2020/6/25 18:13:33
 * project name: pop-parent
 * @Version:
 * @Description: 修改商品信息的数据传输对象
 */
@Data
public class UpdateGoodsDetailDto {
    private Integer tGoodsId;
    private String tGoodsName;
    private String tGoodsEngname;
    private String tGoodsSize;
    private Double tGoodsPrice;
    private Double tGoodsDiscount;
    private Double tGoodsCurPrice;
    private Integer tGoodsStock;
    private Integer tGoodsSales;
    private Integer tStoreId;
    private String tGoodsSort;
    private Integer tGoodsRank;
    private String tSectypeId;
    private Integer tGoodsIsvalid;
    private String tGoodsColor;
    private String tCreatTime;

    public UpdateGoodsDetailDto() {
    }

    public UpdateGoodsDetailDto(String tGoodsName, String tGoodsEngname, String tGoodsSize, Double tGoodsPrice, Double tGoodsDiscount, Double tGoodsCurPrice, Integer tGoodsStock, Integer tGoodsSales, Integer tStoreId, String tGoodsSort, Integer tGoodsRank, String tSectypeId, Integer tGoodsIsvalid, String tGoodsColor, String tCreatTime) {
        this.tGoodsName = tGoodsName;
        this.tGoodsEngname = tGoodsEngname;
        this.tGoodsSize = tGoodsSize;
        this.tGoodsPrice = tGoodsPrice;
        this.tGoodsDiscount = tGoodsDiscount;
        this.tGoodsCurPrice = tGoodsCurPrice;
        this.tGoodsStock = tGoodsStock;
        this.tGoodsSales = tGoodsSales;
        this.tStoreId = tStoreId;
        this.tGoodsSort = tGoodsSort;
        this.tGoodsRank = tGoodsRank;
        this.tSectypeId = tSectypeId;
        this.tGoodsIsvalid = tGoodsIsvalid;
        this.tGoodsColor = tGoodsColor;
        this.tCreatTime = tCreatTime;
    }

    public UpdateGoodsDetailDto(Integer tGoodsId, String tGoodsName, String tGoodsEngname, String tGoodsSize, Double tGoodsPrice, Double tGoodsDiscount, Double tGoodsCurPrice, Integer tGoodsStock, Integer tGoodsSales, Integer tStoreId, String tGoodsSort, Integer tGoodsRank, String tSectypeId, Integer tGoodsIsvalid, String tGoodsColor, String tCreatTime) {
        this.tGoodsId = tGoodsId;
        this.tGoodsName = tGoodsName;
        this.tGoodsEngname = tGoodsEngname;
        this.tGoodsSize = tGoodsSize;
        this.tGoodsPrice = tGoodsPrice;
        this.tGoodsDiscount = tGoodsDiscount;
        this.tGoodsCurPrice = tGoodsCurPrice;
        this.tGoodsStock = tGoodsStock;
        this.tGoodsSales = tGoodsSales;
        this.tStoreId = tStoreId;
        this.tGoodsSort = tGoodsSort;
        this.tGoodsRank = tGoodsRank;
        this.tSectypeId = tSectypeId;
        this.tGoodsIsvalid = tGoodsIsvalid;
        this.tGoodsColor = tGoodsColor;
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

    public Integer gettGoodsStock() {
        return tGoodsStock;
    }

    public void settGoodsStock(Integer tGoodsStock) {
        this.tGoodsStock = tGoodsStock;
    }

    public Integer gettGoodsSales() {
        return tGoodsSales;
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
}
