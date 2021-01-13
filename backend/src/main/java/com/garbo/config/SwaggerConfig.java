package com.garbo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author garbo
 * @description Swagger配置类
 * @create 2021-01-13 16:30
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    // 实现每个接口默认添加token请求参数
    @Bean
    public Docket customDocket() {
        ParameterBuilder ticketPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        ticketPar.name("token").description("令牌")
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build(); //header中的ticket参数非必填，传空也可以
        pars.add(ticketPar.build());    //根据每个方法名也知道当前方法在设置什么参数
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .build()
                .globalOperationParameters(pars)
                .apiInfo(apiInfo())
                .groupName("token");
    }

    //    // 配置了Swagger的Docket的bean实例
    @Bean
    public Docket docket(Environment environment) {
        // 设置要显示的Swagger环境
        Profiles profiles = Profiles.of("dev");
        // 通过environment.acceptsProfiles判断是否处在自己的设定的环境当中
        boolean flag = environment.acceptsProfiles(profiles);
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // RequestHandlerSelectors：配置要扫描接口的方式
//                     basePackage：指定要扫描的包
//                     any():扫描全部
//                     none(): 不扫描
//                     withClassAnnotation：扫描类上的注解
//                     withMethodAnnotation: 扫描方法上的注解
                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.ant("/user"))    // 过滤什么路径
                .build()
                .enable(flag)                           // 是否启动swagger
                .groupName("garbo");                    // 分组名
    }

    // 配置Swagger信息:apiInfo
    private ApiInfo apiInfo() {
        // 作者信息
        return new ApiInfo("garbo的SwaggerAPI文档",
                "blog文档",
                "1.0",
                "https://github.com/garbo-hsing?tab=projects",
                new Contact("garbo", "https://github.com/garbo-hsing?tab=projects", "1025790175@qq.com"),
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>());
    }
}
