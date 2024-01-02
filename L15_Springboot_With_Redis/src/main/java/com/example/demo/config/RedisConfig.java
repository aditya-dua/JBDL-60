package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableRedisRepositories
public class RedisConfig {

	@Bean
	public JedisConnectionFactory connectionFactory() {
		//RedisStandaloneConfiguration config = new RedisStandaloneConfiguration("localhost", 6379);
		RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
		
		//config.setHostName("redis-11372.c305.ap-south-1-1.ec2.cloud.redislabs.com");
		config.setHostName("redis-19441.c326.us-east-1-3.ec2.cloud.redislabs.com");
		
		//config.setPassword("XqbradhamVP12lGlyQ0P4Vn76O3d2aC4");
		config.setPassword("jZvtRcfGf1IvgxSz3Fyfb0OCsYywafiZ");
		config.setPort(19441);
		config.setUsername("default");
		
		return new JedisConnectionFactory(config);
	}
	
	@Bean
	public RedisTemplate<String, Object> template(){
		RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
		template.setConnectionFactory(connectionFactory());
		return template;
	}
	
	
	
}
