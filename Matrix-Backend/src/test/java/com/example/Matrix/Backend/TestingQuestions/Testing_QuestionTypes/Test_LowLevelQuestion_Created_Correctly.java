
package com.example.Matrix.Backend.TestingQuestions.Testing_QuestionTypes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import com.example.Matrix.Backend.QuestionTypes.LowLevelQuestion;
import com.example.Matrix.Backend.QuestionTypes.QuestionAnswerItem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {LowLevelQuestion.class})
class Test_LowLevelQuestion_Created_Correctly {
    private LowLevelQuestion lowLevelQuestion;
    private ArrayList<QuestionAnswerItem> qItems=new ArrayList<QuestionAnswerItem>();
    
    @BeforeEach
    void init(){
        QuestionAnswerItem testQuestionAnswerItem1=new QuestionAnswerItem(110, false, "TEST LOWLEVELQUESTION - QUESTIONANSWERITEM1 QUESTIONTEXT");
        QuestionAnswerItem testQuestionAnswerItem2=new QuestionAnswerItem(111, false, "TEST LOWLEVELQUESTION - QUESTIONANSWERITEM2 QUESTIONTEXT");
        qItems.add(testQuestionAnswerItem1);
        qItems.add(testQuestionAnswerItem2);
        lowLevelQuestion=new LowLevelQuestion(1, qItems);
    }

    @Test
    void test_if_lowLevelQuestion_created_correctly() {

        // LowLevelQuestion testQuestion=new LowLevelQuestion();

        // assertTrue(lowLevelQuestion.getClass() ==  LowLevelQuestion.class);

        assertEquals(1, lowLevelQuestion.getId(), "TEST LOWLEVELQUESTION ERROR - ID SHOULD BE 1");
        assertEquals(110, lowLevelQuestion.getqItems().get(0).getId(), "TEST LOWLEVELQUESTION ERROR - QUESTIONANSWERITEM1 ID SHOULD BE 110");
        assertEquals(111, lowLevelQuestion.getqItems().get(1).getId(), "TEST LOWLEVELQUESTION ERROR - QUESTIONANSWERITEM2 ID SHOULD BE 111");

        assertEquals(false, lowLevelQuestion.getqItems().get(0).getAnswer(), "TEST LOWLEVELQUESTION ERROR - QUESTIONANSWERITEM1 ANSWER SHOULD BE FALSE");
        assertEquals(false, lowLevelQuestion.getqItems().get(1).getAnswer(), "TEST LOWLEVELQUESTION ERROR - QUESTIONANSWERITEM2 ANSWER SHOULD BE FALSE");

        assertEquals("TEST LOWLEVELQUESTION - QUESTIONANSWERITEM1 QUESTIONTEXT", lowLevelQuestion.getqItems().get(0).getQuestionText(),
        "TEST LOWLEVELQUESTION ERROR - QUESTIONANSWERITEM1 TEXT SHOULD BE: \n TEST LOWLEVELQUESTION - QUESTIONANSWERITEM1 QUESTIONTEXT");
        assertEquals("TEST LOWLEVELQUESTION - QUESTIONANSWERITEM2 QUESTIONTEXT", lowLevelQuestion.getqItems().get(1).getQuestionText(),
        "TEST LOWLEVELQUESTION ERROR - QUESTIONANSWERITEM2 TEXT SHOULD BE: \n TEST LOWLEVELQUESTION - QUESTIONANSWERITEM2 QUESTIONTEXT");

    }

    
}