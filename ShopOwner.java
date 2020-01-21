import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * This ShopOwner is a resident of MainWorld. 
 * 
 * @author Matt Marler
 * @version 5/1/18
 */
public class ShopOwner extends HelpfulNPCs
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
    
    private int dbTimer = 0;

    private int arrow = MainWorld.arrowPrice;
    private int shield = MainWorld.shieldPrice;
    private int sword = MainWorld.swordPrice;
    private int bow = MainWorld.bowPrice;
    private int health = MainWorld.healthPotionPrice;
    private int mana = MainWorld.manaPotionPrice;
    
    /**
     * ShopOwner constructor. Initializes image variables and sets inital image.
     */
    public ShopOwner()
    {
        left1= new GreenfootImage("char/BrownMustache/BrownMustache_Left1.png");
        left2= new GreenfootImage("char/BrownMustache/BrownMustache_Left2.png");
        left= new GreenfootImage("char/BrownMustache/BrownMustache_Left_Standing.png");
        right1= new GreenfootImage("char/BrownMustache/BrownMustache_Right1.png");
        right2= new GreenfootImage("char/BrownMustache/BrownMustache_Right2.png");
        right= new GreenfootImage("char/BrownMustache/BrownMustache_Right_Standing.png");
        up1= new GreenfootImage("char/BrownMustache/BrownMustache_Up1.png");
        up2= new GreenfootImage("char/BrownMustache/BrownMustache_Up2.png");
        back= new GreenfootImage("char/BrownMustache/BrownMustache_Back.png");
        down1= new GreenfootImage("char/BrownMustache/BrownMustache_Down1.png");
        down2= new GreenfootImage("char/BrownMustache/BrownMustache_Down2.png");
        front= new GreenfootImage("char/BrownMustache/BrownMustache_Front.png");
        setImage(front);
    }
    
    /**
     * Allows player to open shop dialog to purchase items.
     */
    public void interact()
    {
        if(Greenfoot.mouseClicked(this))
        {
            generateDialog("shop", "Come, check out my wares! \n I have the finest items in the galaxy,\n let alone the world! \n\n\n Press *space* to see selection!");
            MainWorld.shopState = 1;
        }
        if(Greenfoot.isKeyDown("space") && MainWorld.shopState == 1)
        {
            MainWorld.shopState = 0;
            getWorld().removeObjects(getWorld().getObjects(ShopDialog.class));
            getWorld().removeObjects(getWorld().getObjects(ShopDialogBox.class));
            getWorld().removeObjects(getWorld().getObjects(ShopDialogBorder.class));
            generateDialog("Click to purchase!", arrow, shield, sword, bow, health, mana, "Press *escape* to close.");
        }
    }

    /**
     * Act - do whatever the ShopOwner wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        getWorld().addObject(new Shadow(shadowImageWidth, shadowImageHeight, shadowX, shadowY, shadowWidth, shadowHeight), getX(), getY());
        varCycle(stepDelay, dirSwitch, imgChangeDelay, mcRange);
        if(!barrierFar() || isAtEdge())
        {            
            moveChange();
            barrier();
        }
        if(!npcFar())
        {
            npc();
        }
        if(barrierFar()||npcFar())
        {
            movement();
        }
        imageChange(left1, left2, right1, right2, up1, up2, down1, down2, front, back, left, right, imgChangeDelay);
        
        interact();
    }
}
