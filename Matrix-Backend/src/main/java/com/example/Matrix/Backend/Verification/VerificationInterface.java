package com.example.Matrix.Backend.Verification;

import java.util.List;

public interface VerificationInterface {
    double verificationProcess(boolean topLevelAnswer, List<Boolean> lowlevelAnswer);
    int getCountOfAllEvenQuestions(List<Boolean> lowlevelAnswers);
    int getCountOfAllOddQuestions(List<Boolean> lowlevelAnswers);
}
