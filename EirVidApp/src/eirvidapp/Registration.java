package eirvidapp;

import dao.UserDao;
import model.User;


public class Registration {
    
    public User Reg(String name, String surname, int yearofbirth, int cardNumber, String email, String password){
     
                
      User u = new User();
        
       u.setName(name);
       u.setSurname(surname);
       u.setYearOfBirth(yearofbirth);
       u.setCardNumber(cardNumber);
       u.setEmail(email);
       u.setPassword(password);
                    
       boolean registered = UserDao.insertUser(u);
                    
       if (registered){
           System.out.println("-----> USER SUCCESSFULY REGITERED");
       }  else{
           System.out.println("-----> ERROR, TRY AGAIN");
      }
                   
    
    return u;
}
}