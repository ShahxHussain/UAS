/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI.ui.compnents;

import common.testDTO;
import dal.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.IConnection;
import model.SQLConnection;


public class DALManager {
    private IConnection sql;

  
    public DALManager() {
        this.sql = new SQLConnection("jdbc:sqlserver://localhost:1433;databaseName=universityadmissionsystem;trustServerCertificate=true;", "sa", "123456");
    }
    
    public ArrayList<testDTO> getTestQuestions() {
    ArrayList<testDTO> testQuestions = new ArrayList<>();

    try (Connection connection = sql.getConnection()) {
        String query = "SELECT * FROM TestQuestions";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            // Retrieve the question details from the result set
            String id = resultSet.getString("testid");
            String description = resultSet.getString("test_Description");
            String[] options = {
                resultSet.getString("Option_1"),
                resultSet.getString("Option_2"),
                resultSet.getString("Option_3"),
                resultSet.getString("Option_4")
            };
            String answer = resultSet.getString("answer");

            // Create a new testDTO object and set its properties
            testDTO question = new testDTO(description, options, answer);
            question.setId(id);

            // Add the question to the list
            testQuestions.add(question);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return testQuestions;
}

}

