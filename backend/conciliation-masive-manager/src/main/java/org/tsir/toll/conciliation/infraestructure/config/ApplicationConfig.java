package org.tsir.toll.conciliation.infraestructure.config;

import java.util.Collections;

import org.modelmapper.ModelMapper;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.reactive.function.client.WebClient;
import org.tsir.common.modules.TaskRegistrable;
import org.tsir.common.services.RegisterService;
import org.tsir.common.utils.ObjectUtilsVP;
import org.tsir.toll.conciliation.application.register.RegisterProductionTask;

import io.swagger.models.auth.In;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class ApplicationConfig {
	
	public static final String API_VERSION = "1.0.1";
	public static final String IMPLEMENTATION_VERSION = "1.0.1.200109";
	public static final String MODULE_DESCRIPTION = "Servicios para Conciliciación de Dack's y Tiquetes.";
	public static final String MODULE_NAME = "conciliacion-masive";

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	@LoadBalanced
	public WebClient.Builder getWebClient() {
		return ObjectUtilsVP.getClient();
	}

	@Bean
	public HttpMessageConverter<String> createTextPlainConverter() {
		return new StringHttpMessageConverter();
	}
	
	@Bean
	public RegisterService getRegisterService() {
		RegisterService registerService = new RegisterService();
		registerService.setHost("platform-manager");
		return registerService;
	}

	@Bean
	public ConciliationService getConciliationService() {
		ConciliationService service = new ConciliationService();
		service.setHost("conciliation-manager");
		return service;
	}
	


	@Bean
	@Profile("prod")
	public TaskRegistrable getRegisterProductionTask() {
	return new RegisterProductionTask();
	}


	@Bean
	@Profile("dev")
	public TaskRegistrable getRegisterDevelopTask() {
		return () -> {
		};
//		return new RegisterProductionTask();
	}
	
	public ApiInfo apiInfo() {
		return new ApiInfoBuilder().title(MODULE_NAME).description(MODULE_DESCRIPTION).license("")
				.licenseUrl("http://unlicense.org").termsOfServiceUrl("").version(API_VERSION)
				.contact(new Contact("", "", "")).build();
	}
}
