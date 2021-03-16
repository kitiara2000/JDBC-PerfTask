package com.example.dao;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface Table {

    public ResultSet selectAll() throws SQLException;
    public ResultSet selectById(int id) throws SQLException;

    public void update() throws SQLException;

    public void delete(int id) throws SQLException;

//    public int insert (T values) throws SQLException;

    public int bulkInsert(File csv) throws SQLException;

    public void printResult(ResultSet result);

}
