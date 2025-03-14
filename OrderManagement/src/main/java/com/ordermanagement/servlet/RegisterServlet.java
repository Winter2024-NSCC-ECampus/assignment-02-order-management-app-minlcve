package com.ordermanagement.servlet;

import com.ordermanagement.dao.UserDAO;
import com.ordermanagement.model.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        
        System.out.println("🔹 RegisterServlet: Received Data - Name: " + name + ", Email: " + email);

        
        if (name == null || email == null || password == null || name.trim().isEmpty() || email.trim().isEmpty() || password.trim().isEmpty()) {
            System.out.println("❌ Error: One or more fields are empty!");
            response.sendRedirect("register.jsp?error=Please fill in all fields.");
            return;
        }

        User user = new User(name, email, password);
        boolean isRegistered = UserDAO.registerUser(user);

        if (isRegistered) {
            System.out.println("✅ Registration successful! Redirecting to login.jsp...");
            response.sendRedirect("login.jsp");
        } else {
            System.out.println("❌ Registration failed. Database error or user already exists.");
            response.sendRedirect("register.jsp?error=Registration failed. Try again.");
        }
    }
}

