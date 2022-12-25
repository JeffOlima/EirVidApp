/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eirvidapp;

/**
 *
 * @author Jefferson de Oliveira Lima 2020373
 */

import User.RegularUser;

public class EirVidApp {

    public static RegularUser userLogged = null;
   // public static Scanner scanner = new Scanner(System.in);
 //   private static final List<Movie> movies = new MovieList().createMovieList();
    
    public static void main(String[] args) {
        System.out.println("Start.....................................\n");
        MenuOptions start = new MenuOptions();
        start.mainMenu();
    }
}
