import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Pirate has kidnapped the princess and wants to destroy the main character!
 * 
 * @author Anthony Neeser & Benjamin Presley
 * @version 5/10/2018
 */
public class Pirate extends Melee
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
    public boolean angry = true;

    //Npc health
    private int health = 100;

    /**
     * Pirate constructor sets initial image, and sets angry to value of variable passed to constructor. In Pirate's case, he's angry no matter what. 
     */
    public Pirate (boolean angry)
    {
        setImage("char/Pirate/Pirate_Front.png");
    }

    /**
     * Act - do whatever the Pirate wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {   
        monitor();
    }
    
    /**
     * Checks for player attack collisions, sets angry variable (if not done already), sets MainWorld.pirateDead to 1 and removes this at 0 health, and passes variables to NPC.
     */
    public void monitor()
    {
        if(isTouching(PlayerArrow.class))
        {
            health -= MainWorld.playerArrow;
        }
        if(isTouching(PlayerSlash.class))
        {
            health -= MainWorld.playerSlash;
        }
        if(isTouching(PlayerFireball.class))
        {
            health -= MainWorld.playerFireball;
        }
        if(health <= 0)
        {
            getWorld().addObject(new Gold(), getX(), getY());
            MainWorld.pirateDead = 1;
            getWorld().removeObject(this);
        }
        else
        {
            variablePass("char/Pirate/Pirate_", imgChangeDelay, shadowImageWidth, shadowImageHeight, shadowX, shadowY, shadowWidth, shadowHeight, 
                stepDelay, dirSwitch, mcRange, angry, classType, projectile, projectileWidth, projectileHeight, shotSpeed, removalCount, reloadDelay);
        }
    }
}
