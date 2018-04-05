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
public class Staff {
    
    
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
    
}
