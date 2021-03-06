package com.wangdian.springboot.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.*;

@Configuration
//开启Spring cache缓存注解
@EnableCaching
public class MyRedisConfig {
    //springboot 1.几版本的序列化方式跟springboot2.几的不一样， 2.几 是下列方式
    // （使用缓存注解时（@EnableCaching）必须用这种方法，不使用缓存注解的话，两种方法都可以）：
    @Bean
    CacheManager cacheManager(RedisConnectionFactory connectionFactory) {
        //初始化一个RedisCacheWriter
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(connectionFactory);
        //设置CacheManager的值序列化方式为json序列化
        RedisSerializer<Object> jsonSerializer = new GenericJackson2JsonRedisSerializer();//2.几版本redis数据序列化核心方法
        RedisSerializationContext.SerializationPair<Object> pair = RedisSerializationContext.SerializationPair.fromSerializer(jsonSerializer);
        RedisCacheConfiguration defaultCacheConfig = RedisCacheConfiguration.defaultCacheConfig().serializeValuesWith(pair);
        //设置默认超过期时间是30秒
        // defaultCacheConfig.entryTtl(Duration.ofSeconds(30));
        // 初始化RedisCacheManager
        RedisCacheManager cacheManager = new RedisCacheManager(redisCacheWriter, defaultCacheConfig);
        return cacheManager;
    }
        //springboot 1.几版本的序列化方式跟springboot2.几的不一样， 1.几 是下列方式  ：
//        @Bean
//        public RedisTemplate<Object, Object> redisTemplate (RedisConnectionFactory redisConnectionFactory){
//            RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
//            redisTemplate.setConnectionFactory(redisConnectionFactory);
//            // 使用Jackson2JsonRedisSerialize 替换默认序列化
//            Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//            ObjectMapper objectMapper = new ObjectMapper();
//            objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//            objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//            jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
//            // 设置value的序列化规则和 key的序列化规则
//            redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
//            redisTemplate.setKeySerializer(new StringRedisSerializer());
//            redisTemplate.afterPropertiesSet();
//            return redisTemplate;
//        }
    }
