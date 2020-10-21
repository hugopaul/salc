package br.mil.eb.basecmp.salc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class SalcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalcApplication.class, args);
	}

}
