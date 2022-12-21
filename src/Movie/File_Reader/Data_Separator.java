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
    public String[] Seperate(String line) {

        //   String regex = "\"";
        String regex = ",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)";

        return line.split(regex);
    }

}
