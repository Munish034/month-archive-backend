package aadhaar.divison;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

@EnableJpaRepositories("aadhaar.Repository")
@EntityScan("aadhaar.Model")
@ComponentScan("aadhaar")
public class DivisonApplication {

	public static void main(String[] args) {
		SpringApplication.run(DivisonApplication.class, args);
		
	}

}
