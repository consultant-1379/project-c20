package com.example.Matrix.Frontend;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

//Maturity Matrix that is Returned to the User
@Repository
public class CloudNativeMaturityMatrix implements CloudMatrixRepositoryInterface {


   //Get the matrix of Rows
   private List<Row> rows;

    //Constructor to allow for testing of Matrices
    public CloudNativeMaturityMatrix(){
        rows = new ArrayList<>();
    }

    //Constructor for Allowing Pre-defined Matrices to be made with a title and description (For Common Scenarios)
    public CloudNativeMaturityMatrix(List<Row> rows){
        this.rows = rows;
    }

    @JsonProperty("rows")
    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

    //Get Rows
    @Override
    @JsonProperty("rows")
    public List<Row> getRows(){
        return this.rows;
    }

    //Get a row from the matrix
    @Override
    public Row getRow(int index){
        return rows.get(index);
    }

    //Adding a row
    @Override
    public void addRow(Row row){
        rows.add(row);
    }

    //Removing a row
    @Override
    public void removeRow(Row row){
        rows.remove(row);
    }

}
