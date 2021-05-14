package com.wangdian.springboot.service.impl;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component//交给Spring容器处理
public class MySchedulerTask {
    private int count = 0;
    //6位：秒分时天月星（年）：Spring3.0自带的Task是不支持年位的
    //如果是Spring+Quartz就没问题,可以带年位
    @Scheduled(cron = "*/6 * * * * ?")
    private void process() {
        System.out.println("这是定时任务正在执行（runing）: " + (count++));
    }
}
