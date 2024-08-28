package com.example.Matrix.Backend.Rows;
import java.util.List;

//Row Data Structure

//Contains a LocationPoint that was found given the answers to the Questions, which will be the point which the line will go through for this row
//Contains a List of Row Points within the Row that will allow the String for each Point to be displayed
public class RowImpl extends Row {
    //Constructor which passes in the locationPoint, List of Strings and a Stage
    public RowImpl(Double locationPoint, List<String> rowStringPoints, String stage){
        super(locationPoint, rowStringPoints, stage);
    }
}
