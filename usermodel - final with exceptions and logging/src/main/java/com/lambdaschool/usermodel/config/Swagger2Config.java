package com.lambdaschool.usermodel.config;

import com.fasterxml.classmate.TypeResolver;
import com.lambdaschool.usermodel.models.ErrorDetail;
import org.springframework.beans.factory.annotation.Autowired;
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
public class Swagger2Config
{
    @Autowired
    private TypeResolver resolver;
    @Bean
    public Docket api()
    {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.lambdaschool"))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false) // Allows only my exception responses
                // .ignoredParameterTypes(Pageable.class) // allows only my paging parameter list
                .apiInfo(apiEndPointsInfo())
                .pathMapping("/")
                .additionalModels(resolver.resolve(ErrorDetail.class))
                .ignoredParameterTypes();
    }
    private ApiInfo apiEndPointsInfo()
    {
        return new ApiInfoBuilder().title("User Model Project")
                .description("User Model Project but in more detail")
                .contact(new Contact("John Mitchell",
                        "http://www.lambdaschool.com",
                        "john@lambdaschool.com"))
                .license("MIT")
                .licenseUrl("https://github.com/LambdaSchool/java-usermodel/blob/master/LICENSE")
                .version(("1.0.0"))
                .build();
    }
}
