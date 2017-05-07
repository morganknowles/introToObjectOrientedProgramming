import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lemur here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lemur extends Actor
{

    //Instance variable
    private int speed;
    private static final int NUM_FRAGMENTS = 100;
    /**
     * Constructor method
     */
    public Lemur()
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
            placeSplat(getX(), getY(), NUM_FRAGMENTS);
            getWorld().removeObject(this);
            Greenfoot.playSound("au.wav");
        }//end if
    }//end checkEdge
    
    private void placeSplat(int x, int y, int numFragments)
    {
        for (int i=0; i < numFragments; i++) {
            getWorld().addObject ( new Splat(), x, y );
        }
    }
    
    private void checkVehicle()
    {
        if (isTouching(Vehicle.class))
        {
            getWorld().removeObject(this);
        }
    }//end checkVehicle
}//end class