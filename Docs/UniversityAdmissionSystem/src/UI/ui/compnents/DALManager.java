/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI.ui.compnents;

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
        this.sql = new SQLConnection("jdbc:sqlserver://localhost:1433;databaseName=universityadmissionsystem;trustServerCertificate=true;", "sa", "123456");
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
}

