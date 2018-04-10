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
 * @author adity
 */
public class PaymentMethod {
    
    @Override
    public String toString() {
        return ""+ paymentMethodID + " - "+paymentMethodName; //To change body of generated methods, choose Tools | Templates.
    }
    
    public String getPaymentMethodName() {
        return paymentMethodName;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public int getPaymentMethodID() {
        return paymentMethodID;
    }
    
    int paymentMethodID;
    String paymentMethodName;
    double discountPercent;
    
    public PaymentMethod(int paymentMethodID, String paymentMethodName, double discountPercent){
        this.paymentMethodName = paymentMethodName;
        this.paymentMethodID = paymentMethodID;
        this.discountPercent = discountPercent;
    }
    
    public static boolean createPaymentMethod(String paymentMethodName, double discountPercent){
        
        try {
            PreparedStatement pscreate = Connect.connection.prepareStatement("insert into PaymentMethods(paymentMethodName, discountPercent) values(?,?)");
            pscreate.setString(1, paymentMethodName);
            pscreate.setDouble(2, discountPercent);
            
            pscreate.executeUpdate();
            return true;
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
    
    public static ArrayList<PaymentMethod> getAllPaymentMethods(){
        ArrayList <PaymentMethod> paymentMethodList = new ArrayList<PaymentMethod>();
        int tempPaymentMethodID;
        String tempPaymentMethodName;
        double tempDiscountPercent;
        ResultSet resultset = null;
        
        try{
            PreparedStatement preparedStatement = Connect.connection.prepareStatement("select * from PaymentMethods order by paymentMethodName");
            resultset = preparedStatement.executeQuery();
            
            while(resultset.next()){
                tempPaymentMethodID = resultset.getInt("paymentMethodID");
                tempPaymentMethodName = resultset.getString("paymentMethodName");
                tempDiscountPercent = resultset.getDouble("discountPercent");
                paymentMethodList.add(new PaymentMethod(tempPaymentMethodID, tempPaymentMethodName, tempDiscountPercent));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return paymentMethodList;
    }
    
    public static boolean updatePaymentMethod(int paymentMethodID, String paymentMethodName, double discountPercent){
        try {
            PreparedStatement psupdate = Connect.connection.prepareStatement("UPDATE PaymentMethods SET paymentMethodName = ?, discountPercent = ? WHERE paymentMethodID = ?");
            psupdate.setString(1, paymentMethodName);
            psupdate.setDouble(2, discountPercent);
            psupdate.setInt(3, paymentMethodID);
            
            psupdate.executeUpdate();
            return true;
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
    
    public static ResultSet viewAllPaymentMethods(){
        ResultSet resultSet = null;
        try{
            PreparedStatement preparedStatement = Connect.connection.prepareStatement("select * from PaymentMethods order by paymentMethodName");
            resultSet = preparedStatement.executeQuery();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return resultSet;
    }
}
