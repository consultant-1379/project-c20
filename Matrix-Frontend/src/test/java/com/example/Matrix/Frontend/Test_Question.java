package com.example.Matrix.Frontend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
public class Test_Question {
    private Question question;

    @BeforeEach
    void init(){
        question =new Question(1);
    }

    @Test
    void test_matrix_question_is_created() {
        assertTrue(question.getClass() == Question.class);
        assertEquals(1, question.getId());
    }
}
