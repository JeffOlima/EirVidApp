package eirvidapp;

import java.util.Scanner;

/**
 *
 * @author olive
 */
public class Validation {
    public static void EmailAndPasswordValidation(){
    
    Scanner input = new Scanner(System.in);
 
    //Prompt the user to enter an email
    System.out.println("Please enter your email: ");
    String email = input.nextLine();
 
    //Validate the email
    while(!email.contains("@") || !email.contains(".")){
        System.out.println("Invalid email format. Please try again:");
        email = input.nextLine();
    }
    
    System.out.println("Please enter your password: ");
    String password = input.nextLine();
 
    //Validate the password
    while(password.length() < 8){
        System.out.println("Password must be at least 8 characters. Please try again:");
        password = input.nextLine();
    }
}
}

