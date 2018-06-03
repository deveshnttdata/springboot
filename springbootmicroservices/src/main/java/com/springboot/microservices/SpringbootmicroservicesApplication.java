package com.springboot.microservices;

import static springfox.documentation.builders.PathSelectors.any;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableDiscoveryClient
public class SpringbootmicroservicesApplication {

	@Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("Room").select()
                .apis(RequestHandlerSelectors.basePackage("com.springboot.microservices"))
                .paths(any()).build().apiInfo(new ApiInfo("Room Services",
                        "A set of services to provide data access to rooms", "1.0.0", null,
                        new Contact("Devesh Singh", "", null),null, null));
    }
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootmicroservicesApplication.class, args);
	}
}
