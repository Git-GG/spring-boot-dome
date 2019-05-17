package com.feng.customer.Quartz;


import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.time.LocalDateTime;

public class testJob extends QuartzJobBean {

    @Override
    protected void executeInternal(org.quartz.JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("quartz task "+ LocalDateTime.now().toString());
    }
}
