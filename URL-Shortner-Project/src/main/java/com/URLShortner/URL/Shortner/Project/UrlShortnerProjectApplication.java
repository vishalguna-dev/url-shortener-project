package com.URLShortner.URL.Shortner.Project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationProperties.class)
public class UrlShortnerProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrlShortnerProjectApplication.class, args);
	}

}
