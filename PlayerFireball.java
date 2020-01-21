import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Fire magic that can be cast by the player. 
 * 
 * @author Anthony Neeser
 * @version 5/14/18
 */
public class PlayerFireball extends PlayerProjectiles
{
    private int speed; //movement speed.
    private int counter; //For animation.
    private int removeCount; //Time until object removes itself
    private GreenfootImage[] fB;
    private int width, height;
     /**
     * PlayerFireball constructor sets initial values for the player's fireball.
     */
    public PlayerFireball(int s, int r, int w, int h, int countdown)
    {
        width = w;
        height = h;
        removeCount = countdown;
        speed = s;
        setRotation(r);
        initializeImages();
    }

    /**
     * Act - do whatever the PlayerFireball wants to do. This method is called whenever
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
     * Initializes images and sets starting image for player's fireball.
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