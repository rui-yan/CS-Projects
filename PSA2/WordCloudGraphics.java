/* Header Comment 
 * Name: Rui Yan
 * Login: cs8bwaka 
 * Date: January 16, 2016
 * File: WordCloud.java 
 * Sources of Help: None
 * 
 * This class is used to draw a word cloud given an input of an arraylist of
 * wordpairs.
 */

//importing classes
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
public class WordCloudGraphics extends JPanel {
   //Name of the font you want
   String type = "SansSerif";
   //Style of the font you want
   int styles = Font.BOLD;
   //Arraylist of WordPair
   ArrayList<WordPair> storeArray;
   //constructor
   public WordCloudGraphics(ArrayList<WordPair> words){
      storeArray = words;
   }
   //Default Constructor
   public WordCloudGraphics(){
      storeArray = null;
   }
   //Method to call the draw function
   //No need to change anything here
   public void drawWords(){
      try{
         JFrame f = new JFrame();
         f.addWindowListener(new WindowAdapter() {
               public void windowClosing(WindowEvent e) {
               System.exit(0);
               }
               }
               );
         f.setContentPane(new WordCloudGraphics(storeArray));
         //Size of the cloud
         f.setSize(1000,1000);
         f.setVisible(true);
      }
      catch(Exception e){
         System.out.println(e);
      }
   }

   //Modify this method 
   public void paint(Graphics g) {
      //Set size of the text to be drawn 
      int size= 0;
      int n = storeArray.size();
      //Iterate through the Arraylist and print the words
      //Complete the function such that the top most frequent occuring word
      //has biggest size, next most has smaller size and so on
      for(int i = 0;i < storeArray.size(); i++){
	      size = 2 * n - i;
         Font font = new Font(type, styles, size);
         g.setFont(font);
         //See Java documentation on drawString method and its parameters
         String name = storeArray.get(i).getWord();
	 int x = 2 * n * (i + 1);
	 int y = 2 * n * (i + 1);
	 g.drawString(name, x, y); 
      }
   }                  
}

