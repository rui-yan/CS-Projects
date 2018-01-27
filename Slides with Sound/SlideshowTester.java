import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Array;
import java.util.Arrays;

public class SlideshowTester
{
  
  public static void main(String[] args)
  {
    
    // Testing setter methods and constructor for Slide.java
    int failedCases = 0;
    
    try
    {
      Slide slide = new Slide();
      // After the default constructor is call pic and sound should have null values
      if(slide.pic != null || slide.sound != null)
      {
        System.out.println("Error! Please check your constructors for class Slide!");
        failedCases++;
      }
      
      // Testing changeSound(sound) method
      Sound mySound = new Sound("sound1.wav");
      slide.changeSound(mySound);
      if(slide.sound != mySound)
      {
        System.out.println("Error! Failed changeSound method.");
        failedCases++;
      }
      
      // Setting the pic and sound to null using the setter methods
      slide.changePic(null);
      slide.changeSound(null);
      if(slide.pic != null || slide.sound != null)
      {
        System.out.println("Error! Failed changeSound and/or changePic method.");
        failedCases++;
      }
    }
    catch(Exception e) {
            System.out.println("Slideshow Test Case2 Failed:Error! Exception");
            failedCases++;
        }
    
    //Testing Slideshow Class
    //1st test: Testing the constructor which takes no arguments
    try{    
      //Obtaining the probFlip Value when constructor is called with no arguments, answer should be 0.5
      Field privateprobFlip = Class.forName("Slideshow").getDeclaredField("probFlip");
      privateprobFlip.setAccessible(true);
      //Calling constructor with no arguments
      Slideshow mySlideshow = new Slideshow();
      //Testing if the value of probFlip is 0.5
      if((double)privateprobFlip.get(mySlideshow)!=0.5){
        System.out.println("Slideshow Test Case1 Failed: When Slideshow constructor is called with no arguments, probability should be 0.5, but yours is "+ (double)privateprobFlip.get(mySlideshow));
       failedCases++;
      }   
      
    }
    catch ( ClassNotFoundException e ) {
            System.out.println("Slideshow Test Case1 Failed: Error! ClassNotFoundException");
            failedCases++;
        } catch ( IllegalAccessException e ) {
            System.out.println("Slideshow Test Case1 Failed: Error! IllegalAccessException");
            failedCases++;
        } catch (NoSuchFieldException e){
          System.out.println("Slideshow Test Case1 Failed: Error! NoSuchFieldException");
            failedCases++;
        }
        
        
    //2nd test case: Testing changeProbFlip method    
    try{    
      
      //Calling constructor with 1 argument
      Slideshow objTest = new Slideshow(0.7);
      //Calling the changeProbFlip method with 1.01 as argument. This should give an error if the method is wrong
      System.out.println("Displaying the statement you wrote inside your changeProbFlip method:");
      objTest.changeProbFlip(1.01);
      Field privateProbFlip2 = Class.forName("Slideshow").getDeclaredField("probFlip");
      privateProbFlip2.setAccessible(true);
     
      if((double)privateProbFlip2.get(objTest)!=0.7){
       System.out.println("Slideshow Test Case2 Failed: When Slideshow constructor is called with no arguments, probability should be 0.7, but yours is "+ (double)privateProbFlip2.get(objTest));
        failedCases++;
      }
         
    }
    catch ( ClassNotFoundException e ) {
            System.out.println("Slideshow Test Case2 Failed:Error! ClassNotFoundException");
            failedCases++;
        } catch ( IllegalAccessException e ) {
            System.out.println("Slideshow Test Case2 Failed:Error! IllegalAccessException");
            failedCases++;
        } catch (NoSuchFieldException e){
          System.out.println("Slideshow Test Case2 Failed:Error! NoSuchFieldException");
            failedCases++;
        }
        
    //3rd test case: Testing addSlide method
   try{    
       Picture pic1 = new Picture ("pic1.jpg");
       Picture pic2 = new Picture ("pic2.jpg");
       
       Sound sound1 = new Sound("sound1.wav");
       Sound sound2 = new Sound("sound2.wav");
       
       Slide slide1 = new Slide (pic1,sound1); 
       Slide slide2 = new Slide (pic2,sound2); 
    
       //Calling constructor with 1 argument
       Slideshow mySlideshowTest = new Slideshow(0.7);
      
     
       //Adding two slides
       mySlideshowTest.addSlide(slide1) ;
       mySlideshowTest.addSlide(slide2) ;
        
       Field[] fields = mySlideshowTest.getClass().getDeclaredFields();
       
       if(fields.length != 0){
         for(Field field : fields){
           field.setAccessible(true);
           if(field.getType().isArray()){
             field.setAccessible(true);
             int length = Array.getLength(field.get(mySlideshowTest)); 
             if(length!=2){
               System.out.println("Slideshow Test Case3 Failed:Number of slides in the slide array should be 2, but it is " +length);
               failedCases++;}
        }
    }
}
   }

 catch ( IllegalAccessException e ) {
          System.out.println("Slideshow Test Case3 Failed:Error! IllegalAccessException");
            failedCases++;
        } 
        
      if(failedCases == 0)
    {
      System.out.println("All test cases passed. However please note that these test cases test ONLY FEW BASIC SCENARIOS");
      System.out.println("You will be tested for many more scenarios for full credit. ");
    }   
    else
    System.out.println("Total Failed Cases are : "+failedCases);
}
}