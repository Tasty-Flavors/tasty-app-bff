package br.com.tasty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TastyAppBffApplication {
	public static void main(String[] args) {
		SpringApplication.run(TastyAppBffApplication.class, args);
	}
}
