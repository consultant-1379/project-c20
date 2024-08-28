package com.example.Matrix.Backend;

import com.example.Matrix.Backend.Matrix.Entity.CommonScenario;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestClient {
    private static final String DATABASE_URL = "http://localhost:3030/";

    public static ResponseEntity<CommonScenario[]> getCommonScenarios() {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForEntity(DATABASE_URL, CommonScenario[].class);
    }
}