package com.example.Matrix.Frontend;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class QuestionSet {

    private Map<Integer, TopLevelQuestion> topLevelQuestions;
    private Map<Integer, LowLevelQuestion> lowLevelQuestions;
    private List<Section> sections;

    public QuestionSet(Map<Integer, TopLevelQuestion> topLevelQuestions, Map<Integer, LowLevelQuestion> lowLevelQuestions) {
        this.topLevelQuestions = topLevelQuestions;
        this.lowLevelQuestions = lowLevelQuestions;
        this.sections = generateSections();

    }

    public List<Section> generateSections() {
        List<Section> sections = new ArrayList<Section>();
        for (int i = 1; i < 10; i++) {
            TopLevelQuestion topLevelQuestion = topLevelQuestions.get(i);
            LowLevelQuestion lowLevelQuestion = lowLevelQuestions.get(i);
            sections.add(new Section(i, topLevelQuestion, lowLevelQuestion));
        }
        return sections;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

}
