package aadhaar.divison;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

import jakarta.annotation.PreDestroy;

@SpringBootApplication

@EnableJpaRepositories("aadhaar.Repository")
@EntityScan("aadhaar.Model")
@ComponentScan("aadhaar")
@CrossOrigin(origins = "*")

public class DivisonApplication  extends SpringBootServletInitializer  {
	   @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	        return builder.sources(DivisonApplication.class);
	    }
	  
	public static void main(String[] args) {
		SpringApplication.run(DivisonApplication.class, args);
		
	}

}
