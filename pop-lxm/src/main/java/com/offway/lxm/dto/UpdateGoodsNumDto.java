package com.offway.lxm.dto;

/**
 * @Author LXM
 * @Date 2020/6/25 0025
 */
public class UpdateGoodsNumDto {
    private String token;
    /**
     * 购物车id
     */
    private int scId;
    /**
     * 商品数量
     */
    private int gNum;

    public int getScId() {
        return scId;
    }

    public void setScId(int scId) {
        this.scId = scId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getgNum() {
        return gNum;
    }

    public void setgNum(int gNum) {
        this.gNum = gNum;
    }
}
