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

import java.io.Serializable;
import java.sql.Timestamp;

@SuppressWarnings("serial")
public class OrderBean implements Serializable {
    private int order_id;           // Primary Key (auto-increment)
    private int customer_id;        // Foreign Key from customer
    private int courier_id;         // Foreign Key from courier
    private Timestamp order_date;   // DATETIME in MySQL
    private Timestamp delivery_date; // DATETIME in MySQL (can be null)
    private String status;          // e.g., Pending, In Transit, Delivered
    private int deliveryStaffId;  //pk 
    private CourierBean courier;//used in admin for assign order to agents
    private CustomerBean customer;//used in agent to see  the  customer details
    
   
    
    
    // Getters and Setters

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getCourier_id() {
        return courier_id;
    }

    public void setCourier_id(int courier_id) {
        this.courier_id = courier_id;
    }

    public Timestamp getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Timestamp order_date) {
        this.order_date = order_date;
    }

    public Timestamp getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(Timestamp delivery_date) {
        this.delivery_date = delivery_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


	public int getDeliveryStaffId() {
		return deliveryStaffId;
	}

	public void setDeliveryStaffId(int deliveryStaffId) {
		this.deliveryStaffId = deliveryStaffId;
	}

	public CourierBean getCourier() {
		return courier;
	}

	public void setCourier(CourierBean courier) {
		this.courier = courier;
	}

	@Override
	public String toString() {
		return "OrderBean [order_id=" + order_id + ", customer_id=" + customer_id + ", courier_id=" + courier_id
				+ ", order_date=" + order_date + ", delivery_date=" + delivery_date + ", status=" + status
				+ ", deliveryStaffId=" + deliveryStaffId + ", courier=" + courier + "]";
	}

	public CustomerBean getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerBean customer) {
		this.customer = customer;
	}

	

	
}

