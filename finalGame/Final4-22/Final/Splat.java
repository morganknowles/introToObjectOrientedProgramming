import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * Pieces of animals, flying around.
 * 
 * I'm using this code from the book scenario Explosion.
 * @author mik
 * @version 1.0
 * 
 */
public class Splat extends SmoothMover
{
    private static final Vector GRAVITY = new Vector(90, 1.5);
    private static final int FORCE = 15;
    
    public Splat()
    {
        int direction = Greenfoot.getRandomNumber(360);
        int speed = Greenfoot.getRandomNumber(FORCE);
        increaseSpeed( new Vector(direction, speed));
        
        // random image size
        GreenfootImage img = getImage();
        int width = Greenfoot.getRandomNumber(30) + 1;
        int height = Greenfoot.getRandomNumber(30) + 1;
        img.scale (width, height);
        
        setRotation (Greenfoot.getRandomNumber(360));
    }
    
    /**
     * Act - do whatever the Debris wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        increaseSpeed(GRAVITY);
        move();
    }    
}
