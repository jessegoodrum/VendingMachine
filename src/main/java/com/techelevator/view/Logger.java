package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class Logger {
    public  void log (String message){

        File logFile = new File("src/main/resources/placeholder.txt");

        boolean fileExit= logFile.exists()? true:false;

        try(PrintWriter writer=new PrintWriter(new FileOutputStream(logFile,fileExit))){
            writer.println(LocalDateTime.now()+" "+message);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



    }

}
