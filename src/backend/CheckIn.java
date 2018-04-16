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
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author khantil
 */
public class CheckIn {

    public CheckIn(int checkInID, int roomNo, String customerName) {
        this.checkInID = checkInID;
        this.roomNo = roomNo;
        this.customerName = customerName;
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

    private double totalRoomCost;

    /**
     * Get the value of totalRoomCost
     *
     * @return the value of totalRoomCost
     */
    public double getTotalRoomCost() {
        return totalRoomCost;
    }

    /**
     * Set the value of totalRoomCost
     *
     * @param totalRoomCost new value of totalRoomCost
     */
    public void setTotalRoomCost(double totalRoomCost) {
        this.totalRoomCost = totalRoomCost;
    }

    
    private double totalServiceCost;

    /**
     * Get the value of totalServiceCost
     *
     * @return the value of totalServiceCost
     */
    public double getTotalServiceCost() {
        return totalServiceCost;
    }

    /**
     * Set the value of totalServiceCost
     *
     * @param totalServiceCost new value of totalServiceCost
     */
    public void setTotalServiceCost(double totalServiceCost) {
        this.totalServiceCost = totalServiceCost;
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

        private int customerID;

    /**
     * Get the value of customerID
     *
     * @return the value of customerID
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     * Set the value of customerID
     *
     * @param customerID new value of customerID
     */
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

        private int roomNo;

    /**
     * Get the value of roomNo
     *
     * @return the value of roomNo
     */
    public int getRoomNo() {
        return roomNo;
    }

    /**
     * Set the value of roomNo
     *
     * @param roomNo new value of roomNo
     */
    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
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

        private int numberOfGuests;

    /**
     * Get the value of numberOfGuests
     *
     * @return the value of numberOfGuests
     */
    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    /**
     * Set the value of numberOfGuests
     *
     * @param numberOfGuests new value of numberOfGuests
     */
    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

        private Date checkInDateTime;

    /**
     * Get the value of checkInDateTime
     *
     * @return the value of checkInDateTime
     */
    public Date getCheckInDateTime() {
        return checkInDateTime;
    }

    /**
     * Set the value of checkInDateTime
     *
     * @param checkInDateTime new value of checkInDateTime
     */
    public void setCheckInDateTime(Date checkInDateTime) {
        this.checkInDateTime = checkInDateTime;
    }

        private Date checkOutDateTime;

    /**
     * Get the value of checkOutDateTime
     *
     * @return the value of checkOutDateTime
     */
    public Date getCheckOutDateTime() {
        return checkOutDateTime;
    }

    /**
     * Set the value of checkOutDateTime
     *
     * @param checkOutDateTime new value of checkOutDateTime
     */
    public void setCheckOutDateTime(Date checkOutDateTime) {
        this.checkOutDateTime = checkOutDateTime;
    }

        private String customerName;

    /**
     * Get the value of customerName
     *
     * @return the value of customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Set the value of customerName
     *
     * @param customerName new value of customerName
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString(){
        return " Room:" + this.roomNo + "- Name:" + this.customerName;
    }
    
    public static int createCheckIn(int customerID, int roomNo, int hotelID, int staffID, int numberOfGuests) {

        
        try {
            PreparedStatement pscreate = Connect.connection.prepareStatement("insert into CheckIns(customerID, roomNo, hotelID, staffID, checkInDateTime, numberOfGuests) values(?,?,?,?,NOW(),?)",Statement.RETURN_GENERATED_KEYS);
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
    
    //Create checkin without front desk representative
    public static int createCheckIn(int customerID, int roomNo, int hotelID, int numberOfGuests) {

        
        try {
            PreparedStatement pscreate = Connect.connection.prepareStatement("insert into CheckIns(customerID, roomNo, hotelID, checkInDateTime, numberOfGuests) values(?,?,?,NOW(),?)",Statement.RETURN_GENERATED_KEYS);
            pscreate.setInt(1, customerID);
            pscreate.setInt(2, roomNo);
            pscreate.setInt(3, hotelID);
            pscreate.setInt(4, numberOfGuests);

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
    
    public static double getRoomCost(int checkInID){
        ResultSet rs = null;
        double roomCost = 0;
        try{
            PreparedStatement pstotal = Connect.connection.prepareStatement("SELECT DATEDIFF( NOW(), CheckIns.checkInDateTime)*Rooms.roomRates AS totalStayCost " +
                "FROM CheckIns,Rooms " +
                "WHERE CheckIns.checkInID = ? " +
                    "AND CheckIns.roomNo = Rooms.roomNo " +
                    "AND CheckIns.hotelID = Rooms.hotelID");
            pstotal.setInt(1, checkInID);
            rs = pstotal.executeQuery();
            if(rs.next()){
                roomCost = rs.getDouble("totalStayCost");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return roomCost;
    }
    
    public double getTotalDiscount(){
        double discount = 0.0;
        double discountAmount = 0.0;
        discount = Bill.getDiscountPercent(this.checkInID);
        discountAmount = (this.totalRoomCost + this.totalServiceCost)*(discount/100);
        return discount;
    }
    
    public double getTotalBillAmount(){
        double discount = this.getTotalDiscount();
        double total = this.totalRoomCost + this.totalServiceCost - discount;
        this.totalCost = total;
        return total;
    }
    
    public static boolean doCheckOut(int checkInID){
        boolean status = false;
        try{
                PreparedStatement psupdate = Connect.connection.prepareStatement("UPDATE CheckIns " +
                        "SET checkOutDateTime = NOW() " +
                        "WHERE checkInID = ?");
                psupdate.setInt(1, checkInID);
                status = psupdate.execute();
                status = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return status;
    }
    
    public static CheckIn getCheckInFromID(int checkInID){
        CheckIn checkIn = null;
        ResultSet rs = null;
        try{
            PreparedStatement psget = Connect.connection.prepareStatement("Select * FROM CheckIns WHERE checkInID = ?");
            psget.setInt(1, checkInID);
            rs = psget.executeQuery();
            checkIn.setCheckInID(rs.getInt("checkInID"));
            checkIn.setCheckOutDateTime(rs.getDate("checkOutDateTime"));
            checkIn.setCheckInDateTime(rs.getDate("checkInDateTime"));
            checkIn.setCustomerID(rs.getInt("customerID"));
            checkIn.setHotelID(rs.getInt("hotelID"));
            checkIn.setNumberOfGuests(rs.getInt("numberOfGuests"));
            checkIn.setRoomNo(rs.getInt("roomNo"));
            checkIn.setStaffID(rs.getInt("staffID"));
        }catch(Exception e){
            e.printStackTrace();
        }
        return checkIn;
    }
    
    public static ArrayList<CheckIn> getActiveCheckIns(int hotelID){
        ArrayList<CheckIn> activeCheckIns = new ArrayList<CheckIn>();
        ResultSet rs = null;
        int tempcheckInID,tempRoomNo;
        String tempCustomerName;
        
        try{
            PreparedStatement ps = Connect.connection.prepareStatement("SELECT CheckIns.checkInID, Customers.customerFirstName, CheckIns.roomNo "+
                    "FROM CheckIns, Customers "+
                    "WHERE CheckIns.hotelID = ? AND CheckIns.customerID = Customers.customerID AND (CheckIns.checkOutDateTime =\"0000-00-00 00:00:00\" OR CheckIns.checkOutDateTime IS NULL)");
            ps.setInt(1, hotelID);
            rs = ps.executeQuery();
            
            while(rs.next()){
                tempcheckInID = rs.getInt("checkInID");
                tempRoomNo = rs.getInt("roomNo");
                tempCustomerName = rs.getString("customerFirstName");
                activeCheckIns.add(new CheckIn(tempcheckInID, tempRoomNo, tempCustomerName));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return activeCheckIns;
    }
    
    public static ArrayList<CheckIn> getAllCheckIns(int hotelID){
        ArrayList<CheckIn> activeCheckIns = new ArrayList<CheckIn>();
        ResultSet rs = null;
        int tempcheckInID,tempRoomNo;
        String tempCustomerName;
        
        try{
            PreparedStatement ps = Connect.connection.prepareStatement("SELECT CheckIns.checkInID, Customers.customerFirstName, CheckIns.roomNo "+
                    "FROM CheckIns, Customers "+
                    "WHERE CheckIns.hotelID = ? AND CheckIns.customerID = Customers.customerID ");
            ps.setInt(1, hotelID);
            rs = ps.executeQuery();
            
            while(rs.next()){
                tempcheckInID = rs.getInt("checkInID");
                tempRoomNo = rs.getInt("roomNo");
                tempCustomerName = rs.getString("customerFirstName");
                activeCheckIns.add(new CheckIn(tempcheckInID, tempRoomNo, tempCustomerName));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return activeCheckIns;
    }
    
    public static ArrayList<CheckIn> getActivePresidentialCheckIns(int hotelID){
        ArrayList<CheckIn> activeCheckIns = new ArrayList<CheckIn>();
        ResultSet rs = null;
        int tempcheckInID,tempRoomNo;
        String tempCustomerName;
        
        try{
            PreparedStatement ps = Connect.connection.prepareStatement("SELECT DISTINCT CheckIns.checkInID, Customers.customerFirstName, CheckIns.roomNo "+
                    "FROM CheckIns, Customers, Rooms, RoomTypes "+
                    "WHERE CheckIns.hotelID = ? AND CheckIns.hotelID = Rooms.hotelID AND CheckIns.roomNo = Rooms.roomNo AND Rooms.roomTypeID = 4 AND CheckIns.customerID = Customers.customerID AND (CheckIns.checkOutDateTime =\"0000-00-00 00:00:00\" OR CheckIns.checkOutDateTime IS NULL)");
            ps.setInt(1, hotelID);
            rs = ps.executeQuery();
            
            while(rs.next()){
                tempcheckInID = rs.getInt("checkInID");
                tempRoomNo = rs.getInt("roomNo");
                tempCustomerName = rs.getString("customerFirstName");
                activeCheckIns.add(new CheckIn(tempcheckInID, tempRoomNo, tempCustomerName));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return activeCheckIns;
    }
}