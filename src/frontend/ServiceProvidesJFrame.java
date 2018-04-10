/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;


import backend.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JFrame;
/**
 *
 * @author patel
 */
public class ServiceProvidesJFrame extends javax.swing.JFrame {

    /**
     * Creates new form ServiceProvidesJFrame
     */
    public ServiceProvidesJFrame() {
        initComponents();
        populateHotels();
    }
    
    private void populateHotels() {
        selectHotelJBox.removeAllItems();
        //statesJComboBox.addItem("");
        //statesJComboBox.addItem("All States");

        try {
            ArrayList<Hotel> hotelsList = Hotel.getAllHotelsList();
            for (Hotel hotel : hotelsList) {
                selectHotelJBox.addItem(hotel);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
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
        selectHotelJBox = new javax.swing.JComboBox<Hotel>();
        addServiceProvideButton = new javax.swing.JButton();
        updateServiceProvideButton = new javax.swing.JButton();
        viewServiceProvideButton = new javax.swing.JButton();
        removeServiceProvideButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Service Provides");

        jLabel2.setText("Select Hotel");

        selectHotelJBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectHotelJBoxActionPerformed(evt);
            }
        });

        addServiceProvideButton.setText("Add Service");
        addServiceProvideButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addServiceProvideButtonMouseClicked(evt);
            }
        });

        updateServiceProvideButton.setText("Update Service");
        updateServiceProvideButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateServiceProvideButtonMouseClicked(evt);
            }
        });

        viewServiceProvideButton.setText("View Service");
        viewServiceProvideButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewServiceProvideButtonMouseClicked(evt);
            }
        });

        removeServiceProvideButton.setText("Remove Service");
        removeServiceProvideButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeServiceProvideButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(addServiceProvideButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(viewServiceProvideButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(selectHotelJBox, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(removeServiceProvideButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(updateServiceProvideButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)))))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(selectHotelJBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addServiceProvideButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateServiceProvideButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewServiceProvideButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeServiceProvideButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectHotelJBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectHotelJBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectHotelJBoxActionPerformed

    private void addServiceProvideButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addServiceProvideButtonMouseClicked
        // TODO add your handling code here:
        AddServiceProvidesJFrame addServiceProvidesJFrame = new AddServiceProvidesJFrame((Hotel) selectHotelJBox.getSelectedItem());
        addServiceProvidesJFrame.setVisible(true);
        addServiceProvidesJFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        addServiceProvidesJFrame.setLocation(screenWidth/4,screenHeight/4);
    }//GEN-LAST:event_addServiceProvideButtonMouseClicked

    private void updateServiceProvideButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateServiceProvideButtonMouseClicked
        // TODO add your handling code here:
        UpdateServiceProvidesJFrame updateServiceProvidesJFrame = new UpdateServiceProvidesJFrame((Hotel) selectHotelJBox.getSelectedItem());
        updateServiceProvidesJFrame.setVisible(true);
        updateServiceProvidesJFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        updateServiceProvidesJFrame.setLocation(screenWidth/4,screenHeight/4);
    }//GEN-LAST:event_updateServiceProvideButtonMouseClicked

    private void viewServiceProvideButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewServiceProvideButtonMouseClicked
        // TODO add your handling code here:
        ViewServiceProvidesJFrame viewServiceProvidesJFrame = new ViewServiceProvidesJFrame((Hotel) selectHotelJBox.getSelectedItem());
        viewServiceProvidesJFrame.setVisible(true);
        viewServiceProvidesJFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        viewServiceProvidesJFrame.setLocation(screenWidth/4,screenHeight/4);
    }//GEN-LAST:event_viewServiceProvideButtonMouseClicked

    private void removeServiceProvideButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeServiceProvideButtonMouseClicked
        // TODO add your handling code here:
        DeleteServiceProvideJFrame deleteServiceProvideJFrame = new DeleteServiceProvideJFrame((Hotel) selectHotelJBox.getSelectedItem());
        deleteServiceProvideJFrame.setVisible(true);
        deleteServiceProvideJFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        deleteServiceProvideJFrame.setLocation(screenWidth/4,screenHeight/4);
    }//GEN-LAST:event_removeServiceProvideButtonMouseClicked

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
            java.util.logging.Logger.getLogger(ServiceProvidesJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServiceProvidesJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServiceProvidesJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServiceProvidesJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServiceProvidesJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addServiceProvideButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton removeServiceProvideButton;
    private javax.swing.JComboBox<Hotel> selectHotelJBox;
    private javax.swing.JButton updateServiceProvideButton;
    private javax.swing.JButton viewServiceProvideButton;
    // End of variables declaration//GEN-END:variables
}
