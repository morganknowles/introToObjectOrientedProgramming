import greenfoot.*;

/**
 * Write a description of class Giraffe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Giraffe extends Actor
{
      //Instance variable
    private int speed;
    
    /**
     * Constructor method
     */
    public Giraffe()
    {
        speed = Greenfoot.getRandomNumber(2) + 1;
        setRotation(Greenfoot.getRandomNumber(360));
        GreenfootImage image = getImage();
        image.scale(image.getWidth() - 250, image.getHeight() - 250);
        setImage(image);
        
    
    }//end constructor
    
    /**
     * Fall from the sky, slowly rotating.
     */
    public void act() 
    {
        setLocation(getX()- speed , getY()+15);
        turn(1);
        checkEdge();
        
    }//end act  
    
    private void checkEdge()
    {
    if (isAtEdge()) 
        {
            getWorld().removeObject(this);
            Greenfoot.playSound("au.wav");
        }//end if
    }//end checkEdge
}//end class
