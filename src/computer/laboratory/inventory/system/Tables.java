/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package computer.laboratory.inventory.system;

import javax.swing.JTable;

/**
 *
 * @author Tuason
 */
public class Tables {
    
    // tables
    private JTable inventoryTable;
    private JTable inventoryItemTable;
    
    
    private static Tables instance = null;
    private Tables() {}
    
    public static Tables getInstance() {
        if (instance == null) {
            instance = new Tables();
        }
        return instance;
    }
    
    // GETTERS AND SETTERS

    public JTable getInventoryTable() {
        return inventoryTable;
    }

    public void setInventoryTable(JTable inventoryTable) {
        this.inventoryTable = inventoryTable;
    }

    public JTable getInventoryItemTable() {
        return inventoryItemTable;
    }

    public void setInventoryItemTable(JTable inventoryItemTable) {
        this.inventoryItemTable = inventoryItemTable;
    }
    
    
}
