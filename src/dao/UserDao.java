/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dao;

import User.RegularUser;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;


public class UserDao {
     //CONSTANTS
    private static final String DB_URL= "jdbc:mysql://localhost:3306"; 
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD= "root"; 
    
    private static final String SELECT_SQL = "SELECT * FROM eirvidapp.user";
    private static final String SELECT_BY_EMAIL = "SELECT * FROM eirvidapp.user WHERE email = ?";
    private static final String INSERT_SQL = "INSERT INTO eirvidapp.user (name, surname, yearbirth, cardnumber, email, password,)VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_SQL = "UPDATE eirvidapp.user  SET name = ?, surname = ?, yearbirth = ?, cardnumber = ?, email = ?, password = ?  WHERE id = ?";    
    private static final String DELETE_SQL = "DELETE FROM eirvidapp.user WHERE id = ?";
    
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        
//        System.out.println("Type the name");
//        String name = scanner.nextLine();
//        System.out.println("Type the surname");
//        String surname = scanner.nextLine();
//        System.out.println("Type Year of birth");
//        String yearbirth = scanner.nextLine();
//        System.out.println("Type Card number");
//        String cardNumber = scanner.nextLine();
//        System.out.println("Type the email");
//        String email = scanner.next();
//        System.out.println("Type the password");
//        String password = scanner.next();
//        
//        RegularUser user = new RegularUser();
//        user.setName(name);
//        user.setSurname(surname);
//        user.setYearOfBirth(yearbirth);
//        user.setCardNumber(cardNumber);
//        user.setEmail(email);
//        user.setPassword(password);
//        
//        insertUser(user);
//        
//    //CRUD methods - Create Read Update Delete
//}
    
    public static ArrayList<RegularUser> searchUsers(){
        
        ArrayList<RegularUser> users = new ArrayList();
        
        //Java DataBase Connection (JDBC)
        try{
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
            
            Connection c = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            
            PreparedStatement stmt = c.prepareStatement(SELECT_SQL);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String yearbirth = rs.getString("yearbirth");
                String cardNumber= rs.getString("cardnumber");
                String email= rs.getString("email");
                String password= rs.getString("password");
                double balance = rs.getDouble("balance");

                RegularUser user = new RegularUser();
                user.setId(id);
                user.setName(name);
                user.setSurname(surname);
                user.setYearOfBirth(yearbirth);
                user.setCardNumber(cardNumber);
                user.setEmail(email);
                user.setPassword(password);
                user.setBalance(balance);
                
                users.add(user);
                
                
              
            }
            
            stmt.close();
            c.close();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return users;
    } 
    
    public static RegularUser searchUserByEmail(String email){

        RegularUser user = null;
        
        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
            
            Connection c = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            
            PreparedStatement stmt = c.prepareStatement(SELECT_BY_EMAIL);       
        
            stmt.setString(1, email);
            
            ResultSet rs =stmt.executeQuery();
            
            if (rs.next()){
                
                int id = rs.getInt("id");
                String password = rs.getString("password");
                
                user = new RegularUser();
                user.setId(id);
                user.setEmail(email);
                user.setPassword(password);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static boolean insertUser(RegularUser user){
        boolean success = false;
        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
            
            Connection c = DriverManager.getConnection(DB_URL,DB_USER, DB_PASSWORD );
            
            PreparedStatement stmt = c.prepareStatement(INSERT_SQL);       
        
            stmt.setString(1,user.getName());
            stmt.setString(2,user.getSurname() );
            stmt.setString(3,user.getYearOfBirth() );
            stmt.setString(4,user.getCardNumber() );
            stmt.setString(5,user.getEmail());
            stmt.setString(6,user.getPassword());
        
            int rowsAffected = stmt.executeUpdate();
            
        if (rowsAffected > 0){
            success = true;
        }
        } catch (Exception e) {
                e.printStackTrace();
        }
        return success;
        } 
    
    public static boolean updateUser(RegularUser user){
       
        boolean success = false;
        
        try {
            
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
            
            Connection c = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            
            PreparedStatement stmt = c.prepareStatement(UPDATE_SQL);       
        
            stmt.setString(1,user.getName() );
            stmt.setString(2,user.getSurname() );
            stmt.setString(3,user.getYearOfBirth());
            stmt.setString(4,user.getCardNumber() );
            stmt.setString(5,user.getEmail() );
            stmt.setString(6,user.getPassword());
            stmt.setInt(7,user.getId());
            
            int rowsAffected = stmt.executeUpdate();
            
            if (rowsAffected > 0){
            success = true;
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    
    
} 
    
    public static boolean deleteUser(RegularUser user){

     boolean success = false;
        try {
            
              Driver driver = new Driver();
            DriverManager.registerDriver(driver);
            
            Connection c = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            
            PreparedStatement stmt = c.prepareStatement(DELETE_SQL);
            
            stmt.setInt (1, user.getId());
            
            int rowsAffected = stmt.executeUpdate();
            
            if (rowsAffected > 0){
            success = true;
            }else{
           success = false;
        }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
}
}
