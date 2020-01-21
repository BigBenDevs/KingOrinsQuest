import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Spears are used by enemy spearmen to hurt the main character. 
 * 
 * @author Anthony Neeser
 * @version 4/30/18
 */
public class Spear extends Projectiles
{   
    private int speed; //movement speed.
    private int removeCount = 30; //Time until object removes itself
    private GreenfootImage arrow;
    private int damage;
    /**
     * Spear constructor sets initial values for spear.
     */
    public Spear(int s, int r, int width, int height, int countdown)
    {
        removeCount = countdown;
        speed = s;
        arrow = new GreenfootImage("projectiles/spear.png");
        arrow.scale(width, height);
        setImage(arrow);
        setRotation(r);
    }

    /**
     * Act - do whatever the Spear wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(MainWorld.suitActive)
        {
            damage = MainWorld.enemySpear2;
        }
        else
        {
            damage = MainWorld.enemySpear;
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
