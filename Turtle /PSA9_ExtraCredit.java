/* File header comment
 * Name:  Rui Yan
 * Login: cs8bwaka
 * Date:  March 5, 2016
 * File:  PSA9_ExtraCredit.java
 * Sources of Help: None
 *
 * This program will will create 20 turtles (in separate threads) to 
 * draw "JAVA" and its reflection along horizontal axis and "THREAD" and 
 * its reflection along horizontal axis; also, it will draw a dog head.
 */

import turtleClasses.*;
import java.awt.Color;

/*
 * Name:     PSA9_ExtraCredit
 * Purpose:  This class will extend Turtle class and implement Runnable 
 *           interface, create multiple turtles (in separate threads) to 
 *           draw the letters and numbers  in parallel
 */

public class PSA9_ExtraCredit extends Turtle implements Runnable {
    private final static int CHAR_WIDTH = 40;
    private final static int CHAR_HEIGHT = 80;
    private final static int DOG_WIDTH = 60;
    private final static int DOG_HEIGHT = 80;
    private final static int EAR_HEIGHT = 10;
    private final static int PADDING_BETWEEN_CHARS = 40;
    private final static int PADDING_BETWEEN_LINES = 40;
    private final static int CHAR_SPACING=CHAR_WIDTH + PADDING_BETWEEN_CHARS;
    private final static int LINE_SPACING=CHAR_HEIGHT + PADDING_BETWEEN_LINES;

    private final static int START_X_1 = 10; // starting x offset for line 1
    private final static int START_X_2 = 10; // starting x offset for line 2
    private final static int START_X_3 = 10; // starting x offset for line 3
    private final static int START_Y = 10;   // starting y offset

    private final static int PEN_WIDTH1 = 10;
    private final static int PEN_WIDTH2 = 2;
    private final static Color PEN_COLOR1 = Color.BLUE;
    private final static Color PEN_COLOR2 = Color.RED;
    private final static Color PEN_COLOR3 = Color.orange;

    private final static int WORLD_WIDTH = 800;
    private final static int WORLD_HEIGHT = 500;

    private char ch = ' ';
    private int chX;
    private int chY;
    private boolean reflect;
    /*
     * Delay between turtle actions (turns, moves) in milliseconds.
     * 1000 = 1 sec.  so  200 = 0.2 sec.
     */
    private final static int DELAY1 = 500;
    private final static int DELAY2 = 150;

    /* Constructor header comment
     * Name:       PSA9_ExtraCredit
     * Purpose:    This constructor will create a new turtle 
     *             and initialize its instance variable to the passed in
     *             parameter
     * Parameters: World w: the drawing canvas;
     *             boolean reflect: determine if the drawn character 
     *                         should be reflected
     *             char ch: the character that will be drawn;
     *             int: x, int y: the x and y coordinate of the 
     *                         top-left corner of the character;
     *             int delay: the time used to draw the character;
     */
    public PSA9_ExtraCredit(World w, char ch, boolean reflect, 
	    int x, int y, int delay) {
	super(w, delay);  
	// Invoke superclass's ctor to create this turtle
	// on World w with delay of each turtle's action.
	this.ch = ch;
	this.chX = x;
	this.chY = y;
	this.reflect = reflect;
	// Set the pen width and color in the constructor
	this.setPenWidth(PEN_WIDTH1);
	if(reflect == false)
	    this.setPenColor(PEN_COLOR1);
	else
	    this.setPenColor(PEN_COLOR2);

	new Thread(this).start(); 
    }

    /* Constructor header comment
     * Name:       PSA9_ExtraCredit
     * Purpose:    This constructor will create a new turtle 
     *             and initialize its instance variable to the passed in
     *             parameter
     * Parameters: World w: the drawing canvas;
     *             int delay: the time used to draw the character;
     */
    public PSA9_ExtraCredit(World w, int delay) {
	super(w, delay);  // Invoke superclass's ctor to create this turtle
	// on World w with delay of each turtle's action
	// Set the pen width and color in the constructor
	this.setPenWidth(PEN_WIDTH2);
	this.setPenColor(PEN_COLOR3);
    }

    /* Method header comment
     * Name:       run
     * Purpose:    This method will be automatically called from the Thread 
     *             start() method after the Thread begins. It draws the letter
     *             based on the passed in char ch and boolean reflect.
     * Parameters: None
     * Return:     void
     */
    public void run() {
	if(reflect == false){
	    if(ch == 'J')
		this.drawJ(chX, chY);
	    else if(ch == 'V')
		this.drawV(chX, chY); 
	    else if(ch == 'A')
		this.drawA(chX, chY);
	    else if(ch == 'T')
		this.drawT(chX, chY);
	    else if(ch == 'H')
		this.drawH(chX, chY);
	    else if(ch == 'R')
		this.drawR(chX, chY);
	    else if(ch == 'E')
		this.drawE(chX, chY); 
	    else if(ch == 'D')
		this.drawD(chX, chY);
	}

	else{
	    if(ch == 'J')
		this.drawJR(chX, chY);
	    else if(ch == 'V')
		this.drawVR(chX, chY);
	    else if(ch == 'A')
		this.drawAR(chX, chY);
	    else if(ch == 'T') 
		this.drawTR(chX, chY); 
	    else if(ch == 'H')
		this.drawHR(chX, chY);
	    else if(ch == 'R')
		this.drawRR(chX, chY);
	    else if(ch == 'E')
		this.drawER(chX, chY); 
	    else if(ch == 'D')
		this.drawDR(chX, chY);
	}
    }

    /* Method header comment
     * Name:       drawJ
     * Purpose:    This method will draw the letter 'J'
     * Parameters: int x, int y: the x and y coordinate of the upper left 
     *             character that will be drawn.
     * Return:     void
     */
    private void drawJ(int x, int y) {
	penUp();
	moveTo(x, y);  // always start in upper left corner of this char block
	turnToFace(getXPos() + 1, getYPos()); // face right
	penDown();
	forward(CHAR_WIDTH);
	backward(CHAR_WIDTH/2);
	turnRight();
	forward(CHAR_HEIGHT);
	turnRight();
	forward(CHAR_WIDTH/2);
    }

    /* Method header comment
     * Name:       drawJR
     * Purpose:    This method will draw the letter 'J' reversely
     * Parameters: int x, int y: the x and y coordinate of the upper left 
     *             character that will be drawn.
     * Return:     void
     */
    private void drawJR(int x, int y) {
	penUp();
	moveTo(x, y); // always start in upper left corner of this char block
	turnToFace(getXPos() + 1, getYPos()); // face right
	penDown();
	forward(CHAR_WIDTH/2);
	turnRight();
	forward(CHAR_HEIGHT);
	turnRight();
	forward(CHAR_WIDTH/2);
	backward(CHAR_WIDTH);
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
     * Name:       drawAR
     * Purpose:    This method will draw the letter 'A' reversely
     * Parameters: int x, int y: the x and y coordinate of the upper left 
     *             character that will be drawn.
     * Return:     void
     */
    private void drawAR(int x, int y) {
	penUp();
	moveTo(x, y); 
	turnToFace(getXPos(), getYPos()+1); // face right
	penDown();
	forward(CHAR_HEIGHT);
	turnLeft();
	forward(CHAR_WIDTH);
	turnLeft();
	forward(CHAR_HEIGHT/2);
	turnLeft();
	forward(CHAR_WIDTH);
	backward(CHAR_WIDTH);
	turnRight();
	forward(CHAR_HEIGHT/2);
    }

    /* Method header comment
     * Name:       drawV
     * Purpose:    This method will draw the letter 'V'
     * Parameters: int x, int y: the x and y coordinate of the upper left 
     *             character that will be drawn.
     * Return:     void
     */
    private void drawV(int x, int y) {
	penUp();
	moveTo(x, y); 
	penDown();
	moveTo(x+CHAR_WIDTH/2, y+CHAR_HEIGHT);
	moveTo(x+CHAR_WIDTH, y);
    }

    /* Method header comment
     * Name:       drawVR
     * Purpose:    This method will draw the letter 'V' reversly
     * Parameters: int x, int y: the x and y coordinate of the upper left 
     *             character that will be drawn.
     * Return:     void
     */
    private void drawVR(int x, int y) {
	penUp();
	moveTo(x, y); // always start in upper left corner of this char block
	moveTo(x+CHAR_WIDTH/2, y);
	penDown();
	moveTo(x, y+CHAR_HEIGHT);
	moveTo(x+CHAR_WIDTH/2, y);
	moveTo(x+CHAR_WIDTH, y + CHAR_HEIGHT);
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
     * Name:       drawTR
     * Purpose:    This method will draw the letter 'T' reversely
     * Parameters: int x, int y: the x and y coordinate of the upper left 
     *             character that will be drawn.
     * Return:     void
     */
    private void drawTR(int x, int y) {
	penUp();
	moveTo(x, y); // always start in upper left corner of this char block
	turnToFace(getXPos() + 1, getYPos());
	forward(CHAR_WIDTH/2);
	turnRight();
	penDown();
	forward(CHAR_HEIGHT);
	turnRight();
	forward(CHAR_WIDTH/2);
	backward(CHAR_WIDTH);
    }

    /* Method header comment
     * Name:       drawH
     * Purpose:    This method will draw the letter 'H'
     * Parameters: int x, int y: the x and y coordinate of the upper left 
     *             character that will be drawn.
     * Return:     void
     */
    private void drawH(int x, int y) {
	penUp();
	moveTo(x, y); // always start in upper left corner of this char block
	turnToFace(getXPos(), getYPos()+1);
	penDown();
	forward(CHAR_HEIGHT);
	backward(CHAR_HEIGHT/2);
	turnLeft();
	forward(CHAR_WIDTH);
	turnLeft();
	forward(CHAR_HEIGHT/2);
	backward(CHAR_HEIGHT);
    }

    /* Method header comment
     * Name:       drawHR
     * Purpose:    This method will draw the letter 'H' reversely
     * Parameters: int x, int y: the x and y coordinate of the upper left 
     *             character that will be drawn.
     * Return:     void
     */
    private void drawHR(int x, int y) {
	penUp();
	moveTo(x, y); // always start in upper left corner of this char block
	turnToFace(getXPos(), getYPos()+1);
	penDown();
	forward(CHAR_HEIGHT);
	backward(CHAR_HEIGHT/2);
	turnLeft();
	forward(CHAR_WIDTH);
	turnLeft();
	forward(CHAR_HEIGHT/2);
	backward(CHAR_HEIGHT);
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
     * Name:       drawRR
     * Purpose:    This method will draw the letter 'R' reversely
     * Parameters: int x, int y: the x and y coordinate of the upper left 
     *             character that will be drawn.
     * Return:     void
     */
    private void drawRR(int x, int y) {
	penUp();
	moveTo(x, y); 
	turnToFace(getXPos(), getYPos()+1);
	penDown();
	forward(CHAR_HEIGHT);
	turnLeft();
	forward(CHAR_WIDTH);
	turnLeft();
	forward(CHAR_HEIGHT/2);
	turnLeft();
	forward(CHAR_WIDTH);
	moveTo(x+CHAR_WIDTH, y);
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
     * Name:       drawER
     * Purpose:    This method will draw the letter 'E'reversely
     * Parameters: int x, int y: the x and y coordinate of the upper left 
     *             character that will be drawn.
     * Return:     void
     */
    private void drawER(int x, int y) {
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
     * Name:       drawD
     * Purpose:    This method will draw the letter 'D'
     * Parameters: int x, int y: the x and y coordinate of the upper left 
     *             character that will be drawn.
     * Return:     void
     */
    private void drawD(int x, int y) {
	penUp();
	moveTo(x, y); 
	turnToFace(getXPos()+1, getYPos());
	penDown();
	forward(CHAR_WIDTH*5/6);
	moveTo(x+CHAR_WIDTH, y+CHAR_HEIGHT/6); 
	moveTo(x+CHAR_WIDTH, y+CHAR_HEIGHT*5/6);
	moveTo(x+CHAR_WIDTH*5/6, y+CHAR_HEIGHT);
	moveTo(x, y+CHAR_HEIGHT);
	moveTo(x, y);
    }

    /* Method header comment
     * Name:       drawDR
     * Purpose:    This method will draw the letter 'D' reversely
     * Parameters: int x, int y: the x and y coordinate of the upper left 
     *             character that will be drawn.
     * Return:     void
     */
    private void drawDR(int x, int y) {
	penUp();
	moveTo(x, y); 
	turnToFace(getXPos()+1, getYPos());
	penDown();
	forward(CHAR_WIDTH*5/6);
	moveTo(x+CHAR_WIDTH, y+CHAR_HEIGHT/6); 
	moveTo(x+CHAR_WIDTH, y+CHAR_HEIGHT*5/6);
	moveTo(x+CHAR_WIDTH*5/6, y+CHAR_HEIGHT);
	moveTo(x, y+CHAR_HEIGHT);
	moveTo(x, y);
    }

    /* Method header comment
     * Name:       drawDog
     * Purpose:    This method will draw a cartoon dog
     * Parameters: int x, int y: the x and y coordinate of the upper left 
     *             character that will be drawn.
     * Return:     void
     */
    private void drawDog(int x, int y) {
	// Draw head
	penUp();
	moveTo(x, y); 
	turnToFace(getXPos(), getYPos()+1);
	penDown();
	forward(DOG_HEIGHT);
	turnLeft();
	forward(DOG_WIDTH);
	turnLeft();
	forward(DOG_HEIGHT);
	moveTo(x+DOG_WIDTH-EAR_HEIGHT, y+EAR_HEIGHT); 
	moveTo(x+DOG_WIDTH, y+2*EAR_HEIGHT);
	moveTo(x+DOG_WIDTH-EAR_HEIGHT, y+EAR_HEIGHT);
	moveTo(x+EAR_HEIGHT, y+EAR_HEIGHT);
	moveTo(x, y);
	moveTo(x+EAR_HEIGHT, y+EAR_HEIGHT);
	moveTo(x, y+2*EAR_HEIGHT);
	// Draw left eye
	penUp();
	moveTo(x+DOG_WIDTH/6, y+DOG_HEIGHT*3/8);
	turnToFace(x+DOG_WIDTH/6+1, y+DOG_HEIGHT*3/8);
	penDown();
	forward(DOG_WIDTH/6);
	turnRight();
	forward(DOG_WIDTH/6);
	turnRight();
	forward(DOG_WIDTH/6);
	turnRight();
	forward(DOG_WIDTH/6);
	// Draw right eye
	penUp();
	moveTo(x+DOG_WIDTH*2/3, y+DOG_HEIGHT*3/8);
	turnToFace(x+DOG_WIDTH*2/3+1, y+DOG_HEIGHT*3/8);
	penDown();
	forward(DOG_WIDTH/6);
	turnRight();
	forward(DOG_WIDTH/6);
	turnRight();
	forward(DOG_WIDTH/6);
	turnRight();
	forward(DOG_WIDTH/6);
	// Draw mouth
	penUp();
	moveTo(x+DOG_WIDTH/2, y+DOG_HEIGHT/2);
	turnToFace(x+DOG_WIDTH/2, y+DOG_HEIGHT/2+1);
	penDown();
	forward(DOG_WIDTH/6);
	turn(45);
	forward(DOG_WIDTH/6);
	backward(DOG_WIDTH/6);
	turn(270);
	forward(DOG_WIDTH/6);
	hide();
    }

    /* Method header comment
     * Name:       main
     * Purpose:    This method will create a new PSA9_ExtraCredit object 
     *             (a new turtle drawing a character in a separate thread) 
     *             for each letter or number that needs to be drawn, so they 
     *             can all execute simultaneously in parallel.
     * Parameters: String [] args
     * Return:     void
     */
    public static void main(String [] args) {

	int startX1 = (WORLD_WIDTH - 6*CHAR_SPACING + PADDING_BETWEEN_CHARS)/2; 
	// starting x offset for line 1
	int startX2 = (WORLD_WIDTH - 6*CHAR_SPACING + PADDING_BETWEEN_CHARS)/2;
	// starting x offset for line 2
	int startX3 = (WORLD_WIDTH - 8*CHAR_SPACING + PADDING_BETWEEN_CHARS)/2; 
	// starting x offset for line 3
	int startX4 = (WORLD_WIDTH - 8*CHAR_SPACING + PADDING_BETWEEN_CHARS)/2;
	// starting x offset for line 4
	int startY = (WORLD_HEIGHT - 4*LINE_SPACING + PADDING_BETWEEN_LINES)/2;    
	// starting y offset
	int x, y;

	World w = new World(WORLD_WIDTH, WORLD_HEIGHT);
	// Draw "JAVA" and "THREAD" and their reflection 
	PSA9_ExtraCredit turtle1 =
	    new PSA9_ExtraCredit
	    ( w, 'J', false, x= startX1, y = startY, DELAY1);
	PSA9_ExtraCredit turtle2 = 
	    new PSA9_ExtraCredit( w, 'A', false, x+=CHAR_SPACING, y, DELAY1);
	PSA9_ExtraCredit turtle3 =
	    new PSA9_ExtraCredit( w, 'V', false, x+=CHAR_SPACING, y, DELAY1);
	PSA9_ExtraCredit turtle4 =
	    new PSA9_ExtraCredit( w, 'A', false, x+=CHAR_SPACING, y, DELAY1);
	PSA9_ExtraCredit turtle5 =
	    new PSA9_ExtraCredit
	    ( w, 'J', true, x= startX2, y += LINE_SPACING, DELAY1);
	PSA9_ExtraCredit turtle6 =
	    new PSA9_ExtraCredit( w, 'A', true, x+=CHAR_SPACING, y, DELAY1);
	PSA9_ExtraCredit turtle7 =
	    new PSA9_ExtraCredit( w, 'V', true, x+=CHAR_SPACING, y, DELAY1);
	PSA9_ExtraCredit turtle8 =
	    new PSA9_ExtraCredit( w, 'A', true, x+=CHAR_SPACING, y, DELAY1);
	PSA9_ExtraCredit turtle9 = 
	    new PSA9_ExtraCredit
	    ( w, 'T', false, x= startX3, y += LINE_SPACING, DELAY1);
	PSA9_ExtraCredit turtle10 =
	    new PSA9_ExtraCredit( w, 'H', false, x+=CHAR_SPACING, y, DELAY1);
	PSA9_ExtraCredit turtle11 =
	    new PSA9_ExtraCredit( w, 'R', false, x+=CHAR_SPACING, y, DELAY1);
	PSA9_ExtraCredit turtle12 =
	    new PSA9_ExtraCredit( w, 'E', false, x+=CHAR_SPACING, y, DELAY1);
	PSA9_ExtraCredit turtle13 =
	    new PSA9_ExtraCredit( w, 'A', false, x+=CHAR_SPACING, y, DELAY1);
	PSA9_ExtraCredit turtle14 =
	    new PSA9_ExtraCredit( w, 'D', false, x+=CHAR_SPACING, y, DELAY1);
	PSA9_ExtraCredit turtle15 =
	    new PSA9_ExtraCredit
	    ( w, 'T', true, x= startX4, y += LINE_SPACING, DELAY1);
	PSA9_ExtraCredit turtle16 =
	    new PSA9_ExtraCredit( w, 'H', true, x+=CHAR_SPACING, y, DELAY1);
	PSA9_ExtraCredit turtle17 =
	    new PSA9_ExtraCredit( w, 'R', true, x+=CHAR_SPACING, y, DELAY1);
	PSA9_ExtraCredit turtle18 =
	    new PSA9_ExtraCredit( w, 'E', true, x+=CHAR_SPACING, y, DELAY1);
	PSA9_ExtraCredit turtle19 =
	    new PSA9_ExtraCredit( w, 'A', true, x+=CHAR_SPACING, y, DELAY1);
	PSA9_ExtraCredit turtle20 =
	    new PSA9_ExtraCredit( w, 'D', true, x+=CHAR_SPACING, y, DELAY1);

	// Draw creative picture(a dog head)
	PSA9_ExtraCredit turtle21 = new PSA9_ExtraCredit(w, DELAY2);
	turtle21.drawDog(x+=CHAR_SPACING, y);

    }  // End of public class PSA9_ExtraCredit extends Turtle
}

