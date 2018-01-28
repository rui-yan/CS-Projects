/* File header comment
 * Name: Rui Yan
 * Login: cs8bwaka 
 * Date: Februry 23, 2016
 * file: ARectangle.java 
 * Sources of Help: None  
 * 
 * This program will create several ctors and override some methods
 * in ARectangle class which is the subclass of Shape class. 
 *
 */

import objectdraw.*;

/* Class header comment
 * Name: ARectangle
 * Purpose: This class will overload several ctors of ARectangle class that 
 *          takes different parameters and override several methods from super
 *          class Shape. Those methods are move() and equals(). 
 *          In addition, it will implement setter and getter to set and get 
 *          the upperleft point of ARectangle. This class will have two 
 *          subclassed, Rectangle and Square. Both of them have to get the
 *          upperleft point by using the getter implemented in this class.
 */           
public abstract class ARectangle extends Shape {
    private Point upperLeft;

    // Constructors
    public ARectangle() {
	// TODO
	super("ARectangle"); // call the ctor in superclass to setName
	this.setUpperLeft(new Point(0,0));
    }

    public ARectangle(String name, int x, int y) {
	// TODO
	super(name);
	this.setUpperLeft(new Point(x,y)); 
	// deep copy by creating a new object
    }

    public ARectangle(String name, Point upperLeft) {
	// TODO
	super(name);
	this.setUpperLeft(new Point(upperLeft));
    }

    public ARectangle(ARectangle r) {
	// TODO
	super(r.getName());
	this.setUpperLeft(new Point(r.getUpperLeft()));
    }

    // Getter
    public Point getUpperLeft() {
	return this.upperLeft;
    }

    // Setter
    private void setUpperLeft(Point upperLeft) {
	this.upperLeft = upperLeft;
    }

    /* Method header comment
     * Name: move
     * Purpose: This method will add xDelta and yDelta to the shape's 
     *          current X and Y location (upperleft point)
     * Parameter: int xDelta, the integer that will be added to current
     *            x-coordinate of the point;
     *            int yDelta, the integer that will be added to current
     *            y-coordinate of the point;
     * Return: void
     */
    public void move(int xDelta, int yDelta) {
	// TODO
	this.getUpperLeft().move(xDelta, yDelta);  
    }

    /* Method header comment
     * Name: toString
     * Purpose: This method will print out the strings that describe the
     *          ARectangle (the coordinate of upperleft point).
     * Parameter: None
     * Return: void
     */
    @Override
    public String toString() {
	// TODO
	return this.getName() + ": Upper Left Corner: " + 
	    this.getUpperLeft();
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
	if(o instanceof ARectangle) {
	    // test if the upperleft point of the original ARectangle
	    // and the copied ARectangle point to the same reference
	    return this.getUpperLeft().equals(((ARectangle)o).getUpperLeft())
		&& this.getName() == ((ARectangle)o).getName();
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
}
