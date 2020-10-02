package com.aequilibrium.transforming.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.collect.Sets.newHashSet;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;
import static springfox.documentation.spi.DocumentationType.SWAGGER_2;

@Configuration
@EnableSwagger2
@PropertySource("classpath:swagger.properties")
public class SwaggerConfig {

    @Value("${swagger.controller.base.package.name}")
    private String controllerBasePackage;

    @Value("${swagger.api.host}")
    private String apiHost;

    @Value("${swagger.api.info.title}")
    private String apiInfoTitle;

    @Value("${swagger.api.info.description}")
    private String apiInfoDescription;

    @Value("${swagger.api.info.version}")
    private String apiInfoVersion;

   /* @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .consumes(newHashSet(APPLICATION_JSON_VALUE))
                .produces(newHashSet(APPLICATION_JSON_VALUE))
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }*/

    @Bean
    public Docket api() {
        return new Docket(SWAGGER_2)
                .consumes(newHashSet(APPLICATION_JSON_VALUE))
                .produces(newHashSet(APPLICATION_JSON_VALUE))
                .select().apis(basePackage(controllerBasePackage))
                .build()
                .apiInfo(apiInfo())
                .host(apiHost);
    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(apiInfoTitle)
                .description(apiInfoDescription)
                .version(apiInfoVersion)
                .build();
    }
}
