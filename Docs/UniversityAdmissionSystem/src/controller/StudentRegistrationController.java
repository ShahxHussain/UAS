/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author HP 840 G3
 */
import common.StudentDTO;
import java.sql.*;
import javax.swing.JOptionPane;

public class StudentRegistrationController {
    public void registerStudent(String firstname, String lastname, String email, String phoneno, String address) {
        // Validate name and email
        if (firstname.isEmpty() || lastname.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter all required fields.");
            return;
        }

//        // Validate email format
//        if (!isValidEmail(email)) {
//            JOptionPane.showMessageDialog(null, "Please enter a valid email address.");
//            return;
//        }

        // Create a StudentDTO object and set the data
        StudentDTO objstu = new StudentDTO();
        objstu.Firstname = firstname;
        objstu.Lastname = lastname;
        objstu.Email = email;
        objstu.Phoneno = phoneno;
        objstu.Address = address;
        

        // Database connection and data insertion
        try {
            // Load the SQL Server JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Establish the database connection
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Universityadmissionsystem;trustServerCertificate=true;", "sa", "123456");

            // Create the SQL query to insert the student data
            String query = "INSERT INTO students (firstname, lastname, email, phoneno, address) VALUES (?, ?, ?, ?, ?)";

            // Create a prepared statement to prevent SQL injection
            PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, objstu.Firstname);
            statement.setString(2, objstu.Lastname);
            statement.setString(3, objstu.Email);
            statement.setString(4, objstu.Phoneno);
            statement.setString(5, objstu.Address);

            // Execute the query
            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                // Get the generated keys (if any)
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    // Get the generated 'id' value
                    int id = generatedKeys.getInt(1);

                    // Display a success message with the generated 'id' value
                    JOptionPane.showMessageDialog(null, "Data inserted successfully! Student ID: " + id);
                } else {
                    // Display a success message without the generated 'id' value
                    JOptionPane.showMessageDialog(null, "Data inserted successfully!");
                }
            } else {
                // Display an error message if no rows were affected
                JOptionPane.showMessageDialog(null, "Failed to insert data into the database.");
            }

            // Close the prepared statement and connection
            statement.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException ex) {
            // Handle any errors that may occur
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred while inserting data.");
        }

    }

    private boolean isValidEmail(String email) {
        // Email validation logic
        // You can replace this with a more robust email validation method if needed
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email.matches(emailRegex);
    }
}
