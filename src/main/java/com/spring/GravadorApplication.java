package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class GravadorApplication implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(GravadorApplication.class, args);
	}
	
	/*Permite ao spring localizar a página dentro de /WEB-INF/jsp/*/
	@Override
	public void configureViewResolvers(final ViewResolverRegistry registry) {
	    registry.jsp("/WEB-INF/jsp/", ".jsp");
	}

}
