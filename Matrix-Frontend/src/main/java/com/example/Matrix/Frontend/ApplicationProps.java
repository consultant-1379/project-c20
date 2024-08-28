package com.example.Matrix.Frontend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "rersources")
public class ApplicationProps {
    
    @Value("${topLevelQuestionStrings}")
    private String[] topLevelQuestionStrings;
    
    public String[] getTopLevelQuestionStrings() {
        return topLevelQuestionStrings;
    }

    public void setTopLevelQuestionStrings(String[] topLevelQuestionStrings) {
        this.topLevelQuestionStrings = topLevelQuestionStrings;
    }

}
