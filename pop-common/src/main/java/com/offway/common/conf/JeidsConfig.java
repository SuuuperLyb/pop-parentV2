package com.offway.common.conf;

import com.offway.common.three.JedisCore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


@Configuration
public class JeidsConfig {
    @Value("${pop.redis.host}")
    private String host;

    @Value("${pop.redis.port}")
    private int port;

    @Value("${pop.redis.pwd}")
    private String pwd;

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public JedisCore creatJedisCore(){
        return new JedisCore(host,port,pwd);
    }
}
