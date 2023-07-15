//package dal;
//
//import model.UserModel;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class UserDAL {
//    private Connection con;
//
//    public UserDAL() {
//        try {
//            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=universityadmissionsystem;trustServerCertificate=true;", "sa", "soman5050");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public boolean authenticate(UserModel user) {
//        String sql = "SELECT * FROM Users WHERE email = ? AND password = ?";
//
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setString(1, user.getEmail());
//            ps.setString(2, user.getPassword());
//
//            ResultSet rs = ps.executeQuery();
//
//            return rs.next();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        // No such user exists
//        return false;
//    }
//
//    public boolean addUser(UserModel user) {
//        String sql = "INSERT INTO Users (email, password) VALUES (?, ?)";
//
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setString(1, user.getEmail());
//            ps.setString(2, user.getPassword());
//
//            int rowsAffected = ps.executeUpdate();
//
//            // If one row is affected, the user was successfully added
//            return rowsAffected == 1;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        // User addition failed
//        return false;
//    }
//}

package dal;

import model.UserModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAL {
    private Connection con;

    public UserDAL() {
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=universityadmissionsystem;trustServerCertificate=true;", "sa", "soman5050");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean authenticate(UserModel user) {
        String sql = "SELECT * FROM Users WHERE email = ? AND password = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());

            ResultSet rs = ps.executeQuery();

            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // No such user exists
        return false;
    }

    public boolean addUser(UserModel user) {
        String sql = "INSERT INTO Users (email, password) VALUES (?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());

            int rowsAffected = ps.executeUpdate();

            // If one row is affected, the user was successfully added
            return rowsAffected == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // User addition failed
        return false;
    }
}
