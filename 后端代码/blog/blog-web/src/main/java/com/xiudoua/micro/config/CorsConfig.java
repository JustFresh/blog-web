package com.xiudoua.micro.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 
 * @desc 
 * @author JustFresh
 * @time 2018年11月23日 下午5:14:38
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
@Configuration
public class CorsConfig {

	@Value("${cors.config.urls}")
	private String corsConfigUrls;
	
    private CorsConfiguration buildConfig() {  
        CorsConfiguration config = new CorsConfiguration();  
//        config.addAllowedOrigin("*"); // 1允许任何域名使用
        //1.根据配置文件的配置可允许跨域的ip及端口
        if(StringUtils.isEmpty(corsConfigUrls)){
        	//如果为空则默认允许http://localhost:4200跨域
        	corsConfigUrls = "http://localhost:4200";
        }
        String[] corsUrlArr = corsConfigUrls.split(",");
        if(corsUrlArr != null && corsUrlArr.length > 0){
        	for(int i=0;i<corsUrlArr.length;i++){
        		config.addAllowedOrigin(corsUrlArr[i]);
        	}
        }
        config.addAllowedHeader("*"); // 2允许任何头
        config.addAllowedMethod("*"); // 3允许任何方法（post、get等） 
        return config;  
    }  
  
    @Bean  
    public CorsFilter corsFilter() {  
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();  
        source.registerCorsConfiguration("/**", buildConfig()); // 4  
        return new CorsFilter(source);  
    }  
    
}