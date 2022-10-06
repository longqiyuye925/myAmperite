package com.example.amperite.config;//package com.example.amperite.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//
///**
// * @ClassName config.SwaggerConfig
// * @Description TODO
// * @Author wushichao5
// * @Date 2022/5/25 20:16
// * @Version 1.0
// **/
//@Configuration
//public class SwaggerConfig {
//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.OAS_30)
//                .enable(true)//仅在开发环境开启Swagger
//                .apiInfo(apiInfo())
//                .host("http://www.example.com")
//                .select()
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("文档")
//                .description("")
//                .contact(new Contact("吴士超", null, null))
//                .version("3.0")
//                .build();
//    }
//
//}
