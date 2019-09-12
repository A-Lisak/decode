package com.decode.anpr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class AnprApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnprApplication.class, args);
	}

}
