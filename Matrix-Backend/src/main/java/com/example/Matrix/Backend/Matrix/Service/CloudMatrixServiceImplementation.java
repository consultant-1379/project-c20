package com.example.Matrix.Backend.Matrix.Service;

import com.example.Matrix.Backend.Matrix.Entity.CloudNativeMaturityMatrix;
import com.example.Matrix.Backend.Matrix.Entity.CommonScenario;
import com.example.Matrix.Backend.Matrix.Repository.CloudMatrixRepositoryInterface;
import com.example.Matrix.Backend.QuestionTypes.QuestionSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CloudMatrixServiceImplementation implements CloudMatrixServiceInterface {
    @Autowired
    private CloudMatrixRepositoryInterface cloudRepository;

    @Override
    public CloudNativeMaturityMatrix returnCloudMatrixFromRepository(QuestionSet questionSet) {
        return cloudRepository.returnCloudMatrix(questionSet);
    }

    @Override
    public CommonScenario compareToCommonScenarioFromRepository(CloudNativeMaturityMatrix cloudNativeMaturityMatrix) {
        return cloudRepository.compareToCommonScenario(cloudNativeMaturityMatrix);
    }

    @Override
    public QuestionSet getQuestionSetFromRespository() {
        return cloudRepository.getQuestionSet();
    }
}
