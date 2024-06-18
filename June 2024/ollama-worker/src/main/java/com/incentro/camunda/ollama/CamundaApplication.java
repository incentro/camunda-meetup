package com.incentro.camunda.ollama;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;


@SpringBootApplication
public class CamundaApplication {

    @Value("${ollama.base-url}")
    private String ollamaBaseUrl;

	public static void main(String[] args) {
		SpringApplication.run(CamundaApplication.class, args);
	}

	@Bean
    public WebClient webClient() {
        return WebClient.builder().baseUrl(ollamaBaseUrl).build();
    }

}
