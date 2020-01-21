import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Bow icon allows to buy a bow from a shop. 
 * 
 * @author Anthony Neeser (Art by Ben Presley)
 * @version 5/7/18
 */
public class BowIcon extends Icons
{
    GreenfootSound bow;
    /**
     *  BowIcon constructor sets image for BowIcon. 
     */
    public BowIcon()
    {
        bow = new GreenfootSound("effects/bowSelect.mp3");
        setImage(new GreenfootImage("UI/iconBowColor.png"));
    }

    /**
     * Act - do whatever the BowIcon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        bow();
    } 
    
    /**
     * If clicked in shop, BowIcon will add a bow to your inventory, if you have enough gold, 
     * and if you don't already have a bow. Pressing escape will remove BowIcon from screen. 
     */
    public void bow()
    {
        if (Greenfoot.isKeyDown("escape"))
        {
            //System.out.println("BowX = "+getX()+" and BowY = "+getY());
            getWorld().removeObject(this);
        }

        if(Greenfoot.mouseClicked(this) && getWorld() instanceof Shop)
        {
            if(MainWorld.gold >= MainWorld.bowPrice && MainWorld.bow == 0)
            {
                MainWorld.gold -= MainWorld.bowPrice;
                MainWorld.bow=1;
                bow.play();
            }
        }
    }
}
