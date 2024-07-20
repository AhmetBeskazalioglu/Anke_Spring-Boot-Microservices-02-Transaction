package com.anke.Anke_Spring_Boot_Microservices_02_Transaction;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AnkeSpringBootMicroservices02TransactionApplication.class);
	}

}
