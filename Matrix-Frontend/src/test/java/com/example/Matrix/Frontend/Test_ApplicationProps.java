package com.example.Matrix.Frontend;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {ApplicationProps.class})
public class Test_ApplicationProps {
    private ApplicationProps applicationProps;
    
    @BeforeEach
    void init(){
        applicationProps = new ApplicationProps();
    }

    @Test
    void test_application_props_is_created() {
        ApplicationProps testApplicationProps = new ApplicationProps();
        assertTrue(testApplicationProps.getClass() ==  testApplicationProps.getClass());
    }
}
