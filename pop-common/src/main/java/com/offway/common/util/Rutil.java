package com.offway.common.util;


import com.offway.common.entity.R;
import com.offway.common.type.RcodeType;

public class Rutil{
    public static R Ok(String msg, Object  data){
        return new R(RcodeType.成功.getValue(),msg,data);
    }

    public static R Ok(){
        return new R(RcodeType.成功.getValue(),"Ok",null);
    }

    public static R Ok(Object data){
        return new R (RcodeType.成功.getValue(),"Ok",data);
    }

    public static R err(String msg){
        return new R(RcodeType.失败.getValue(),msg,null);
    }

    public static R err(){
        return new R (RcodeType.失败.getValue(),"ERR",null);
    }


}
