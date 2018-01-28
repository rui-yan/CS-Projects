/* File header comment
 * Name: Rui Yan
 * Login: cs8bwaka 
 * Date: Februry 23, 2016
 * file: TestCSE8B_Polygon.java 
 * Sources of Help: None   
 *
 */

import java.awt.*;
import objectdraw.*;

public class TestCSE8B_Polygon extends WindowController
{
    public void begin()
    {
	try
	{
	    makePolygon();
	}
	catch ( Exception e )
	{
	    String msg1 = "An Exception Occurred!";
	    String msg2 = "Check the terminal window";
	    String msg3 = "for details!";

	    Text errorMsg1 = new Text( msg1, 25, 200, canvas );
	    Text errorMsg2 = new Text( msg2, 25, 225, canvas );
	    Text errorMsg3 = new Text( msg3, 25, 250, canvas );

	    errorMsg1.setColor( Color.RED );
	    errorMsg1.setFontSize( 32 );
	    errorMsg1.setBold( true );

	    errorMsg2.setColor( Color.RED );
	    errorMsg2.setFontSize( 32 );
	    errorMsg2.setBold( true );

	    errorMsg3.setColor( Color.RED );
	    errorMsg3.setFontSize( 32 );
	    errorMsg3.setBold( true );

	    e.printStackTrace();
	}
    }

    public void makePolygon()
    {
	Shape poly1;  // these are generic Shapes
	CSE8B_Polygon poly2;
	Point[] pointsArr;
	Point p1, p2, p3, p4, p5;

	// Test Polygon no-arg ctor - should set points[] to null
	poly1 = new CSE8B_Polygon();

	if (((CSE8B_Polygon)poly1).getPointArray().length != 0){
	    String s = "\nThis should not print!!!\n"
		+ "Testing Polygon no-arg ctor\n"
		+ "PointArray should be null\n";
	    throw new IllegalStateException( s );
	}

	p1 = new Point( canvas.getWidth()/5, canvas.getHeight()/5 );
	p2 = new Point( canvas.getWidth()/4, canvas.getHeight()/2 );
	p3 = new Point( canvas.getWidth()/3, canvas.getHeight()/4 );
	p4 = new Point( canvas.getWidth()/4, canvas.getHeight()/3 );
	p5 = new Point( canvas.getWidth()/6, canvas.getHeight()/6 );

	pointsArr = new Point[5];
	pointsArr[0] = p1;
	pointsArr[1] = p2;
	pointsArr[2] = p3;
	pointsArr[3] = p4;
	pointsArr[4] = p5;

	// Test Polygon points[] ctor
	poly1 = new CSE8B_Polygon(pointsArr);
	poly1.draw( canvas, Color.BLACK, false );

	// Test if Polygon ctor did shallow copy vs deep copy

	if (((CSE8B_Polygon)poly1).getPointArray()[0] == p1) {
	    String s = 
		    "\nYou implemented the Polygon ctor with a shallow copy.\n"
		+ "Should be deep copy!\n";
	    throw new IllegalStateException( s );
	}

	if (p1.equals(poly1)){
	    String s ="\nThis should not print! Comparing Point to Polygon.\n";
	    throw new IllegalStateException( s );
	} 

	if (poly1.equals(p1)){
	    String s ="\nThis should not print! Comparing Polygon to Point.\n";
	    throw new IllegalStateException( s );
	} 

	if (poly1 instanceof CSE8B_Polygon){
	    poly2 = new CSE8B_Polygon((CSE8B_Polygon)poly1); 
	    //test Polygon copy ctor
	    poly2.move(200, 0); 
	    //test Polygon.move()
	    poly2.draw(canvas, Color.GREEN, true);

	    boolean deep = true;
	    for(int i = 0; i < pointsArr.length; i++){
		if (((CSE8B_Polygon)poly2).getPointArray()[i] 
			== ((CSE8B_Polygon)poly1).getPointArray()[i])
		    deep = false;
	    } 
	    if(deep == false){
		String s = "\nYou implemented the Polygon copy ctor with a "
		    + "shallow copy.\n"
		    + "Should be deep copy.\n";
		throw new IllegalStateException( s );
	    }

	    if (poly1.equals(null)) {  // test Polygon equals() with null
		String s = "\nThis should not print!!!\n"
		    + "Testing Polygon equals() with null\n";
		throw new IllegalStateException( s );
	    }

	    // test Polygon equals()
	    if ((poly1.equals(poly2))){  // must have used == for compare
		String s = 
		    "\nYou implemented the Polygon equals() incorrectly.\n";
		throw new IllegalStateException( s );
	    }

	    // test Circle toString()
	    /* Display info about poly1 */
	    Text text1 = new Text(poly2.toString(), 
		    canvas.getWidth() / 2, 
		    canvas.getHeight() / 2, 
		    canvas);
	}
	else
	{
	    throw new RuntimeException(String.valueOf(poly1));
	}

    }  // End of makePolygon()

} // End of class 
