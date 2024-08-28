package com.example.Matrix.Frontend;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class Test_TopLevelQuestion {
    private QuestionAnswerItem testQuestionAnswerItem;
    private TopLevelQuestion testTopLevelQuestion;
    
    @BeforeEach
    void init(){
        testTopLevelQuestion = new TopLevelQuestion(1, testQuestionAnswerItem);
    }

    @Test
    void test_top_level_question_is_created() {
        TopLevelQuestion topLevelQuestion = new TopLevelQuestion(1, testQuestionAnswerItem);
        assertTrue(topLevelQuestion.getClass() ==  topLevelQuestion.getClass());
    }    
}
