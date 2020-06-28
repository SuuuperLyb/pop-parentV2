package com.offway.popzgy.three;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;

/**
 * @program: HungryApi
 * @description: 基于JWT算法生成令牌
 * @author: Feri(邢朋辉)
 * @create: 2020-06-18 15:53
 */
public class JwtCore {

    /**
     * 生成加密的令牌*/
    public static String createToken(String msg){
        //1、创建加密的技术-sha-256
        SignatureAlgorithm signatureAlgorithm= SignatureAlgorithm.HS256;
        //2、创建JWT建造者对象
        JwtBuilder jwtBuilder= Jwts.builder();
        //3、设置JWt相关信息
        jwtBuilder.setIssuedAt(new Date());//开始时间
        jwtBuilder.setSubject(msg);//设置JWT中的内容
        jwtBuilder.signWith(signatureAlgorithm,createKey());
        //4、生成JWT
        return jwtBuilder.compact();
    }


    //解析 令牌
    public static String parseJWT(String token){
        SecretKey key=createKey();
        Claims claims=Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
    //生成秘钥
    private static SecretKey createKey(){
        byte[] keys="netpackettoken".getBytes();
        SecretKey key=new SecretKeySpec(keys,0,keys.length,"AES");
        return key;
    }
}
