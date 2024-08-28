package com.example.Matrix.Frontend;

import java.io.Serializable;
import java.util.List;

public class LowLevelQuestion extends Question implements Serializable{

    private List<QuestionAnswerItem> qItems;

    public LowLevelQuestion(){
    }

    public LowLevelQuestion(int id, List<QuestionAnswerItem> qItems) {
        super(id);
        this.qItems = qItems;
        
    }
    
    public void setqItems(List<QuestionAnswerItem> qItems) {
        this.qItems = qItems;
    }

    public List<QuestionAnswerItem> getqItems() {
        return qItems;
    }

}
