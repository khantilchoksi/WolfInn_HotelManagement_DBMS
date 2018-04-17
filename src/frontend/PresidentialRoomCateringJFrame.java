/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import backend.*;
import backend.Hotel;
import static frontend.ViewStaffForCheckInJFrame.buildTableModel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
        viewActiveCheckInsJButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

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

        viewActiveCheckInsJButton.setText("View All Active Presidential CheckIn Caterers");
        viewActiveCheckInsJButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewActiveCheckInsJButtonMouseClicked(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(addCaterer))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(viewCaterer)
                            .addComponent(selectPresidentialCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(525, 525, 525))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(selectHotel, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(179, 179, 179)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(115, 115, 115)
                            .addComponent(viewActiveCheckInsJButton))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(54, 54, 54)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                .addGap(28, 28, 28)
                .addComponent(viewActiveCheckInsJButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(selectPresidentialCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addCaterer)
                    .addComponent(viewCaterer))
                .addGap(55, 55, 55))
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
        AddCatererJFrame addCatererJFrame = new AddCatererJFrame(h, ci.getCheckInID());
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

    private void viewActiveCheckInsJButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewActiveCheckInsJButtonMouseClicked
        // TODO add your handling code here:
        Hotel hotel = (Hotel)selectHotel.getSelectedItem();
        try{
            if(hotel != null){
                ResultSet showStaffResultSet = PresidentialRoomCatering.getCatererHotelDetails(hotel.getHotelID());
                if(showStaffResultSet!= null){
                    jTable1.setModel(buildTableModel(showStaffResultSet));
                    jScrollPane1.setViewportView(jTable1);
                    pack();
                }else{
                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                    model.setRowCount(0);
                }
                
            }else{
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                    model.setRowCount(0);
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,ex);
        }
        
    }//GEN-LAST:event_viewActiveCheckInsJButtonMouseClicked

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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<Hotel> selectHotel;
    private javax.swing.JComboBox<CheckIn> selectPresidentialCheckIn;
    private javax.swing.JButton viewActiveCheckInsJButton;
    private javax.swing.JButton viewCaterer;
    // End of variables declaration//GEN-END:variables
}
