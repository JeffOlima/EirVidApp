/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package User;

import Movie.Movie;

import java.util.List;
/**
 *
 * @author Bekezhan Abdykarimov ( 2020297 )
 */

public interface User_Functionality {
    public Movie findMovie(List<Movie> movieList);
    public void rentMovie(List<Movie> moviesLibrary);
}
