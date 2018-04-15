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
 * @author Dax Amin
 */
public class Department {
    
    public int getDepartmentID() {
        return departmentID;
    }
    
    public String getDepartmentName() {
        return departmentName;
    }
    
    @Override
    public String toString() {
        return this.departmentName;
    }
    
    public Department(int departmentID, String departmentName) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
    }
    
    int departmentID;
    String departmentName;
    
        //Return Newly created hotel id or return -1 if error 
    public static boolean createDepartment(String departmentName) {

        try {
            PreparedStatement pscreate = Connect.connection.prepareStatement("insert into Departments(departmentName) values(?)");
            pscreate.setString(1, departmentName);
            pscreate.executeUpdate();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,ex);
            return false;
        }

        
    }
    
    public static ResultSet viewAllDepartments(){
        ResultSet resultSet = null;
        try
        {
            Statement statement = Connect.connection.createStatement();
            resultSet = statement.executeQuery("select * from Departments;");
            
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,ex);
        }
        
        return resultSet;
        
    }
        
    public static ArrayList<Department> getAllDepartmentList(){
        ResultSet resultSet = null;
        ArrayList<Department> departmentList = new ArrayList<Department>();
        int tempDepartmentID; 
        String tempDepartmentName;
        try
        {
            
            Statement statement = Connect.connection.createStatement();
            resultSet = statement.executeQuery("select * from Departments order by departmentName");
            
            while(resultSet.next()){
                tempDepartmentID = resultSet.getInt("departmentID");
                
                tempDepartmentName = resultSet.getString("departmentName");
                
                departmentList.add(new Department(tempDepartmentID, tempDepartmentName));
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
            //JOptionPane.showMessageDialog(null,ex);
        }
        
        return departmentList;
        
    }
    
    public static Department getDepartment(int departmentID){
        int tempDepartmentID;
        String tempDepartmentName;
        ResultSet resultSet = null;
        try
        {
            PreparedStatement preparedStatement = Connect.connection.prepareStatement("select * from Departments where departmentID = ? ");
            preparedStatement.setInt(1, departmentID);
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                
                tempDepartmentID = resultSet.getInt("departmentID");
                tempDepartmentName = resultSet.getString("departmentName");
                return (new Department(tempDepartmentID, tempDepartmentName));
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
            //JOptionPane.showMessageDialog(null,ex);
        }
        return null;
    }
}
