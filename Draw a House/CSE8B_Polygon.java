/* File header comment
 * Name: Rui Yan
 * Login: cs8bwaka 
 * Date: Februry 23, 2016
 * file: Polygon.java 
 * Sources of Help: None  
 * 
 * This program will create several ctors and override some methods
 * in Polygon class which is the subclass of Shape class. 
 *
 */
import java.awt.*;
import objectdraw.*;


/* Class header comment
 * Name: Polygon
 * Purpose: This class will overload several ctors of Polygon class that takes
 *          different parameters and override several methods from superclass 
 *          Shape. Those methods are move(), Draw() and equals(). In addition,
 *          it will implement setter and getter to set and get the array of 
 *          points of the polygon.
 */         
public class CSE8B_Polygon extends Shape {
    private Point points[];

    // Constructors
    public CSE8B_Polygon() {
	// TODO
	super("CSE8B_Polygon");
	this.setPointArray(new Point[0]); 
    }

    public CSE8B_Polygon(Point points[]) {
	// TODO
	super("CSE8B_Polygon");
	Point[] copy = new Point[points.length];
	for(int i = 0; i < points.length; i++){
	    copy[i] = new Point(points[i]);
	}
	this.setPointArray(copy);
    }

    public CSE8B_Polygon(CSE8B_Polygon p) {
	// TODO
	super(p.getName());
	Point[] copy = new Point[p.getPointArray().length];
	for(int i = 0; i < p.getPointArray().length; i++){
	    copy[i] = new Point(p.getPointArray()[i]);
	}
	this.setPointArray(copy);
    }

    // Getter
    public Point[] getPointArray() {
	return this.points;
    }

    // Setter
    private void setPointArray(Point[] copy) {
	this.points = copy;
    }

    /* Method header comment
     * Name: move
     * Purpose: This method will add xDelta and yDelta to the shape's 
     *          current X and Y location (all points in the point array)
     * Parameter: int xDelta, the integer that will be added to current
     *            x-coordinate of the point;
     *            int yDelta, the integer that will be added to current
     *            y-coordinate of the point;
     * Return: void
     */
    public void move(int xDelta, int yDelta) {
	// TODO
	for(int i = 0; i < this.points.length; i++) {
	    this.getPointArray()[i].move(xDelta, yDelta);
	}
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
	if(c == null)
	    c = Color.BLACK;
	int length = this.points.length;
	Line myLine = new Line(0,0,0,0,canvas);
	for(int i = 0; i < length-1; i++) {
	    myLine = new Line(this.points[i].getX(), 
		    this.points[i].getY(),
		    this.points[i+1].getX(),
		    this.points[i+1].getY(),
		    canvas);
	    myLine.setColor(c);
	}
	// connect the last and first point in the point array
	myLine = new Line(this.points[length-1].getX(), 
		this.points[length-1].getY(),
		this.points[0].getX(),
		this.points[0].getY(),
		canvas);
	myLine.setColor(c);
    }

    /* Method header comment
     * Name: toString
     * Purpose: This method will print out the strings that describe the
     *          polygon (the number of sides of the polygon).
     * Parameter: None
     * Return: void
     */
    public String toString() {
	// TODO
	return this.getName() + ": sides: " + this.points.length;
    }

    /* Method header comment
     * Name: equals
     * Purpose: This method will test if the copy ctors do the deep copy
     * Parameter: Object o, the copied object 
     * Return: boolean; return true if it is deep copy; otherwise false
     */

    public boolean equals(Object o) {
	// TODO
	if(o == null)
	    return false;
	if(o instanceof CSE8B_Polygon){
	    // for loop to loop over each point in the point array
	    // and test whether the points of the original polygon
	    // and copied polgon point to the same reference
	    if(this.getName() != ((CSE8B_Polygon)o).getName())
		return false;
	    for(int i = 0; i < ((CSE8B_Polygon)o).getPointArray().length; i++){
		if(!this.getPointArray()[i].equals
			(((CSE8B_Polygon)o).getPointArray()[i]))
		    return false;
	    }
	    return true;
	}
	else return false;
    }

    /* Method header comment
     * Name: hashCode
     * Purpose: This method will return an integer that represents the object
     * Parameter: None
     * Return: int; the integer that represents the object
     */
    public int hashCode() {
	// TODO
	return this.toString().hashCode();
    }
}

