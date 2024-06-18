package com.incentro.camunda.ollama.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.incentro.camunda.ollama.service.model.GenerateRequest;
import com.incentro.camunda.ollama.service.model.GenerateResponse;
import com.incentro.camunda.ollama.service.model.GetModelsResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OllamaService {

    private WebClient client;

    public OllamaService(WebClient client) {
        this.client = client;
    }

    public Mono<GetModelsResponse> getModels() {
        return client.get()
                .uri("/api/tags")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(GetModelsResponse.class);

    }

    public Flux<GenerateResponse> generate(String model, String prompt, boolean stream) {
        GenerateRequest request = new GenerateRequest(model, prompt, stream);
        return getResponse(request);
    }

    public Flux<GenerateResponse> generate(String model, String prompt, boolean stream, List<Integer> context) {
        GenerateRequest request = new GenerateRequest(model, prompt, stream);
        request.setContext(context);

        return getResponse(request);
    }

    private Flux<GenerateResponse> getResponse(GenerateRequest request) {
        return client.post()
                .uri("api/generate")
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(request))
                .retrieve()
                .bodyToFlux(GenerateResponse.class);
    }

}