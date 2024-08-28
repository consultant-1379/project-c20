package com.example.Matrix.Backend.Rows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Row implements RowInterface {
    //Constructor which passes in the locationPoint and a List of Strings
    private Double locationPoint;
    private Map<Double, String> pointsToStringMap;
    private List<String> rowStringPoints;
    private String stage;

    //Constructor which passes in the locationPoint and a List of Strings
    public Row(Double locationPoint, List<String> rowStringPoints, String stage){
        this.locationPoint = locationPoint;
        this.stage = stage;
        this.rowStringPoints = rowStringPoints;
        List<Double> rowPoints = new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));

        this.pointsToStringMap = getHashMapOfPoints(rowPoints, rowStringPoints);
    }

    //This method returns a HashMap of what String is available at what point within the row
    public Map<Double, String> getHashMapOfPoints(List<Double> rowPoints, List<String> rowStringPoints){
        HashMap<Double, String> rowStringtoPointsHashMap = new HashMap<>();

        for(int i = 0; i<rowPoints.size(); i++){
            rowStringtoPointsHashMap.put(rowPoints.get(i), rowStringPoints.get(i));
        }

        return rowStringtoPointsHashMap;
    }

    //Returns Map of Points to Strings on the row
    public Map<Double, String> getPointsToStringMap(){
        return pointsToStringMap;
    }

    //Returns List String for Row to Strings on the row
    public List<String> getStringForRow(){
        return rowStringPoints;
    }

    //Sets List String for Row to Strings on the row
    public void setStringForRow(List<String> rowStringPoints){
        this.rowStringPoints = rowStringPoints;
    }

    //Setting Points to String Map
    public void setPointsToStringMap(Map<Double, String> pointsToStringMap){
        this.pointsToStringMap = pointsToStringMap;
    }

    //Returns the locationPoint on the row
    @Override
    public Double getRowLocationPoint() {
        return this.locationPoint;
    }

    //Returns the Stage of the row
    @Override
    public String getStage() {
        return this.stage;
    }

    //Returns the Stage of the row
    @Override
    public void setStage(String stage) {
        this.stage = stage;
    }

    //Set the LocationPoint on the row
    @Override
    public void setRowLocationPoint(Double locationPoint) {
        this.locationPoint = locationPoint;
    }
}
