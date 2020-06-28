package com.offway.common.three;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisCore {

    private Jedis jedis;
    private JedisPool jedisPool;
    private String password;

    public String getPassword(){
        return this.password;
    }

    public Jedis getJedis(){
        return jedisPool.getResource();
    }

    public JedisCore(String host,int port,String password){
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        this.password = password;
        poolConfig.setMaxTotal(1000);
        jedisPool = new JedisPool(poolConfig,host,port);
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
