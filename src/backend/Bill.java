/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author khantil
 */
public class Bill {
    public static boolean enterBillInfo(int checkInID, int paymentMethodID, 
            String payerFirstName, String payerLastName, String cardNumber, String SSN,  
            String payerBillingAddress, int cityID, int payerZipCode) {

        
        try {
            PreparedStatement pscreate = Connect.connection.prepareStatement(
                    "INSERT into Bills(checkInID, paymentMethodID, " +
                    "payerFirstName, payerLastName, cardNumber, SSN, " +
                    "payerBillingAddress, cityID, payerZipCode) values(?,?,?,?,?,?,?,?,?);"
            );
            pscreate.setInt(1, checkInID);
            pscreate.setInt(2, paymentMethodID);
            pscreate.setString(3, payerFirstName);
            pscreate.setString(4, payerLastName);
            pscreate.setString(5, cardNumber);
            pscreate.setString(6, SSN);
            pscreate.setString(7, payerBillingAddress);
            pscreate.setInt(8, cityID);
            pscreate.setInt(9, payerZipCode);
            pscreate.executeUpdate();

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,ex);
            return false;
        }

        
    }
    
    public static double getDiscountPercent(int checkInID){
        ResultSet rs = null;
        double discount = 0;
        String error;
        try{
            PreparedStatement psGetDiscount = Connect.connection.prepareStatement("SELECT PaymentMethods.discountPercent " +
                    "FROM Bills, PaymentMethods "+
                    "WHERE Bills.checkInID = ? and Bills.paymentMethodID = PaymentMethods.paymentMethodID");
            psGetDiscount.setInt(1, checkInID);
            rs = psGetDiscount.executeQuery();
            while(rs.next()){
                discount = rs.getDouble("discountPercent");
            }
            //rs.next();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return discount;
                
    }
    
    public static boolean updateBill(int checkInID, double totalAmount){
        boolean status = false;
        try{
            PreparedStatement ps = Connect.connection.prepareStatement("UPDATE Bills " +
                    "SET totalAmount = ? " +
                    "WHERE checkInID = ?");
            ps.setInt(2, checkInID);
            ps.setDouble(1, totalAmount);
            status = ps.execute();
            status = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return status;
    }
}
