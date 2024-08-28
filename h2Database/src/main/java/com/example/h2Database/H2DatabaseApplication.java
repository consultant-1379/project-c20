package com.example.h2Database;

import com.example.h2Database.Repository.CommonScenarioRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class H2DatabaseApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(H2DatabaseApplication.class, args);

		CommonScenarioRepository commonScenarioRepository = configurableApplicationContext.getBean(CommonScenarioRepository.class);

		CommonScenarioBean commonScenarioBean = configurableApplicationContext.getBean(CommonScenarioBean.class);

		commonScenarioBean.calculateCommonScenarios(commonScenarioRepository);
	}
}
