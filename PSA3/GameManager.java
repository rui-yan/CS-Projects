
/* File header comment
 * Name: Rui Yan
 * Login: cs8bwaka 
 * Date: February 2nd, 2016
 * File: GameManager.java 
 * Sources of Help: Textbook  
 * 
 * This program will manage the game 2048.
 * 
 */

import java.util.*;
import java.io.*;

/* Class header comment
 * Name: GameManager
 * Purpose: This class contains several methods to manage the gameplay 
 */

public class GameManager {
    // Instance variables
    private Board board; // The actual 2048 board
    private String outputFileName; 
    // File to save the board to when exiting

    // TODO PSA3
    // GameManager Constructor
    // Generate new game
    public GameManager(int boardSize, String outputBoard, Random random) {
	// Check if the value of boardSize is an integer 
	// that greater or equal to 2. 
	if(boardSize >= 2)
	    this.board = new Board (boardSize, random);
	else if (boardSize < 2){
	    System.out.println("boardSize should not less than 2");
	}

	this.outputFileName = outputBoard;
	System.out.println("Generating a New Board");
    }

    // TODO PSA3
    // GameManager Constructor
    // Load a saved game
    public GameManager(String inputBoard, String outputBoard, 
	    Random random) throws IOException {
	this.board = new Board (inputBoard, random);
	// Check if the outputBoard is null String
	if(outputBoard != null)
	    this.outputFileName = outputBoard;
	else{
	    System.out.println("output string should not be null");
	}
	System.out.println("Loading Board from " + inputBoard);
    }

    // TODO PSA3
    // Main play loop
    // Takes in input from the user to specify moves to execute
    // valid moves are:
    //      k - Move up
    //      j - Move Down
    //      h - Move Left
    //      l - Move Right
    //      q - Quit and Save Board
    //
    //  If an invalid command is received then print the controls
    //  to remind the user of the valid moves.
    //
    //  Once the player decides to quit or the game is over,
    //  save the game board to a file based on the outputFileName
    //  string that was set in the constructor and then return
    //
    //  If the game is over print "Game Over!" to the terminal


    /* Method header comment
     * Name: play
     * Purpose: This method will print out the controls used to operate 
     *   the game and the current state of the 2048 board to the console
     *   then prompt the user for a command. Then it will check if the 
     *   command is valid and if it is valid, it will execute the command.
     *   If it is not valid, it will exit and save the file.
     * Parameters: None
     * Return: void
     */

    public void play() throws IOException {

	//print out controls
	this.printControls();

	//print out current board
	String game = board.toString();
	System.out.print(game);

	Scanner sc = new Scanner(System.in);
	String s = sc.next();
	// prompt user for a command

	Direction dir = Direction.UP;
	// initiate the Direction dir

	while(!s.equals("q") && !board.isGameOver()){

	    if (s.equals("k") || s.equals("j") || 
		    s.equals("h") || s.equals("l")){
		// Check if the command is valid

		if (s.equals("k"))
		    dir = Direction.UP;

		else if (s.equals("j"))
		    dir = Direction.DOWN;

		else if (s.equals("h"))
		    dir = Direction.LEFT;

		else if (s.equals("l"))
		    dir = Direction.RIGHT;

		if (board.canMove(dir)){
		    board.move(dir);
		    board.addRandomTile();
		} // Check if it is a valid move. Perform
		// the move and add a new tile

		game = board.toString();
		System.out.print(game);
		s = sc.next();
		// Print out the updated board and prompt
		// the user another command
		    }

	    else{
		this.printControls();
		game = board.toString();
		System.out.print(game);
		s = sc.next();
		// If the command is invalid, it will print
		// out Controls and updated board, 
		// and prompt the user for another command
	    }

	}

	if(s.equals("q") || board.isGameOver()){
	    // Check if user decide to quit or the game is over
	    if (board.isGameOver() == true){
		System.out.println("Game Over!");
		// Print"Game over!" if the game is over
	    }
	    board.saveBoard(outputFileName);
	    // Save the board to the output file specified by
	    // the instance variable outputFileName 
	    return;
	    // Exit the method
	}
    }

    /* Method header comment
     * Name: printControls
     * Purpose: This method will print the controls for the game.
     * Parameters: None
     * Return: void
     */

    private void printControls() {
	System.out.println("  Controls:");
	System.out.println("    k - Move Up");
	System.out.println("    j - Move Down");
	System.out.println("    h - Move Left");
	System.out.println("    l - Move Right");
	System.out.println("    q - Quit and Save Board");
	System.out.println();
    }
}
