/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functionality;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Bekezhan Abdykarimov ( 2020297 )
 *
 *
 */
public class GetUserInput {

    /**
     * The first getInput method takes in a single String argument called message and prompts the user to enter a string by printing message to the console.
     * It then reads the user's input using a Scanner object and stores it in a local String variable called input.
     * The method then enters a while loop that continues until validInput is true.
     * Inside the loop, it tries to assign the value of input to input.
     * If an InputMismatchException is caught, it prints an error message and continues the loop.
     * If no exception is caught, it sets validInput to true and breaks out of the loop.
     * Finally, the method returns the value of input.*/

    public String getInput(String message) {

        Scanner scanner = new Scanner(System.in);
        String input = null;
        boolean validInput = false;
        while(!validInput){
            try {
                System.out.print(message);
                input = scanner.nextLine();
                if(!input.isEmpty()) {
                    validInput = true;
                }else{
                    System.out.println("Nothing was entered. Please try again");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. \n " + message);

            }
        }
        return input;
    }

    /**
     * The second getInput method is similar, but it prompts the user to enter an integer and returns the integer value entered by the user.
     * It does this by using a Scanner object to read the user's input as a string and then checks whether the string is empty or not a number.
     * If either of these conditions is true, it prints an error message and continues the loop.
     * If the input is a valid integer, it parses the string to an int value and returns it.
     * */

    public int getInput(){
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        boolean isValid = false;

        while(!isValid) {
            String input = scanner.nextLine();
            if(input.isEmpty()) {
                System.out.println("Input cannot be empty. Please enter a number: ");
            } else if(!input.matches("\\d+")) {
                System.out.println("Input is not a number. Please enter a number: ");
            } else {
                num = Integer.parseInt(input);
                isValid = true;
            }
        }
        return num;
    }
}