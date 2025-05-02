package com.ashi.BeansandDAOs;
/*
 * mysql> desc delivery_staff;
+-------------------+-------------+------+-----+---------+----------------+
| Field             | Type        | Null | Key | Default | Extra          |
+-------------------+-------------+------+-----+---------+----------------+
| staff_id          | int         | NO   | PRI | NULL    | auto_increment |
| name              | varchar(50) | NO   |     | NULL    |                |
| phone             | varchar(15) | NO   | UNI | NULL    |                |
| userid            | varchar(20) | NO   | UNI | NULL    |                |
| password          | varchar(20) | YES  |     | NULL    |                |
| photo             | blob        | YES  |     | NULL    |                |
| assigned_order_id | int         | YES  | MUL | NULL    |                |
| delivered_data    | timestamp   | YES  |     | NULL    |                |
+-------------------+-------------+------+-----+---------+----------------+*/


import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import com.ashi.dbconfig.DBConnection;

public class DeliveryAgentDAO {
	
	public DeliveryAgentBean login(String userId,String password) {
		DeliveryAgentBean agentBean = null;
			try {
			    Connection connection = DBConnection.getConnection();
			    PreparedStatement pStatement = connection.prepareStatement
			    		("select * from delivery_staff where userid = ? and password = ?");
			    pStatement.setString(1, userId);
			    pStatement.setString(2, password);
			    ResultSet res = pStatement.executeQuery();
			    if(res.next()) {
			    	agentBean  = new DeliveryAgentBean();
			    	agentBean.setName(res.getString("name"));
			    	agentBean.setPhone(res.getString("phone"));
			    	agentBean.setStaffId(res.getInt("staff_id"));
			    	agentBean.setPassword(res.getString("password"));
			    	agentBean.setUserId(res.getString("userid"));
			    	agentBean.setPhoto(res.getBlob("photo"));
			    	agentBean.setDeliveredDate(res.getTimestamp("delivered_data"));
			    	
			    }
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		
		return agentBean;
		
		
	}
	
	
	public boolean addDeliveryStaff(DeliveryAgentBean staff, InputStream photoStream) {
        boolean status = false;
        
        String sql = "INSERT INTO delivery_staff (name, phone, userid, password, photo) VALUES (?, ?, ?, ?, ?)";

        try {
        	Connection conn = DBConnection.getConnection();
        
             PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, staff.getName());
            pstmt.setString(2, staff.getPhone());
            pstmt.setString(3, staff.getUserId());
            pstmt.setString(4, staff.getPassword());

            if (photoStream != null) {
                pstmt.setBlob(5, photoStream); // set the photo blob
            } else {
                pstmt.setNull(5, java.sql.Types.BLOB); // if no photo uploaded
            }

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace(); // you can also log it properly
        }

        return status;
    }
	
	
	public List<DeliveryAgentBean> getUnsignedAgents(){
		List<DeliveryAgentBean> agents = new ArrayList<>();
		
		   try {
			    Connection connection = DBConnection.getConnection();
			    //avilabe agents
			    PreparedStatement pStatement = connection.prepareStatement("select * from delivery_staff where assigned_order_id is null ");
			    
			    ResultSet res = pStatement.executeQuery();
			    while(res.next()) {
			    	DeliveryAgentBean agentBean = new DeliveryAgentBean();
			    	agentBean.setStaffId(res.getInt("staff_id"));
			    	agentBean.setAssignedOrderId(res.getInt("assigned_order_id"));
			    	agentBean.setDeliveredDate(res.getTimestamp("delivered_data"));
			    	agentBean.setName(res.getString("name"));
			    	agentBean.setPhone(res.getString("phone"));
			    	agentBean.setUserId(res.getString("userid"));
			    	agentBean.setPhoto(res.getBlob("photo"));
			    	//don't set password 
			    	agents.add(agentBean);
			    }
			     
		   }
		   catch (Exception e) {
			e.printStackTrace();
		}
		
		return agents;
	}
	
	public int OrderToStaff(int orderId, int staffId) {
	    int k = 0;
	    String query = "UPDATE delivery_staff SET assigned_order_id = ? WHERE staff_id = ?";
	    try {
	        Connection connection = DBConnection.getConnection();
	        PreparedStatement pStatement = connection.prepareStatement(query);

	        pStatement.setInt(1, orderId);   //  assigned_order_id = orderId
	        pStatement.setInt(2, staffId);    // staff_id = staffId

	        k = pStatement.executeUpdate();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return k;
	}
	
	public List<DeliveryAgentBean> getAgents(){
		List<DeliveryAgentBean> agents = new ArrayList<>();
		
		   try {
			    Connection connection = DBConnection.getConnection();
			    //available agents
			    PreparedStatement pStatement = connection.prepareStatement("select * from delivery_staff");
			    
			    ResultSet res = pStatement.executeQuery();
			    while(res.next()) {
			    	DeliveryAgentBean agentBean = new DeliveryAgentBean();
			    	agentBean.setStaffId(res.getInt("staff_id"));
			    	//agentBean.setAssignedOrderId(res.getInt("assigned_order_id"));
			    	//agentBean.setDeliveredDate(res.getTimestamp("delivered_data"));
			    	agentBean.setName(res.getString("name"));
			    	agentBean.setPhone(res.getString("phone"));
			    	agentBean.setUserId(res.getString("userid"));
			    	//agentBean.setPhoto(res.getBlob("photo"));
			    	agentBean.setPassword(res.getString("password"));
			    	agents.add(agentBean);
			    }
			     
		   }
		   catch (Exception e) {
			e.printStackTrace();
		}
		
		return agents;
	}
	
	
	 public boolean updateAgent(int agentId, String name, String phone, String userId, String password) {
	        boolean rowUpdated = false;
	        try{
	        	Connection conn = DBConnection.getConnection();
	       
	            String sql = "UPDATE delivery_staff SET name=?, phone=?, userid=?, password=? WHERE staff_id=?";
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            stmt.setString(1, name);
	            stmt.setString(2, phone);
	            stmt.setString(3, userId);
	            stmt.setString(4, password);
	            stmt.setInt(5, agentId);

	            int rows = stmt.executeUpdate();
	            rowUpdated = rows > 0;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return rowUpdated;
	    }
	
	 
	 //before deleting use check agent is assinged with the orders or not 
	 public boolean isAgentLinkedToOrders(int agentId) {
		    boolean linked = false;
		    try {
		    	Connection conn = DBConnection.getConnection();
		        String sql = "SELECT COUNT(*) FROM orders WHERE delivery_staff_id = ?";
		        PreparedStatement stmt = conn.prepareStatement(sql);
		        stmt.setInt(1, agentId);
		        ResultSet rs = stmt.executeQuery();
		        if (rs.next()) {
		            linked = rs.getInt(1) > 0;
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return linked;
		}

	 
	 public int deleteAgent(int staffId) {
		 int k =0 ;
		   try {
			   Connection connection  = DBConnection.getConnection();
			   PreparedStatement pStatement = connection.prepareStatement
					   ("DELETE FROM delivery_staff WHERE staff_id = ?");
			   pStatement.setInt(1, staffId);
			   k = pStatement.executeUpdate();
			   
		   }
		   catch (Exception e) {
			e.printStackTrace();
		}
		 
		 return k;
		 
	 }
	 
	 
	 public InputStream getAgentPhotoById(int staffId) {
	        InputStream photoStream = null;

	        try {
	        	Connection conn = DBConnection.getConnection();	        
	            PreparedStatement ps = conn.prepareStatement("SELECT photo FROM delivery_staff WHERE staff_id = ?");
	            ps.setInt(1, staffId);
	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	                Blob photoBlob = rs.getBlob("photo");
	                if (photoBlob != null) {
	                    photoStream = photoBlob.getBinaryStream();
	                }
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return photoStream;
	    }
	 
	 
	 public int updatePassword(int staffId,String password) {
		 int k = 0;
		    try {
		    	Connection connection = DBConnection.getConnection();
		    	PreparedStatement pStatement = connection.prepareStatement
		    			("UPDATE delivery_staff set password = ? where staff_id = ?");
		    	pStatement.setString(1, password);
		    	pStatement.setInt(2, staffId);
		    	k = pStatement.executeUpdate();
				
			} catch (Exception e) {
				
			}
		 
		 return k;
		 
	 }
	 
	 
	 
	 
	
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 

}
