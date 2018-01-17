// Keep these two lines.  They are what tell Java to include the
// classes you need for working with files.
// You might get warnings about them at first.  That's OK, just
// ignore the warnings.  They should go away as you complete your code.
import java.io.*;
import java.util.*;

/** Your header comment goes here.
 *  Name: Rui Yan
 *  Login: cs8bwaka
 *  Date: January 12, 2016
 *  File: Caesar.java
 *  Sources of Help: None 
 * */

/*
 * Name:    Caesar
 * Purpose: To implement the caesar cipher (rotational cipher): decrypt and encrypt method .
 */

public class Caesar {
	// Complete the methods below.  Be sure to add header
	// comments for each. You may (and should) also write additional
	// helper methods.  Be sure to make the helper methods private and include
	// header comments for each.

	// Although you will not be graded on style this week, you should follow
	// these basic style guidelines nonetheless.   You will be graded on this
	// in weeks to come, so start to practice now.

	// Use proper indenting: Indent each block of code (e.g., method body,
	//   loop body.  Line up the lines in the block so that they are all
	//   indented to the same degree.  See examples of this in the book
	//   and in the code below.
	// Use descriptive variable names: The names of your variables should
	//   describe the data they hold.  Almost always, your variable names
	//   should be words (or abbreviations), not single letters.
	// Write short methods: Break your methods up into submethods if they
	//   are getting too complicated or long.  Generally your methods
	//   shouldn't get too much longer than about 20 lines of code
	// Write short lines: Each line of code should be no longer than 80
	//   characters, so it can fit in a reasonable size window.  There's a
	//   column number in both vim and emacs.
	//
	// We'll start with these, as these are the most important.We may add to
	// this list later in the term, but if you do all of the above you're
	// in good shape.

	/*
	 * Name:       encrypt
	 * Purpose:    To convert a string to an array of characters and use a for 
	 *             loop to access each character in the array and then call 
	 *             letterOperation method each time to rotate the letters 
	 * Parameters: String s, the string we wanna encrypt(the plaintext)
	 *             int rotation, the integer we wanna the rotational cipher to 
	 *             rotate
	 * Return:     a new string which is converted from the changed array of 
	 *             characters
	 */
	public static String encrypt(String s, int rotation) {
		// Complete this method 
		// letters are between 65 and 90 (Upper Case) 
		// and 97 and 122 (Lower Case)

		char[] chars = s.toCharArray();
		//convert the string into an array of characters

		for (int i=0; i < s.length(); i++){
			//use for loop to access the character at each index
			char a = chars[i];
			chars[i] = letterOperation(a, rotation);
			//call the helper method letterOperation
		} 
		return new String(chars);
		//convert the changed array to a string and return the string 
	}
	/*
	 * Name:       decrypt
	 * Purpose:    To convert a string to an array of characters and use a for
	 *             loop to access each character in the array and then call
	 *             letterOperation method each time to rotate the letters in the
	 *             opposite order of alphabetic for number rotation
	 * Parameters: String s, the string we wanna decrypt(the enciphered message)
	 *             int rotation, the integer we wanna the rotational cipher to
	 *             rotate
	 * Return:     a new string which is converted from the changed array of
	 *             characters
	 */
	public static String decrypt(String s, int rotation) {
		// Complete this method
		char[] chars = s.toCharArray();
		for (int i=0; i < s.length(); i++){
			char a = chars[i];
			chars[i] = letterOperation(a,-rotation);
			//decipher, the rotation number should be -rotation
		}
		return new String(chars);
	}
	/*
	 * Name:       letterOperation
	 * Purpose:    To take a character and then determine whether it is a letter,
	 *             rotate it in the alphabetic order for number rotation and then
	 *             return the character that has been rotated
	 * Parameters: char a, the character we wanna rotate
	 *             int rotation, the integer we wanna the rotational cipher to
	 *             rotate (the integer value of the offset) 
	 * Return:     a new character which is the rotated alphabet
	 * 
	 */
	private static char letterOperation(char a, int rotation) {
		//Complete this method

		char c = ' '; //initiate char c
		int x = 0;

		// Using if statement to determine the  
		// non-alphabetic characters
		if (!Character.isLetter(a))
			return a;//return the original characters 

		else{

			if (Character.isUpperCase(a)){
				x = (int)a - 65; //algorithm, minus int 'A'
				x = (x + rotation) % 26; //make x closer to 0
				if(x < 0)  //determine whether x is smaller than 0
					x += 26;
				c = (char)(65 + x); // casting integer to character    
			}

			else if(Character.isLowerCase(a)){
				x = (int)a - 97; //algorithm, minus int 'a'
				x = (x + rotation) % 26;
				if(x < 0)
					x += 26;
				c = (char)(97 + x);//casting integer to character 
			}
		} 
		return c;
	}
}
