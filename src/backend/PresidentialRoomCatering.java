/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author patel
 */
public class PresidentialRoomCatering {

    public PresidentialRoomCatering(int staffID, int checkInID, String staffName) {
        this.staffID = staffID;
        this.checkInID = checkInID;
        this.staffName = staffName;
    }
    
    
    private int staffID;
    
    private int checkInID;

    private String staffName;

    /**
     * Get the value of staffName
     *
     * @return the value of staffName
     */
    public String getStaffName() {
        return staffName;
    }

    /**
     * Set the value of staffName
     *
     * @param staffName new value of staffName
     */
    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

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

    
    
    public static boolean assignCaterer(int checkInID,int staffID){
        boolean status = false;
        try{
            PreparedStatement pscreate = Connect.connection.prepareStatement("INSERT INTO PresidentialCatering(checkInID, staffID) VALUES(?,?)");
            pscreate.setInt(1, checkInID);
            pscreate.setInt(2, staffID);
            status = pscreate.execute();
                    
        }catch(Exception e){
            e.printStackTrace();
        }
        return status;
    }
    
    public static ResultSet getCatererDetails(int checkIn, int hotelID){
        ResultSet rs = null;
        try{
            PreparedStatement ps = Connect.connection.prepareStatement("SELECT  Staffs.staffFirstName, Staffs.staffLastName "
                    + "FROM PresidentialCatering, Staffs "
                    + "WHERE checkInID = ? AND PresidentialCatering.staffID = Staffs.staffID");
            ps.setInt(1, checkIn);
            rs = ps.executeQuery();
        }catch(Exception e){
            e.printStackTrace();
        }
        return rs;
    }
    
    public static ResultSet getCatererHotelDetails(int hotelID){
        ResultSet rs = null;
        try{
            PreparedStatement ps = Connect.connection.prepareStatement("SELECT  CheckIns.roomNo, Staffs.staffFirstName, Staffs.staffLastName "
                    + "FROM PresidentialCatering, Staffs, CheckIns "
                    + "WHERE CheckIns.hotelID = ? AND CheckIns.checkInID = PresidentialCatering.checkInID AND PresidentialCatering.staffID = Staffs.staffID AND (CheckIns.checkOutDateTime =\"0000-00-00 00:00:00\" OR CheckIns.checkOutDateTime IS NULL)");
            ps.setInt(1, hotelID);
            rs = ps.executeQuery();
        }catch(Exception e){
            e.printStackTrace();
        }
        return rs;
    }
}
