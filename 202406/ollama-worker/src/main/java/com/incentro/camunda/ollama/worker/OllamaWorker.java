package com.incentro.camunda.ollama.worker;

import com.incentro.camunda.ollama.handler.OllamaServiceHandler;
import com.incentro.camunda.ollama.service.model.GenerateResponse;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.spring.client.annotation.JobWorker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class OllamaWorker {

    private OllamaServiceHandler ollamaServiceHandler;

    public OllamaWorker(OllamaServiceHandler ollamaServiceHandler) {
        this.ollamaServiceHandler = ollamaServiceHandler;
    }

    private static Logger logger = LoggerFactory.getLogger(OllamaWorker.class);

    @JobWorker(type = "ollama_getModels")
    public Map<String, List<String>> handleGetModels(final ActivatedJob activatedJob) {
        logger.info("Executing worker GetModels");

        List<String> model_names = this.ollamaServiceHandler.HandleGetModels();

        Map<String, List<String>> map = new HashMap<>();
        map.put("model_names", model_names);
        return map;
    }

    @JobWorker(type = "ollama_generate", timeout = 600000)
    public Map<String, Object> handleGenerate(final ActivatedJob activatedJob) {
        logger.info("Executing worker handleGenerate");

        Map<String, Object> variables = activatedJob.getVariablesAsMap();
        String model = (String) variables.get("in_model");
        String prompt = (String) variables.get("in_prompt");
        @SuppressWarnings("unchecked")
        List<Integer> context = (List<Integer>) variables.get("in_context");

        List<GenerateResponse> responses = this.ollamaServiceHandler.HandleGenerate(model, prompt, context);
        StringBuilder response = new StringBuilder();
        for (GenerateResponse current : responses)
            response.append(current.getResponse());

        GenerateResponse lastResponse = responses.get(responses.size() - 1);

        Map<String, Object> map = new HashMap<>();
        map.put("out_response", response.toString());
        map.put("out_context", lastResponse.getContext());
        return map;
    }
}
