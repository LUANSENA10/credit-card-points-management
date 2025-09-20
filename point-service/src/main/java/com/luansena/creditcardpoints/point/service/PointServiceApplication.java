package com.luansena.creditcardpoints.point.service;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@EnableRabbit
@SpringBootApplication
public class PointServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PointServiceApplication.class, args);
	}

}
