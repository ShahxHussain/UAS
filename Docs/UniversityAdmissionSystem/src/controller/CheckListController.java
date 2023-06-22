package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import common.CheckMeritListDTO;
import controller.CheckMeritListValidator;

public class CheckListController {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=universityadmissionsystem;trustServerCertificate=true;";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "123456";

    public List<CheckMeritListDTO> getMeritList() {
        List<CheckMeritListDTO> meritList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String query = "SELECT * FROM merit_list";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int studentID = resultSet.getInt("student_id");
                String studentName = resultSet.getString("student_name");
                String course = resultSet.getString("course");
                int matricMarks = resultSet.getInt("matric_marks");
                int fscMarks = resultSet.getInt("fsc_marks");
                int testMarks = resultSet.getInt("test_marks");
                double percentage = resultSet.getDouble("percentage");
                String rank = resultSet.getString("rank");

                CheckMeritListDTO dto = new CheckMeritListDTO(studentID, studentName, course, matricMarks, fscMarks, testMarks, percentage, rank);

                if (CheckMeritListValidator.validateCheckMeritListDTO(dto)) {
                    meritList.add(dto);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return meritList;
    }

    public List<CheckMeritListDTO> getWaitingList() {
        List<CheckMeritListDTO> waitingList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String query = "SELECT * FROM waiting_list";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int studentID = resultSet.getInt("student_id");
                String studentName = resultSet.getString("student_name");
                String course = resultSet.getString("course");
                int matricMarks = resultSet.getInt("matric_marks");
                int fscMarks = resultSet.getInt("fsc_marks");
                int testMarks = resultSet.getInt("test_marks");
                double percentage = resultSet.getDouble("percentage");
                String rank = resultSet.getString("rank");

                CheckMeritListDTO dto = new CheckMeritListDTO(studentID, studentName, course, matricMarks, fscMarks, testMarks, percentage, rank);

                if (CheckMeritListValidator.validateCheckMeritListDTO(dto)) {
                    waitingList.add(dto);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return waitingList;
    }
}
