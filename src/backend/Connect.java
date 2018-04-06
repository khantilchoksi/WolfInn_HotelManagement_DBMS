/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author khantil
 */
public class Connect {
    static Connection connection = null;
    
    private static final String user = "root";
    private static final String password = "";
    private static final String driver ="org.mariadb.jdbc.Driver";
    private static final boolean localdb = true; // Determine whether to use a local database or NCSU's DB.
//    jdbc:mariadb://localhost:3306/DB?user=root&password=myPassword"
    private static final String jdbcURL = localdb

			? "jdbc:mariadb://localhost/wolfinn?user=root&password=&createDatabaseIfNotExist=true" // If using a local database
			: "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/$USER$"; // If using NCSU's DB
    
    public static void getConnection(){

        try{
            
            Class.forName(driver);
            // URL 
            connection = DriverManager.getConnection(jdbcURL);
            System.out.println(jdbcURL);
            System.out.println("\n Connected from Connect.java!");
            //JOptionPane.showMessageDialog(null,"CONNECTED");

        }catch (Exception ex) {
            //JOptionPane.showMessageDialog(null,ex);
            ex.printStackTrace();
        }
    }
    
    public static void closeConnection(){
        try{
            close(connection);
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,ex);
        }
    }
    
    
    static void close(Connection connection) {
            if(connection != null) {
                try {
                connection.close();
                } catch(Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null,ex);
                }
            }
    }
    
    public static void main(String[] args) {
    		getConnection();
    }
}
