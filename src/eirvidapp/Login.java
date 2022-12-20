/*package eirvidapp;

import dao.UserDao;
import User.User;

public class Login {
    public boolean Log_IN(String email, String password){

        User u = UserDao.searchUserByEmail(email);

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
*/