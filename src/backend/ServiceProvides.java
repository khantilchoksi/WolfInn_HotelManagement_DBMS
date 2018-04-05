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
public class ServiceProvides {
    private String serviceName;

    public ServiceProvides(String serviceName, int hotelID, int roomTypeID, double ratePerService) {
        this.serviceName = serviceName;
        this.hotelID = hotelID;
        this.roomTypeID = roomTypeID;
        this.ratePerService = ratePerService;
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

        private int serviceID;

    /**
     * Get the value of serviceID
     *
     * @return the value of serviceID
     */
    public int getServiceID() {
        return serviceID;
    }

    /**
     * Set the value of serviceID
     *
     * @param serviceID new value of serviceID
     */
    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

        private double ratePerService;

    /**
     * Get the value of ratePerService
     *
     * @return the value of ratePerService
     */
    public double getRatePerService() {
        return ratePerService;
    }

    /**
     * Set the value of ratePerService
     *
     * @param ratePerService new value of ratePerService
     */
    public void setRatePerService(double ratePerService) {
        this.ratePerService = ratePerService;
    }

    public ServiceProvides(int hotelID, int roomTypeID, int serviceID, double ratePerService) {
        this.hotelID = hotelID;
        this.roomTypeID = roomTypeID;
        this.serviceID = serviceID;
        this.ratePerService = ratePerService;
    }

    
    
    
    //Return Newly created room id or return -1 if error  
    public static boolean createServiceProvides(int roomTypeID, int hotelID, int serviceID, double ratePerService) {

        try {
            PreparedStatement pscreate = Connect.connection.prepareStatement("insert into ServiceProvides(roomTypeID, hotelID, serviceID, ratePerService) values(?,?,?,?)");
            pscreate.setInt(3, serviceID);
            pscreate.setInt(1, roomTypeID);
            pscreate.setInt(2, hotelID);
            pscreate.setDouble(4, ratePerService);

            pscreate.executeUpdate();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,ex);
            return false;
        }

        
    }
    
    public static boolean updateServiceProvideDetails(int roomTypeID, int hotelID,int serviceID, double ratePerService) {

        try {
            PreparedStatement pscreate = Connect.connection.prepareStatement("UPDATE ServiceProvides "+
                    "SET ratePerService = ?"+
                    "WHERE hotelID = ? and roomTyepID = ? and serviceID = ?");
            pscreate.setDouble(1, ratePerService);
            pscreate.setInt(4, serviceID);
            pscreate.setInt(3, roomTypeID);
            pscreate.setInt(2, hotelID);

            pscreate.executeUpdate();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,ex);
            return false;
        }

        
    }
    
    public static boolean deleteServiceProvides(int hotelID, int roomTypeID, int serviceID) {

        try {
            PreparedStatement pscreate = Connect.connection.prepareStatement("DELETE from ServiceProvides WHERE hotelID = ? and roomTypeID = ? and serviceID = ?");
            pscreate.setInt(1, hotelID);
            pscreate.setInt(2, roomTypeID);
            pscreate.setInt(3, serviceID);

            pscreate.executeUpdate();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,ex);
            return false;
        }

        
    }
    
    public static ResultSet viewAllServicesForHotelRoomTypes(int hotelID, int roomTypeID){
        ResultSet resultSet = null;
        try
        {
            PreparedStatement statement = Connect.connection.prepareStatement("select * from ServiceProvides, Services where ServiceProvides.serviceID = Services.serviceID and hotelID = ? and roomTypeID = ?");
            statement.setInt(1, hotelID);
            statement.setInt(2, roomTypeID);
            resultSet = statement.executeQuery();
            
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,ex);
        }
        
        return resultSet;
        
    }
    
    public static ArrayList<ServiceProvides> getAllHotelRoomServicesList(int hotelID, int roomTypeID){
        ArrayList<ServiceProvides> hotelRoomServicesList = new ArrayList<ServiceProvides>();
        int tempHotelID, tempRoomTypeID; 
        String tempServiceName;
        double tempRatePerService;
        ResultSet resultSet = null;
        try
        {
            PreparedStatement preparedStatement = Connect.connection.prepareStatement("select * from ServiceProvides, Services where ServiceProvides.serviceID = Services.serviceID and hotelID = ? and roomTypeID = ?");
            preparedStatement.setInt(1, hotelID);
            preparedStatement.setInt(2, roomTypeID);
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                tempHotelID = resultSet.getInt("hotelID");
                tempRoomTypeID = resultSet.getInt("roomTypeID");
                tempRatePerService = resultSet.getDouble("ratePerService");
                tempServiceName= resultSet.getString("serviceName");
                hotelRoomServicesList.add(new ServiceProvides( tempServiceName, tempHotelID, tempRoomTypeID, tempRatePerService));
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
            //JOptionPane.showMessageDialog(null,ex);
        }
        
        return hotelRoomServicesList;
        
    }
    
    
}
