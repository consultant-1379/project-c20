package com.example.Matrix.Frontend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {LowLevelQuestion.class})
public class Test_LowLevelQuestion {
    private LowLevelQuestion lowLevelQuestion;
    private ArrayList<QuestionAnswerItem> testQuestionAnswerItems=new ArrayList<QuestionAnswerItem>();
    
    @BeforeEach
    void init(){
        QuestionAnswerItem testQuestionAnswerItem1=new QuestionAnswerItem(555, false, "testQuestionAnswerItem1");
        QuestionAnswerItem testQuestionAnswerItem2=new QuestionAnswerItem(999, false, "testQuestionAnswerItem2");
        testQuestionAnswerItems.add(testQuestionAnswerItem1);
        testQuestionAnswerItems.add(testQuestionAnswerItem2);
        lowLevelQuestion=new LowLevelQuestion(1, testQuestionAnswerItems);
    }

    @Test
    void test_if_lowLevelQuestion_created_correctly() {
        assertTrue(lowLevelQuestion.getClass() ==  LowLevelQuestion.class);

        assertEquals(555, lowLevelQuestion.getqItems().get(0).getId(), "testQuestionAnswerItem1 !=555");
        assertEquals(999, lowLevelQuestion.getqItems().get(1).getId(), "testQuestionAnswerItem2 !=999");

        assertEquals(false, lowLevelQuestion.getqItems().get(0).getAnswer(), "lowLevelQuestion1 item != false");
        assertEquals(false, lowLevelQuestion.getqItems().get(1).getAnswer(), "lowLevelQuestion2 item != false");

        assertEquals("testQuestionAnswerItem1", lowLevelQuestion.getqItems().get(0).getQuestionText(), "testQuestionAnswerItem1 != testQuestionAnswerItem1");
        assertEquals("testQuestionAnswerItem2", lowLevelQuestion.getqItems().get(1).getQuestionText(), "testQuestionAnswerItem2 != testQuestionAnswerItem2");

    }
}
