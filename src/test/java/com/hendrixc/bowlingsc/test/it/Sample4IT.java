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
import java.util.logging.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

/**
 * Integration Test Case for sample3 file.
 *
 * @author Henry Coral
 */
public class Sample4IT {

    private static final Logger LOG = Logger.getLogger(Sample4IT.class.getName());
    
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
    public void testBad1() {
        try {
            String fileName1 = resourcesDirectory+File.separator+"bad1.txt";
            List<Player> players  = parser.parseFile(fileName1);
            List<Player> scores = new ArrayList<>();
            for (Player player : players) {
                scores.add(calculator.calculate(player));
            }
            formatter.format(scores);
            
        } catch (ParserException | IOException | ScoreCalculationException | ScoreFormatterException ex) {
            Assertions.assertEquals("The sum of first and second throws exceed the max pines number.", ex.getMessage());
        }
    }
    
    @Test
    public void testBad2() {
        try {
            String fileName1 = resourcesDirectory+File.separator+"bad2.txt";
            List<Player> players  = parser.parseFile(fileName1);
            List<Player> scores = new ArrayList<>();
            for (Player player : players) {
                scores.add(calculator.calculate(player));
            }
            formatter.format(scores);
            
        } catch (ParserException | IOException | ScoreCalculationException | ScoreFormatterException ex) {
            Assertions.assertEquals("Frames for player Jeff are insufficients.", ex.getMessage());
        }
    }
    
    
    
}
