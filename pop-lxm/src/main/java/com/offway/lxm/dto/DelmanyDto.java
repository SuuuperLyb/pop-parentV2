package com.offway.lxm.dto;

import java.util.List;

/**
 * @Author LXM
 * @Date 2020/6/25 0025
 */
public class DelmanyDto {
    private String token;
    /**
     * 购物车id集合
     */
    private List<Integer> scidlist;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<Integer> getScidlist() {
        return scidlist;
    }

    public void setScidlist(List<Integer> scidlist) {
        this.scidlist = scidlist;
    }
}
