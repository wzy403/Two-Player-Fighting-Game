import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Start here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Start extends Actor
{
    /**
     * Act - do whatever the Start wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        click();
    }
    
    /**
     * Method click
     *
     * If clicked swich to MyWorld screen
     */
    public void click(){
        if(Greenfoot.mousePressed(this)){
            Greenfoot.playSound("ready go.mp3");
            Greenfoot.setWorld(new MyWorld());
        }
    }
}
