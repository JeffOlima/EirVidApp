/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functionality;

import Movie.Movie;

import java.util.List;
/**
 *
 * @author Bekezhan Abdykarimov ( 2020297 )
 *
 * This code defines a Java class called FindMovie that contains a method called findMovie.
 *
 * The findMovie method takes in two arguments: a String called movieName and a List of Movie objects called movies.
 * It then iterates through the list of movies using a for-each loop and compares the original_title of each movie to the movieName string.
 * If a match is found, the matching movie object is returned. If the loop completes and no match is found, null is returned.
 *
 * The FindMovie class also has a couple of getter and setter methods for a private field called movieIndex.
 */
public class FindMovie {

    private int movieIndex;


    public Movie findMovie(String movieName, List<Movie> movies) {

        for (Movie movie : movies) {
            if (movie.getOriginal_title().equals(movieName)) {
                return  movie;

            }
        }
        return null;
    }
    public int getMovieIndex() {
        return movieIndex;
    }

    public void setMovieIndex(int movieIndex) {
        this.movieIndex = movieIndex;
    }

}
