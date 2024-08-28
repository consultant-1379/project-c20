package com.example.Matrix.Frontend;
public class LowLevelAnswers {
    
    private int id;
    private String answers[][];
  
    public LowLevelAnswers(String[][] answers){
        this.answers = answers;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setAnswers(String answers[][]) {
        this.answers = answers;
    }

    public String[][] getAnswers() {
        return this.answers;
    }
}
