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
import java.io.File;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Test Cases for parseFile method of TextScoreParser class.
 *
 * @author Henry Coral
 */
@DisplayName("Tests for parseFile method of TextScoreParser class")
public class ParseFileTextScoreParserTest {
    
    private final ScoreParser parser = new TextScoreParser(); 
    private static String resourcesDirectory; 
    
    @BeforeAll
    static void initAll() {
        File dir = new File("src/test/resources");
        resourcesDirectory = dir.getAbsolutePath();
    }
    
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Proces File with incorrect values")
    public void testNullAndEmptyFileName(String fileName) {
        Assertions.assertThrows(ParserException.class,() -> parser.parseFile(fileName)); 
    }
    
    @ParameterizedTest
    @DisplayName("Process Files with all files exists.")
    @ValueSource(strings = { "perfect.txt", "terrible.txt", "sample1.txt" })
    public void testExistingFiles(String fileName) {
        String fileName1 = resourcesDirectory+File.separator+fileName;
        Assertions.assertDoesNotThrow(() -> parser.parseFile(fileName1));
    }
    
}
