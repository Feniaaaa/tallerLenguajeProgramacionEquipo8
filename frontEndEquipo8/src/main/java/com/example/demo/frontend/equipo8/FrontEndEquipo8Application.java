package com.example.demo.frontend.equipo8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })


public class FrontEndEquipo8Application {

	//http://localhost:8081/persona/listar/REST
	public static void main(String[] args) {
		SpringApplication.run(FrontEndEquipo8Application.class, args);
	}

}
