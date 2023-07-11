package dal;
import common.PublishDTO;
import common.testDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.IConnection;


public class DALManager {
    private IConnection connectionProvider;

    public DALManager(IConnection connectionProvider) {
        this.connectionProvider = connectionProvider;
    }

    public List<PublishDTO> getAllStudents() {
        List<PublishDTO> students = new ArrayList<>();

        try (Connection connection = connectionProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM Testresult");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                PublishDTO student = new PublishDTO();
                student.setStudentID(resultSet.getInt("studentID"));
                student.setStudentName(resultSet.getString("student_name"));
                student.setTestResult(resultSet.getInt("testresult"));
                student.setPercentage(resultSet.getDouble("percentage"));
                students.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

  
    // Other database operations...

 
public void deleteStudent(PublishDTO student) {
    String query = "DELETE FROM Testresult WHERE studentID = ?";
    try (Connection connection = connectionProvider.getConnection();
         PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setInt(1, student.getStudentID());
        statement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
        // Handle the exception or throw it to the calling code
    }
}

public void updateStudent(PublishDTO student) {
    String query = "UPDATE Testresult SET student_name = ?, testresult = ?, percentage = ? WHERE studentID = ?";
    try (Connection connection = connectionProvider.getConnection();
         PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setString(1, student.getStudentName());
        statement.setInt(2, student.getTestResult());
        statement.setDouble(3, student.getPercentage());
        statement.setInt(4, student.getStudentID());
        statement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
        // Handle the exception or throw it to the calling code
    }
}


    
   public List<Student> getStudents() {
    List<Student> students = new ArrayList<>();

    try {
        Connection connection = connectionProvider.getConnection();
        
        String query = "SELECT * FROM STUDENTS";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            int admissionID = resultSet.getInt("admissionID");
            String studentName = resultSet.getString("std_name");
            boolean feeStatus = resultSet.getBoolean("feeStatus");

            Student student = new Student(admissionID, studentName, feeStatus);
            students.add(student);
        }

        resultSet.close();
        statement.close();
        connection.close();
    } catch (Exception e) {
        e.printStackTrace();
    }

    return students;
   }
   
public List<Student> getUnpaidStudents() {
    List<Student> unpaidStudents = new ArrayList<>();

    try {
        Connection connection = connectionProvider.getConnection();
      
        String query = "SELECT * FROM STUDENTS WHERE feeStatus = 0";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

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
    List<Student> paidStudents = new ArrayList<>();

    try {
        Connection connection = connectionProvider.getConnection();
        
        String query = "SELECT * FROM STUDENTS WHERE feeStatus = 1";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

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
}

