/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Movie;

import Movie.File_Reader.Data_FileReader;
import Movie.File_Reader.Data_Parser;
import Movie.File_Reader.Data_Separator;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bekezhan Abdykarimov ( 2020297 )
 */

public class MovieList {
    String inputFile = "Movie_Metadata_Edited.csv";
    private List<Movie> movies;

    public MovieList() throws IOException {
        movies = createMovieList();
    }

    public List<Movie> createMovieList() throws IOException {

        Data_Parser dataParser = new Data_Parser();
        Data_Separator ds = new Data_Separator();
        Data_FileReader dataFileReader = new Data_FileReader();
        List<String> lines = dataFileReader.ReadFile(inputFile);
        movies = dataParser.ParseData(lines);
        return movies;
    }

    private List<Movie> getMovieThatWereRentedInLastFiveMinutes() {
        // Get the current time
        Instant currentTime = Instant.now();
        List<Movie> rentedMovies = new ArrayList<>();
        // Check if the last rented time is within the last 5 minutes (300 / 60 = 5)
        for(int i = 0; i < movies.size(); i++) {

            if (currentTime.isBefore(movies.get(i).getLastRentedTime().plusSeconds(300))) {
                // adds the Movie if the last rented time is within the last 5 minutes
                 rentedMovies.add(movies.get(i));
            } else {
                // Returns an empty arraylist if the last rented time is not within the last 5 minutes
                return rentedMovies;
            }
        }
        return rentedMovies;
    }

    public void showTheMostRentedMovies(){

        List<Movie> rentedMovies = getMovieThatWereRentedInLastFiveMinutes();
        System.out.println("The Most Popular movies, that were rented 5 minutes ago: \n");
        for(int i = 0; i < rentedMovies.size(); i++) {
            System.out.println("The Movie :" + rentedMovies.get(i).getTitle() + " , was rented: " + rentedMovies.get(i).getRentCount() + "" +
                    " in the last 5 minutes \n " +
                    "Last rented time : " + rentedMovies.get(i).getLastRentedTime() );
        }
    }

    public List<Movie> getMovies() {
        return movies;
    }

}
