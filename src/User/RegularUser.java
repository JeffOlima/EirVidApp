/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package User;

import Functionality.FindMovie;
import Functionality.GetUserInput;
import Functionality.Pay;
import Functionality.Rent;
import Functionality.RentTimer;
import Movie.Movie;

import java.util.*;
/**
 *
 * @author Bekezhan Abdykarimov ( 2020297 )
 */

public class RegularUser extends User{

    private List<Movie> rentedMoviesList;

    public RegularUser() { 
        this(0, "", "", "", "", "" , "", 0.0);
    }

    public RegularUser(int id, String name, String surname, String yearOfBirth, String cardNumber, String email, String password, double balance) {
        super(id, name, surname, yearOfBirth, cardNumber, email, password, balance);
        this.rentedMoviesList = new ArrayList<>();
    }

    @Override
    public Movie findMovie(List<Movie> moviesLibrary){

        GetUserInput userInput = new GetUserInput();
        FindMovie find = new FindMovie();

        String message = "Enter the name of the movie: ";
        String movieName = userInput.getInput(message); //Taking an input from the user

        Movie foundMovie = find.findMovie(movieName, moviesLibrary);
            if(foundMovie == null){
                System.out.println("Movie " + movieName + " not found \n " +
                        "Please try again");
                return findMovie(moviesLibrary);
                }
            else{
                //   isFound = true;
                System.out.println("Movie " + movieName + " is in the catalog.");
                return foundMovie;
            }
    }

    @Override
    public void rentMovie(List<Movie> moviesLibrary) {

        Movie movie;
        int rentPeriod;

        Rent rent = new Rent();
        //Asking user for a movie that he would like to rent, and using findMovie() method to find
        movie = findMovie(moviesLibrary);
        //Asking user to choose the rent period, by calling private method showRentTimeOptions()
        rentPeriod = showRentTimeOptions(movie);
        //If user rents a movie for 1 day, we charge him money, other rent options are free
        //60 seconds * 60 = 1 hour * 24 = 1 day or 
        if(rentPeriod == 86400) { 
            System.out.println("Movie price: " + movie.getPrice() + ", your current balance: " + this.getBalance() );
            if(!pay(movie)) {
                System.out.println("Payment was canceled ");
                rentMovie(moviesLibrary);
            }
        }
        //by calling this method we are increasing rented variable and updating the last rent time
        movie.rented();
        //adding found movie to the rentedList<> by calling rent.rentMovie()
        setRentedMovies(rent.rentMovie(getRentedMovies(), movie));
            //  rentedMoviesList = rent.rentMovie(getRentedMovies(), movie); //calling rentMovie() from Rent class to modify it for the regular user
        System.out.println("The movie " + movie.getTitle() + " was successfully added to your collection \n");
        movie.getMovie(); // outputs the movie we just rented
        //showing user's current balance: 
        System.out.println("Your current balance: " + this.getBalance());
        //Setting the rent timer
        RentTimer rt = new RentTimer();
        rt.removeAfterNtime(getRentedMovies(), movie, rentPeriod);
        
    }

    private int showRentTimeOptions(Movie movie) {
        GetUserInput userInput = new GetUserInput();
        System.out.println("Choose the rent duration: \n" +
                "1) 1 minute (free) \n" +
                "2) 5 minutes (free)\n" +
                "3) 1 hour (free)\n" +
                "4) 1 day (Movie: " + movie.getOriginal_title() + " 1 day rental price: " + movie.getPrice());
        int input = userInput.getInput();
        int rentTime = -1;  // will be shown in seconds
        switch (input)
        {
            case 1:
                return rentTime = 60;

            case 2:
                return rentTime = 60 * 5; //5 minutes

            case 3:
                return rentTime = 60 * 60; //1 hour (60 minutes)

            case 4:
                return rentTime = (60 * 60) * 24; //1 day

            default:
                System.out.println("This option does not exist. \n" +
                        "Please, try again.");
                return showRentTimeOptions(movie);
        }
    }
    
    private boolean pay(Movie movie) { 
        
        Pay MovieRent = new Pay();
        GetUserInput userInput = new GetUserInput();
        boolean paymentSuccessful = false; 
        
        System.out.println("Movie: " + movie.getOriginal_title() + " 1 day rental price: " + movie.getPrice() + " \n"
                + "Would you like to pay? \n"
                + "1) Yes \n"
                + "2) No \n");
         int input = userInput.getInput();
         switch (input)
        {
            case 1:
                   MovieRent.pay(this, movie);
                   
                   return paymentSuccessful = true;

            case 2:
                    System.out.println("Payment canceled");
                    return paymentSuccessful;
             default:
                System.out.println("This option does not exist. \n" +
                        "Please, try again.");
                return pay(movie);
         }
        
    }
         
    public List<Movie> getRentedMovies() {
        return rentedMoviesList;
    }

    public void setRentedMovies(List<Movie> rentedMovies) {
        this.rentedMoviesList = rentedMovies;
    }
}

