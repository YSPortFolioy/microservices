package com.youssadi.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.context.request.WebRequest;

@SpringBootApplication
@EnableJpaRepositories("com.youssadi.dao")
@EntityScan("com.youssadi.domain")
@ComponentScan({"com.youssadi.controller", "com.youssadi.service"})
@EnableFeignClients("com.youssadi.clients")

public class HotelServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelServiceApplication.class, args);
	}

}



