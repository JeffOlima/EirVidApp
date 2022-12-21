/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package eirvidapp;

import dao.UserDao;
import User.RegularUser;

public class Login {
    public boolean Log_IN(String email, String password){

        RegularUser u = UserDao.searchUserByEmail(email);

        boolean successLogin = false;

        if (u != null && u.getPassword().equals(password)){
            successLogin = true;
        }
//
        if (successLogin){
            System.out.println("-----> YOU LOGGED IN");
            return true;
        } else{
            System.out.println("-----> Email/password incorrect");
            return false;
        }
    }

}