/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.PreparedStatement;
import java.util.Date;
import javax.swing.JOptionPane;
import backend.*;
import java.sql.ResultSet;
import java.util.*;

/**
 *
 * @author patel
 */
public class ServiceRecord {
    
    public ServiceRecord(int recordID, int checkInID, int serviceID, int staffID, int quantity, Date datetime, String serviceName) {
        this.recordID = recordID;
        this.checkInID = checkInID;
        this.serviceID = serviceID;
        this.staffID = staffID;
        this.quantity = quantity;
        this.datetime = datetime;
        this.serviceName = serviceName;
                
    }

    public ServiceRecord(String serviceName, double totalCost, int quantity, Date datetime) {
        this.serviceName = serviceName;
        this.totalCost = totalCost;
        this.quantity = quantity;
        this.datetime = datetime;
    }
    
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

    
    private double totalCost;

    /**
     * Get the value of totalCost
     *
     * @return the value of totalCost
     */
    public double getTotalCost() {
        return totalCost;
    }

    /**
     * Set the value of totalCost
     *
     * @param totalCost new value of totalCost
     */
    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    
    private int recordID;

    /**
     * Get the value of recordID
     *
     * @return the value of recordID
     */
    public int getRecordID() {
        return recordID;
    }

    /**
     * Set the value of recordID
     *
     * @param recordID new value of recordID
     */
    public void setRecordID(int recordID) {
        this.recordID = recordID;
    }

    private int checkInID;

    /**
     * Get the value of checkInID
     *
     * @return the value of checkInID
     */
    public int getCheckInID() {
        return checkInID;
    }

    /**
     * Set the value of checkInID
     *
     * @param checkInID new value of checkInID
     */
    public void setCheckInID(int checkInID) {
        this.checkInID = checkInID;
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

    private int staffID;

    /**
     * Get the value of staffID
     *
     * @return the value of staffID
     */
    public int getStaffID() {
        return staffID;
    }

    /**
     * Set the value of staffID
     *
     * @param staffID new value of staffID
     */
    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

        private int quantity;

    /**
     * Get the value of quantity
     *
     * @return the value of quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Set the value of quantity
     *
     * @param quantity new value of quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

        private Date datetime;

    /**
     * Get the value of datetime
     *
     * @return the value of datetime
     */
    public Date getDatetime() {
        return datetime;
    }

    /**
     * Set the value of datetime
     *
     * @param datetime new value of datetime
     */
    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
    
    @Override
    public String toString() {
        return "" + recordID + " - " + serviceName + ": Qty-" + quantity;
    }

    public static boolean createServiceRecords(int checkInID, int serviceID, int quantity) {
        try {
            PreparedStatement pscreate = Connect.connection.prepareStatement("insert into ServiceRecords(checkInID, serviceID, quantity, dateTime) values(?,?,?,NOW())");
            pscreate.setInt(3, quantity);
            pscreate.setInt(1, checkInID);
            pscreate.setInt(2, serviceID);

            pscreate.executeUpdate();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,ex);
            return false;
        } 
    }
    
    public static ArrayList<Services> getServices(int checkInID){
        ResultSet resultSet = null;
        int tempServiceID;
        String tempServiceName;
        ArrayList<Services> checkInServiceList = new ArrayList<Services>();
        try
        {
            PreparedStatement psshow = Connect.connection.prepareStatement("SELECT Services.serviceID, Services.serviceName "+
                    "FROM ServiceProvides, CheckIns, Rooms, Services "+
                    "WHERE (CheckIns.checkInID = ? and CheckIns.roomNo = Rooms.roomNo and CheckIns.hotelID = Rooms.hotelID and Rooms.roomTypeID = ServiceProvides.roomTypeID and Rooms.hotelID = ServiceProvides.hotelID and ServiceProvides.serviceID = Services.serviceID)");
            psshow.setInt(1, checkInID);
            resultSet = psshow.executeQuery();
            while(resultSet.next()){
                tempServiceID = resultSet.getInt("serviceID");
                tempServiceName = resultSet.getString("serviceName");
                checkInServiceList.add(new Services(tempServiceID, tempServiceName));
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,ex);
        }        
        return checkInServiceList; 
    }
   
    
    public static boolean updateServiceProvides(int hotelID, int roomTypeID, int serviceID, double ratePerService){
        try{
            PreparedStatement ps = Connect.connection.prepareStatement("Update ServiceProvides"+
                    "SET ratePerService = ?"+ 
                    "WHERE (hotelID = ? and roomTypeID = ? and serviceID = ?)");
            ps.setDouble(1, ratePerService);
            ps.setInt(2, hotelID);
            ps.setInt(3, roomTypeID);
            ps.setInt(4, serviceID);
            ps.executeQuery();
            return(true);
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean updateServiceRecords(int serviceRecordID, int serviceID, int quantity){
        try{
            PreparedStatement ps = Connect.connection.prepareStatement("Update ServiceRecords "+
                    "SET quantity = ?, serviceID = ? "+ 
                    "WHERE (recordID = ?)");
            ps.setDouble(1, quantity);
            ps.setInt(3, serviceRecordID);
            ps.setInt(2, serviceID);
            ps.executeQuery();
            return(true);
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public static ResultSet viewServices(int hotelID, int checkInID){
        ResultSet resultSet = null;
        try
        {
            PreparedStatement psshow = Connect.connection.prepareStatement("SELECT ServiceRecords.checkInID, Services.serviceName, "
                    + "ServiceRecords.quantity, ServiceRecords.dateTime "+
                    "FROM Services, ServiceRecords "+
                    "WHERE checkInID = ? AND Services.serviceID = ServiceRecords.serviceID "
                    + "ORDER BY dateTime;");
            psshow.setInt(1, checkInID);
            resultSet = psshow.executeQuery();
            
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,ex);
        }        
        return resultSet;   
    }
    
    public static ResultSet getServiceRecordsForCheckIns(int checkInID){
        ResultSet rs = null;
        try{
            PreparedStatement psDisplay = Connect.connection.prepareStatement("SELECT Services.serviceName, ServiceRecords.quantity, ServiceProvides.ratePerService AS CostOfEachItem, (ServiceProvides.ratePerService*ServiceRecords.quantity) AS TotalServiceCost, ServiceRecords.dateTime " +
                "FROM ServiceRecords, ServiceProvides, CheckIns, Rooms, Services " +
                "WHERE (ServiceRecords.checkInID = ? " +
                    "AND ServiceRecords.checkInID = CheckIns.checkInID " +
                    "AND ServiceRecords.serviceID = ServiceProvides.serviceID " +
                    "AND CheckIns.roomNo = Rooms.roomNo " +
                    "AND CheckIns.hotelID = ServiceProvides.hotelID " +
                    "AND Rooms.roomTypeID = ServiceProvides.roomTypeID " +
                    "AND ServiceRecords.serviceID = Services.serviceID " +
                    "AND Rooms.hotelID = CheckIns.hotelID)");
            psDisplay.setInt(1, checkInID);
            rs = psDisplay.executeQuery();
        }catch(Exception e){
            e.printStackTrace();
        }
        return rs;
    }
    
    public static ArrayList<ServiceRecord> getServiceRecordsList(int checkInID){
        ResultSet resultSet = null;
        int tempRecordID;
        int tempServiceID;
        int tempCheckInID;
        int tempQuantity;
        int tempStaffID;
        String tempServiceName;
        Date tempDateTime;
        ArrayList<ServiceRecord> serviceRecordList = new ArrayList<ServiceRecord>();
        
        try
        {
            PreparedStatement preparedStatement = Connect.connection.prepareStatement("SELECT * FROM ServiceRecords, Services  "
                    + "WHERE ServiceRecords.checkInID = ? AND ServiceRecords.serviceID = Services.serviceID "
                    + "ORDER BY ServiceRecords.dateTime DESC");
            preparedStatement.setInt(1, checkInID);
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                tempRecordID = resultSet.getInt("recordID");
                tempServiceID = resultSet.getInt("serviceID");
                tempCheckInID = resultSet.getInt("checkInID");
                tempStaffID = resultSet.getInt("staffID");
                tempQuantity = resultSet.getInt("quantity");
                tempDateTime = resultSet.getDate("dateTime");
                tempServiceName = resultSet.getString("serviceName");
                serviceRecordList.add(new ServiceRecord(tempRecordID, tempCheckInID, tempServiceID, tempStaffID, tempQuantity, tempDateTime,tempServiceName));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return serviceRecordList;
    }
    
    public static double getTotalServiceCost(int checkInID){
        double totalCost = 0;
        ResultSet rs = null;
        try{
            PreparedStatement psDisplay = Connect.connection.prepareStatement("SELECT SUM(ServiceProvides.ratePerService*ServiceRecords.quantity) AS TotalServiceCost " +
                "FROM ServiceRecords, ServiceProvides, CheckIns, Rooms " +
                "WHERE (ServiceRecords.checkInID = ? " +
                    "AND ServiceRecords.checkInID = CheckIns.checkInID " +
                    "AND ServiceRecords.serviceID = ServiceProvides.serviceID " +
                    "AND CheckIns.roomNo = Rooms.roomNo " +
                    "AND CheckIns.hotelID = ServiceProvides.hotelID " +
                    "AND Rooms.roomTypeID = ServiceProvides.roomTypeID " +
                    "AND Rooms.hotelID = CheckIns.hotelID)");
            psDisplay.setInt(1, checkInID);
            rs = psDisplay.executeQuery();
            
            if(rs.next()){
                totalCost = rs.getDouble("TotalServiceCost");
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return totalCost;
    }
}
