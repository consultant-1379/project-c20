package com.example.Matrix.Frontend;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {ViewController.class})
public class Test_ViewController {
    private ViewController viewController;
    
    @BeforeEach
    void init(){
        viewController = new ViewController();
    }

    @Test
    void test_view_controller_is_created() {
        ViewController viewController = new ViewController();
        assertTrue(viewController.getClass() ==  viewController.getClass());
    }
}
