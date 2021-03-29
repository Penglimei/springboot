package com.plm.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * 开启定时任务
 */
@Service
public class ScheduledService {

    /**
     * cron表达式 : 秒    分   时   日   月   周几
     *
     *  cron = "0 3 16 * * ?"   // 每天下午16：03执行任务
     *  cron = "0 0 10,14,16 * * ?"  // 每天10点、14点、16点执行任务
     *  cron = "0 0 12 ？ * WED"     // 每个周三中午12点执行任务
     *  cron = "0 0/30 9-17 * * ?"  // 每天早上9点到下午17点每半小时执行任务
     */
    @Scheduled(cron = "0 3 16 * * ?")
    public void hello(){
        System.out.println("hello,scheduled service running!");
    }
}
