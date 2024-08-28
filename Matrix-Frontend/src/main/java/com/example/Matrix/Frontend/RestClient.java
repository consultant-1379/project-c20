package com.example.Matrix.Frontend;

import java.util.Collections;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class RestClient {
    private final static String MATRIX_BACKEND_URL = "http://localhost:8080/";

    public static CloudNativeMaturityMatrix postQuestionSet(QuestionSet questionSet) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<QuestionSet> requestBody = new HttpEntity<QuestionSet>(questionSet, headers);
        
        return restTemplate.postForObject(MATRIX_BACKEND_URL, requestBody, CloudNativeMaturityMatrix.class);

    }
}
