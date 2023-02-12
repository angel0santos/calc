package com.api.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


import com.api.back.model.service.bussines.ClsCalcBusiness;
import com.api.back.model.service.bussines.ClsRespuestaBusiness;

@SpringBootApplication
@ComponentScan(basePackages = {"com.controllers"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	 public ClsCalcBusiness serviceCal() {
		return new ClsCalcBusiness();
	}
	
	@Bean
	public ClsRespuestaBusiness serviceRespuesta() {
		return new ClsRespuestaBusiness();
	}
}
