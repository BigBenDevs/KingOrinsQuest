import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Iceball is an ice magic attack. 
 * 
 * @author Anthony Neeser
 * @version 4/30/18
 */
public class Iceball extends Projectiles
{   
    private int speed; //Movement speed.
    private int counter; //For animation 
    private int removeCount; //Time until object removes itself
    private int width, height;
    private GreenfootImage[] iB;
    private int damage;
    /**
     * Iceball constructor sets initial values for Iceball.
     */
    public Iceball(int s, int r, int width, int height, int countdown)
    {
        removeCount = countdown;
        speed = s;
        setRotation(r);
        initializeImages();
    }

    /**
     * Act - do whatever the Iceball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        counter++;
        if (counter >= iB.length * 3)
        {
            counter = 0;
        }
        setImage(iB[counter / 3]);
        iB[counter / 3].scale(width, width);
        if(MainWorld.suitActive)
        {
            damage = MainWorld.enemyIceball2;
        }
        else
        {
            damage = MainWorld.enemyIceball;
        }
        if(isTouching(Player.class))
        {
            if(MainWorld.playerArmor > damage)
            {
                MainWorld.playerArmor -= damage;
            }
            else if(MainWorld.playerArmor <= damage)
            {
                int tempDamage = damage - MainWorld.playerArmor;
                MainWorld.playerArmor = MainWorld.playerArmor+tempDamage-damage; 
                MainWorld.playerHealth -= tempDamage;
                MainWorld.shield = 0;
            }
            else
            {
                MainWorld.playerHealth -= damage;
            }
            getWorld().removeObject(this);
        }
        else if(isTouching(Barrier.class))
        {
            getWorld().removeObject(this);
        }
        else
        {
            removal(removeCount);
            move(speed);
        }
    }    
    
    /**
     * Initializes images and sets starting image for iceball
     */
    private void initializeImages()
    {
        iB = new GreenfootImage[6];
        for(int i =0; i<iB.length; i++)
        {
            String filename = "projectiles/iceball"+(i)+".png";
            iB[i] = new GreenfootImage(filename);
        }
        setImage(iB[0]);
        iB[0].scale(20,20);
    }
}
