import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Super class for game world.  Contains global variables.
 * 
 * @author Benjamin Presley, Anthony Neeser 
 * @version (04/30/18)
 */
public class MainWorld extends World
{
    //World spawn variables
    public static int spawn = 0;  //This variable is set to identify where to spawn char when changing worlds
    public static int topWorldID;
    public static int leftWorldID;
    public static int rightWorldID;
    public static int bottomWorldID;
    public static int lastWorld = 0;
    public static String worldDirection;

    public static final GreenfootSound
    myworldMusic = new GreenfootSound("sounds/music/Resolution.mp3"), //Background music for main world
    caveworldMusic = new GreenfootSound("sounds/music/TheZone.mp3"); //Background music for shop world
    public static int mute = 0; //Variable for muting background music
    private Player hawthorne;
    private Dialog dialog;

    //public static int gold;
    public static int dB = 200;
    public static int dBKing = 300;
    public static int genericDB = 100;
    public static int playerX = 0;
    public static int playerY = 0;

    //Player status
    public static int playerHealth = 100;
    public static int playerMana = 0;
    public static int playerArmor = 0;
    public static int start = 0;
    public static String playerName;
    public static int nameSet;

    //Damage to enemies by player's arrows
    public static int playerArrow = 12;
    public static int playerSlash = 20;
    public static int playerFireball = 8;
    public static int playerIceball = 5;
    
    //Enemy attack damage
    public static int enemyArrow = 8;
    public static int enemySpear = 6;
    public static int enemyFireball = 10;
    public static int enemySlash = 12;
    public static int enemyIceball = 10;
    //Enemy attack damage with suit
    public static int enemyArrow2 = 4;
    public static int enemySpear2 = 3;
    public static int enemyFireball2 = 5;
    public static int enemySlash2 = 6;
	public static int enemyIceball2 = 5;
    
	//Inventory
    public static int gold = 100;
    public static int arrowCount = 0;
    public static int healthPotion = 0;
    public static int manaPotion = 0;
    public static int shield = 0;
    public static int mushroomCount = 0;

    //Character state changed
    public static int state = 0;
    //Suit of armor
    public static int suit = 1;
    public static boolean suitActive = false;
    //Sword
    public static int sword = 0;
    public static boolean swordActive = false;
    //Bow
    public static int bow = 0;
    public static boolean bowActive = false;

    //Quest
    public static int quest = 0; //Set to zero at game start.  Set to 1 when starting quest.  Set to 2 when completed.
    public static int pirateDead = 0; //Set to 0 at game start.  Set to 1 after the Pirate is killed.

    //Prices
    public static int arrowPrice = 25;
    public static int healthPotionPrice = 15;
    public static int manaPotionPrice = 15;
    public static int shieldPrice = 100;
    public static int swordPrice = 100;
    public static int bowPrice = 50;

    public static int shopState = 0;
    public MainWorld(String worldIDLeftClean)
    {
        super(1080, 920, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        MyWorldBG myworldbg = new MyWorldBG();
        addObject(myworldbg,549,467);
        myworldbg.setLocation(541,459);
    }
}

