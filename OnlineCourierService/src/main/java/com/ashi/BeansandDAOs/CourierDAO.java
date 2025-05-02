package com.ashi.BeansandDAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ashi.dbconfig.DBConnection;

/*
mysql> desc courier;
+-------------------+---------------+------+-----+-------------------+-------------------+
| Field             | Type          | Null | Key | Default           | Extra             |
+-------------------+---------------+------+-----+-------------------+-------------------+
| courier_id        | int           | NO   | PRI | NULL              | auto_increment    |
| pickup_location   | varchar(255)  | NO   |     | NULL              |                   |
| destination       | varchar(255)  | NO   |     | NULL              |                   |
| weight            | decimal(10,2) | NO   |     | NULL              |                   |
| type              | varchar(50)   | YES  |     | NULL              |                   |
| cost              | decimal(10,2) | NO   |     | NULL              |                   |
| customer_id       | int           | NO   | MUL | NULL              |                   |
| booking_date      | datetime      | NO   |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
| expected_delivery | datetime      | YES  |     | NULL              |                   |
+-------------------+---------------+------+-----+-------------------+-------------------+*/
public class CourierDAO {

    public int addCourier(CourierBean cb) {
        int result = 0;
        Connection connection = null;
        PreparedStatement pStatement = null;
        ResultSet generatedKeys = null;

        try {
            connection = DBConnection.getConnection();
            
            String query = "INSERT INTO courier (pickup_location, destination, weight, type, cost, booking_date, expected_delivery, customer_id) " +
                           "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            pStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);  // Return generated keys

            pStatement.setString(1, cb.getPickupLocation());
            pStatement.setString(2, cb.getDestination());
            pStatement.setDouble(3, cb.getWeight());
            pStatement.setString(4, cb.getType());
            pStatement.setDouble(5, cb.getCost());
            pStatement.setTimestamp(6, cb.getBooking_date());
            pStatement.setTimestamp(7, cb.getExpected_delivery());
            pStatement.setInt(8, cb.getCustomer_id());

            // Execute the insert query
            result = pStatement.executeUpdate();

            // Retrieve the generated courier_id
            if (result > 0) {
                generatedKeys = pStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    cb.setCourier_id(generatedKeys.getInt(1)); // Set the generated courier_id
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
            
       
        return result;
    }
    
    public int updateCourierDetails(CourierBean cb) {
    //	System.out.println("courier in DAO :"+cb);
        int k  = 0;
        try {
        	Connection con = DBConnection.getConnection();
        
             PreparedStatement ps = con.prepareStatement(
                 "UPDATE courier SET pickup_location = ?, destination = ?, weight = ?, type = ?, booking_date = ?, expected_delivery = ?,cost = ? WHERE courier_id = ?"
             ) ;
            
            ps.setString(1, cb.getPickupLocation());
            ps.setString(2, cb.getDestination());
            ps.setDouble(3, cb.getWeight());
            ps.setString(4, cb.getType());
            ps.setTimestamp(5, cb.getBooking_date());
            ps.setTimestamp(6, cb.getExpected_delivery());
            ps.setDouble(7, cb.getCost());
            ps.setInt(8, cb.getCourier_id());

            k = ps.executeUpdate();
         
        } catch (Exception e) {
            e.printStackTrace();
        }
        return k;
    }

}
