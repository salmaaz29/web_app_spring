package ma.fstt.web_app_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan("ma.fstt")
@EnableJpaRepositories("ma.fstt.repository")
@EntityScan("ma.fstt.entities")
public class WebAppSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebAppSpringApplication.class, args);
	}

}
