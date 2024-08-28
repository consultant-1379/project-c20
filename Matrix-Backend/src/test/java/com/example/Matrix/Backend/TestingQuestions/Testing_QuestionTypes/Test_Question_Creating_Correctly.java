package com.example.Matrix.Backend.TestingQuestions.Testing_QuestionTypes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.Matrix.Backend.QuestionTypes.Question;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {Question.class})
class Test_Question_Creating_Correctly {
    
    private Question question;
    
    @BeforeEach
    void init(){
        question=new Question(1);
    }

    @Test
    void test_if_question_created_correctly() {

        // assertTrue(question.getClass() ==  Question.class);
        assertEquals(1, question.getId(), "TEST BASEQUESTION ERROR - ID SHOULD BE 1");

    }
    

    
    
}

