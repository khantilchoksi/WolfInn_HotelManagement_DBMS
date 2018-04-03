/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author khantil
 */
public class Hotels {

    //Return Newly created hotel id or return -1 if error 
    int createHotel(String hotelName, String hotelStreetAddress, int cityID, int zipCode, String phoneNumber) {

        try {
            PreparedStatement pscreate = Connect.connection.prepareStatement("insert into Hotels(hotelName, hotelStreetAddress, cityID, zipCode, phoneNumber) values(?,?,?,?,?)");
            pscreate.setString(1, hotelName);
            pscreate.setString(2, hotelStreetAddress);
            pscreate.setInt(3, cityID);
            pscreate.setInt(4, zipCode);
            pscreate.setString(5, phoneNumber);

            pscreate.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            //JOptionPane.showMessageDialog(null,ex);
        }

        return 1;
    }
    
    public static ResultSet viewAllHotels(){
        ResultSet resultSet = null;
        try
        {
            Statement statement = Connect.connection.createStatement();
            resultSet = statement.executeQuery("select * from hotels order by hotelID");
            
        }catch(Exception ex){
            ex.printStackTrace();
            //JOptionPane.showMessageDialog(null,ex);
        }
        
        return resultSet;
        
    }

}
