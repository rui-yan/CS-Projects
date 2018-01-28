/* File header comment
 * Name: Rui Yan
 * Login: cs8bwaka 
 * Date: Februry 23, 2016
 * file: Shape.java 
 * Sources of Help: None  
 * 
 * This program will create several ctors and some methods that will be
 * inheritated in its subclass.
 *
 */

import java.awt.*;
import objectdraw.*;

/* Class header comment
 * Name: Shape
 * Purpose: This class will construct several ctors of Shape class that takes
 *          different parameters and implement setName() to set the name of 
 *          the graphical object in its subclass and several other methods 
 *          that will be overriden in its subclass. Those methods are move(), 
 *          Draw(), equals().
 */
public abstract class Shape {
    private String name;

    // Constructors
    public Shape() {
	// TODO
	this.setName("Shape");
    }

    public Shape(String name) {
	// TODO
	this.setName(name);
    }

    // Getter
    public String getName() {
	// TODO
	return this.name;
    }

    // Setter
    private void setName(String name) {
	this.name = name;
    }

    /* Method header comment
     * Name: equals
     * Purpose: This method will test if the copy ctors do the deep copy
     * Parameter: Object o, the copied object 
     * Return: boolean; return true if it is deep copy; otherwise false
     */
    @Override
    public boolean equals(Object o) {
	String s = "\n**********************************************************\n"
	    + "This should never print. If it does print, then\n"
	    + "you did not override equals() properly in class "
	    + this.getClass().getName() + "\n"
	    + "**********************************************************\n";

	System.out.println(s);

	return this == o;
    }

    /* Method header comment
     * Name: move
     * Purpose: This method is an abstract method that is declared without 
     *          an implementation
     * Parameter: int xDelta, the integer that will be added to current
     *            x-coordinate of the point;
     *            int yDelta, the integer that will be added to current
     *            y-coordinate of the point;
     * Return: void
     */
    public abstract void move(int xDelta, int yDelta);

    /* Method header comment
     * Name: draw
     * Purpose: This method is an abstract method that is declared without 
     *          an implementation
     * Parameter: DrawingCanvas canvas: the canvas object that will be drawed;
     *            Color c: the color of the graphical object, if c is null,
     *            use Color.BLACK;
     *            boolean fill: determine whether the graphical object should 
     *            be filled or not.
     * Return: void
     */
    public abstract void draw(DrawingCanvas canvas, Color c, boolean fill);
}
