import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{

    /**
     * Constructor for objects of class GameOver.
     * This will set up text and button for the GameOver screen
     */
    public GameOver(int win)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 360, 1); 
        showText("Congratulations!\nPlayer "+ win +" wins!", getWidth() / 2, getHeight() / 2 - 50);
        showText("Restart the Game",getWidth() / 2, getHeight() / 2 + 50);
        addObject(new Restart(), 503, 292);
    }
}
