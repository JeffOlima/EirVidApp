/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Movie.File_Reader;

import Movie.Movie;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bekezhan Abdykarimov ( 2020297 )
 */
public class Data_Parser {
    
    // This method takes a list of strings called lines and returns a list of Movie objects.
    public List<Movie> parseData(List<String> lines) {
        /*
        The method creates an empty list of Movie objects called movies and 
        two objects of other classes, dataSeperator and dataMapper. 
        */
        List<Movie> movies = new ArrayList<Movie>();
        Data_Separator dataSeperator = new Data_Separator();
        Data_Mapper dataMapper = new Data_Mapper();

        lines.forEach(line -> {
            // Splitting each line of lines List 
            String[] fields = dataSeperator.seperate(line);

            //(Mapping) passing in the array of fields as an argument, 
            // to create a new Movie object
            //And then that object is added to the movies list
            movies.add(dataMapper.map(fields));

        });
        //returns ready movies List
        return movies;
    }
}

