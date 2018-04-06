/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Dax Amin
 */
public class Report {
    
    public static ResultSet occupancyHotel(){
        ResultSet resultSet = null;
        try
        {
            Statement statement = Connect.connection.createStatement();
            resultSet = statement.executeQuery("SELECT CheckIns.hotelID, Hotels.hotelName, COUNT(*) AS TotalRoomsOccupied "
                    + "FROM CheckIns, Hotels "
                    + "WHERE CheckIns.hotelID = Hotels.hotelID AND (checkOutDateTime = '0000-00-00 00:00:00' OR NULL) "
                    + "GROUP BY CheckIns.hotelID;");
            
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,ex);
        }
        
        return resultSet;
    }
    
    public static ResultSet occupancyRoomType(){
        ResultSet resultSet = null;
        try
        {
            Statement statement = Connect.connection.createStatement();
            resultSet = statement.executeQuery("SELECT RoomTypes.roomTypeName, COUNT(*) AS TotalOccupied "
                    + "FROM CheckIns, RoomTypes, Rooms "
                    + "WHERE CheckIns.hotelID = Rooms.hotelID AND CheckIns.roomNo = Rooms.roomNo "
                    + "AND Rooms.roomTypeID = RoomTypes.roomTypeID AND (checkOutDateTime = '0000-00-00 00:00:00' OR NULL) "
                    + "GROUP BY RoomTypes.roomTypeName "
                    + "ORDER BY RoomTypes.roomTypeName;");
            
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,ex);
        }
        
        return resultSet;
    }
    
    public static ResultSet occupancyCity(){
        ResultSet resultSet = null;
        try
        {
            Statement statement = Connect.connection.createStatement();
            resultSet = statement.executeQuery("SELECT Cities.cityName, COUNT(*) AS TotalOccupied "
                    + "FROM CheckIns, Hotels, Cities "
                    + "WHERE CheckIns.hotelID = Hotels.hotelID AND Hotels.cityID = Cities.cityID "
                    + "AND (checkOutDateTime = '0000-00-00 00:00:00' OR NULL) "
                    + "GROUP BY Cities.cityID "
                    + "ORDER BY Cities.cityName;");
            
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,ex);
        }
        
        return resultSet;
    }
    
    public static ResultSet checkInDateRange(Date startDate, Date endDate){
        java.sql.Date sqlStartDate = new java.sql.Date(startDate.getTime());
        java.sql.Date sqlEndDate = new java.sql.Date(endDate.getTime());
        ResultSet resultSet = null;
        try
        {
            PreparedStatement pstatement = Connect.connection.prepareStatement("SELECT COUNT(*) AS TotalCheckIns FROM CheckIns "
                    + "WHERE checkInDateTime BETWEEN ? AND ?;");
            
            pstatement.setDate(1, sqlStartDate);
            pstatement.setDate(2, sqlEndDate);
            
            resultSet = pstatement.executeQuery();
            
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,ex);
        }
        
        return resultSet;
    }
    
    public static ResultSet staffGrouped(){
        ResultSet resultSet = null;
        try
        {
            Statement statement = Connect.connection.createStatement();
            resultSet = statement.executeQuery("SELECT StaffTypes.staffTypeName, COUNT(*) AS TotalStaff "
                    + "FROM Staffs, StaffTypes "
                    + "WHERE Staffs.staffTypeID = StaffTypes.staffTypeID "
                    + "GROUP BY StaffTypes.staffTypeName "
                    + "ORDER BY StaffTypes.staffTypeName;");
            
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,ex);
        }
        
        return resultSet;
    }
    
    public static ResultSet getRevenue(Date startDate, Date endDate){
        java.sql.Date sqlStartDate = new java.sql.Date(startDate.getTime());
        java.sql.Date sqlEndDate = new java.sql.Date(endDate.getTime());
        ResultSet resultSet = null;
        try
        {
            PreparedStatement pstatement = Connect.connection.prepareStatement("SELECT CheckIns.hotelID, Hotels.hotelName, SUM(Bills.totalAmount) AS TotalRevenue "
                    + "FROM CheckIns, Hotels, Bills "
                    + "WHERE Bills.checkInID = CheckIns.checkInID AND CheckIns.hotelID = Hotels.hotelID "
                    + "AND (CheckIns.checkOutDateTime BETWEEN ? AND ?) "
                    + "GROUP BY CheckIns.hotelID "
                    + "ORDER BY CheckIns.hotelID;");
            
            pstatement.setDate(1, sqlStartDate);
            pstatement.setDate(2, sqlEndDate);
            
            resultSet = pstatement.executeQuery();
            
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,ex);
        }
        
        return resultSet;
    }
    
}
