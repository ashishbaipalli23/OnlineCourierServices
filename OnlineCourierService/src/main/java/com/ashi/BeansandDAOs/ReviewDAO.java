package com.ashi.BeansandDAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ashi.dbconfig.DBConnection;

public class ReviewDAO {

	public boolean insertReview(int orderId, int customerId, int staffId, int rating, String comments) {
        boolean success = false;
        String query = "INSERT INTO review (customer_id, order_id, staff_id, rating, comments, review_date) " +
                       "SELECT ?, ?, ?, ?, ?, CURDATE() FROM dual " +
                       "WHERE NOT EXISTS (SELECT 1 FROM review WHERE order_id = ?)";

        try {
        	Connection conn = DBConnection.getConnection();
        
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setInt(1, customerId);
            ps.setInt(2, orderId);
            ps.setInt(3, staffId);
            ps.setInt(4, rating);
            ps.setString(5, comments);
            ps.setInt(6, orderId);
            
            
            success = ps.executeUpdate() > 0;
            
            
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }

	
	
	public int getStaffIdByOrderId(int orderId) {
        int staffId = 0;
        String query = "SELECT delivery_staff_id FROM orders WHERE order_id = ?";
        try {
        	Connection conn = DBConnection.getConnection();
        
            PreparedStatement ps = conn.prepareStatement(query); 
            ps.setInt(1, orderId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                staffId = rs.getInt("delivery_staff_id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return staffId;
    }
	
	
	
	 public  List<ReviewBean> getReviewsByCustomerId(int customerId) {
	        List<ReviewBean> reviews = new ArrayList<>();
	      
	         
	         

	        try {
	        	Connection con = DBConnection.getConnection();
	        	PreparedStatement ps = con.prepareStatement("SELECT * FROM review WHERE customer_id = ?");
	            ps.setInt(1, customerId);
	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	                ReviewBean bean = new ReviewBean();
	                bean.setReviewId(rs.getInt("review_id"));
	                bean.setCustomerId(rs.getInt("customer_id"));
	                bean.setOrderId(rs.getInt("order_id"));
	                bean.setStaffId(rs.getInt("staff_id"));
	                bean.setRating(rs.getInt("rating"));
	                bean.setComments(rs.getString("comments"));
	                bean.setReviewDate(rs.getTimestamp("review_date"));
	                reviews.add(bean);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        } 

	        return reviews;
	    }
	
	
	
	 
	 public List<ReviewBean> getReviewsByStaffId(int staffId) {
	        List<ReviewBean> reviews = new ArrayList<>();

	        String query = "SELECT review_id, customer_id, order_id, staff_id, rating, comments, review_date "
	                     + "FROM review WHERE staff_id = ?";

	        try {
	        	Connection con = DBConnection.getConnection();
	        
	             PreparedStatement ps = con.prepareStatement(query);
	             

	            ps.setInt(1, staffId);
	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	                ReviewBean rb = new ReviewBean();
	                rb.setReviewId(rs.getInt("review_id"));
	                rb.setCustomerId(rs.getInt("customer_id"));
	                rb.setOrderId(rs.getInt("order_id"));
	                rb.setStaffId(rs.getInt("staff_id"));
	                rb.setRating(rs.getInt("rating"));
	                rb.setComments(rs.getString("comments"));
	                rb.setReviewDate(rs.getTimestamp("review_date"));

	                reviews.add(rb);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        return reviews;
	    }
	
	
	 //get all reviews
	 public List<ReviewBean> getAllReviews() {
		    List<ReviewBean> list = new ArrayList<>();
		    Connection con = null;
		    PreparedStatement ps = null;
		    ResultSet rs = null;

		    try {
		        con = DBConnection.getConnection();
		        ps = con.prepareStatement("SELECT * FROM review ORDER BY review_date DESC");
		        rs = ps.executeQuery();

		        while (rs.next()) {
		            ReviewBean r = new ReviewBean();
		            r.setReviewId(rs.getInt("review_id"));
		            r.setCustomerId(rs.getInt("customer_id"));
		            r.setOrderId(rs.getInt("order_id"));
		            r.setStaffId(rs.getInt("staff_id"));
		            r.setRating(rs.getInt("rating"));
		            r.setComments(rs.getString("comments"));
		            r.setReviewDate(rs.getTimestamp("review_date"));

		            list.add(r);
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return list;
		}

	
	
	
	
	
	
	
	
}
