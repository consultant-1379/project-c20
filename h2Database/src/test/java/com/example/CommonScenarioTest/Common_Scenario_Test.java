package com.example.CommonScenarioTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.h2Database.Model.CommonScenario;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {CommonScenario.class})
class Common_Scenario_Test {
    private CommonScenario commonScenario1;
    private CommonScenario commonScenario2;
    
    @BeforeEach
    void init(){
        String title = "Common Scenario Title";
        String description = "Common Scenario Description";
        String problem = "Common Scenario Problem";
        String solution = "Common Scenario Solution";
        double[] locationPointsExample = new double[]{4.0,5.0,6.0};

        commonScenario1 = new CommonScenario();
        commonScenario2 = new CommonScenario(title, description, problem, solution, locationPointsExample);
    }

    @Test
    void test_if_CommonScenarios_are_created_correctly() {
        /*Testing and setting common scenario 1*/
        commonScenario1.setTitle("Example title");
        commonScenario1.setDescription("Example description");
        commonScenario1.setSolution("Example solution");
        commonScenario1.setProblem("Example problem");

        double[] locationPoints = new double[] {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0};

        commonScenario1.setLocationPoints(locationPoints);

        assertEquals("Example title", commonScenario1.getTitle());
        assertEquals("Example description", commonScenario1.getDescription());
        assertEquals("Example solution", commonScenario1.getSolution());
        assertEquals("Example problem", commonScenario1.getProblem());
        assertEquals(locationPoints, commonScenario1.getLocationPoints());

        assertEquals("Common Scenario Title", commonScenario2.getTitle());
    }
}


