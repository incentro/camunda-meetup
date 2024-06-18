package com.incentro.camunda.ollama.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GenerateResponse {

    @JsonProperty("model")
    String model;

    @JsonProperty("created_at")
    String createdAt;

    @JsonProperty("response")
    String response;

    @JsonProperty("done")
    boolean done;

    @JsonProperty("context")
    int[] context;

    @JsonProperty("total_duration")
    String total_duration;

    @JsonProperty("load_duration")
    String load_duration;

    @JsonProperty("prompt_eval_count")
    String prompt_eval_count;

    @JsonProperty("prompt_eval_duration")
    String prompt_eval_duration;

    @JsonProperty("eval_count")
    String eval_count;

    @JsonProperty("eval_duration")
    String eval_duration;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public int[] getContext() {
        return context;
    }

    public void setContext(int[] context) {
        this.context = context;
    }

    public String getTotal_duration() {
        return total_duration;
    }

    public void setTotal_duration(String total_duration) {
        this.total_duration = total_duration;
    }

    public String getLoad_duration() {
        return load_duration;
    }

    public void setLoad_duration(String load_duration) {
        this.load_duration = load_duration;
    }

    public String getPrompt_eval_count() {
        return prompt_eval_count;
    }

    public void setPrompt_eval_count(String prompt_eval_count) {
        this.prompt_eval_count = prompt_eval_count;
    }

    public String getPrompt_eval_duration() {
        return prompt_eval_duration;
    }

    public void setPrompt_eval_duration(String prompt_eval_duration) {
        this.prompt_eval_duration = prompt_eval_duration;
    }

    public String getEval_count() {
        return eval_count;
    }

    public void setEval_count(String eval_count) {
        this.eval_count = eval_count;
    }

    public String getEval_duration() {
        return eval_duration;
    }

    public void setEval_duration(String eval_duration) {
        this.eval_duration = eval_duration;
    }

}
