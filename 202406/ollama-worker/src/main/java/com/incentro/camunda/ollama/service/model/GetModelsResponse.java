package com.incentro.camunda.ollama.service.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetModelsResponse {

    @JsonProperty("models")
    public List<Model> models;
}
