package com.wxh.bicyclerental;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select()
                //controller类所在的包，否则会报错
                .apis(RequestHandlerSelectors.basePackage("com.wxh.bicyclerental"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo getApiInfo() {
        Contact contact = new Contact("wangxinhui","https://www.baiddu.com","1102343495@qq.com");
        return new ApiInfoBuilder()
                .title("自行车租赁管理系统")
                .description("自行车租赁管理系统，2021哈理工毕业设计")
                .version("项目版本：1.0")
                .contact(contact)
                .license("The Apache License")
                .licenseUrl("http://www.baidu.com")
                .build();
    }
}
