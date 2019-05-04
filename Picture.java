
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

    public void copy (Picture sourcePicture, int xpos, int ypos)
    {
        Pixel sourcePixel = null;
        Pixel targetPixel = null;

        for (int sourceX = 0, targetX = xpos;sourceX < sourcePicture.getWidth();sourceX++, targetX++)
        {
            for (int sourceY = 0, targetY = ypos;sourceY < sourcePicture.getHeight();sourceY++, targetY++)
            {
                sourcePixel = sourcePicture.getPixel(sourceX, sourceY);
                targetPixel = this.getPixel(targetX, targetY);

                targetPixel.setColor(sourcePixel.getColor());
            }
        }
    }

    public void recursive(Picture sourcePicture, int divide, int xpos, int ypos)
    {
        Pixel sourcePixel = null;
        Pixel targetPixel = null;

        if (divide > 17)
            return;
        else
        {          
            for (int sourceX = 0, targetX = xpos; sourceX < sourcePicture.getWidth(); sourceX += divide, targetX++)
            {
                for (int sourceY = 0, targetY = ypos;sourceY < sourcePicture.getHeight();sourceY += divide, targetY++)
                {
                    sourcePixel = sourcePicture.getPixel(sourceX, sourceY);
                    targetPixel = this.getPixel(targetX, targetY);

                    targetPixel.setColor(sourcePixel.getColor());
                }
            }

            //increasing divide increases the amount the image is divided
            divide++;
            //recursively called
            recursive(sourcePicture,divide,xpos,ypos);
        }
    }

    public void invert()
    {
        //creates an array of pixels p
        Pixel[] p = this.getPixels();

        for (Pixel i: p)
        {
            i.setRed((255-i.getRed()));
            i.setBlue((255-i.getBlue()));
            i.setGreen((255-i.getGreen()));
        }
    }

    public void sepia()
    {  
        //creates an array of pixels p
        Pixel[] p = this.getPixels();

        for (Pixel i: p)

        {
            //Found the formula for making a sepia image from this link
            //https://www.dyclassroom.com/image-processing-project/how-to-convert-a-color-image-into-sepia-image
            int r = i.getRed(); 
            int g = i.getGreen();
            int b = i.getBlue();

            double tr = 0.393*r + 0.769*g + 0.189*b;
            double tg = 0.349*r + 0.686*g + 0.168*b;
            double tb = 0.272*r + 0.534*g + 0.131*b;
            
            if (tr > 255)
                i.setRed(255);
            else
                i.setRed((int)tr);
            
            if (tg > 255)
                i.setGreen(255);
            else
                i.setGreen((int)tg);
            
            if (tg > 255)
                i.setBlue(255);
            else
                i.setBlue((int)tb);
        }
    }

    public void mirrorVertical()
    {
        int width = this.getWidth();
        int mirrorPoint = width/2;

        Pixel leftPixel = null;
        Pixel rightPixel = null;

        for (int y = 0; y < getHeight(); y++) //loops from top to bottom
        {
            for (int x = 0; x < mirrorPoint; x++) //loops from left to mid point
            {
                leftPixel = getPixel(x,y);
                rightPixel = getPixel(width-1-x,y);
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }

    public void rotate (Picture sourcePicture,int xpos, int ypos)
    {
        Pixel sourcePixel = null;
        Pixel targetPixel = null;

        for (int sourceX = 0, targetY = ypos;sourceX < sourcePicture.getWidth();sourceX++, targetY++)
        {
            for (int sourceY = 0, targetX = sourcePicture.getHeight()+xpos;sourceY < sourcePicture.getHeight();sourceY++, targetX--)
            {
                sourcePixel = sourcePicture.getPixel(sourceX, sourceY);
                targetPixel = this.getPixel(targetX, targetY);

                targetPixel.setColor(sourcePixel.getColor());
            }               
        }
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

    public static void main(String[] args)
    {
        String fileName = FileChooser.pickAFile();
        Picture pictObj = new Picture(fileName);
        pictObj.explore();
    }
} // this } is the end of class Picture, put all new methods before this
