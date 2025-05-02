package com.ashi.dbconfig;


//Mysql 
public interface DBInfo {

  String driver = "com.mysql.cj.jdbc.Driver";
  String url = "jdbc:mysql://localhost:3306/OnlineCouriesServices";
  String userName = "ashish";
  String password = "developer";

}

//oracle
//public interface DBInfo {
//
//	String driver = "oracle.jdbc.driver.OracleDriver";
//	String url = "jdbc:oracle:thin:@localhost:1521:xe";
//	String userName = "ashishjdbc";
//	String password = "developerjdbc";
//	
//}

