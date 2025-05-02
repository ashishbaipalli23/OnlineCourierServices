package com.ashi.BeansandDAOs;



import java.io.Serializable;
import java.sql.Timestamp;

@SuppressWarnings("serial")
public class OrderDetailsBean implements Serializable {

    // Order details
    private int orderId;
    private Timestamp orderDate;
    private Timestamp deliveryDate;
    private String orderStatus;

    // Courier details
    private String pickupLocation;
    private String destination;
    private double weight;
    private String type;
    private double cost;
    private Timestamp expectedDelivery;

    // Payment details
    private double amount;
    private String paymentMethod;
    private String paymentStatus;
    private Timestamp paymentDate;

    
    private boolean reviewExist; 
    // --- Getters and Setters ---

    // Order
    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public Timestamp getDeliveryDate() {
        return deliveryDate;
    }
    public void setDeliveryDate(Timestamp deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    // Courier
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

    public Timestamp getExpectedDelivery() {
        return expectedDelivery;
    }
    public void setExpectedDelivery(Timestamp expectedDelivery) {
        this.expectedDelivery = expectedDelivery;
    }

    // Payment
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }
    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Timestamp getPaymentDate() {
        return paymentDate;
    }
    public void setPaymentDate(Timestamp paymentDate) {
        this.paymentDate = paymentDate;
    }
	public boolean isReviewExist() {
		return reviewExist;
	}
	public void setReviewExist(boolean reviewExist) {
		this.reviewExist = reviewExist;
	}
}
