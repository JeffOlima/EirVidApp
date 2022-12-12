package Movie.File_Reader;

public class Data_Separator {
    public String[] Seperate(String line) {

        //   String regex = "\"";
        String regex = ",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)";

        return line.split(regex);
    }

}
