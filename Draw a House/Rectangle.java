/* File header comment
 * Name: Rui Yan
 * Login: cs8bwaka 
 * Date: Februry 23, 2016
 * file: Rectangle.java 
 * Sources of Help: None  
 * 
 * This program will create several ctors and override some methods
 * in Rectangle class which is the subclass of ARectangle class. 
 *
 */

import java.awt.*;
import objectdraw.*;

/* Class header comment
 * Name: Square
 * Purpose: This class will overload several ctors of Rectangle class that takes
 *          different parameters and override several methods from superclass 
 *          ARectangle. Those methods are Draw() and equals(). 
 *          In addition, it will implement setter and getter to set and get 
 *          the width and height of the rectangle.
 */        
public class Rectangle extends ARectangle {
    private int width;
    private int height;

    // Constructors
    public Rectangle() {
	// TODO
	super("Rectangle", 0, 0); 
	// call the ctor in super class to set the name and upperleft point
	this.setWidth(0);
	this.setHeight(0);
    }

    public Rectangle(int x, int y, int width, int height) {
	// TODO
	super("Rectangle", x, y);
	this.setWidth(width);
	this.setHeight(height);
    }

    public Rectangle(Point upperLeft, int width, int height) {
	// TODO
	super("Rectangle", upperLeft);
	this.setWidth(width);
	this.setHeight(height);
    }

    public Rectangle(Rectangle r) {
	// TODO
	super(r);
	this.setWidth(r.getWidth());
	this.setHeight(r.getHeight());
    }

    // Getters
    public int getWidth() {
	return this.width;
    }
    public int getHeight() {
	return this.height;
    }

    // Setters
    private void setWidth(int width) {
	this.width = width;
    }
    private void setHeight(int height) {
	this.height = height;
    }

    /* Method header comment
     * Name: toString
     * Purpose: This method will print out the strings that describe the
     *          rectangle (the coordinate of upperleft point and its width
     *          and height).
     * Parameter: None
     * Return: void
     */
    @Override
    public String toString() {
	// TODO
	return super.toString() + " Width: " + this.getWidth()
	    + " Height: " + this.getHeight();
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
	if(o instanceof Rectangle) {
	    //test if they have the same width and height and 
	    //whether their upperleft points point to the same reference
	    return super.equals((Rectangle)o) &&
		this.getWidth() == ((Rectangle)o).getWidth() &&
		this.getHeight() == ((Rectangle)o).getHeight();
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
	    FilledRect myRectangle = new FilledRect(
		    this.getUpperLeft().getX(), 
		    this.getUpperLeft().getY(), 
		    this.getWidth(), 
		    this.getHeight(), 
		    canvas);	
	    myRectangle.setColor(c);
	}
	else {
	    FramedRect myRect = new FramedRect(this.getUpperLeft().getX(), 
		    this.getUpperLeft().getY(), this.getWidth(), 
		    this.getHeight(), canvas);
	    myRect.setColor(c);
	}
    }
}
