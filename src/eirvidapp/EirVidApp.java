/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eirvidapp;

import Movie.Movie;
import Movie.MovieList;
import User.RegularUser;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EirVidApp {

    public static RegularUser userLogged = null;
    public static Scanner scanner = new Scanner(System.in);
    private static final List<Movie> movies = new MovieList().createMovieList();
    
    public static void main(String[] args) {
        
        userLogged = new RegularUser(0, "Bekezhan", "Abdykarimov", "1999", "12345678912345", "by.bekardi@gmail.com", "213124124", 100.0);
        userLogged.rentMovie(movies);
    }
    
/*
    public static void main(String[] args) {

        ArrayList<RegularUser> users = new ArrayList();
        //The app is running 
        boolean running = true;
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
                    break;
                }
                case "2": {
                    //[2] LOGIN
                    Login login = new Login();
                    login.Sign_In();
                    break;
                }
                case "3": {
                    //[3] QUIT
                    running = false;
                    System.out.println("Shutting down the system");
                    break;
                }
                default: {
                    break;
                }
            }
        }
        System.out.println("System shutted off");
    }

    public static void HomePage() {

        boolean running = true;
        while (running) {
            //options from the main menu 
            MenuOutput homepage = new MenuOutput();
            homepage.HomePageOutput();

            String option = scanner.nextLine();

            switch (option) {
                case "1": {
                    userLogged.findMovie(movies);
                    break;
                }
                case "2": {
                    userLogged.rentMovie(movies);
                    break;
                }
                case "3": {
                    
                    break;
                }
                case "4": {
                    System.out.println("Logging out");
                    running = false;
                    userLogged = null;
                    break;
                }

            }
        }
    }*/
}
