package com.wangdian.springboot;


import com.wangdian.springboot.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {App.class})
public class RedisTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test2() throws Exception {
        stringRedisTemplate.opsForValue().set("site", "www.yidiankt.com");
    }

    @Test
    public void test() throws Exception {
        User user = new User();
        user.setAge(10);
        user.setBirth(new Date());
        user.setLastName("yidiankt");
        redisTemplate.opsForValue().set("user", user);
        // User user2 = (User) redisTemplate.opsForValue().get("author");
        // System.out.println(user2);
        }
    }
