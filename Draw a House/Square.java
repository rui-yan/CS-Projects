/* File header comment
 * Name: Rui Yan
 * Login: cs8bwaka 
 * Date: Februry 23, 2016
 * file: Square.java 
 * Sources of Help: None  
 * 
 * This program will create several ctors and override some methods
 * in Square class which is the subclass of ARectangle class. 
 *
 */
import java.awt.*;
import objectdraw.*;

/* Class header comment
 * Name: Square
 * Purpose: This class will overload several ctors of Square class that takes
 *          different parameters and override several methods from superclass 
 *          ARectangle. Those methods are Draw() and equals(). 
 *          In addition, it will implement setter and getter to set and get 
 *          the side of the square.
 */        
public class Square extends ARectangle {
    private int side;

    // Constructors
    public Square() {
	// TODO
	super("Square", 0, 0);
	// call the ctor in super class to set the name and upperleft point
	this.setSide(0);
    }

    public Square(int x, int y, int side) {
	// TODO
	super("Square", x, y);
	this.setSide(side);
    }

    public Square(Point upperLeft, int side) {
	// TODO
	super("Square", upperLeft);
	this.setSide(side);
    }

    public Square(Square square) {
	// TODO
	super(square);
	this.setSide(square.getSide());
    }

    // Getter
    public int getSide() {
	return this.side;
    }

    // Setter
    private void setSide(int side) {
	this.side = side;
    }

    /* Method header comment
     * Name: toString
     * Purpose: This method will print out the strings that describe the
     *          square (the coordinate of upperleft point and its side).
     * Parameter: None
     * Return: void
     */
    @Override
    public String toString() {
	// TODO
	return super.toString() + " Sides: " + this.getSide();
    }

    /* Method header comment
     * Name: equals
     * Purpose: This method will test if the copy ctors do the deep copy
     * Parameter: Object o, the copied object 
     * Return: boolean; return true if it is deep copy; otherwise false
     */
    @Override
    public boolean equals(Object o) {
	// TODO
	if(o == null)
		return false;
	if(o instanceof Square){
	    //test if they have the same side and whether their upperleft
	    //points point to the same reference
	    return super.equals((Square)o) &&
		this.getSide() == ((Square)o).getSide();
	}
	return false;
    }

    /* Method header comment
     * Name: draw
     * Purpose: This method will create the appropriate objectdraw library
     *          object to draw on the canvas parameter.
     * Parameter: DrawingCanvas canvas: the canvas object that will be drawed;
     *            Color c: the color of the graphical object, if c is null,
     *            use Color.BLACK;
     *            boolean fill: determine whether the graphical object should 
     *            be filled or not.
     * Return: void
     */
    public void draw(DrawingCanvas canvas, Color c, boolean fill) {
	// TODO
	if(canvas == null)
		return;
	// If c is null, use Color.BLACK
	if(c == null)
	    c = Color.BLACK;
	if(fill == true){
	    // Create filledrect to draw the triangle if fill is true
	    FilledRect mySquare = new FilledRect(
		    this.getUpperLeft().getX(), 
		    this.getUpperLeft().getY(), 
		    this.getSide(), 
		    this.getSide(), canvas);
	    mySquare.setColor(c);
	}
	else{
	    FramedRect mySqr = new FramedRect
		(this.getUpperLeft().getX(), 
		 this.getUpperLeft().getY(), 
		 this.getSide(), 
		 this.getSide(), canvas);
	    mySqr.setColor(c);
	}
    }
}
