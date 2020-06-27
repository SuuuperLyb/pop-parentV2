package com.offway.lxm.dto;

/**
 * @Author LXM
 * @Date 2020/6/27 0027
 */
public class UpdateOrderDto {
    private String token;
    private Integer oId;

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
}
