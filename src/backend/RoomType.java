/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author patel
 */
public class RoomType {

    public RoomType(String roomTypeName, int roomTypeID) {
        this.roomTypeName = roomTypeName;
        this.roomTypeID = roomTypeID;
    }
    
    
    private String roomTypeName;

    /**
     * Get the value of roomTypeName
     *
     * @return the value of roomTypeName
     */
    public String getRoomTypeName() {
        return roomTypeName;
    }

    /**
     * Set the value of roomTypeName
     *
     * @param roomTypeName new value of roomTypeName
     */
    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
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
    
    
    
    
    //Return Newly created room Type id or return -1 if error  
    public static boolean createRoomType(String roomTypeName) {

        try {
            PreparedStatement pscreate = Connect.connection.prepareStatement("insert into RoomTypes(roomTypeName) values(?)");
            pscreate.setString(1, roomTypeName);

            pscreate.executeUpdate();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,ex);
            return false;
        }

        
    }
    
    public static boolean updateRoomTypeDetails(int roomTypeID, String roomTypeName) {

        try {
            PreparedStatement pscreate = Connect.connection.prepareStatement("UPDATE RoomTypes "+
                    "SET roomTypeName = ?"+
                    "WHERE roomTypeID = ?");
            pscreate.setString(1, roomTypeName);
            pscreate.setInt(2, roomTypeID);

            pscreate.executeUpdate();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,ex);
            return false;
        }

        
    }
    
    public static boolean deleteRoomType(int roomTypeID) {

        try {
            PreparedStatement pscreate = Connect.connection.prepareStatement("DELETE from RoomTypes WHERE roomTypeID = ?");
            pscreate.setInt(1, roomTypeID);

            pscreate.executeUpdate();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,ex);
            return false;
        }

        
    }
    
    public static ResultSet viewAllRoomTypes(){
        ResultSet resultSet = null;
        try
        {
            PreparedStatement statement = Connect.connection.prepareStatement("select * from RoomTypes");
            resultSet = statement.executeQuery();
            
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,ex);
        }
        
        return resultSet;
        
    }
    
    public static ArrayList<RoomType> getAllRoomsList(){
        ArrayList<RoomType> roomTypesList = new ArrayList<RoomType>();
        int tempRoomTypeID;
        String tempRoomTypeName;
        ResultSet resultSet = null;
        try
        {
            PreparedStatement preparedStatement = Connect.connection.prepareStatement("select * from RoomTypes");
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                tempRoomTypeName = resultSet.getString("roomTypeName");
                tempRoomTypeID = resultSet.getInt("roomTypeID");
                roomTypesList.add(new RoomType( tempRoomTypeName, tempRoomTypeID));
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
            //JOptionPane.showMessageDialog(null,ex);
        }
        
        return roomTypesList;
        
    }
    
    

}
