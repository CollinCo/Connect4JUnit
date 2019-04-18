package core;

import org.junit.Assert.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import core.Connect4;

class Connect4JUnit {
    private Connect4 game;
    private Connect4ComputerPlayer computer;
    
    
    // Testing connect4 file
    @BeforeEach
    public void setUp() throws Exception {
        game = new Connect4(0);

        Connect4ComputerPlayer computer = new Connect4ComputerPlayer();
    }
    
    @Test
    void testConstructor() { 
        assertNotNull(game);
    }

    @Test
    void testTakeTurnGUI() {
	assertEquals(0, game.takeTurnGUI(true, 1, 1));
	assertEquals(0, game.takeTurnGUI(false, 0, 0));
	assertEquals(0, game.takeTurnGUI(true, 6, 4));
	assertEquals(0, game.takeTurnGUI(false, 5, 1));
    }
    
    @Test
    void testCheckWinHorizontal() {
	assertFalse(game.checkWin(0));
	game.takeTurnGUI(false, 0, 0);
	game.takeTurnGUI(false, 0, 1);
	game.takeTurnGUI(false, 0, 2);
	game.takeTurnGUI(false, 0, 3);
	assertTrue(game.checkWin(0));
    }
    
    @Test
    void testCheckWinVertical() {
	assertFalse(game.checkWin(0));
	game.takeTurnGUI(true, 0, 0);
	game.takeTurnGUI(true, 1, 0);
	game.takeTurnGUI(true, 2, 0);
	game.takeTurnGUI(true, 3, 0);
	assertTrue(game.checkWin(1));
    }
    
    @Test
    void testCheckWinDescendingDiagonal() {
	assertFalse(game.checkWin(0));
	game.directPlace(0, 0);
	game.directPlace(1, 1);
	game.directPlace(2, 2);
	game.directPlace(3, 3);
	assertTrue(game.checkWin(0));
    }
   
    @Test
    void testCheckWinAscendingDiagonal() {
	game.directPlace(3, 0);
	game.directPlace(2, 1);
	game.directPlace(1, 2);
	game.directPlace(0, 3);
    	assertTrue(game.checkWin(0));
    }
    
    @Test
    void testComputerTurn() {
	//game.takeTurnGUI(true, 0, 0);
	computer.takeTurn(game.board);
    }
    
    @Test
    void testToString() {
	game.toString();
    }
}
