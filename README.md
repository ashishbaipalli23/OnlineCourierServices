# OnlineCourierServices
Online Courier Service – Java Web Application A full-stack web application 
# 🚚 Online Courier Service - Java Maven Web Project
A full-featured Java-based web application designed to streamline the process of booking, tracking, and managing courier deliveries. This project is built using **java**,**JSP**, **Servlets**, **JDBC**, and **MySQL**, and follows the **MVC (Model-View-Controller) architectural pattern** to ensure clean separation of concerns. The application is packaged using **Maven** for efficient dependency management and build automation.

---

## 🔧 Features

🔐 Authentication System — Secure login and registration for customers and delivery agents.

📦 Courier Booking Module — Book couriers with automatic cost and delivery time calculation based on distance.

💳 Payment Integration — Track courier charges with support for different payment methods and a payment history dashboard.

🚚 Delivery Tracking — Real-time updates and delivery status tracking for customers.

🧾 Delivery History — Delivery agents can view a complete history of all completed deliveries.

🌟 Review & Rating System — Customers can submit one-time reviews for delivered orders and view past feedback.

⚙️ Admin Panel — Manage users, staff, and all courier activity centrally.
---

## 🛠️ Technologies Used

- Java (Servlets & JSP)
- JDBC & MySQL
- HTML, CSS,BootStrap5, JavaScript
- Apache Tomcat
- Maven (project build management)
- Eclipse IDE

---

## ⚙️ Project Structure
```
OnlineCourierService/
├── src/
│   ├── main/
│   │   ├── java/                       # Java source code
│   │   │   ├── com.ashi.controllers/   # Servlets handling requests (e.g., LoginServlet, BookCourierServlet)
│   │   │   ├── com.courier.BeansandDAOs/          # Beans and DAO classes for DB operations (e.g., UserDAO, CourierDAO)
│   │   │   └── com.ashi.dbconfig/    #DBconfiguration (JDBC connection)
│   │   └── webapp/
│   │       ├── WEB-INF/
│   │       │   └── web.xml             # Deployment descriptor
│   │       ├── jsp/                    # JSP pages (e.g., login.jsp, bookCourier.jsp, dashboard.jsp)
│   │       └── index.jsp               # Landing/Home page
│
├── pom.xml                             # Maven project configuration file
└── README.md                           # Project overview and instructions
```

---

## 🧪 How to Run

1. Clone the repository :
2. Import the project into Eclipse as a **Maven Project**.

3. Set up a MySQL database and run the SQL scripts located in `resources/sql/`.

4. Update your database credentials in the relevant DBConnection class.

5. Deploy the project on Apache Tomcat server.

6. Visit `http://localhost:8080/OnlineCourierService` in your browser.

---

## 👤 Author

**Ashish**  
Java Developer | Web Application Enthusiast

---


