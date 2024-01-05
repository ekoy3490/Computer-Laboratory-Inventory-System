/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package computer.laboratory.inventory.system;

import static computer.laboratory.inventory.system.DatabaseConnection.getDB_CONNECTION_URL;
import static computer.laboratory.inventory.system.DatabaseConnection.getDB_PASSWORD;
import static computer.laboratory.inventory.system.DatabaseConnection.getDB_USERNAME;
import static computer.laboratory.inventory.system.DatabaseConnection.getJDBC_DRIVER;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Tuason
 */
public class Helper {
    
    // ### INVENTORY ###
    public static void displayInventory(String room) {
        Connection connection = null;
        PreparedStatement selectStatement = null;
        ResultSet selectRs = null;
        
        try {
            Class.forName(getJDBC_DRIVER());
            connection = DriverManager.getConnection(getDB_CONNECTION_URL(), getDB_USERNAME(), getDB_PASSWORD());
            String selectQuery = "SELECT * FROM inventory WHERE laboratory_room=? ORDER BY date DESC";
            selectStatement = connection.prepareStatement(selectQuery);
            selectStatement.setString(1, room);
            selectRs = selectStatement.executeQuery();
            JTable table = Tables.getInstance().getInventoryTable();

            DefaultTableModel defaultTable = (DefaultTableModel) table.getModel();
            defaultTable.setRowCount(0); 

            while (selectRs.next()) {
                Object[] row = {
                    selectRs.getString("inventory_id"),
                    selectRs.getString("date"),
                    selectRs.getString("inventory_by")
                };

                defaultTable.addRow(row); 
            }

            // Create a custom cell renderer to center the values in the specified column
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

            // Set the custom renderer for the specified column
            table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
            table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
            
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
             try {
                if (selectRs != null) {
                    selectRs.close();
                }
                if (selectStatement != null) {
                    selectStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    
    public static void searchInventory(String searchText, String room) {
        Connection connection = null;
        PreparedStatement selectStatement = null;
        ResultSet selectRs = null;
        
        try {
            Class.forName(getJDBC_DRIVER());
            connection = DriverManager.getConnection(getDB_CONNECTION_URL(), getDB_USERNAME(), getDB_PASSWORD());
            String selectQuery = "SELECT * FROM inventory WHERE (inventory_by LIKE ? OR date LIKE ?) AND laboratory_room=? ORDER BY date DESC";
            selectStatement = connection.prepareStatement(selectQuery);
            selectStatement.setString(1, "%" + searchText + "%");
            selectStatement.setString(2, "%" + searchText + "%");
            selectStatement.setString(3, room);
            selectRs = selectStatement.executeQuery();
            JTable table = Tables.getInstance().getInventoryTable();

            DefaultTableModel defaultTable = (DefaultTableModel) table.getModel();
            defaultTable.setRowCount(0); 

            while (selectRs.next()) {
                Object[] row = {
                    selectRs.getString("inventory_id"),
                    selectRs.getString("date"),
                    selectRs.getString("inventory_by")
                };

                defaultTable.addRow(row); 
            }

            // Create a custom cell renderer to center the values in the specified column
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

            // Set the custom renderer for the specified column
            table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
            table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
            
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
             try {
                if (selectRs != null) {
                    selectRs.close();
                }
                if (selectStatement != null) {
                    selectStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    
    // ### INVENTORY ITEMS ###
    public static void displayInventoryItems(int inventoryId, String room) {
        // DATABASE
        Connection connection = null;
        PreparedStatement selectStatement = null;
        ResultSet selectRs = null;

        try {
            
            Class.forName(getJDBC_DRIVER());
            connection = DriverManager.getConnection(getDB_CONNECTION_URL(), getDB_USERNAME(), getDB_PASSWORD());
            String selectQuery = "SELECT * FROM inventory_item WHERE inventory_id=? AND laboratory_room=?";
            selectStatement = connection.prepareStatement(selectQuery);
            selectStatement.setInt(1, inventoryId);
            selectStatement.setString(2, room);
            selectRs = selectStatement.executeQuery();
            JTable table = Tables.getInstance().getInventoryItemTable();

            DefaultTableModel defaultTable = (DefaultTableModel) table.getModel();
            defaultTable.setRowCount(0); 
            
            while (selectRs.next()) {
                
                Object[] row = {
                    selectRs.getString("item_id"),
                    selectRs.getString("brand_name"),
                    selectRs.getInt("pieces"),
                    selectRs.getString("remarks")
                };

                defaultTable.addRow(row); 
            }

            // Create a custom cell renderer to center the values in the specified column
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

            // Set the custom renderer for the specified column
            table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
            table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
            
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
             try {
                
                if (selectStatement != null) {
                    selectStatement.close();
                }
                if (selectRs != null) {
                    selectRs.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
}
