import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is Princess Anna.  Save her! 
 * 
 * @author Benjamin Presley
 * @version 4/30/18
 */
public class PrincessAnna extends BensSubSystem
{
    //Images. Set each in constructor. 
    private GreenfootImage left1, left2, right1, right2, up1, up2, down1, down2, front, back, left, right;

    //Set image change delay to pass to FriendlyNPC.
    private int imgChangeDelay = 15;

    //Set step delay (Higher means a slower walk speed in world).
    private int stepDelay = 2;

    //Set direction change delay
    private int dirSwitch = 200;

    //Set range in which NPC notices main character
    private int mcRange = 200;

    //Shadow specifications
    private int shadowImageWidth = 64;
    private int shadowImageHeight = 128;
    private int shadowX = 17;
    private int shadowY = 82;
    private int shadowWidth = 35;
    private int shadowHeight = 20;

    //Set if enemy will shoot, what ammo to use, speed of the ammo, and how often to reload.  
    private String classType = "archer"; //"archer", "spearman", "melee"
    private String projectile = "arrow"; // "arrow", "spear"
    private int projectileWidth = 18;
    private int projectileHeight = 7;
    private int shotSpeed = 10;
    private int removalCount = 25;
    private int reloadDelay = Greenfoot.getRandomNumber(100)+100; //Adds delay to reload so that each enemy is different.

    //Angry?
    public boolean angry = false;

    //Dialog prompt
    private int counter = 0;
    private int set = 0;
    private int dbCount = MainWorld.dB + 1;

    /**
     * Villager constructor. Initializes image variables, sets size of initial image, then sets inital image.
     */
    public PrincessAnna()
    {
        left1= new GreenfootImage("char/PurpleDress/PurpleDress_Left1.png");
        left2= new GreenfootImage("char/PurpleDress/PurpleDress_Left2.png");
        left= new GreenfootImage("char/PurpleDress/PurpleDress_Left_Standing.png");
        right1= new GreenfootImage("char/PurpleDress/PurpleDress_Right1.png");
        right2= new GreenfootImage("char/PurpleDress/PurpleDress_Right2.png");
        right= new GreenfootImage("char/PurpleDress/PurpleDress_Right_Standing.png");
        up1= new GreenfootImage("char/PurpleDress/PurpleDress_Up1.png");
        up2= new GreenfootImage("char/PurpleDress/PurpleDress_Up2.png");
        back= new GreenfootImage("char/PurpleDress/PurpleDress_Back.png");
        down1= new GreenfootImage("char/PurpleDress/PurpleDress_Down1.png");
        down2= new GreenfootImage("char/PurpleDress/PurpleDress_Down2.png");
        front= new GreenfootImage("char/PurpleDress/PurpleDress_Front.png");
        front.scale(64,64);
        setImage(front);
    }

    /**
     * Act - do whatever the Villager wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {

    }

}
