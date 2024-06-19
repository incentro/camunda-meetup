package com.incentro.camunda.ollama.service.model;

import java.util.List;
import java.util.Map;

public class GenerateRequest {
    String model;
    String prompt;

    boolean stream;
    Map<String, Object> options;
    String system;
    String template;
    List<Integer> context;
    boolean raw;
    String keep_alive;

    public GenerateRequest() {
    }
    
    public GenerateRequest(String model, String prompt, boolean stream) {
        this.model = model;
        this.prompt = prompt;
        this.stream = stream;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getPrompt() {
        return prompt;
    }
    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }
    public boolean isStream() {
        return stream;
    }
    public void setStream(boolean stream) {
        this.stream = stream;
    }

    public Map<String, Object> getOptions() {
        return options;
    }

    public void setOptions(Map<String, Object> options) {
        this.options = options;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public List<Integer> getContext() {
        return context;
    }

    public void setContext(List<Integer> context) {
        this.context = context;
    }

    public boolean isRaw() {
        return raw;
    }

    public void setRaw(boolean raw) {
        this.raw = raw;
    }

    public String getKeep_alive() {
        return keep_alive;
    }

    public void setKeep_alive(String keep_alive) {
        this.keep_alive = keep_alive;
    }
}
