package com.ashi.BeansandDAOs;
/*
mysql> desc payment;
+----------------+---------------+------+-----+-------------------+-------------------+
| Field          | Type          | Null | Key | Default           | Extra             |
+----------------+---------------+------+-----+-------------------+-------------------+
| payment_id     | int           | NO   | PRI | NULL              | auto_increment    |
| order_id       | int           | NO   | MUL | NULL              |                   |
| amount         | decimal(10,2) | NO   |     | NULL              |                   |
| payment_date   | timestamp     | NO   |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
| payment_method | varchar(50)   | NO   |     | NULL              |                   |
| status         | varchar(50)   | YES  |     | Pending           |                   |
| customer_id    | int           | NO   | MUL | NULL              |                   |
+----------------+---------------+------+-----+-------------------+-------------------+
7 rows in set (0.02 sec)
*/

import com.ashi.dbconfig.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class PaymentDAO {
	

	    public int savePayment(PaymentBean pb) {
	        int k = 0;
	        try  {
	        	Connection con = DBConnection.getConnection();
	        	
	            PreparedStatement ps = con.prepareStatement
	            		("INSERT INTO payment (order_id, amount, payment_date, payment_method, status, customer_id) VALUES (?, ?, ?, ?, ?, ?)");
	            ps.setInt(1, pb.getOrderId());
	            ps.setDouble(2, pb.getAmount());
	            ps.setTimestamp(3, pb.getPaymentDate());
	            ps.setString(4, pb.getPaymentMethod());
	            ps.setString(5, pb.getStatus());
	            ps.setInt(6, pb.getCustomerId());

	            k = ps.executeUpdate();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return k;
	        
	    }
	    
	    
	    public List<PaymentBean> getPaymentHistory(int customerId){
	    	
	    	List<PaymentBean> payments = new ArrayList<PaymentBean>();
	    	try {
					Connection connection = DBConnection.getConnection();
					PreparedStatement pStatement = connection.prepareStatement
							("SELECT * FROM payment WHERE customer_id = ?");
					pStatement.setInt(1, customerId);
					ResultSet res = pStatement.executeQuery();
					while(res.next()) {
						PaymentBean pb = new PaymentBean();
						//i am column names to get the data from the result set
						pb.setPaymentId(res.getInt("payment_id"));
						pb.setAmount(res.getDouble("amount"));
						pb.setCustomerId(res.getInt("customer_id"));
						pb.setOrderId(res.getInt("order_id"));
						pb.setPaymentDate(res.getTimestamp("payment_date"));
						pb.setPaymentMethod(res.getString("payment_method"));
						pb.setStatus(res.getString("status"));
						
						payments.add(pb);
						
					}
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	
	    	return payments;
	    	
	    }
	    
	    
	    
	}


