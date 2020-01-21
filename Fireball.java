import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Fireball is a fire magic attack. 
 * 
 * @author Anthony Neeser
 * @version 4/30/18
 */
public class Fireball extends Projectiles
{   
    private int speed; //movement speed.
    private int counter; //For animation.
    private int removeCount; //Time until object removes itself
    private GreenfootImage[] fB;
    private int width, height;
    private int damage;
    /**
     * Fireball constructor sets initial values for fireball.
     */
    public Fireball(int s, int r, int w, int h, int countdown)
    {
        width = w;
        height = h;
        removeCount = countdown;
        speed = s;
        setRotation(r);
        initializeImages();
    }

    /**
     * Act - do whatever the Fireball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        counter++;
        if (counter >= fB.length * 3)
        {
            counter = 0;
        }
        setImage(fB[counter / 3]);
        fB[counter / 3].scale(width, width);
        if(MainWorld.suitActive)
        {
            damage = MainWorld.enemyFireball2;
        }
        else
        {
            damage = MainWorld.enemyFireball;
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
     * Initializes images and sets starting image for fireball.
     */
    public void initializeImages()
    {
        fB = new GreenfootImage[6];
        for(int i =0; i<fB.length; i++)
        {
            String filename = "projectiles/fireball"+(i)+".png";
            fB[i] = new GreenfootImage(filename);
        }
        setImage(fB[0]);
        fB[0].scale(width,width);
    }
}
