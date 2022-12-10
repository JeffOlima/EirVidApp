
package dao;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
import model.User;


public class UserDao {
     //CONSTANTS
    private static final String DB_URL= "jdbc:mysql://localhost:3306"; 
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD= "root"; 
    
    private static final String SELECT_SQL = "SELECT * FROM starmovies.user";
    private static final String SELECT_BY_EMAIL = "SELECT * FROM starmovies.user WHERE email = ?";
    private static final String INSERT_SQL = "INSERT INTO starmovies.user (name, surname, yearbirth, cardnumber, email, password)VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_SQL = "UPDATE starmovies.user  SET name = ?, surname = ?, yearbirth = ?, cardnumber = ?, email = ?, password = ?  WHERE id = ?";    
    private static final String DELETE_SQL = "DELETE FROM starmovies.user WHERE id = ?";
    
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
}