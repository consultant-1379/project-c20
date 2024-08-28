package com.example.Matrix.Backend.Matrix.Service;

import com.example.Matrix.Backend.Matrix.Entity.CloudNativeMaturityMatrix;
import com.example.Matrix.Backend.Matrix.Entity.CommonScenario;
import com.example.Matrix.Backend.QuestionTypes.QuestionSet;

public interface CloudMatrixServiceInterface {
    CommonScenario compareToCommonScenarioFromRepository(CloudNativeMaturityMatrix cloudMatrixEntered);
    CloudNativeMaturityMatrix returnCloudMatrixFromRepository(QuestionSet questionSet);
    QuestionSet getQuestionSetFromRespository();
}
