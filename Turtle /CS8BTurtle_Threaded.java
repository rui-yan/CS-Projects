/* File header comment
 * Name:  Rui Yan
 * Login: cs8bwaka
 * Date:  March 5, 2016
 * File:  CS8BTurtle_Threaded.java
 * Sources of Help: None
 *
 * This program will will create multiple turtles (in separate threads) to 
 * draw the letters and numbers "CS8BWAKA WINTER 2016" in parallel
 */

import turtleClasses.*;
import java.awt.Color;

/*
 * Name:     CSE8BTurtle_Threaded
 * Purpose:  This class will extend Turtle class and implement Runnable 
 *           interface, create multiple turtles (in separate threads) to 
 *           draw the letters and numbers "CS8BWAKA WINTER 2016" in parallel
 */

public class CS8BTurtle_Threaded extends Turtle implements Runnable {
    private final static int CHAR_WIDTH = 40;
    private final static int CHAR_HEIGHT = 80;
    private final static int PADDING_BETWEEN_CHARS = 40;
    private final static int PADDING_BETWEEN_LINES = 40;
    private final static int CHAR_SPACING=CHAR_WIDTH + PADDING_BETWEEN_CHARS;
    private final static int LINE_SPACING=CHAR_HEIGHT + PADDING_BETWEEN_LINES;

    private final static int START_X_1 = 10; // starting x offset for line 1
    private final static int START_X_2 = 10; // starting x offset for line 2
    private final static int START_X_3 = 10; // starting x offset for line 3
    private final static int START_Y = 10;   // starting y offset

    private final static int PEN_WIDTH = 10;
    private final static Color PEN_COLOR = Color.BLUE;

    private final static int WORLD_WIDTH = 800;
    private final static int WORLD_HEIGHT = 500;

    private char ch = ' ';
    private int chX;
    private int chY;

    /*
     * Delay between turtle actions (turns, moves) in milliseconds.
     * 1000 = 1 sec.  so  200 = 0.2 sec.
     */
    private final static int DELAY = 500;

    /* Constructor header comment
     * Name:       CS8BTurtle_Threaded
     * Purpose:    This constructor will create a new CS8BTurtle_Threaded 
     *             and initialize its instance variable to the passed in
     *             parameter
     * Parameters: World w: the drawing canvas;
     *             char ch: the character that will be drawn;
     *             int: x, int y: the x and y coordinate of the 
     *                         top-left corner of the character;
     *             int delay: the time used to draw the character;
     */
    public CS8BTurtle_Threaded(World w, char ch, int x, int y, int delay) {
	super(w, delay);  // Invoke superclass's ctor to create this turtle
	// on World w with delay of each turtle's action.
	this.ch = ch;
	this.chX = x;
	this.chY = y;
	// Set the pen width and color in the constructor
	this.setPenWidth(PEN_WIDTH);
	this.setPenColor(PEN_COLOR);
	new Thread(this).start(); 
    }

    /* Method header comment
     * Name:       run
     * Purpose:    This method will be automatically called from the Thread 
     *             start() method after the Thread begins
     * Parameters: None
     * Return:     void
     */
    public void run() {
	switch(ch) {
	    case 'C': this.drawC(chX, chY); break;
	    case 'S': this.drawS(chX, chY); break;
	    case '8': this.draw8(chX, chY); break;
	    case 'B': this.drawB(chX, chY); break;
	    case 'W': this.drawW(chX, chY); break;
	    case 'A': this.drawA(chX, chY); break;
	    case 'K': this.drawK(chX, chY); break;
	    case 'I': this.drawI(chX, chY); break;
	    case 'N': this.drawN(chX, chY); break;
	    case 'T': this.drawT(chX, chY); break;
	    case 'E': this.drawE(chX, chY); break;
	    case 'R': this.drawR(chX, chY); break;
	    case '2': this.draw2(chX, chY); break;
	    case '0': this.draw0(chX, chY); break;
	    case '1': this.draw1(chX, chY); break;
	    case '6': this.draw6(chX, chY); break;
	}
    }
    /* Method header comment
     * Name:       drawC
     * Purpose:    This method will draw the letter 'C'
     * Parameters: int x, int y: the x and y coordinate of the upper left 
     *             character that will be drawn.
     * Return:     void
     */
    private void drawC(int x, int y) {
	penUp();
	moveTo(x, y);  // always start in upper left corner of this char block
	turnToFace(getXPos() + 1, getYPos()); // face right
	penDown();
	forward(CHAR_WIDTH);
	backward(CHAR_WIDTH);
	turnRight();
	forward(CHAR_HEIGHT);
	turnLeft();
	forward(CHAR_WIDTH);
    }

    /* TODO: Complete this part to draw the 'S' character */
    /* Method header comment
     * Name:       drawS
     * Purpose:    This method will draw the letter 'S'
     * Parameters: int x, int y: the x and y coordinate of the upper left 
     *             character that will be drawn.
     * Return:     void
     */
    private void drawS(int x, int y) {
	penUp();
	moveTo(x, y); // always start in upper left corner of this char block
	turnToFace(getXPos() + 1, getYPos()); // face right
	penDown();
	forward(CHAR_WIDTH);
	backward(CHAR_WIDTH);
	turnRight();
	forward(CHAR_HEIGHT/2);
	turnLeft();
	forward(CHAR_WIDTH);
	turnRight();
	forward(CHAR_HEIGHT/2);
	turnRight();
	forward(CHAR_WIDTH);
    }

    /* Method header comment
     * Name:       draw8
     * Purpose:    This method will draw the letter '8'
     * Parameters: int x, int y: the x and y coordinate of the upper left 
     *             character that will be drawn.
     * Return:     void
     */
    private void draw8(int x, int y) {
	penUp();
	moveTo(x, y); // always start in upper left corner of this char block
	turnToFace(getXPos() + 1, getYPos()); // face right
	penDown();
	forward(CHAR_WIDTH);
	turnRight();
	forward(CHAR_HEIGHT);
	turnRight();
	forward(CHAR_WIDTH);
	turnRight();
	forward(CHAR_HEIGHT/2);
	turnRight();
	forward(CHAR_WIDTH);
	backward(CHAR_WIDTH);
	turnLeft();
	forward(CHAR_HEIGHT/2);
    }

    /* Method header comment
     * Name:       drawB
     * Purpose:    This method will draw the letter 'B'
     * Parameters: int x, int y: the x and y coordinate of the upper left 
     *             character that will be drawn.
     * Return:     void
     */
    private void drawB(int x, int y) {
	penUp();
	moveTo(x, y); // always start in upper left corner of this char block
	turnToFace(getXPos(), getYPos()+1); // face down
	penDown();
	forward(CHAR_HEIGHT);
	backward(CHAR_HEIGHT);
	moveTo(x+CHAR_WIDTH, y+CHAR_HEIGHT/4);
	moveTo(x, y+CHAR_HEIGHT/2);
	moveTo(x+CHAR_WIDTH, y+CHAR_HEIGHT*3/4);
	moveTo(x, y+CHAR_HEIGHT);
    }

    /* Method header comment
     * Name:       drawW
     * Purpose:    This method will draw the letter 'W'
     * Parameters: int x, int y: the x and y coordinate of the upper left 
     *             character that will be drawn.
     * Return:     void
     */
    private void drawW(int x, int y) {
	penUp();
	moveTo(x, y); // always start in upper left corner of this char block
	penDown();
	moveTo(getXPos()+CHAR_WIDTH/6, getYPos()+CHAR_HEIGHT);
	moveTo(x+CHAR_WIDTH*1/2, y+CHAR_HEIGHT*4/5);
	moveTo(x+CHAR_WIDTH*5/6, y+CHAR_HEIGHT);
	moveTo(x+CHAR_WIDTH, y);
    }

    /* Method header comment
     * Name:       drawA
     * Purpose:    This method will draw the letter 'A'
     * Parameters: int x, int y: the x and y coordinate of the upper left 
     *             character that will be drawn.
     * Return:     void
     */
    private void drawA(int x, int y) {
	penUp();
	moveTo(x, y); // always start in upper left corner of this char block
	turnToFace(getXPos() + 1, getYPos()); // face right
	penDown();
	forward(CHAR_WIDTH);
	turnRight();
	forward(CHAR_HEIGHT);
	backward(CHAR_HEIGHT/2);
	turnRight();
	forward(CHAR_WIDTH);
	turnLeft();
	forward(CHAR_HEIGHT/2);
	backward(CHAR_HEIGHT);
    }

    /* Method header comment
     * Name:       drawK
     * Purpose:    This method will draw the letter 'K'
     * Parameters: int x, int y: the x and y coordinate of the upper left 
     *             character that will be drawn.
     * Return:     void
     */
    private void drawK(int x, int y) {
	penUp();
	moveTo(x, y); // always start in upper left corner of this char block
	turnToFace(getXPos(), getYPos() + 1);
	penDown();
	forward(CHAR_HEIGHT);
	backward(CHAR_HEIGHT/2);
	moveTo(x+CHAR_WIDTH, y);
	moveTo(x, y+CHAR_HEIGHT/2);
	moveTo(x+CHAR_WIDTH, y+CHAR_HEIGHT);
    }

    /* Method header comment
     * Name:       drawI
     * Purpose:    This method will draw the letter 'I'
     * Parameters: int x, int y: the x and y coordinate of the upper left 
     *             character that will be drawn.
     * Return:     void
     */
    private void drawI(int x, int y) {
	penUp();
	moveTo(x, y); // always start in upper left corner of this char block
	turnToFace(getXPos() + 1, getYPos());
	penDown();
	forward(CHAR_WIDTH);
	backward(CHAR_WIDTH/2);
	turnRight();
	forward(CHAR_HEIGHT);
	turnRight();
	forward(CHAR_WIDTH/2);
	backward(CHAR_WIDTH);
    }

    /* Method header comment
     * Name:       drawN
     * Purpose:    This method will draw the letter 'N'
     * Parameters: int x, int y: the x and y coordinate of the upper left 
     *             character that will be drawn.
     * Return:     void
     */
    private void drawN(int x, int y) {
	penUp();
	moveTo(x, y); // always start in upper left corner of this char block
	turnToFace(getXPos(), getYPos()+1);
	penDown();
	forward(CHAR_HEIGHT);
	backward(CHAR_HEIGHT);
	moveTo(x+CHAR_WIDTH, y+CHAR_HEIGHT);
	moveTo(x+CHAR_WIDTH, y);
    }

    /* Method header comment
     * Name:       drawT
     * Purpose:    This method will draw the letter 'T'
     * Parameters: int x, int y: the x and y coordinate of the upper left 
     *             character that will be drawn.
     * Return:     void
     */
    private void drawT(int x, int y) {
	penUp();
	moveTo(x, y); // always start in upper left corner of this char block
	turnToFace(getXPos()+1, getYPos());
	penDown();
	forward(CHAR_WIDTH);
	backward(CHAR_WIDTH/2);
	turnRight();
	forward(CHAR_HEIGHT);
    }

    /* Method header comment
     * Name:       drawE
     * Purpose:    This method will draw the letter 'E'
     * Parameters: int x, int y: the x and y coordinate of the upper left 
     *             character that will be drawn.
     * Return:     void
     */
    private void drawE(int x, int y) {
	penUp();
	moveTo(x, y); // always start in upper left corner of this char block
	turnToFace(getXPos()+1, getYPos());
	penDown();
	forward(CHAR_WIDTH);
	backward(CHAR_WIDTH);
	turnRight();
	forward(CHAR_HEIGHT/2);
	turnLeft();
	forward(CHAR_WIDTH);
	backward(CHAR_WIDTH);
	turnRight();
	forward(CHAR_HEIGHT/2);
	turnLeft();
	forward(CHAR_WIDTH);
    }

    /* Method header comment
     * Name:       drawR
     * Purpose:    This method will draw the letter 'R'
     * Parameters: int x, int y: the x and y coordinate of the upper left 
     *             character that will be drawn.
     * Return:     void
     */
    private void drawR(int x, int y) {
	penUp();
	moveTo(x, y); 
	turnToFace(getXPos()+1, getYPos());
	penDown();
	forward(CHAR_WIDTH);
	turnRight();
	forward(CHAR_HEIGHT/2);
	turnRight();
	forward(CHAR_WIDTH);
	turnRight();
	forward(CHAR_HEIGHT/2);
	backward(CHAR_HEIGHT);
	forward(CHAR_HEIGHT/2);
	moveTo(x+CHAR_WIDTH, y+CHAR_HEIGHT);
    }

    /* Method header comment
     * Name:       draw2
     * Purpose:    This method will draw the letter '2'
     * Parameters: int x, int y: the x and y coordinate of the upper left 
     *             character that will be drawn.
     * Return:     void
     */
    private void draw2(int x, int y) {
	penUp();
	moveTo(x, y); 
	turnToFace(getXPos()+1, getYPos());
	penDown();
	forward(CHAR_WIDTH);
	turnRight();
	forward(CHAR_HEIGHT/2);
	turnRight();
	forward(CHAR_WIDTH);
	turnLeft();
	forward(CHAR_HEIGHT/2);
	turnLeft();
	forward(CHAR_WIDTH);
    }

    /* Method header comment
     * Name:       draw0
     * Purpose:    This method will draw the letter '0'
     * Parameters: int x, int y: the x and y coordinate of the upper left 
     *             character that will be drawn.
     * Return:     void
     */
    private void draw0(int x, int y) {
	penUp();
	moveTo(x, y); 
	turnToFace(getXPos()+1, getYPos());
	penDown();
	forward(CHAR_WIDTH);
	turnRight();
	forward(CHAR_HEIGHT);
	turnRight();
	forward(CHAR_WIDTH);
	turnRight();
	forward(CHAR_HEIGHT);
    }

    /* Method header comment
     * Name:       draw1
     * Purpose:    This method will draw the letter '1'
     * Parameters: int x, int y: the x and y coordinate of the upper left 
     *             character that will be drawn.
     * Return:     void
     */
    private void draw1(int x, int y) {
	penUp();
	moveTo(x, y);
	turnToFace(getXPos()+1, getYPos());
	forward(CHAR_WIDTH/2); 
	turnToFace(getXPos()+CHAR_WIDTH/2, getYPos()+1);
	turn(120); 
	penDown();
	forward(CHAR_WIDTH/2);
	backward(CHAR_WIDTH/2);
	turnToFace(x + CHAR_WIDTH/2, y + 1);
	forward(CHAR_HEIGHT);
	turnRight();
	forward(CHAR_WIDTH/2);
	backward(CHAR_WIDTH);
    }

    /* Method header comment
     * Name:       draw6
     * Purpose:    This method will draw the letter '6'
     * Parameters: int x, int y: the x and y coordinate of the upper left 
     *             character that will be drawn.
     * Return:     void
     */
    private void draw6(int x, int y) {
	penUp();
	moveTo(x, y); 
	turnToFace(getXPos()+1, getYPos());
	penDown();
	forward(CHAR_WIDTH);
	backward(CHAR_WIDTH);
	turnRight();
	forward(CHAR_HEIGHT);
	backward(CHAR_HEIGHT/2);
	turnLeft();
	forward(CHAR_WIDTH);
	turnRight();
	forward(CHAR_HEIGHT/2);
	turnRight();
	forward(CHAR_WIDTH);
    }

    /* Method header comment
     * Name:       main
     * Purpose:    This method will create a new CS8BTurtle_Threaded object 
     *             (a new turtle drawing a character in a separate thread) 
     *             for each letter or number that needs to be drawn, so they 
     *             can all execute simultaneously in parallel.
     * Parameters: String [] args
     * Return:     void
     */
    public static void main(String [] args) {

	int startX1 = (WORLD_WIDTH - 8*CHAR_SPACING + PADDING_BETWEEN_CHARS)/2;  
	// starting x offset for line 1
	int startX2 = (WORLD_WIDTH - 6*CHAR_SPACING + PADDING_BETWEEN_CHARS)/2;
	// starting x offset for line 2
	int startX3 = (WORLD_WIDTH - 4*CHAR_SPACING + PADDING_BETWEEN_CHARS)/2;  
	// starting x offset for line 3
	int startY = (WORLD_HEIGHT - 3*LINE_SPACING + PADDING_BETWEEN_LINES)/2;    
	// starting y offset
	int x, y;

	World w = new World(WORLD_WIDTH, WORLD_HEIGHT);

	CS8BTurtle_Threaded turtle1 =
	    new CS8BTurtle_Threaded( w, 'C', x = startX1, y = startY, DELAY);
	CS8BTurtle_Threaded turtle2 = 
	    new CS8BTurtle_Threaded( w, 'S', x += CHAR_SPACING, y, DELAY);
	CS8BTurtle_Threaded turtle3 =
	    new CS8BTurtle_Threaded( w, '8', x += CHAR_SPACING, y, DELAY);
	CS8BTurtle_Threaded turtle4 =
	    new CS8BTurtle_Threaded( w, 'B', x += CHAR_SPACING, y, DELAY);
	CS8BTurtle_Threaded turtle5 =
	    new CS8BTurtle_Threaded( w, 'W', x += CHAR_SPACING, y, DELAY);
	CS8BTurtle_Threaded turtle6 =
	    new CS8BTurtle_Threaded( w, 'A', x += CHAR_SPACING, y, DELAY);
	CS8BTurtle_Threaded turtle7 =
	    new CS8BTurtle_Threaded( w, 'K', x += CHAR_SPACING, y, DELAY);
	CS8BTurtle_Threaded turtle8 =
	    new CS8BTurtle_Threaded( w, 'A', x += CHAR_SPACING, y, DELAY);
	CS8BTurtle_Threaded turtle9 =
	    new CS8BTurtle_Threaded
	    ( w, 'W', x = startX2, y += LINE_SPACING, DELAY);
	CS8BTurtle_Threaded turtle10 =
	    new CS8BTurtle_Threaded( w, 'I', x += CHAR_SPACING, y, DELAY);
	CS8BTurtle_Threaded turtle11 =
	    new CS8BTurtle_Threaded( w, 'N', x += CHAR_SPACING, y, DELAY);
	CS8BTurtle_Threaded turtle12 =
	    new CS8BTurtle_Threaded( w, 'T', x += CHAR_SPACING, y, DELAY);
	CS8BTurtle_Threaded turtle13 =
	    new CS8BTurtle_Threaded( w, 'E', x += CHAR_SPACING, y, DELAY);
	CS8BTurtle_Threaded turtle14 =
	    new CS8BTurtle_Threaded( w, 'R', x += CHAR_SPACING, y, DELAY);
	CS8BTurtle_Threaded turtle15 =
	    new CS8BTurtle_Threaded
	    ( w, '2', x = startX3, y += LINE_SPACING, DELAY);
	CS8BTurtle_Threaded turtle16 =
	    new CS8BTurtle_Threaded( w, '0', x += CHAR_SPACING, y, DELAY);
	CS8BTurtle_Threaded turtle17 =
	    new CS8BTurtle_Threaded( w, '1', x += CHAR_SPACING, y, DELAY);
	CS8BTurtle_Threaded turtle18 =
	    new CS8BTurtle_Threaded( w, '6', x += CHAR_SPACING, y, DELAY);
    }

}  // End of public class CS8BTurtle_Threaded extends Turtle


