package com.ashi.BeansandDAOs;

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

import java.sql.Timestamp;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CourierBean implements Serializable {

    private int courier_id; // Primary Key
    private String pickupLocation;
    private String destination;
    private double weight;
    private String type;
    private double cost;
    private int customer_id; // Foreign Key
    private Timestamp booking_date;
    private Timestamp expected_delivery;

    // Getters and Setters

    public int getCourier_id() {
        return courier_id;
    }

    public void setCourier_id(int courier_id) {
        this.courier_id = courier_id;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public Timestamp getBooking_date() {
        return booking_date;
    }

    public void setBooking_date(Timestamp booking_date) {
        this.booking_date = booking_date;
    }

    public Timestamp getExpected_delivery() {
        return expected_delivery;
    }

    public void setExpected_delivery(Timestamp expected_delivery) {
        this.expected_delivery = expected_delivery;
    }

	@Override
	public String toString() {
		return "CourierBean [courier_id=" + courier_id + ", pickupLocation=" + pickupLocation + ", destination="
				+ destination + ", weight=" + weight + ", type=" + type + ", cost=" + cost + ", customer_id="
				+ customer_id + ", booking_date=" + booking_date + ", expected_delivery=" + expected_delivery + "]";
	}
    
    
}

