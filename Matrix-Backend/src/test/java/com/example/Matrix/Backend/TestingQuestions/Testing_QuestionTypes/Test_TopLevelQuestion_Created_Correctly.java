
package com.example.Matrix.Backend.TestingQuestions.Testing_QuestionTypes;

import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.Matrix.Backend.QuestionTypes.QuestionAnswerItem;
import com.example.Matrix.Backend.QuestionTypes.TopLevelQuestion;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {TopLevelQuestion.class})
class Test_TopLevelQuestion_Created_Correctly {
    private TopLevelQuestion topLevelQuestion;
    private QuestionAnswerItem testQuestionAnswerItem;
    
    @BeforeEach
    void init(){
        testQuestionAnswerItem = new QuestionAnswerItem(10, false, "TEST TOPLEVELQUESTION - QUESTIONANSWERITEM QUESTIONTEXT");
        topLevelQuestion=new TopLevelQuestion(1, testQuestionAnswerItem);
    }

    @Test
    void test_if_topLevelQuestion_created_correctly() {

        // assertTrue(topLevelQuestion.getClass() ==  TopLevelQuestion.class, "TEST TOPLEVELQUESTION ERROR - CLASS TYPE NOT MATCHING");
        // assertEquals(topLevelQuestion, TopLevelQuestion.class);
        assertEquals(1, topLevelQuestion.getId(), "TEST TOPLEVELQUESTION ERROR - ID SHOULD BE 1");
        assertEquals(10, topLevelQuestion.getqItem().getId(), "TEST TOPLEVELQUESTION ERROR - QUESTIONANSWERITEM ID SHOULD BE 10");
        assertEquals("TEST TOPLEVELQUESTION - QUESTIONANSWERITEM QUESTIONTEXT", topLevelQuestion.getqItem().getQuestionText(),
        "TEST TOPLEVELQUESTION ERROR - TEXT SHOULD BE: \n TEST TOPLEVELQUESTION - QUESTIONANSWERITEM QUESTIONTEXT");
        assertEquals(false, topLevelQuestion.getqItem().getAnswer(), "TEST TOPLEVELQUESTION ERROR - QUESTIONANSWERITEM ANSWER SHOULD BE FALSE");

    }

    
    
}
