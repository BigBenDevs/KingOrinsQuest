import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Arrows that can be shot by player. 
 * 
 * @author Anthony Neeser
 * @version 4/30/18
 */
public class PlayerArrow extends PlayerProjectiles
{   
    private int speed; //movement speed.
    private int removeCount; //Time until object removes itself
    private GreenfootImage arrow;
    /**
     * PlayerArrow constructor sets initial values for player's arrow.
     */
    public PlayerArrow(int s, int r, int width, int height, int countdown)
    {
        removeCount = countdown;
        speed = s;
        arrow = new GreenfootImage("projectiles/arrow.png");
        arrow.scale(width, height);
        setImage(arrow);
        setRotation(r);
    }

    /**
     * Act - do whatever the PlayerArrow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(isTouching(EnemyNPC.class) || isTouching(Barrier.class))
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
