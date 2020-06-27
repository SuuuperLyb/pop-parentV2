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
public class TUserlike extends Model<TUserlike> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "l_id", type = IdType.AUTO)
    private Integer lId;

    /**
     * 用户id
     */
    private Integer uId;

    /**
     * 商品id(可以为空)
     */
    private Integer gId;

    /**
     * 店铺id(可以为空)
     */
    private Integer storeId;

    /**
     * 明星穿搭id(可以为空)
     */
    private Integer starId;

    /**
     * 创建时间
     */
    private LocalDate lCreateTime;

    /**
     * 用户喜欢状态(存在1,删除0)
     */
    private Integer lStatus;

    public Integer getlId() {
        return lId;
    }

    public void setlId(Integer lId) {
        this.lId = lId;
    }
    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }
    public Integer getgId() {
        return gId;
    }

    public void setgId(Integer gId) {
        this.gId = gId;
    }
    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }
    public Integer getStarId() {
        return starId;
    }

    public void setStarId(Integer starId) {
        this.starId = starId;
    }
    public LocalDate getlCreateTime() {
        return lCreateTime;
    }

    public void setlCreateTime(LocalDate lCreateTime) {
        this.lCreateTime = lCreateTime;
    }
    public Integer getlStatus() {
        return lStatus;
    }

    public void setlStatus(Integer lStatus) {
        this.lStatus = lStatus;
    }

    @Override
    protected Serializable pkVal() {
        return this.lId;
    }

    @Override
    public String toString() {
        return "TUserlike{" +
            "lId=" + lId +
            ", uId=" + uId +
            ", gId=" + gId +
            ", storeId=" + storeId +
            ", starId=" + starId +
            ", lCreateTime=" + lCreateTime +
            ", lStatus=" + lStatus +
        "}";
    }
}
