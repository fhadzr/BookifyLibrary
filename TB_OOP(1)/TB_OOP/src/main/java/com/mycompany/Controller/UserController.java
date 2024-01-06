/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Controller;

import com.mycompany.Model.Book;
import com.mycompany.Utility.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mycompany.Model.User;
import com.mycompany.View.AdminDashboardView;
import com.mycompany.View.UserDashboardView;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Acer
 */
public class UserController {
    
    String query = "";
  
    public boolean Login(String username, String password){
        
        AdminDashboardView homePageView = new AdminDashboardView();
        ConnectionManager conMan = new ConnectionManager();
        Connection con = conMan.LogOn();
        
        Boolean loginStatus = false;
        query = "SELECT * FROM account WHERE username ='"+username+"'"+" AND password = '"+password+"'";
        //add baris dibawah
        User userLogin = new User();
        
        try{
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            
            while(rs.next()){
                if((username.equals(rs.getString("username")) && password.equals(rs.getString("password"))) 
                        && (rs.getString("id").equals("U000"))){
                    
                    loginStatus = true;
                    homePageView.setVisible(true);
                    
                }else if(username.equals(rs.getString("username")) && password.equals(rs.getString("password"))){
                    loginStatus = true;
                    
                    userLogin.setId(rs.getString("id"));
                    userLogin.setUsername(rs.getString("username"));
                    userLogin.setPassword(rs.getString("password"));
                    userLogin.setEmail(rs.getString("email"));
                    //add baris dibawah
                    
                    UserDashboardView userDashboardView = new UserDashboardView(userLogin);
                    userDashboardView.setVisible(true);
                }
                else{
                    loginStatus = false;
                }
            }
                        
        }catch (SQLException e){
            e.getMessage();
        }
        conMan.LogOff();
        return loginStatus;
    }
    
    public boolean LogOut(){
        
        return true;
    }
    
    
    public boolean Register(String username, String password, String email){
        ConnectionManager conMan = new ConnectionManager();
        Connection con = conMan.LogOn();
        
        Boolean registerStatus = false;
        
        query = "SELECT * FROM account";
        List<User> listUser = new ArrayList<User>();
        try{
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            
            
            while(rs.next()){
                User objUser = new User(rs.getString("id"), rs.getString("username"), rs.getString("password"), rs.getString("email"));
                listUser.add(objUser);
            }
        }catch (SQLException e){
            e.getMessage();
        }
        
        query = "SELECT COUNT(*) FROM account";
        int dataCount = 0;
        try{
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                dataCount = rs.getInt("COUNT(*)");
            }
            
        }catch (SQLException e){
            e.getMessage();
        }
                
        String id;
        int rowAffected = 0;
//            System.out.println(dataCount);
        if(dataCount < 10){
            id = "U00"+(dataCount);
        }else if(dataCount < 100){
            id = "U0"+(dataCount);
        }else{
            id = "U"+(dataCount);
        }

        boolean usernameExists = false;

        for (User user : listUser) {
            if (user.getUsername().equals(username)) {
                usernameExists = true;
                break;
            }
        }

        if (!usernameExists) {
            query = "INSERT INTO account VALUES('"+id+"', '"+username+"', '"+password+"', '"+ email +"')";
            try {
                Statement stm = con.createStatement();
                rowAffected = stm.executeUpdate(query);

                if (rowAffected > 0) {
                    registerStatus = true;
                } else {
                    registerStatus = false;
                }
            } catch (SQLException e) {
                e.getMessage();
            }
        } else {
            registerStatus = false;
        }
        conMan.LogOff();
        return registerStatus;
    }
    
    public boolean changePassword(String username,String password, String newPassword){
        
        ConnectionManager conMan = new ConnectionManager();
        Connection con = conMan.LogOn();
        
        Boolean changeStatus = false;
        query = "SELECT * FROM account WHERE username ='"+username+"'"+" AND password = '"+password+"'";
        
        User userLogin = new User();
        
        try{
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            int rowAffected = 0;
            while(rs.next()){
                if(username.equals(rs.getString("username")) && password.equals(rs.getString("password"))){
                    query = "UPDATE account SET password = '"+ newPassword + "' WHERE username = '" + username + "'";
                    try{
                        rowAffected = stm.executeUpdate(query);

                        if(rowAffected > 0){
                            changeStatus = true;
                        }else{
                            changeStatus = false;
                        }
                    }catch(SQLException e){
                        e.getMessage();
                    }
                }
                else{
                    changeStatus = false;
                }
            }
//            if(correctPassword == true){
//                query = "UPDATE account SET password = '"+ newPassword + "' WHERE username = '" + username + "'";
//                try{
//                    rowAffected = stm.executeUpdate(query);
//
//                    if(rowAffected > 0){
//                        borrowStatus = true;
//                    }else{
//                        borrowStatus = false;
//                    }
//                }catch(SQLException e){
//                    e.getMessage();
//                }
//            }
                        
        }catch (SQLException e){
            e.getMessage();
        }
        conMan.LogOff();
        return changeStatus;
    }
    
    public boolean checkAccount(String username,String password){
        
        ConnectionManager conMan = new ConnectionManager();
        Connection con = conMan.LogOn();
        
        Boolean accountStatus = false;
        query = "SELECT * FROM account WHERE username ='"+username+"'"+" AND password = '"+password+"'";
        
        User userLogin = new User();
        
        try{
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            int rowAffected = 0;
            while(rs.next()){
                if(username.equals(rs.getString("username")) && password.equals(rs.getString("password"))){
                    accountStatus = true;

                }
                else{
                    accountStatus = false;
                }
            }
       
        }catch (SQLException e){
            e.getMessage();
        }
        conMan.LogOff();
        return accountStatus;
    }
}
