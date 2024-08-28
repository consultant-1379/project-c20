package com.example.Matrix.Frontend;

import java.util.List;

//Row Interface defines the method to which each Row has to Implement
public interface RowInterface {
    List<String> getRowStringList();
    List<Double> getRowPointsList();
    Double getRowLocationPoint();
    String getStage();
    void setStage(String stage);
    void setRowStringList(List<String> stringList);
    void setRowPointsList(List<Double> pointList);
    void setRowLocationPoint(Double locationPoint);
}
