/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author khantil
 */
public class City {

    public String getCityName() {
        return cityName;
    }

    public int getStateID() {
        return stateID;
    }

    public int getCityID() {
        return cityID;
    }

    public City(int cityID, String cityName, int stateID) {
        this.cityID = cityID;
        this.cityName = cityName;
        this.stateID = stateID;
    }

    @Override
    public String toString() {
        return this.cityName;
    }
    
    int cityID;
    String cityName;
    int stateID;
    
    public static ArrayList<City> getAllCitiesInStateList(int stateID){
        ArrayList<City> citiesList = new ArrayList<City>();
        int tempCityID, tempStateID;
        String tempCityName;
        ResultSet resultSet = null;
        try
        {
            PreparedStatement preparedStatement = Connect.connection.prepareStatement("select * from Cities where stateID = ? order by cityName");
            preparedStatement.setInt(1, stateID);
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                tempCityID = resultSet.getInt("cityID");
                tempStateID = resultSet.getInt("stateID");
                tempCityName = resultSet.getString("cityName");
                citiesList.add(new City(tempCityID, tempCityName, tempStateID));
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
            //JOptionPane.showMessageDialog(null,ex);
        }
        
        return citiesList;
        
    }
    
    public static City getCity(int cityID){
        int tempCityID, tempStateID;
        String tempCityName;
        ResultSet resultSet = null;
        try
        {
            PreparedStatement preparedStatement = Connect.connection.prepareStatement("select * from Cities where cityID = ? ");
            preparedStatement.setInt(1, cityID);
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                tempCityID = resultSet.getInt("cityID");
                tempStateID = resultSet.getInt("stateID");
                tempCityName = resultSet.getString("cityName");
                return (new City(tempCityID, tempCityName, tempStateID));
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
            //JOptionPane.showMessageDialog(null,ex);
        }
        return null;
    }
}
