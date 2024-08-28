package com.example.Matrix.Backend.Rows;

import java.util.Map;

//Row Interface defines the method to which each Row has to Implement
public interface RowInterface {
    String getStage();
    void setStage(String stage);
    Double getRowLocationPoint();
    void setRowLocationPoint(Double locationPoint);
    Map<Double, String> getPointsToStringMap();
    void setPointsToStringMap(Map<Double, String> pointsToStringMap);
}
