package com.offway.lxm.dto;

/**
 * @Author LXM
 * @Date 2020/6/26 0026
 */
public class DelOneOrderDto {
    private String token;
    /**
     * 订单id
     */
    private int oId;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getoId() {
        return oId;
    }

    public void setoId(int oId) {
        this.oId = oId;
    }
}
