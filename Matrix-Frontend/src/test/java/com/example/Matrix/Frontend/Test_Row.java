package com.example.Matrix.Frontend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
public class Test_Row {
    private Row testRow;

    @BeforeEach
    void init(){
        testRow =new Row();
    }

    @Test
    void test_row_is_created() {
        assertTrue(testRow.getClass() == Row.class);
    }
}
