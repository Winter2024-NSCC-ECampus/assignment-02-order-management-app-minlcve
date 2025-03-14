package com.ordermanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.ordermanagement.model.User;

public class UserDAO {

    public static boolean registerUser(User user) {
        String query = "INSERT INTO users (first_name, last_name, email, password) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            
            if (conn == null) {
                System.out.println("❌ Database connection is NULL. Check DB setup.");
                return false;
            }

            // ✅ Splitting full name into first and last name
            String[] nameParts = user.getName().split(" ", 2);
            String firstName = nameParts.length > 0 ? nameParts[0] : "";
            String lastName = nameParts.length > 1 ? nameParts[1] : "";

            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPassword());

            int rowsAffected = stmt.executeUpdate();
            System.out.println("✅ User registered in database: " + rowsAffected);
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();  
        }
        return false;
    }

    
    public static boolean validateUser(String email, String password) {
        String query = "SELECT * FROM users WHERE email = ? AND password = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            return rs.next();  
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
