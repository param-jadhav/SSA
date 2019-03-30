package com.usa.gov.fedral.ssa.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
	public Docket edApi() {
		return new Docket(DocumentationType.SWAGGER_2)
					.host("localhost:9090")
					.select()
					.apis(RequestHandlerSelectors.basePackage("com.usa.gov.fedral.ssa.resource"))
					.paths(PathSelectors.any())
					.build()
					.apiInfo(metaData());
					
	}
	
    private ApiInfo metaData() {

        ApiInfo apiInfo = new ApiInfo("Social Security Number Web", 
        							"Social Security Number Web Resource for Validating SSN", 
        							"1.0", 
        							"Terms of Serivce", 
        							new Contact("Prabhakar", "http://www.ssa-web.org", "care@ssa-web.org"), 
        							"Apache License Version 2.0",
        							"https://www.apache.org/licenses/LICENSE-2.0");

        return apiInfo;

    }

}
