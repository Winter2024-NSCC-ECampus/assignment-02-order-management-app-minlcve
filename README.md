# Order Management System

This is an Order Management System built using Java (JSP, Servlets), MySQL, and Apache Tomcat. The system allows users to register, log in, view products with descriptions, ratings, and reviews, place orders, and view order confirmation.

## Features

- User Authentication (Login/Registration)
- View Products with Descriptions, Reviews, and Ratings
- Place Orders for Products
- Order Confirmation Page
- Logout functionality

## Technologies Used

- **Java**: JSP, Servlets
- **MySQL**: Database
- **Apache Tomcat**: Web Server
- **JDBC**: Database Connectivity
- **HTML/CSS**: Frontend

## Getting Started

### Prerequisites

Before running this application, ensure you have the following installed:

- **Java** (version 8 or higher)
- **MySQL** (for database management)
- **Apache Tomcat** (as the web server)
- **IDE**: Eclipse, IntelliJ, or any Java IDE of your choice.

### Database Setup

1. **Create a database** in MySQL named `order_management`.
2. **Import the schema** from `schema.sql` to create the necessary tables:
    - `users` (for user authentication)
    - `products` (for product details, reviews, and ratings)
    - `orders` (for storing customer orders)
   
   Example schema for `products` table:

   ```sql
   CREATE TABLE products (
       id INT AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(255),
       description TEXT,
       reviews TEXT,
       price DOUBLE,
       category VARCHAR(255),
       stock INT
   );
   
Set up the DBConnection class for your MySQL database credentials (username, password, URL)

**Running the Project**
1. Clone the repository:
git clone https://github.com/yourusername/OrderManagement.git

2. Import the project into your preferred IDE (Eclipse, IntelliJ, etc.).

3. Make sure Apache Tomcat is configured and running.

4. Set up the MySQL database connection by editing the DBConnection.java class to include your database credentials.

5. Run the project in your IDE by starting the Tomcat server.

**How to Use**
1. Login: Use the login page to log in with an existing user.
2. Browse Products: After logging in, view available products with descriptions, reviews, and ratings.
3. Place an Order: Select a product, fill out your order details, and place the order.
4. Order Confirmation: Once your order is placed, you'll see a confirmation page.
5. Logout: Log out using the logout button.

**Example Flow**
Login → View Products → Select Product → Place Order → Order Confirmation


