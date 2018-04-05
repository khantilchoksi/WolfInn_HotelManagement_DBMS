/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Dax Amin
 */
public class Staff {
    
    
    public static boolean createStaff(int hotelID, int staffTypeID, String staffFirstName, String staffLastName, Date birthDate,
            String phoneNumber, String streetAddress, int cityID, int zipCode) {
        
        java.sql.Date sqlBirthDate = new java.sql.Date(birthDate.getTime());

        try {
            PreparedStatement pscreate = Connect.connection.prepareStatement("insert into Staffs(hotelID, stafftypeID, staffFirstName, staffLastName, "+
                    "birthDate, phoneNumber, streetAddress, cityID, zipCode) values(?,?,?,?,?,?,?,?,?)");
            pscreate.setInt(1, hotelID);
            pscreate.setInt(2, staffTypeID);
            pscreate.setString(3, staffFirstName);
            pscreate.setString(4, staffLastName);
            pscreate.setDate(5, sqlBirthDate);
            pscreate.setString(6, phoneNumber);
            pscreate.setString(7, streetAddress);
            pscreate.setInt(8, cityID);
            pscreate.setInt(9, zipCode);

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
