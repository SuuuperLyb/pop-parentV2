package com.offway.lxm.dto;

/**
 * @Author LXM
 * @Date 2020/6/27 0027
 */
public class OrderCommitDto {
    private String token;
    private Integer oId;
    private String commentContent;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }
}
