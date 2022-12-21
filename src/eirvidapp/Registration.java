/*
package eirvidapp;

import User.RegularUser;
import dao.UserDao;


public class Registration {

    public RegularUser Reg(String name, String surname, String yearofbirth, String cardNumber, String email, String password) {
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
}*/