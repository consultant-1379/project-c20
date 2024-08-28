package com.example.Matrix.Frontend;

import java.io.Serializable;

public class QuestionAnswerItem implements Serializable{
    private int id;
    private boolean answer;
    private String questionText;
    
    public QuestionAnswerItem(){
    }

    public QuestionAnswerItem(int id, boolean answer, String questionText) {
        this.id = id;
        this.answer = answer;
        this.questionText = questionText;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    public boolean getAnswer() {
        return answer;
    }
}
