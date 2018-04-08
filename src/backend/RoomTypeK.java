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
 * @author khantil
 */
public class RoomTypeK {
    int roomTypeID;
    String roomTypeName;
    
    
    public int getRoomTypeID() {
        return roomTypeID;
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }

    @Override
    public String toString() {
        return  roomTypeName;
    }

    public RoomTypeK(int roomTypeID, String roomTypeName) {
        this.roomTypeID = roomTypeID;
        this.roomTypeName = roomTypeName;
    }
    
    public static ArrayList<RoomTypeK> getRoomTypesList(){
        ArrayList<RoomTypeK> roomTypesList = new ArrayList<RoomTypeK>();
        int tempRoomTypeID, tempStateID;
        String tempRoomTypeName;
        ResultSet resultSet = null;
        try
        {
            PreparedStatement preparedStatement = Connect.connection.prepareStatement("select * from RoomTypes order by roomTypeName");
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                tempRoomTypeID = resultSet.getInt("roomTypeID");
                tempRoomTypeName = resultSet.getString("roomTypeName");
                roomTypesList.add(new RoomTypeK(tempRoomTypeID, tempRoomTypeName));
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,ex);
        }
        
        return roomTypesList;
        
        
    }
}
