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

/**
 *
 * @author Dax Amin
 */
public class StaffType {
    
    public int getStaffTypeID() {
        return staffTypeID;
    }
    
    public String getStaffTypeName() {
        return staffTypeName;
    }
    
    @Override
    public String toString() {
        return this.staffTypeName;
    }
    
    public StaffType(int staffTypeID, String staffTypeName) {
        this.staffTypeID = staffTypeID;
        this.staffTypeName = staffTypeName;
    }
    
    int staffTypeID;
    String staffTypeName;
    
    public static ArrayList<StaffType> getAllStaffTypeList(){
        ResultSet resultSet = null;
        ArrayList<StaffType> staffTypeList = new ArrayList<StaffType>();
        int tempStaffTypeID; 
        String tempStaffTypeName;
        try
        {
            Statement statement = Connect.connection.createStatement();
            resultSet = statement.executeQuery("select * from StaffTypes order by staffTypeName");
            
            while(resultSet.next()){
                tempStaffTypeID = resultSet.getInt("staffTypeID");
                tempStaffTypeName = resultSet.getString("staffTypeName");
                staffTypeList.add(new StaffType(tempStaffTypeID, tempStaffTypeName));
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
            //JOptionPane.showMessageDialog(null,ex);
        }
        
        return staffTypeList;
        
    }
    
    public static StaffType getStaffType(int staffTypeID){
        int tempStaffTypeID;
        String tempStaffTypeName;
        ResultSet resultSet = null;
        try
        {
            PreparedStatement preparedStatement = Connect.connection.prepareStatement("select * from StaffTypes where staffTypeID = ? ");
            preparedStatement.setInt(1, staffTypeID);
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                
                tempStaffTypeID = resultSet.getInt("staffTypeID");
                tempStaffTypeName = resultSet.getString("staffTypeName");
                return (new StaffType(tempStaffTypeID, tempStaffTypeName));
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
            //JOptionPane.showMessageDialog(null,ex);
        }
        return null;
    }
    
}
