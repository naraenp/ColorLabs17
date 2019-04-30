//Naraen Palanikumar
//10.30.2018
//Poster Project Lab
//Makes a collage of pictures

import java.awt.*;
import java.util.*;

public class Collage
{
    public static void main(String[] args)
    {
         //Picture 2 tPic = ;
        
         //initializes variables
         int r = 0, g = 0, b = 0, avgrgb = 0, large = 0, small = 255, interval = 0;
         
         //sets the pictures all as the same one
         Picture pic0 = new Picture("collage/mypicture.jpg");
         Picture pic1 = new Picture("collage/mypicture.jpg");
         Picture pic2 = new Picture("collage/mypicture.jpg");
         Picture pic3 = new Picture("collage/mypicture.jpg");
         
         //initializes an array to use for the pictures
         Pixel[] method1;
         Pixel[] method2;
         Pixel[] custompalette;
         
         //arranges the pixels into an array to use for the pictures
         method1 = pic1.getPixels();
         method2 = pic2.getPixels();
         custompalette = pic3.getPixels();
         
         //displays the original image
         pic0.explore();
         
         //METHOD 1
         for (Pixel m1 : method1){
            r = m1.getRed();
            g = m1.getGreen();
            b = m1.getBlue();
            
            avgrgb = (r + g + b)/3;
            
            if (avgrgb < 64)
                m1.setColor(new Color(0,0,139));
            else if (avgrgb < 128)
                m1.setColor(new Color(255,0,0));
            else if (avgrgb < 192)
                m1.setColor(new Color(173,216,250));
            else
                m1.setColor(new Color(255,255,242));
         }
         //explores the first picture after applying method 1 modifications
         pic1.explore();
         
         
         
         
         //METHOD 2
         for (Pixel m2 : method2){
            r = m2.getRed();
            g = m2.getGreen();
            b = m2.getBlue();
            
            avgrgb = (r + g + b)/3;
            
            if (avgrgb > large)
                large = avgrgb;
            if (avgrgb < small)
                small = avgrgb;
            
            interval = (large - small)/4;
                
            if (avgrgb < interval)
                m2.setColor(new Color(0,0,139));
            else if (avgrgb < (interval*2))
                m2.setColor(new Color(255,0,0));
            else if (avgrgb < (interval*3))
                m2.setColor(new Color(173,216,250));
            else
                m2.setColor(new Color(255,255,242));
         }
         //explores the first picture after applying method 2 modifications
         pic2.explore();
         
         //METHOD 3: Color Palette
         for (Pixel colpal : custompalette){
            r = colpal.getRed();
            g = colpal.getGreen();
            b = colpal.getBlue();
            
            avgrgb = (r + g + b)/3;

            if (avgrgb > large)
                large = avgrgb;
            if (avgrgb < small)
                small = avgrgb;
            
            interval = (large - small)/4;
                
            if (avgrgb < interval)
                colpal.setColor(new Color(139,10,0));
            else if (avgrgb < (interval*2))
                colpal.setColor(new Color(255,127,80));
            else if (avgrgb < (interval*3))
                colpal.setColor(new Color(255,200,160));
            else
                colpal.setColor(new Color(255,255,245));
         }
         //explores the first picture after applying color palette modifications
         pic3.explore();
         
         
    }//main       
}//class
