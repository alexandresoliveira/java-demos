package dev.aleoliv.demomobileapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "dev.aleoliv.demomobileapi" })
public class DemoMobileApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoMobileApiApplication.class, args);
	}

}
