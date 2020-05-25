/*
 * System: Bowling Score Calculator
 * Author: Henry Coral
 * Stage: Unit Test
 * 
 * This program is for demo purposes, you can use or modify it under your own risk.
 */
package com.hendrixc.bowlingsc.test.ut;

import com.hendrixc.bowlingsc.service.parser.ParserException;
import com.hendrixc.bowlingsc.service.parser.ScoreParser;
import com.hendrixc.bowlingsc.service.parser.TextScoreParser;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

/**
 * Test Cases for parseContent method of TextScoreParser class.
 *
 * @author Henry Coral
 */
@DisplayName("Tests for parseContent method of TextScoreParser class")
public class ParseContentTextScoreParserTest {
    
    private final ScoreParser parser = new TextScoreParser();
    
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Proces Line with incorrect values")
    public void testNullAndEmptyContent(String line) {
        Assertions.assertThrows(ParserException.class,() -> parser.parseContent(line)); 
    }
    
    @ParameterizedTest
    @MethodSource("contentExceedMaximunPlayers")
    @DisplayName("Parse Content that exceed maximun players")
    public void testContentExceedMaximunPlayers(String content) {
        Exception e = Assertions.assertThrows(ParserException.class,() -> parser.parseContent(content)); 
        Assertions.assertEquals("Players number exceed maximun permited 6.", e.getMessage());
    }
    
    @ParameterizedTest
    @MethodSource("contentOnePlayerPerfectScore")
    @DisplayName("Parse Content of player with perfect score")
    public void testContentOnePlayerPerfectScore(String content) {
        Assertions.assertDoesNotThrow(() -> parser.parseContent(content)); 
    }
    
    @ParameterizedTest
    @MethodSource("contentOnePlayerTerribleScore")
    @DisplayName("Parse Content of player with terrible score")
    public void testContentOnePlayerTerribleScore(String content) {
        Assertions.assertDoesNotThrow(() -> parser.parseContent(content)); 
    }
    
    @ParameterizedTest
    @MethodSource("contentSample")
    @DisplayName("Parse Content sample")
    public void testContentSample(String content) {
        Assertions.assertDoesNotThrow(() -> parser.parseContent(content)); 
    }
    
    @ParameterizedTest
    @MethodSource("contentExceedMaximunFramesForPlayer")
    @DisplayName("Parse Content that exceed Maximun Frames For Player")
    public void testContentExceedMaximunFramesForPlayer(String content) {
        Exception e = Assertions.assertThrows(ParserException.class,() -> parser.parseContent(content)); 
        Assertions.assertEquals("Exceed maximun number of Frames.", e.getMessage());
    }
    
    static Stream<String> contentExceedMaximunPlayers() {
        return Stream.of(
                "Jeff\t10\n" +
                "María\t10\n" +
                "María Ñacato\t10\n" +
                "Colón\t10\n" +
                "O'Brian\t10\n" +
                "PETER\t10\n" +
                "carl\t10\n"
        );
    }
    
    static Stream<String> contentExceedMaximunFramesForPlayer() {
        return Stream.of(
                "Jeff\t10\n" +
                "Jeff\t10\n" +
                "Jeff\t10\n" +
                "Jeff\t10\n" +
                "Jeff\t10\n" +
                "Jeff\t10\n" +
                "Jeff\t10\n" +
                "Jeff\t10\n" +
                "Jeff\t10\n" +
                "Jeff\t10\n" +  
                "Jeff\t10\n" +
                "Jeff\t10\n" +
                "Jeff\t10\n" +
                "Jeff\t10\n"         
        );
    }
    static Stream<String> contentOnePlayerPerfectScore() {
        return Stream.of(
                "Jeff\t10\n" +
                "Jeff\t10\n" +
                "Jeff\t10\n" +
                "Jeff\t10\n" +
                "Jeff\t10\n" +
                "Jeff\t10\n" +
                "Jeff\t10\n" +
                "Jeff\t10\n" +
                "Jeff\t10\n" +
                "Jeff\t10\n" +  
                "Jeff\t10\n" +
                "Jeff\t10\n"         
        );
    }
    
    static Stream<String> contentOnePlayerTerribleScore() {
        return Stream.of(
                "Jeff\t0\n" +
                "Jeff\t0\n" +
                "Jeff\t0\n" +
                "Jeff\t0\n" +
                "Jeff\t0\n" +
                "Jeff\t0\n" +
                "Jeff\t0\n" +
                "Jeff\t0\n" +
                "Jeff\t0\n" +
                "Jeff\t0\n" +  
                "Jeff\t0\n" +
                "Jeff\t0\n" +
                "Jeff\t0\n" +
                "Jeff\t0\n" +
                "Jeff\t0\n" +
                "Jeff\t0\n" +
                "Jeff\t0\n" +
                "Jeff\t0\n" +
                "Jeff\t0\n" +        
                "Jeff\t0\n"         
        );
    }
    
    static Stream<String> contentSample() {
        return Stream.of(
                "Jeff\t10\n"
                + "John\t3\n"
                + "John\t7\n"
                + "Jeff\t7\n"
                + "Jeff\t3\n"
                + "John\t6\n"
                + "John\t3\n"
                + "Jeff\t9\n"
                + "Jeff\t0\n"
                + "John\t10\n"
                + "Jeff\t10\n"
                + "John\t8\n"
                + "John\t1\n"
                + "Jeff\t0\n"
                + "Jeff\t8\n"
                + "John\t10\n"
                + "Jeff\t8\n"
                + "Jeff\t2\n"
                + "John\t10\n"
                + "Jeff\tF\n"
                + "Jeff\t6\n"
                + "John\t9\n"
                + "John\t0\n"
                + "Jeff\t10\n"
                + "John\t7\n"
                + "John\t3\n"
                + "Jeff\t10\n"
                + "John\t4\n"
                + "John\t4\n"
                + "Jeff\t10\n"
                + "Jeff\t8\n"
                + "Jeff\t1\n"
                + "John\t10\n"
                + "John\t9\n"
                + "John\t0"
        );
    }
}
