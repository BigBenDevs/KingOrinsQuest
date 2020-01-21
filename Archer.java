import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The archer wants to destroy the main character!
 * 
 * @author Anthony Neeser
 * @version 4/30/18
 */
public class Archer extends Ranged
{
    //Set image change delay
    private int imgChangeDelay = 15;

    //Set step delay (Higher means a slower walk speed in world).
    private int stepDelay = 3;

    //Set direction change delay
    private int dirSwitch = 200;

    //Set range in which NPC notices main character
    private int mcRange = 300;

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
    public boolean angry;
    //Health
    private int health = 40;
    //Iced? (NPC is frozen, preventing movement/attacks
    private int ice;
    /**
     * Archer constructor sets initial image, and sets angry to value of variable passed to constructor.
     */
    public Archer(boolean angry)
    {
        this.angry = angry;
        setImage("char/Guerrilla/Guerrilla_Front.png");
    }

    /**
     * Act - do whatever the Archer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {   
        monitor();
    }
    
    /**
     * Checks for player attack collisions, sets angry variable (if not done already), checks if under ice effect, removes this at 0 health, and passes variables to NPC
     */
    public void monitor()
    {
        if(isTouching(PlayerArrow.class))
        {
            health -= MainWorld.playerArrow;
            angry = true;
        }
        if(isTouching(PlayerSlash.class))
        {
            health -= MainWorld.playerSlash;
            angry = true;
        }
        if(isTouching(PlayerFireball.class))
        {
            health -= MainWorld.playerFireball;
            angry = true;
        }

        if(isTouching(PlayerIceball.class))
        {
            health -= MainWorld.playerIceball;
            angry = true;
            ice = 200;
        }
        if(ice > 0)
        {
            ice--;
        }
        if(health <= 0)
        {
            getWorld().addObject(new Gold(), getX(), getY());
            getWorld().removeObject(this);
        }
        else
        {
            if(ice == 0)
            {
                variablePass("char/Guerrilla/Guerrilla_", imgChangeDelay, shadowImageWidth, shadowImageHeight, shadowX, shadowY, shadowWidth, shadowHeight, 
                    stepDelay, dirSwitch, mcRange, angry, classType, projectile, projectileWidth, projectileHeight, shotSpeed, removalCount, reloadDelay);
            }
        }
    }
}
