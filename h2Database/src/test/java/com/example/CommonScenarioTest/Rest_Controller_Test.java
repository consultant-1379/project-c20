package com.example.CommonScenarioTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.example.h2Database.RestController;
import com.example.h2Database.Model.CommonScenario;
import com.example.h2Database.Repository.CommonScenarioRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
public class Rest_Controller_Test {
    @InjectMocks
    private RestController restController;
    
    @Mock
    private CommonScenarioRepository commonScenarioRepository;

    @Test
    public void testGettingAllEmployees(){
        Iterable<CommonScenario> commonScenarios = commonScenarioRepository.findAll();

        List<CommonScenario> commonScenariosList = new ArrayList<>();

        commonScenarios.forEach((commonScenario) -> commonScenariosList.add(commonScenario));

        assertEquals(4, commonScenariosList.size());
    }
}
