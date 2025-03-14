<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.ordermanagement.model.Product" %>
<%@ page import="com.ordermanagement.dao.ProductDAO" %>

<html>
<head>
    <title>Review Product</title>
</head>
<body>
    <h2>Review Product</h2>

    <% 
        // Get product ID from URL parameter
        String productIdStr = request.getParameter("productId");
        int productId = Integer.parseInt(productIdStr);

        // Fetch product details using product ID
        Product product = ProductDAO.getProductById(productId);
    %>

    <h3><%= product.getName() %></h3>
    <p><%= product.getDescription() %></p>
    <p>Rating: <%= product.getRating() %> / 5</p>
    <p>Reviews: <%= product.getReviews() %></p>

    <form action="submitReview.jsp" method="post">
        <input type="hidden" name="productId" value="<%= productId %>">
        <label for="rating">Rating (1-5):</label>
        <input type="number" name="rating" min="1" max="5" required><br>

        <label for="review">Review:</label><br>
        <textarea name="review" rows="4" cols="50" required></textarea><br>

        <button type="submit">Submit Review</button>
    </form>

    <a href="products.jsp">Back to Products</a>
</body>
</html>
