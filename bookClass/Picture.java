import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * Copyright Georgia Institute of Technology 2004-2005
 * @author Barbara Ericson ericson@cc.gatech.edu
 * 
 /* Filename: Picture.java 
 * 1)PSA3 Part A/B created by: Rui Yan, cs8afbfd and Shijie Ji, cs8afbdh
 * 2)startPointPSA3 created by: Rui Yan, cs8afbfd
 * 
 * PID:
 * Rui Yan A92089334, 
 * Shijie Ji A92071119
 * 
 * Email: 
 * Rui Yan: r9yan@ucsd.edu, 
 * Shijie Ji: s5ji@ucsd.edu
 * 
 * Partner Histories:
 * Rui Yan:
 PSA0 Partner:  Shijie Ji, cs8afbdh
 PSA1 Partner:  Shijie Ji, cs8afbdh
 PSA2 Partner:  Shijie Ji, cs8afbdh
 PSA3 Partner:  Shijie Ji, cs8afbdh.
 PSA4 Partner:  To be determined...
 PSA5 Partner:  To be determined...
 PSA6 Partner:  To be determined...
 PSA7 Partner:  To be determined...
 PSA8 Partner:  To be determined...
 
 * Shijie Ji:
 PSA0 Partner:  Rui Yan, cs8afbfd
 PSA1 Partner:  Rui Yan, cs8afbfd
 PSA2 Partner:  Rui Yan, cs8afbfd
 PSA3 Partner:  Rui Yan, cs8afbfd
 PSA4 Partner:  To be determined...
 PSA5 Partner:  To be determined...
 PSA6 Partner:  To be determined...
 PSA7 Partner:  To be determined...
 PSA8 Partner:  To be determined...
 PSA9 Partner:  To be determined...
 
 * Date: 10/20/2015
 * Due Date:10/20/2015
 */ 

public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param width the width of the desired picture
   * @param height the height of the desired picture
   */
  public Picture(int width, int height)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /*Part A
   * Subtract the given values from the appropriate colors.
   * Input: rSub - the amount that should be subtracted from the original red value
   *        gSub - the amount that should be subtracted from the original green value
   *        bSub - the amount that should be subtracted from the original blue value
   * Returns: nothing
   */
  public void subtractColor(int rSub, int gSub, int bSub)
  { 
    Pixel[] pixelArray = this.getPixels();
    int rval = 0;
    int gval = 0;
    int bval = 0;
    int index = 0;
    while (index<pixelArray.length)
    {
      rval = pixelArray[index].getRed() - rSub;
      gval = pixelArray[index].getGreen() - gSub;
      bval = pixelArray[index].getBlue() - bSub;
      pixelArray[index].setRed(rval);
      pixelArray[index].setGreen(gval);
      pixelArray[index].setBlue(bval);
      index++;
    }
  }
  
//Part B
  /*1
   * Create the negative of each pixel between the provided indices
   * Input: start - the index of the first pixel to be modified (inclusive)
   * end - the index of the last pixel to be modified (inclusive)
   * Returns: nothing
   */
  public void compliment(int start, int end)
  {
    Pixel[] pixelArray=this.getPixels();
    Pixel p=null;
    while (start < end)
    {
      p=pixelArray[start];
      p.setRed(255-p.getRed());
      p.setGreen(255-p.getGreen());
      p.setBlue(255-p.getBlue());
      start+=1;
    }
  }
  
  /*2
   * Create the grayscale of each pixel between the provided indices
   * Input: start - the index of the first pixel to be modified (inclusive)
   *        end - the index of the last pixel to be modified (inclusive)
   * Returns: nothing
   */
  public void grayScale(int start, int end)
  {
    Pixel[] pixelArray=this.getPixels();
    Pixel p=null;
    int average;
    while (start < end)
    {
      p=pixelArray[start];
      average=(int)((p.getRed()+p.getGreen()+p.getBlue())/3);
      p.setRed(average);
      p.setBlue(average);
      p.setGreen(average);
      start+=1;
    }
  }
  
  /*3
   * Apply myFilter to each pixel between the provided indices
   * ADD A SHORT DESCRIPTION OF YOUR FILTER HERE
   * Input: start - the index of the first pixel to be modified (inclusive)
   *        end - the index of the last pixel to be modified (inclusive)
   * Returns: nothing
   */
  public void myFilter(int start, int end)
  {
    Pixel[] pixelArray=this.getPixels();
    Pixel p=null;
    Pixel q=null;
    while (start < end)
    {
      p=pixelArray[start];
      q=pixelArray[start+1];
      p.setRed(q.getBlue());
      p.setBlue(q.getGreen());
      p.setGreen(q.getRed());
      start+=1;
    }
  }
  
// starPointPSA3 created by Rui Yan, cs8afbfd
  public void starPointFilter(int start, int end)
  { 
    Pixel[] pixelArray=this.getPixels();
    Pixel p=null;
    double brightness;
    int average;
    int red;
    int blue;
    int green;
    int aRed;
    int aBlue;
    int aGreen;
    while (start < end)
    {
      p=pixelArray[start];
      red=p.getRed();
      blue=p.getBlue();
      green=p.getGreen();
      brightness = 0.3 * red + 0.6 * green + 0.1 * blue;
      average=(int)(brightness/3);
      aRed= Math.abs((int)(average-red));
      aBlue=Math.abs((int)(average-blue));
      aGreen=Math.abs((int)(average-green));
      red=(int)(average+aRed*(1.3));
      blue=(int)(average+aBlue*(1.3));
      green=(int)(average+aGreen*(1.3));
      p.setRed(red);
      p.setBlue(blue);
      p.setGreen(green);
      start+=1;
    }
  }
}
    
