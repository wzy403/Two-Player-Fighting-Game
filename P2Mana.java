import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class P1Mana here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class P2Mana extends Player2 {
    GreenfootImage img;
    private int Counter = 0;
    Font ManaDissplay = new Font(16);
    
    /**
     * P2Mana Constructor
     *
     * This Constructors is for update the Mana show on the screen
     */
    public P2Mana(int Mana){
        img = new GreenfootImage(1000, 100);
        img.setColor(Color.RED);
        String ManaCount = "Mana: ";
        for (int i = 0; i < Mana; i++) {
            ManaCount += "○";
        }
        img.setFont(ManaDissplay);
        img.drawString(ManaCount, 500, 100);
        setImage(img);
    }

    /**
     * P2Mana Constructor
     * This Constructors is for initial value at start(which is 10 Mana for start)
     */
    public P2Mana(){
        img = new GreenfootImage(1000, 100);
        img.setColor(Color.RED);
        img.setFont(ManaDissplay);
        img.drawString("Mana: ○○○○○○○○○○", 500, 100);
        setImage(img);
    }

    /**
     * Act - do whatever the P1Mana wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * 
     * remove the old P1Mana class when update it
     * 
     */
    public void act() {
        // Add your action code here.
        if(isTouching(P2Mana.class)){
            getWorld().removeObject(this);
        }
    }
}
