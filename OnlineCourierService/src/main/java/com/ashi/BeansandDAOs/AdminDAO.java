package com.ashi.BeansandDAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ashi.dbconfig.DBConnection;

/*mysql> desc admin;
+----------+--------------+------+-----+---------------------+-------------------+
| Field    | Type         | Null | Key | Default             | Extra             |
+----------+--------------+------+-----+---------------------+-------------------+
| admin_id | int          | NO   | PRI | NULL                | auto_increment    |
| username | varchar(50)  | NO   | UNI | NULL                |                   |
| password | varchar(255) | NO   |     | NULL                |                   |
| role     | varchar(50)  | NO   |     | _utf8mb4\'Manager\' | DEFAULT_GENERATED |
| email    | varchar(50)  | YES  | UNI | NULL                |                   |
+----------+--------------+------+-----+---------------------+-------------------+
*/
public class AdminDAO {

	public AdminBean login(String username,String password) {
	     AdminBean admin = null;
		   try {
			   Connection connection = DBConnection.getConnection();
			   PreparedStatement pStatement = connection.prepareStatement("select * from admin where username = ? and password = ?");
			   pStatement.setString(2, password);
			   pStatement.setString(1, username);
			   ResultSet res = pStatement.executeQuery();
			   if(res.next()) {
				   admin = new AdminBean();
				   admin.setAdminId(res.getInt("admin_id"));
				   admin.setPassword(res.getString("password"));
				   admin.setRole(res.getString("role"));
				   admin.setEmail(res.getString("email"));
				   admin.setUsername(res.getString("username"));
			   }
		   }
		   catch (Exception e) {
			  e.printStackTrace();
		}
		
		return admin;
		
	}
	
	public int passwordChange(String password){
		
	    int k = 0;
	      try {
			
	    	  Connection connection = DBConnection.getConnection();
	    	  PreparedStatement pStatement = connection.prepareStatement("update admin set password = ?");
	    	  pStatement.setString(1,password);
	    	  k = pStatement.executeUpdate();
	    	  
	    	  
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	    return k;
	    
		
	}
	
}
