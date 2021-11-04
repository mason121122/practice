package com.practice.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Mark Wang
 * @date 2021/10/3
 */
@Configuration
@EnableSwagger2
@ConditionalOnProperty(name = "swagger2.enable", havingValue = "false")
public class Swagger2Config{

    /**
     * 这段配置为swagger页面添加全局token参数的输入框
     * 注1.swagger3和swagger2配置是不用用的
     * 注2.swagger2 使用globalOperationParameters(赛token的方法)属性配置全局token参数
     * .securitySchemes(Collections.singletonList(HttpAuthenticationScheme.JWT_BEARER_BUILDER
     * //                        显示用
     *                         .name("JWT")
     *                         .build()))
     *                 .securityContexts(Collections.singletonList(SecurityContext.builder()
     *                         .securityReferences(Collections.singletonList(SecurityReference.builder()
     *                                 .scopes(new AuthorizationScope[0])
     *                                 .reference("JWT")
     *                                 .build()))
     *                         // 声明作用域
     *                         .operationSelector(o -> o.requestMappingPattern().matches("/.*"))
     *                         .build()))
     * @return
     */
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo()).enable(true)
                .securitySchemes(Collections.singletonList(HttpAuthenticationScheme.JWT_BEARER_BUILDER
                        .name("JWT")
                        .build()))
                .securityContexts(Collections.singletonList(SecurityContext.builder()
                        .securityReferences(Collections.singletonList(SecurityReference.builder()
                                .scopes(new AuthorizationScope[0])
                                .reference("JWT")
                                .build()))
                        // 声明作用域
                        .operationSelector(o -> o.requestMappingPattern().matches("/.*"))
                        .build()))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.practice"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("", "url", "");
        return new ApiInfoBuilder()
                .title("practice系统Restful API")
                .description("practice系统Restful API")
                .termsOfServiceUrl("")
                .contact(contact)
                .version("1.0-SNAPSHOT")
                .build();
    }
}
