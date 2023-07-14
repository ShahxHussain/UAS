package model;

import common.StudentDTO;

import java.sql.*;
import java.util.ArrayList;

public class SQLConnection implements IConnection {
    public String URL;
    public String USERNAME;
    public String PASSWORD;

    
    public SQLConnection(String URL, String USERNAME, String PASSWORD) {
        this.URL = URL;
        this.USERNAME = USERNAME;
        this.PASSWORD = PASSWORD;
    }

    @Override
    public Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
