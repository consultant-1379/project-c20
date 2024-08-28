package com.example.Matrix.Backend.QuestionTypes;

import java.io.Serializable;

public class TopLevelQuestion extends Question implements Serializable{
    
    private QuestionAnswerItem qItem;

    public TopLevelQuestion(int id, QuestionAnswerItem qItem ) {
        super(id);
        this.qItem = qItem;
    }

    public TopLevelQuestion()   {
        
    }

    public QuestionAnswerItem getqItem() {
        return qItem;
    }

    public void setqItem(QuestionAnswerItem qItem) {
        this.qItem = qItem;
    }

}
