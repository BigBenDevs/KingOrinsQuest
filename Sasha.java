import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Sasha is a resident of MainWorld. 
 * 
 * @author Anthony Neeser
 * @version 4/30/18
 */
public class Sasha extends Villager
{
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
     * Sasha constructor. Sets initial image.
     */
    public Sasha()
    {
        setImage("char/RedHairGirl/RedHair_Front.png");
    }

    /**
     * 1st dialog. 
     */
    public void dialog1()
    {
        generateDialog("world", "-Sasha-\n\n\nWhat a fine day it is!\nSay, have you heard about the princess?");
    }

    /**
     * 2nd dialog.
     */
    public void dialog2()
    {
        if(counter == dbCount)
        {
            generateDialog("world", "If someone doesn't find her,\nthe kingdom could be doomed!\n\nAre you up to the challenge?");
            counter = 0;
            set = 0;
        }
    }

    /**
     * Act - do whatever the Villager wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        variablePass("char/RedHairGirl/RedHair_", imgChangeDelay, shadowImageWidth, shadowImageHeight, shadowX, shadowY, shadowWidth, shadowHeight, 
            stepDelay, dirSwitch, mcRange, angry, classType, projectile, projectileWidth, projectileHeight, shotSpeed, removalCount, reloadDelay);
        if(Greenfoot.mouseClicked(this) && set != 1 && worldDialog())
        {
            dialog1();
            set = 1;
        }
        if(set == 1 && counter < dbCount)
        {
            counter++;
        }
        dialog2();
    }
}
