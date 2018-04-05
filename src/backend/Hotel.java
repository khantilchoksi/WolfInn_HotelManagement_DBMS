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
 * @author khantil
 */
public class Hotel {

    public int getHotelID() {
        return hotelID;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getHotelStreetAddress() {
        return hotelStreetAddress;
    }

    public int getCityID() {
        return cityID;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "" + hotelID + " - " + hotelName;
    }

    public Hotel(int hotelID, String hotelName, String hotelStreetAddress, int cityID, int zipCode, String phoneNumber) {
        this.hotelID = hotelID;
        this.hotelName = hotelName;
        this.hotelStreetAddress = hotelStreetAddress;
        this.cityID = cityID;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
    }
    
    
    
    int hotelID;
    String hotelName;
    String hotelStreetAddress;
    int cityID;
    int zipCode;
    String phoneNumber;
    

    //Return Newly created hotel id or return -1 if error 
    public static boolean createHotel(String hotelName, String hotelStreetAddress, int cityID, int zipCode, String phoneNumber) {

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
    
    public static boolean updateHotelDetails(int hotelID, String hotelName, String hotelStreetAddress, int cityID, int zipCode, String phoneNumber) {

        try {
            PreparedStatement pscreate = Connect.connection.prepareStatement("UPDATE Hotels "+
                    "SET hotelName = ?, hotelStreetAddress = ?, cityID = ?, zipCode = ?, phoneNumber = ?"+
                    "WHERE hotelID = ?");
            pscreate.setString(1, hotelName);
            pscreate.setString(2, hotelStreetAddress);
            pscreate.setInt(3, cityID);
            pscreate.setInt(4, zipCode);
            pscreate.setString(5, phoneNumber);
            pscreate.setInt(6, hotelID);

            pscreate.executeUpdate();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,ex);
            return false;
        }

        
    }
    
    public static boolean deleteHotel(int hotelID) {

        try {
            PreparedStatement pscreate = Connect.connection.prepareStatement("DELETE from Hotels WHERE hotelID = ?");
            pscreate.setInt(1, hotelID);

            pscreate.executeUpdate();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,ex);
            return false;
        }

        
    }
    
    public static ResultSet viewAllHotels(){
        ResultSet resultSet = null;
        try
        {
            Statement statement = Connect.connection.createStatement();
            resultSet = statement.executeQuery("select * from Hotels order by hotelName");
            
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,ex);
        }
        
        return resultSet;
        
    }
    
    public static ArrayList<Hotel> getAllHotelsList(){
        ArrayList<Hotel> hotelsList = new ArrayList<Hotel>();
        int tempHotelID, tempHotelCityID, tempHotelZipCode;
        String tempHotelName, tempHotelStreetAddress, tempHotelPhoneNumber;
        ResultSet resultSet = null;
        try
        {
            PreparedStatement preparedStatement = Connect.connection.prepareStatement("select * from Hotels order by hotelID");
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                tempHotelID = resultSet.getInt("hotelID");
                tempHotelName = resultSet.getString("hotelName");
                tempHotelStreetAddress = resultSet.getString("hotelStreetAddress");
                tempHotelCityID = resultSet.getInt("cityID");
                tempHotelZipCode = resultSet.getInt("zipCode");
                tempHotelPhoneNumber = resultSet.getString("phoneNumber");
                hotelsList.add(new Hotel(tempHotelID, tempHotelName, tempHotelStreetAddress, tempHotelCityID, tempHotelZipCode, tempHotelPhoneNumber));
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
            //JOptionPane.showMessageDialog(null,ex);
        }
        
        return hotelsList;
        
    }
}
