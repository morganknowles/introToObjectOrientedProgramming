import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *Class GameOver holds images of three balloons that are shown when the game is over.
 */
public class GameOver extends Actor
{
    public int balloonNumber;
    static GreenfootImage[] images = { new GreenfootImage("balloon1.png"),
                                       new GreenfootImage("balloon2.png"),
                                       new GreenfootImage("balloon3.png"),};
                                    
    public GameOver(int bNum)
    {
        balloonNumber = bNum;
        setImage(images[bNum]);
    }

    public void act() 
    {
    }    
}
