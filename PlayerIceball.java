import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Ice magic that can be cast by the player.
 * 
 * @author Anthony Neeser
 * @version 5/14/18
 */
public class PlayerIceball extends PlayerProjectiles
{
    private int speed; //movement speed.
    private int counter; //For animation.
    private int removeCount; //Time until object removes itself
    private GreenfootImage[] iB;
    private int width, height;
    /**
     * PlayerIceball constructor sets initial values for player's iceball.
     */
    public PlayerIceball(int s, int r, int w, int h, int countdown)
    {
        width = w;
        height = h;
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
        if(isTouching(EnemyNPC.class) || isTouching(Barrier.class))
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
     * Initializes images and sets starting image for player's iceball.
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
        iB[0].scale(width,width);
    }
}
