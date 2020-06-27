package com.offway.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * <p>
 * 商品风格表(style)
 * </p>
 *
 * @author LYB
 * @since 2020-06-25
 */
public class TStyle extends Model<TStyle> {

    private static final long serialVersionUID = 1L;

    /**
     * 商品风格id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品风格名称
     */
    private String styleName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getStyleName() {
        return styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TStyle{" +
            "id=" + id +
            ", styleName=" + styleName +
        "}";
    }
}
