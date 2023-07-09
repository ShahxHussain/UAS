package dal;
import common.PublishDTO;
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

    public void saveStudent(PublishDTO student) {
        try (Connection connection = connectionProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO Testresult (studentID, student_name, testresult, percentage) VALUES (?, ?, ?, ?)")) {

            statement.setInt(1, student.getStudentID());
            statement.setString(2, student.getStudentName());
            statement.setInt(3, student.getTestResult());
            statement.setDouble(4, student.getPercentage());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Other database operations...

    public void deleteStudent(int studentID) {
        try (Connection connection = connectionProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM Testresult WHERE studentID = ?")) {

            statement.setInt(1, studentID);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ...
}
