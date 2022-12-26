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

    private String inputFile = "Movie_Metadata_Edited.csv";
    private List<Movie> movies;

    public MovieList() {
        movies = createMovieList();
    }

    public List<Movie> createMovieList() {

        Data_Parser dataParser = new Data_Parser();
        Data_FileReader dataFileReader = new Data_FileReader();
        try {
            List<String> lines = dataFileReader.readFile(inputFile);
            movies = dataParser.parseData(lines);
        } catch (IOException e) {
            System.out.println(e);
        }

        return movies;
    }

    public List<Movie> getMovies() {
        return movies;
    }

}
