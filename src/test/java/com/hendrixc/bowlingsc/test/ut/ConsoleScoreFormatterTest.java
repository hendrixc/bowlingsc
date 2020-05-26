/*
 * System: Bowling Score Calculator
 * Author: Henry Coral
 * Stage: Unit Test
 * 
 * This program is for demo purposes, you can use or modify it under your own risk.
 */
package com.hendrixc.bowlingsc.test.ut;

import com.hendrixc.bowlingsc.model.Frame;
import com.hendrixc.bowlingsc.model.Player;
import com.hendrixc.bowlingsc.service.format.ConsoleScoreFormatter;
import com.hendrixc.bowlingsc.service.format.ScoreFormatter;
import com.hendrixc.bowlingsc.service.format.ScoreFormatterException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

/**
 * Test Cases for parseContent method of ConsoleScoreFormatter class.
 *
 * @author Henry Coral
 */
@DisplayName("Tests for ConsoleScoreFormatter class")
public class ConsoleScoreFormatterTest {

    private static final Logger LOG = Logger.getLogger(ConsoleScoreFormatterTest.class.getName());
    
    private final ScoreFormatter formatter = new ConsoleScoreFormatter();
    
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Proces Text with incorrect values")
    public void testNullAndEmptyContent(Player player) {
        Assertions.assertThrows(ScoreFormatterException.class,() -> formatter.format(player)); 
    }
    
    @Test
    @DisplayName("Format for terrible score")
    public void testFormatTerribleScore() {
        try {
            String expected = "Jeff\n" +
                    "Pinfalls\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\n" +
                    "Score\t\t0\t\t0\t\t0\t\t0\t\t0\t\t0\t\t0\t\t0\t\t0\t\t0\n";
            String text = formatter.format(this.dataFactoryTerribleScore());
            Assertions.assertEquals(expected, text);
        } catch (ScoreFormatterException ex) {
            LOG.log(Level.SEVERE, "Exception in testFormatTerribleScore", ex);
        }
    }
    
    @Test
    @DisplayName("Format for perfect score")
    public void testFormatPerfectScore() {
        try {
            String expected = "Jeff\n" +
                                "Pinfalls	 	X	 	X	 	X	 	X	 	X	 	X	 	X	 	X	 	X	X	X	X\n" +
                                "Score		30		60		90		120		150		180		210		240		270		300\n";
            String text = formatter.format(this.dataFactoryPerfectScore());
            Assertions.assertEquals(expected, text);
        } catch (ScoreFormatterException ex) {
            LOG.log(Level.SEVERE, "Exception in testFormatPerfectScore", ex);
        }
    }
    
    @Test
    @DisplayName("Format for dataset 1")
    public void testDataSet1FormatScore() {
        try {
            String expected = "Jeff\n" +
                              "Pinfalls	 	X	7	/	9	9	 	X	0	0	8	/	0	0	 	X	 	X	X	8	1\n" +
                              "Score		20		39		48		66		74		84		90		120		148		167\n";
            String text = formatter.format(this.dataFactoryDataSet1());
            Assertions.assertEquals(expected, text);
        } catch (ScoreFormatterException ex) {
            LOG.log(Level.SEVERE, "Exception in testDataSet1FormatScore", ex);
        }
    }
    
    private Player dataFactoryPerfectScore() {
        Player player = new Player("Jeff");
        for (int turn = 1; turn < 10; turn++) {
            Frame frame = new Frame(turn);
            frame.setFirstBall(10);
            frame.setScore(turn*30);
            player.putFrame(frame);
        }
        Frame frame = new Frame(10);
        frame.setFirstBall(10);
        frame.setSecondBall(10);
        frame.setBonusBall(10);
        frame.setScore(300);
        player.putFrame(frame);
        player.setFinalScore(300);
        return player;
    }
    
    private Player dataFactoryTerribleScore() {
        Player player = new Player("Jeff");
        for (int turn = 1; turn < 10; turn++) {
            Frame frame = new Frame(turn);
            frame.setFirstBall(0);
            frame.setSecondBall(0);
            frame.setScore(0);
            player.putFrame(frame);
        }
        Frame frame = new Frame(10);
        frame.setFirstBall(0);
        frame.setSecondBall(0);
        frame.setScore(0);
        player.putFrame(frame);
        player.setFinalScore(0);
        return player;
    }
    
        private Player dataFactoryDataSet1() {
        Player player = new Player("Jeff");
        Frame frame = new Frame(1);
        frame.setFirstBall(10);
        frame.setScore(20);
        player.putFrame(frame);
        frame = new Frame(2);
        frame.setFirstBall(7);
        frame.setSecondBall(3);
        frame.setScore(39);
        player.putFrame(frame);
        frame = new Frame(3);
        frame.setFirstBall(9);
        frame.setSecondBall(0);
        frame.setScore(48);
        player.putFrame(frame);
        frame = new Frame(4);
        frame.setFirstBall(10);
        frame.setScore(66);
        player.putFrame(frame);
        frame = new Frame(5);
        frame.setFirstBall(0);
        frame.setSecondBall(8);
        frame.setScore(74);
        player.putFrame(frame);
        frame = new Frame(6);
        frame.setFirstBall(8);
        frame.setSecondBall(2);
        frame.setScore(84);
        player.putFrame(frame);
        frame = new Frame(7);
        frame.setFirstBall(0);
        frame.setSecondBall(6);
        frame.setScore(90);
        player.putFrame(frame);
        frame = new Frame(8);
        frame.setFirstBall(10);
        frame.setScore(120);
        player.putFrame(frame);
        frame = new Frame(9);
        frame.setFirstBall(10);
        frame.setScore(148);
        player.putFrame(frame);
        frame = new Frame(10);
        frame.setFirstBall(10);
        frame.setSecondBall(8);
        frame.setBonusBall(1);
        frame.setScore(167);
        player.putFrame(frame);
        player.setFinalScore(166);
        return player;
    }
    
}
