/*
 * System: Bowling Score Calculator
 * Author: Henry Coral
 * 
 * This program is for demo purposes, you can use or modify it under your own risk.
 */
package com.hendrixc.bowlingsc.service.parser;


import com.hendrixc.bowlingsc.model.Player;
import java.io.IOException;
import java.util.List;

/**
 * Define the methods that must be implemented to create an Score Parser implementation.
 * A ScoreParser implementation must be able to process a file or an text in order to validate and produce 
 * a List of Player type objects.
 * 
 * The parse process must be perform the following validdations:<br>
 * One to Six players
 * Ten frames for player, each frame with one to two turn excepted the last frame that could be 3 turns.
 * Each line has to be the format below:
 * Player Name[tab char] number of pins knoked down, example
 * John   4
 * 
 * @author Henry Coral
 */
public interface ScoreParser {
    
    /**
     * Execute the parse of a file to return a list of a Player objects.
     * This method internally call to the parseContent method.
     * 
     * @param fileName name of the file that contains the players and frames.
     * @return a list of Players, each one with their respective frames.
     * @throws ParserException if the file content is not correct.
     * @throws IOException if the file can not be read or does not exists.
     */
    List<Player> parseFile(String fileName) throws ParserException, IOException;
    
    /**
     * Execute the parse of a text to return a list of a Player objects.
     * This method must perform a syntactic and value validation of each lines contained in the 
     * file before validating the structure and order of each player's frames.
     * 
     * @param content text content to be parsed.
     * @return a list of Players, each one with their respective frames.
     * @throws ParserException if the text content is not correct.
     */
    List<Player> parseContent(String content)  throws ParserException;
    
    
}
