package com.ashi.BeansandDAOs;
import java.util.*;

import com.ashi.dbconfig.DBConnection;

import java.sql.*;
public class StaffDAO {
    public List<StaffPerformanceBean> getAllStaffPerformance() {
    	
        List<StaffPerformanceBean> list = new ArrayList<>();

        String sql = "SELECT ds.staff_id, ds.name, " +
                "COUNT(o.order_id) AS deliveries, " +
                "AVG(r.rating) AS avg_rating " +
                "FROM delivery_staff ds " +
                "LEFT JOIN orders o ON ds.staff_id = o.delivery_staff_id " +
                "LEFT JOIN review r ON ds.staff_id = r.staff_id " +
                "GROUP BY ds.staff_id, ds.name";

        try {
        	Connection con = DBConnection.getConnection();
        
        	PreparedStatement ps = con.prepareStatement(sql);
        
             ResultSet rs = ps.executeQuery(); 
             while (rs.next()) {
                 StaffPerformanceBean sp = new StaffPerformanceBean();
                 sp.setStaffId(rs.getInt("staff_id"));
                 sp.setName(rs.getString("name"));
                 sp.setDeliveryCount(rs.getInt("deliveries"));
                 sp.setAvgRating(rs.getDouble("avg_rating"));
                 list.add(sp);
             }
        }
        catch (Exception e) {
			e.printStackTrace();
		}
        return list;
    }
}
