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
public class Services {

    public Services(int serviceID, String serviceName) {
        this.serviceID = serviceID;
        this.serviceName = serviceName;
    }
    
    @Override
    public String toString(){
        return "" + serviceName ;
    }
    
    private int serviceID;
    
    private String serviceName;

    /**
     * Get the value of serviceName
     *
     * @return the value of serviceName
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * Set the value of serviceName
     *
     * @param serviceName new value of serviceName
     */
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

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

    
    
    
    //Return Newly created room Type id or return -1 if error  
    public static boolean createService(String serviceName) {

        try {
            PreparedStatement pscreate1 = Connect.connection.prepareStatement("INSERT into Services(serviceName) values(?)");
            pscreate1.setString(1, serviceName);

            pscreate1.executeUpdate();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,ex);
            return false;
        }

        
    }
    
    public static boolean updateServiceDetails(int serviceID, String serviceName) {

        try {
            PreparedStatement pscreate1 = Connect.connection.prepareStatement("UPDATE Services"+
                    "SET serviceName = ?"+
                    "WHERE serviceID = ?");
            pscreate1.setString(1, serviceName);
            pscreate1.setInt(2, serviceID);

            pscreate1.executeUpdate();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,ex);
            return false;
        }

        
    }
    
    public static boolean deleteService(int serviceID) {

        try {
            PreparedStatement pscreate1 = Connect.connection.prepareStatement("DELETE from Services WHERE serviceID = ?");
            pscreate1.setInt(1, serviceID);

            pscreate1.executeUpdate();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,ex);
            return false;
        }

        
    }
    
    public static ResultSet viewAllServices(){
        ResultSet resultSet = null;
        try
        {
            PreparedStatement statement = Connect.connection.prepareStatement("select * from Services");
            resultSet = statement.executeQuery();
            
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,ex);
        }
        
        return resultSet;
        
    }
    
    public static ArrayList<Services> getAllServiceList(){
        ArrayList<Services> servicesList = new ArrayList<Services>();
        int tempServiceID;
        String tempServiceName;
        ResultSet resultSet = null;
        try
        {
            PreparedStatement preparedStatement = Connect.connection.prepareStatement("select * from Services");
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                tempServiceName = resultSet.getString("serviceName");
                tempServiceID = resultSet.getInt("serviceID");
                servicesList.add(new Services( tempServiceID, tempServiceName));
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
            //JOptionPane.showMessageDialog(null,ex);
        }
        
        return servicesList;
        
    }
    
    
    
    
}
