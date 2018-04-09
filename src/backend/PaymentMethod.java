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
public class PaymentMethod {

    @Override
    public String toString() {
        return  "" + paymentMethodID + " - " + paymentMethodName ;
    }

    public int getPaymentMethodID() {
        return paymentMethodID;
    }

    public String getPaymentMethodName() {
        return paymentMethodName;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public PaymentMethod(int paymentMethodID, String paymentMethodName, double discountPercentage) {
        this.paymentMethodID = paymentMethodID;
        this.paymentMethodName = paymentMethodName;
        this.discountPercentage = discountPercentage;
    }
    int paymentMethodID;
    String paymentMethodName;
    double discountPercentage;
    
    
    
    public static ArrayList<PaymentMethod> getAllPaymentMethodsList(){
        ArrayList<PaymentMethod> paymentMethodsList = new ArrayList<PaymentMethod>();
        int tempPaymentMethodID;
        String tempPaymentMethodName;
        double tempDiscount;
        ResultSet resultSet = null;
        try{
            PreparedStatement preparedStatement = Connect.connection.prepareStatement("select * from PaymentMethods order by paymentMethodID");
            
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                tempPaymentMethodID = resultSet.getInt("paymentMethodID");
                tempPaymentMethodName = resultSet.getString("paymentMethodName");
                tempDiscount = resultSet.getDouble("discountPercent");
                paymentMethodsList.add(new PaymentMethod(tempPaymentMethodID, tempPaymentMethodName, tempDiscount));
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
            //JOptionPane.showMessageDialog(null,ex);
        }
        
        return paymentMethodsList;
        
    }
    
}
