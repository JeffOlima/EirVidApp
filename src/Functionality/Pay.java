/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functionality;

import Movie.Movie;
import User.RegularUser;

/**
 *
 * @author Bekezhan Abdykarimov ( 2020297 )
 */
public class Pay {

    public void pay (RegularUser user, Movie movie) {
        
        double userBalance = user.getBalance();
        double movieRentPrice = movie.getPrice();

        if(userBalance < movieRentPrice) {
            System.out.println("Not enough balance, please add some credits");
        }else{
            user.setBalance(userBalance - movieRentPrice);
            System.out.println("Payment approved");
        }
    }
}
