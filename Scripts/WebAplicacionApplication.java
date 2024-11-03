package com.aplicacion.WebAplicacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "mx.aplicacion.WebAplicacion")
public class WebAplicacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebAplicacionApplication.class, args);
	}

}
