package com.offway.common.three;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisCore {

    private Jedis jedis;

    public JedisCore(String host,int port,String password){
        JedisPool jedisPool = new JedisPool(host,port);
        jedis = jedisPool.getResource();
        jedis.auth(password);
    }

    //redis add
    public void set(String key,int sec,String value ){
        jedis.setex(key,sec,value);
    }
    //query getVal
    public String getVal(String key){
        return jedis.get(key);
    }

    //del
    public void del(String key){
        jedis.del(key);
    }

    //setExpire
    public void setEx(String key,int sec){
        jedis.expire(key,sec);
    }

    //isExist
    public boolean isExist(String key){
        return jedis.exists(key);
    }


}
