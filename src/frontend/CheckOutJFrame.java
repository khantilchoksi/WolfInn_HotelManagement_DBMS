/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import backend.Hotel;
import backend.*;
import static frontend.ViewRoomTypesJFrame.buildTableModel;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author khantil
 */
public class CheckOutJFrame extends javax.swing.JFrame {

    CheckIn currentCheckIn;
    /**
     * Creates new form CheckOutJFrame
     */
    public CheckOutJFrame() {
        initComponents();
        
        populateHotels();
        
        
        
    }

    private void populateHotels() {
        selectHotelJComboBox.removeAllItems();
        //statesJComboBox.addItem("");
        //statesJComboBox.addItem("All States");

        try {
            ArrayList<Hotel> hotelsList = Hotel.getAllHotelsList();
            for (Hotel hotel : hotelsList) {
                selectHotelJComboBox.addItem(hotel);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private void populateCheckedInRooms(int hotelID){
        roomsJComboBox.removeAllItems();
        //Hotel hotel = (Hotel)selectHotel.getSelectedItem();
        try{
            ArrayList<CheckIn> checkedInRooms = CheckIn.getActiveCheckIns(hotelID);
            for(CheckIn checkin : checkedInRooms){
                roomsJComboBox.addItem(checkin);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        closeJButton = new javax.swing.JButton();
        checkOutJButton = new javax.swing.JButton();
        selectHotelJComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        roomsJComboBox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        roomRateLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        totalAmountJLabel = new javax.swing.JLabel();
        discountAmountLabel = new javax.swing.JLabel();
        totalAmoutToBePaidLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setText("Check-Out");

        jLabel2.setText("Select Hotel:");

        jLabel3.setText("Select Check-In Room:");

        closeJButton.setText("Close");
        closeJButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeJButtonMouseClicked(evt);
            }
        });

        checkOutJButton.setText("Check-Out");
        checkOutJButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkOutJButtonMouseClicked(evt);
            }
        });

        selectHotelJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectHotelJComboBoxActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        roomsJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomsJComboBoxActionPerformed(evt);
            }
        });

        jLabel4.setText("Rooms Charges:");

        roomRateLabel.setText("jLabel7");

        jLabel7.setText("Total Amount To Be Paid:");

        jLabel8.setText("Total:");

        jLabel9.setText("Discount:");

        totalAmountJLabel.setText("jLabel10");

        discountAmountLabel.setText("jLabel11");

        totalAmoutToBePaidLabel.setText("jLabel12");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(259, 259, 259)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(39, 39, 39)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(selectHotelJComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(roomsJComboBox, 0, 255, Short.MAX_VALUE))
                                    .addComponent(roomRateLabel)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(checkOutJButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(closeJButton)
                .addGap(10, 10, 10))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(totalAmoutToBePaidLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(discountAmountLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(156, 156, 156)
                        .addComponent(totalAmountJLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(selectHotelJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(roomsJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(roomRateLabel))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(totalAmountJLabel))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(discountAmountLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(totalAmoutToBePaidLabel))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkOutJButton)
                    .addComponent(closeJButton))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectHotelJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectHotelJComboBoxActionPerformed
        // TODO add your handling code here:
        roomsJComboBox.removeAllItems();
        //jTable1.removeAll();
        Hotel hotel = (Hotel)selectHotelJComboBox.getSelectedItem();
        populateCheckedInRooms(hotel.getHotelID());
    }//GEN-LAST:event_selectHotelJComboBoxActionPerformed

    private void roomsJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomsJComboBoxActionPerformed
        // TODO add your handling code here:
//        jTable1.removeAll();
        System.out.println("\n ITEM COUNT: "+roomsJComboBox.getItemCount()+ "Hotel : "+(Hotel)selectHotelJComboBox.getSelectedItem());
        if(roomsJComboBox.getItemCount() > 0){
            currentCheckIn = (CheckIn) roomsJComboBox.getSelectedItem();
            
            try{
                jTable1.setModel(buildTableModel(ServiceRecord.getServiceRecordsForCheckIns(currentCheckIn.getCheckInID())));
                jScrollPane1.setViewportView(jTable1);
                pack();
                
                currentCheckIn.setTotalServiceCost(ServiceRecord.getTotalServiceCost(currentCheckIn.getCheckInID()));
                currentCheckIn.setTotalRoomCost(CheckIn.getRoomCost(currentCheckIn.getCheckInID()));
                roomRateLabel.setText(Double.toString(currentCheckIn.getTotalRoomCost()));
                totalAmountJLabel.setText(Double.toString(currentCheckIn.getTotalRoomCost()+currentCheckIn.getTotalServiceCost()));
                discountAmountLabel.setText(Double.toString(currentCheckIn.getTotalDiscount()));
                totalAmoutToBePaidLabel.setText(Double.toString(currentCheckIn.getTotalBillAmount()));
            
            }catch(Exception ex){
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null,ex);
            }
            
            
            
        }
//        else{
//            
//            JOptionPane.showMessageDialog(null,"NO CHECKED IN ROOMS FOUND IN THIS HOTEL!");
//        }
        


    }//GEN-LAST:event_roomsJComboBoxActionPerformed

    private void checkOutJButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkOutJButtonMouseClicked
        // TODO add your handling code here:
        boolean statusCheckOut;
        boolean statusBilling;
        Savepoint s;
        Connection conn = null;
        try{
            conn = Connect.connection;
            conn.setAutoCommit(false);
            s = conn.setSavepoint();
        }catch(Exception e){
            e.printStackTrace();
        }
        statusCheckOut = CheckIn.doCheckOut(currentCheckIn.getCheckInID());
        statusBilling = Bill.updateBill(currentCheckIn.getCheckInID(), currentCheckIn.getTotalCost());
        if(statusCheckOut && statusBilling){
            try{
                conn.commit();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            try{
                conn.rollback();
                JOptionPane.showMessageDialog(null, "One of the transactions did not execute");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        try{
            conn.setAutoCommit(true);
        }catch(Exception e){
            e.printStackTrace();
        }
        JOptionPane.showConfirmDialog(null, "Successfully checked out");
    }//GEN-LAST:event_checkOutJButtonMouseClicked

    private void closeJButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeJButtonMouseClicked
        // TODO add your handling code here:
        WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }//GEN-LAST:event_closeJButtonMouseClicked

    public static DefaultTableModel buildTableModel(ResultSet rs)
            throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();

        // names of columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames);

    }
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
            java.util.logging.Logger.getLogger(CheckOutJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CheckOutJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CheckOutJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CheckOutJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CheckOutJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton checkOutJButton;
    private javax.swing.JButton closeJButton;
    private javax.swing.JLabel discountAmountLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel roomRateLabel;
    private javax.swing.JComboBox<CheckIn> roomsJComboBox;
    private javax.swing.JComboBox<Hotel> selectHotelJComboBox;
    private javax.swing.JLabel totalAmountJLabel;
    private javax.swing.JLabel totalAmoutToBePaidLabel;
    // End of variables declaration//GEN-END:variables
}
