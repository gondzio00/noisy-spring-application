package com.example.gondzio.Noisy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.validation.Validator;
import javax.validation.ValidatorFactory;

@SpringBootApplication
public class NoisyApplication {

	public static void main(String[] args) {
		SpringApplication.run(NoisyApplication.class, args);
	}
}
