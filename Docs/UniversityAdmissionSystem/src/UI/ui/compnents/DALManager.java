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

/**
 *
 * @author DELL
 */
public class DALManager {
    private IConnection sql;

    public DALManager() {
        this.sql = new SQLConnection("jdbc:sqlserver://localhost:1433;databaseName=University_Admission_System;trustServerCertificate=true;", "sa", "123456");
    }

    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();

        try (Connection connection = sql.getConnection()) {
            String query = "SELECT * FROM Students";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int admissionID = resultSet.getInt("AdmissionID");
                String studentName = resultSet.getString("StudentName");
                boolean feeStatus = resultSet.getBoolean("FeeStatus");

                Student student = new Student(admissionID, studentName, feeStatus);
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
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
            String option1 = resultSet.getString("Option_1");
            String option2 = resultSet.getString("Option_2");
            String option3 = resultSet.getString("Option_3");
            String option4 = resultSet.getString("Option_4");
            String answer = resultSet.getString("answer");

            // Create a new testDTO object and set its properties
            testDTO question = new testDTO();
            question.setId(id);
            question.setDescription(description);
            question.setOption1(option1);
            question.setOption2(option2);
            question.setOption3(option3);
            question.setOption4(option4);
            question.setAnswer(answer);

            // Add the question to the list
            testQuestions.add(question);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return testQuestions;
}


}

