import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Vehicle collects the animals. 
 * 
 * @author Morgan Knowles
 */
public class Vehicle extends Actor
{
    //instance variables
    private GreenfootImage image1;
    private GreenfootImage image2;
    private int speed;
    
    public Vehicle()
    {
        image1 = new GreenfootImage("vehicle.png");
        image2 = new GreenfootImage("vehicleleft.png");
        setImage(image1);
        speed = 10;
    }//end Vehicle
    
    public void act() 
    {
        checkBomb();
        checkKeyPress();
        checkBoard();
    }//end act
    
    /**
     * Check whether a keyboard key has been pressed and react if it has.
     */
    private void checkKeyPress()
    {
    if (Greenfoot.isKeyDown("right")) 
        {
            setLocation(getX()+speed, getY());
            setImage(image1);
        }//end if
        
    if (Greenfoot.isKeyDown("left")) 
        {
          setLocation(getX()-speed, getY());
           setImage(image2);
        }//end if
    }//end checkkeypress

    /**
     * Ensure that the Vehicle does not drive into the
     * right edge of the world that contains the game info. If the 
     * Vehicle tries to drive into it, it will be returned to its 
     * starting place.
     */
    private void checkBoard()
    {
       if (getX() == 720)
       {
           setLocation(300,375);
        }//end if
    }//end checkBoard
    
    /**
     * Check to see if the a Bomb is touching the Vehicle. If this
     * is true, then the game is stopped.
     */
    private void checkBomb()
    {
        if (isTouching(Bomb.class))
        {
            Greenfoot.playSound("explosion.wav");
            setLocation(300,475);//this hides the vehicle behind the explosion 
            SafariCatch safaricatch = (SafariCatch)getWorld();
            Explosion explosion = new Explosion();
            safaricatch.addObject(explosion, 370, 225);
            Greenfoot.stop();
            youLose();
            return;
        }//end if
    }//end checkBomb
    
    /**
     * This shows the Lose message. 
     */
    private void youLose()
    {
        SafariCatch safaricatch = (SafariCatch)getWorld();
        Lose lose = new Lose();
        safaricatch.addObject(lose, 250, 100);
    }//end youLose
}//end class
