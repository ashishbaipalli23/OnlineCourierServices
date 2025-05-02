package com.ashi.BeansandDAOs;
/*
 * mysql> desc admin;
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
import java.io.Serializable;


@SuppressWarnings("serial")
public class AdminBean implements Serializable{
	
	private int adminId;//PK
	private String username;
	private String password;
	private String role;//default = 'Manager'
	private String email;
	
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "AdminBean [adminId=" + adminId + ", username=" + username + ", password=" + password + ", role=" + role
				+ "]";
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
}
