package com.v2h.controller;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
 
/**
 * 
* @ClassName: Swagger2  
* @Description: TODO(swagger配置类)
* @date 2019年3月20日 下午3:01:49 
* @author dlz
 */
@Configuration
public class SwaggerConfig {
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.v2h.controller"))//修改为自己的包名
				.paths(PathSelectors.any())
				.build();
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("测试api文档")
				.description("简单优雅的restfun风格的测试文档")
				.termsOfServiceUrl("localhost:8081")// 将“url”换成自己的ip:port
				.version("1.0")
				.build();
	}
}