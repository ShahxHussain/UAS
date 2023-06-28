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

//    public ArrayList<StudentDTO> getStudents() {
//        ArrayList<StudentDTO> students = new ArrayList<>();
//        Connection connection = null;
//        Statement statement = null;
//        ResultSet resultSet = null;
//
//        try {
//            connection = getConnection();
//            statement = connection.createStatement();
//            resultSet = (model.ResultSet) statement.executeQuery("SELECT * FROM Students");
//
//            while (resultSet.next()) {
//                String studentName = resultSet.getString("StudentName");
//                String personalDetails = resultSet.getString("PersonalDetails");
//                boolean academicDocuments = resultSet.getBoolean("AcademicDocuments");
//                boolean feeStatus = resultSet.getBoolean("FeeStatus");
//
//                StudentDTO student = new StudentDTO(studentName, personalDetails, academicDocuments, feeStatus);
//                students.add(student);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            // Close resources in the reverse order of their creation
//            if (resultSet != null) {
//                resultSet.close();
//            }
//            if (statement != null) {
//                try {
//                    statement.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//        return students;
//    }

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
