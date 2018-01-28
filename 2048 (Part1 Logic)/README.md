
 *  Name: Rui Yan
 *  Login: cs8bwaka
 *  Date: January 30, 2016
 *  File: README
 

PROGRAM DESCRIPTION:
-------------------------------------------------------------------------------
The following two programs are used to implement the 2048 game

GameManager.java:
-- This program manages the gameplay. It will print out the controls 
   used to operate the game and the current state of the 2048 board.
   Then it will prompt you for a command and check if your command 
   is valid. If it is valid, it will execute the command.
   If it is not valid, it will exit and save the file.

Board.java
-- This program will check whether you can move in a certain direction.
   If you cannot move, your board will not change. It you can move, then
   it will perform the move according to your commands. When you move 
   successfully, your score will increase according to the tiles which 
   collided. If you cannot move in any direction at last,it will tell 
   the GameManeger to print out "Game Over!"and exit. 
   
   In addition, this program allows you to upload an unfinished game, 
   to save your unfinished game to a file, to rotate your board and 
   to check the validity of the unfinished game uploaded from the file.  
   
SHORT RESPONSE:
-------------------------------------------------------------------------------
Unix/Linux related Questions:
1. From your current directory how do you copy over a java file named fubar 
   from a folder three directories above? Write the full command required to 
   perform this action. 
-- cp ../../../fubar.java

2. What does the command ¡°man cat¡± do (with no quotes)? 
-- Display the manual page (online software documentatio) for the Unix 
   command "cat"

Vim related Questions
3. How do you jump to a certain line number in your code with a single command 
   in vim? For example, how do you jump directly to line 20? (Not arrow keys)
-- Type ":n" (Move to nth line of the file) in the command mode
-- Type ":20" (Move to line 20) in the command mode

4. What does the command ¡°gg¡± do (with no quotes). What about ¡°G¡±?
-- "gg": go to the top of the file
-- "G" : go to the end of the file

Java Questions:
5. Name the 2 requirements for a constructor signature. 
-- 1) Name of the constructor should be the same as the name of the class 
-- 2) no return type/ Access modifier-private, public or protected

6. What does the keyword static mean in regards to variables?
-- It means that the scope of the variables is the whole class. 
   Static variable is a member variable of a given class which is
   shared across all instances (objects), and is accessible as a 
   member variable of these objects.
