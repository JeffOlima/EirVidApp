package Functionality;

import Movie.Movie;

import javax.swing.text.html.FormSubmitEvent;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RentTimer {
    boolean rentOver;

    public void removeAfterNtime(List<Movie> userRentedMovies, Movie movie, int rentPeriod) {
        Remove remove = new Remove();

        System.out.println(
                "Current time : " + Calendar.getInstance().getTime());

        // creating a ScheduledExecutorService object
        ScheduledExecutorService scheduler
                = Executors.newScheduledThreadPool(1);
        //removes the movie after 5 seconds
        Runnable task = () -> remove.removeRentedMovie(userRentedMovies,movie);

        //run this task after 5 seconds
        scheduler.schedule(task, rentPeriod, TimeUnit.SECONDS);

        scheduler.shutdown();

    }
}
