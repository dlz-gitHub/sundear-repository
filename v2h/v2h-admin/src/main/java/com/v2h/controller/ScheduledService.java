package com.v2h.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledService {
   /* @Scheduled(cron = "0/5 * * * * *")
    public void scheduled(){
    	System.out.println("=====>>>>>使用cron  {}-->"+System.currentTimeMillis());
    }
    @Scheduled(fixedRate = 5000)
    public void scheduled1() {
    	System.out.println("=====>>>>>使用fixedRate{}-->"+System.currentTimeMillis());
    }*/
    @Scheduled(fixedDelay = 5000)
    public void scheduled2() {
      // System.out.println("=====>>>>>fixedDelay{}-->"+System.currentTimeMillis());
    }
}
