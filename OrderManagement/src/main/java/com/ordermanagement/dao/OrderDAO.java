package com.ordermanagement.dao;

import com.ordermanagement.model.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class OrderDAO {

    public static boolean placeOrder(Order order) {
        String query = "INSERT INTO orders (product_id, first_name, last_name, city, street, landmark, state, pin, phone) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, order.getProductId());
            stmt.setString(2, order.getFirstName());
            stmt.setString(3, order.getLastName());
            stmt.setString(4, order.getCity());
            stmt.setString(5, order.getStreet());
            stmt.setString(6, order.getLandmark());
            stmt.setString(7, order.getState());
            stmt.setString(8, order.getPin());
            stmt.setString(9, order.getPhone());

            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
