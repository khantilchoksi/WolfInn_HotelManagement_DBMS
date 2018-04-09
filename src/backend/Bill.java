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
}
