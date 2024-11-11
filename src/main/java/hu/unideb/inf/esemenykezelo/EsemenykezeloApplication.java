package hu.unideb.inf.esemenykezelo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EsemenykezeloApplication {

	public static void main(String[] args) {
		SpringApplication.run(EsemenykezeloApplication.class, args);
	}

	@Bean
	ModelMapper modelMapper() {
		//return new ModelMapper();
		ModelMapper m = new ModelMapper();
		return m;
	}

}
