package com.example.Matrix.Frontend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {QuestionAnswerItem.class})
public class Test_QuestionAnswerItem {
    private QuestionAnswerItem questionAnswerItem;
    
    @BeforeEach
    void init(){
        questionAnswerItem=new QuestionAnswerItem(1, false, "questionAnswerItem");
    }

    @Test
    void test_if_question_answer_item_is_created() {
        assertTrue(questionAnswerItem.getClass() ==  QuestionAnswerItem.class, "Classes do not match");
        assertEquals(questionAnswerItem.getId(), 1);
        assertEquals(false, questionAnswerItem.getAnswer(), "Answer should be false");
        assertEquals("questionAnswerItem", questionAnswerItem.getQuestionText(),"Text should be questionAnswerItem");
    }
    
}
