package com.v2h.controller;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;



/**  
* @ClassName: MyConfig  
* @Description: TODO(代替spring的配置文件)
* @date 2019年3月15日 下午1:52:46    
*/
@Configuration
public class MyConfig {
	
	/*@Bean
	public UserService userService() {
		return new UserServiceImpl();
	}
	@Bean
	public UserDao userDao() {
		return new UserDaoImpl();
	}*/
	
	//配置资源映射器
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
       registry.addResourceHandler("/img/**").addResourceLocations("/WEB-INF/"+"/img/");
       registry.addResourceHandler("/static/**").addResourceLocations("/WEB-INF/"+"/static/");
    }
    
    //配置跨域请求问题
    private CorsConfiguration buildConfig() {  
        CorsConfiguration corsConfiguration = new CorsConfiguration();  
        corsConfiguration.addAllowedOrigin("*"); // 1允许任何域名使用
        corsConfiguration.addAllowedHeader("*"); // 2允许任何头
        corsConfiguration.addAllowedMethod("*"); // 3允许任何方法（post、get等） 
        return corsConfiguration;  
    } 
    @Bean  
    public CorsFilter corsFilter() {  
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();  
        source.registerCorsConfiguration("/**", buildConfig()); // 4  
        return new CorsFilter(source);  
    }  
}
