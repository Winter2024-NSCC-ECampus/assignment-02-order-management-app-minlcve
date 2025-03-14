package com.ordermanagement.dao;

import com.ordermanagement.model.Review;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAO {

    public static boolean addReview(Review review) {
        String query = "INSERT INTO product_reviews (product_id, user_email, review_text, rating) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, review.getProductId());
            stmt.setString(2, review.getUserEmail());
            stmt.setString(3, review.getReviewText());
            stmt.setInt(4, review.getRating());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static List<Review> getReviewsByProductId(int productId) {
        List<Review> reviews = new ArrayList<>();
        String query = "SELECT * FROM product_reviews WHERE product_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, productId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Review review = new Review(
                    rs.getInt("product_id"),
                    rs.getString("user_email"),
                    rs.getString("review_text"),
                    rs.getInt("rating")
                );
                reviews.add(review);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reviews;
    }
}
