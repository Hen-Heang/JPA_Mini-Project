package com.example.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class JpaApplication {
//    private static final Logger log = LoggerFactory.getLogger(StartApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

}
