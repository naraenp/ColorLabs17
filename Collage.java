public class Collage
{
    public static void main (String[] args)
    {
        Picture original = new Picture("collage/thonk.png");
        Picture recursive = new Picture("collage/thonk.png");
        Picture invert = new Picture("collage/thonk.png");
        Picture sepia = new Picture("collage/thonk.png");
        Picture mVertical = new Picture("collage/thonk.png");
        Picture rotate = new Picture("collage/thonk.png");
        
        Picture canvas = new Picture("collage/canvas.jpg");

        //copies original picture
        canvas.copy(original,25,25);

        //copies recursive of picture onto original picture
        canvas.copy(original,225, 25);
        canvas.recursive(recursive,2,225,25);

        //inverts colors
        invert.invert();
        canvas.copy(invert,425,25);

        //converts to grey
        sepia.sepia();
        canvas.copy(sepia,25,225);

        //mirrors over vertical line
        mVertical.mirrorVertical();
        canvas.copy(mVertical,225,225);

        //rotates image 90 degrees clockwise
        canvas.rotate(rotate,425,225);

        canvas.explore();

        canvas.write("collage/naraencollage.jpg");
    }
}