package Movie.File_Reader;

/**
 *
 * @author Bekezhan Abdykarimov ( 2020297 )
 */
public class Data_Separator {
    public String[] Seperate(String line) {

        //   String regex = "\"";
        String regex = ",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)";

        return line.split(regex);
    }

}
