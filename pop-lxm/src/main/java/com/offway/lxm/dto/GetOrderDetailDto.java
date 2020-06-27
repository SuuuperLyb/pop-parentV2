package com.offway.lxm.dto;

/**
 * @Author LXM
 * @Date 2020/6/27 0027
 */
public class GetOrderDetailDto {
    private String token;
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
