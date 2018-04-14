/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import backend.*;
import backend.Hotel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author patel
 */
public class PresidentialRoomCateringJFrame extends javax.swing.JFrame {

    /**
     * Creates new form PresidentialRoomCatering
     */
    public PresidentialRoomCateringJFrame() {
        initComponents();
        populateHotels();
    }
    
    public void populateHotels(){
        selectHotel.removeAllItems();
        try{
            ArrayList<Hotel> hotels = Hotel.getAllHotelsList();
            for(Hotel h : hotels){
                selectHotel.addItem(h);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void populateCheckIns(){
        selectPresidentialCheckIn.removeAllItems();
        Hotel hotel = (Hotel)selectHotel.getSelectedItem();
        try{
            ArrayList<CheckIn> checkIns = CheckIn.getActivePresidentialCheckIns(hotel.getHotelID());
            for(CheckIn ci : checkIns){
                System.out.println(ci.getCheckInID());
                selectPresidentialCheckIn.addItem(ci);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        selectHotel = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        selectPresidentialCheckIn = new javax.swing.JComboBox<>();
        addCaterer = new javax.swing.JButton();
        viewCaterer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Presidential Room Catering");

        jLabel2.setText("Select Hotel");

        selectHotel.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                selectHotelItemStateChanged(evt);
            }
        });

        jLabel3.setText("Select Presidential Check In");

        addCaterer.setText("Add Caterer");
        addCaterer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addCatererMouseClicked(evt);
            }
        });

        viewCaterer.setText("View Caterer");
        viewCaterer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewCatererMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addCaterer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(viewCaterer))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(selectHotel, 0, 56, Short.MAX_VALUE)
                            .addComponent(selectPresidentialCheckIn, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(68, 68, 68))
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(selectHotel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(selectPresidentialCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addCaterer)
                    .addComponent(viewCaterer))
                .addContainerGap(114, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectHotelItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_selectHotelItemStateChanged
        // TODO add your handling code here:
        populateCheckIns();
    }//GEN-LAST:event_selectHotelItemStateChanged

    private void addCatererMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addCatererMouseClicked
        // TODO add your handling code here:
        Hotel h = (Hotel)selectHotel.getSelectedItem();
        CheckIn ci = (CheckIn)selectPresidentialCheckIn.getSelectedItem();
        AddCatererJFrame addCatererJFrame = new AddCatererJFrame(h, ci);
        addCatererJFrame.setVisible(true);
        addCatererJFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        addCatererJFrame.setLocation(screenWidth/4,screenHeight/4);
    }//GEN-LAST:event_addCatererMouseClicked

    private void viewCatererMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewCatererMouseClicked
        // TODO add your handling code here:
        Hotel h = (Hotel)selectHotel.getSelectedItem();
        CheckIn ci = (CheckIn)selectPresidentialCheckIn.getSelectedItem();
        ViewCatererJFrame viewCatererJFrame = new ViewCatererJFrame(h, ci);
        viewCatererJFrame.setVisible(true);
        viewCatererJFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        viewCatererJFrame.setLocation(screenWidth/4,screenHeight/4);
    }//GEN-LAST:event_viewCatererMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PresidentialRoomCateringJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PresidentialRoomCateringJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PresidentialRoomCateringJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PresidentialRoomCateringJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PresidentialRoomCateringJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCaterer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox<Hotel> selectHotel;
    private javax.swing.JComboBox<CheckIn> selectPresidentialCheckIn;
    private javax.swing.JButton viewCaterer;
    // End of variables declaration//GEN-END:variables
}
