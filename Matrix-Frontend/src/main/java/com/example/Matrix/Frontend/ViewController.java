package com.example.Matrix.Frontend;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ViewController {

    @Autowired
    private Map<Integer, TopLevelQuestion> topLevelQuestions;
 
    @Autowired
    private Map<Integer, LowLevelQuestion> lowLevelQuestions;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/questionset")
    public String questionSetForm(Model model) {

        model.addAttribute("questionset", new QuestionSet(topLevelQuestions, lowLevelQuestions));
        return "questionset";
    }
    
    @PostMapping("/cloudnativematuritymatrix")
    public String questionsetSubmit(@ModelAttribute QuestionSet questionSet, Model model) {

        CloudNativeMaturityMatrix matrix = RestClient.postQuestionSet(questionSet);


        model.addAttribute("matrix", matrix);
        return "cloudnativematuritymatrix";
    }

}
