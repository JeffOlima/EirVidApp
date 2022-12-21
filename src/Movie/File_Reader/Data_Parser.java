package Movie.File_Reader;

import Movie.Movie;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bekezhan Abdykarimov ( 2020297 )
 */
public class Data_Parser {
    public List<Movie> ParseData(List<String> lines) {
        List<Movie> movies = new ArrayList<Movie>();
        Data_Separator dataSeperator = new Data_Separator();
        Data_Mapper dataMapper = new Data_Mapper();

        lines.forEach(line -> {
            // Splitting
            String[] fields = dataSeperator.Seperate(line);

            // Mapping
            movies.add(dataMapper.Map(fields));

        });
        return movies;
    }
}
