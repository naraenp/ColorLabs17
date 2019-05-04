public class Collage
{
    public static void main (String[] args)
    {
        Picture original = new Picture("collage/thonk.jpg");
        Picture recursive = new Picture("collage/thonk.jpg");
        Picture invert = new Picture("collage/thonk.jpg");
        Picture gray = new Picture("collage/thonk.jpg");
        Picture mVertical = new Picture("collage/thonk.jpg");
        Picture rotate = new Picture("collage/thonk.jpg");
        
        Picture canvas = new Picture("collage/canvas.jpg");

        
        
        //copies original picture
        canvas.copy(original,25,25);

        //copies recursive of picture onto original picture
        canvas.recursive(recursive,2,125,25);

        //inverts colors
        invert.invert();
        canvas.copy(invert,225,25);

        //converts to grey
        gray.gray();
        canvas.copy(gray,25,125);

        //mirrors over vertical line
        mVertical.mirrorVertical();
        canvas.copy(mVertical,125,125);

        //rotates image 90 degrees clockwise
        canvas.rotate(rotate,225,125);

        canvas.explore();

        canvas.write("collage/naraencollage.jpg");
    }
}