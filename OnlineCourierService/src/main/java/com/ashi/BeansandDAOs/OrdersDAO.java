package com.ashi.BeansandDAOs;
/*
mysql> desc orders;
+-------------------+-------------+------+-----+---------+----------------+
| Field             | Type        | Null | Key | Default | Extra          |
+-------------------+-------------+------+-----+---------+----------------+
| order_id          | int         | NO   | PRI | NULL    | auto_increment |
| customer_id       | int         | NO   | MUL | NULL    |                |
| courier_id        | int         | YES  | MUL | NULL    |                |
| order_date        | datetime    | NO   |     | NULL    |                |
| delivery_date     | datetime    | YES  |     | NULL    |                |
| status            | varchar(50) | YES  |     | Pending |                |
| delivery_staff_id | int         | YES  | MUL | NULL    |                |
+-------------------+-------------+------+-----+---------+----------------+
*/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import com.ashi.dbconfig.DBConnection;

public class OrdersDAO {
	
	public int placeOrder(OrderBean ob) {
		//insert row in the Orders table
        int k = 0;
        try {
            Connection connection = DBConnection.getConnection();
            
            PreparedStatement pStatement = connection.prepareStatement(
                "INSERT INTO orders (customer_id, courier_id, order_date, status) VALUES (?, ?, CURRENT_TIMESTAMP, ?)"
            );

            // Set parameters
            pStatement.setInt(1, ob.getCustomer_id());
            pStatement.setInt(2, ob.getCourier_id());
            pStatement.setString(3, ob.getStatus());

            // Execute
            k = pStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return k;
    }
   
	public int cancelOrder(int orderId) {
	   int k= 0;
	    String query = "UPDATE orders SET status = 'Cancelled' WHERE order_id = ?";
	    try {
	    	Connection con = DBConnection.getConnection();
	
	         PreparedStatement ps = con.prepareStatement(query);
	        	
	        ps.setInt(1, orderId);
	        k = ps.executeUpdate();
	       
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return k;
	}

	
	

	
	
	
	 public List<OrderBean> getUnassignedOrders() {
	        List<OrderBean> unassignedOrders = new ArrayList<>();
	        //get unassigned order from order table
	        String query = "SELECT * FROM orders WHERE delivery_staff_id IS NULL";
	        try {
	        	
	        
	        Connection connection = DBConnection.getConnection();
	             PreparedStatement pStatement = connection.prepareStatement(query);
	            
	            
	            ResultSet res = pStatement.executeQuery();
	            while (res.next()) {
	            	OrderBean order = new OrderBean();
	                order.setOrder_id(res.getInt("order_id"));
	                order.setCustomer_id(res.getInt("customer_id"));
	                order.setCourier_id(res.getInt("courier_id"));
	                order.setOrder_date(res.getTimestamp("order_date"));
	                order.setDelivery_date(res.getTimestamp("delivery_date"));
	                order.setStatus(res.getString("status"));
	                unassignedOrders.add(order);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return unassignedOrders;
	    }
	 
	 
	public List<OrderBean> getUnassignedOrdersWithCourierDetails() {
		
	    List<OrderBean> unassignedOrdersWithCourier = new ArrayList<>();
	    String query = "SELECT o.order_id, o.customer_id, o.courier_id, o.order_date,o.delivery_date, o.status, " +
	                   "c.pickup_location, c.destination, c.weight, c.type, c.cost, c.booking_date, c.expected_delivery " +
	                   "FROM orders o " +
	                   "LEFT JOIN courier c ON o.courier_id = c.courier_id " +
	                   "WHERE o.delivery_staff_id IS NULL";
	
	    try {
	        Connection connection = DBConnection.getConnection();
	        PreparedStatement pStatement = connection.prepareStatement(query);
	        ResultSet res = pStatement.executeQuery();
	
	        while (res.next()) {
	            OrderBean order = new OrderBean();
	            order.setOrder_id(res.getInt("order_id"));
	            order.setCustomer_id(res.getInt("customer_id"));
	            order.setCourier_id(res.getInt("courier_id"));
	            order.setOrder_date(res.getTimestamp("order_date"));
	            order.setDelivery_date(res.getTimestamp("delivery_date"));
	            order.setStatus(res.getString("status"));
	
	            // Set courier details
	            CourierBean courier = new CourierBean();
	            courier.setPickupLocation(res.getString("pickup_location"));
	            courier.setDestination(res.getString("destination"));
	            courier.setWeight(res.getDouble("weight"));
	            courier.setType(res.getString("type"));
	            courier.setCost(res.getDouble("cost"));
	            courier.setBooking_date(res.getTimestamp("booking_date"));
	            courier.setExpected_delivery(res.getTimestamp("expected_delivery"));
	
	            // Attach the courier details to the order
	            order.setCourier(courier);
	
	            // Add the order with courier details to the list
	            unassignedOrdersWithCourier.add(order);
	        }
	
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	
	    return unassignedOrdersWithCourier;
}

	 
	 public int assignStaffToOrder(int orderId, int staffId) {
		    
		    int k = 0;
	        String query = "UPDATE orders SET delivery_staff_id = ?, status= ? WHERE order_id = ?";
	        try {
	        	Connection connection = DBConnection.getConnection();
	        
	             PreparedStatement pStatement = connection.prepareStatement(query);
	             
	            
	            pStatement.setInt(1, staffId);
	            pStatement.setString(2, "PickUp Ready");
	            pStatement.setInt(3, orderId);
	            
	            k = pStatement.executeUpdate();
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			return k;
	    }
	 
	 
	 public List<OrderBean> getOrdersByStaffId(int staffId){
		    List<OrderBean> orders = new ArrayList<OrderBean>();
		    String sql = "SELECT * FROM orders WHERE delivery_staff_id = ? and delivery_date is null  ORDER BY order_date DESC";

		    try {
		    	Connection con = DBConnection.getConnection();
		    
		         PreparedStatement ps = con.prepareStatement(sql);
		        		 

		        ps.setInt(1, staffId);
		        ResultSet rs = ps.executeQuery();

		        while (rs.next()) {
		            OrderBean order = new OrderBean();
		            order.setOrder_id(rs.getInt("order_id"));
		            order.setCustomer_id(rs.getInt("customer_id"));
		            order.setCourier_id(rs.getInt("courier_id"));
		            order.setOrder_date(rs.getTimestamp("order_date"));
		            order.setDelivery_date(rs.getTimestamp("delivery_date"));
		            order.setStatus(rs.getString("status"));
		            order.setDeliveryStaffId(rs.getInt("delivery_staff_id"));
		            orders.add(order);
		        }
		    }
		    catch (Exception e) {
			     e.printStackTrace();
			}

		    return orders;
		}

	 
	 //view order details along with the courier details and also customer details 
	 public OrderBean getOrderDetailsToAgent(int orderID,int staffId) {
		    OrderBean order = null;
	        CourierBean courier = null;
	        CustomerBean customer = null;
		    try {
		    
		    	   String sql = "SELECT o.*, c.*, cu.* FROM orders o "
		                   + "JOIN courier c ON o.courier_id = c.courier_id "
		                   + "JOIN customer cu ON c.customer_id = cu.customer_id "
		                   + "WHERE o.order_id = ? and delivery_staff_id = ? ";
		    	   
		    	   
		    	Connection connection = DBConnection.getConnection();
		    	PreparedStatement pStatement = connection.prepareStatement(sql);
		    	pStatement.setInt(1, orderID);
		    	pStatement.setInt(2, staffId);
		    	
		    	 ResultSet rs = pStatement.executeQuery();

		            if (rs.next()) {
		                order = new OrderBean();
		                order.setOrder_id(rs.getInt("o.order_id"));
		                order.setCustomer_id(rs.getInt("o.customer_id"));
		                order.setCourier_id(rs.getInt("o.courier_id"));
		                order.setOrder_date(rs.getTimestamp("o.order_date"));
		                order.setDelivery_date(rs.getTimestamp("o.delivery_date"));
		                order.setStatus(rs.getString("o.status"));

		                courier = new CourierBean();
		                courier.setCourier_id(rs.getInt("c.courier_id"));
		                courier.setPickupLocation(rs.getString("c.pickup_location"));
		                courier.setDestination(rs.getString("c.destination"));
		                courier.setWeight(rs.getDouble("c.weight"));
		                courier.setType(rs.getString("c.type"));
		                courier.setCost(rs.getDouble("c.cost"));
		                courier.setExpected_delivery(rs.getTimestamp("c.expected_delivery"));

		                customer = new CustomerBean();
		                customer.setCustomer_id(rs.getInt("cu.customer_id"));
		                customer.setName(rs.getString("cu.name"));
		                customer.setPhone(rs.getString("cu.phone"));

		                order.setCourier(courier);
		                order.setCustomer(customer);
		            }

		    	
		    }
		    catch (Exception e) {
				e.printStackTrace();
			}
		 
		 return order;
	 }
	 
	 public OrderBean getAssignedOrderForAgent(int staffId) {
		    OrderBean order = null;

		    try {
		       Connection conn = DBConnection.getConnection();
		       
		        String sql = "SELECT * FROM orders WHERE delivery_staff_id = ? AND status != 'Delivered'";
		        PreparedStatement ps = conn.prepareStatement(sql);
		        ps.setInt(1, staffId);
		        ResultSet rs = ps.executeQuery();

		        if (rs.next()) {
		            order = new OrderBean();
		            order.setOrder_id(rs.getInt("order_id"));
		            order.setStatus(rs.getString("status"));
		            // Set more fields if needed
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return order;
		}

	 
	 //update status of the order 
	public String updateOrderStatus(int orderId, int staffId, String status) {
	    String result = "failed";
	    Connection con = null;
	    PreparedStatement ps1 = null;
	    PreparedStatement ps2 = null;
	    PreparedStatement ps3 = null;
	
	    try {
	        con = DBConnection.getConnection();
	        con.setAutoCommit(false);
	
	        // Step 1: Update order status and delivery_date if Delivered
	        ps1 = con.prepareStatement(
	            "UPDATE orders SET status = ?, delivery_date = CASE WHEN ? = 'Delivered' THEN NOW() ELSE delivery_date END WHERE order_id = ? AND delivery_staff_id = ?"
	        );
	        ps1.setString(1, status);
	        ps1.setString(2, status);
	        ps1.setInt(3, orderId);
	        ps1.setInt(4, staffId);
	        int rows1 = ps1.executeUpdate();
	
	        if (rows1 == 0) {
	            con.rollback();
	
	            if (ps1 != null) ps1.close();
	            if (con != null) con.setAutoCommit(true);
	           
	
	            return "Order not found or unauthorized update attempt.";
	        }
	
	        if ("Delivered".equalsIgnoreCase(status)) {
	            // Step 2: Update delivery_staff table (delivered_data)
	            ps2 = con.prepareStatement("UPDATE delivery_staff SET delivered_data = NOW() WHERE staff_id = ?");
	            ps2.setInt(1, staffId);
	            ps2.executeUpdate();
	
	            // Step 3: Free the agent by setting assigned_order_id to NULL
	            ps3 = con.prepareStatement("UPDATE delivery_staff SET assigned_order_id = NULL WHERE staff_id = ?");
	            ps3.setInt(1, staffId);
	            ps3.executeUpdate();
	        }
	
	        con.commit();
	        result = "success";
	
	        // Manual cleanup
	        if (ps3 != null) ps3.close();
	        if (ps2 != null) ps2.close();
	        if (ps1 != null) ps1.close();
	        if (con != null) con.setAutoCommit(true);
	        
	
	    } catch (Exception e) {
	        try {
	            if (con != null) con.rollback();
	            if (ps3 != null) ps3.close();
	            if (ps2 != null) ps2.close();
	            if (ps1 != null) ps1.close();
	            if (con != null) con.setAutoCommit(true);
	            
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	        result = "error";
	        e.printStackTrace();
	    }

    return result;
   }


  
	 //Delivery history of an agent
	public List<OrderBean> getDeliveryHistory(int staffId) {
	    List<OrderBean> history = new ArrayList<>();

	    try {
	        Connection con = DBConnection.getConnection();
	        PreparedStatement ps = con.prepareStatement(
	            "SELECT * FROM orders WHERE delivery_staff_id = ? AND status = 'Delivered' ORDER BY delivery_date DESC"
	        );
	        ps.setInt(1, staffId);
	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            OrderBean order = new OrderBean();
	            order.setOrder_id(rs.getInt("order_id"));
	            order.setCustomer_id(rs.getInt("customer_id"));
	            order.setOrder_date(rs.getTimestamp("order_date"));
	            order.setDelivery_date(rs.getTimestamp("delivery_date"));
	            order.setStatus(rs.getString("status"));
	            
	         
	            history.add(order);
	        }

	        rs.close();
	        ps.close();
	      
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return history;
	}

	
	
	
	
}
