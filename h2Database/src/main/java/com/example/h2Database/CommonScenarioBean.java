package com.example.h2Database;

import java.util.Arrays;
import java.util.List;

import com.example.h2Database.Model.CommonScenario;
import com.example.h2Database.Repository.CommonScenarioRepository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@Component
@Lazy
@ApplicationScope
public class CommonScenarioBean {
    //Get titles of all Common Scenarios
    @Value("${titles}")
	private String titles;

    @Value("${ScenarioDescription1}")
    private String scenario1;

    @Value("${ScenarioDescription2}")
    private String scenario2;

    @Value("${ScenarioDescription3}")
    private String scenario3;

    @Value("${ScenarioDescription4}")
    private String scenario4;

    @Value("${ProblemDescription1}")
    private String problem1;

    @Value("${ProblemDescription2}")
    private String problem2;

    @Value("${ProblemDescription3}")
    private String problem3;

    @Value("${ProblemDescription4}")
    private String problem4;

    @Value("${Solution1}")
    private String solution1;

    @Value("${Solution2}")
    private String solution2;

    @Value("${Solution3}")
    private String solution3;

    @Value("${Solution4}")
    private String solution4;

    private List<String> titleStrings;

    //Add the Common Scenarios to the Database
    public void calculateCommonScenarios(CommonScenarioRepository commonScenarioRepository){
        titleStrings = Arrays.asList(titles.split(","));

        addListAndShiftToRepository(commonScenarioRepository);
        addTechnicalUpgradeToRepository(commonScenarioRepository);
        addAllOrNothingApproach(commonScenarioRepository);
        addSpikingApproach(commonScenarioRepository);
    }

    //Adding Common Scenario 1
    public void addListAndShiftToRepository(CommonScenarioRepository commonScenarioRepository){
        //Lift and Shift location Points
        double[] locationPoints={3, 3, 3, 3, 3, 3, 3, 4, 4};

        //Adding the Matrix to the Common Scenario Repository
        CommonScenario liftAndShiftMatrix = new CommonScenario(titleStrings.get(0), scenario1, problem1, solution1, locationPoints);
        commonScenarioRepository.save(liftAndShiftMatrix);
    }

    //Add Common Scenario 2
    public void addTechnicalUpgradeToRepository(CommonScenarioRepository commonScenarioRepository){
        //Treating Cloud Native as Simply a Technical Upgrade
        double[] locationPoints={3, 3, 3, 3, 4, 4, 4, 4, 4};

        //Adding the Matrix to the Common Scenario Repository
        CommonScenario technicalUpgradeMatrix = new CommonScenario(titleStrings.get(1), scenario2, problem2, solution2, locationPoints);
        commonScenarioRepository.save(technicalUpgradeMatrix);
    }

    //Add Common Scenario 3
    public void addAllOrNothingApproach(CommonScenarioRepository commonScenarioRepository){
        //'All or Nothing Approach' -> Greenfield Myth
        double[] locationPoints={3, 3.5, 3, 2.5, 3.5, 3, 2.5, 3.5, 3.75};

        //Adding the Matrix to the Common Scenario Repository
        CommonScenario allOrNothingMatrix = new CommonScenario(titleStrings.get(2), scenario3, problem3, solution3, locationPoints);
        commonScenarioRepository.save(allOrNothingMatrix);
    }
    
    //Add Common Scenario 4
    public void addSpikingApproach(CommonScenarioRepository commonScenarioRepository){
        //'Spiking' CN Transformation via an Unbalanced Approach
        double[] locationPoints={2.5, 2.5, 2.5, 2.5, 2.5, 2.5, 2.5, 4, 2.5};

        //Adding the Matrix to the Common Scenario Repository
        CommonScenario spikingMatrix = new CommonScenario(titleStrings.get(3), scenario4, problem4, solution4, locationPoints);
        commonScenarioRepository.save(spikingMatrix);
    }
}
