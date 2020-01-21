import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Chicken walks around just doing their own thing.
 * 
 * @author Anthony Neeser 
 * @version 5/7/18
 */
public class Chicken extends Animals
{
    //Set image change delay
    private int imgChangeDelay = 15;

    //Set step delay (Higher means a slower walk speed in world).
    private int stepDelay = 2;

    //Set direction change delay
    private int dirSwitch = 200;

    //Set range in which NPC notices main character
    private int mcRange = 200;

    //Shadow specifications
    private int shadowImageWidth = 64/2;
    private int shadowImageHeight = 128/2;
    private int shadowX = 17/2-3;
    private int shadowY = 82/2;
    private int shadowWidth = 35/2+5;
    private int shadowHeight = 20/2;

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

    public Chicken()
    {
        //Chicken
        setImage("/char/Chicken/Chicken_Front.png");
    }

    /**
     * Act - do whatever the Villager1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        variablePass("/char/Chicken/Chicken_", imgChangeDelay, shadowImageWidth, shadowImageHeight, shadowX, shadowY, shadowWidth, shadowHeight, 
            stepDelay, dirSwitch, mcRange, angry, classType, projectile, projectileWidth, projectileHeight, shotSpeed, removalCount, reloadDelay);
    }    
}