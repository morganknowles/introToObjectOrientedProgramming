import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is an animal class that holds the different animal images for this game.
 * All of the animals do the same thing but they get different images in the world.
 * 
 * 
 * Morgan Knowles
 */

public class Animal extends Actor
{
    //Instance variable
    private int speed;
    public int animalNumber;
    private static final int NUM_FRAGMENTS = 100;
    //these are the images for the animals
    static GreenfootImage[] images = { new GreenfootImage("lion.png"),
                                       new GreenfootImage("tiger.png"),
                                       new GreenfootImage("giraffe.png"),
                                       new GreenfootImage("zebra.png"), 
                                       new GreenfootImage("lemur.png")};                               
    /**
    * Constructor method
    */
    public Animal(int aNum)
    {
        animalNumber = aNum;
        setImage(images[aNum]);
        speed = (1);
        setRotation(Greenfoot.getRandomNumber(360));
    }//end constructor
    
    /**
    * Fall from the sky, slowly rotating.
    */
    public void act() 
    {
        if (isTouching(Vehicle.class))//this method is in act because actor not in world issues
        {
           addSaved();
           getWorld().removeObject(this);
           return;
            
        }//end if
        setLocation(getX()- speed , getY()+5);
        turn(1);
        checkEdge();
    }//end act   
    
    /**
    * Check to see if the Animal has reached the edge. 
    * If it has, placeSplat, remove Animal, and play a sound.
    * 
    */
    private void checkEdge()
    {
    if (getY() == 400) 
        {
            addLost();
            placeSplat(getX(), getY(), NUM_FRAGMENTS);
            getWorld().removeObject(this);
            Greenfoot.playSound("au.wav");
        }//end if
    }//end checkEdge
    
    /**
     * Add saved animal count to the world.
     */
    private void addSaved()
    {
        SafariCatch safaricatch = (SafariCatch)getWorld();
            safaricatch.addSaved(1);
            safaricatch.animalCount(1);
    }//end addSaved
        
    /**
     * Add lost animal count to the world.
     */
    private void addLost()
    {
        SafariCatch safaricatch = (SafariCatch)getWorld();
            safaricatch.addLost(1);
            safaricatch.animalCount(1);
    }//end addLost
    
    /**
    * placeSplat is similar to Debris from Explosion.
    */
    private void placeSplat(int x, int y, int numFragments)
    {
        for (int i=0; i < numFragments; i++) {
            getWorld().addObject ( new Splat(), x, y );
        }//end for
    }//end placeSplat
}//end class