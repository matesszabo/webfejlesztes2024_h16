package hu.unideb.inf.esemenykezelo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class EsemenykezeloApplication {

	public static void main(String[] args) {
		SpringApplication.run(EsemenykezeloApplication.class, args);
	}

}
