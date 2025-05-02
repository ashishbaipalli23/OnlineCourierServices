package com.ashi.BeansandDAOs;

import java.io.Serializable;
import java.sql.Timestamp;

/*
 * mysql> desc review;
+-------------+------+------+-----+---------+----------------+
| Field       | Type | Null | Key | Default | Extra          |
+-------------+------+------+-----+---------+----------------+
| review_id   | int  | NO   | PRI | NULL    | auto_increment |
| customer_id | int  | NO   | MUL | NULL    |                |
| order_id    | int  | NO   | MUL | NULL    |                |
| staff_id    | int  | YES  | MUL | NULL    |                |
| rating      | int  | YES  |     | NULL    |                |
| comments    | text | YES  |     | NULL    |                |
| review_date | date | YES  |     | NULL    |                |
+-------------+------+------+-----+---------+----------------+
7 rows in set (0.08 sec)*/


@SuppressWarnings("serial")
public class ReviewBean implements Serializable{
		private int reviewId;//Pk
		private int customerId;//FK -one to many
		private int orderId;//FK one to one 
		private int staffId;//FK one to many
		private int rating;
		
		private Timestamp reviewDate;
		private String comments;
		
		
		
		
		public int getReviewId() {
			return reviewId;
		}
		public void setReviewId(int reviewId) {
			this.reviewId = reviewId;
		}
		public int getCustomerId() {
			return customerId;
		}
		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}
		public int getOrderId() {
			return orderId;
		}
		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}
		public int getStaffId() {
			return staffId;
		}
		public void setStaffId(int staffId) {
			this.staffId = staffId;
		}
		public int getRating() {
			return rating;
		}
		public void setRating(int rating) {
			this.rating = rating;
		}
	
		public Timestamp getReviewDate() {
			return reviewDate;
		}
		public void setReviewDate(Timestamp reviewDate) {
			this.reviewDate = reviewDate;
		}
		public String getComments() {
			return comments;
		}
		public void setComments(String comments) {
			this.comments = comments;
		}
	
		
		
		
	
}
























