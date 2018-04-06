/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
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
    
}
