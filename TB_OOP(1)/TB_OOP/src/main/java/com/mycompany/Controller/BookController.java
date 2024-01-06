/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Controller;

import com.mycompany.Utility.ConnectionManager;
import com.mycompany.Model.Book;
import com.mycompany.Model.Transaction;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author atha
 */
public class BookController {
    ConnectionManager conMan = new ConnectionManager();
    Connection con = conMan.LogOn();
    
    public boolean insertBook(int book_id, String book_category, String book_name, String book_author, int quantity){
        String query = "INSERT INTO book values "
                + "('" + book_id + "', " 
                + "'" + book_category + "', "
                + "'" + book_name + "', "
                + "'" + book_author + "', "
                + quantity +")";
        try{
            Statement stm = con.createStatement();
            stm.executeUpdate(query);
            return true;
        } catch (Exception ex){
            System.out.println(ex.toString());
            return false;
        }
    }
    
    public List<Book> showBook(){
        List<Book> listBook = new ArrayList<Book>();
        String  query = "Select * from book";
        
        try{
            Statement stm = con.createStatement();
            ResultSet rs;
            rs = stm.executeQuery(query);
            while(rs.next()){
                Book book = new Book();
                book.setBook_id(rs.getInt("book_id"));
                book.setBook_category(rs.getString("book_category"));
                book.setBook_name(rs.getString("book_name"));
                book.setBook_author(rs.getString("book_author"));
                book.setQuantity(rs.getInt("quantity"));
                listBook.add(book);
            }
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
        return listBook;
    }
    
    public List<Book> showBookByCategory(String book_category){
        List<Book> listBook = new ArrayList<Book>();
        String  query = "Select * from book where book_category = '"+ book_category + "'";
        
        try{
            Statement stm = con.createStatement();
            ResultSet rs;
            rs = stm.executeQuery(query);
            while(rs.next()){
                Book book = new Book();
                book.setBook_id(rs.getInt("book_id"));
                book.setBook_category(rs.getString("book_category"));
                book.setBook_name(rs.getString("book_name"));
                book.setBook_author(rs.getString("book_author"));
                book.setQuantity(rs.getInt("quantity"));
                listBook.add(book);
            }
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
        return listBook;
    }
    
    public boolean updateBook(int book_id, String book_category, String book_name, String book_author, int quantity){
        String query = "Update book SET book_name = '"
                + book_name + "', book_category = '" + book_category +
                "', book_author = '" + book_author + "', " 
                + "quantity = " + quantity +
                " WHERE book_id = '" + book_id + "'";
        
        try {
            Statement stm = con.createStatement();
            stm.executeUpdate(query);
            return true;
        } catch(Exception ex){
            System.out.println(ex.toString());
            return false;
        }
    }
    
    public boolean updateQtt(int book_id){
        String query = "Update book SET quantity = quantity + 1 WHERE book_id = " + book_id;
        
        try {
            Statement stm = con.createStatement();
            stm.executeUpdate(query);
            return true;
        } catch(Exception ex){
            System.out.println(ex.toString());
            return false;
        }
    }
    
    public boolean deleteBook(int book_id){
        String query = "delete from book where book_id = '" + book_id + "'";
        try{
            Statement stm = con.createStatement();
            stm.executeUpdate(query);
            return true;
        }catch (Exception ex){
            System.out.println(ex.toString());
            return false;
        }
    }
    
    public List<Book> searchBook(String key){
        List<Book> listBook = new ArrayList<Book>();
        String query = "Select * from book where " +
                "book_name LIKE '%" + key + "%'";
        
         try{
            Statement stm = con.createStatement();
            ResultSet rs;
            rs = stm.executeQuery(query);
            while(rs.next()){
                Book book = new Book();
                book.setBook_id(rs.getInt("book_id"));
                book.setBook_category(rs.getString("book_category"));
                book.setBook_name(rs.getString("book_name"));
                book.setBook_author(rs.getString("book_author"));
                book.setQuantity(rs.getInt("quantity"));
                listBook.add(book);
            }
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
        return listBook;
    }
    
    public List<Book> searchBookCategory(String key){
        List<Book> listBook = new ArrayList<Book>();
        String query = "Select * from book where " +
                "book_category LIKE '%" + key + "%'";
        
         try{
            Statement stm = con.createStatement();
            ResultSet rs;
            rs = stm.executeQuery(query);
            while(rs.next()){
                Book book = new Book();
                book.setBook_id(rs.getInt("book_id"));
                book.setBook_category(rs.getString("book_category"));
                book.setBook_name(rs.getString("book_name"));
                book.setBook_author(rs.getString("book_author"));
                book.setQuantity(rs.getInt("quantity"));
                listBook.add(book);
            }
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
        return listBook;
    }
    
    public boolean borrowBook(String id, int book_id, List<Book> listBook){
        Boolean borrowStatus = false;
        Boolean insertStatus = false;
        String bkId = null;
        String query;
        
        int bookQty = 0;
        int rowAffected = 0;
       
        
        LocalDate borrowDate = LocalDate.now();
        LocalDate returnDate = LocalDate.now().plusDays(7);
        
        for (Book book : listBook)
        {
            if(book_id == book.getBook_id()){
                bkId = Integer.toString(book.getBook_id());
                bookQty = book.getQuantity();
                break;
            }
        }
        
        if((bookQty - 1) >= 0){
            query = "INSERT INTO transaction VALUES (NULL, '"+id+"', '"+bkId+"', '"+borrowDate+"', '"+returnDate+"', "+0+","+0+")";

            try{
                Statement stm = con.createStatement();
                rowAffected = stm.executeUpdate(query);
                
                if(rowAffected > 0){
                    insertStatus = true;
                }else{
                    insertStatus = false;
                }
            }catch(SQLException e){
                e.getMessage();
            }
            
            rowAffected = 0;
            
            if(insertStatus = true){
                query = "UPDATE book SET quantity = "+ (bookQty - 1) + " WHERE book_id = '"+bkId+"'";
                try{
                    Statement stm = con.createStatement();
                    rowAffected = stm.executeUpdate(query);

                    if(rowAffected > 0){
                        borrowStatus = true;
                    }else{
                        borrowStatus = false;
                    }
                }catch(SQLException e){
                    e.getMessage();
                }
            }
        }
        else{
            borrowStatus = false;
        }
        return borrowStatus;
    }
}
