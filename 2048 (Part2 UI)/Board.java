
/* File header comment
 * Name: Rui Yan
 * Login: cs8bwaka 
 * Date: January 25, 2016
 * File: Board.java 
 * Sources of Help: Textbook  
 * 
 * This program will create several methods of Board in order to save 
 * the board, add random tile to the board and rotate the board.
 */

/**
 * Sample Board
 * <p/>
 * 0   1   2   3
 * 0   -   -   -   -
 * 1   -   -   -   -
 * 2   -   -   -   -
 * 3   -   -   -   -
 * <p/>
 * The sample board shows the index values for the columns and rows
 * Remember that you access a 2D array by first specifying the row
 * and then the column: grid[row][column]
 */

import java.util.*;
import java.io.*;

/* Class header comment
 * Name: Board
 * Purpose: This class contains several methods to save, rotate and
 * add new tile to the board which are needed in the gameplay. 
 */

public class Board {
    public final int NUM_START_TILES = 2;
    public final int TWO_PROBABILITY = 90;
    public final int GRID_SIZE;

    private final Random random;
    private int[][] grid;
    private int score;

    // TODO PSA3 Constructor
    // Constructs a fresh board with random tiles
    public Board(int boardSize, Random random) {
	this.random = random; // FIXME
	GRID_SIZE = boardSize; // FIXME
	this.grid = new int[GRID_SIZE][GRID_SIZE];
	this.score = 0;
	for (int i = 0; i < NUM_START_TILES; i++){
	    this.addRandomTile();
	    // Add a few stater tiles to the board
	    // based on the constant NUM_START_TILES
	}
    }

    // TODO PSA3 Constructor
    // Construct a board based off of an input file
    public Board(String inputBoard, Random random) throws IOException {

	Scanner input = new Scanner(new File(inputBoard));
	String s1 = input.nextLine();
	int gridSize = Integer.parseInt(s1);
	String s2 = input.nextLine();
	int scr = Integer.parseInt(s2);
	// Read from the inputFile
	// Convert the strings1 in the first line (size)
	// into integer gridSize; Convert the string in the second
	// line (score) into integer scr.

	this.random = random; // FIXME
	GRID_SIZE = gridSize; // FIXME
	this.grid = new int[GRID_SIZE][GRID_SIZE];
	score = scr;
	String in = " ";
	int index = 0;
	for (int i = 0; i < grid.length; i++){
	    for (int j = 0; j < grid[i].length; j++){
		in = input.next();
		index = Integer.parseInt(in);
		grid[i][j] = index;
	    }
	}
	// Loads a saved board from the file specified 
	// by the string inputBoard.
    }

    // TODO PSA3
    /* Method header comment
     * Name: saveBoard
     * Purpose: This method will save theh current board to a file
     * Parameters: String outputBoard, the name of the file you want
     * to save your board to
     * Return: void
     */

    public void saveBoard(String outputBoard) throws IOException {
	PrintWriter writer = new PrintWriter(outputBoard);
	// Write into the file called outputBoard
	writer.println(GRID_SIZE);
	// Print out the size of board at the first line
	writer.println(score);
	// Print out the score at the second line
	for (int i = 0; i < grid.length; i++){
	    for (int j = 0; j < grid[i].length; j++){
		writer.print(grid[i][j]+" ");
		// print out each tile in the board
		// one by one
	    }
	    writer.println();
	}	
	writer.close();
    }

    // TODO PSA3
    /* Method header comment
     * Name: addRandomTile
     * Purpose: This method will add a random tile (of value 2 or 4) 
     *          to a random empty space on the board.
     * Parameters: None
     * Return: void
     */

    public void addRandomTile() {
	int count = 0; 
	// Count is the number of available tiles 
	int location = 0;
	int value = 0;

	for (int i = 0; i < grid.length; i++){
	    for (int j = 0; j < grid[i].length; j++){
		if (grid[i][j] == 0){
		    count += 1;
		}
	    }
	}
	// Count the number of available tiles

	if (count == 0)
	    return; // Exit if count is 0

	else{
	    int[] empty = new int[count];
	    // create an array called empty with 
	    // the size of count 

	    location = random.nextInt(count);
	    // get a random int called location 
	    // between 0 and count-1

	    value = random.nextInt(100);
	    // get a random int called value between 0 and 99

	    if (value < TWO_PROBABILITY)
		// Determine the value of new tiles (2 or 4)
		empty[location] = 2;
	    else
		empty[location] = 4;

	    // Loop over the 2D array grid and 1D array empty
	    // and give the value of nth empty spot in empty
	    // back to the 2D array. 
	    int n = 0;
	    for (int i = 0; i < grid.length; i++){
		for (int j = 0; j < grid[i].length; j++){
		    if (grid[i][j] == 0){
			this.grid[i][j] = empty[n];
			// place the new tile at the 
			// n'th empty spot
			n=n+1;
		    }
		}
	    }
	}
    }


    // TODO PSA3

    /* Method header comment
     * Name: rotate
     * Purpose: This method will rotate the board by 90 degrees clockwise 
     *          or 90 degrees counter-clockwise. If rotateClockwise is 
     *          true, rotates the board clockwise, else rotates the board 
     *          counter-clockwise
     * Parameters: boolean rotateClockwise, Determine if you should 
     *             rotate the board clockwise. 
     * Return: void
     */

    public void rotate(boolean rotateClockwise) {
	int n = GRID_SIZE;
	int temp;

	if (rotateClockwise == true){
	    // rotate the board clockwise
	    for (int i = 0; i < n/2; i++){
		for (int j = i; j < n-i-1; j++){
		    temp = grid[i][j];
		    grid[i][j] = grid[n-j-1][i];
		    grid[n-j-1][i] = grid[n-i-1][n-j-1]; 
		    grid[n-i-1][n-j-1] = grid[j][n-i-1];
		    grid[j][n-i-1] = temp;
		}
	    }
	}

	else{
	    // rotate the board counterclockwise
	    for (int i = 0; i < n/2; i++){
		for (int j = i; j < n-i-1; j++){
		    temp = grid[i][j];
		    grid[i][j] = grid[j][n-i-1];
		    grid[j][n-i-1] = grid[n-i-1][n-j-1];
		    grid[n-i-1][n-j-1] = grid[n-j-1][i];
		    grid[n-j-1][i] = temp;
		}
	    }
	}
    }

    /* Extra Credit for PSA3
     * Method header comment
     * Name: isInputFileCorrectFormat
     * Purpose: This method will check if the input file is correct
     * Parameters: String inputFile, the name of the file you want
     *             to load your board from
     * Return: Return true if the file to be read is in the correct 
     *         format, else return false
     */

    /* CHECKLIST:
     * 1. boardsize:
     * 1) equal or larger than 2
     * 2) integer

     * 2. score
     * 1) non-negative
     * 2) integer
     * 3) % 4 == 0

     * 3. numbers in grid
     * 1) non-negative
     * 2) power of 2
     * 3) the number of tiles in each row should equals to size
     *
     * 4. the number of tiles
     * 1) equal to size * size
     */

    public static boolean isInputFileCorrectFormat(String inputFile) {

	try {   

	    // Read the inputfile
	    Scanner in = new Scanner(new File(inputFile));
	    // Read the gridsize (1st line)
	    String s3 = in.nextLine();
	    int size = Integer.parseInt(s3);
	    // Read the score (2nd line)
	    String s4 = in.nextLine();
	    int scor = Integer.parseInt(s4);

	    // Check if the size is larger than 0
	    if (size < 2) {
		System.out.println
		    ("Size should >= 2");
		return false;
	    }

	    // Check if the score is non-negative
	    if (scor < 0) {
		System.out.println
		    ("Score should be nonnegative");
		return false;
	    }

	    //  Check if the score is valid
	    else if ((scor > 0 && scor < 4) || (scor % 4) != 0){
		System.out.println("Score is not valid");
		return false;
	    }

	    String sNumber = " ";
	    int number = 0;
	    int gridCount = 0;

	    // Check if the numbers in grid are non-negative
	    // or power of 2 and count the number of grids

	    int[][] game = new int[size][size];

	    for (int i = 0; i < game.length; i++){
		for (int j = 0; j < game[i].length; j++){
		    sNumber = in.next();
		    number= Integer.parseInt(sNumber);

		    if (number < 0 ){
			System.out.println
			    ("Numbers in the grid have to be non-negative");
			return false;
		    }

		    else{
			int square = 1;
			while(number >= square){
			    if(number == square){
				square = square * 2;
				return true;
			    }
			    return false;
			}
			gridCount+=1;
		    }
		}
	    }

	    // Check if the number of tiles equal to size * size
	    if (gridCount != size * size)
		return false;

	    //write your code to check for all conditions and 
	    //return true if it satisfies all conditions 
	    //else return false

	    return true;
	} catch (Exception e) {
	    return false;
	}
    }

    // TODO PSA4
    // Performs a move operation

    /* Method header comment
     * Name: move
     * Purpose: This method will actually perform the main game logic         
     *          and perform a move. 
     * Parameters: Direction direction
     * Return: boolean move. Return true if the move was successful
     *         and false if it was not.
     */
    public boolean move(Direction direction) {

	boolean mo = false;//initiate the boolean move

	ArrayList<Integer> tileSet;//construct an arraylist

	// check if the board canMove
	if(this.canMove(direction) == true){
	    // loop over the column/row one by one
	    for(int i = 0; i < GRID_SIZE; i++){
		// initiate an arraylist	
		tileSet = new ArrayList<Integer>();

		// moveLeft
		if(direction == Direction.LEFT){
		    //loop over the first row in the board
		    for(int j = 0; j < GRID_SIZE; j++){
			//add the nonzero tiles into arrayList
			//(from left to right)
			if(grid[i][j]!=0)
			    tileSet.add(grid[i][j]);
		    }

		    //the following two steps are common in each 
		    //canMove helper method
		    //Step1: add zero tiles into the end of arrayList
		    for(int p = 0; tileSet.size() < GRID_SIZE; p++){
			tileSet.add(0);
		    }
		    //Step2: merge neighbouring tiles if they have same value 
		    for(int n = 1; n < GRID_SIZE; n++){
			if(tileSet.get(n-1) == tileSet.get(n)){
			    tileSet.set(n-1,tileSet.get(n-1)+tileSet.get(n));
			    tileSet.remove(n);
			    tileSet.add(0);
			    //update the score
			    score += tileSet.get(n-1);
			}
		    }
		    //load the updated arrayList back to the board
		    //(from left to right)
		    for(int t = 0; t < GRID_SIZE; t++){
			grid[i][t] = tileSet.get(t);
		    }
		    //return true if the board move to left
		    mo = true;
		}

		// moveRight
		if(direction == Direction.RIGHT){
		    //loop over the first row in the board
		    for(int j = 0; j < GRID_SIZE; j++){
			//add the nonzero tiles into arrayList
			//(from right to left)
			if(grid[i][GRID_SIZE-j-1]!=0)
			    tileSet.add(grid[i][GRID_SIZE-j-1]);
		    }

		    //common parts in canMove helper methods(see canMoveLeft)
		    for(int p = 0; tileSet.size() < GRID_SIZE; p++){
			tileSet.add(0);
		    }
		    for(int n = 1; n < GRID_SIZE; n++){
			if(tileSet.get(n-1) == tileSet.get(n)){
			    tileSet.set(n-1,tileSet.get(n-1)+tileSet.get(n));
			    tileSet.remove(n);
			    tileSet.add(0);
			    score += tileSet.get(n-1);
			}
		    }
		    //load the updated arrayList back to the board 
		    //(from right to left)
		    for(int t = 0; t < GRID_SIZE; t++){
			grid[i][GRID_SIZE-t-1] = tileSet.get(t);
		    }
		    mo = true;	  
		}

		// moveUp
		if(direction == Direction.UP){
		    //loop over the first column in the board  
		    for(int j = 0; j < GRID_SIZE; j++){
			//add the nonzero tiles into arrayList
			//(from up to down)
			if(grid[j][i]!=0)
			    tileSet.add(grid[j][i]);
		    }
		    //common parts in canMove helper methods(see canMoveLeft)
		    for(int p = 0; tileSet.size() < GRID_SIZE; p++){
			tileSet.add(0);
		    }
		    for(int n = 1; n < GRID_SIZE; n++){
			if(tileSet.get(n-1) == tileSet.get(n)){
			    tileSet.set(n-1,tileSet.get(n-1)+tileSet.get(n));
			    tileSet.remove(n);
			    tileSet.add(0);
			    score += tileSet.get(n-1);
			}
		    }
		    //load the updated arrayList back to the board 
		    //(from up to down)
		    for(int t = 0; t < GRID_SIZE; t++){
			grid[t][i] = tileSet.get(t);
		    }
		    mo = true;
		}

		// moveDown
		if(direction == Direction.DOWN){
		    //loop over the first column in the board    
		    for(int j = 0; j < GRID_SIZE; j++){
			//add the nonzero tiles into arrayList
			//(from down to up)
			if(grid[GRID_SIZE-j-1][i]!=0)
			    tileSet.add(grid[GRID_SIZE-j-1][i]);
		    }
		    //common parts in canMove helper methods(see canMoveLeft)
		    for(int p = 0; tileSet.size() < GRID_SIZE; p++){
			tileSet.add(0);
		    }
		    for(int n = 1; n < GRID_SIZE; n++){
			if(tileSet.get(n-1) == tileSet.get(n)){
			    tileSet.set(n-1,tileSet.get(n-1)+tileSet.get(n));
			    tileSet.remove(n);
			    tileSet.add(0);
			    score += tileSet.get(n-1);
			}
		    }  
		    //load the updated arrayList back to the board 
		    //(from down to up) 
		    for(int t = 0; t < GRID_SIZE; t++){
			grid[GRID_SIZE-t-1][i] = tileSet.get(t);
		    }
		    mo = true;	
		}
	    }
	}
	return mo;
    }


    // TODO PSA4
    /* Method header comment
     * Name: isGameOver
     * Purpose: This method that checks if the game is over. The game is
     *          over once there are no longer any valid moves left.
     * Parameters: None
     * Return: boolean isGameOver. Return true if the game is over and false
     *         if the game is over.
     */
    public boolean isGameOver() {

	boolean gameOver = true;

	if(this.canMove(Direction.LEFT)==true)
	    return false;  

	else if(this.canMove(Direction.RIGHT)==true)
	    return false;

	else if(this.canMove(Direction.UP)==true)
	    return false; 

	else if(this.canMove(Direction.DOWN)==true)
	    return false; 

	else{
	    System.out.println("Game Over!");
	    return true;
	}
    }


	// TODO PSA4
	/* Method header comment
	 * Name: canMove
	 * Purpose: This method determines if the board can move in the 
	 *          passed in direction.
	 * Parameters: Direction direction. The direction in which the
	 *             board move. 
	 * Return: boolean canMove. If the board can move in the passed 
	 *         in direction, this method will return true. 
	 *         Otherwise it will return false.
	 */
	public boolean canMove(Direction direction) {

	    boolean canm = false;

	    if (direction == Direction.LEFT)
		canm = this.canMoveLeft();

	    else if (direction == Direction.RIGHT)
		canm = this.canMoveRight();

	    else if (direction == Direction.UP)
		canm = this.canMoveUp();

	    else if (direction == Direction.DOWN)
		canm = this.canMoveDown();

	    return canm;
	}

	/* Method header comment (helper method of method canMove())
	 * Name: canMoveLeft
	 * Purpose: This method determines if the board can move left. 
	 * Parameters: None 
	 * Return: boolean canMoveLeft. If the board can move left, 
	 *         it will return true. Otherwise it will return false.
	 */
	private boolean canMoveLeft() {
	    for (int i = 0; i < GRID_SIZE; i++){
		for (int j = 1; j < GRID_SIZE; j++){

		    if(grid[i][j-1]==0 && grid[i][j]!=0)
			return true;

		    if(grid[i][j-1]!=0 && grid[i][j-1]==grid[i][j])
			return true;
		}	
	    }
	    return false;
	}

	/* Method header comment (helper method of method canMove())
	 * Name: canMoveRight
	 * Purpose: This method determines if the board can move right.
	 * Parameters: None 
	 * Return: boolean canMoveRight. If the board can move right, 
	 *         it will return true. Otherwise it will return false.
	 */
	private boolean canMoveRight() {
	    for (int i = 0; i < GRID_SIZE; i++){
		for (int j = GRID_SIZE-1; j > 0; j--) {

		    if(grid[i][j]==0 && grid[i][j-1]!=0)
			return true;

		    if(grid[i][j]!=0 && grid[i][j]==grid[i][j-1])
			return true;
		}
	    }
	    return false;
	}

	/* Method header comment (helper method of method canMove())
	 * Name: canMoveUp
	 * Purpose: This method determines if the board can move up.
	 * Parameters: None 
	 * Return: boolean canMoveUp. If the board can move up, 
	 *         it will return true. Otherwise it will return false.
	 */
	private boolean canMoveUp() {
	    for (int j = 0; j < GRID_SIZE; j++){
		for (int i = 1; i < GRID_SIZE; i++){

		    if(grid[i-1][j]==0 && grid[i][j]!=0)
			return true;

		    if(grid[i-1][j]!=0 && grid[i-1][j]==grid[i][j])
			return true;
		}
	    }
	    return false;
	}

	/* Method header comment (helper method of method canMove())
	 * Name: canMoveDown
	 * Purpose: This method determines if the board can move down.
	 * Parameters: None 
	 * Return: boolean canMoveDown. If the board can move down, 
	 *         it will return true. Otherwise it will return false.
	 */
	private boolean canMoveDown() {
	    for (int j = 0; j < GRID_SIZE; j++){
		for (int i = GRID_SIZE-1; i > 0; i--){

		    if(grid[i][j]==0 && grid[i-1][j]!=0)
			return true;

		    if(grid[i][j]!=0 && grid[i][j]==grid[i-1][j])
			return true;
		}
	    }
	    return false;
	}

	// Return the reference to the 2048 Grid
	public int[][] getGrid() {
	    return grid;
	}

	// Return the score
	public int getScore() {
	    return score;
	}

	@Override
	public String toString() {
	    StringBuilder outputString = new StringBuilder();
	    outputString.append(String.format("Score: %d\n", score));
	    for (int row = 0; row < GRID_SIZE; row++) {
		for (int column = 0; column < GRID_SIZE; column++)
		    outputString.append(grid[row][column] == 0 ? "    -" :
			    String.format("%5d", grid[row][column]));

		outputString.append("\n");
	    }
	    return outputString.toString();
	}
    }
