/*
 * System: Bowling Score Calculator
 * Author: Henry Coral
 * Stage: Unit Test
 * 
 * This program is for demo purposes, you can use or modify it under your own risk.
 */
package com.hendrixc.bowlingsc.test.it;

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
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Integration Test Case for terrible Score.
 *
 * @author Henry Coral
 */
public class TerribleScoreIT {

    private static final Logger LOG = Logger.getLogger(TerribleScoreIT.class.getName());
    
    private final ScoreParser parser = new TextScoreParser();
    private final ScoreCalculator calculator = new TenPinScoreCalculator();
    private final ScoreFormatter formatter = new ConsoleScoreFormatter();
    
    private static String resourcesDirectory; 
    
    @BeforeAll
    static void initAll() {
        File dir = new File("src/test/resources");
        resourcesDirectory = dir.getAbsolutePath();
    }
    
    @Test
    public void testScore() {
        try {
            String fileName1 = resourcesDirectory+File.separator+"terrible.txt";
            List<Player> players  = parser.parseFile(fileName1);
            List<Player> scores = new ArrayList<>();
            for (Player player : players) {
                scores.add(calculator.calculate(player));
            }
            String toPrint = formatter.format(scores);
            String expected = ""
                    + "Frame		1		2		3		4		5		6		7		8		9		10\n" +
                    "Jeff\n" +
                    "Pinfalls	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0\n" +
                    "Score		0		0		0		0		0		0		0		0		0		0\n";
            Assertions.assertEquals(expected, toPrint);
        } catch (ParserException | IOException | ScoreCalculationException | ScoreFormatterException ex) {
            LOG.log(Level.SEVERE, "Exception in testScore", ex);
        }
    }
    
}
