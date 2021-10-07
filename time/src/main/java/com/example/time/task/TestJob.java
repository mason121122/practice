package com.example.time.task;


import com.practice.common.utils.DateUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Mark Wang
 * @date 2021/10/3
 */
@Component
public class TestJob {
    public final static long ONE_Minute =  60 * 1000;

    @Scheduled(fixedDelay=ONE_Minute)
    public void fixedDelayJob(){
        System.out.println(DateUtil.getTimeShort(new Date())+" >>fixedDelay执行....");
    }

    @Scheduled(fixedRate=ONE_Minute)
    public void fixedRateJob(){
        System.out.println(DateUtil.getTimeShort(new Date())+" >>fixedRate执行....");
    }

    @Scheduled(cron = "0/30 * * * * ?")
    public void cronJob(){
        System.out.println(DateUtil.getTimeShort(new Date())+" >>cron执行....");
    }

    @Scheduled(cron = "0 0/1 * * * ?")
    public void cronJob2(){
        Thread t = Thread.currentThread();
        System.out.println(DateUtil.getTimeShort(new Date())+" >>cron执行...."+"当前线程名字：" + t.getName() + " 当前线程的优先级别为：" + t.getPriority() + " ID:" + t.getId());
    }

    @Scheduled(cron = "0 0/1 * * * ?")
    public void cronJob3(){
        Thread t = Thread.currentThread();
        System.out.println(DateUtil.getTimeShort(new Date())+" >>cron执行...."+"当前线程名字：" + t.getName() + " 当前线程的优先级别为：" + t.getPriority() + " ID:" + t.getId());
    }

    @Scheduled(cron = "0 0/1 * * * ?")
    public void cronJob4(){
        Thread t = Thread.currentThread();
        System.out.println(DateUtil.getTimeShort(new Date())+" >>cron执行...."+"当前线程名字：" + t.getName() + " 当前线程的优先级别为：" + t.getPriority() + " ID:" + t.getId());
    }
}
