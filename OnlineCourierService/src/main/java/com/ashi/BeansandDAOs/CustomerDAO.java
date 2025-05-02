package com.ashi.BeansandDAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ashi.dbconfig.DBConnection;
/*
 * +-------------+--------------+------+-----+---------+----------------+
| Field         | Type         | Null | Key | Default | Extra          |
+-------------+--------------+------+-----+---------+----------------+
| customer_id 1 | int          | NO   | PRI | NULL    | auto_increment |
| name        2 | varchar(100) | NO   |     | NULL    |                |
| username   3  | varchar(50)  | NO   | UNI | NULL    |                |
| password   4  | varchar(255) | NO   |     | NULL    |                |
| address    5  | varchar(255) | YES  |     | NULL    |                |
| phone      6  | varchar(15)  | NO   | UNI | NULL    |                |
| email      7  | varchar(100) | YES  | UNI | NULL    |                |
+-------------+--------------+------+-----+---------+----------------+
 * */
public class CustomerDAO {
   
	public int register(CustomerBean cb) {
		int k = 0;
		   try {
			   Connection connection = DBConnection.getConnection();
			   PreparedStatement pStatement = connection.prepareStatement
					   ("INSERT INTO Customer (name, username, password, address, phone, email) VALUES (?, ?, ?, ?, ?, ?)");
			   pStatement.setString(1, cb.getName());
			   pStatement.setString(2, cb.getUsername());
			   pStatement.setString(3, cb.getPassword());
			   pStatement.setString(4, cb.getAddress());
			   pStatement.setString(5, cb.getPhone());
			   pStatement.setString(6, cb.getEmail());
			   
			   k = pStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return k ;
	}
	
	public CustomerBean login(String username,String password) {
		CustomerBean cb = null;
		
		 	try{
		 		Connection connection = DBConnection.getConnection();
		 		PreparedStatement pStatement = connection.prepareStatement
		 				("select * from customer where  username = ? and password = ?");
		 		pStatement.setString(1, username);
		 		pStatement.setString(2, password);
		 		ResultSet res = pStatement.executeQuery();
		 		if(res.next()) {
		 			cb = new CustomerBean();
		 			cb.setCustomer_id(res.getInt(1));
		 			cb.setName(res.getString(2));
		 			cb.setUsername(res.getString(3));
		 			//4th col no required
		 			cb.setAddress(res.getString(5));
		 			cb.setPhone(res.getString(6));
		 			cb.setEmail(res.getString(7));
		 		}
		 	}
		 	catch (Exception e) {
				e.printStackTrace();
			}
		
		
		
		return cb;
	}
	
	public int updateProfile(CustomerBean cb) {
		int k = 0;
		   try {
			   Connection connection = DBConnection.getConnection();
			   PreparedStatement pStatement = connection.prepareStatement
					   ("update customer set name = ?,address =  ?,phone = ? where username = ? and email = ? ");
			   pStatement.setString(1, cb.getName());
			   pStatement.setString(2, cb.getAddress());
			   pStatement.setString(3, cb.getPhone());
			   pStatement.setString(4, cb.getUsername());
			   pStatement.setString(5, cb.getEmail());
			   
			   k = pStatement.executeUpdate();
		   }
		   catch (Exception e) {
			  e.printStackTrace();
		}
		return k;
	}
	
	
	
}
