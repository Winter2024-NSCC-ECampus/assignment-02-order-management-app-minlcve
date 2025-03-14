package com.ordermanagement.dao;

import com.ordermanagement.model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public static List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();
        String query = "SELECT * FROM products";  // Fetch all products

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));  // Description
                product.setReviews(rs.getString("reviews"));  // Reviews
                product.setRating(rs.getInt("rating"));  // Rating
                product.setPrice(rs.getDouble("price"));
                product.setCategory(rs.getString("category"));
                product.setStock(rs.getInt("stock"));

                
                System.out.println("🔹 Loaded Product: " + product.getName() + " | $" + product.getPrice());

                productList.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        if (productList.isEmpty()) {
            System.out.println("❌ No products found in database!");
        } else {
            System.out.println("✅ SUCCESS: " + productList.size() + " products fetched.");
        }

        return productList;
    }

    
    public static Product getProductById(int productId) {
        Product product = null;
        String query = "SELECT * FROM products WHERE id = ?";  

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, productId);  
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                
                product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));  // Description
                product.setReviews(rs.getString("reviews"));  // Reviews
                product.setRating(rs.getInt("rating"));  // Rating
                product.setPrice(rs.getDouble("price"));
                product.setCategory(rs.getString("category"));
                product.setStock(rs.getInt("stock"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }

    
    public static void main(String[] args) {
        List<Product> products = getAllProducts();
        if (products.isEmpty()) {
            System.out.println("❌ No products found in database!");
        } else {
            for (Product p : products) {
                System.out.println("🔹 " + p.getName() + " - $" + p.getPrice() + " | Reviews: " + p.getReviews() + " | Rating: " + p.getRating());
            }
        }
    }
}
