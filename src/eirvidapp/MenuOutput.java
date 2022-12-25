/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eirvidapp;

import java.util.Scanner;

public class MenuOutput {


    /**
 *
 * @author Jefferson de Oliveira Lima 2020373
 */


    public void StartupOutput() {
        //menu + user input
        System.out.println("===== LOGIN PAGE =====");
        System.out.println("[1] REGISTER A NEW USER");
        System.out.println("[2] LOGIN");
        System.out.println("[3] QUIT");
        System.out.println("SELECT AN OPTION");
    }
    
    public void HomePageOutput() {
        System.out.println("===== HOME PAGE =====");  
        System.out.println("SELECT AN OPTION");
        System.out.println("[1] Find a movie ");
        System.out.println("[2] Rent a movie");
        System.out.println("[3] See recomendations");
        System.out.println("[4] Show current balance");
        System.out.println("[5] Show rented movies");
        System.out.println("[6] Logout "
                + "\n");
    }
}
