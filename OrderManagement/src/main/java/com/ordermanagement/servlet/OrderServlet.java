package com.ordermanagement.servlet;

import com.ordermanagement.dao.OrderDAO;
import com.ordermanagement.model.Order;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class OrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("🔹 OrderServlet triggered...");

        // ✅ Get product ID
        String productIdStr = request.getParameter("productId");
        if (productIdStr == null || productIdStr.isEmpty()) {
            System.out.println("❌ ERROR: Product ID is missing!");
            response.sendRedirect("order.jsp?error=Invalid product selection. Try again.");
            return;
        }

        int productId;
        try {
            productId = Integer.parseInt(productIdStr);
            System.out.println("✅ Product ID: " + productId);
        } catch (NumberFormatException e) {
            System.out.println("❌ ERROR: Invalid Product ID format!");
            response.sendRedirect("order.jsp?error=Invalid product ID.");
            return;
        }

        // ✅ Get user input for order details
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String city = request.getParameter("city");
        String street = request.getParameter("street");
        String landmark = request.getParameter("landmark");
        String state = request.getParameter("state");
        String pin = request.getParameter("pin");
        String phone = request.getParameter("phone");

        // ✅ Validate form fields
        if (firstName == null || lastName == null || city == null || street == null || state == null || pin == null || phone == null ||
                firstName.isEmpty() || lastName.isEmpty() || city.isEmpty() || street.isEmpty() || state.isEmpty() || pin.isEmpty() || phone.isEmpty()) {
            System.out.println("❌ ERROR: Missing required order details!");
            response.sendRedirect("order.jsp?error=Please fill in all required fields.");
            return;
        }

        System.out.println("✅ Order Details: " + firstName + " " + lastName + ", " + city + ", " + street);

        // ✅ Create Order Object
        Order order = new Order(productId, firstName, lastName, city, street, landmark, state, pin, phone);

        // ✅ Place order in database
        boolean isOrderPlaced = OrderDAO.placeOrder(order);

        if (isOrderPlaced) {
            System.out.println("✅ ORDER SUCCESS: Redirecting to order-confirmation.jsp...");
            response.sendRedirect("order-confirmation.jsp");  // ✅ Redirect to confirmation page
        } else {
            System.out.println("❌ ERROR: Order placement failed!");
            response.sendRedirect("order.jsp?error=Order failed. Try again.");
        }
    }
}

