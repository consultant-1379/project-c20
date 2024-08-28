package com.example.Matrix.Frontend;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class Test_MatrixFrontendApplication {
    private MatrixFrontendApplication testMatrixFrontendApplication;
    Map<Integer, TopLevelQuestion> topLevelQuestions = new HashMap<Integer, TopLevelQuestion>();

    @BeforeEach
    void init(){
        testMatrixFrontendApplication =new MatrixFrontendApplication();
    }

    @Test
    void test_matrix_frontend_application_is_created() {
        assertTrue(testMatrixFrontendApplication.getClass() ==  testMatrixFrontendApplication.getClass());
    }
}
