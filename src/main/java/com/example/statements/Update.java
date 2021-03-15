package com.example.statements;

import com.example.model.ProductionBrands;
import com.example.util.DatabaseConnection;

import java.sql.*;

public class Update {
    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preStatement;

    static {
        try {
            //get connection to DB
            connection = new DatabaseConnection().getConnection();
            //create a statement
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static int intoProductionBrandsTable(ProductionBrands values) throws SQLException {
        int rowsUpdated = 0;

        return rowsUpdated;
    }
}
