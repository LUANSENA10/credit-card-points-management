package com.luansena.creditcardpoints.point;

import org.springframework.boot.SpringApplication;

public class TestPointServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(PointServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
