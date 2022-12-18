package Movie;

import java.time.LocalDate;
import java.time.LocalTime;


public class BorrowedMovie extends Movie{

    private LocalDate rentDate;
    private LocalDate returnDate;

    private LocalTime rentTime;

    private LocalTime returnTime;
    private int rentPeriod;

    public BorrowedMovie(Movie movie, LocalDate rentDate, LocalDate returnDate, int rentPeriod, LocalTime rentTime, LocalTime returnTime) {
        this(
                movie.getOriginal_language(),
                movie.getOriginal_title(),
                movie.getOverview(),
                movie.getPopularity(),
                movie.getRelease_date(),
                movie.getRuntime(),
                movie.getTagline(),
                movie.getTitle(),
                movie.getVote_average(),
                movie.getVote_count(),
                movie.getPrice(),
                rentDate,
                returnDate,
                rentPeriod,
                rentTime,
                returnTime
                );

    }

    public BorrowedMovie(
            String original_language,
            String original_title,
            String overview,
            double popularity,
            String release_date,
            double runtime,
            String tagline,
            String title,
            double vote_average,
            double vote_count,
            double price,
            LocalDate rentDate,
            LocalDate returnDate,
            int rentPeriod,
            LocalTime rentTime,
            LocalTime returnTime
    )
    {
        super(original_language,
                original_title,
                overview,
                popularity,
                release_date,
                runtime,
                tagline,
                title,
                vote_average,
                vote_count,
                price);
        this.rentDate = rentDate;
        this.returnDate = returnDate;
        this.rentPeriod = rentPeriod;
        this.rentTime = rentTime;
        this.returnTime = returnTime;
    }

    public LocalDate getRentDate() {
        return rentDate;
    }

    public void setRentDate(LocalDate rentDate) {
        this.rentDate = rentDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public LocalTime getRentTime() {
        return rentTime;
    }

    public void setRentTime(LocalTime rentTime) {
        this.rentTime = rentTime;
    }

    public LocalTime getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(LocalTime returnTime) {
        this.returnTime = returnTime;
    }

    public int getRentPeriod() {
        return rentPeriod;
    }

    public void setRentPeriod(int rentPeriod) {
        this.rentPeriod = rentPeriod;
    }
}
