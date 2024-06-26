import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player1 extends Actor
{
    private GreenfootImage[][] walk;
    private GreenfootImage[][] stand;
    private GreenfootImage[][] still1;
    private int counter, dalay, standCounter, side;
    private int checker;
    private int Mana, Counter, ManaChecker;
    private final static int SPEED = 5;
    private int speed;
    private int vSpeed;
    private boolean check;
    private int checkSpace;
    /**
     * This is for initialize  and input all the value for the variable
     */
    public Player1(){
        walk = new GreenfootImage[2][8];
        stand = new GreenfootImage[2][12];
        still1 = new GreenfootImage[2][6];
        counter = 0;
        dalay = 0;
        standCounter = 0;
        side = 0;
        checker = 0;
        Mana = 10;
        Counter = 0;
        ManaChecker = 0;
        speed = 7;
        vSpeed = 5;
        check = false;
        checkSpace = 0;
        for(int j = 1; j <= 8; j++){
            walk[0][j-1] = new GreenfootImage("walk"+j+".png");
            GreenfootImage flap = new GreenfootImage("walk"+j+".png");
            flap.mirrorHorizontally();
            walk[1][j-1] = flap;
        }
        for(int j = 1; j <= 12; j++){
            stand[0][j-1] = new GreenfootImage("stand" + j +  ".png");
            GreenfootImage flap = new GreenfootImage("stand"+j+".png");
            flap.mirrorHorizontally();
            stand[1][j-1] = flap;
        }
        for(int j = 1; j <= 6; j++){
            still1[0][j-1] = new GreenfootImage("skill1_"+j+".png");
            GreenfootImage flap = new GreenfootImage("skill1_"+j+".png");
            flap.mirrorHorizontally();
            still1[1][j-1] = flap;
        }
        setImage(stand[side][standCounter]);
    }

    public void act()
    {
        // Add your action code here.
        checkOutScreen();
        Anmation();
        CheckHit();
        trackMana();
        falling();
    }

    /**
     * Method checkOutScreen
     * Check and to make sure that player can not go though the Edge
     */
    public void checkOutScreen(){
        if(getX() > 1050){
            move(-5);
        }else if(getX() < 0){
            move(5);
        }
    }

    /**
     * Method Anmation
     * Animation for walk, skill, jump and stand
     */
    public void Anmation(){
        if(Greenfoot.isKeyDown("a")&&checker == 0){
            Walk("left");
        }else if(Greenfoot.isKeyDown("d") && checker == 0){
            Walk("right");
        }else if(Greenfoot.isKeyDown("q")||checker == 1){
            Skill1();
            checker = 1;
            Skill1Animation(side);
        }else{
            dalay++;
            counter = 0;
            if(dalay % SPEED == 0){
                setImage(stand[side][standCounter]);
                if(standCounter == 11){
                    standCounter = 0;
                    dalay = 0;
                }
                else
                    standCounter++;
            }
        }
        if(Greenfoot.isKeyDown("space") && checkSpace <= 2){
            moveUp();
        }else{
            check = false;
        }
    }

    /**
     * Method falling
     * Falling's main method
     */
    private void falling(){
        if(isTouching(Floor.class)){
            checkSpace = 0;
            vSpeed = 0;
            return;
        }
        checkGround();
    }

    /**
     * Method moveUp
     * Jumping Method
     */
    private void moveUp()
    {
        if(check == false && checkSpace < 2){
            vSpeed = -20;
            fall();
            checkSpace++;
            check = true;
        }
    }

    /**
     * Method fall
     * falling/gravity Method
     */
    public void fall(){
        setLocation(getX(),getY()+vSpeed);
        vSpeed += 2;
    }

    /**
     * Method checkGround
     * Check if the player is on the Ground object or not
     */
    public void checkGround(){
        Actor Gunder = getOneObjectAtOffset(0, getImage().getHeight()/2, Ground.class);
        if(Gunder == null){
            fall();
        }else{
            Ground s = (Ground)getOneIntersectingObject(Ground.class);
            vSpeed = 5;
            if(s != null){
                if(s.getSide() == 1){
                    move(5);
                }else{
                    move(-5);
                }
            }
        }
    }

    /**
     * Method CheckHit
     * Check if the player got hit or not
     * And also calculate how much damage it need to take
     */
    public void CheckHit(){
        Actor Hit = getOneObjectAtOffset(0, 30, Player2_Skill1  .class);
        if(Hit != null){
            Player2 d = (Player2)getOneIntersectingObject(Player2.class);
            if(d != null){
                ((MyWorld)getWorld()).sub_Health("P1",(Greenfoot.getRandomNumber(d.damage()+1)+1)*3);
            }
        }
    }

    /**
     * Method Skill1
     * Skill animation main method
     */
    public void Skill1(){
        if(checker == 0){
            if(Mana > 0){
                Mana = Mana / 2;
                getWorld().addObject(new P1Mana(Mana), 10, 0);
                getWorld().addObject(new Player1_Skill1  (side), getX(), getY());

            }else{
                ManaChecker = 1;
            }
        }
    }

    /**
     * Method trackMana
     * Add Mana if it is less then 10
     * the speed for this is every 100 iteration
     */
    public void trackMana(){
        if (Mana < 10){
            Counter++;
            if (Counter % 100 == 0){
                Mana++;
                if(Mana > 0){
                    ManaChecker = 0;
                }
                getWorld().addObject(new P1Mana(Mana), 10, 0);
            }
            if (Mana >= 10){
                Mana = 10;
                Counter = 0;
            }
        }
    }

    /**
     * Method Skill1Animation
     *
     * skill main Animation method
     * and the parameter for is just for keep track on which side the player are facing to
     */
    public void Skill1Animation(int faceSide){
        if(ManaChecker == 0){
            dalay++;
            if(dalay % SPEED == 0){
                if(counter >= 5){
                    counter = 0;
                    checker = 0;
                }
                setImage(still1[faceSide][counter]);
                counter++;
            }
        }else{
            checker = 0;
        }
    }

    /**
     * Method Walk
     * 
     * Walk Animation main method
     * and the parameter for is just for keep track on which side the player are facing to
     */
    public void Walk(String faceSide){
        if(faceSide == "left"){
            side = 1;
            dalay++;
            if(dalay % SPEED == 0){
                setImage(walk[1][counter]);
                move(-10);
                if(counter >= 7)
                    counter = 0;
                else
                    counter++;
            }
        }else if(faceSide == "right"){
            side = 0;
            dalay++;
            if(dalay % SPEED == 0){
                setImage(walk[0][counter]);
                move(10);
                if(counter >= 7)
                    counter = 0;
                else
                    counter++;
            }
        }
    }

    /**
     * Method damage
     *
     * return the Mana
     * This is use for let player2 calculate the damage
     */
    public int damage(){
        return Mana;
    }
}
