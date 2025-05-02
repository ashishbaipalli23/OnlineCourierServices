package com.ashi.BeansandDAOs;
import java.sql.*;
import java.util.*;

import com.ashi.dbconfig.DBConnection;
public class OrderDetailsDAO {
	public List<OrderDetailsBean> getPastOrdersByCustomer(int customerId) {
	    List<OrderDetailsBean> list = new ArrayList<>();
	      
	    try {
	    	 Connection con = DBConnection.getConnection();
	 	    
	 	    String sql = "SELECT o.order_id, o.order_date, o.delivery_date, o.status AS order_status, " +
	 	                 "c.pickup_location, c.destination, c.weight, c.type, c.cost, c.expected_delivery, " +
	 	                 "p.amount, p.payment_method, p.status AS payment_status, p.payment_date " +
	 	                 "FROM orders o " +
	 	                 "JOIN courier c ON o.courier_id = c.courier_id " +
	 	                 "LEFT JOIN payment p ON o.order_id = p.order_id " +
	 	                 "WHERE o.customer_id = ?";
	 	    
	 	    PreparedStatement ps = con.prepareStatement(sql);
	 	    ps.setInt(1, customerId);
	 	    ResultSet rs = ps.executeQuery();
	 	    
	 	    while (rs.next()) {
	 	        OrderDetailsBean bean = new OrderDetailsBean();
	 	        bean.setOrderId(rs.getInt("order_id"));
	 	        bean.setOrderDate(rs.getTimestamp("order_date"));
	 	        bean.setDeliveryDate(rs.getTimestamp("delivery_date"));
	 	        bean.setOrderStatus(rs.getString("order_status"));
                bean.setReviewExist(checkIfReviewExists(bean.getOrderId()));//reviwed or not 
	 	        
	 	        bean.setPickupLocation(rs.getString("pickup_location"));
	 	        bean.setDestination(rs.getString("destination"));
	 	        bean.setWeight(rs.getDouble("weight"));
	 	        bean.setType(rs.getString("type"));
	 	        bean.setCost(rs.getDouble("cost"));
	 	        bean.setExpectedDelivery(rs.getTimestamp("expected_delivery"));

	 	        bean.setAmount(rs.getDouble("amount"));
	 	        bean.setPaymentMethod(rs.getString("payment_method"));
	 	        bean.setPaymentStatus(rs.getString("payment_status"));
	 	        bean.setPaymentDate(rs.getTimestamp("payment_date"));

	 	        list.add(bean);
	 	    }
	 	   
	    }
	    catch (Exception e) {
		    e.printStackTrace();
		}
	   
	    
	    return list;
	}


	public  OrderDetailsBean getOrderDetailsById(int orderId,int cid) {
	    OrderDetailsBean bean = null;
	    try {
	    	Connection con = DBConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(
	            "SELECT o.order_id, o.status AS order_status, c.pickup_location, c.destination, c.expected_delivery " +
	            "FROM orders o JOIN courier c ON o.courier_id = c.courier_id WHERE o.order_id = ? and o.customer_id = ?");
	         
	        ps.setInt(1, orderId);
	        ps.setInt(2, cid);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            bean = new OrderDetailsBean();
	            bean.setOrderId(rs.getInt("order_id"));
	            bean.setOrderStatus(rs.getString("order_status"));
	            bean.setPickupLocation(rs.getString("pickup_location"));
	            bean.setDestination(rs.getString("destination"));
	            bean.setExpectedDelivery(rs.getTimestamp("expected_delivery"));
	        }
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return bean;
	}

	
	//review check
		public boolean checkIfReviewExists(int orderId) {
		    String query = "SELECT 1 FROM review WHERE order_id = ?";
		    try {
		    	Connection con = DBConnection.getConnection();
		    
		         PreparedStatement ps = con.prepareStatement(query);

		        ps.setInt(1, orderId);
		        ResultSet rs = ps.executeQuery();
		        return rs.next();  // true if a record is found
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return false;
		}

}
