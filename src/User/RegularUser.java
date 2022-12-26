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
import Movie.MovieList;
import Movie.Movie_GetRandomSomeMovies;

import java.util.*;

/**
 *
 * @author Bekezhan Abdykarimov ( 2020297 )
 */
public class RegularUser extends User {

    private final List<Movie> moviesLibrary = new MovieList().getMovies();
    private List<Movie> rentedMoviesList = new ArrayList<>();

    public RegularUser() {
        this(0, "", "", "", "", "", "", 0.0);
    }

    public RegularUser(int id, String name, String surname, String yearOfBirth, String cardNumber, String email, String password, double balance) {
        super(id, name, surname, yearOfBirth, cardNumber, email, password, balance);
        this.rentedMoviesList = new ArrayList<>();
    }

    @Override
    public void showRentedMovies() {
        // check if the list is empty or not
        // using isEmpty() function
        boolean ans = rentedMoviesList.isEmpty();
        if (ans == true) {
            System.out.println("The List is empty \n");
        } else {
            for (int i = 0; i < rentedMoviesList.size(); i++) {
                System.out.println("Movie " + i);
                rentedMoviesList.get(i).showShortInfo();
                System.out.println("\n");
            }
        }
    }

    @Override
    public Movie findMovie() {

        GetUserInput userInput = new GetUserInput();
        FindMovie find = new FindMovie();

        String message = "Enter the name of the movie: ";
        String movieName = userInput.getInput(message); //Taking an input from the user

        Movie foundMovie = find.findMovie(movieName, moviesLibrary);
        if (foundMovie == null) {
            System.out.println("Movie " + movieName + " not found \n");
            return null;
        } else {
           
            System.out.println("Movie " + movieName + " is in the catalog. \n");
            return foundMovie;
        }
    }

    public void getRandomMovies() {
        System.out.println("Here is the list of random movies that we suggest according to their popularity: \n");
        Movie_GetRandomSomeMovies randomMovies = new Movie_GetRandomSomeMovies();
        randomMovies.getRandomFive(moviesLibrary);
    }

    @Override
    public void rentMovie() {

        Movie movie;
        int rentPeriod;
        Rent rent = new Rent();
        RentTimer rt = new RentTimer();

        //Asking user for a movie that he would like to rent, and using findMovie() method to find
        do {
            movie = findMovie();
        } while (movie == null);

        //Asking user to choose the rent period, by calling private method showRentTimeOptions()
        rentPeriod = showRentTimeOptions(movie);
        //If user rents a movie for 1 day, we charge him money, other rent options are free
        //60 seconds * 60 = 1 hour * 24 = 1 day or 86400 seconds
        switch (rentPeriod) {
            case 60:
            case (60 * 5):
            case (60 * 60):
                //adding found movie to the rentedList<> by calling rent.rentMovie()
                setRentedMovies(rent.rentMovie(getRentedMovies(), movie));
                //  rentedMoviesList = rent.rentMovie(getRentedMovies(), movie); //calling rentMovie() from Rent class to modify it for the regular user

                //showing user's current balance: 
                System.out.println("Your current balance: " + this.getBalance());

                //Setting the rent timer
                rt.removeAfterNtime(getRentedMovies(), movie, rentPeriod);

                break;
            case 86400:
                if (pay(movie)) {
                    //adding found movie to the rentedList<> by calling rent.rentMovie()
                    setRentedMovies(rent.rentMovie(getRentedMovies(), movie));
                    //  rentedMoviesList = rent.rentMovie(getRentedMovies(), movie); //calling rentMovie() from Rent class to modify it for the regular user

                    //showing user's current balance: 
                    System.out.println("Your current balance: " + this.getBalance());

                    //Setting the rent timer
                    rt.removeAfterNtime(getRentedMovies(), movie, rentPeriod);
                    break;
                }
                break;
            default:
                System.out.println("Smth went wrong");
                break;
        }
    }

    @Override
    public int showRentTimeOptions(Movie movie) {
        GetUserInput userInput = new GetUserInput();
        System.out.println("Choose the rent duration: \n"
                + "1) 1 minute (free) \n"
                + "2) 5 minutes (free)\n"
                + "3) 1 hour (free)\n"
                + "4) 1 day (Movie: " + movie.getOriginal_title() + " 1 day rental price: " + movie.getPrice() + ")");
        int input = userInput.getInput();
        int rentTime = -1;  // will be shown in seconds
        switch (input) {
            case 1:
                return rentTime = 60;

            case 2:
                return rentTime = 60 * 5; //5 minutes

            case 3:
                return rentTime = 60 * 60; //1 hour (60 minutes)

            case 4:
                return rentTime = (60 * 60) * 24; //1 day

            default:
                System.out.println("This option does not exist. \n"
                        + "Please, try again.");
                return showRentTimeOptions(movie);
        }
    }
    /*
    This is a method in Java that allows a user to pay for a movie rental.
    The method takes a movie object as an argument 
    */
    @Override
    public boolean pay(Movie movie) {

        Pay MovieRent = new Pay();
        GetUserInput userInput = new GetUserInput();
        boolean paymentSuccessful = false;

        System.out.println("Movie: " + movie.getOriginal_title() + " 1 day rental price: " + movie.getPrice() + " \n"
                + "Would you like to pay? \n"
                + "1) Yes \n"
                + "2) No \n");
        int input = userInput.getInput();
        switch (input) {
            case 1:
                MovieRent.pay(this, movie);
                return paymentSuccessful = true;
            case 2:
                System.out.println("Payment canceled");
                return paymentSuccessful;
            default:
                System.out.println("This option does not exist. \n"
                        + "Please, try again.");
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
