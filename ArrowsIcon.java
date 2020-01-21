import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The arrows icon is a stand in for arrows. If clicked in the shop, it can add 10 
 * arrows to your inventory.
 * 
 * @author Anthony Neeser (Art by Ben Presley)
 * @version 5/7/18
 */
public class ArrowsIcon extends Icons
{
    GreenfootSound arrows;
    /**
     *  ArrowsIcon constructor sets image for ArrowsIcon. 
     */
    public ArrowsIcon()
    {
        arrows = new GreenfootSound("effects/arrowSelect.mp3");
        setImage(new GreenfootImage("UI/iconArrowsColor.png"));
    }

    /**
     * Act - do whatever the ArrowsIcon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        arrows();
    }    
    
    /**
     * If clicked in shop, the ArrowsIcon will add ten arrows to your inventory, if you have enough gold
     * and you have less than or equal to 90 arrows stocked. If you press escape ArrowsIcon is removed from the screen. 
     */
    public void arrows()
    {
        if (Greenfoot.isKeyDown("escape"))
        {
            //System.out.println("ArrowsX = "+getX()+" and ArrowsY = "+getY());
            getWorld().removeObject(this);
        }

        if(Greenfoot.mouseClicked(this) && getWorld() instanceof Shop)
        {
            if(MainWorld.gold >= MainWorld.arrowPrice && MainWorld.arrowCount <= 90)
            {
                MainWorld.gold -= MainWorld.arrowPrice;
                MainWorld.arrowCount += 10;
                arrows.play();
            }
        }
    }
}
