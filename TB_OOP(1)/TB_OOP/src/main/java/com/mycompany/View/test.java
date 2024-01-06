/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.View;

import com.mycompany.Model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author asus
 */
public class test {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/perpustakaan";
    static final String USER = "root";
    static final String PASS = "";
    public static void main(String[] args) {
 
        Connection conn = null;
        Statement stmt = null;

        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // Buka koneksi
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Buat statement
            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            // Query untuk mengambil semua data dari tabel account
            String sql = "SELECT id, username, password, email FROM account";
            ResultSet rs = stmt.executeQuery(sql);

            // Username yang ingin diambil
            String targetUsername = "gilang";

            // Iterasi hasil query untuk mencari data dengan username tertentu
            while (rs.next()) {
                String id = rs.getString("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");

                // Filter data berdasarkan username yang diinginkan
                if (username.equals(targetUsername)) {
                    // Tampilkan data yang sesuai
                    System.out.println("ID: " + id);
                    System.out.println("Username: " + username);
                    System.out.println("Password: " + password);
                    System.out.println("Email: " + email);
                    break; // Keluar dari loop setelah menemukan data yang sesuai
                }
            }

            // Tutup semua sumber daya
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Tutup sumber daya di blok finally
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
                // Tidak perlu melakukan apa-apa
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
