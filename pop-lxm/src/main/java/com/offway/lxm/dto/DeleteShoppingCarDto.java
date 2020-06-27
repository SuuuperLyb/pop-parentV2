package com.offway.lxm.dto;

/**
 * @Author LXM
 * @Date 2020/6/25 0025
 */
public class DeleteShoppingCarDto {
    private String token;
    /**
     * 购物车id
     */
    private int scId;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getScId() {
        return scId;
    }

    public void setScId(int scId) {
        this.scId = scId;
    }
}
