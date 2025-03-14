<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Register</title>
    <script>
        function redirectToLogin() {
            setTimeout(function() {
                window.location.href = "login.jsp";
            }, 2000);  // Redirect after 2 seconds
        }
    </script>
</head>
<body>
    <h2>Register</h2>

    <% 
        String error = request.getParameter("error");
        String success = request.getParameter("success"); 
    %>

    <% if (error != null) { %>
        <p style="color:red;"><%= error %></p>
    <% } else if (success != null) { %>
        <p style="color:green;"><%= success %></p>
        <script> redirectToLogin(); </script>
    <% } %>

    <form action="RegisterServlet" method="post">
        <label>Full Name:</label>
        <input type="text" name="name" required><br>

        <label>Email:</label>
        <input type="text" name="email" required><br>

        <label>Password:</label>
        <input type="password" name="password" required><br>

        <button type="submit">Register</button>
    </form>
</body>
</html>
