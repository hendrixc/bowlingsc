/*
 * System: Bowling Score Calculator
 * Author: Henry Coral
 * 
 * This program is for demo purposes, you can use or modify it under your own risk.
 */
package com.hendrixc.bowlingsc;

import com.hendrixc.bowlingsc.model.Player;
import com.hendrixc.bowlingsc.service.parser.ParserException;
import com.hendrixc.bowlingsc.service.parser.ScoreParser;
import com.hendrixc.bowlingsc.service.parser.TextScoreParser;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Main class for Bowling Score.
 * For detailed information please README.md file provided with distribution.
 * @author Henry Coral
 */
public class Starter {
    
    private static final String MAIN = "\n" 
            + "Bowling Scoring\n"
            + "===============\n";
    
    private static final String USAGE = "\n" 
            + "Basic Usage:\n"
            + "\tjava -jar bowlingsc.jar \n"
            + "Providing a file name: \n"
            + "\tjava -jar bowlingsc.jar scoringFile.txt\n"
            + "Providing a file name and printing verbose validation: \n"
            + "\tjava -jar bowlingsc.jar -v scoringFile.txt\n";
    
    /**
     * The application's entry point 
     * @param args an array of command-line arguments for the application
     */
    public static void main(String args[]) {
        Starter.printer(MAIN);
        Starter starter = new Starter();
        starter.process(args);
    }
    
    public void process(String args[]) {
        Object[] values = this.obtainExecutionValues(args);
        ScoreParser parser = new TextScoreParser();
        try {
            List<Player> players = parser.parseFile((String)values[0]);
            
        } catch (ParserException ex) {
            Logger.getLogger(Starter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Starter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * Gets the necessary values of the arguments for the program execution.
     * @param args values passed in the command line.
     * @return an object array of length 2. The first position (0) represents the file name that 
     * contain the data to be processed,  the second position (1) contains a boolean value that 
     * specify the type of file validation (verbose or not).
     */
    private Object[] obtainExecutionValues(String args[]) {
        Object[] response = new Object[2]; 
        String fileName = null;
        Boolean verbose = Boolean.FALSE;
        if (args.length==0) {
            Scanner scan = new Scanner(System.in);
            Starter.printer("Input the file name: ");
            fileName = scan.nextLine();
            Starter.printer("Verbose Validation [y]: ");
            verbose = ("Y".equalsIgnoreCase(scan.nextLine()));
        } else if (args.length==1){
           fileName = args[0]; 
        } else if (args.length == 2 && "-v".equalsIgnoreCase(args[0])){
            fileName = args[1];
            verbose = Boolean.TRUE;
        } else {
            Starter.printer(USAGE);
            System.exit(-1);
        }
        response[0] = fileName;
        response[1] = verbose;
        return response;
    }
    
    /**
     * Wrapper for System.out.println
     * @param message Message to be printed in the console.
     */
    private static void printer(String message) {
        System.out.println(message);
    }
    
}
