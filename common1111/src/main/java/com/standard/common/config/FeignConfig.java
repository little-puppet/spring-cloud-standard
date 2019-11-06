package com.standard.common.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: zhangH
 * @date: 2019/10/20 10:12
 * @description:
 */
@Configuration
@EnableFeignClients(basePackages = {"com.standard.common.service"})
@ComponentScan("com.standard.common.service")
public class FeignConfig {

}
