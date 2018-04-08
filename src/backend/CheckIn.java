/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author khantil
 */
public class CheckIn {
    
    public static int createCheckIn(int customerID, int roomNo, int hotelID, int staffID, int numberOfGuests) {

        
        try {
            PreparedStatement pscreate = Connect.connection.prepareStatement("insert into CheckIns(customerID, roomNo, hotelID, staffID, checkInDateTime, numberOfGuests) values(?,?,?,?,NOW() ,?)",Statement.RETURN_GENERATED_KEYS);
            pscreate.setInt(1, customerID);
            pscreate.setInt(2, roomNo);
            pscreate.setInt(3, hotelID);
            pscreate.setInt(4, staffID);
            pscreate.setInt(5, numberOfGuests);

            pscreate.executeUpdate();
            
            ResultSet resultSet = pscreate.getGeneratedKeys();
            if(resultSet != null && resultSet.next()){
                return resultSet.getInt(1);
            }
            
            return -1;
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,ex);
            return -1;
        }

        
    }
}
