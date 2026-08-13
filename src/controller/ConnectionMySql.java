package controller;

import java.sql.Connection;
import java.sql.*;

public class ConnectionMySql {
    public Connection getConnection(){
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/projetoCRUD","root","");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
