package com.offway.lxm.dto;

import java.util.List;

/**
 * @Author LXM
 * @Date 2020/6/26 0026
 */
public class DelManyOrderDto {
    private String token;
    private List<Integer> oIdlist;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<Integer> getoIdlist() {
        return oIdlist;
    }

    public void setoIdlist(List<Integer> oIdlist) {
        this.oIdlist = oIdlist;
    }
}
