/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package User;

import Functionality.FindMovie;
import Movie.Movie;

/**
 *
 * @author olive
 */
public abstract class User implements User_Functionality{
    
    private int id;
    private String name;
    private String surname;
    private String YearOfBirth;
    private String cardNumber;
    private String email;
    private String password;

    public User(int id, String name, String surname, int yearOfBirth, int cardNumber, String email, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        YearOfBirth = yearOfBirth;
        this.cardNumber = cardNumber;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    } 
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getYearOfBirth() {
        return YearOfBirth;
    }

    public void setYearOfBirth(String YearOfBirth) {
        this.YearOfBirth = YearOfBirth;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



  
}
