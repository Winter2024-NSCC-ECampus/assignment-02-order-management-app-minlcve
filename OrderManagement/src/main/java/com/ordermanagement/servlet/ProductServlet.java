package com.ordermanagement.servlet;

import com.ordermanagement.dao.ProductDAO;
import com.ordermanagement.dao.ReviewDAO;
import com.ordermanagement.model.Product;
import com.ordermanagement.model.Review;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        
        if (session == null || session.getAttribute("userEmail") == null) {
            System.out.println("🚨 User is not logged in! Redirecting to login.jsp...");
            response.sendRedirect("login.jsp?error=You must log in first.");
            return;
        }

       
        List<Product> products = ProductDAO.getAllProducts();

        
        if (products == null) {
            System.out.println("❌ ERROR: Products list is NULL!");
            request.setAttribute("errorMessage", "Error fetching products.");
        } else if (products.isEmpty()) {
            System.out.println("❌ No products found in database!");
        } else {
            System.out.println("✅ SUCCESS: " + products.size() + " products fetched.");
        }

        
        request.setAttribute("products", products);

        
        String productIdParam = request.getParameter("productId");
        if (productIdParam != null) {
            try {
                int productId = Integer.parseInt(productIdParam);
                
                Product product = ProductDAO.getProductById(productId);

               
                List<Review> reviews = ReviewDAO.getReviewsByProductId(productId);

                
                request.setAttribute("product", product);
                request.setAttribute("reviews", reviews);

                
                request.getRequestDispatcher("productDetails.jsp").forward(request, response);
                return;
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid product ID: " + productIdParam);
                response.sendRedirect("products.jsp?error=Invalid product selected.");
                return;
            }
        }

        
        request.getRequestDispatcher("products.jsp").forward(request, response);
    }
}

