package com.caldatto.rediscrud.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

import com.caldatto.rediscrud.model.Person;

@Configuration
public class RedisConfig {

    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private Integer port;

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {

        final RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setValueSerializer(new GenericToStringSerializer<>(Object.class));
        return template;
    }

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }

//    @Bean
//    JedisConnectionFactory jedisConnectionFactory() {
//        var redisStandAloneConfiguration = new RedisStandaloneConfiguration(host, port);
//        return new JedisConnectionFactory(redisStandAloneConfiguration);
//    }
//
//    @Bean
//    public RedisTemplate<String, Person> redisTemplate(JedisConnectionFactory jedisConnectionFactory){
//        var personTemplate = new RedisTemplate<String, Person>();
//        personTemplate.setConnectionFactory(jedisConnectionFactory());
//
//        return personTemplate;
//    }

}
