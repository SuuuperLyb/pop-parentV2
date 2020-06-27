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
public class TFirsttype extends Model<TFirsttype> {

    private static final long serialVersionUID = 1L;

    /**
     * 一级分类id
     */
    @TableId(value = "t_firsttype_id", type = IdType.AUTO)
    private Integer tFirsttypeId;

    /**
     * 大类名称
     */
    private String tFirsttypeName;

    /**
     * 1有效0无效
     */
    private Integer tFirsttypeIsvalid;

    public Integer gettFirsttypeId() {
        return tFirsttypeId;
    }

    public void settFirsttypeId(Integer tFirsttypeId) {
        this.tFirsttypeId = tFirsttypeId;
    }
    public String gettFirsttypeName() {
        return tFirsttypeName;
    }

    public void settFirsttypeName(String tFirsttypeName) {
        this.tFirsttypeName = tFirsttypeName;
    }
    public Integer gettFirsttypeIsvalid() {
        return tFirsttypeIsvalid;
    }

    public void settFirsttypeIsvalid(Integer tFirsttypeIsvalid) {
        this.tFirsttypeIsvalid = tFirsttypeIsvalid;
    }

    @Override
    protected Serializable pkVal() {
        return this.tFirsttypeId;
    }

    @Override
    public String toString() {
        return "TFirsttype{" +
            "tFirsttypeId=" + tFirsttypeId +
            ", tFirsttypeName=" + tFirsttypeName +
            ", tFirsttypeIsvalid=" + tFirsttypeIsvalid +
        "}";
    }
}
