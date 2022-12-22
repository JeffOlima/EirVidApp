/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eirvidapp;

import User.RegularUser;
import dao.UserDao;
import java.util.Scanner;

public class Registration {

    public RegularUser Registration() {

        String name, surname, yearofbirth, cardNumber, email, password;

        Scanner scanner = new Scanner(System.in);

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

       return  CreateNewUser(name, surname, yearofbirth, cardNumber, email, password);

    }
    //After Registration() we call this method to insert the user into the database 

    private RegularUser CreateNewUser(String name, String surname, String yearofbirth, String cardNumber, String email, String password) {
        RegularUser user = new RegularUser();

        user.setName(name);
        user.setSurname(surname);
        user.setYearOfBirth(yearofbirth);
        user.setCardNumber(cardNumber);
        user.setEmail(email);
        user.setPassword(password);

        boolean registered = UserDao.insertUser(user);

        if (registered) {
            System.out.println("-----> USER SUCCESSFULY REGITERED");
        } else {
            System.out.println("-----> ERROR, TRY AGAIN");
        }

        return user;
    }
}
