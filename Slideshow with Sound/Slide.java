/* Filename: Slide.java
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
public class Slide
{
  //////////// fields //////////////////
  /** the picture */
  public Picture pic;
  /** the sound */
  public Sound sound;
  
  //////////// constructors ///////////
  public Slide(){
    this.pic = null;
    this.sound = null;
  }
  public Slide(Picture inPic, Sound inSound)
  {
    this.pic = inPic;
    this.sound = inSound;
  }
  /////////// methods ///////////////
  /** This method changes the picture to be displayed for this
    *    slide to the image represented by inPic.
    * inPic: the picture we want to change to
    */
    public void changePic(Picture inPic)
    {
      this.pic = inPic;
    }
    /** This method Changes the sound to be played for this
      * slide to the sound represented by inSound.
    * inSound: the sound we want to change to
    */
    public void changeSound(Sound inSound)
    {
      this.sound = inSound;
    }
   /** This method shows the modified copy of the slide picture based on the parameter
     *    flipHorizontal, plays the sound, and in the end closes the image.
     * flipHorizontal: the boolean parameter to indicate whether to flip the 
     * copy of the slide picture horizontally or vertically before showing it
     */ 
   public void showSlide(boolean flipHorizontal)
   {
     Picture copy = new Picture(this.pic);
     if (this.pic == null || this.sound == null)
     {
       System.out.println("Error The pic or sound is null");
     }
     else{
     if(flipHorizontal == true)
     {
       copy.flipHorizontal();
       copy.show();
       sound.blockingPlay();
       copy.hide();
     }
     else
     {
       copy.flipVertical();
       copy.show();
       sound.blockingPlay();
       copy.hide();
     }
     } 
    }
}
    
  