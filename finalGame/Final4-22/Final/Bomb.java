import greenfoot.*;

/**
 * The Bomb spins and moves towards the bottom of the world.
 * If the Bomb hits the Vehicle then its game over.
 */
public class Bomb extends Actor
{
    //Instance variable
    private int speed;
  
    /**
     * Constructor method. Sets the speed and rotation of the Bomb.
     */
    public Bomb()
    {
        speed = 1;
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
    
    /**
     * If the Bomb is at the edge of the world, the Bomb disappears.
     */

    private void checkEdge()
    {
        if (isAtEdge()) 
        {
            getWorld().removeObject(this);
        }//end if
    }//end checkEdge
}//end class