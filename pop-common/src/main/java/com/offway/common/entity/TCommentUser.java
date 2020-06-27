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
public class TCommentUser extends Model<TCommentUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 评论id
     */
    @TableId(value = "c_comment_id", type = IdType.AUTO)
    private Integer cCommentId;

    /**
     * 用户id
     */
    private Integer uId;

    /**
     * 评论时间
     */
    private LocalDate cCommentDate;

    /**
     * 评论内容
     */
    private String cCommentContent;

    /**
     * 1有效，0无效
     */
    private Integer cIsvalid;

    /**
     * 商品id
     */
    private Integer goodsId;

    public Integer getcCommentId() {
        return cCommentId;
    }

    public void setcCommentId(Integer cCommentId) {
        this.cCommentId = cCommentId;
    }
    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }
    public LocalDate getcCommentDate() {
        return cCommentDate;
    }

    public void setcCommentDate(LocalDate cCommentDate) {
        this.cCommentDate = cCommentDate;
    }
    public String getcCommentContent() {
        return cCommentContent;
    }

    public void setcCommentContent(String cCommentContent) {
        this.cCommentContent = cCommentContent;
    }
    public Integer getcIsvalid() {
        return cIsvalid;
    }

    public void setcIsvalid(Integer cIsvalid) {
        this.cIsvalid = cIsvalid;
    }
    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    @Override
    protected Serializable pkVal() {
        return this.cCommentId;
    }

    @Override
    public String toString() {
        return "TCommentUser{" +
            "cCommentId=" + cCommentId +
            ", uId=" + uId +
            ", cCommentDate=" + cCommentDate +
            ", cCommentContent=" + cCommentContent +
            ", cIsvalid=" + cIsvalid +
            ", goodsId=" + goodsId +
        "}";
    }
}
