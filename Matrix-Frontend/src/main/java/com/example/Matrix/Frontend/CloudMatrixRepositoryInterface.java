package com.example.Matrix.Frontend;

import java.util.List;


public interface CloudMatrixRepositoryInterface {
    void addRow(Row row);
    void removeRow(Row row);
    Row getRow(int index);
    List<Row> getRows();
}
