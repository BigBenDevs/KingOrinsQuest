import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Player slash is the player's sword swing. 
 * 
 * @author Anthony Neeser
 * @version 5/12/18
 */
public class PlayerSlash extends PlayerProjectiles
{   
    private int speed; //movement speed.
    private int removeCount; //Time until object removes itself
    private GreenfootImage slash;
    /**
     * PlayerSlash constructor sets initial values for player's slash.
     */
    public PlayerSlash(int s, int r, int width, int height, int countdown)
    {
        removeCount = countdown;
        speed = s;
        slash = new GreenfootImage("projectiles/SwordSlash.png");
        slash.scale(width, height);
        setImage(slash);
        setRotation(r);
    }

    /**
     * Act - do whatever the Fireball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(isTouching(EnemyNPC.class))
        {
            getWorld().removeObject(this);
        }
        else
        {
            removal(removeCount);
        }
        move(speed);
    }    
}