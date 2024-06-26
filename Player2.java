import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player2 extends Actor
{
    private GreenfootImage[][] walk;
    private GreenfootImage[][] run;
    private GreenfootImage[][] stand;
    private GreenfootImage[][] still1;
    private int counter, dalay, standCounter, side;
    private int checker, runChecker;
    private int Mana, Counter, ManaChecker;
    private final static int SPEED = 5;
    private int speed;
    private int vSpeed;
    private boolean check ;
    private int checkSpace;
    /**
     * This is for initialize  and input all the value for the variable
     */
    public Player2(){
        walk = new GreenfootImage[2][8];
        run = new GreenfootImage[2][6];
        stand = new GreenfootImage[2][2];
        still1 = new GreenfootImage[2][8];
        counter = 0;
        dalay = 0;
        standCounter = 0; 
        side = 0;
        checker = 0;
        runChecker = 0;
        Mana = 10;
        Counter = 0;
        ManaChecker = 0;
        speed = 7;
        vSpeed = 5;
        check = false;
        checkSpace = 0;
        for(int j = 1; j <= 8; j++){
            walk[1][j-1] = new GreenfootImage("Player2_walk"+j+".gif");
            GreenfootImage flap = new GreenfootImage("Player2_walk"+j+".gif");
            flap.mirrorHorizontally();
            walk[0][j-1] = flap;
        }
        for(int j = 1; j <= 2; j++){
            stand[1][j-1] = new GreenfootImage("Player2_stand"+j+".png");
            GreenfootImage flap = new GreenfootImage("Player2_stand"+j+".png");
            flap.mirrorHorizontally();
            stand[0][j-1] = flap;
        }
        for(int j = 1; j <= 8; j++){
            still1[1][j-1] = new GreenfootImage("Player2_skill1_"+j+".png");
            GreenfootImage flap = new GreenfootImage("Player2_skill1_"+j+".png");
            flap.mirrorHorizontally();
            still1[0][j-1] = flap;
        }
        for(int i = 1; i <= 6; i++){
            run[1][i-1] = new GreenfootImage("run"+i+".png");
            GreenfootImage flap = new GreenfootImage("run"+i+".png");
            flap.mirrorHorizontally();
            run[0][i-1] = flap;
        }
        setImage(stand[side][standCounter]);
    }

    public void act()
    {
        // Add your action code here.
        checkOutScreen();
        trackMana();
        Anmation();
        CheckHit();
        falling();
    }

    /**
     * Method checkOutScreen
     * Check and to make sure that player can not go though the Edge
     */
    public void checkOutScreen(){
        if(getX() > 1050){
            move(-5);
        }else if(getX() < -50){
            move(5);
        }
    }

    /**
     * Method Anmation
     * Animation for walk, skill, jump, run and stand
     */
    public void Anmation(){
        if(Greenfoot.isKeyDown("Left")&&checker == 0){
            if(Greenfoot.isKeyDown("L")){
                if(runChecker == 0){
                    counter = 0;
                    runChecker = 1;
                }
                Run("left");
            }else{
                runChecker = 0;
                Walk("left");
            }
        }else if(Greenfoot.isKeyDown("Right") && checker == 0){
            if(Greenfoot.isKeyDown("L")){
                if(runChecker == 0){
                    counter = 0;
                    runChecker = 1;
                }
                Run("right");
            }else{
                runChecker = 0;
                Walk("right");
            }
        }else if(Greenfoot.isKeyDown("p")||checker == 1){
            Skill1();
            checker = 1;
            Skill1Animation(side);            
        }else{
            dalay++;
            counter = 0;
            if(dalay % SPEED == 0){
                setImage(stand[side][standCounter]);
                if(standCounter >= 1){
                    standCounter = 0;
                    dalay = 0;
                }
                else
                    standCounter++;
            }
        }
        if(Greenfoot.isKeyDown("up") && checkSpace <= 2){
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
     * Method fall
     * falling/gravity Method
     */
    public void fall(){
        setLocation(getX(),getY()+vSpeed);
        vSpeed += 2;
    }

    /**
     * Method CheckHit
     * Check if the player got hit or not
     * And also calculate how much damage it need to take
     */
    public void CheckHit(){
        Actor Hit = getOneObjectAtOffset(getImage().getWidth()/2, 0, Player1_Skill1  .class);
        if(Hit != null){
            Player1 a = (Player1)getOneIntersectingObject(Player1.class);
            if(a != null){
                ((MyWorld)getWorld()).sub_Health("P2",(Greenfoot.getRandomNumber(a.damage()+1)+1)*3);
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
                getWorld().addObject(new P2Mana(Mana), 800, 0);
                getWorld().addObject(new Player2_Skill1  (side), getX(), getY());
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
        if (Mana <= 10){
            Counter++;
            if (Counter % 100 == 0){
                Mana++;
                if(Mana > 0){
                    ManaChecker = 0;
                }
                getWorld().addObject(new P2Mana(Mana), 800, 0);
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
        if(faceSide == 0){
            if(ManaChecker == 0){
                dalay++;
                if(dalay % SPEED == 0){
                    if(counter >= 5){
                        counter = 0;
                        checker = 0;
                    }
                    if(counter <= 3){
                        move(-20);
                        setImage(still1[0][counter]);
                        counter++;
                        return;
                    }
                    if(counter == 4){
                        Skill1();    
                    }
                    setImage(still1[0][counter]);
                    counter++;
                }
            }else{
                checker = 0;
            }
        }else if(faceSide == 1){
            if(ManaChecker == 0){
                dalay++;
                if(dalay % SPEED == 0){
                    if(counter >= 5){
                        counter = 0;
                        checker = 0;
                    }
                    if(counter <= 3){
                        move(20);
                    }
                    setImage(still1[1][counter]);
                    counter++;
                }
            }else{
                checker = 0;
            }
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
            side = 0;
            dalay++;
            if(dalay % SPEED == 0){
                setImage(walk[0][counter]);
                move(-10);
                if(counter >= 7)
                    counter = 0;
                else
                    counter++;
            }
        }else if(faceSide == "right"){
            side = 1;
            dalay++;
            if(dalay % SPEED == 0){
                setImage(walk[1][counter]);
                move(10);
                if(counter >= 7)
                    counter = 0;
                else
                    counter++;
            }
        }
    }

    /**
     * Method Run
     * 
     * Run Animation main method
     * and the parameter for is just for keep track on which side the player are facing to
     */
    public void Run(String faceSide){
        if(faceSide == "left"){
            side = 1;
            dalay++;
            if(dalay % SPEED == 0){
                setImage(run[0][counter]);
                move(-20);
                if(counter >= 5)
                    counter = 0;
                else
                    counter++;
            }
        }else if(faceSide == "right"){
            side = 0;
            dalay++;
            if(dalay % SPEED == 0){
                setImage(run[1][counter]);
                move(20);
                if(counter >= 5)
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
     * This is use for let player1 calculate the damage
     */
    public int damage(){
        return Mana;
    }
}
