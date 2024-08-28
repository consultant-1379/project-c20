package com.example.Matrix.Backend.Matrix.Entity;

import java.util.ArrayList;
import java.util.List;

import com.example.Matrix.Backend.Rows.*;

public class CloudNativeMaturityMatrix {
    //Get the matrix of Rows
    private List<Row> matrix;

    //Constructor to allow for testing of Matrices
    public CloudNativeMaturityMatrix(){
        matrix = new ArrayList<>();
    }

    //Constructor for Allowing Pre-defined Matrices to be made with a title and description (For Common Scenarios)
    public CloudNativeMaturityMatrix(List<Row> rows){
        this.matrix = rows;
    }

    //Get Rows
    public List<Row> getRows(){
        return this.matrix;
    }

    //Get a row from the matrix
    public Row getRow(int index){
        return matrix.get(index);
    }

    //Adding a row
    public void addRow(Row row){
        matrix.add(row);
    }

    //Removing a row
    public void removeRow(Row row){
        matrix.remove(row);
    }
}
