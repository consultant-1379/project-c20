package com.example.Matrix.Frontend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {CloudNativeMaturityMatrix.class})
public class Test_CloudNativeMaturityMatrix {
    private CloudNativeMaturityMatrix testCloudNativeMaturityMatrix;
    private List<Row> rows;

    @BeforeEach
    void init(){
        testCloudNativeMaturityMatrix = new CloudNativeMaturityMatrix(rows);
    }

    @Test
    void test_if_cloud_native_maturity_matrix_is_created() {
        assertTrue(testCloudNativeMaturityMatrix.getClass() ==  testCloudNativeMaturityMatrix.getClass());
        assertEquals(testCloudNativeMaturityMatrix.getRows(), rows);
    }
}
