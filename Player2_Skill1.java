import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player2_Skill1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player2_Skill1 extends Player2
{   private int counter;
    private int side;
    
    /**
     * Player2_Skill1   Constructor
     *
     * Initialize all the variable
     */
    public Player2_Skill1  (int dir){
        counter = 0;
        setImage(new GreenfootImage(10,50));
        side = dir;
    }

    /**
     * Act - do whatever the Player2_Skill1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        MoveDir();
    }
    
    /**
     * Method MoveDir
     * 
     * Keep trake the Direction and how long this object should stay
     */
    public void MoveDir(){
        if(side == 1){
            counter++;
            move(10);
            if(counter >= 27){
                getWorld().removeObject(this);
            }
        }else{
            counter++;
            move(-10);
            if(counter >= 27){
                getWorld().removeObject(this);
            }
        }
    }
}
