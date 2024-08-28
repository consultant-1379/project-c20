package com.example.Matrix.Frontend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.stereotype.Component;

public class Row implements RowInterface {
    //Constructor which passes in the locationPoint and a List of Strings
    private Double locationPoint;
    private List<String> rowStringPoints;
    private List<Double> rowPoints;
    private String stage;
    private Map<Double, String> hashMapOfPoints;
    private double maxInRowPoints;
    private double minInRowPoints;
    

    public Row() {

    }

    //Constructor which passes in the locationPoint and a List of Strings
    public Row(Double locationPoint, List<String> rowStringPoints, String stage){
        this.locationPoint = locationPoint;
        this.rowStringPoints = rowStringPoints;
        this.stage = stage;
        rowPoints = new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));
        this.hashMapOfPoints = getHashMapOfPoints();
    }

    // This method returns a HashMap of what String is available at what point within the row
    public Map<Double, String> getHashMapOfPoints(){
        HashMap<Double, String> rowStringtoPointsHashMap = new HashMap<>();

        for(int i = 0; i<rowPoints.size(); i++){
            rowStringtoPointsHashMap.put(rowPoints.get(i), rowStringPoints.get(i));
        }

        return rowStringtoPointsHashMap;
    }

    @JsonProperty("hashMapOfPoints")
    public void setHashMapOfPoints(Map<Double, String> hashMapOfPoints) {
        this.hashMapOfPoints = hashMapOfPoints;
    }

    @JsonProperty("maxInRowPoints")
    public void setMaxInRowPoints(double maxInRowPoints) {
        this.maxInRowPoints = maxInRowPoints;
    }


    @JsonProperty("minInRowPoints")
    public void setMinInRowPoints(double minInRowPoints) {
        this.minInRowPoints = minInRowPoints;
    }

    //Get Maximum Value in Collection
    @JsonProperty("maxInRowPoints")
    public Double getMaxInRowPoints(){
        return maxInRowPoints;
    }

    //Get Minimum Value in Collection
    @JsonProperty("minInRowPoints")
    public Double getMinInRowPoints(){
        return minInRowPoints;
    }

    //Returns the List of String for Each Point of the row
    @Override
    @JsonProperty("rowStringPoints")
    public List<String> getRowStringList() {
        return rowStringPoints;
    }

    //Returns the Points on the row
    @Override
    @JsonProperty("rowPointsList")
    public List<Double> getRowPointsList() {
        return rowPoints;
    }

    //Returns the locationPoint on the row
    @Override
    @JsonProperty("locationPoint")
    public Double getRowLocationPoint() {
        return this.locationPoint;
    }

    //Returns the Stage of the row
    @Override
    @JsonProperty("stage")
    public String getStage() {
        return this.stage;
    }

    //Returns the Stage of the row
    @Override
    @JsonProperty("stage")
    public void setStage(String stage) {
        this.stage = stage;
    }

    //Set the List of String for Each Point of the row
    @Override
    @JsonProperty("rowStringList")
    public void setRowStringList(List<String> rowStringPoints) {
        this.rowStringPoints = rowStringPoints;
    }

    //Set the List of Points of the row
    @Override
    @JsonProperty("rowPointsList")
    public void setRowPointsList(List<Double> rowPoints) {
        this.rowPoints = rowPoints;
    }

    //Set the LocationPoint on the row
    @Override
    @JsonProperty("locationPoint")
    public void setRowLocationPoint(Double locationPoint) {
        this.locationPoint = locationPoint;
    }
}
