package com.offway.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * <p>
 * 商品类别表(type)
 * </p>
 *
 * @author LYB
 * @since 2020-06-25
 */
public class TType extends Model<TType> {

    private static final long serialVersionUID = 1L;

    /**
     * 商品类别id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品类别名称
     */
    private String typeName;

    /**
     * 商品类别图例
     */
    private String typePicture;

    /**
     * 商品类别描述
     */
    private String typeDescribe;

    /**
     * 商品id
     */
    private Integer goodsId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    public String getTypePicture() {
        return typePicture;
    }

    public void setTypePicture(String typePicture) {
        this.typePicture = typePicture;
    }
    public String getTypeDescribe() {
        return typeDescribe;
    }

    public void setTypeDescribe(String typeDescribe) {
        this.typeDescribe = typeDescribe;
    }
    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TType{" +
            "id=" + id +
            ", typeName=" + typeName +
            ", typePicture=" + typePicture +
            ", typeDescribe=" + typeDescribe +
            ", goodsId=" + goodsId +
        "}";
    }
}
