/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package eirvidapp;

import User.RegularUser;
import dao.UserDao;


public class Registration {

    public RegularUser Reg(String name, String surname, String yearofbirth, String cardNumber, String email, String password, double balance) {
        RegularUser user = new RegularUser();

        user.setName(name);
        user.setSurname(surname);
        user.setYearOfBirth(yearofbirth);
        user.setCardNumber(cardNumber);
        user.setEmail(email);
        user.setPassword(password);
        user.setBalance(balance);
        
        boolean registered = UserDao.insertUser(user);

        if (registered) {
            System.out.println("-----> USER SUCCESSFULY REGITERED");
        } else {
            System.out.println("-----> ERROR, TRY AGAIN");
        }


        return user;
    }
}
