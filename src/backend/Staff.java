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
public class Staff {
    
    
    public static boolean createStaff(String hotelName, String hotelStreetAddress, int cityID, int zipCode, String phoneNumber) {

        try {
            PreparedStatement pscreate = Connect.connection.prepareStatement("insert into Hotels(hotelName, hotelStreetAddress, cityID, zipCode, phoneNumber) values(?,?,?,?,?)");
            pscreate.setString(1, hotelName);
            pscreate.setString(2, hotelStreetAddress);
            pscreate.setInt(3, cityID);
            pscreate.setInt(4, zipCode);
            pscreate.setString(5, phoneNumber);

            pscreate.executeUpdate();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,ex);
            return false;
        }

        
    }
    
    public static ResultSet viewAllStaffs(int hotelID){
        ResultSet resultSet = null;
        try
        {
            PreparedStatement psshow = Connect.connection.prepareStatement("SELECT * "+
                    "FROM Staffs "+
                    "WHERE hotelID = ?");
            psshow.setInt(1, hotelID);
            resultSet = psshow.executeQuery();
            
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,ex);
        }
        
        return resultSet;
        
    }
    
    
    
}
