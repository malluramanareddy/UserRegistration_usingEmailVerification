package com.careers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
@EnableAutoConfiguration
public class TracnxCareersApplication {

	public static void main(String[] args) {
		SpringApplication.run(TracnxCareersApplication.class, args);
	}

}
