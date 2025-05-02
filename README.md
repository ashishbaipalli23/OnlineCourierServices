# OnlineCourierServices
Online Courier Service – Java Web Application A full-stack web application 
# 🚚 Online Courier Service - Java Maven Web Project

A full-stack web application for booking and managing courier deliveries. Built using **Java**, **JSP**, **Servlets**, **JDBC**, and **MySQL** with **Maven** as the build tool, following the **MVC design pattern**.

---

## 🔧 Features

- User registration and login (Customer, Admin, Delivery Agent)
- Courier booking with dynamic cost and delivery date calculation
- Secure payment system with payment history
- Real-time delivery tracking for customers
- Delivery history and performance stats for delivery agents
- Review system (submit and view reviews for completed orders)
- Admin panel for managing users, couriers, and payments

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
OnlineCourierService/
├── src/
│   ├── main/
│   │   ├── java/                       # Java source code
│   │   │   ├── com.ashi.controller/   # Servlets handling requests (e.g., LoginServlet, BookCourierServlet)
│   │   │   ├── com.courier.dao/          # DAO classes for DB operations (e.g., UserDAO, CourierDAO)
│   │   │   └── com.ashi.dbconfig/    #DBconfiguration (JDBC connection)
│   │   └── webapp/
│   │       ├── WEB-INF/
│   │       │   └── web.xml             # Deployment descriptor
│   │       ├── jsp/                    # JSP pages (e.g., login.jsp, bookCourier.jsp, dashboard.jsp)
│   │       └── index.jsp               # Landing/Home page
│
├── pom.xml                             # Maven project configuration file
└── README.md                           # Project overview and instructions


---

## 🧪 How to Run

1. Clone the repository
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


