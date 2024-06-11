import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyWorld extends World {
    private int P1Health = 100;
    private int P2Health = 100;
    private int win;

    /**
     * Constructor for objects of class MyWorld.
     * This also initialized what need to display on screen
     */
    public MyWorld() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 360, 1,false);
        addObject(new Backround(), getWidth() / 2, getHeight() / 2);
        addObject(new Player1(), 119, 210);
        addObject(new Player2(), 947, 234);
        addObject(new Ground(), getWidth() / 2, getHeight() / 3+20);
        addObject(new Floor(), -288, 350);
        addObject(new Floor(), 280, 350);
        addObject(new Floor(), 848, 350);
        addObject(new P1Mana(), 10, 0);
        addObject(new P2Mana(), 800, 0);
        showText("Player1 Health: " + P1Health, 100, 20);
        showText("Player2 Health: " + P2Health, 900, 20);
    }

    public void act() {
        checkHealth();
    }

    /**
     * Method sub_Health
     * This is to subtract the Health when calling it from other class
     */
    public void sub_Health(String player, int damage) {
        if (player == "P1") {
            P1Health-= damage;
            showText("Player1 Health: " + P1Health, 100, 20);
        } else {
            P2Health-= damage;
            showText("Player2 Health: " + P2Health, 900, 20);
        }
    }

    /**
     * Method checkHealth
     * Check if one player's health below 0, the game will end.
     */
    public void checkHealth(){
        if(P2Health <= 0){
            Greenfoot.playSound("game over.mp3");
            win = 1;
            Greenfoot.setWorld(new GameOver(win));
        }else if(P1Health <= 0){
            Greenfoot.playSound("game over.mp3");
            win = 2;
            Greenfoot.setWorld(new GameOver(win));
        }
    }
}
