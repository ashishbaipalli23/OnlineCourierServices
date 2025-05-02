package com.ashi.dbconfig;



import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	private static Connection conn = null;
	
	static {
	    try {
	      //  System.out.println("Loading database driver...");
	        Class.forName(DBInfo.driver);
	        //System.out.println("Driver loaded successfully.");

	      //  System.out.println("Connecting to database...");
	        conn = DriverManager.getConnection(DBInfo.url, DBInfo.userName, DBInfo.password);
	      //  System.out.println("Database connection established successfully.");
	    } catch (Exception e) {
	      //  System.err.println("Error while establishing database connection: " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	
	//Restrict the object creation for this class
	private DBConnection() {
		
	}
	
	
    public static Connection getConnection() {
    	return conn;
    }
    
    
    //closing the connection
    public static void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
         //System.out.println("Database connection closed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
}