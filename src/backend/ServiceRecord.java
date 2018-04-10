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

    public ServiceRecord(int recordID, int checkInID, int serviceID, int staffID, int quantity, Date datetime) {
        this.recordID = recordID;
        this.checkInID = checkInID;
        this.serviceID = serviceID;
        this.staffID = staffID;
        this.quantity = quantity;
        this.datetime = datetime;
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

    public static boolean createServiceRecords(int checkInID, int serviceID, int quantity) {
        try {
            PreparedStatement pscreate = Connect.connection.prepareStatement("insert into ServiceProvides(checkInID, serviceID, quantity, dateTime) values(?,?,?,NOW())");
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
                    "FROM ServiceProvides,CheckIns,Rooms,Services"+
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
    
    public static ArrayList<CheckIn> getActiveCheckIns(int hotelID){
        ArrayList<CheckIn> activeCheckIns = new ArrayList<CheckIn>();
        ResultSet rs = null;
        int tempcheckInID,tempRoomNo;
        String customerName;
        
        try{
            PreparedStatement ps = Connect.connection.prepareStatement("SELECT CheckIns.checkInID, Customers.customerFirstName, CheckIns.roomNo"+
                    "FROM CheckIns, Customers"+
                    "WHERE (CheckIns.hotelID = ? and CheckIns.customerID = Customers.customerID and CheckIns.checkOutDateTime =\"0000-00-00 00:00:00\")");
            ps.setInt(1, hotelID);
            rs = ps.executeQuery();
            while(rs.next()){
                tempcheckInID = rs.getInt("checkInID");
                tempRoomNo = rs.getInt("roomNo");
                customerName = rs.getString("customerFirstName");
                activeCheckIns.add(new CheckIn(tempcheckInID, tempRoomNo, customerName));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return activeCheckIns;
    }
    
}
