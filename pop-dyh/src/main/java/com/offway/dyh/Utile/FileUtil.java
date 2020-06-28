package com.offway.dyh.Utile;

import java.util.UUID;


public class FileUtil {

    public static String renameFile(String fname){
        if(fname.length()>30){
            fname=fname.substring(fname.length()-30);
        }
        return UUID.randomUUID().toString().replace("-","")+"_"+fname;
    }
}
