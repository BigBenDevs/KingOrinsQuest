import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Projectile handles when to remove each projectile subclasses' removal from world. 
 * 
 * @author Anthony Neeser
 * @version 4/30/18
 */
public class Projectiles extends JimboSubSystem
{
    private int count, removeCount;
    
    public void removal(int timeFlying)
    {
        if(count>timeFlying||isAtEdge())
        {
            removeCount++;
            if(removeCount==3)
            {
                getWorld().removeObject(this);
            }
        }
        else
        {
            count++;
        }
    }
}