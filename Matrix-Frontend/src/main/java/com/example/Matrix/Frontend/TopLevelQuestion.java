package com.example.Matrix.Frontend;

public class TopLevelQuestion extends Question {
    
    private QuestionAnswerItem qItem;

    public TopLevelQuestion(int id, QuestionAnswerItem qItem ) {
        super(id);
        this.qItem = qItem;
    }

    public QuestionAnswerItem getqItem() {
        return qItem;
    }

    public void setqItem(QuestionAnswerItem qItem) {
        this.qItem = qItem;
    }

}
