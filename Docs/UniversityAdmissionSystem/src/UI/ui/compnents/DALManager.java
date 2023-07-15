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

  
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        
        
        try (
             Connection connection = sql.getConnection()) {
            String query = "SELECT * FROM Students";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int admissionID = resultSet.getInt("admissionID");
                String studentName = resultSet.getString("std_name");
                boolean feeStatus = resultSet.getBoolean("feeStatus");

                Student student = new Student(admissionID, studentName, feeStatus);
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }
    
    
    public List<Student> getUnpaidStudents() {
        // Implement the logic to retrieve unpaid students from the database
        List<Student> unpaidStudents = new ArrayList<>();

        try {
            Connection connection = sql.getConnection();
            
            String query = "SELECT * FROM STUDENTS WHERE feeStatus = 0";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int admissionID = resultSet.getInt("admissionID");
                String studentName = resultSet.getString("std_name");
                boolean feeStatus = resultSet.getBoolean("feeStatus");

                Student student = new Student(admissionID, studentName, feeStatus);
                unpaidStudents.add(student);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return unpaidStudents;
    }
    
    public List<Student> getPaidStudents() {
        // Implement the logic to retrieve paid students from the database
        List<Student> paidStudents = new ArrayList<>();

        try {
            Connection connection = sql.getConnection();;
            String query = "SELECT * FROM STUDENTS WHERE feeStatus = 1";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int admissionID = resultSet.getInt("admissionID");
                String studentName = resultSet.getString("std_name");
                boolean feeStatus = resultSet.getBoolean("feeStatus");

                Student student = new Student(admissionID, studentName, feeStatus);
                paidStudents.add(student);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return paidStudents;
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

   public void saveAnnouncement(String text) {
    try (Connection connection = sql.getConnection()) {
        String query = "INSERT INTO Announcements (text) VALUES (?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, text);
        statement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}



}

