//Naraen Palanikumar
//10.26.2018
//The Color Lab
//Takes a picture an manipulates the colors of pixels to achieve a certain effect

//IMPORT SECTION
import java.awt.*;
import java.util.*;
import java.util.List;
import java.lang.Math;

public class ColorLabNaraen
{
    public static void main(String[] args)
    {
        int r = 0;
        int g = 0;
        int b = 0;
        int avgcol = 0;
        int absr = 0, absg = 0, absb = 0;
        
        Picture pic = new Picture("images/gfield.jpg");
        Picture pic1 = new Picture("images/gfield.jpg");
        Picture pic2 = new Picture("images/gfield.jpg");
        Picture pic3 = new Picture("images/gfield.jpg");
        Picture pic4 = new Picture("images/gfield.jpg");
        Picture pic5 = new Picture("images/gfield.jpg");
        Picture pic6 = new Picture("images/gfield.jpg");
        Picture pic7 = new Picture("images/gfield.jpg");

        Pixel[] pix;
        pix = pic.getPixels();
        
        Pixel[] pix1;
        pix1 = pic1.getPixels();
        
        Pixel[] pix2;
        pix2 = pic2.getPixels();
        
        Pixel[] pix3;
        pix3 = pic3.getPixels();
        
        Pixel[] pix4;
        pix4 = pic4.getPixels();
        
        Pixel[] pix5;
        pix5 = pic5.getPixels();
        
        Pixel[] pix6;
        pix6 = pic6.getPixels();
        
        Pixel[] pix7;
        pix7 = pic7.getPixels();
        
        
        //displays original without edits
        pic.explore();
        
        for (Pixel zero : pix){
            zero.setRed(255);
        }
        //for and statement max red in pixels
        pic.explore();
        
        for (Pixel one : pix1){
            r = one.getRed();
            g = one.getGreen();
            b = one.getBlue();
            
            one.setRed(255-r);
            one.setGreen(255-g);
            one.setBlue(255-b);
        }
        //negates pixels for pic1
        pic1.explore();
        
        for (Pixel two : pix2){
            r = two.getRed();
            g = two.getGreen();
            b = two.getBlue();
            
            avgcol = ((r + g + b)/3);
            
            two.setRed(avgcol);
            two.setGreen(avgcol);
            two.setBlue(avgcol);
        }
        //sets pic2 to grayscale
        pic2.explore();
        
        for (Pixel three : pix3){
            r = three.getRed();
            g = three.getGreen();
            b = three.getBlue();
            
            if(r > 50)
                three.setRed(r-50);
            else
                three.setRed(0);
            
            if(g > 50)
                three.setGreen(g-50);
            else
                three.setGreen(0);
                
            if(b > 50)
                three.setBlue(b-50);
            else
                three.setBlue(0);
        }
        //lightens pixels in pix3
        pic3.explore();
        
        for (Pixel four : pix4){
            r = four.getRed();
            g = four.getGreen();
            b = four.getBlue();
            
            absr = Math.abs(r-160);
            absg = Math.abs(g-120);
            absb = Math.abs(b-100);
            
            if (absr<30 && absg<30 && absb<30){
                    four.setRed(50);
                    four.setBlue(25);
                    four.setBlue(100);
                 }
        }
        //colorifies pic4
        pic4.explore();
        
        for (Pixel five : pix5){
            r = five.getRed();
            g = five.getGreen();
            b = five.getBlue();
            
            
            five.setRed(g);
            five.setGreen(b);
            five.setBlue(r);
        }
        //swap3
        pic5.explore();
        
        for (Pixel six : pix6){
            r = six.getRed();
            g = six.getGreen();
            
            six.setRed(g);
            six.setGreen(r);
        }
        //swap2
        pic6.explore();

    }
}
