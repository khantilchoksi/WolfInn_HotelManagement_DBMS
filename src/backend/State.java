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
 * @author khantil
 */
public class State {

    @Override
    public boolean equals(Object obj) {
        final State secondState = (State) obj;
        if(this.stateID != secondState.getStateID()){
            return false;
        }
        if (! this.stateName.equals(secondState.getStateName())){
            return false;
        }
        return true;// of generated methods, choose Tools | Templates.
    }

    public int getStateID() {
        return stateID;
    }

    public String getStateName() {
        return stateName;
    }

    @Override
    public String toString() {
        return this.stateName;
    }

    public State(int stateID, String stateName) {
        this.stateID = stateID;
        this.stateName = stateName;
    }
    
    int stateID;
    String stateName;
    
//    public static ResultSet getAllStates(){
//        ResultSet resultSet = null;
//        try
//        {
//            Statement statement = Connect.connection.createStatement();
//            resultSet = statement.executeQuery("select * from States order by stateName");
//            
//        }catch(Exception ex){
//            ex.printStackTrace();
//            //JOptionPane.showMessageDialog(null,ex);
//        }
//        
//        return resultSet;
//        
//    }
    
        public static ArrayList<State> getAllStatesList(){
        ResultSet resultSet = null;
        ArrayList<State> statesList = new ArrayList<State>();
        int tempStateID; 
        String tempStateName;
        try
        {
            Statement statement = Connect.connection.createStatement();
            resultSet = statement.executeQuery("select * from States order by stateName");
            
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
        
    public static State getState(int stateID){
        int tempStateID;
        String tempStateName;
        ResultSet resultSet = null;
        try
        {
            PreparedStatement preparedStatement = Connect.connection.prepareStatement("select * from States where stateID = ? ");
            preparedStatement.setInt(1, stateID);
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                
                tempStateID = resultSet.getInt("stateID");
                tempStateName = resultSet.getString("stateName");
                return (new State(tempStateID, tempStateName));
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
            //JOptionPane.showMessageDialog(null,ex);
        }
        return null;
    }
}
