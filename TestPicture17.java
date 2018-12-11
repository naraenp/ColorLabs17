
/**
 * Kevin Hayes
 * Test Picture Classes
 *
 * @author (Kevin Hayes)
 * @version (10-19-2016)
 */
import java.awt.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List
public class TestPicture17
{

    /**
     * main method, to test the picture
     *
     */
  public static void main(String[] args)
  {
      //opens picture using a dialog box
      /**/
     //String fileName = FileChooser.pickAFile();
     //Picture pictObj = new Picture(fileName);
     //pictObj.explore();

     //opens a pictue using a path
     //Picture apic = new Picture("C:\\Users\\khayes\\Favorites\\Documents\APCS- Java\chap03\Curriclum 2013\Picture Color labs\images\\beach.jpg");
     
     //relative path
     //Picture apic = new Picture("images\\beach.jpg");
     //Picture ferris1 = new Picture("images/2000 ferris wheel2.jpg");
     //Picture ferris2 = new Picture("images/2000 ferris wheel2.jpg");
     //Picture ferris3 = new Picture("/2000 ferris wheel2.jpg");
     
     

     //apic.explore();
     //ferris1.explore();
     
     
     //makes an array of pixels
     //Pixel[] pixels;
     //gets pixels from picture and assigns to pixels array
     //pixels = ferris1.getPixels();
     //how to get array of pixels
     
     
     
     
     //sets the picture of garfield as the picture and set to explore is
     Picture mypicture = new Picture("images/gfield.jpg");
     mypicture.explore();
     
     //makes an array of pixels and sets it to all the pixels in the picture
     Pixel[] pixels1;
     pixels1 = mypicture.getPixels();
     
     //outputs the size of the array of  pixels
     System.out.println("This is a array of size " + pixels1.length);
    
    //outputs the rgb value
    System.out.println(pixels1[17]);
    
    
    
    //outputs the rgb value of the pixel at 17
    System.out.println(pixels1[17].getColor());
    
    
    //access spot pixel
    
    pixels1[17].setColor(Color.blue);
 
    
    
    
   
     
     
    /**
     * Adjust the Red Value to equal 0
     */
    
    /*
    for (Pixel spot : pixels1){
        int redval = spot.getRed();
        int blueval = spot.getBlue();
        int greenval = spot.getGreen();
        if (redval < 170)
            spot.setRed((int)(redval * 1.5));    
        else
            spot.setRed(255);
        if (greenval < 170)
            spot.setGreen((int)(greenval * 1.5));  
        else
            spot.setGreen(255);
        if (blueval < 170)
            spot.setBlue((int)(blueval * 1.5));
        else
            spot.setBlue(255);
            
     */
    for (Pixel spot : pixels1){
        int redval = spot.getRed();
        int blueval = spot.getBlue();
        int greenval = spot.getGreen();
        spot.setRed(255-redval);
        spot.setBlue(255-blueval);
        spot.setGreen(255-greenval);
    }
    
    mypicture.explore();
        
     //how many pixels or how large array
    //System.out.println("This is a large array"+pixels1.length  );


    /**/
        //access each index
    //System.out.println(pixels1[17]);
    //access each pixel
    //Pixel spot = ferris1.getPixel(100,100);
    
    //System.out.println(pixels[17].getColor());
    //System.out.println(spot);
/*
    pixels[17].setColor(Color.blue);
    spot.setColor(new Color(252,252,252));
    pixels[500034].setColor(Color.blue);

    ferris1.explore();
/*
   // loop to access indexes of array or collection

    //for each loop spot  is a ?
    for (Pixel spot : pixels)
    System.out.println( spot );


   
 /**/

 /**
  * Method to clear red from picture
  * @param none
  * @return none
  */
 /*
    for (Pixel pixelObj : pixels)
        {
            //set the red value of the current pixel to the new value
           

        }
    ferris1.explore();
    
/**/
 /**
  * Method to reduce red from picture by a factor of n
  * @param none
  * @return none
  */

/*
int value;
final double  FACTOR = .5;
    for (Pixel pixelObj : pixels)
    {

        //get the redvalue
        value = pixelObj.getRed();
        //System.out.println(value);

        //decrease the red value by 50%
        
        //set the red value of the current pixel to the new value
        

    }
    // use new picture when changing or it will make changes to 
    // pic you already changed
    ferris1.explore();
    ferris2.explore();

  /**/ 
    //write/save a picture as a file
    mypicture.write("ultragarfield/ferris11.jpg");

    /**/
  }//main
}//class
