/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Movie.File_Reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bekezhan Abdykarimov ( 2020297 )
 
  Java class called Data_FileReader that has a method called readFile 
  that takes a file name as input and returns a list of strings, 
  each representing a line in the file.
 */ 
public class Data_FileReader {
    /*
        The method starts by creating a BufferedReader object 
        called myReader that reads from the file specified by the input parameter InputFile. 
        It then creates an empty list of strings called lines 
        and initializes a string called inputLine to the first line of the file read by myReader.*/
    public List<String> readFile(String InputFile) throws FileNotFoundException, IOException {
        /*
            The method then enters a loop that reads each line of the file until 
            it reaches the end of the file (indicated by a return value of null from the readLine method). 
            For each line, it adds the line to the lines list.
        */
        BufferedReader myReader = new BufferedReader(new FileReader(InputFile));
        List<String> lines = new ArrayList<>();
        String inputLine = myReader.readLine();

        while ((inputLine = myReader.readLine()) != null) {
            lines.add(inputLine);
        }
        //Finally, the method returns the lines list.
        return lines;
    }
}

