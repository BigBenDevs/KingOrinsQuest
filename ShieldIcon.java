import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Shield icon allows to buy armor from a shop.
 * 
 * @author Anthony Neeser (Art by Ben Presley)
 * @version 5/7/18
 */
public class ShieldIcon extends Icons
{
    GreenfootSound shield;
    /**
     *  ShieldIcon constructor sets image for ShieldIcon. 
     */
    public ShieldIcon()
    {
        shield = new GreenfootSound("effects/shieldSelect.mp3");
        setImage(new GreenfootImage("UI/iconShieldColor.png"));
    }
    
    /**
     * Act - do whatever the ShieldIcon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        shield();
    }   
    
    /**
     * If clicked in shop, the ShieldIcon will add 100 armor to your character, if you have enough gold
     * and you currently have 0 armor. If you press escape, ShieldIcon is removed from the screen. 
     */
    public void shield()
    {
        if (Greenfoot.isKeyDown("escape"))
        {
            getWorld().removeObject(this);
        }
        
        if(Greenfoot.mouseClicked(this) && getWorld() instanceof Shop)
        {
            if(MainWorld.gold >= MainWorld.shieldPrice && MainWorld.shield == 0)
            {
                MainWorld.gold -= MainWorld.shieldPrice;
                MainWorld.shield = 1;
                MainWorld.playerArmor = 100;
                shield.play();
            }
        }
    }
}