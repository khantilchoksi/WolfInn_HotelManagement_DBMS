/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms_wolfinn;
import backend.Connect;
import backend.DropWolfInn;
import backend.WolfInn;
import frontend.HotelsJFrame;
import java.awt.Dimension;
import java.awt.Toolkit;
/**
 *
 * @author khantil
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connect.getConnection();
        
        //DropWolfInn.droptTables();
        WolfInn.populateData();
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                HotelsJFrame n = new HotelsJFrame();
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                n.setSize(screenSize.width/2, screenSize.height/2);
                n.setVisible(true);
                
            }
        });
    }
    
}
