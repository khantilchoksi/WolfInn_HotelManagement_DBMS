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
 * @author khantil
 */
public class State {

    public State(int stateID, String stateName) {
        this.stateID = stateID;
        this.stateName = stateName;
    }
    
    int stateID;
    String stateName;
    
    public static ResultSet getAllStates(){
        ResultSet resultSet = null;
        try
        {
            Statement statement = Connect.connection.createStatement();
            resultSet = statement.executeQuery("select * from states order by stateName");
            
        }catch(Exception ex){
            ex.printStackTrace();
            //JOptionPane.showMessageDialog(null,ex);
        }
        
        return resultSet;
        
    }
    
        public static ArrayList<State> getAllStatesList(){
        ResultSet resultSet = null;
        ArrayList<State> statesList = new ArrayList<State>();
        int tempStateID; 
        String tempStateName;
        try
        {
            Statement statement = Connect.connection.createStatement();
            resultSet = statement.executeQuery("select * from states order by stateName");
            
            while(resultSet.next()){
                tempStateID = resultSet.getInt("stateID");
                tempStateName = resultSet.getString("stateName");
                statesList.add(new State(tempStateID, tempStateName));
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
            //JOptionPane.showMessageDialog(null,ex);
        }
        
        return statesList;
        
    }
}
