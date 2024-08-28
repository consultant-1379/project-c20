package com.example.Matrix.Backend.QuestionTypes;

import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class QuestionSet {
    private List<Section> sections;

    String[][] answers; 
    public QuestionSet() {
        
    }

    public QuestionSet(List<Section> sections){
        this.sections = sections;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }
}
