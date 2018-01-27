/* Filename: Slideshow.java
 * Created by: Rui Yan, cs8afbfd and Mengying Li, cs8afabf
 * PID:
 * Rui Yan: A92089334
 * Mengying Li: A92124721
 * 
 * Email: 
 * Rui Yan: r9yan@ucsd.edu, 
 * Mengying Li: mel116@ucsd.edu
 * 
 * Partner Histories:
 * Rui Yan:
 PSA0 Partner:  Shijie Ji, cs8afbdh
 PSA1 Partner:  Shijie Ji, cs8afbdh
 PSA2 Partner:  Shijie Ji, cs8afbdh
 PSA3 Partner:  Shijie Ji, cs8afbdh
 PSA4 Partner:  Mengying Li, cs8afabf
 PSA5 Partner:  Mengying Li, cs8afabf
 PSA6 Partner:  Mengying Li, cs8afabf
 PSA7 Partner:  Mengying Li, cs8afabf
 PSA8 Partner:  Mengying Li, cs8afabf
 
 * Mengying Li:
 PSA0 Partner:  Wendi Wu, cs8afacq
 PSA1 Partner:  David Amadeo, cs8afbcl
 PSA2 Partner:  Xinyu Wu, cs8afafl
 PSA3 Partner:  David Amadeo, cs8afbcl
 PSA4 Partner:  Rui Yan, cs8afbfd
 PSA5 Partner:  Rui Yan, cs8afbfd
 PSA6 Partner:  Rui Yan, cs8afbfd
 PSA7 Partner:  Rui Yan, cs8afbfd
 PSA8 Partner:  Rui Yan, cs8afbfd
 
 * Date: 12/01/2015
 * Due Date:12/01/2015
 */ 
import java.util.Random;
public class Slideshow
{
  //////////// fields //////////////////
  private Slide[] slides;
  private double probFlip;
  //////////// constructors ///////////
  public Slideshow(){
   this.slides = null;
   this.probFlip = 0.5;
  }
  public Slideshow(double inProb){
    this.slides = null;
    this.probFlip = inProb;
  }
  /////////// methods ///////////////
  /** This method changes the value of probFlip to inProb
    * inProb: a double number between 0 and 1 that indicates the 
    *    probability to flip horizontally
    */
  public void changeProbFlip(double inProb){
    if (inProb >= 0 && inProb <= 1){
    this.probFlip = inProb;
    }
    else{
      System.out.println("Inappropriate value for probFlip");
    }
  }
  /** This method adds a slide, inSlide, to the end of the slides array.
    * inSlide: the slide we want to add.
    */
  public void addSlide(Slide inSlide){
    Slide[] oneLarger = null;
    if (slides == null){
    oneLarger = new Slide[1];
    oneLarger[0] = inSlide;
    slides = oneLarger;
    }
    else{
    oneLarger = new Slide[slides.length+1];
    for (int i = 0; i < slides.length; i++){
    oneLarger[i] = slides[i];
    }
    oneLarger[slides.length] = inSlide;
    slides = oneLarger;
  }
}
  /** This method changes the slide at index slideToChange to inSlide.
    * inSlide: the slide we want to insert at index slideToChange
    * slideToChange: the interger of the index we want to change the slide
    */
  public void changeSlide(Slide inSlide, int slideToChange){
    Slide[] indexChange = new Slide[slides.length];
    if (slideToChange >= 0 && slideToChange < slides.length){
      slides[slideToChange] = inSlide;
    }
    else{
      System.out.println("slideToChange is out of the valid index range");
    }
  }
  /** This method shows the entire slideshow from beginning to end. 
    */ 
  public void show(){
    if(this.slides == null){
      System.out.println("Error The slideshow is empty");
    }
    else{
      boolean flipHorizontal;
      Random rnd = new Random();
      for(int i = 0; i < this.slides.length; i++){
      double random = rnd.nextDouble();
        if (random < this.probFlip){
          flipHorizontal = true;
        }
        else{
          flipHorizontal = false;
        }
        slides[i].showSlide(flipHorizontal);
      }
    }
  }
  
  public static void main( String[] args ){
    
    Picture pic1 = new Picture("pic1.jpg");
    Picture pic2 = new Picture("pic2.jpg");
    Picture pic3 = new Picture("pic3.jpg");
    Picture pic4 = new Picture("pic4.jpg");

    Sound sound1 = new Sound("sound1.wav");
    Sound sound2 = new Sound("sound2.wav");
    Sound sound3 = new Sound("sound3.wav");
    Sound sound4 = new Sound("sound4.wav");
    
    Slide slide1 = new Slide(pic1,sound1);
    Slide slide2 = new Slide(pic2,sound2);
    Slide slide3 = new Slide(pic3,sound3);
    Slide slide4 = new Slide(pic4,sound4);
    
    Slideshow slideshow = new Slideshow(0.7);
    slideshow.addSlide(slide1);
    slideshow.addSlide(slide2);
    slideshow.addSlide(slide3);
    slideshow.addSlide(slide4);
    slideshow.show();      
  }       
}
    
    