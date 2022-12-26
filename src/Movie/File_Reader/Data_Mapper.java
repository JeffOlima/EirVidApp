/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Movie.File_Reader;

import Movie.Movie;

/**
 *
 * @author Bekezhan Abdykarimov ( 2020297 )
 */
public class Data_Mapper {

    /*
    Java class called Data_Mapper that has a method called map(). 
    This method takes an array of strings called fields and uses it to create 
    and return a new Movie object.
     */
    public Movie map(String[] fields) {

        String original_language = fields[0];
        String original_title = fields[1];
        String overview = fields[2];
        double popularity = Double.parseDouble(fields[3]);
        String release_date = fields[4];
        double runtime = Double.parseDouble(fields[5]);
        String tagline = fields[6];
        String title = fields[7];
        double vote_average = Double.parseDouble(fields[8]);
        double vote_count = Double.parseDouble(fields[9]);
        double price = Double.parseDouble(fields[10]);

        return new Movie(
                original_language,
                original_title,
                overview,
                popularity,
                release_date,
                runtime,
                tagline,
                title,
                vote_average,
                vote_count,
                price,
                0,
                null
        );
    }
}
