/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Movie;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Admin
 */
public class Movie_GetRandomSomeMovies {

    public void getRandomFive(List<Movie> movies) {

        //Sort the array list of movies by popularity score using the Collections .sort() method:
        Collections.sort(movies, new Comparator<Movie>() {
            @Override
            public int compare(Movie m1, Movie m2) {
                return Double.compare(m2.getPopularity(), m1.getPopularity());
            }
        });
     //   Generate 5 random numbers between 0 and the size of the array list:
        Random rand = new Random();
        int num1 = rand.nextInt(movies.size());
        int num2 = rand.nextInt(movies.size());
        int num3 = rand.nextInt(movies.size());
        int num4 = rand.nextInt(movies.size());
        int num5 = rand.nextInt(movies.size());

      //  Use the random numbers to select 5 different movies from the array list and output their titles and popularity scores:
      
        System.out.println( "1 )" + movies.get(num1).getTitle() + " \n " + "popularity: " + movies.get(num1).getPopularity() + " \n " + movies.get(num1).getOverview());
        System.out.println( "2 )" + movies.get(num2).getTitle() + " \n " + "popularity: " + movies.get(num2).getPopularity() + " \n " + movies.get(num2).getOverview());
        System.out.println( "3 )" + movies.get(num3).getTitle() + " \n " + "popularity: " + movies.get(num3).getPopularity() + " \n " + movies.get(num3).getOverview());
        System.out.println( "4 )" + movies.get(num4).getTitle() + " \n " + "popularity: " + movies.get(num4).getPopularity() + " \n " + movies.get(num4).getOverview());
        System.out.println( "5 )" + movies.get(num5).getTitle() + " \n " + "popularity: " + movies.get(num5).getPopularity() + " \n " + movies.get(num5).getOverview() + "\n");
    }
}
