//package com.otp.swagger;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//import springfox.documentation.service.Contact;
//
//@Configuration
//@EnableSwagger2
//public class SwaggerConfiguration {
//	@Bean
//	public Docket swaggerApiConfig() {
//		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.any())
//				.apis(RequestHandlerSelectors.basePackage("com.otp")).build()
//				.apiInfo(apiInfo());
//	}
//
//	private ApiInfo apiInfo() {
//
//		return new ApiInfo("Swagger API Documentation", "OTP Generation", "", "",
//				new Contact("Swager API Example", "http://localhost:8080/swagger-ui.html", ""), "", "");
//
//	}
//}
//
//
//
//
