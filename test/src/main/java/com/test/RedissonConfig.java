/**
 * @Title: RedissonConfig.java Create on 2020年1月9日 下午12:18:01
 * @author: jiangyuanquan
 * @Description: TODO(用一句话描述该文件做什么)
 * @Package com.test
 * Copyright <a href="mailto:www.ekezhan.com">www.ekezhan.com</a> Corporation 2020
*/
	
package com.test;

import java.io.IOException;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.retry.annotation.EnableRetry;

/**@Description: TODO
 * @author: jiangyuanquan 
 * @version: 2020年1月9日 下午12:18:01
*/

@Configuration 
public class RedissonConfig {  

   @Bean  
   public RedissonClient redissonClient() throws IOException {  
       return Redisson.create(  
               Config.fromYAML(new ClassPathResource("redisson-single.yml").getInputStream())  
       );  
   }  
}  
