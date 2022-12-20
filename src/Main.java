import Functionality.FindMovie;
import Movie.Movie;
import Movie.MovieList;
import User.User;
import User.RegularUser;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Start");
        MovieList movieList = new MovieList();
        FindMovie f = new FindMovie();
        RegularUser user = new RegularUser();
       // System.out.println(f.findMovie("Heat", movieList.getMovies()).getOverview());
     //   user.findMovie(movieList.getMovies());
        user.rentMovie(movieList.getMovies());



    //    user.rentMovie("Casino", 5);
       // user.rentMovie("Nixon", 5);
    /*    for(int i = 0; i < user.getRentedMovies().size(); i++){
            user.getRentedMovies().get(i).getMovie();
        }*/
    }
}