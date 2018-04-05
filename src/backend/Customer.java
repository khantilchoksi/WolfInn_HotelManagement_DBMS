/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author adity
 */
public class Customer {

    @Override
    public String toString() {
        return ""+customerID+ " - "+customerFirstName+" "+customerLastName; //To change body of generated methods, choose Tools | Templates.
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
    
    int customerID;
    String customerFirstName;
    String customerLastName;
    Date birthDate;
    String phoneNumber;
    String emailAddress;
    
    public Customer(int customerID, String customerFirstName, String customerLastName, Date birthDate, String phoneNumber, String emailAddress){
        this.customerID = customerID;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }
    
    public static boolean createCustomer(String customerFirstName, String customerLastName, Date birthDate, String phoneNumber, String emailAddress){
        try {
            PreparedStatement pscreate = Connect.connection.prepareStatement("insert into Customers(customerFirstName, customerLastName, birthDate, phoneNumber, emailAddress) values(?,?,?,?,?)");
            pscreate.setString(1, customerFirstName);
            pscreate.setString(2, customerLastName);
            pscreate.setDate(3, birthDate);
            pscreate.setString(4, phoneNumber);
            pscreate.setString(5, emailAddress);
			
            pscreate.executeUpdate();
            return true;
	}catch(Exception ex) {
            ex.printStackTrace();
            return false;
            //JOptionPane.showMessageDialog(null,ex);
	}
    }
    
    public static boolean deleteCustomer(int customerID){
        try{
            PreparedStatement psdelete = Connect.connection.prepareStatement("delete from Customers where customerID = ?");
            psdelete.setInt(1, customerID);
            
            psdelete.executeUpdate();
            return true;
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
    
    public static boolean updateCustomerDetails(int customerID, String customerFirstName, String customerLastName, Date birthDate, String phoneNumber, String emailAddress){
        try {
            PreparedStatement psupdate = Connect.connection.prepareStatement("UPDATE Customers "+
                    "SET customerFirstName = ?, customerLastName = ?, birthDate = ?, phoneNumber = ?, emailAddress = ?"+
                    "WHERE customerID = ?");
            psupdate.setString(1, customerFirstName);
            psupdate.setString(2, customerLastName);
            psupdate.setDate(3, birthDate);
            psupdate.setString(4, phoneNumber);
            psupdate.setString(5, emailAddress);
            psupdate.setInt(6, customerID);
			
            psupdate.executeUpdate();
            return true;
	}catch(Exception ex) {
            ex.printStackTrace();
            return false;
            //JOptionPane.showMessageDialog(null,ex);
	}
    }
    
    public static ResultSet viewAllCustomers(){
        ResultSet resultSet = null;
        try
        {
            PreparedStatement preparedStatement = Connect.connection.prepareStatement("select * from Customers order by customerFirstName");
            resultSet = preparedStatement.executeQuery();
            
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,ex);
        }
        
        return resultSet;
    }
    
    public static ArrayList<Customer> getAllCustomers(){
        ArrayList <Customer> customersList = new ArrayList<Customer>();
        int tempcustomerID;
        String tempcustomerFirstName, tempcustomerLastName, tempphoneNumber, tempemailAddress;
        Date tempbirthDate;
        ResultSet resultSet = null;
        try{
            PreparedStatement preparedStatement = Connect.connection.prepareStatement("select * from Customers order by customerFirstName");
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
               tempcustomerID = resultSet.getInt("customerID");
               tempcustomerFirstName = resultSet.getString("customerFirstName");
               tempcustomerLastName = resultSet.getString("customerLastName");
               tempphoneNumber = resultSet.getString("phoneNumber");
               tempemailAddress = resultSet.getString("emailAddress");
               tempbirthDate = resultSet.getDate("birthDatte");
               customersList.add(new Customer(tempcustomerID, tempcustomerFirstName, tempcustomerLastName, tempbirthDate, tempphoneNumber, tempemailAddress));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return customersList;
    }
    
    
}
