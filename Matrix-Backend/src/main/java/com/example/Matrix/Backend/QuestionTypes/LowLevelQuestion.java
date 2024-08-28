package com.example.Matrix.Backend.QuestionTypes;

import java.io.Serializable;
import java.util.List;

public class LowLevelQuestion extends Question implements Serializable{

    private List<QuestionAnswerItem> qItems;

    public LowLevelQuestion(int id, List<QuestionAnswerItem> qItems) {
        super(id);
        this.qItems = qItems;
        
    }

    public LowLevelQuestion()   {}
    
    public void setqItems(List<QuestionAnswerItem> qItems) {
        this.qItems = qItems;
    }

    public List<QuestionAnswerItem> getqItems() {
        return qItems;
    }

}
