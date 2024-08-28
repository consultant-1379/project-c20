package com.example.Matrix.Frontend;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MatrixFrontendApplication {

    @Autowired
	private ApplicationProps applicationProps;

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(MatrixFrontendApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean()
	@Scope("application")
    public Map<Integer, TopLevelQuestion> topLevelQuestions() {
        Map<Integer, TopLevelQuestion> topLevelQuestions = new HashMap<Integer, TopLevelQuestion>();


        // String[] topLevelQuestionstrings = env.getProperty("topLevelQuestionStrings", String[].class);
        
		// System.out.println("????????????????????????");
		// System.out.println(topLevelQuestions);

        // int i = 1;
        // for(String questionstring: applicationProps.getTopLevelQuestionStrings()) {

        //     QuestionAnswerItem qItem = new QuestionAnswerItem(i, false, questionstring);
        //     topLevelQuestions.put(1, new TopLevelQuestion(1, qItem));
        //     i++;

        // }

		for (int i=1; i < 10; i++) {

			QuestionAnswerItem qItem = new QuestionAnswerItem(i, false, "questionstring");
			topLevelQuestions.put(i, new TopLevelQuestion(1, qItem));
			   
		}

		
        return topLevelQuestions;

	}
}
