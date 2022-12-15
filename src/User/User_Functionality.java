package User;

import Movie.Movie;

import java.util.List;

public interface User_Functionality {
    public Movie findMovie(String movieName);
    public void rentMovie(String movieName, int rentPeriod);
}
