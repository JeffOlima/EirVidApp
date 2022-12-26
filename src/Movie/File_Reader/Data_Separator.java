/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Movie.File_Reader;

/**
 *
 * @author Bekezhan Abdykarimov ( 2020297 )
 */
public class Data_Separator {

    /*
    This method takes a single string input called line and 
    separates it into an array of strings using a regular expression 
    as the delimiter.
     */
    public String[] seperate(String line) {

        //   String regex = "\"";
        String regex = ",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)";

        return line.split(regex);

        //returns the resulting array of strings that have been split 
    }

}
