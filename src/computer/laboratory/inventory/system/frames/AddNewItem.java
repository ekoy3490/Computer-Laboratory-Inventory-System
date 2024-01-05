/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package computer.laboratory.inventory.system.frames;

import static computer.laboratory.inventory.system.DatabaseConnection.getDB_CONNECTION_URL;
import static computer.laboratory.inventory.system.DatabaseConnection.getDB_PASSWORD;
import static computer.laboratory.inventory.system.DatabaseConnection.getDB_USERNAME;
import static computer.laboratory.inventory.system.DatabaseConnection.getJDBC_DRIVER;
import computer.laboratory.inventory.system.Helper;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Tuason
 */
public class AddNewItem extends javax.swing.JFrame {

    private String imagePath;
    private String room;
    private int inventoryId;
    
    public AddNewItem(String room, int inventoryId) {
        initComponents();
        
        // INITIALIZE VARIABLES
        this.room = room;
        this.inventoryId = inventoryId;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        container = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        body = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        imageReview = new javax.swing.JLabel();
        piecesField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        descriptionTextArea = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        othersCheckBox = new javax.swing.JCheckBox();
        goodCheckBox = new javax.swing.JCheckBox();
        brandNameField = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        remarksTextArea = new javax.swing.JTextArea();
        addBtn = new javax.swing.JButton();
        uploadImageBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(900, 540));

        jScrollPane1.setMaximumSize(new java.awt.Dimension(900, 540));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(900, 540));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(900, 540));

        container.setBackground(new java.awt.Color(255, 255, 255));
        container.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setBackground(new java.awt.Color(255, 255, 255));
        header.setPreferredSize(new java.awt.Dimension(816, 80));
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Leelawadee UI", 1, 36)); // NOI18N
        jLabel2.setText("TALISAY CITY COLLEGE");
        header.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/computer/laboratory/inventory/system/images/tcc logo.png"))); // NOI18N
        header.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 70, 70));

        container.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 130));

        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        jLabel1.setText("Remarks: ");
        body.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 70, 30));

        imageReview.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        body.add(imageReview, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, 260, 160));

        piecesField.setBackground(new java.awt.Color(255, 255, 204));
        piecesField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        body.add(piecesField, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 260, 30));

        descriptionTextArea.setBackground(new java.awt.Color(255, 255, 204));
        descriptionTextArea.setColumns(20);
        descriptionTextArea.setRows(5);
        descriptionTextArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane2.setViewportView(descriptionTextArea);

        body.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 260, 90));

        jLabel5.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        jLabel5.setText("Description:");
        body.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 100, 30));

        jLabel6.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        jLabel6.setText("Brand Name:");
        body.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 100, 30));

        jLabel7.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        jLabel7.setText("Pieces:");
        body.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 60, 30));

        othersCheckBox.setText("Others");
        othersCheckBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                othersCheckBoxMouseClicked(evt);
            }
        });
        body.add(othersCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 130, 30));

        goodCheckBox.setSelected(true);
        goodCheckBox.setText("Good");
        goodCheckBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                goodCheckBoxMouseClicked(evt);
            }
        });
        body.add(goodCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 100, 30));

        brandNameField.setBackground(new java.awt.Color(255, 255, 204));
        brandNameField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        body.add(brandNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 260, 30));

        remarksTextArea.setEditable(false);
        remarksTextArea.setBackground(new java.awt.Color(255, 255, 204));
        remarksTextArea.setColumns(20);
        remarksTextArea.setRows(5);
        remarksTextArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane3.setViewportView(remarksTextArea);

        body.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 260, 100));

        addBtn.setBackground(new java.awt.Color(255, 204, 102));
        addBtn.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        addBtn.setText("Add Item");
        addBtn.setToolTipText("Add New Item");
        addBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });
        body.add(addBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 290, 120, 40));

        uploadImageBtn.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        uploadImageBtn.setText("Upload Image");
        uploadImageBtn.setToolTipText("Upload Image");
        uploadImageBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        uploadImageBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadImageBtnActionPerformed(evt);
            }
        });
        body.add(uploadImageBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 200, 130, 40));

        container.add(body, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 870, 410));

        jScrollPane1.setViewportView(container);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed

        // add new inventory item
        String brandName = brandNameField.getText();
        String description = descriptionTextArea.getText(); // Optional
        String piecesStr = piecesField.getText();
        int pieces;
        String remarks = "Good";
                
        if(brandName.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Please enter value in brand name field.");
            return;
        }
        
        // pieces
        if(piecesStr.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Please enter value in pieces field.");
            return;
        }
        
        try {
            pieces = Integer.parseInt(piecesStr);
            if(pieces < 1) {
                JOptionPane.showMessageDialog(rootPane, "Please enter greater than 0 value.");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "Please enter an integer value in pieces field.");
            return;
        }
        
        // remarks
        if(goodCheckBox.isSelected()) {
            remarks = "Good";
        }
        if(othersCheckBox.isSelected()) {
            remarks = remarksTextArea.getText();
        }
        
        // DATABASE - INSERT DATA (Add new item)
         Connection connection = null;
        PreparedStatement insertStatement = null;
        
        try {
            
            
            Class.forName(getJDBC_DRIVER());
            connection = DriverManager.getConnection(getDB_CONNECTION_URL(), getDB_USERNAME(), getDB_PASSWORD());
            
            if(this.imagePath == null) {
                
                String insertQuery = "INSERT INTO inventory_item(brand_name, description, pieces, "
                    + "remarks, `laboratory_room`, `inventory_id`) VALUES (?,?,?,?,?,?)";
                insertStatement = connection.prepareStatement(insertQuery);
                insertStatement.setString(1, brandName);
                insertStatement.setString(2, description);
                insertStatement.setInt(3, pieces);
                insertStatement.setString(4, remarks);
                insertStatement.setString(5, this.room);
                insertStatement.setInt(6, this.inventoryId);
                
            } else {
                
                InputStream image = new FileInputStream(new File(this.imagePath));

                String insertQuery = "INSERT INTO inventory_item(brand_name, description, image, pieces, "
                    + "remarks, `laboratory_room`, `inventory_id`) VALUES (?,?,?,?,?,?,?)";
                insertStatement = connection.prepareStatement(insertQuery);
                insertStatement.setString(1, brandName);
                insertStatement.setString(2, description);
                insertStatement.setBlob(3, image);
                insertStatement.setInt(4, pieces);
                insertStatement.setString(5, remarks);
                insertStatement.setString(6, this.room);
                insertStatement.setInt(7, this.inventoryId);
                
            }
            
            if(insertStatement.executeUpdate() > 0) {
                
                JOptionPane.showMessageDialog(rootPane, "Successfully add new item.");
                Helper.displayInventoryItems(this.inventoryId, this.room);
//                this.dispose();
                // I change my mind let's not close the frame instead let's empy the fields for next item to add
                brandNameField.setText("");
                descriptionTextArea.setText("");
                piecesField.setText("");
                goodCheckBox.setSelected(true);
                othersCheckBox.setSelected(false);
                remarksTextArea.setText("");
                imageReview.setIcon(null);
                
            }
            
        } catch (FileNotFoundException | ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e);
        } finally {
             try {
                
                if (insertStatement != null) {
                    insertStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                    e.printStackTrace();
            }
        }

    }//GEN-LAST:event_addBtnActionPerformed

    private void goodCheckBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goodCheckBoxMouseClicked
        if(goodCheckBox.isSelected() && othersCheckBox.isSelected()) {
            othersCheckBox.setSelected(false);
            remarksTextArea.setEditable(false);
            remarksTextArea.setText("");
            return;
        }
        
        if(!goodCheckBox.isSelected() && !othersCheckBox.isSelected()) {
            goodCheckBox.setSelected(true);
            remarksTextArea.setEditable(false);
            remarksTextArea.setText("");
        }
    }//GEN-LAST:event_goodCheckBoxMouseClicked

    private void othersCheckBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_othersCheckBoxMouseClicked
        if(othersCheckBox.isSelected() && goodCheckBox.isSelected()) {
            goodCheckBox.setSelected(false);
            remarksTextArea.setEditable(true);
            return;
        }
        
        if(!othersCheckBox.isSelected() && !goodCheckBox.isSelected()) {
            othersCheckBox.setSelected(true);
            remarksTextArea.setEditable(true);
        }
    }//GEN-LAST:event_othersCheckBoxMouseClicked

    private void uploadImageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadImageBtnActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File selectedFile = chooser.getSelectedFile();

        if (selectedFile != null && selectedFile.isFile()) {
            try {
                String path = selectedFile.getAbsolutePath();

                // this will resize the image ratio
                BufferedImage bi = ImageIO.read(selectedFile);
                Image img = bi.getScaledInstance(260, 150, Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(img);
                imageReview.setIcon(icon);

                // initialize image path
                this.imagePath = path;
            } catch (IOException ex) {
                Logger.getLogger(ImageTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid file selected");
        }
    }//GEN-LAST:event_uploadImageBtnActionPerformed

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
            java.util.logging.Logger.getLogger(AddNewItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddNewItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddNewItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddNewItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new AddNewItem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JPanel body;
    private javax.swing.JTextField brandNameField;
    private javax.swing.JPanel container;
    private javax.swing.JTextArea descriptionTextArea;
    private javax.swing.JCheckBox goodCheckBox;
    private javax.swing.JPanel header;
    private javax.swing.JLabel imageReview;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JCheckBox othersCheckBox;
    private javax.swing.JTextField piecesField;
    private javax.swing.JTextArea remarksTextArea;
    private javax.swing.JButton uploadImageBtn;
    // End of variables declaration//GEN-END:variables
}
