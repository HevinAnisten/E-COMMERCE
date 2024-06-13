package e_commerce_application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {

		SpringApplication.run(EcommerceApplication.class, args);
	}

}