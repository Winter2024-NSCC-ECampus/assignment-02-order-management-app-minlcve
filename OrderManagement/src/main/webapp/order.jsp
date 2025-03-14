<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Place Order</title>
</head>
<body>
    <h2>Place Your Order</h2>

    <% 
        String productId = request.getParameter("productId"); 
        if (productId == null || productId.isEmpty()) { 
    %>
        <p style="color: red;">❌ ERROR: Invalid product selection.</p>
        <a href="products.jsp">Back to Products</a>
    <% 
        return; 
        } 
    %>

    <form action="OrderServlet" method="post">
        <input type="hidden" name="productId" value="<%= productId %>">

        <label>First Name:</label>
        <input type="text" name="firstName" required><br>

        <label>Last Name:</label>
        <input type="text" name="lastName" required><br>

        <label>City:</label>
        <input type="text" name="city" required><br>

        <label>Street:</label>
        <input type="text" name="street" required><br>

        <label>Landmark:</label>
        <input type="text" name="landmark"><br>

        <label>State:</label>
        <input type="text" name="state" required><br>

        <label>Pin Code:</label>
        <input type="text" name="pin" required><br>

        <label>Phone Number:</label>
        <input type="text" name="phone" required><br>

        <button type="submit">Place Order</button>
    </form>

    <p><a href="products.jsp">Back to Products</a></p>
</body>
</html>

