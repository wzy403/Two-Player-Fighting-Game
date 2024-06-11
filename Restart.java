import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Restart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Restart extends Actor
{
    public Restart(){
        
    }
    
    /**
     * Act - do whatever the Restart wants to do. This method is called whenever
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
     * If clicked swich to MainMenu screen
     */
    public void click(){
        if(Greenfoot.mousePressed(this)){
            Greenfoot.setWorld(new MainMenu());
        }
    }
}
