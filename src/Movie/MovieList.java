package Movie;

import Movie.File_Reader.Data_FileReader;
import Movie.File_Reader.Data_Parser;
import Movie.File_Reader.Data_Separator;

import java.io.IOException;
import java.util.List;


public class MovieList {
    String inputFile = "Movie_Metadata_Edited.csv";

    public List<Movie> createMovieList() throws IOException {

        Data_Parser dataParser = new Data_Parser();
        Data_Separator ds = new Data_Separator();
        Data_FileReader dataFileReader = new Data_FileReader();
        List<String> lines = dataFileReader.ReadFile(inputFile);
        List<Movie> movies = dataParser.ParseData(lines);

        return movies;
    }
}
