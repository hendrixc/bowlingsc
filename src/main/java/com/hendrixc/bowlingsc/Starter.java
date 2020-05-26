/*
 * System: Bowling Score Calculator
 * Author: Henry Coral
 * 
 * This program is for demo purposes, you can use or modify it under your own risk.
 */
package com.hendrixc.bowlingsc;

import com.hendrixc.bowlingsc.model.Player;
import com.hendrixc.bowlingsc.service.calculator.ScoreCalculationException;
import com.hendrixc.bowlingsc.service.calculator.ScoreCalculator;
import com.hendrixc.bowlingsc.service.calculator.TenPinScoreCalculator;
import com.hendrixc.bowlingsc.service.format.ConsoleScoreFormatter;
import com.hendrixc.bowlingsc.service.format.ScoreFormatter;
import com.hendrixc.bowlingsc.service.format.ScoreFormatterException;
import com.hendrixc.bowlingsc.service.parser.ParserException;
import com.hendrixc.bowlingsc.service.parser.ScoreParser;
import com.hendrixc.bowlingsc.service.parser.TextScoreParser;

import java.io.IOException;
import java.util.ArrayList;
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

    private static final Logger LOG = Logger.getLogger(Starter.class.getName());
    
    private static final String MAIN = "\n" 
            + "Bowling Scoring\n"
            + "===============\n";
    
    private static final String USAGE = "\n" 
            + "Basic Usage:\n"
            + "\tjava -jar bowlingsc-full.jar \n"
            + "Providing a file name: \n"
            + "\tjava -jar bowlingsc.jar scoringFile.txt\n";
    
    /**
     * The application's entry point 
     * @param args an array of command-line arguments for the application
     */
    public static void main(String args[]) {
        Starter.printer(MAIN);
        Starter starter = new Starter();
        starter.process(args);
    }
    
    /**
     * Execute the program according the parameters received.
     * @param args command line parameters.
     */
    public void process(String args[]) {
        String fileName = this.obtainExecutionValues(args);
        ScoreParser parser = new TextScoreParser();
        ScoreCalculator calculator = new TenPinScoreCalculator();
        ScoreFormatter formatter = new ConsoleScoreFormatter();
        try {
            List<Player> players = parser.parseFile(fileName);
            List<Player> playersC = new ArrayList<>();
            for (Player player : players) {
                playersC.add(calculator.calculate(player));
            }
            String text = formatter.format(playersC);
            Starter.printer(text);
        } catch (ParserException | IOException | ScoreCalculationException | ScoreFormatterException ex) {
           LOG.log(Level.SEVERE, "An exception has ocurred:" + ex.getMessage(), ex);
           System.exit(-1);
        }
        
    }
    
    /**
     * Gets the necessary values of the arguments for the program execution.
     * @param args values passed in the command line.
     * @return the file name.
     */
    private String obtainExecutionValues(String args[]) {
        String fileName=null;
        switch (args.length) {
            case 0:
                Scanner scan = new Scanner(System.in);
                Starter.printer("Input the file name: ");
                fileName = scan.nextLine();
                break;
            case 1:
                fileName = args[0];
                break;
            default:
                Starter.printer(USAGE);
                System.exit(-1);
        }
        return fileName;
    }
    
    /**
     * Wrapper for System.out.println
     * @param message Message to be printed in the console.
     */
    private static void printer(String message) {
        System.out.println(message);
    }
    
}
