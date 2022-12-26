/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eirvidapp;

import User.RegularUser;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Jefferson de Oliveira Lima 2020373
 */
public class MenuOptions {

    private static RegularUser userLogged;

    public void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<RegularUser> users = new ArrayList();
        //The app is running 
        boolean running = true;
        //menu + user input 
       // MenuOutput menu = new MenuOutput();
        //menu.StartupOutput();
       // String option = scanner.nextLine();

        while (running) {
    
            
            //menu + user input 
            MenuOutput menu = new MenuOutput();
            menu.StartupOutput();
            String option = scanner.nextLine();

            //Process the user input
            switch (option) {
                case "1": {
                    //[1] REGISTER A NEW USER
                    Registration registration = new Registration();
                    userLogged = registration.Registration();
                    if (userLogged != null) {
                         System.out.println("Welcome " + userLogged.getName() + " " + userLogged.getSurname() + "!");
                        HomePage();
                    }
                    break;
                }
                case "2": {
                    //[2] LOGIN
                    Login login = new Login();
                    userLogged = login.Sign_In();
                    if (userLogged != null) {
                        System.out.println("Welcome " + userLogged.getName() + " " + userLogged.getSurname() + "!");
                        MenuOptions homepage = new MenuOptions();
                        homepage.HomePage();
                    }
                    break;
                }
                case "3": {
                    //[3] QUIT
                    running = false;
                    userLogged = null;
                    System.out.println("Shutting down the system");
                    break;
                }
                default: {
                    break;
                }
            }
        }
        System.out.println("System shutted off");
        scanner.close();
    }

    public void HomePage() {

       // boolean running = true;
        //while (running) {
            //options from the main menu 
            Scanner scanner = new Scanner(System.in);
            MenuOutput homepage = new MenuOutput();
            homepage.HomePageOutput();
                   
            String option = scanner.nextLine();

            switch (option) {
                case "1": {
                    userLogged.findMovie();
                    HomePage();
                    break;
                }
                case "2": {
                    userLogged.rentMovie();
                    HomePage();
                    break;
                }
                case "3": {
                    userLogged.getRandomMovies();
                    HomePage();
                    break;
                }
                case "4": {
                    if(userLogged == null){
                        System.out.println("null");
                    }
                    System.out.println(userLogged.getName() + " your current balance: " + userLogged.getBalance() +" \n");
                    HomePage();
                    
                    break;
                }
                case "5": {
                    userLogged.showRentedMovies();
                    HomePage();
                    break;
                }
                case "6": {
                    System.out.println("Logging out");
                   // running = false;
                    userLogged = null;
                    break;    
                }
                default: {
                    HomePage();
                    break;
                }

            }
     //   }
    }
}
