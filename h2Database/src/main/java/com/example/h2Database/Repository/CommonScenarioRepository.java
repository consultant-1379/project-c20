package com.example.h2Database.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.example.h2Database.Model.CommonScenario;

@Component
public interface CommonScenarioRepository extends CrudRepository<CommonScenario, Long> {
    
}
