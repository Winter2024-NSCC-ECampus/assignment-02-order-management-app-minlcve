package com.ordermanagement.servlet;

import com.ordermanagement.dao.ProductDAO;
import com.ordermanagement.dao.ReviewDAO;
import com.ordermanagement.model.Review;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class ProductReviewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the product ID and review details from the form
        int productId = Integer.parseInt(request.getParameter("productId"));
        String reviewText = request.getParameter("reviewText");
        int rating = Integer.parseInt(request.getParameter("rating"));
        String userEmail = (String) request.getSession().getAttribute("userEmail");

        // Create a new review object
        Review review = new Review(productId, userEmail, reviewText, rating);

        // Save the review to the database
        boolean reviewAdded = ReviewDAO.addReview(review);

        if (reviewAdded) {
            // Redirect to the product details page to see the updated review
            response.sendRedirect("ProductServlet?productId=" + productId);
        } else {
            response.sendRedirect("productDetails.jsp?error=Failed to submit the review");
        }
    }
}
