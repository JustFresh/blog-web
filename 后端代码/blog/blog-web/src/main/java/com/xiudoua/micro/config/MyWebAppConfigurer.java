package com.xiudoua.micro.config;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 
 * mysite: http://www.xiudoua.com
 * @desc: 配置自定义静态资源引用
 * @author: JustFresh
 * @date: 2018年7月8日 下午4:05:01 
 * @version: beta1.1
 */
@Configuration
@Order(value = 1)
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter{
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//文件上传路径地址配置
        registry.addResourceHandler("/Uploads/**")
        .addResourceLocations("file:D:/Uploads/");
        super.addResourceHandlers(registry);
    }
	
	/**
	 * 日期格式化配置
	 * @return
	 */
	@Bean
	public Converter<String, Date> addNewConvert() {
	    return new Converter<String, Date>() {
	        @Override
	        public Date convert(String source) {
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	            Date date = null;
	            try {
	                date = sdf.parse( source);
	            } catch (Exception e) {
	            	logger.error("启动类配置日期格式化转换器失败：{}",e);
	            }
	            return date;
	        }
	    };
	}
	
}