package com.example.h2Database.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CommonScenario {
    //Id of CommonScenario
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    //Get LocationPoints of Common Scenario
    private double[] locationPoints;
    
    //Get Title of the Matrix (Common Scenario)
    @Column(columnDefinition = "TEXT")
    private String title; 

    //Get Description of the Matrix (Common Scenario)
    @Column(columnDefinition = "TEXT")
    private String description; 

    //Get Description of the Matrix (Common Scenario)
    @Column(columnDefinition = "TEXT")
    private String problem; 

    //Get Description of the Matrix (Common Scenario)
    @Column(columnDefinition = "TEXT")
    private String solution; 

    public CommonScenario(){
        
    }
    
    //Constructor for Allowing Pre-defined Matrices to be made with a title (For Common Scenarios)
    public CommonScenario(String title, String description, String problem, String solution, double[] locationPoints){
        this.title = title;
        this.description = description;
        this.problem = problem;
        this.solution = solution;
        this.locationPoints = locationPoints;
    }

    //Get Title Of Common Scenario
    public String getTitle(){
        return this.title;
    }

    //Set Title of Common Scenario
    public void setTitle(String title){
        this.title = title;
    }

    //Get Description Of Common Scenario
    public String getDescription(){
        return this.description;
    }

    //Set Description of Common Scenario
    public void setDescription(String description){
        this.description = description;
    }

    //Get Problem Of Common Scenario
    public String getProblem(){
        return this.problem;
    }

    //Set Problem of Common Scenario
    public void setProblem(String problem){
        this.problem = problem;
    }

    //Get Solution Of Common Scenario
    public String getSolution(){
        return this.solution;
    }

    //Set Solution of Common Scenario
    public void setSolution(String solution){
        this.solution = solution;
    }

    //Get Location Points Of Common Scenario
    public double[] getLocationPoints(){
        return this.locationPoints;
    }

    //Set Location Points of Common Scenario
    public void setLocationPoints(double[] locationPoints){
        this.locationPoints = locationPoints;
    }
}

