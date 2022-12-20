package Functionality;

import java.time.Instant;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GetUserInput {

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
