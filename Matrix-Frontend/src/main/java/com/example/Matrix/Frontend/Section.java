package com.example.Matrix.Frontend;

import java.io.Serializable;

public class Section implements Serializable{
    

    private int id;
    private TopLevelQuestion topLevelQuestion;
    private LowLevelQuestion lowLevelQuestion;
    private LowLevelAnswers lowLevelAnswers;

    public Section(){

    }

    public Section(int id, TopLevelQuestion topLevelQuestion, LowLevelQuestion lowLevelQuestion) {
        this.id = id;
        this.topLevelQuestion = topLevelQuestion;
        this.lowLevelQuestion = lowLevelQuestion;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LowLevelQuestion getLowLevelQuestion() {
        return lowLevelQuestion;
    }

    public void setLowLevelQuestion(LowLevelQuestion lowLevelQuestion) {
        this.lowLevelQuestion = lowLevelQuestion;
    }

    public TopLevelQuestion getTopLevelQuestion() {
        return topLevelQuestion;
    }

    public void setTopLevelQuestion(TopLevelQuestion topLevelQuestion) {
        this.topLevelQuestion = topLevelQuestion;
    }

    public LowLevelAnswers getLowLevelAnswers() {
        return lowLevelAnswers;
    }

    public void setLowLevelAnswers(LowLevelAnswers lowLevelAnswer) {
        this.lowLevelAnswers = lowLevelAnswer;
    }

}
