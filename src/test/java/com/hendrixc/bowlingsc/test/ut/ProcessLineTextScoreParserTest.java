/*
 * System: Bowling Score Calculator
 * Author: Henry Coral
 * Stage: Unit Test
 * 
 * This program is for demo purposes, you can use or modify it under your own risk.
 */
package com.hendrixc.bowlingsc.test.ut;

import com.hendrixc.bowlingsc.service.parser.LineContent;
import com.hendrixc.bowlingsc.service.parser.ParserException;
import com.hendrixc.bowlingsc.service.parser.ScoreParser;
import com.hendrixc.bowlingsc.service.parser.TextScoreParser;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

/**
 * Test Cases for processLine method of TextScoreParser class.
 *
 * @author Henry Coral
 */
@DisplayName("Tests for procesLine method of TextScoreParser class")
public class ProcessLineTextScoreParserTest {
    
    private final ScoreParser parser = new TextScoreParser();
    
    @Test
    @DisplayName("Test LineContent object")
    public void testLineContent() {
        try {
            String line = "Jeff\t4";
            LineContent lineContent = this.parser.processLine(line);
            Assertions.assertEquals("Jeff", lineContent.getName());
            Assertions.assertEquals(Integer.valueOf(4), lineContent.getPines());
            line = "Jeff\tF";
            lineContent = this.parser.processLine(line);
            Assertions.assertEquals("Jeff", lineContent.getName());
            Assertions.assertEquals(Integer.valueOf(0), lineContent.getPines());
        } catch (ParserException ex) {
            Logger.getLogger(ProcessLineTextScoreParserTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @ParameterizedTest
    @MethodSource("correctStrings")
    @DisplayName("Proces Line with correct values")
    public void testCorrectValues(String line) {
        Assertions.assertDoesNotThrow(() -> parser.processLine(line)); 
    }
    
    @ParameterizedTest
    @NullAndEmptySource
    @MethodSource("badStrings")
    @DisplayName("Proces Line with incorrect values")
    public void testInorrectValues(String line) {
        Assertions.assertThrows(ParserException.class,() -> parser.processLine(line)); 
    }
    
    static Stream<String> badStrings() {
        return Stream.of(
                "Jeff\t15",
                "María\t-1",
                "María Ñacato\tD",
                "Colón1\t1",
                "  Ángel  \t",
                "O'Brian",
                "Müller\t ",
                " \t1",
                "1\t1",
                " \t ",
                "A\tFF",
                "A\tff"
        );
    }
    
    static Stream<String> correctStrings() {
        return Stream.of(
                "Jeff\t1",
                "María\t1",
                "María Ñacato\t1",
                "Colón\t1",
                "  Ángel  \t  1  ",
                "O'Brian\tF",
                "PETER\tF ",
                "carl\t F",
                "PETER\tf ",
                "carl\t f",
                "PETER\t F ",
                "carl\t f ",
                "François Hollande\t\t10",
                "Müller\t0 "
        );
    }
}
