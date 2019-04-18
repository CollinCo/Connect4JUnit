// Collin Connolly
// Project 2
package ui;
import core.Connect4;
import ui.Connect4GUI;

import java.util.Scanner;
import ui.Connect4GUI;

//JavaFX
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Ellipse;

/**
 * Handles the Connect 4 game's interaction with console.
 * 2 users play connect 4. Board is displayed after every turn
 * until a winner is detected or there is no winner found when
 * the board is filled.
 * @author Collin Connolly
 * @version 1.1
 */
public class Connect4TextConsole {

    /**
     * Creates game object and handles all game interactions
     * with the console.
     * @param args - Default args
     */
    public static void main (String args[]) {
    	
    	
        Scanner scan = new Scanner(System.in);
        System.out.println("Connect4");
        String mode;
        int pvp;

        System.out.print("Enter g for GUI or t for text console: ");
        mode = scan.nextLine();
        

        while(!(mode.equals("g") || mode.equals("G") || mode.equals("t") || mode.equals("T"))){
            System.out.println("Please input a g or a t");
            mode = scan.nextLine();
        }
        
        if(mode.equals("g") || mode.equals("G")) {
        	Connect4GUI.main(args);
            return;
        } 
        
        System.out.print("Enter p for Human vs. Human or enter c to play against a computer: ");
        mode = scan.nextLine();

        while(!(mode.equals("p") || mode.equals("c") || mode.equals("P") || mode.equals("C"))){
            System.out.println("Please input a C or a P");
            mode = scan.nextLine();
        }

        // setting mode
        if(mode.equals("p") || mode.equals("P")) {
            System.out.println("\nHuman vs Human selected\n");
            pvp = 0;
        } else {
            System.out.println("\nHuman vs Computer selected\n");
            pvp = 1;
        }

        // Create Board and initial print of blank board
        Connect4 board = new Connect4(pvp);
        System.out.print(board.toString());
        boolean win = false;
        int turn = 0;

        // Game running - players take turns
        while(!win && turn < 42) {
            win = Connect4.takeTurn(turn);
            System.out.print(board.toString());
            turn++;
        }

        // Full board check
        if(turn == 42)
            System.out.println("Grid full! No winner!");

            // Win found - Print winning player
        else if(turn % 2 == 0 && pvp == 0)
            System.out.println("Player X won!");
        else if(turn % 2 == 0 && pvp == 1)
            System.out.println("Computer won!");
        else if(turn % 2 == 1 && pvp == 0)
            System.out.println("Player O won!");
        else if(turn % 2 == 1 && pvp == 1)
            System.out.println("Player won!");
    }
}