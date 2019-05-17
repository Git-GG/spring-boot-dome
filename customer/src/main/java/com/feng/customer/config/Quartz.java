package com.feng.customer.config;

import com.feng.customer.Quartz.testJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Quartz {
    @Bean
    public JobDetail teatQuartzDetail(){
        return JobBuilder.newJob(testJob.class).withIdentity("testQuartz").storeDurably().build();
    }

    @Bean
    public Trigger testQuartzTrigger(){
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(10)  //设置时间周期单位秒
                .repeatForever();
        return TriggerBuilder.newTrigger().forJob(teatQuartzDetail())
                .withIdentity("testQuartz")
                .withSchedule(scheduleBuilder)
                .build();
    }

}
