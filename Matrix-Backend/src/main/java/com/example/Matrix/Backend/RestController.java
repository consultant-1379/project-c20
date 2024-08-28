package com.example.Matrix.Backend;

import java.util.HashMap;
import java.util.Map;

import com.example.Matrix.Backend.Matrix.Entity.CloudNativeMaturityMatrix;
import com.example.Matrix.Backend.Matrix.Entity.CommonScenario;
import com.example.Matrix.Backend.Matrix.Service.CloudMatrixServiceInterface;
import com.example.Matrix.Backend.QuestionTypes.QuestionSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin
@RequestMapping("/")
public class RestController {  
    @Autowired
    private CloudMatrixServiceInterface cloudMatrixServiceInterface;

    @GetMapping(value="/questionSet", produces = {"application/json"})
    public ResponseEntity<QuestionSet> produceQuestionSet() {
        QuestionSet producedQuestionSet = cloudMatrixServiceInterface.getQuestionSetFromRespository();
        return ResponseEntity.ok().body(producedQuestionSet);
    }

    @PostMapping(consumes={"application/json", "application/xml"}, produces = {"application/json"})
    public ResponseEntity<Map<String,Object>> calculateCloudNativeMaturityMatrix(@RequestBody QuestionSet questionSet) {
        CloudNativeMaturityMatrix cloudNativeMaturityMatrix = cloudMatrixServiceInterface.returnCloudMatrixFromRepository(questionSet);
        CommonScenario commonScenario = cloudMatrixServiceInterface.compareToCommonScenarioFromRepository(cloudNativeMaturityMatrix);
        
        Map<String, Object> mapOfObjects = new HashMap<>();
        mapOfObjects.put("CloudMatrix", cloudNativeMaturityMatrix);
        mapOfObjects.put("CommonScenario", commonScenario);
    
        return ResponseEntity.ok().body(mapOfObjects);
    }
}
