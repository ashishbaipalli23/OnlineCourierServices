package com.ashi.BeansandDAOs;

public class StaffPerformanceBean {
    private int staffId;
    private String name;
    private int deliveryCount;
    private double avgRating;
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
	public int getDeliveryCount() {
		return deliveryCount;
	}
	public void setDeliveryCount(int deliveryCount) {
		this.deliveryCount = deliveryCount;
	}
	public double getAvgRating() {
		return avgRating;
	}
	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}
	@Override
	public String toString() {
		return "StaffPerformanceBean [staffId=" + staffId + ", name=" + name + ", deliveryCount=" + deliveryCount
				+ ", avgRating=" + avgRating + "]";
	}

    
    
}

