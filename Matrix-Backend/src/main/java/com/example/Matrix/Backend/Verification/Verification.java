package com.example.Matrix.Backend.Verification;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class Verification implements VerificationInterface {
    //Given the Answers to the Question (Via Boolean Values), return the LocationPoint to where the user is on that row
    @Override
    public double verificationProcess(boolean topLevelAnswer, List<Boolean> lowlevelAnswers){
        int numberOfOddValues = getCountOfAllOddQuestions(lowlevelAnswers);
        int numberOfEvenValues = getCountOfAllEvenQuestions(lowlevelAnswers); 

        //If the topLevelAnswer is true, return 4.0
        if(topLevelAnswer){
            return 4.0;
        }

        //If the answer is True for either 1, 3 or 1 and 3 return 2
        if(numberOfOddValues >= 1 && numberOfEvenValues == 0){
            return 2.0;
        }

        //If the answer is True for either 2, 4 or 2 and 4 return 3
        if(numberOfOddValues == 0 && numberOfEvenValues >= 1){
            return 3.0;
        }

        //If there is a mixture of even and odd numbers return 2.5
        if(numberOfOddValues >= 1 && numberOfEvenValues >= 1){
            return 2.5;
        }

        //If there were no answers given return 2.5
        return 2.5;
    }

    //Gets the Count of All Even Questions
    @Override
    public int getCountOfAllEvenQuestions(List<Boolean> lowlevelAnswers){
        int countOfEvenValues = 0;

        for(int i = 0; i<lowlevelAnswers.size(); i+=2){
            if(lowlevelAnswers.get(i) == true){
                countOfEvenValues++;
            }
        }
    
        return countOfEvenValues;
    }

    //Gets the Count of All True values for Even Indexes in the LowLevelAnswers Array
    @Override
    public int getCountOfAllOddQuestions(List<Boolean> lowlevelAnswers){
        int countOfOddValues = 0;
        
        for(int i = 0; i<lowlevelAnswers.size(); i+=2){
            if(lowlevelAnswers.get(i) == true){
                countOfOddValues++;
            }
        }

        return countOfOddValues;
    }
}
