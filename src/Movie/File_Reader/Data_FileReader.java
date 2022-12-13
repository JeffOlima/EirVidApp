package Movie.File_Reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Data_FileReader {
    public List<String> ReadFile(String InputFile) throws FileNotFoundException, IOException {
        BufferedReader myReader = new BufferedReader(new FileReader(InputFile));
        List<String> lines = new ArrayList<>();
        String inputLine = myReader.readLine();

        while ((inputLine = myReader.readLine()) != null) {
            lines.add(inputLine);
        }
        return lines;
    }
}
