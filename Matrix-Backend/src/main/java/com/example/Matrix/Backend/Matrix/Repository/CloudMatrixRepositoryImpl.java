package com.example.Matrix.Backend.Matrix.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

import com.example.Matrix.Backend.RestClient;
import com.example.Matrix.Backend.Matrix.Entity.CloudNativeMaturityMatrix;
import com.example.Matrix.Backend.Matrix.Entity.CommonScenario;
import com.example.Matrix.Backend.QuestionTypes.LowLevelQuestion;
import com.example.Matrix.Backend.QuestionTypes.QuestionSet;
import com.example.Matrix.Backend.QuestionTypes.Section;
import com.example.Matrix.Backend.QuestionTypes.TopLevelQuestion;
import com.example.Matrix.Backend.Rows.Row;
import com.example.Matrix.Backend.Rows.RowImpl;
import com.example.Matrix.Backend.Verification.VerificationInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public class CloudMatrixRepositoryImpl implements CloudMatrixRepositoryInterface {
    //VerificationInterface that allows us to Autowire a verification Implementation
    @Autowired 
    private VerificationInterface verification;

    //Return the String HashMap that represents the list of Strings on each Row
    @Autowired
    private Map<Integer, List<String>> stringRowHashMap;

    //Return the String HashMap that Represents the Stage on each Row
    @Autowired
    private Map<Integer, String> stageHashMap;

    //Importing TopLevelQuestions
    @Autowired
    private Map<Integer, TopLevelQuestion> topLevelQuestions;
 
    //Importing LowLevelQuestions
    @Autowired
    private Map<Integer, LowLevelQuestion> lowLevelQuestions;

    //Add Cloud Matrix
    public CloudNativeMaturityMatrix returnCloudMatrix(QuestionSet questionSet){
        return calculateMatrix(questionSet);
    }

    //Create QuestionSet
    public QuestionSet getQuestionSet(){
        return createQuestionSet();
    }

    private QuestionSet createQuestionSet() {
        List<Section> sections = generateSections();

        return new QuestionSet(sections);
    }

    public List<Section> generateSections() {
        Map<Integer, String> promptHashMap = getPromptHashMap();

        List<Section> sectionsList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            TopLevelQuestion topLevelQuestion = topLevelQuestions.get(i);
            LowLevelQuestion lowLevelQuestion = lowLevelQuestions.get(i);
            String stage = stageHashMap.get(i);
            String prompt = promptHashMap.get(i);
            sectionsList.add(new Section(i, topLevelQuestion, lowLevelQuestion, stage, prompt));
        }
        return sectionsList;
    }

    private Map<Integer, String> getPromptHashMap() {
        Map<Integer, String> promptTempMap = new HashMap<>();

        promptTempMap.put(1, "How individuals in your organisation interact, communicate, and work with each other.");
        promptTempMap.put(2, "What you do, and how you go about doing it. How do decisions get made in your organisation about new products to build, or services and features to offer -- or how to improve existing ones?");
        promptTempMap.put(3, "How do responsibilities, communication, and collaboration work between teams in your organisation?");
        promptTempMap.put(4, "How do you plan and then execute work?");
        promptTempMap.put(5, "What is the overall structure of your technology and systems?");
        promptTempMap.put(6, "How does your organisation deploy software and run it in production?");
        promptTempMap.put(7, "How does software progress from your development teams to running live in production?");
        promptTempMap.put(8, "How does your organisation create and then control new infastructure? How quickly can you deploy?");
        promptTempMap.put(9, "Your infastructure describes the physical servers or instances that your production environment consists of: what they are, where they are, and how they are managed.");

        return promptTempMap;
    }

    //Method that returns the Matrix HashMap which contains an ID for each row (Key) and a corresponding Row Data Structure for that Row (Value)
    //The method calculates the location Point given the answers for each Question
    //Given the section ID, we find the corresponding List of Strings for that Row, given the pre-defined StringRowHashMap
    //Creates a Row Implementation with the LocationPoint and Strings calculated
    //Then adds this Row Implementation to the matrix List given the section ID and Row that we have created
    public CloudNativeMaturityMatrix calculateMatrix(QuestionSet questionSet){
        List<Section> sections = questionSet.getSections();
        List<Row> returningMatrix = new ArrayList<>();

        for(Section section: sections){
            List<Boolean> answers = new ArrayList<>();

            for(int i = 0; i<section.getLowLevelQuestion().getqItems().size(); i++){
                answers.add(section.getLowLevelQuestion().getqItems().get(i).getAnswer());
            }

            double locationPoint = verification.verificationProcess(section.getTopLevelQuestion().getqItem().getAnswer(), answers);

            Row row = new RowImpl(locationPoint, stringRowHashMap.get(section.getId()), stageHashMap.get(section.getId()));

            returningMatrix.add(row);
        }

        return new CloudNativeMaturityMatrix(returningMatrix); 
    }

    //Compares to each Common Scenario And Return Which One Matches
    public CommonScenario compareToCommonScenario(CloudNativeMaturityMatrix cloudMatrixEntered) {
        List<Double> locationPointsForThis = new ArrayList<>();
        
        ResponseEntity<CommonScenario[]> commonScenariosArray = RestClient.getCommonScenarios();
        List<CommonScenario> commonScenarios = Arrays.asList(commonScenariosArray.getBody());

        for(int currentRow=0; currentRow<cloudMatrixEntered.getRows().size(); currentRow++){
            locationPointsForThis.add(cloudMatrixEntered.getRow(currentRow).getRowLocationPoint());
        }

        for(int commonScenarioIndex = 0; commonScenarioIndex<commonScenarios.size(); commonScenarioIndex++){
            double[] locationsArray = commonScenarios.get(commonScenarioIndex).getLocationPoints();

            List<Double> locationPointsForCurrentScenario;
            locationPointsForCurrentScenario = DoubleStream.of(locationsArray).boxed().collect(Collectors.toList());

            //If we find one that matches return that common Scenario
            if(locationPointsForCurrentScenario.equals(locationPointsForThis)){
                return commonScenarios.get(commonScenarioIndex);
            }
        }

        //Otherwise return an empty object
        return new CommonScenario("No Common Scenario Found");
    }
}
