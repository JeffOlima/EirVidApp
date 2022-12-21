/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eirvidapp;

import java.util.Scanner;

public class Menu {

    //Scanner object to get input from the terminal
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Shows main menu options
     */


    public void StartupOutput() {
        //menu + user input
        System.out.println("===== LOGIN PAGE =====");
        System.out.println("[1] REGISTER A NEW USER");
        System.out.println("[2] LOGIN");
        System.out.println("[3] QUIT");
        System.out.println("SELECT AN OPTION");
    }
}