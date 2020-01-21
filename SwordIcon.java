import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Sword icon allows to buy a sword from a shop.
 * 
 * @author Anthony Neeser (Art by Ben Presley)
 * @version 5/7/18
 */
public class SwordIcon extends Icons
{
    GreenfootSound sword;
    /**
     *  SwordIcon constructor sets image for SwordIcon. 
     */
    public SwordIcon()
    {
        sword = new GreenfootSound("effects/swordSelect.wav");
        setImage(new GreenfootImage("UI/iconSwordColor.png"));
    }
    
    /**
     * Act - do whatever the SwordIcon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        sword();
    }    
    
    /**
     * If clicked in shop, SwordIcon will add a sword to your inventory, if you have enough gold, 
     * and if you don't already have a sword. Pressing escape will remove SwordIcon from screen. 
     */
    public void sword()
    {
        if (Greenfoot.isKeyDown("escape"))
        {
            //System.out.println("SwordX = "+getX()+" and SwordY = "+getY());
            getWorld().removeObject(this);
        }
        
        if(Greenfoot.mouseClicked(this) && getWorld() instanceof Shop)
        {
            if(MainWorld.gold >= MainWorld.swordPrice && MainWorld.sword == 0)
            {
                MainWorld.gold -= MainWorld.swordPrice;
                MainWorld.sword = 1;
                sword.play();
            }
        }
    }
}
