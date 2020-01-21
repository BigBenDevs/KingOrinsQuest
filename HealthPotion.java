import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Health potion will act as a health regen elixer.  It will be randomly spawned withing the world and can be picked up by the player.
 * 
 * @author (Benjamin Presley) 
 * @version (04/30/18)
 */
public class HealthPotion extends Loot
{
    private GreenfootImage healthPotionImage;
    public HealthPotion()
    {
        healthPotionImage = new GreenfootImage("loot/HealthPotion.png");
        setImage(healthPotionImage);
    }
    /**
     * Act - do whatever the HealthPotion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
