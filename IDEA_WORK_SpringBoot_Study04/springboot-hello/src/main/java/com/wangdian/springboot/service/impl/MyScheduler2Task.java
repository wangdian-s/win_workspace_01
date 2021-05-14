package com.wangdian.springboot.service.impl;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class MyScheduler2Task {
    private static final SimpleDateFormat dateFormat
            = new SimpleDateFormat("HH:mm:ss");
    //@Scheduled(fixedRate = 6000)//上一次开始执行时间点之后6秒再执行,
    // 加入程序运行时间大于该设定时间，则按照该程序运行时间走，意义在于6秒之后才会执行，
    // 最低间隔为6秒；
    //@Scheduled(fixedDelay = 6000)//上一次执行完毕时间点之后6秒再执行；
    @Scheduled(initialDelay=1000, fixedRate=6000)
    //第一次延迟1秒后执行，之后按fixedRate的规则每6秒执行一次。
    public void reportCurrentTime() {
        // 测试fixedRate和fixedDelay区别
        //模拟任务执行所花的时间
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("现在时间："
                + dateFormat.format(new Date()));
    }
}
