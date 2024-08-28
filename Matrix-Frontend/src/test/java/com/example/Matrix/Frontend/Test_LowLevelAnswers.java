package com.example.Matrix.Frontend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {LowLevelAnswers.class})
public class Test_LowLevelAnswers {
    private LowLevelAnswers lowLevelAnswers;

    private String[][] answers={
        {"TestAns1", "TestAns2"},
        {"TestAns3", "TestAns4"},
        {"TestAns5", "TestAns6"}
    };
    
    @BeforeEach
    void init(){
        lowLevelAnswers=new LowLevelAnswers(answers);
        lowLevelAnswers.setId(1);
    }

    @Test
    void test_if_low_level_answers_is_created() {
        assertTrue(lowLevelAnswers.getClass() ==  LowLevelAnswers.class, "Class type not equal");
        assertEquals(1, lowLevelAnswers.getId(), "ID != 1");
        assertEquals("TestAns1", lowLevelAnswers.getAnswers()[0][0], "TestAns1 != lowLevelAnswers[0][0]");
        assertEquals("TestAns2", lowLevelAnswers.getAnswers()[0][1], "TestAns2 != lowLevelAnswers[0][1]");
        assertEquals("TestAns3", lowLevelAnswers.getAnswers()[1][0], "TestAns3 != lowLevelAnswers[1][0]");
        assertEquals("TestAns4", lowLevelAnswers.getAnswers()[1][1], "TestAns4 != lowLevelAnswers[1][0]");
        assertEquals("TestAns5", lowLevelAnswers.getAnswers()[2][0], "TestAns5 != lowLevelAnswers[2][0]");
        assertEquals("TestAns6", lowLevelAnswers.getAnswers()[2][1], "TestAns6 != lowLevelAnswers[2][1]");

    }
}
