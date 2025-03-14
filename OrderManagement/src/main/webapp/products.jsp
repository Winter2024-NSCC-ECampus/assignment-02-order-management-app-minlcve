<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.ordermanagement.model.Product" %>

<html>
<head>
    <title>Products</title>
</head>
<body>
    <h2>Available Products</h2>

    <% 
        List<Product> products = (List<Product>) request.getAttribute("products");
        if (products == null || products.isEmpty()) { 
    %>
        <p>No products available.</p>
    <% 
        } else { 
    %>
        <ul>
        <% for (Product product : products) { %>
            <li>
                <strong><%= product.getName() %></strong> - $<%= product.getPrice() %>
                <p><%= product.getDescription() %></p>
                <p>Rating: <%= product.getRating() %> / 5</p>
                <p>Reviews: <%= product.getReviews() %></p>

                <!-- Order Now Button -->
                <form action="order.jsp" method="get">
                    <input type="hidden" name="productId" value="<%= product.getId() %>">
                    <button type="submit">Order Now</button>
                </form>

                <!-- Review/Rate Product Button -->
                <form action="review.jsp" method="get">
                    <input type="hidden" name="productId" value="<%= product.getId() %>">
                    <button type="submit">Review/Rate Product</button>
                </form>
            </li>
        <% } %>
        </ul>
    <% } %>

    <a href="logout.jsp">Logout</a>
</body>
</html>
