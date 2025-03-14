package com.ordermanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection conn = null;

 
    public static Connection getConnection() {
        try {
            if (conn == null || conn.isClosed()) { 
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ordermanagement", "root", "Sunoo123!");
                System.out.println("✅ Database Connected Successfully!");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("❌ Database Connection Failed!");
        }
        return conn;
    }
}
