import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Walter is a resident of MainWorld. He lives in the Old Man's House.  
 * 
 * @author Anthony Neeser
 * @version 4/30/18
 */
public class Walter extends Villager
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
     * Villager constructor. Initializes image variables, sets size of initial image, then sets inital image.
     */
    public Walter()
    {
        setImage("char/MustacheMan/MustacheMan_Front.png");
    }

    /**
     * Act - do whatever the Villager wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        variablePass("char/MustacheMan/MustacheMan_", imgChangeDelay, shadowImageWidth, shadowImageHeight, shadowX, shadowY, shadowWidth, shadowHeight, 
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

    public void dialog1()
    {
        generateDialog("world", "I can see you are on an important quest. \n I may be able to help you.");
    }

    public void dialog2()
    {
        if(counter == dbCount)
        {
            counter = 0;
            if(MainWorld.suit == 0)
            {
                generateDialog("world", "The caves north of here hold your fate. \n Take this suit of armor for protection. \n God speed young hero!");
                MainWorld.suit = 1;
            }
            else{
            generateDialog("world", "The caves north of here hold your fate. \n God speed young hero!");
            }
            set = 0;
        }
    }
}
