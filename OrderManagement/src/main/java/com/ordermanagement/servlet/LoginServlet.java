package com.ordermanagement.servlet;

import com.ordermanagement.dao.UserDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (UserDAO.validateUser(email, password)) {
            // ✅ Create session for logged-in user
            HttpSession session = request.getSession();
            session.setAttribute("userEmail", email);
            System.out.println("✅ LOGIN SUCCESS: Redirecting to ProductServlet...");

            // ✅ Redirect to ProductServlet (which loads products before showing products.jsp)
            response.sendRedirect("ProductServlet");
        } else {
            // ❌ Redirect back to login page with error
            System.out.println("❌ LOGIN FAILED: Invalid credentials!");
            response.sendRedirect("login.jsp?error=Invalid credentials. Try again.");
        }
    }
}

