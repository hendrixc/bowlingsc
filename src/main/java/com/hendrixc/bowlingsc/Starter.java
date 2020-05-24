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

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Main class for Bowling Score.
 * For detailed information please README.md file provided with distribution.
 * @author Henry Coral
 * @Version 1.0
 */
public class Starter {
    
    private static final String MAIN = "\n" 
            + "Bowling Scoring\n"
            + "===============\n";
    
    private static final String USAGE = "\n" 
            + "Basic Usage:\n"
            + "\tjava -jar bowling.jar \n"
            + "Providing a file name: \n"
            + "\tjava -jar bowling.jar scoringFile.txt\n"
            + "Providing a file name and printing verbose validation: \n"
            + "\tjava -jar bowling.jar -v scoringFile.txt\n";
    
    /**
     * 
     * @param args 
     */
    public static void main(String args[]) {
        Starter.printer(MAIN);
        Starter starter = new Starter();
        starter.process(args);
    }
    
    public void process(String args[]) {
        Object[] values = this.obtainValues(args);
        ScoreParser parser = null;
        try {
            List<Player> players = parser.parseFile((String)values[0]);
            
        } catch (ParserException ex) {
            Logger.getLogger(Starter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Starter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * Request a file name with the scoring to be analized.
     * @return Name of the file name with the individual scores.
     */
    private Object[] obtainValues(String args[]) {
        Object[] response = new Object[2]; 
        String fileName = null;
        Boolean verbose = Boolean.FALSE;
        if (args == null) {
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
