package com.offway.common.type;

public enum RcodeType {
    成功(200),失败(500);
    private int value;
    private RcodeType(int v){
        value = v;
    }
    public int getValue(){
        return value;
    }
}
