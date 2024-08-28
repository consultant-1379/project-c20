
package com.example.Matrix.Backend.TestingQuestions.Testing_QuestionTypes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.Matrix.Backend.QuestionTypes.LowLevelAnswers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {LowLevelAnswers.class})
class Test_LowLevelAnswers_Creating_Correctly {
    private LowLevelAnswers lowLevelAnswers;
    private String[][] testAnswers={{"TEST LOWLEVELANSWERS - TESTANSWER1", "TEST LOWLEVELANSWERS - TESTANSWER2"},
    {"TEST LOWLEVELANSWERS - TESTANSWER3", "TEST LOWLEVELANSWERS - TESTANSWER4"}};
    
    @BeforeEach
    void init(){
        
        lowLevelAnswers=new LowLevelAnswers(testAnswers);
        lowLevelAnswers.setId(1);
    }

    @Test
    void test_if_lowLevelAnswers_created_correctly() {

        // assertTrue(lowLevelAnswers.getClass() ==  LowLevelAnswers.class, "TEST LOWLEVELANSWERS ERROR - CLASS TYPE NOT MATCHING");
        assertEquals(1, lowLevelAnswers.getId(), "TEST LOWLEVELANSWERS ERROR - ID SHOULD BE 1");

        assertEquals("TEST LOWLEVELANSWERS - TESTANSWER1", lowLevelAnswers.getAnswers()[0][0], 
        "TEST LOWLEVELANSWERS ERROR - TEXT SHOULD BE: \n TEST LOWLEVELANSWERS - TESTANSWER1");
        assertEquals("TEST LOWLEVELANSWERS - TESTANSWER2", lowLevelAnswers.getAnswers()[0][1], 
        "TEST LOWLEVELANSWERS ERROR - TEXT SHOULD BE: \n TEST LOWLEVELANSWERS - TESTANSWER2");
        assertEquals("TEST LOWLEVELANSWERS - TESTANSWER3", lowLevelAnswers.getAnswers()[1][0], 
        "TEST LOWLEVELANSWERS ERROR - TEXT SHOULD BE: \n TEST LOWLEVELANSWERS - TESTANSWER3");
        assertEquals("TEST LOWLEVELANSWERS - TESTANSWER4", lowLevelAnswers.getAnswers()[1][1], 
        "TEST LOWLEVELANSWERS ERROR - TEXT SHOULD BE: \n TEST LOWLEVELANSWERS - TESTANSWER4");
    }    
}
