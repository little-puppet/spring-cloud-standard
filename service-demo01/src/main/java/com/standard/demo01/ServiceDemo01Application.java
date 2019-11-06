package com.standard.demo01;

import com.standard.common.config.BaseConfig;
import com.standard.common.config.FeignConfig;
import com.standard.common.config.MybatisPlusConfig;
import com.standard.common.config.SwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableEurekaClient
@Import({BaseConfig.class, FeignConfig.class, MybatisPlusConfig.class, SwaggerConfig.class})
public class ServiceDemo01Application {

    public static void main(String[] args) {
        SpringApplication.run(ServiceDemo01Application.class, args);
    }

}
