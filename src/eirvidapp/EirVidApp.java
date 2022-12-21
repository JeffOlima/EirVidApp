
package eirvidapp;


import User.User;
import eirvidapp.OutputHomePage;

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
           menu.StartupOutput();
            String option = scanner.nextLine();
            
            //Process the user input
            switch (option){
                case "1": {
                 String name, surname, yearofbirth, cardNumber, email, password;
                   double balance; 
                     do {
                     System.out.println("Please enter your name (Only letters and no space):");
                     name = scanner.nextLine();
                     if (name.matches("[a-zA-Z]+")) {
                      break;
                     } else {
                     System.out.println("Name is invalid. Please enter a valid name (Only letters and no spaces).");
                     }
                     } while (true);
                      
                    do {
                    System.out.println("Please enter your surname (Only letters and no space):");
                    surname = scanner.nextLine();
                    if (surname.matches("[a-zA-Z]+")) {
                    break;
                    } else {
                    System.out.println("Surname is invalid. Please enter a valid surname (Only letters and no spaces).");
                    }
                    } while (true);

                    do {
                   System.out.println("Please enter your date of birth (DD/MM/YYYY):");
                   yearofbirth = scanner.nextLine();
                    if (yearofbirth.matches("((0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/[0-9]{4})")) {
                   break;
                   } else {
                   System.out.println("Date of birth is invalid. Please enter a valid date of birth (DD/MM/YYYY).");
                   }
                   } while (true);

                    do {
                    System.out.println("Please enter your card number (Must be 16 numbers):");
                    cardNumber = scanner.nextLine();
                    if (cardNumber.matches("[0-9]{16}")) {
                    break;
                    } else {
                   System.out.println("Card number is invalid. Please enter a valid card number (Must be 16 numbers).");
                   }
                   } while (true);

                   do {
                   System.out.println("Please enter your email:");
                   email = scanner.nextLine();
                   if (email.matches("[a-zA-Z0-9_.]+@[a-zA-Z]+\\.[a-zA-Z]+")) {
                   break;
                   } else {
                   System.out.println("Email is invalid. Please enter a valid email.");
                   }
                   } while (true);

                   do {
                   System.out.println("Please enter your password (Must be more than 8 characters):");
                   password = scanner.nextLine();
                   if (password.matches(".{8,}")) {
                   break;
                   } else {
                   System.out.println("Password is invalid. Please enter a valid password (Must be more than 8 characters).");
                   }
                   } while (true);
                   
                   do {
                   System.out.println("Please enter your balance");
                   balance = scanner.nextDouble();
                   if (balance > 0) {
                   break;
                   } else {
                   System.out.println("must be more than 0");
                   }
                   } while (true);
                   
                    Registration registration = new Registration();
                    registration.Reg(name, surname, yearofbirth, cardNumber, email, password, balance);
                   
                    break;
                }
                case "2":{
                      Scanner input = new Scanner(System.in);
 
                    System.out.println("===== LOGIN =====");
                    System.out.println("Type the email");
                    String email = scanner.nextLine();
                    System.out.println("Type the password");
                    String password = scanner.nextLine();


                    Login login = new Login();
                    login.Log_IN(email, password);
                    if(login.Log_IN(email, password)){
                       // userLogged = u;
                        HomePage();
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
    
    public static void HomePage(){
        
        boolean running = true;
        while(running){
         //options from the main menu 
            OutputHomePage homepage = new OutputHomePage();
            homepage.homePage();
      
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

