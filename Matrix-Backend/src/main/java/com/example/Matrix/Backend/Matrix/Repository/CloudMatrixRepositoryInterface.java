package com.example.Matrix.Backend.Matrix.Repository;

import com.example.Matrix.Backend.Matrix.Entity.CloudNativeMaturityMatrix;
import com.example.Matrix.Backend.Matrix.Entity.CommonScenario;
import com.example.Matrix.Backend.QuestionTypes.QuestionSet;

public interface CloudMatrixRepositoryInterface {
    CommonScenario compareToCommonScenario(CloudNativeMaturityMatrix cloudMatrixEntered);
    CloudNativeMaturityMatrix returnCloudMatrix(QuestionSet questionSet);
    QuestionSet getQuestionSet();
}
