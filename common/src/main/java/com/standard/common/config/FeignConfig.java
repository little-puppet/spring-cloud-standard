package com.standard.common.config;

import com.standard.common.component.FeignHystrixConcurrencyStrategy;
import com.standard.common.component.FeignRequestInterceptor;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.session.web.http.SessionRepositoryFilter;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author: zhangH
 * @date: 2019/10/20 10:12
 * @description:
 */
@Configuration
@ComponentScan("com.standard.common.service")
@EnableFeignClients(basePackages = {"com.standard.common.service"})
@Slf4j
public class FeignConfig {

    @Bean
    public FeignRequestInterceptor feignRequestInterceptor(){
        return new FeignRequestInterceptor();
    }

    @Bean
    public FeignHystrixConcurrencyStrategy feignHystrixConcurrencyStrategy(){
        return new FeignHystrixConcurrencyStrategy();
    }


}
