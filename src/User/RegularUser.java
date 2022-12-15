package User;

import Functionality.FindMovie;
import Functionality.Rent;
import Functionality.RentTimer;
import Movie.Movie;

import java.util.*;

public class RegularUser extends User{

    private List<Movie> rentedMovies;

    public RegularUser(){
        this(1, "Bekezhan", "Abdykarimov", 1999, 47320, "smth@mail.com", "password");
    }

    public RegularUser(int id, String name, String surname, int yearOfBirth, int cardNumber, String email, String password) {
        super(id, name, surname, yearOfBirth, cardNumber, email, password);
        this.rentedMovies = new ArrayList<>();
    }

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
        rentedMovies = rent.rentMovie(this.rentedMovies, movie);
        getRentedMovies2(); // output
        RentTimer rentTimer = new RentTimer();
        boolean rentOver = rentTimer.setTheTimer(rentPeriod);
        if(rentOver){
            rent.removeRentedMovie(rentedMovies,movie);
            System.out.println("movie rent is over");
            getRentedMovies2();
        }
        getRentedMovies2();

    }

    public List<Movie> getRentedMovies() {
        return rentedMovies;
    }

    public void getRentedMovies2() {
        for(int i = 0; i < rentedMovies.size(); i++){
            rentedMovies.get(i).getMovie();
        }
    }

    /* public List<Movie> rentMovie(List<Movie> userRentedMovies, Movie movie, int rentPeriod){
        userRentedMovies.add(movie);
        Timer timer = new Timer();
        TimerTask removeMovieTask = new TimerTask() {
            int minutes = rentPeriod;
            boolean rentOver ;
            @Override
            public void run() {
                if(minutes >= 0){
                    rentOver = false;
                    System.out.println(minutes);
                    minutes--;
                }else{
                    rentOver = true;
                    System.out.println("movie rent is over");
                    removeRentedMovie(userRentedMovies, movie);
                    timer.cancel();
                }
            }
        };


        Calendar date = Calendar.getInstance();
      //  date.setTime();
        //date.se
        timer.scheduleAtFixedRate(removeMovieTask, date.getTime(), rentPeriod * 1000);


        return userRentedMovies;
    }
        };*/
}
