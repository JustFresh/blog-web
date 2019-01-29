package com.xiudoua.micro.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * 
 * @desc 
 * @author JustFresh
 * @time 2019年1月6日 下午12:56:21
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
@EnableJpaAuditing
@Configuration
public class JpaAuditingConfig implements AuditorAware<String>{

	private static final String LOGIN_ADMIN = "admin";

    /**
     * 返回当前操作人
     */
    @Override
    public String getCurrentAuditor() {
        return LOGIN_ADMIN;
    }
	
}