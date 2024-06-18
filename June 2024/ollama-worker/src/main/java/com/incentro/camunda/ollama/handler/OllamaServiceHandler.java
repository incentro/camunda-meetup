package com.incentro.camunda.ollama.handler;

import java.util.List;

import org.springframework.stereotype.Component;

import com.incentro.camunda.ollama.service.OllamaService;
import com.incentro.camunda.ollama.service.model.GenerateResponse;
import com.incentro.camunda.ollama.service.model.GetModelsResponse;

@Component
public class OllamaServiceHandler {

    private OllamaService ollamaService;

    public OllamaServiceHandler(OllamaService ollamaService) {
        this.ollamaService = ollamaService;
    }

    public List<String> HandleGetModels() {
        GetModelsResponse result = this.ollamaService.getModels().block();
        
        return result.models.stream()
        .map(x -> x.name)
        .toList();
    }

    public GenerateResponse HandleGenerate(String model, String prompt) {        
        return this.ollamaService.generate(model, prompt, true)
            .blockLast();
    }

    public List<GenerateResponse> HandleGenerate(String model, String prompt, List<Integer> context) {        
        return this.ollamaService.generate(model, prompt, true, context)
        .buffer()
        .blockLast();
    }

}
