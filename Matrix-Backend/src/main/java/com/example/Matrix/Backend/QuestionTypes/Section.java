package com.example.Matrix.Backend.QuestionTypes;

import java.io.Serializable;

public class Section implements Serializable{
    
    private int id;
    private String prompt;
    private String stage;
    private TopLevelQuestion topLevelQuestion;
    private LowLevelQuestion lowLevelQuestion;
    private LowLevelAnswers lowLevelAnswers;

    public Section(int id, TopLevelQuestion topLevelQuestion, LowLevelQuestion lowLevelQuestion, String stage, String prompt) {
        this.id = id;
        this.topLevelQuestion = topLevelQuestion;
        this.lowLevelQuestion = lowLevelQuestion;
        this.stage = stage;
        this.prompt = prompt;
    }

    public Section()    {}

    public String getStage(){
        return stage;
    }

    public String getPrompt(){
        return prompt;
    }

    public void setStage(String stage){
        this.stage = stage;
    }

    public void setPrompt(String prompt){
        this.prompt = prompt;
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
