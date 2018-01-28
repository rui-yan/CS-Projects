 *  Name: Rui Yan
 *  Login: cs8bwaka
 *  Date: February 23, 2016
 *  File: README


PROGRAM DESCRIPTION:
-------------------------------------------------------------------------------
1. Point.java: This program will allow people to get and set the points of the 
graphical object in the following programs. Also, it enables those graphical
objects to move by moving their critical points (for Triangle: three vertexs;
Rectangle and Square: upperleft point; Circle: center point; Line: start and 
end point). In addition, it will print out the strings that describe the
coordinate of those points.
---------------
2. Shape.java: This program will describe some common properties of the 
graphical objects in the following programs (their move and draw). 
In addition, it implements a test for every graphical objects to test whether 
those programs implement a correct method to copy the ojects. Also, it allows 
people to get and set the name of those graphical objects.
---------------
The following programs all have the common properties implemented in the 
Shape.java. In addition, they add their own properties in their own programs:
---
1) CSE8B_Line.java: This program will deal with line. It allows people to set 
and get the start point and the end point of the line. In addition, it prints
out the information to describe the line (the coordinate of the start and end
points) and moves and draws the line (the color of the line can be determined
by the users).
---
2) Circle.java: This program will deal with circle. It allows people to set 
and get the center point and the radius of the circle. In addition, it prints
out the information to describe the circle (the coordinate of the center point
and the radius) and moves and draws the circles (fills the circle with the
color user asks. If user does not want to fill the circle with color, it will
draw a circle without filling color; if user does not ask for a certain color,
the frame of the cirle will be black).
---
3) Triangle.java: This program will deal with triangle. It allows people to set 
and get the three vertexs of the triangle. In addition, it prints out the 
information to describe the triangle (the coordinate of the three points and 
moves and draws the triangles. It fills the triangle by drawing many frames of
triangle(three lines that connected by its three vertexs). Users can decide 
which color they want for the triangle; if user does not ask for a certain 
color, the color will be defaulted as black).
---
4) ARectangle.java: This program will deal with the common properties of a 
rectangle, including rectangle and a special kind of rectangle--square. 
It allows people to set and get the upperleft point of the rectangle. 
In addition, it prints out the information to describe the rectangle 
(the coordinate of the upperleft point) and moves the rectangle. There have 
two sub-programs that implement the properties of square and rectangle
specifically:

4.1) Square.java: This program will deal with square. It allows people to
get and set the length of sides of the square. In addition, it draws the square
according to user's requirement(fill the square with a certain color if users
want). Also, it adds more detailed information about its length of sides in
the printed out strings.

4.2) Rectangle.java: This program will deal with rectangle. It allows people to
get and set the length of the width and height of the rectangle. In addition, 
it draws the rectangle according to user's requirement (fill it with a certain 
color if users want). Also, it adds more detailed information about its 
length of width and height in the printed out strings.


SHORT RESPONSE
-------------------------------------------------------------------------------
1. How would you test whether the copy constructors in the shape classes are 
   doing a deep copy instead of a shallow copy?
-- Description by words:
   Create an object in the shape classes and then use copy ctor to create
   a deep copy of this object. Then use "==" to test if this two object point 
   to the same reference; If yes, it is a shallow copy; if not, then use equals
   method to test if this two objects at the same position: if yes, then it is 
   a deep copy.  
 
  For example, given:
	CSE8B_Line line1 = new CSE8B_Line();
	CSE8B_Line line2 = new CSE8B_Line(line1);
   How would you write a test to determine if CSE8B_Line¡¯s copy constructor 
   is doing a deep copy?

-- Description by code:
   public void testCopyCtor() {
   CSE8B_Line line1 = new CSE8B_Line();
   CSE8B_Line line2 = new CSE8B_Line(line1);
   line1.move(1,2);
   if(line2 == line1)
        System.out.println("copy ctor does a shallow copy");
   else if(!line2.equals(line1))
        System.out.println("copy ctor does a deep copy");
   }      

2. On a similar note, how would you write a test for the equals() method in 
   CSE8B_Line to determine if it is doing a deep comparison vs. a shallow 
   reference comparisons?

-- 1)Description by code:
   public void testEquals() {
   CSE8B_Line line1 = new CSE8B_Line();
   CSE8B_Line line2 = new CSE8B_Line(line1);
   line1.move(1,2);
   if(line1.equals(line2))
         System.out.print("equals()method does a shallow copy");
   else
         System.out.print("equals()method does a deep copy");
}

  2)Description by words:
  Create a new line (line1) and then create its copy (line2) by using copy 
  constructor, then move line1 by using move method. Then, use equals method
  to test whether line2 and line1 at the same position. If yes, it is shallow
  copy because the reference of line2 changes when the line1 moves; If not,
  it is a deep copy.
  


