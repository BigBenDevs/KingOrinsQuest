import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Gold drops when you kills enemies. If you pick it up, you will gain at
 * least 25 gold, and up to 50 gold. 
 * 
 * @author Anthony Neeser
 * @version 5/7/18
 */
public class Gold extends Loot
{
    public Gold()
    {
        GreenfootImage gold = new GreenfootImage("loot/pile_of_coins.gif");
        gold.scale(32, 32);
        setImage(gold);
    }
    
    /**
     * Act - do whatever the Gold wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(isTouching(Player.class))
        {
            MainWorld.gold += Greenfoot.getRandomNumber(26)+25;
            getWorld().removeObject(this);
        }
    }    
}
