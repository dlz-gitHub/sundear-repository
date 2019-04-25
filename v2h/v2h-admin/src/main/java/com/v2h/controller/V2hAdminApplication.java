package com.v2h.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**  
* @ClassName: AdminApplication  
* @Description: TODO(这里用一句话描述这个类的作用)
* @date 2019年3月20日 上午11:05:35 
* @author dlz   
*/

@SpringBootApplication
@MapperScan(basePackages= {"com.v2h.core.mapper"})
@ComponentScan({"com.v2h.service.impl","com.v2h.core.dao.impl","com.v2h.controller"})
@PropertySource("classpath:myconfig.properties")
@EnableSwagger2  //开启swagger配置
@EnableScheduling //开启定时器
public class V2hAdminApplication {
	
	public static void main(String[] args) {		
		SpringApplication.run(V2hAdminApplication.class, args);
	}
	
}
