package com.example.Matrix.Backend.QuestionTypes;

import java.io.Serializable;

public class Question implements Serializable {
    
    private int id;

    public Question(int id) {
        this.id = id;
    }

    public Question()   { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
