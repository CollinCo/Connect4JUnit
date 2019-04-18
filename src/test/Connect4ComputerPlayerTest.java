package test;

import org.junit.Assert.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import core.Connect4;
import core.Connect4ComputerPlayer;

class Connect4ComputerPlayerTest {
    private Connect4 game;
    private Connect4ComputerPlayer comp;
    private int ROWS = 6;
    private int COLS = 7;
    private char board[][] = new char[COLS + 1][ROWS + 1];; 
     
    // Testing connect4 file
    @BeforeEach
    public void setUp() {
	
        game = new Connect4(1);
        comp = new Connect4ComputerPlayer();
        
        
        for(int i = 0; i < COLS; i++) {
            for(int j = 0; j < ROWS; j++) {
                board[i][j] = ' ';
            }
        }
    }
    
    @Test
    void testConstructor() { 
        assertNotNull(game);
    }
    
    @Test
    void testTakeTurn() {
	assertNotNull(comp.takeTurn(board));
    }
    
    @Test
    void testCheckBoardVertical() {
	board[0][0] = 'X';
	board[0][1] = 'X';
	board[0][2] = 'X';
	board[0][3] = 'X';
	assertNotNull(comp.takeTurn(board));
    }
    
    @Test
    void testCheckBoardUpDiag() {
	board[0][0] = 'X';
	board[1][1] = 'X';
	board[2][2] = 'X';
	board[3][3] = 'X';
	assertNotNull(comp.takeTurn(board));
    }  
    
    @Test
    void testCheckBoardDownDiag() {
	board[3][0] = 'X';
	board[2][1] = 'X';
	board[1][2] = 'X';
	board[0][3] = 'X';
	assertNotNull(comp.takeTurn(board));
    } 
    
    @Test
    void testCheckBoardHorizontal() {
	board[3][0] = 'X';
	board[2][0] = 'X';
	board[1][0] = 'X';
	board[0][0] = 'X';
	assertNotNull(comp.takeTurn(board));
    }
}
