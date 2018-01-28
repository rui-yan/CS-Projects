/* File header comment
 * Name: Rui Yan
 * Login: cs8bwaka 
 * Date: Februry 23, 2016
 * file: CSE8B_Line.java 
 * Sources of Help: None  
 * 
 * This program will create several ctors and override some methods
 * in CSE8B_Line class which is the subclass of Shape class. 
 *
 */

import java.awt.*;
import objectdraw.*;

/* Class header comment
 * Name: CSE8B_Line
 * Purpose: This class will overload several ctors of CSE8B_Line class that 
 *          takes different parameters and override several methods from 
 *          superclass Shape. Those methods are move(), Draw() and equal().
 *          In addition, it will implement setter and getter to set and get
 *          the start and end point of the line.
 */
public class CSE8B_Line extends Shape {
    private Point start;
    private Point end;

    // Constructors
    public CSE8B_Line() {
	// TODO
	super("CSE8B_Line"); // call the ctor in superclass to setName
	this.setStart(new Point(0,0));
	this.setEnd(new Point(0,0));
    }

    public CSE8B_Line(Point start, Point end) {
	// TODO
	super("CSE8B_Line");
	this.setStart(new Point(start));
	this.setEnd(new Point(end));
    }

    public CSE8B_Line(CSE8B_Line line) {
	// TODO
	super(line.getName());
	this.setStart(new Point(line.getStart()));
	// deep copy by creating a new object
	this.setEnd(new Point(line.getEnd()));
    }

    // Getters
    public Point getStart() {
	return this.start;
    }

    public Point getEnd() {
	return this.end;
    }

    // Setters
    private void setStart(Point start) {
	this.start = start;
    }

    private void setEnd(Point end) {
	this.end = end;
    }

    /* Method header comment
     * Name: move
     * Purpose: This method will add xDelta and yDelta to the shape's 
     *          current X and Y location (start and end point)
     * Parameter: int xDelta, the integer that will be added to current
     *            x-coordinate of the point;
     *            int yDelta, the integer that will be added to current
     *            y-coordinate of the point;
     * Return: void
     */
    public void move(int xDelta, int yDelta) {
	// TODO
	this.getStart().move(xDelta, yDelta);
	this.getEnd().move(xDelta, yDelta);
    }

    /* Method header comment
     * Name: toString
     * Purpose: This method will print out the strings that describe the
     *          CSE8B_Line (the coordinate of start point and end point)
     * Parameter: None
     * Return: void
     */
    @Override
    public String toString() {
	// TODO
	return this.getName() + ": " + this.getStart() + 
	    " to " + this.getEnd();
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
	if(o instanceof CSE8B_Line){
	    //test if the start point and end point of original line
	    //and the copied line point to the same reference
	    return this.getName() == ((CSE8B_Line)o).getName() &&
		this.getStart().equals(((CSE8B_Line)o).getStart()) &&
		this.getEnd().equals(((CSE8B_Line)o).getEnd());
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
	if(canvas == null)
	    return;
	// If c is null, use Color.BLACK
	if(c == null)
	    c = Color.BLACK;
	// Create the line
	Line myLine = new Line(this.getStart().getX(), this.getStart().getY(),
		this.getEnd().getX(), this.getEnd().getY(), canvas);
	myLine.setColor(c);
    }
}
