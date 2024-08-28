
package com.example.Matrix.Backend.TestingQuestions.Testing_QuestionTypes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import com.example.Matrix.Backend.QuestionTypes.LowLevelAnswers;
import com.example.Matrix.Backend.QuestionTypes.LowLevelQuestion;
import com.example.Matrix.Backend.QuestionTypes.QuestionAnswerItem;
import com.example.Matrix.Backend.QuestionTypes.QuestionSet;
import com.example.Matrix.Backend.QuestionTypes.Section;
import com.example.Matrix.Backend.QuestionTypes.TopLevelQuestion;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {QuestionSet.class})
class Test_QuestionSet_Created_Correctly {
    private QuestionSet questionSet;
    private Section section;
    private ArrayList<QuestionAnswerItem> qItems=new ArrayList<QuestionAnswerItem>();
    
    @BeforeEach
    void init(){

        QuestionAnswerItem testQuestionAnswerItem0 = new QuestionAnswerItem(110, false, "TEST QUESTIONSET - TESTQUESTIONANSWERITEM0 QUESTIONTEXT");
        TopLevelQuestion testTopLevelQuestion = new TopLevelQuestion(10, testQuestionAnswerItem0);

        QuestionAnswerItem testQuestionAnswerItem1=new QuestionAnswerItem(111, false, "TEST QUESTIONSET - TESTQUESTIONANSWERITEM1 QUESTIONTEXT");
        QuestionAnswerItem testQuestionAnswerItem2=new QuestionAnswerItem(112, false, "TEST QUESTIONSET - TESTQUESTIONANSWERITEM2 QUESTIONTEXT");
        qItems.add(testQuestionAnswerItem1);
        qItems.add(testQuestionAnswerItem2);
        LowLevelQuestion testLowLevelQuestion=new LowLevelQuestion(11, qItems);

        section= new Section(1,testTopLevelQuestion, testLowLevelQuestion, "prompt", "stage");
        String[][] testAnswersArray={{"TEST QUESTIONSET - TESTANSWER1"}, {"TEST QUESTIONSET - TESTANSWER2"}};
        LowLevelAnswers testAnswers = new LowLevelAnswers(testAnswersArray);
        section.setLowLevelAnswers(testAnswers);

        List<Section> listSections=new ArrayList<Section>();
        listSections.add(section);

        questionSet = new QuestionSet(listSections);

    }

    @Test
    void test_if_questionSet_created_correctly() {

        // assertTrue(questionSet.getClass() ==  QuestionSet.class, "TEST QUESTIONSET ERROR - CLASS TYPE NOT MATCHING");

        assertEquals(1, questionSet.getSections().get(0).getId(), "TEST QUESTIONSET  ERROR - ID SHOULD BE 1");
        assertEquals(10, questionSet.getSections().get(0).getTopLevelQuestion().getId(), "TEST QUESTIONSET  ERROR - ID SHOULD BE 10");

        assertEquals(false, questionSet.getSections().get(0).getTopLevelQuestion().getqItem().getAnswer(), "TEST QUESTIONSET ERROR - ANSWER SHOULD BE FALSE");
        assertEquals(false, questionSet.getSections().get(0).getLowLevelQuestion().getqItems().get(0).getAnswer(), "TEST QUESTIONSET ERROR - ANSWER SHOULD BE FALSE");

        // "questionstring"
        assertEquals("TEST QUESTIONSET - TESTQUESTIONANSWERITEM0 QUESTIONTEXT", questionSet.getSections().get(0).getTopLevelQuestion().getqItem().getQuestionText(), "TEST QUESTIONSET ERROR - TEXT MUST BE MATCHING");

        // "Low level question item question text string"  
        assertEquals("TEST QUESTIONSET - TESTQUESTIONANSWERITEM1 QUESTIONTEXT", questionSet.getSections().get(0).getLowLevelQuestion().getqItems().get(0).getQuestionText(), "TEST QUESTIONSET ERROR - TEXT MUST BE MATCHING");
    }    
}

