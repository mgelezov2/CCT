package ca1_ooa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 *
 * @author michael
 */

//UNFINISHED CHANGES
//IMPLEMENT USER INPUT DATA TO FILE MANUALLY
//MAKE IF STATEMENTS FOR SUBJECT NUMBER VALIDATION MORE PRESENTABLE

public class CA1_OOA {

    /**
     * @param args the command line arguments
     */    
    public static void main(String[] args) throws FileNotFoundException,InputMismatchException ,IOException {
        try{
            //FILE READER,WRITER AND MAIN ARRAY STORAGE
            BufferedReader studentReadTxt = new BufferedReader(new FileReader("/home/michael/NetBeansProjects/CA1_OOA/students.txt"));   
            ArrayList<String> stListValidation = new ArrayList<>();        
            BufferedWriter studentWriteTxt = new BufferedWriter(new FileWriter("/home/michael/NetBeansProjects/CA1_OOA/status.txt", false));
            //FOR LOOP REITERATION GOING LINE BY LINE
            Stream<String> fileStream = Files.lines(Paths.get("students.txt"));
            int noOfLines = (int) fileStream.count();
            for (int i = 0; i < noOfLines; i++) {
                 String lineInProgress = studentReadTxt.readLine();
                 // String lineProcessed = lineInProgress;
                 String[] splitStudentData = lineInProgress.split(" ");
     
   
                //VALIDATE FIRST NAME   
                if(splitStudentData[0].matches("[a-zA-Z]+")){
                   stListValidation.add(splitStudentData[0]);
                 }
                 else{ 
                   System.out.println("Error first name invalid!");      
                 }

               //VALIDATE SECOND NAME    
               if(splitStudentData[1].matches("[a-zA-Z ']+|[0-9]+")){
                  stListValidation.add(splitStudentData[1]);
                }
               else{
                  System.out.println("Error second name invalid!");      
                }
