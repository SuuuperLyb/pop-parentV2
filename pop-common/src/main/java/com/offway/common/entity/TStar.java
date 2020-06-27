package com.offway.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * <p>
 * 明星star表
 * </p>
 *
 * @author LYB
 * @since 2020-06-25
 */
public class TStar extends Model<TStar> {

    private static final long serialVersionUID = 1L;

    /**
     * 明星id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 明星名字
     */
    private String starName;

    /**
     * 明星穿搭描述
     */
    private String starWeardescription;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getStarName() {
        return starName;
    }

    public void setStarName(String starName) {
        this.starName = starName;
    }
    public String getStarWeardescription() {
        return starWeardescription;
    }

    public void setStarWeardescription(String starWeardescription) {
        this.starWeardescription = starWeardescription;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TStar{" +
            "id=" + id +
            ", starName=" + starName +
            ", starWeardescription=" + starWeardescription +
        "}";
    }
}
