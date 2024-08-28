package com.example.Matrix.Frontend;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class Test_RestClient {
    private RestClient restClient;

    
    @BeforeEach
    void init(){
        restClient=new RestClient();
    }

    @Test
    void test_if_lowLevelAnswers_created_correctly() {
        assertTrue(restClient.getClass() ==  RestClient.class);

    }
}
