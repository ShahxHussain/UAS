/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import common.testDTO;
import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class SQLConnection {
    public static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=universityadmissionsystem;trustServerCertificate=true;";
    public static final String USERNAME = "sa";
    public static final String PASSWORD = "123456";
//
public ArrayList<testDTO> getTestQuestions() {
//    Connection dbConnection = objConnection.getConnection();
//    String getRandomQuestionsQuery = "SELECT * FROM Questions ORDER BY RAND() LIMIT " + numQuestions;
//    ResultSet rs = objReader.getRecords(getRandomQuestionsQuery, dbConnection);
//    
    ArrayList<testDTO> randomQuestions = new ArrayList<>();
//    while (rs.next()) {
//        String questionText = rs.getString("QuestionText");
//        String option1 = rs.getString("Option1");
//        String option2 = rs.getString("Option2");
//        // ... Retrieve other question attributes from the result set
//        // Create a Question object and add it to the list
//        Question question = new Question(questionText, option1, option2, /* ... */);
//        randomQuestions.add(question);
//    }
//    
    return randomQuestions;

}


    
    public static void main(String[] args) {
        Connection connection = null;
        try {
          
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("aaaxzxasdxsada " + connection);
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

