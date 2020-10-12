package com.example.demo;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CondidatApplication {

	public static void main(String[] args) {
		SpringApplication.run(CondidatApplication.class, args);
	}
	
	@Bean
	ApplicationRunner init (CandidatRepository repository) {
		return args ->{
			Stream.of("aziz","adem,","mostfa").forEach(nom->{
				repository.save(new Candidat(nom));
			});
			repository.findAll().forEach(System.out::println);
		};
	}
	

}
