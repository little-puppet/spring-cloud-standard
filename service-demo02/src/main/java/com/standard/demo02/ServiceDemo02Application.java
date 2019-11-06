package com.standard.demo02;

import com.standard.common.config.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@Import({BaseConfig.class,FeignConfig.class, MybatisPlusConfig.class,SwaggerConfig.class, CachConfig.class})
@EnableSwagger2
public class ServiceDemo02Application {

    public static void main(String[] args) {
        SpringApplication.run(ServiceDemo02Application.class, args);
    }

}
