package com.ashi.BeansandDAOs;

import java.io.Serializable;

/**
+-------------+--------------+------+-----+---------+----------------+
| Field       | Type         | Null | Key | Default | Extra          |
+-------------+--------------+------+-----+---------+----------------+
| customer_id | int          | NO   | PRI | NULL    | auto_increment |
| name        | varchar(100) | NO   |     | NULL    |                |
| username    | varchar(50)  | NO   | UNI | NULL    |                |
| password    | varchar(255) | NO   |     | NULL    |                |
| address     | varchar(255) | YES  |     | NULL    |                |
| phone       | varchar(15)  | NO   | UNI | NULL    |                |
| email       | varchar(100) | YES  | UNI | NULL    |                |
+-------------+--------------+------+-----+---------+----------------+
 * */
@SuppressWarnings("serial")
public class CustomerBean implements Serializable {
	 private int customer_id; //auto increment
	    private String name;
	    private String username;
	    private String password;
	    private String address;
	    private String phone;
	    private String email;

	    // Constructors
	    public CustomerBean() {}

	    public CustomerBean(String name, String username, String password, String address, String phone, String email) {
	        this.name = name;
	        this.username = username;
	        this.password = password;
	        this.address = address;
	        this.phone = phone;
	        this.email = email;
	    }

	    // Getters and Setters
	    public int getCustomer_id() {
	        return customer_id;
	    }

	    public void setCustomer_id(int customer_id) {
	        this.customer_id = customer_id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public String getAddress() {
	        return address;
	    }

	    public void setAddress(String address) {
	        this.address = address;
	    }

	    public String getPhone() {
	        return phone;
	    }

	    public void setPhone(String phone) {
	        this.phone = phone;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    // Optional toString() method for debugging
	    @Override
	    public String toString() {
	        return "CustomerBean{" +
	                "customer_id=" + customer_id +
	                ", name='" + name + '\'' +
	                ", username='" + username + '\'' +
	                ", password='" + password + '\'' +
	                ", address='" + address + '\'' +
	                ", phone='" + phone + '\'' +
	                ", email='" + email + '\'' +
	                '}';
	    }
      
}
