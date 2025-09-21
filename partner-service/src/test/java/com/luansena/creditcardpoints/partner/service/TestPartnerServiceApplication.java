package com.luansena.creditcardpoints.partner.service;

import org.springframework.boot.SpringApplication;

public class TestPartnerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(PartnerServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
