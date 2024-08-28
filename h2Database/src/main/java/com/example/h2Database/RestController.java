package com.example.h2Database;

import com.example.h2Database.Model.CommonScenario;
import com.example.h2Database.Repository.CommonScenarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin
@RequestMapping("/")
public class RestController {  
    @Autowired
    private CommonScenarioRepository commonScenarioRepository;
    
    @GetMapping(produces = {"application/json"})
    public ResponseEntity<Iterable<CommonScenario>> getCommonScenarios() {
        Iterable<CommonScenario> commonScenarios = commonScenarioRepository.findAll();

        return ResponseEntity.ok().body(commonScenarios);
    }
}
