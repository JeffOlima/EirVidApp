package Movie.File_Reader;

import Movie.Movie;

public class Data_Mapper {

    public Movie Map(String[] fields) {
        String original_language = fields[0];
        String original_title = fields[1];
        String overview = fields[2];
        double popularity = -1.0;
        try {
            popularity = Double.parseDouble(fields[3]);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(original_title);
        }
        String release_date = fields[4];
        double runtime = Double.parseDouble(fields[5]);
        String tagline = fields[6];
        String title = fields[7];
        double vote_average = Double.parseDouble(fields[8]);;
        double vote_count = Double.parseDouble(fields[9]);;
        double price = Double.parseDouble(fields[10]);;

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