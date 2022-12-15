import Movie.Movie;
import Movie.MovieList;
import User.User;
import User.RegularUser;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Start");
        Calendar date = Calendar.getInstance();
        System.out.println(date.getTime());
        MovieList movieList = new MovieList();
        List<Movie> movies = movieList.createMovieList();
       // movies.get(0).getMovie();
       // User user = new User();
      //  user.findMovie("Heat").getMovie();
        RegularUser user = new RegularUser();
        user.rentMovie("Heat", 5);
        user.rentMovie("Casino", 5);
        user.rentMovie("Nixon", 5);
        for(int i = 0; i < user.getRentedMovies().size(); i++){
            user.getRentedMovies().get(i).getMovie();
        }
    }
}