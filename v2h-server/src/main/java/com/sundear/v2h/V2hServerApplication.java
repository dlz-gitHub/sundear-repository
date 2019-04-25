package com.sundear.v2h;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan(basePackages= {"com.sundear.v2h.mapper"})
@PropertySource("classpath:socket.properties")
@ComponentScan({"com.sundear.v2h.service.impl","com.sundear.v2h.dao.impl","com.sundear.v2h"})
@EnableScheduling //开启定时器
public class V2hServerApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext application = SpringApplication.run(V2hServerApplication.class, args);
		application.getBean(SocketServer.class).start();//在spring容器启动后，取到已经初始化的SocketServer，启动Socket服务
	}

}
