/* File header comment
 * Name:  Rui Yan
 * Login: cs8bwaka
 * Date:  March 5, 2016
 * File:  CS8BTurtle.java
 * Sources of Help: None
 *
 * This program will create a turtle to draw the text "CS8BWAKA WINTER 2016"
 */

import turtleClasses.*;
import java.awt.Color;

/*
 * Name:     CSE8BTurtle
 * Purpose:  This class will create a turtle to draw the text 
 *           "CS8BWAKA WINTER 2016"
 */

public class CS8BTurtle extends Turtle {
    private final static int CHAR_WIDTH = 40;
    private final static int CHAR_HEIGHT = 80;
    private final static int PADDING_BETWEEN_CHARS = 40;
    private final static int PADDING_BETWEEN_LINES = 40;
    private final static int CHAR_SPACING = CHAR_WIDTH + PADDING_BETWEEN_CHARS;
    private final static int LINE_SPACING = CHAR_HEIGHT + PADDING_BETWEEN_LINES;

    private final static int START_X_1 = 10; // starting x offset for line 1
    private final static int START_X_2 = 10; // starting x offset for line 2
    private final static int START_X_3 = 10; // starting x offset for line 3
    private final static int START_Y = 10;   // starting y offset

    private final static int PEN_WIDTH = 10;
    private final static Color PEN_COLOR = Color.BLUE;

    private final static int WORLD_WIDTH = 800;
    private final static int WORLD_HEIGHT = 500;

    /*
     * Delay between turtle actions (turns, moves) in milliseconds.
     * 1000 = 1 sec.  so  200 = 0.2 sec.
     */
    private final static int DELAY = 500;


    /* Constructor header comment
     * Name:       CS8BTurtle
     * Purpose:    This constructor will create a new CS8BTurtle
     * Parameters: World w: the drawing canvas;
     *             int delay: the time used to draw the character;
     */
    public CS8BTurtle(World w, int delay) {
	super(w, delay);  // Invoke superclass's ctor to create this turtle
    }                     // on World w with delay of each turtle's action.

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
	turnToFace(getXPos(), getYPos()+1); // face right
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
     * Purpose:    This method will create a new CS8BTurtle object to
     *             draw each letter and number one by one.
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
	CS8BTurtle myTurtle = new CS8BTurtle(w, DELAY);

	// Set the pen width and color in the constructor
	myTurtle.setPenWidth(PEN_WIDTH);
	myTurtle.setPenColor(PEN_COLOR);

	myTurtle.drawC(x = startX1, y = startY);
	myTurtle.drawS(x += CHAR_SPACING, y);

	/* TODO: Complete this main method to draw the remaining text */
	myTurtle.draw8(x += CHAR_SPACING, y);
	myTurtle.drawB(x += CHAR_SPACING, y);
	myTurtle.drawW(x += CHAR_SPACING, y);
	myTurtle.drawA(x += CHAR_SPACING, y);
	myTurtle.drawK(x += CHAR_SPACING, y);
	myTurtle.drawA(x += CHAR_SPACING, y);
	myTurtle.drawW(x = startX2, y += LINE_SPACING);
	myTurtle.drawI(x += CHAR_SPACING, y);
	myTurtle.drawN(x += CHAR_SPACING, y);
	myTurtle.drawT(x += CHAR_SPACING, y);
	myTurtle.drawE(x += CHAR_SPACING, y);
	myTurtle.drawR(x += CHAR_SPACING, y);
	myTurtle.draw2(x = startX3, y += LINE_SPACING);
	myTurtle.draw0(x += CHAR_SPACING, y);
	myTurtle.draw1(x += CHAR_SPACING, y);
	myTurtle.draw6(x += CHAR_SPACING, y);
    }

}  // End of public class CS8BTurtle extends Turtle


