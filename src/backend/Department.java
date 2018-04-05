/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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
    
    public static ArrayList<Department> getAllDepartmentList(){
        ResultSet resultSet = null;
        ArrayList<Department> departmentList = new ArrayList<Department>();
        int tempDepartmentID; 
        String tempDepartmentName;
        try
        {
            Statement statement = Connect.connection.createStatement();
            resultSet = statement.executeQuery("select * from Department order by departmentName");
            
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
}
