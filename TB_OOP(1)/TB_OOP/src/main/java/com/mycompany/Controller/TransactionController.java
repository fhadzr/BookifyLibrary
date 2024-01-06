/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Controller;

import com.mycompany.Utility.ConnectionManager;
import com.mycompany.Model.Transaction;
import com.mycompany.Model.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class TransactionController {
    String query;
    
    public List<Transaction> showTransactionAdmin(){        
        ConnectionManager conMan = new ConnectionManager();
        Connection con = conMan.LogOn();
        
        List<Transaction> listTrans = new ArrayList<Transaction>();
        
        query = "SELECT * FROM transaction";
                
        try{
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                Transaction trans = new Transaction();
                trans.setTransaction_id(rs.getInt("transaction_id"));
                trans.setUser_id(rs.getString("id"));
                trans.setBook_id(rs.getString("book_id"));
                trans.setBorrow_date(rs.getString("borrow_date"));
                trans.setReturn_date(rs.getString("return_date"));
                trans.setBorrow_status(rs.getInt("borrow_status"));
                trans.setReturn_status(rs.getInt("return_status"));
                listTrans.add(trans);
            }
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
        
        return listTrans;
    }
    
    public List<Transaction> showTransactionUser(String id){        
        ConnectionManager conMan = new ConnectionManager();
        Connection con = conMan.LogOn();
        
        List<Transaction> listTrans = new ArrayList<Transaction>();
        
        query = "SELECT * FROM transaction WHERE id = '"+ id +"'";
                
        try{
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                Transaction trans = new Transaction();
                trans.setTransaction_id(rs.getInt("transaction_id"));
                trans.setUser_id(rs.getString("id"));
                trans.setBook_id(rs.getString("book_id"));
                trans.setBorrow_date(rs.getString("borrow_date"));
                trans.setReturn_date(rs.getString("return_date"));
                trans.setBorrow_status(rs.getInt("borrow_status"));
                trans.setReturn_status(rs.getInt("return_status"));
                listTrans.add(trans);
            }
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
        
        return listTrans;
    }
    
    public LocalDate getDueDate(int transaction_id){
        ConnectionManager conMan = new ConnectionManager();
        Connection con = conMan.LogOn();
        
        query = "SELECT return_date FROM transaction WHERE transaction_id = '"+transaction_id+"'";
        try{
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            if (rs.next()) {
                java.sql.Date sqlDueDate = rs.getDate("return_date");
                return sqlDueDate.toLocalDate();
            }
        }catch(SQLException e){
            e.getMessage();
        }
        return null;
    }
    
    public boolean ManageTransaction(int transaction_id,String return_date, int return_status, int borrow_status){
        Boolean updateStatus = false;
        ConnectionManager conMan = new ConnectionManager();
        Connection con = conMan.LogOn();
            
        LocalDate dueDate = getDueDate(transaction_id);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate currentDate = LocalDate.parse(return_date, formatter);
        
        if (dueDate.isBefore(currentDate)) {
            // Tanggal pengembalian sudah lewat
            int rowAffected = 0;
            query = "UPDATE transaction SET return_date = '" + return_date + "', borrow_status = " + 
                borrow_status + ", return_status = " + return_status + " WHERE transaction_id = " + transaction_id;

            // Menghitung selisih hari
            long daysLate = ChronoUnit.DAYS.between(dueDate, currentDate);

            // Menghitung denda per hari
            double fineRatePerDay = 10.0;//(dollar)

            // Menghitung total denda
            double totalFine = daysLate * fineRatePerDay;

            // Menampilkan pesan dengan jumlah denda
            String fineMessage = String.format("Transaksi harus dikenai denda sebesar %.2f karena terlambat selama %d hari.", totalFine, daysLate);
            JOptionPane.showMessageDialog(null, fineMessage, "Denda", JOptionPane.WARNING_MESSAGE);

            try {
                Statement stm = con.createStatement();
                rowAffected = stm.executeUpdate(query);

                if (rowAffected > 0) {
                    updateStatus = true;
                } else {
                    updateStatus = false;
                }
            } catch (SQLException e) {
                e.printStackTrace(); // Tampilkan kesalahan untuk debugging
                updateStatus = false;
            }
        }
        else{
            int rowAffected = 0;
            query = "UPDATE transaction SET return_date = '"+ return_date +"', borrow_status = "+ 
                borrow_status +", return_status = "+return_status+" WHERE transaction_id = "+transaction_id;
        
            try{
                Statement stm = con.createStatement();
                rowAffected = stm.executeUpdate(query);

                if(rowAffected > 0){
                    updateStatus = true;
                }else{
                    updateStatus = false;      
                }   
            }catch(SQLException e){
                e.getMessage();
            }  
        }       
        return updateStatus;
    }
    
    public List<Transaction> searchTrans(String key){
        ConnectionManager conMan = new ConnectionManager();
        Connection con = conMan.LogOn();
        List<Transaction> listTrans = new ArrayList<Transaction>();
        String query = "Select * from transaction where " +
                "book_id LIKE '%" + key + "'";
        
        try{
           Statement stm = con.createStatement();
           ResultSet rs = stm.executeQuery(query);
           while(rs.next()){
               Transaction trans = new Transaction();
               trans.setTransaction_id(rs.getInt("transaction_id"));
               trans.setUser_id(rs.getString("user_id"));
               trans.setBook_id(rs.getString("book_id"));
               trans.setBorrow_date(rs.getString("borrow_date"));
               trans.setReturn_date(rs.getString("return_date"));
               trans.setBorrow_status(rs.getInt("borrow_status"));
               trans.setReturn_status(rs.getInt("return_status"));
               listTrans.add(trans);
           }
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
        
        return listTrans;
    }
    
    public boolean deleteHistory(int transId){
        
        ConnectionManager conMan = new ConnectionManager();
        Connection con = conMan.LogOn();
        
        String query = "delete from transaction where transaction_id = '" + transId + "'";
        try{
            Statement stm = con.createStatement();
            stm.executeUpdate(query);
            return true;
        }catch (Exception ex){
            System.out.println(ex.toString());
            return false;
        }
    }
    
}
