package User;

import Functionality.FindMovie;
import Functionality.Rent;
import Functionality.RentTimer;
import Movie.Movie;
import Movie.BorrowedMovie;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class RegularUser extends User{

    private List<Movie> rentedMovies;
  //  private List <BorrowedMovie> rentedMovies2;


    public RegularUser(){
        this(1, "Bekezhan", "Abdykarimov", 1999, 47320, "smth@mail.com", "password");
    }

    public RegularUser(int id, String name, String surname, int yearOfBirth, int cardNumber, String email, String password) {
        super(id, name, surname, yearOfBirth, cardNumber, email, password);
        this.rentedMovies = new ArrayList<>();
    }

    /*
    public RegularUser(){
    this(1, "Bekezhan", "Abdykarimov", 1999, 47320, "smth@mail.com", "password");
    }

    public RegularUser(int id, String name, String surname, int yearOfBirth, int cardNumber, String email, String password) {
        super(id, name, surname, yearOfBirth, cardNumber, email, password);
        this.rentedMovies2 = new ArrayList<>();
    }
    @Override
    public void rentMovie(String movieName, int rentPeriod){
}
*/

    @Override
    public Movie findMovie(String movieName){
        FindMovie findTheMovie = new FindMovie();
        if(findTheMovie == null) {
            System.out.println("Movie not found");
        }
        return findTheMovie.findMovie(movieName);
    }

    @Override
    public void rentMovie(String movieName, int rentPeriod) {
        Rent rent = new Rent();
        FindMovie findMovie = new FindMovie();
        Movie movie = findMovie.findMovie(movieName);
        if(findMovie == null){
            System.out.println("We couldn't find the movie " + movieName + ", try again pls");
        }
        else {
            rentedMovies = rent.rentMovie(getRentedMovies(), movie); //calling rentMovie() from Rent class to modify it for the regular user
            System.out.println("The movie " + movie.getTitle() + " was successfully added to your collection");
            getRentedMovies2(); // output

            //Setting the rent timer
            RentTimer rt = new RentTimer();
            rt.removeAfterNtime(getRentedMovies(), movie, rentPeriod);

        }
    }

    public List<Movie> getRentedMovies() {
        return rentedMovies;
    }

    public void setRentedMovies(List<Movie> rentedMovies) {
        this.rentedMovies = rentedMovies;
    }

    public void getRentedMovies2() {
        for(int i = 0; i < rentedMovies.size(); i++){
            System.out.println( rentedMovies.get(i).getTitle());
        }
    }

    /*
    @Override
    public void rentMovie(String movieName, int rentPeriod) {
        Rent rent = new Rent();
        FindMovie findMovie = new FindMovie();
        Movie movie = findMovie.findMovie(movieName);
        if(findMovie == null){
            System.out.println("We couldn't find the movie " + movieName + ", try again pls");
        }
        else {
            rentedMovies = rent.rentMovie(this.rentedMovies, movie); //calling rentMovie() from Rent class to modify it for the regular user
            movie.getMovie(); // rented movie output
            //getRentedMovies2(); // output
            RentTimer rentTimer = new RentTimer();
            boolean rentOver = rentTimer.setTheTimer(rentPeriod);
            System.out.println(rentOver);
            if(rentOver){
                rent.removeRentedMovie(rentedMovies,movie);
                System.out.println("The rent of the movie: " +  movieName +  "is over" );
                getRentedMovies2();
            }
            getRentedMovies2();

        }
    }
    */
}
