/*package eirvidapp;



//import dao.UserDao;
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
           Menu menu = new Menu();
           menu.OutputFirstPart();
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
                    
                    Login login = new Login();
                    login.Log_IN(email, password);
                    if(login.Log_IN(email, password)){
                       // userLogged = u;
                        homePage();
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
        System.out.println("[4] Logout");
      
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
                 System.out.println("Logging out");
                 running = false;
                 userLogged = null;
                break;
            }  
           
        }
        }
    }
}
*/