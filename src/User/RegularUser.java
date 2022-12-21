package User;

import Functionality.FindMovie;
import Functionality.GetUserInput;
import Functionality.Rent;
import Functionality.RentTimer;
import Movie.Movie;

import java.util.*;


public class RegularUser extends User{

    private List<Movie> rentedMoviesList;
    private double balance;


    public RegularUser(){
        this(1, "Bekezhan", "Abdykarimov", "1999", "42412412312", "smth@mail.com", "password");
    }

    public RegularUser(int id, String name, String surname, String yearOfBirth, String cardNumber, String email, String password) {
        super(id, name, surname, yearOfBirth, cardNumber, email, password);
        this.rentedMoviesList = new ArrayList<>();
        this.balance = 100.0; //each new user will get 100 credit
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
        rentPeriod = showRentTimeOptions();
        //by calling this method we are increasing rented variable and updating the last rent time
        movie.rented();
        //adding found movie to the rentedList<> by calling rent.rentMovie()
        setRentedMovies(rent.rentMovie(getRentedMovies(), movie));
            //  rentedMoviesList = rent.rentMovie(getRentedMovies(), movie); //calling rentMovie() from Rent class to modify it for the regular user
        System.out.println("The movie " + movie.getTitle() + " was successfully added to your collection \n");
        movie.getMovie(); // outputs the movie we just rented

        //Setting the rent timer
        RentTimer rt = new RentTimer();
        rt.removeAfterNtime(getRentedMovies(), movie, rentPeriod);

    }

    private int showRentTimeOptions() {
        GetUserInput userInput = new GetUserInput();
        System.out.println("Choose the rent duration: \n" +
                "1) 1 minute \n" +
                "2) 5 minutes \n" +
                "3) 1 hour \n" +
                "4) 1 day ");
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
                return showRentTimeOptions();
        }
    }

    public List<Movie> getRentedMovies() {
        return rentedMoviesList;
    }

    public void setRentedMovies(List<Movie> rentedMovies) {
        this.rentedMoviesList = rentedMovies;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
