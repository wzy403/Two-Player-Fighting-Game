import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ground here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ground extends Actor
{
    private int side;
    private int trans;
    private int swich;

    /**
     * Ground Constructor
     * Initialize the value for all the variable in this class
     */
    public Ground(){
        side = 1;
        trans = 255;
        swich = 0;
    }

    /**
     * Act - do whatever the Ground wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        movement();
        touchingEdge();
        SetTrans();
    }

    /**
     * Method SetTrans
     * Change the Transparency
     * From 225 - 0 than 0 - 225
     */
    public void SetTrans(){
        if(swich == 0){
            trans += 1;
            if(trans > 255){
                swich = 1;
                trans = 255;
            }
            getImage().setTransparency(trans);
        }else{
            getImage().setTransparency(trans);
            trans -= 1;
            if(trans < 0){
                swich = 0;
                trans = 0;
            }
        }
    }

    /**
     * Method movement
     * Make the Ground move back and forth
     */
    public void movement(){
        if(side == 1){
            move(5);
        }else{
            move(-5);
        }
    }

    /**
     * Method touchingEdge
     * Keep track of the ground for which side it should be move right now
     */
    public void touchingEdge(){
        if(isAtEdge()){
            switch(side){
                case 1:
                    side = 0;
                    break;
                case 0:
                    side = 1;
                    break;
            }
        }
    }

    /**
     * Method getSide
     *
     * Return what side the Ground are moving right now
     * then when the player stand on this object it can follow this to move around
     */
    public int getSide(){
        return side;
    }
}
