import greenfoot.*;

/**
 * Write a description of class Tiger here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tiger extends Actor
{
    //Instance variable
    private int speed;
    
    /**
     * Constructor method
     */
    public Tiger()
    {
        speed = Greenfoot.getRandomNumber(2) + 1;
        setRotation(Greenfoot.getRandomNumber(360));
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
