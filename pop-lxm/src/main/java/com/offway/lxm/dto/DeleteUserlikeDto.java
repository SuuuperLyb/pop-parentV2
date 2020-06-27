package com.offway.lxm.dto;

/**
 * @Author LXM
 * @Date 2020/6/25 0025
 */
public class DeleteUserlikeDto {
    private String token;
    /**
     * 用户喜欢id
     */
    private int id;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
