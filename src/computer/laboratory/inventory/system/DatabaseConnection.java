/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package computer.laboratory.inventory.system;

/**
 *
 * @author Tuason
 */
public class DatabaseConnection {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_CONNECTION_URL = "jdbc:mysql://localhost:3306/computer_laboratory_inventory_management";
    private static final String DB_USERNAME = "phpMyAdmin";
    private static final String DB_PASSWORD = "admin";
    
    // GETTERS

    public static String getJDBC_DRIVER() {
        return JDBC_DRIVER;
    }

    public static String getDB_CONNECTION_URL() {
        return DB_CONNECTION_URL;
    }

    public static String getDB_USERNAME() {
        return DB_USERNAME;
    }

    public static String getDB_PASSWORD() {
        return DB_PASSWORD;
    }
    
}
