package com.example.Matrix.Frontend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {Section.class})
public class Test_Section {
    private Section testSection;
    private int id = 1;
    private TopLevelQuestion topLevelQuestion;
    private LowLevelQuestion lowLevelQuestion;
    private LowLevelAnswers lowLevelAnswers;

    @BeforeEach
    void init(){
        testSection = new Section(id, topLevelQuestion, lowLevelQuestion);
    }

    @Test
    void test_if_section_created_correctly() {
        assertTrue(testSection.getClass() ==  Section.class);
        
        assertEquals(1, testSection.getId());
        assertEquals(testSection.getTopLevelQuestion(), topLevelQuestion);
        assertEquals(testSection.getLowLevelAnswers(), lowLevelAnswers);
        assertEquals(testSection.getLowLevelAnswers(), lowLevelAnswers);
    }
}
