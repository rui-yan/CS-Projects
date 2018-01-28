/* File header comment
 * Name: Rui Yan
 * Login: cs8bwaka 
 * Date: Februry 23, 2016
 * file: Circle.java 
 * Sources of Help: None  
 * 
 * This program will create several ctors and override some methods
 * in Circle class which is the subclass of Shape class. 
 *
 */

import java.awt.*;
import objectdraw.*;

/* Class header comment
 * Name: Circle
 * Purpose: This class will overload several ctors of Circle class that takes
 *          different parameters and override several methods from superclass 
 *          Shape. Those methods are move(), Draw() and equals(). In addition,
 *          it will implement setter and getter to set and get the center point 
 *          and the radius of the circle.
 */           
public class Circle extends Shape {
    private Point center;
    private int radius;

    // Constructors
    public Circle() {
	// TODO
	super("Circle"); // call the ctor in superclass to setName
	this.setCenter(new Point(0,0));
	this.setRadius(0);
    }

    public Circle(Point center, int radius) {
	// TODO
	super("Circle"); // call the ctor in superclass to setName
	this.setCenter(new Point(center));
	this.setRadius(radius);
    }

    public Circle(Circle c) {
	// TODO
	super(c.getName());
	this.setCenter(new Point(c.getCenter()));
	this.setRadius(c.getRadius());
    }

    // Getters
    public Point getCenter() {
	return this.center;
    }
    public int getRadius() {
	return this.radius;
    }

    // Setters
    private void setCenter(Point center) {
	this.center = center;
    }
    private void setRadius(int radius) {
	this.radius = radius;
    }

    /* Method header comment
     * Name: move
     * Purpose: This method will add xDelta and yDelta to the shape's 
     *          current X and Y location (center point)
     * Parameter: int xDelta, the integer that will be added to current
     *            x-coordinate of the point;
     *            int yDelta, the integer that will be added to current
     *            y-coordinate of the point;
     * Return: void
     */
    public void move(int xDelta, int yDelta) {
	// TODO
	this.getCenter().move(xDelta, yDelta);
    }

    /* Method header comment
     * Name: toString
     * Purpose: This method will print out the strings that describe the
     *          circle (the coordinate of center point and its radius).
     * Parameter: None
     * Return: void
     */
    @Override
    public String toString() {
	// TODO
	return this.getName() + ": Center: " + this.getCenter() + 
	    "; Radius: " + this.getRadius(); 
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
	if(o instanceof Circle){
	    // test if the center point of the original circle and
	    // the copied circle point to the same reference
	    return this.getName() == ((Circle)o).getName() &&
		this.getCenter().equals(((Circle)o).getCenter()) &&
		this.getRadius() == ((Circle)o).getRadius();
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
	// If fill is true, fill the graphical object
	if(fill == true){
	    FilledOval myCircle = new FilledOval
		(this.getCenter().getX()-this.getRadius(),
		 this.getCenter().getY()-this.getRadius(),
		 this.getRadius()*2, this.getRadius()*2, canvas);
	    myCircle.setColor(c);
	}
	// else, do not fill it
	else{
	    FramedOval myCir = new FramedOval
		(this.getCenter().getX()-this.getRadius(),
		 this.getCenter().getY()-this.getRadius(),
		 this.getRadius()*2, this.getRadius()*2, canvas);
	    myCir.setColor(c);
	}
    }
}
