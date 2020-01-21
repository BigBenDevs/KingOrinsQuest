import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Slash is a sword attack used by fighters. 
 * 
 * @author Anthony Neeser & Benjamin Presley
 * @version 5/10/2018
 */
public class Slash extends Projectiles
{   
    private int speed; //movement speed.
    private int counter; //For animation.
    private int removeCount; //Time until object removes itself
    private GreenfootImage slash;
    private int damage;
    /**
     * Slash constructor sets initial values for slash.
     */
    public Slash(int s, int r, int width, int height, int countdown)
    {
        removeCount = countdown;
        speed = s;
        slash = new GreenfootImage("projectiles/SwordSlash.png");
        slash.scale(width, height);
        setImage(slash);
        setRotation(r);
    }

    /**
     * Act - do whatever the Slash wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(MainWorld.suitActive)
        {
            damage = MainWorld.enemySlash2;
        }
        else
        {
            damage = MainWorld.enemySlash;
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
}
