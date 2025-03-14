<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.ordermanagement.model.Product, com.ordermanagement.model.Review" %>
<html>
<head>
    <title>Product Details</title>
</head>
<body>
    <h2>Product Details</h2>

    <%
        // Fetch product and reviews from request attributes
        Product product = (Product) request.getAttribute("product");
        List<Review> reviews = (List<Review>) request.getAttribute("reviews");
    %>

    <h3><%= product.getName() %></h3>
    <p><strong>Description:</strong> <%= product.getDescription() %></p>
    <p><strong>Price:</strong> $<%= product.getPrice() %></p>
    <p><strong>Category:</strong> <%= product.getCategory() %></p>
    <p><strong>Stock:</strong> <%= product.getStock() %></p>

    <h4>Reviews:</h4>
    <% for (Review review : reviews) { %>
        <p><strong><%= review.getUserEmail() %> (Rating: <%= review.getRating() %>):</strong> <%= review.getReviewText() %></p>
    <% } %>

    <h4>Leave a Review:</h4>
    <form action="ProductReviewServlet" method="post">
        <input type="hidden" name="productId" value="<%= product.getId() %>">
        <textarea name="reviewText" required></textarea><br>
        <label for="rating">Rating:</label>
        <input type="number" name="rating" min="1" max="5" required><br>
        <button type="submit">Submit Review</button>
    </form>

    <a href="products.jsp">Back to Products</a>
</body>
</html>
