package com.ordermanagement.model;

public class Review {
    private int productId;
    private String userEmail;
    private String reviewText;
    private int rating;

    public Review(int productId, String userEmail, String reviewText, int rating) {
        this.productId = productId;
        this.userEmail = userEmail;
        this.reviewText = reviewText;
        this.rating = rating;
    }

    public int getProductId() {
        return productId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getReviewText() {
        return reviewText;
    }

    public int getRating() {
        return rating;
    }
}
