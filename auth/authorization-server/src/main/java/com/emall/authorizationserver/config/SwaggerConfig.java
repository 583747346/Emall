package com.emall.authorizationserver.config;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.emall.authorizationserver"))
                .paths(PathSelectors.any())
                .build();
//                .globalOperationParameters(defaultHeader());
    }

    /**
     * swgger令牌认证
     * @return
     */
    private static List<Parameter> defaultHeader() {
        ParameterBuilder paramType = new ParameterBuilder();
        paramType.name("param-type")
                .description("应用类型")
                .modelRef(new ModelRef("String"))
                .parameterType("header")
                .required(false)
                .build();
        ParameterBuilder paramToken = new ParameterBuilder();
        paramToken.name("param-token")
                .description("令牌")
                .modelRef(new ModelRef("String"))
                .parameterType("header")
                .required(false)
                .build();
        List<Parameter> parameters = new ArrayList<>();
        parameters.add(paramType.build());
        parameters.add(paramToken.build());
        return parameters;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("授权服务API")
                .description("授权服务")
                .termsOfServiceUrl("##")
                .version("2.0")
                .build();
    }
}
