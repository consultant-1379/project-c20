package com.example.Matrix.Backend.TestingQuestions.Testing_QuestionTypes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.Matrix.Backend.QuestionTypes.QuestionAnswerItem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {QuestionAnswerItem.class})
class Test_QuestionAnswerItem_Creating_Correctly {
    
    private QuestionAnswerItem questionAnswerItem;
    
    @BeforeEach
    void init(){
        questionAnswerItem=new QuestionAnswerItem(1, false, "TEST QUESTIONANSWERITEM - QUESTIONTEXT");
    }

    @Test
    void test_if_question_created_correctly() {

        // assertTrue(questionAnswerItem.getClass() ==  QuestionAnswerItem.class, "TEST QUESTIONANSWERITEM ERROR - CLASS TYPE NOT MATCHING");
        assertEquals(1, questionAnswerItem.getId(), "TEST QUESTIONANSWERITEM ERROR - ID SHOULD BE 1");
        assertEquals(false, questionAnswerItem.getAnswer(), "TEST QUESTIONANSWERITEM ERROR - ANSWER SHOULD BE FALSE");
        assertEquals("TEST QUESTIONANSWERITEM - QUESTIONTEXT", questionAnswerItem.getQuestionText(),
        "TEST QUESTIONANSWERITEM ERROR - TEXT SHOULD BE: \n TEST QUESTIONANSWERITEM - QUESTIONTEXT");

    }
    

    
    
}

