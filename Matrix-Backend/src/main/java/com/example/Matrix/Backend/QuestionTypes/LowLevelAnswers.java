package com.example.Matrix.Backend.QuestionTypes;

import java.io.Serializable;

public class LowLevelAnswers implements Serializable{
    
    private int id;
    private String[][] answers;
  
    public LowLevelAnswers(String[][] answers){
        this.answers = answers;
    }

    public LowLevelAnswers()    {}

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setAnswers(String[][] answers) {
        this.answers = answers;
    }

    public String[][] getAnswers() {
        return this.answers;
    }
}
