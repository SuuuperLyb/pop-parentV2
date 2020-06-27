package com.offway.common.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class R {

    /**
     * 统一结果
     */

    private int code;

    private String msg;

    private Object object;

    public static R succ(Object data){
        return new R(200,"Ok",data);
    }

    public static R succ(){
        return new R(200,"OK",null);
    }

//    public static R cucc(String msg){
//        return new R(200,msg,);
//    }
}
