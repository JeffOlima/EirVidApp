package Functionality;

import Movie.Movie;
import User.RegularUser;

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