
package dao;

import com.mysql.cj.jdbc.Driver;
import model.User;

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
    private static final String INSERT_SQL = "INSERT INTO eirvidapp.user (name, surname, yearbirth, cardnumber, email, password)VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_SQL = "UPDATE eirvidapp.user  SET name = ?, surname = ?, yearbirth = ?, cardnumber = ?, email = ?, password = ?  WHERE id = ?";    
    private static final String DELETE_SQL = "DELETE FROM eirvidapp.user WHERE id = ?";
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Type the name");
        String name = scanner.nextLine();
        System.out.println("Type the surname");
        String surname = scanner.nextLine();
        System.out.println("Type Year of birth");
        int yearbirth = scanner.nextInt();
        System.out.println("Type Card number");
        int cardNumber = scanner.nextInt();
        System.out.println("Type the email");
        String email = scanner.next();
        System.out.println("Type the password");
        String password = scanner.next();
        
        User u = new User();
        u.setName(name);
        u.setSurname(surname);
        u.setYearOfBirth(yearbirth);
        u.setCardNumber(cardNumber);
        u.setEmail(email);
        u.setPassword(password);
        
        insertUser(u);
        
    //CRUD methods - Create Read Update Delete
}
    
    public static ArrayList<User> searchUsers(){
        
        ArrayList<User> users = new ArrayList();
        
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
                int yearbirth = rs.getInt("yearbirth");
                int cardNumber= rs.getInt("cardnumber");
                String email= rs.getString("email");
                String password= rs.getString("password");
                
                User u = new User();
                u.setId(id);
                u.setName(name);
                u.setSurname(surname);
                u.setYearOfBirth(yearbirth);
                u.setCardNumber(cardNumber);
                u.setEmail(email);
                u.setPassword(password);
                
                users.add(u);
                
                
              
            }
            
            stmt.close();
            c.close();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return users;
    } 
    
    public static User searchUserByEmail(String email){
        
        User u = null;
        
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
                
                u = new User();
                u.setId(id);
                u.setEmail(email);
                u.setPassword(password);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    public static boolean insertUser(User u){
        boolean success = false;
        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
            
            Connection c = DriverManager.getConnection(DB_URL,DB_USER, DB_PASSWORD );
            
            PreparedStatement stmt = c.prepareStatement(INSERT_SQL);       
        
            stmt.setString(1,u.getName());
            stmt.setString(2,u.getSurname() );
            stmt.setInt(3,u.getYearOfBirth() );
            stmt.setInt(4,u.getCardNumber() );
            stmt.setString(5,u.getEmail());
            stmt.setString(6,u.getPassword());
        
            int rowsAffected = stmt.executeUpdate();
            
        if (rowsAffected > 0){
            success = true;
        }
        } catch (Exception e) {
                e.printStackTrace();
        }
        return success;
        } 
    
    public static boolean updateUser(User u){
       
        boolean success = false;
        
        try {
            
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
            
            Connection c = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            
            PreparedStatement stmt = c.prepareStatement(UPDATE_SQL);       
        
            stmt.setString(1,u.getName() );
            stmt.setString(2,u.getSurname() );
            stmt.setInt(3,u.getYearOfBirth());
            stmt.setInt(4,u.getCardNumber() );
            stmt.setString(5,u.getEmail() );
            stmt.setString(6,u.getPassword());
            stmt.setInt(7,u.getId());
            
            int rowsAffected = stmt.executeUpdate();
            
            if (rowsAffected > 0){
            success = true;
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    
    
} 
    
    public static boolean deleteUser(User u){

     boolean success = false;
        try {
            
              Driver driver = new Driver();
            DriverManager.registerDriver(driver);
            
            Connection c = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            
            PreparedStatement stmt = c.prepareStatement(DELETE_SQL);
            
            stmt.setInt (1, u.getId());
            
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