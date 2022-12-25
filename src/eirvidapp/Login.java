/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eirvidapp;

/**
 *
 * @author Jefferson de Oliveira Lima 2020373
 */

import dao.UserDao;
import User.RegularUser;
import java.util.Scanner;

public class Login {
     
    
    public RegularUser Sign_In() {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== LOGIN =====");
        System.out.println("Type the email");
        String email = scanner.nextLine();
        System.out.println("Type the password");
        String password = scanner.nextLine();

        //Log_IN(email, password);
        if (Log_IN(email, password) == false) {
            // userLogged = u;
            return Sign_In();
            
        }else{
            System.out.println("works.....");
            RegularUser userLogged = GetUser(email);
            return userLogged;
        }
    }

    private boolean Log_IN(String email, String password) {

        RegularUser u = UserDao.searchUserByEmail(email);

        boolean successLogin = false;

        if (u != null && u.getPassword().equals(password)) {
            successLogin = true;
        }
//
        if (successLogin) {
            System.out.println("-----> YOU LOGGED IN");
            return successLogin;
        } else {
            System.out.println("-----> Email/password incorrect");
            return successLogin;
        }
    }
    
    private RegularUser GetUser(String email){
        RegularUser u = UserDao.searchUserByEmail(email);
        return u;
    }
    

}
