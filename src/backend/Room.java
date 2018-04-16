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
 * @author patel
 */
public class Room
{
    
    private boolean availability;

    /**
     * Get the value of availability
     *
     * @return the value of availability
     */
    public boolean isAvailability() {
        return availability;
    }

    /**
     * Set the value of availability
     *
     * @param availability new value of availability
     */
    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public String toString(){
        return " " + roomNo + " "; 
    }
    
    public Room(int maxAllowedOccupancy, double roomRates, int hotelID, int roomTypeID, int roomNo, boolean availability) {
        this.maxAllowedOccupancy = maxAllowedOccupancy;
        this.roomRates = roomRates;
        this.hotelID = hotelID;
        this.roomTypeID = roomTypeID;
        this.roomNo = roomNo;
        this.availability = availability;
    }

    private int maxAllowedOccupancy;

    /**
     * Get the value of maxAllowedOccupancy
     *
     * @return the value of maxAllowedOccupancy
     */
    public int getMaxAllowedOccupancy() {
        return maxAllowedOccupancy;
    }

    /**
     * Set the value of maxAllowedOccupancy
     *
     * @param maxAllowedOccupancy new value of maxAllowedOccupancy
     */
    public void setMaxAllowedOccupancy(int maxAllowedOccupancy) {
        this.maxAllowedOccupancy = maxAllowedOccupancy;
    }


    private double roomRates;

    /**
     * Get the value of roomRates
     *
     * @return the value of roomRates
     */
    public double getRoomRates() {
        return roomRates;
    }

    /**
     * Set the value of roomRates
     *
     * @param roomRates new value of roomRates
     */
    public void setRoomRates(double roomRates) {
        this.roomRates = roomRates;
    }


    private int hotelID;

    /**
     * Get the value of hotelID
     *
     * @return the value of hotelID
     */
    public int getHotelID() {
        return hotelID;
    }

    /**
     * Set the value of hotelID
     *
     * @param hotelID new value of hotelID
     */
    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }


    private int roomTypeID;

    /**
     * Get the value of roomTypeID
     *
     * @return the value of roomTypeID
     */
    public int getRoomTypeID() {
        return roomTypeID;
    }

    /**
     * Set the value of roomTypeID
     *
     * @param roomTypeID new value of roomTypeID
     */
    public void setRoomTypeID(int roomTypeID) {
        this.roomTypeID = roomTypeID;
    }

    private int roomNo;

    /**
     * Get the value of roomNo
     *
     * @return the value of roomNo
     */
    public int getRoomNo() {
        return roomNo;
    }

    /**
     * Set the value of roomNo
     *
     * @param roomNo new value of roomNo
     */
    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }
    
    //Return Newly created room id or return -1 if error  
    public static boolean createRoom(int roomNo, int roomTypeID, int hotelID, double roomRates, int maxAllowedOccupancy, boolean availability) {

        try {
            PreparedStatement pscreate = Connect.connection.prepareStatement("insert into Rooms(roomNo, roomTypeID, hotelID, roomRates, maxAllowedOccupancy, availability) values(?,?,?,?,?,?)");
            pscreate.setInt(1, roomNo);
            pscreate.setInt(2, roomTypeID);
            pscreate.setInt(3, hotelID);
            pscreate.setDouble(4, roomRates);
            pscreate.setInt(5, maxAllowedOccupancy);
            pscreate.setBoolean(6, availability);

            pscreate.executeUpdate();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,ex);
            return false;
        }

        
    }
    
    public static boolean updateRoomDetails(int roomNo, int roomTypeID, int hotelID, double roomRates, short maxAllowedOccupancy, boolean availability) {

        try {
            PreparedStatement pscreate = Connect.connection.prepareStatement("UPDATE Rooms "+
                    "SET roomRates = ?, maxAllowedOccupancy = ?, roomTypeID = ?,availability = ? "+
                    "WHERE (hotelID = ? and roomNo = ?)");
            pscreate.setDouble(1, roomRates);
            pscreate.setShort(2, maxAllowedOccupancy);
            pscreate.setInt(3, roomTypeID);
            pscreate.setBoolean(4, availability);
            pscreate.setInt(5, hotelID);
            pscreate.setInt(6, roomNo);

            pscreate.executeUpdate();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,ex);
            return false;
        }

        
    }
    
    public static int getRoomTypeIDFromHotelRoomNo(int hotelID, int roomNo){
        int roomTypeID = 0;
        ResultSet rs = null;
        try{
            PreparedStatement ps = Connect.connection.prepareStatement("SELECT roomTypeID FROM Rooms WHERE (roomNo = ? AND hotelID = ?)");
            ps.setInt(1,roomNo);
            ps.setInt(2,hotelID);
            rs = ps.executeQuery();
            while(rs.next()){
                roomTypeID = rs.getInt("roomTypeID");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return roomTypeID;
    }

    public static boolean updateRoomAvailability(int roomNo,  int hotelID, boolean availability) {

        try {
            PreparedStatement pscreate = Connect.connection.prepareStatement("UPDATE Rooms "+
                    "SET availability = ? "+
                    "WHERE (hotelID = ? and roomNo = ?)");
            pscreate.setBoolean(1, availability);
            pscreate.setInt(2, hotelID);
            pscreate.setInt(3, roomNo);

            pscreate.executeUpdate();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,ex);
            return false;
        }

    }
    
    public static boolean deleteRoom(int hotelID, int roomNo) {

        try {
            PreparedStatement pscreate = Connect.connection.prepareStatement("DELETE from Rooms WHERE hotelID = ? and roomNo = ?");
            pscreate.setInt(1, hotelID);
            pscreate.setInt(2, roomNo);

            pscreate.executeUpdate();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,ex);
            return false;
        }

        
    }
    
    public static ResultSet viewAllRooms(int hotelID){
        ResultSet resultSet = null;
        try
        {
            PreparedStatement statement = Connect.connection.prepareStatement("select * from Rooms where hotelID = ?");
            statement.setInt(1, hotelID);
            resultSet = statement.executeQuery();
            
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,ex);
        }
        
        return resultSet;
        
    }
    
    public static ArrayList<Room> getAllRoomsList(int hotelID){
        ArrayList<Room> roomsList = new ArrayList<Room>();
        int tempHotelID, tempRoomTypeID, tempRoomNo, tempMaxAllowedOccupancy;
        double tempRoomRates;
        boolean tempAvailability;
        ResultSet resultSet = null;
        try
        {
            PreparedStatement preparedStatement = Connect.connection.prepareStatement("select * from Rooms where hotelID = ?");
            preparedStatement.setInt(1, hotelID);
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                tempHotelID = resultSet.getInt("hotelID");
                tempRoomTypeID = resultSet.getInt("roomTypeID");
                tempRoomNo = resultSet.getInt("roomNo");
                tempRoomRates = resultSet.getDouble("roomRates");
                tempMaxAllowedOccupancy = resultSet.getInt("maxAllowedOccupancy");
                tempAvailability = resultSet.getBoolean("availability");
                roomsList.add(new Room( tempMaxAllowedOccupancy, tempRoomRates, tempHotelID, tempRoomTypeID, tempRoomNo, tempAvailability));
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
            //JOptionPane.showMessageDialog(null,ex);
        }
        
        return roomsList;
        
    }
    
    public static ResultSet getAvailableRoomsInHotel(int hotelID){
        ResultSet resultSet = null;
        try
        {
            PreparedStatement preparedStatement = 
                    Connect.connection.prepareStatement(
                        "SELECT roomNo, roomTypeName, roomRates, maxAllowedOccupancy " +
                        "From Rooms, RoomTypes " +
                        "WHERE( (roomNo, hotelID) NOT IN (SELECT Rooms.roomNo, Rooms.hotelID " +
                                              "FROM Rooms, CheckIns " +
                                              "WHERE Rooms.roomNo=CheckIns.roomNo AND Rooms.hotelID = CheckIns.hotelID AND (CheckIns.checkOutDateTime IS NULL OR CheckIns.checkOutDateTime=\"0000-00-00 00:00:00\" )) "+
                        "AND Rooms.roomTypeID = RoomTypes.roomTypeID AND hotelID=? and Rooms.availability is true );"
                    );
            preparedStatement.setInt(1, hotelID);
            resultSet = preparedStatement.executeQuery();
            
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,ex);
        }
        
        return resultSet;
    }
    
    public static ResultSet getAvailableRoomsInHotelByRoomTypes(int hotelID, int roomTypeID){
        ResultSet resultSet = null;
        try
        {
            PreparedStatement preparedStatement = 
                    Connect.connection.prepareStatement(
                        "SELECT roomNo, roomTypeName, roomRates, maxAllowedOccupancy " +
                        "From Rooms, RoomTypes " +
                        "WHERE( (roomNo, hotelID) NOT IN (SELECT Rooms.roomNo, Rooms.hotelID " +
                                              "FROM Rooms, CheckIns " +
                                              "WHERE Rooms.roomNo=CheckIns.roomNo AND Rooms.hotelID = CheckIns.hotelID AND (CheckIns.checkOutDateTime IS NULL OR CheckIns.checkOutDateTime=\"0000-00-00 00:00:00\" )) "+
                        "AND Rooms.roomTypeID = RoomTypes.roomTypeID AND hotelID = ? AND Rooms.roomTypeID = ? AND Rooms.availability is true );"
                    );
            preparedStatement.setInt(1, hotelID);
            preparedStatement.setInt(2, roomTypeID);
            resultSet = preparedStatement.executeQuery();
            
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,ex);
        }
        
        return resultSet;
    }
}
