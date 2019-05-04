public class Collage
{
    public static void main (String[] args)
    {
        Picture mypicture = new Picture("images/mypicture.jpeg");
        Picture canvas = new Picture("images/canvas.jpeg");

        //copies original picture
        canvas.copy(mypicture,0,0);

        //copies recursive of picture onto original picture
        canvas.recursive(mypicture,2,0,0);

        //inverts colors
        mypicture.invert();
        canvas.copy(mypicture,700,0);

        //converts to grey
        mypicture.gray();
        canvas.copy(mypicture,1400,0);

        //mirrors over vertical line
        mypicture.mirrorVertical();
        canvas.copy(mypicture,0,700);

        //mirrors over horizontal line
        mypicture.mirrorHorizontal();
        canvas.copy(mypicture,700,700);

        //rotates image 90 degrees clockwise
        canvas.rotate(mypicture,1400,700);

        canvas.explore();

        canvas.write("images/finalcollege.jpg");
    }
}