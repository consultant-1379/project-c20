package com.example.Matrix.Frontend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {QuestionSet.class})
public class Test_QuestionSet {

    @Autowired
    private Map<Integer, TopLevelQuestion> topLevelQuestions;
 
    @Autowired
    private Map<Integer, LowLevelQuestion> lowLevelQuestions;

    private QuestionSet questionSet;

    @BeforeEach
    void init(){
        questionSet=new QuestionSet(topLevelQuestions, lowLevelQuestions);
    }
    
    @Test
    void test_if_questionSet_created_correctly() {

        assertTrue(questionSet.getClass() ==  QuestionSet.class);

        assertEquals(5, questionSet.getSections().get(4).getId(), "ID != 5");
        assertEquals(1, questionSet.getSections().get(4).getTopLevelQuestion().getId(), "ID != 1");

        assertEquals(false, questionSet.getSections().get(1).getTopLevelQuestion().getqItem().getAnswer(), "answer != false");
        assertEquals(false, questionSet.getSections().get(2).getLowLevelQuestion().getqItems().get(0).getAnswer(), "answer != false");

        assertEquals("questionstring", questionSet.getSections().get(4).getTopLevelQuestion().getqItem().getQuestionText(), "Text should be questionstring");

        assertEquals("Low level question item question text string from the frontend", questionSet.getSections().get(5).getLowLevelQuestion().getqItems().get(0).getQuestionText(), "Text does not match");
    }


}
