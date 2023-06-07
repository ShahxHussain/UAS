/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {
    public static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=universityadmissionsystem";
    public static final String USERNAME = "sa";
    public static final String PASSWORD = "12345678";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Register the JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            // Open a connection
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
            // Connection successful, perform database operations here
            
            // Close the connection
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

