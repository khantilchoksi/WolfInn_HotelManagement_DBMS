/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author khantil
 */
public class City {
    
    int cityID;
    String cityName;
    int stateID;
    
    public static ResultSet getAllCitiesInState(int stateID){
        ResultSet resultSet = null;
        try
        {
            PreparedStatement preparedStatement = Connect.connection.prepareStatement("select * from cities where stateID = ? order by stateName");
            preparedStatement.setInt(1, stateID);
            resultSet = preparedStatement.executeQuery();
            
        }catch(Exception ex){
            ex.printStackTrace();
            //JOptionPane.showMessageDialog(null,ex);
        }
        
        return resultSet;
        
    }
}
