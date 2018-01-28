/* File header comment
 * Name: Rui Yan
 * Login: cs8bwaka 
 * Date: Februry 23, 2016
 * file: Triangle.java 
 * Sources of Help: None  
 * 
 * This program will create several ctors and override some methods
 * in Triangle class which is the subclass of Shape class. 
 *
 */

import java.awt.*;
import objectdraw.*;

/* Class header comment
 * Name: Triangle
 * Purpose: This class will overload several ctors of Triangle class that takes
 *          different parameters and override several methods from superclass 
 *          Shape. Those methods are move(), Draw() and equals(). In addition,
 *          it will implement setter and getter to set and get the three points
 *          of the triangle.
 */           
public class Triangle extends Shape {
    private Point p1;
    private Point p2;
    private Point p3;

    // Constructors
    public Triangle() {
	// TODO
	super("Triangle"); // call the ctor in superclass to setName
	this.setP1(new Point(0,0));
	this.setP2(new Point(0,0));
	this.setP3(new Point(0,0));
    }

    public Triangle(Point p1, Point p2, Point p3) {
	// TODO
	super("Triangle");
	this.setP1(new Point(p1)); // deep copy by creating a new object
	this.setP2(new Point(p2));
	this.setP3(new Point(p3));
    }

    public Triangle(Triangle tri) {
	// TODO
	super(tri.getName());
	this.setP1(new Point(tri.getP1()));
	this.setP2(new Point(tri.getP2()));
	this.setP3(new Point(tri.getP3()));
    }

    // Getters
    public Point getP1() {
	return this.p1;
    }
    public Point getP2() {
	return this.p2;
    }
    public Point getP3() {
	return this.p3;
    }

    // Setters
    private void setP1(Point p1) {
	this.p1 = p1;
    }
    private void setP2(Point p2) {
	this.p2 = p2;
    }
    private void setP3(Point p3) {
	this.p3 = p3;
    }

    /* Method header comment
     * Name: move
     * Purpose: This method will add xDelta and yDelta to the shape's 
     *          current X and Y location (all 3 points)
     * Parameter: int xDelta, the integer that will be added to current
     *            x-coordinate of the point;
     *            int yDelta, the integer that will be added to current
     *            y-coordinate of the point;
     * Return: void
     */
    public void move(int xDelta, int yDelta) {
	// TODO
	// call the method in Point.java to move
	this.getP1().move(xDelta, yDelta);
	this.getP2().move(xDelta, yDelta);
	this.getP3().move(xDelta, yDelta);
    }

    /* Method header comment
     * Name: toString
     * Purpose: This method will print out the strings that describe the
     *          triangle (the coordinate of three points).
     * Parameter: None
     * Return: void
     */
    @Override
    public String toString() {
	// TODO
	return this.getName() + ": " + this.getP1() + ", "
	    + this.getP2() + ", " + this.getP3();
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
	if (o instanceof Triangle) {
	    //test if the three points of original triangle
            //and the copied triangle point to the same reference
	    return this.getName() == ((Triangle)o).getName() &&
		this.getP1().equals(((Triangle)o).getP1()) &&
		this.getP2().equals(((Triangle)o).getP2()) &&
		this.getP3().equals(((Triangle)o).getP3());
	}
	return false;
    }

    /* Method header comment
     * Name: hashCode
     * Purpose: This method will return an integer that represents the object
     * Parameter: None
     * Return: int; the integer that represents the object
     */
    @Override
    public int hashCode() {
	// TODO
	return this.toString().hashCode();
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
	// If c is null, use Color.BLACK
	if(c == null)
	    c = Color.BLACK;
	// Create three lines to draw the triangle
	Line line1 = new Line(this.getP1().getX(), this.getP1().getY(), 
		this.getP2().getX(), this.getP2().getY(), canvas);
	Line line2 = new Line(this.getP2().getX(), this.getP2().getY(),
		this.getP3().getX(), this.getP3().getY(), canvas);
	Line line3 = new Line(this.getP3().getX(), this.getP3().getY(), 
		this.getP1().getX(), this.getP1().getY(), canvas);
	// Set color
	line1.setColor(c);
	line2.setColor(c);
	line3.setColor(c);
    }
}
