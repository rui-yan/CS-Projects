/** 
 *  Name: Rui Yan
 *  Login: cs8bwaka
 *  Date: February 26, 2016
 *  File: README
 *  Sources of Help: None 
 */

SHORT RESPONSE
-------------------------------------------------------------------------------
Vim related Question:

1) In vim, what command can you use to find and replace every instance of the 
   word fun with amazing? How would you replace only the first instance of fun 
   with amazing in each line?
-- Type ":%s/fun/amazing/g" to replace every instance of the word fun with 
   amazing
-- Type ":%s/fun/amazing/" to replace only the first instance of fun with
   amazing 

Unix/Linux Questions:

2) Suppose you are currently inside a directory and in there you want to make 
   a new directory called fooDir. And inside fooDir, you want another directory 
   called barDir. Using only a single mkdir command, how can you create a 
   directory called fooDir with a directory called barDir inside it? 
-- mkdir -p fooDir/barDir

3) Give an example of how you would use a wildcard character (you can use it 
   with whichever command you want like rm, cat, ls, cp, etc). Describe what 
   happens after you use it. 
-- * (Asterisk) represents any sequence of characters. This means that if you 
   include a * in your filename then that part of the filename can be formed 
   using any sequence of characters.
-- Example: "rm *.class" removes all .class files (files with .class extension) 
             in a Unix directory

4) How can you run gvim through the command line to open all Java source code 
   files in the current directory, each file in its own tab?
-- gvim -p *.java

Java Question:
5) What does the keyword static mean in regards to methods? Provide an example 
   use of a static method. 
-- "static" keyword denotes that a method can be accessed without requiring an 
   instantiation of the class to which it belongs. In other words, a static 
   method can be invoked without the need for creating an instance of a class.
-- Example: we can call Math.abs() every time without creating an object.

6) A high school student is trying to write a Java program that will draw 
   different shapes and in different possible colors. To do this, she has 
   written just one Java class called ShapeDrawer, which contains all the 
   necessary methods like drawRedCircle(), drawBlueCircle(), 
   drawYellowSquare(), drawGreenSquare(), and so on. Using object-oriented 
   terminology, describe how you can help the student improve her design.
-- I would suggest her writing a parent class drawShape and creates some
   methods to draw the shape in different colors. Then, write the subclasses 
   that inheritate from the superclass to draw different shapes such as circle 
   and square. Then overloads the method of drawing shape in differenr colors
   in the subclasses to draw different shapes (circle and square) in different
   colors.

