/* File header comment
 * Name: Rui Yan
 * Login: cs8bwaka 
 * Date: Februry 23, 2016
 * file: Point.java 
 * Sources of Help: None  
 * 
 * This program will create several ctors and some methods
 * in Point class. 
 *
 */

/* Class header comment
 * Name: Point
 * Purpose: This class will create several ctors that takes different 
 *          parameters and implement several methods of Point. Those 
 *          methods are move(), toString(), hashCode() and equals().
 */
public class Point {
    private int x;
    private int y;

    // Constructors
    public Point() {
	// TODO
	this.setX(0);
	this.setY(0);
    }

    public Point(int x, int y) {
	// TODO
	this.setX(x);
	this.setY(y);
    }

    public Point(Point point) {
	// TODO
	this.setX(point.getX());
	this.setY(point.getY());
    }

    // Getters
    public int getX() {
	return this.x;
    }
    public int getY() {
	return this.y;
    }

    // Setters
    private void setX(int x) {
	this.x = x;
    }
    private void setY(int y) {
	this.y = y;
    }

    /* Method header comment
     * Name: Point
     * Purpose: This method will add xDelta and yDelta to the x and y 
     *          coordinate of the point.
     * Parameter: int xDelta, the integer that will be added to current
     *            x-coordinate of the point;
     *            int yDelta, the integer that will be added to current
     *            y-coordinate of the point;
     * Return: void
     */
    public void move(int xDelta, int yDelta) {
	// TODO
	this.setX(this.getX() + xDelta);
	this.setY(this.getY() + yDelta);
    }

    /* Method header comment
     * Name: toString
     * Purpose: This method will print out the strings that describe the
     *          point (its x and y coordinate)
     * Parameter: None
     * Return: void
     */
    @Override
    public String toString() {
	// TODO
	return "Point: (" + this.getX() + "," + this.getY() + ")";
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
	if(o instanceof Point){
	    //test whether the x and y coordinate of the orginal
	    //point and the copied point equal
	    return this.getX() == ((Point)o).getX() &&
		this.getY() == ((Point)o).getY();
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
