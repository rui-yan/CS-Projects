/** 
 *  Name: Rui Yan
 *  Login: cs8bwaka
 *  Date: March 4, 2016
 *  File: README
 *  Sources of Help: None 
 */

PROGRAM DESCRIPTION:
-------------------------------------------------------------------------------
Explain how to run your program. What happens when you run it? How did you test 
your program to ensure correct output? 
-- Type "java ¨Ccp ./turtleClasses.jar:. CS8BTurtle" in the command mode to run
   the program. When we run it, it will show one (or more than one) turtles and
   use those turtles (pens) to draw the characters in parallel. Check if the 
   final image looks the same as what you expected.

SHORT RESPONSE
-------------------------------------------------------------------------------
Vim Questions:
1. How do you set a marker in vim (use register a)
-- ma

2. Given the first question, how do you go to that marker? 
-- 'a

Unix Questions:
3. What is the command to display the first five lines of a file to the 
   terminal? The last five lines?
-- "head -lines filename", "lines is an optional value specifying the number 
   of lines to be read."
-- display the first five lines of a file, we need to type "head -5 filename"
-- display the last five lines of a file, "tail -5 filename"

4. What is the command to transfer files across accounts? 
-- scp [options] username1@source_host:directory1/filename1 
   username2@destination_host:directory2/filename2
         
Java Questions:
5. Given the following code:
	Arectangle r = new Rect();
	r.toString();
   Which class's toString() is called? 
-- Rect class
	    
6. What is implicitly called in a classes no-argument constructor? For example:
	public class Bar extends Foo {
		public Bar()
	        {
                     System.out.println(¡°What¡¯s called before this statement¡±);
		}
       }

-- super();


