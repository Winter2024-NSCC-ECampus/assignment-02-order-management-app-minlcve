package com.ordermanagement.model;

public class Product {
    private int id;
    private String name;
    private String description;
    private double price;
    private String category;
    private int stock;
    private String reviews;  // Added reviews field
    private int rating;  // Added rating field

    
    public Product() {}

   
    public Product(int id, String name, String description, double price, String category, int stock, String reviews, int rating) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.stock = stock;
        this.reviews = reviews;
        this.rating = rating;
    }

    // ✅ Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public String getReviews() { return reviews; }  // Getter for reviews
    public void setReviews(String reviews) { this.reviews = reviews; }  // Setter for reviews

    public int getRating() { return rating; }  // Getter for rating
    public void setRating(int rating) { this.rating = rating; }  // Setter for rating
}
