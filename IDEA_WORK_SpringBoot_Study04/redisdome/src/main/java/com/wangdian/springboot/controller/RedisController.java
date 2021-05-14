package com.wangdian.springboot.controller;

import com.wangdian.springboot.entity.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CacheConfig(cacheNames = "user")
public class RedisController {
    //@CacheConfig(cacheNames = "user")注解后，该类的注解下的缓存注解无需再写明value值
    //@Cacheable(value="user")
    @Cacheable
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable int id){
        //模拟数据返回
        User user =new User();
        user.setId(id);
        user.setLastName("name"+id);
        System.out.println("查询数据库getUser:"+id);
        return  user;
    }

    //@CacheConfig(cacheNames = "user")注解后，该类的注解下的缓存注解无需再写明value值
    //@CachePut(value="user")
    @CachePut
    @GetMapping("/updateUser/{id}")
    public User updateUser(@PathVariable int id){
        //模拟数据返回
        User user =new User();
        user.setId(id);
        user.setLastName("update name"+id);
        System.out.println("更新数据库gupdateUser:"+id);
        return  user;
    }

    //@CacheConfig(cacheNames = "user")注解后，该类的注解下的缓存注解无需再写明value值
    //@CacheEvict(value="user",key = "#id")
    @CacheEvict(key = "#id")
    @GetMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable int id) {
        //模拟数据返回
        System.out.println("删除数据库deleteUser:" + id);
    }

}
