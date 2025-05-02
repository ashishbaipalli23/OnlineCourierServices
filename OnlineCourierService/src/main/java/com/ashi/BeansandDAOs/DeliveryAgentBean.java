package com.ashi.BeansandDAOs;
/*
 *mysql> desc delivery_staff;
+-------------------+-------------+------+-----+---------+----------------+
| Field             | Type        | Null | Key | Default | Extra          |
+-------------------+-------------+------+-----+---------+----------------+
| staff_id          | int         | NO   | PRI | NULL    | auto_increment |
| name              | varchar(50) | NO   |     | NULL    |                |
| phone             | varchar(15) | NO   | UNI | NULL    |                |
| userid            | varchar(20) | NO   | UNI | NULL    |                |
| password          | varchar(20) | NO   | UNI | NULL    |                |
| photo             | blob        | YES  |     | NULL    |                |
| assigned_order_id | int         | YES  | MUL | NULL    |                |
| delivered_data    | timestamp   | YES  |     | NULL    |                |
+-------------------+-------------+------+-----+---------+----------------+
 * */
import java.io.Serializable;
import java.sql.Blob;
import java.sql.Timestamp;


@SuppressWarnings("serial")
public class DeliveryAgentBean implements Serializable {
   private int staffId;//PK auto_generated
   private String name;
   private String phone;
   private String userId;
   private String password;
   private Blob photo; // we can use byte[]-> directly supports in blob type
   private Integer assignedOrderId; //allows null values
   private Timestamp deliveredDate;
		   
		   
		public int getStaffId() {
			return staffId;
		}
		public void setStaffId(int staffId) {
			this.staffId = staffId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public Blob getPhoto() {
			return photo;
		}
		public void setPhoto(Blob photo) {
			this.photo = photo;
		}
		public Integer getAssignedOrderId() {
			return assignedOrderId;
		}
		public void setAssignedOrderId(Integer assignedOrderId) {
			this.assignedOrderId = assignedOrderId;
		}
		public Timestamp getDeliveredDate() {
			return deliveredDate;
		}
		public void setDeliveredDate(Timestamp deliveredDate) {
			this.deliveredDate = deliveredDate;
		}
		@Override
		public String toString() {
			return "DeliveryAgentBean [staffId=" + staffId + ", name=" + name + ", phone=" + phone + ", userId=" + userId
					+ ", password=" + password + ", photo=" + photo + ", assignedOrderId=" + assignedOrderId
					+ ", deliveredDate=" + deliveredDate + "]";
		}
		   
		   
   
}
