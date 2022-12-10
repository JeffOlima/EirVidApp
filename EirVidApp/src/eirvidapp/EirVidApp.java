package eirvidapp;



import dao.UserDao;
import model.User;
import java.util.ArrayList;
import java.util.Scanner;


public class EirVidApp {

    public static User userLogged = null; 
    public static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        
        ArrayList<User> users = new ArrayList();
        
        boolean running = true;
        while (running){
            
            //menu + user input 
            System.out.println("===== LOGIN PAGE =====");
            System.out.println("[1] REGISTER A NEW USER");
            System.out.println("[2] LOGIN");
            System.out.println("[3] QUIT");
            System.out.println("SELECT AN OPTION");
            String option = scanner.nextLine();
            
            //Process the user input
            switch (option){
                case "1": {
                    System.out.println("===== USER REGISTRATION =====");
                    System.out.println("Type the name");
                    String name = scanner.nextLine();
                    System.out.println("Type the surname");
                    String surname = scanner.nextLine();
                    System.out.println("Type Year of birth");
                    int yearofbirth = scanner.nextInt();
                    System.out.println("Type Card number");
                    int cardNumber = scanner.nextInt();
                    System.out.println("Type the email");
                    String email = scanner.next();
                    System.out.println("Type the password");
                    String password = scanner.next();
                
                     User u = new User();
                
                    u.setName(name);
                    u.setSurname(surname);
                    u.setYearOfBirth(yearofbirth);
                    u.setCardNumber(cardNumber);
                    u.setEmail(email);
                    u.setPassword(password);
        
                    boolean registered = UserDao.insertUser(u);
                    
                    if (registered){
                        System.out.println("-----> USER SUCCESSFULY REGITERED");
                    }else{
                    System.out.println("-----> ERROR, TRY AGAIN");
                    }
                    break;
                }
                case "2":{
                    System.out.println("===== LOGIN =====");
                    System.out.println("Type the email");
                    String email = scanner.nextLine();
                    System.out.println("Type the password");
                    String password = scanner.nextLine();
                    
                    User u = UserDao.searchUserByEmail(email);
                    
                    boolean successLogin = false;
                    
                    if (u != null && u.getPassword().equals(password)){
                        successLogin = true;
                    }
// 
                    if (!successLogin){
                        System.out.println("-----> YOU LOGGED IN");
                        userLogged = u;
                        homePage();
                    } else{
                        System.out.println("-----> Email/password incorrect");
                    }
                    
                    break;
                }
                case "3":{
                    running = false;
                    System.out.println("Shutting down the system");
                    break;
                }
                default:{
                    break;
                 }
            }   
        }
        System.out.println("System shutted off");
    }
    
    public static void homePage(){
        
        boolean running = true;
        while(running){
            //options from the main menu 
        System.out.println("===== HOME PAGE =====");  
        System.out.println("SELECT AN OPTION");
        System.out.println("[1] ");
        System.out.println("[2] ");
        System.out.println("[3] ");
        System.out.println("[4] ");
        System.out.println("[5] ");
        System.out.println("[6] Logout");
      
        String option = scanner.nextLine();
        
        switch (option){
            case "1":{
                break;
            }
             case "2":{
                break;
            }
              case "3":{
                break;
            }
             case "4":{
                break;
            }  
             case "5":{
                break;
            }
             case "6":{
                 System.out.println("Logging out");
                 running = false;
                 userLogged = null;
                break;
            } 
            
        }
        }
    }
}
