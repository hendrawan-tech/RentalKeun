/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import com.mysql.cj.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hendra
 */
public class Functions {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_NAME = "rentalkeun";
    private static final String USER = "rentalkeun";
    private static final String PASSWORD = "Bismillah5758";
    private static final String URL = "jdbc:mysql://db4free.net:3306/" + DB_NAME;

    private static String email;
    private static String id_mobil;
    private static String id_user;

    public static Connection configDB() throws SQLException {
        DriverManager.registerDriver(new Driver());
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        return connection;
    }

    public static boolean isConnected() {
        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database Connected");
            return true;
        } catch (Exception e) {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Database Not Connection");
            return false;
        }
    }

    public static void main(String[] args) {
        isConnected();
    }

    public static String get_id_mobil() {
        return id_mobil;
    }

    public static String get_email() {
        return email;
    }

    public static String get_id_user() {
        return id_user;
    }

    public static void set_email(String data) {
        email = data;
    }

    public static void set_id_mobil(String data) {
        id_mobil = data;
    }
    
    public static void set_id_user(String data) {
        id_user = data;
    }
}
