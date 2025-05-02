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

import java.io.Serializable;
import java.sql.Timestamp;


@SuppressWarnings("serial")
public class PaymentBean implements Serializable {


    private int paymentId; // PK, auto-generated
    private int orderId;   // FK one-to-one
    private double amount;
    private Timestamp paymentDate;
    private String paymentMethod;
    private String status;
    private int customerId; // FK one-to-many

    // Getters and Setters
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Timestamp getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Timestamp paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    // Optional: toString() for logging/debugging
    @Override
    public String toString() {
        return "PaymentBean [paymentId=" + paymentId + ", orderId=" + orderId + ", amount=" + amount
                + ", paymentDate=" + paymentDate + ", paymentMethod=" + paymentMethod + ", status=" + status
                + ", customerId=" + customerId + "]";
    }
}
