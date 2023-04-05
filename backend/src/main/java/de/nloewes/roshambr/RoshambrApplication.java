package de.nloewes.roshambr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@ComponentScan("de.nloewes.roshambr")
public class RoshambrApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoshambrApplication.class, args);
	}

}
