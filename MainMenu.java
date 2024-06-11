import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MainMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainMenu extends World
{

    /**
     * Constructor for objects of class MainMenu.
     * This will setup the text and button(start button) for the start Menu/MainMenu screen
     */
    public MainMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 360, 1);
        showText("Welcome to the\nLowest budget fighting Game!", getWidth() / 2, getHeight() / 2 - 80);
        showText("~Click the Button below to start the game~",getWidth() / 2, getHeight() / 2);
        addObject(new Start(), 499, 272);
    }
}
