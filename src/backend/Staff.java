/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Dax Amin
 */
public class Staff {
    
    public int getStaffID(){
        return staffID;
    }
    
    public int getDepartmentID(){
        return departmentID;
    }
    
    public String getStaffFirstName(){
        return staffFirstName;
    }
    
    public String getStaffLastName(){
        return staffLastName;
    }
    
    public int getStaffTypeID(){
        return staffTypeID;
    }
    
    public String getFirstName(){
        return staffFirstName;
    }
    
    public String getLastName(){
        return staffLastName;
    }
    
    public Date getBirthDate(){
        return birthDate;
    }
    
    public String getPhoneNumber(){
        return phoneNumber;
    }
    
    public String getAddress(){
        return streetAddress;
    }
    
    public int getCityID(){
        return cityID;
    }
    
    public int getZipCode(){
        return zipCode;
    }
    
    @Override
    public String toString() {
        return "" + staffID + " - " + staffFirstName + " " + staffLastName;
    }
    
    public Staff(int staffID, int hotelID, int staffTypeID, int departmentID, String staffFirstName, String staffLastName, Date birthDate,
            String phoneNumber, String streetAddress, int cityID, int zipCode) {
        this.staffID = staffID;
        this.hotelID = hotelID;
        this.staffTypeID = staffTypeID;
        this.departmentID = departmentID;
        this.staffFirstName = staffFirstName;
        this.staffLastName = staffLastName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.streetAddress = streetAddress;
        this.cityID = cityID;
        this.zipCode = zipCode;
        
    }
    
    int staffID;
    int hotelID;
    int staffTypeID;
    int departmentID;
    String staffFirstName;
    String staffLastName;
    Date birthDate;
    String phoneNumber;
    String streetAddress;
    int cityID;
    int zipCode;
    
    
    public static boolean createStaff(int hotelID, int staffTypeID, int departmentID, String staffFirstName, String staffLastName, Date birthDate,
            String phoneNumber, String streetAddress, int cityID, int zipCode) {
        
        java.sql.Date sqlBirthDate = new java.sql.Date(birthDate.getTime());

        try {
            PreparedStatement pscreate = Connect.connection.prepareStatement("insert into Staffs(hotelID, stafftypeID, departmentID, staffFirstName, staffLastName, "+
                    "birthDate, phoneNumber, streetAddress, cityID, zipCode) values(?,?,?,?,?,?,?,?,?,?)");
            pscreate.setInt(1, hotelID);
            pscreate.setInt(2, staffTypeID);
            pscreate.setInt(3, departmentID);
            pscreate.setString(4, staffFirstName);
            pscreate.setString(5, staffLastName);
            pscreate.setDate(6, sqlBirthDate);
            pscreate.setString(7, phoneNumber);
            pscreate.setString(8, streetAddress);
            pscreate.setInt(9, cityID);
            pscreate.setInt(10, zipCode);

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
    
        public static boolean deleteStaff(int staffID) {
            try {
                PreparedStatement pscreate = Connect.connection.prepareStatement("DELETE from Staffs WHERE staffID = ?");
                pscreate.setInt(1, staffID);

                pscreate.executeUpdate();
                return true;
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null,ex);
                return false;
        }    
    }
        
        public static boolean updateStaffDetails(int staffID, int hotelID, int staffTypeID, int departmentID, String staffFirstName, String staffLastName,
                Date birthDate, String phoneNumber, String streetAddress, int cityID, int zipCode) {
            
            java.sql.Date sqlBirthDate = new java.sql.Date(birthDate.getTime());

            try {
                PreparedStatement pscreate = Connect.connection.prepareStatement("UPDATE Staffs "+
                        "SET hotelID = ?, staffTypeID = ?, departmentID = ?, staffFirstName = ?, staffLastName = ?, "
                        + "birthDate = ?, phoneNumber = ?, streetAddress = ?, cityID = ?, zipCode = ? "+
                        "WHERE staffID = ?");
                
                pscreate.setInt(1, hotelID);
                pscreate.setInt(2, staffTypeID);
                pscreate.setInt(3, departmentID);
                pscreate.setString(4, staffFirstName);
                pscreate.setString(5, staffLastName);
                pscreate.setDate(6, sqlBirthDate);
                pscreate.setString(7, phoneNumber);
                pscreate.setString(8, streetAddress);
                pscreate.setInt(9, cityID);
                pscreate.setInt(10, zipCode);
                pscreate.setInt(11, staffID);
         

                pscreate.executeUpdate();
                return true;
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null,ex);
                return false;
            }

        
    }
        
        public static ArrayList<Staff> getAllStaffsList(int hotelID){
        ArrayList<Staff> StaffsList = new ArrayList<Staff>();
        int tempStaffID, tempHotelID, tempStaffTypeID, tempDepartmentID, tempCityID, tempZipCode;
        String tempFirstName, tempStreetAddress, tempPhoneNumber, tempLastName;
        Date tempBirthDate;
        ResultSet resultSet = null;
        try
        {
            PreparedStatement preparedStatement = Connect.connection.prepareStatement("SELECT * FROM Staffs  "
                    + "WHERE hotelID = ? "
                    + "ORDER BY staffID");
            preparedStatement.setInt(1, hotelID);
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                tempStaffID = resultSet.getInt("staffID");
                tempHotelID = resultSet.getInt("hotelID");
                tempStaffTypeID = resultSet.getInt("staffTypeID");
                tempDepartmentID = resultSet.getInt("departmentID");
                tempFirstName = resultSet.getString("staffFirstName");
                tempLastName = resultSet.getString("staffLastName");
                tempBirthDate = resultSet.getDate("birthDate");
                tempPhoneNumber = resultSet.getString("phoneNumber");
                tempStreetAddress = resultSet.getString("StreetAddress");
                tempCityID = resultSet.getInt("cityID");
                tempZipCode = resultSet.getInt("zipCode");
                
                StaffsList.add(new Staff(tempStaffID, tempHotelID, tempStaffTypeID, tempDepartmentID, tempFirstName, tempLastName, tempBirthDate, 
                        tempPhoneNumber, tempStreetAddress, tempCityID, tempZipCode));
            }
        }catch(Exception ex){
            ex.printStackTrace();
            //JOptionPane.showMessageDialog(null,ex);
        }
        
        return StaffsList;
        
    }
    
    
    
}
