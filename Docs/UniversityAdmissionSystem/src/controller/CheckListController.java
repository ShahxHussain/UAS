package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.CheckMeritListModel;

public class CheckListController {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=universityadmissionsystem;trustServerCertificate=true;";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "123456";

    public List<CheckMeritListModel> getMeritList() {
        List<CheckMeritListModel> meritList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String query = "SELECT * FROM merit_list";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int studentID = resultSet.getInt("student_id");
                String studentName = resultSet.getString("student_name");
                String rank = resultSet.getString("rank");

                // Perform validation on the data
                if (studentID > 0 && studentName != null && !studentName.isEmpty() && rank != null && !rank.isEmpty()) {
                    CheckMeritListModel entry = new CheckMeritListModel(studentID, studentName, rank);
                    meritList.add(entry);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return meritList;
    }
        public List<CheckMeritListModel> getWaitingList() {
        // Replace this code with your actual implementation to fetch the waiting list data from the database
        // Here, a dummy list is returned for demonstration purposes
        List<CheckMeritListModel> waitingList = new ArrayList<>();
        waitingList.add(new CheckMeritListModel(01, "King Khan", "WL001"));
        waitingList.add(new CheckMeritListModel(02, "Jane Smith", "WL002"));
        waitingList.add(new CheckMeritListModel(03, "Bob Johnson", "WL003"));
        return waitingList;
    }
}
