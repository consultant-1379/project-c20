
package com.example.Matrix.Backend.TestingQuestions.Testing_QuestionTypes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import com.example.Matrix.Backend.QuestionTypes.LowLevelAnswers;
import com.example.Matrix.Backend.QuestionTypes.LowLevelQuestion;
import com.example.Matrix.Backend.QuestionTypes.QuestionAnswerItem;
import com.example.Matrix.Backend.QuestionTypes.Section;
import com.example.Matrix.Backend.QuestionTypes.TopLevelQuestion;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {Section.class})
class Test_Section_Created_Correctly {
    private Section section;
    private ArrayList<QuestionAnswerItem> qItems=new ArrayList<QuestionAnswerItem>();
    
    @BeforeEach
    void init(){
        QuestionAnswerItem testQuestionAnswerItem0 = new QuestionAnswerItem(110, false, "TEST SECTION - TESTQUESTIONANSWERITEM0 QUESTIONTEXT");
        TopLevelQuestion testTopLevelQuestion = new TopLevelQuestion(10, testQuestionAnswerItem0);

        QuestionAnswerItem testQuestionAnswerItem1=new QuestionAnswerItem(111, false, "TEST SECTION - TESTQUESTIONANSWERITEM1 QUESTIONTEXT");
        QuestionAnswerItem testQuestionAnswerItem2=new QuestionAnswerItem(112, false, "TEST SECTION - TESTQUESTIONANSWERITEM2 QUESTIONTEXT");
        qItems.add(testQuestionAnswerItem1);
        qItems.add(testQuestionAnswerItem2);
        LowLevelQuestion testLowLevelQuestion=new LowLevelQuestion(11, qItems);

        section= new Section(1,testTopLevelQuestion, testLowLevelQuestion, "prompt", "stage");
        String[][] testAnswersArray={{"TEST SECTION - TESTANSWER1"}, {"TEST SECTION - TESTANSWER2"}};
        LowLevelAnswers testAnswers = new LowLevelAnswers(testAnswersArray);
        section.setLowLevelAnswers(testAnswers);
    }

    @Test
    void test_if_section_created_correctly() {
    
        // assertTrue(section.getClass() ==  Section.class, "TEST SECTION ERROR - CLASS TYPE NOT MATCHING");

        assertEquals(1, section.getId(), "TEST SECTION  ERROR - ID SHOULD BE 1");
        assertEquals(10, section.getTopLevelQuestion().getId(), "TEST SECTION ERROR - ID SHOULD BE 10");
        assertEquals(110, section.getTopLevelQuestion().getqItem().getId(), "TEST SECTION  ERROR - ID SHOULD BE 110");
        assertEquals(112, section.getLowLevelQuestion().getqItems().get(1).getId(), "TEST SECTION  ERROR - ID SHOULD BE 112");

        assertEquals(false, section.getTopLevelQuestion().getqItem().getAnswer(), "TEST SECTION ERROR - ANSWER SHOULD BE FALSE");
        assertEquals(false, section.getLowLevelQuestion().getqItems().get(0).getAnswer(), "TEST SECTION ERROR - ANSWER SHOULD BE FALSE");

        assertEquals("TEST SECTION - TESTQUESTIONANSWERITEM1 QUESTIONTEXT", section.getLowLevelQuestion().getqItems().get(0).getQuestionText(),  "TEST SECTION ERROR - TEXT MUST BE MATCHING");
        assertEquals("TEST SECTION - TESTANSWER2", section.getLowLevelAnswers().getAnswers()[1][0],  "TEST SECTION ERROR - TEXT MUST BE MATCHING");
    }
 
}
