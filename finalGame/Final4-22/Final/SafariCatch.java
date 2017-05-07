import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
* Morgan Knowles
*/
public class SafariCatch extends World
{
    private int saved;
    private int lost;
    private int time;
    private int timerA = 0;
    private int timerB = 0;
    private int aCount;
    
    // Constructor for objects of class SafariCatch
    public SafariCatch()
    {    
        // Create a new world with 976x420 cells with a cell size of 1x1 pixels.
        super(976, 420, 1); 
        makeVehicle();
        saved = 0;
        time = 0;
        lost = 0;
        showSaved();
        showLost();
        showTime();
        
    }//end safariCatch
    
    public void act()
    {
        timerA++; 
        timerB++;
        //makeBomb();
        countTime();
        makeAnimals();
    }//end act
    
    /**
     * Make a Vehicle in the bottom middle of the world.
     */
    public void makeVehicle()
    {
        Vehicle vehicle = new Vehicle();
        addObject(vehicle, 300, 375);
    }//end makeVehicle
    
    /**
     * When timerB reaches 55 play a sound and continue counting.
     * When timerB reaches 60 set timerB back to 0 and add one Bomb.
     */
     public void makeBomb()
    {
       if (timerB > 55)
       {
           Greenfoot.playSound("flyby.wav");
       }//end if
       if (timerB > 60)
       {
           
           timerB = 0;
           
           Bomb bomb = new Bomb();
           addObject (bomb, Greenfoot.getRandomNumber(750), 0);
           
       }//end if
    }//end makeBarrel
    
    /**
     * When timerA reaches 11 set timerA back to 0 and add one random Animal in a random location. 
     */
    public void makeAnimals()
    {
        if (timerA > 11)
        {
            timerA = 0;
            Animal animal = new Animal(Greenfoot.getRandomNumber(5));
            addObject(animal, Greenfoot.getRandomNumber(750), 0);
       }//end if
    }//end makeAnimals
    
    /**
     * Count how namy animals have been lost.
     */
       public void addLost(int points)
    {
        lost = lost + points;
        showLost();
    }//end addScore
    
    /**
     * Count how many animals have been saved.
     */
    public void addSaved(int points)
    {
        saved = saved + points;
        showSaved();
        if (saved < 0) 
        {
            Greenfoot.playSound("au.wav");
            Greenfoot.stop();
        }//end if
    }//end addScore
    
    /**
     * Count down the game time and display it. Stop the game 
     * with a message when time is up.
     */
    private void countTime()
    {
        time++;
        showTime();
        if (time == 1500)
        {
            Greenfoot.stop();
            showGameOver(10000);
        }//end if
    }//end counttime
    
    /**
     * Count the animals.
     */
    public void animalCount(int points)
    {
        aCount = aCount + points;
    }//end animalCount
    
    /**
    * Show how many animals have been saved.
    */
    private void showSaved()
    {
        showText("Animals Saved: " + saved, 860, 35);
    }//end showSaved
    
    /**
    * Show how many Animals have been lost on screen.
    */
    private void showLost()
    {
        showText("Animals Lost: " + lost, 850, 75);
    }//end showLost
    
    /**
     * Show the remaining game time on screen.
     */
    private void showTime()
    {
        showText("Time: " + time, 815, 55);
    }//end showtime
    
     /**
     * Create GameOver image (balloons) on the left side of the world 
     * and show Final score percentage
     * The for is simalar to the way stars are created in the Asteroid scenario
     */
    private void showGameOver(int number) 
    {
        showText("Final Score:" + saved*100/aCount + "%", 855,300);
        GreenfootImage background = getBackground();   
        for(int i=0; i < number; i++) 
        {
             int x = Greenfoot.getRandomNumber( getWidth() );
             int y = Greenfoot.getRandomNumber( getHeight() );
             
            GameOver gameover = new GameOver(Greenfoot.getRandomNumber(3));
            addObject(gameover,Greenfoot.getRandomNumber(750), Greenfoot.getRandomNumber(420));
        }//end for
    }//end showGameOver
}//end world
