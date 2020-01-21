import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Mana potion icon is a stand in for a mana potion. If clicked in the shop, it can add a 
 * mana potion to your inventory. 
 * 
 * @author Anthony Neeser (Art by Ben Presley)
 * @version 5/7/18
 */
public class ManaPotionIcon extends Icons
{
    GreenfootSound potion;
    /**
     * Health potion icon constructor sets image for health potion icon. 
     */
    public ManaPotionIcon(int size)
    {
        potion = new GreenfootSound("effects/potionSelect.mp3");
        GreenfootImage mana = new GreenfootImage("UI/iconManaPotionColor.png");
        mana.scale(size, size);
        setImage(mana);
    }

    /**
     * Act - do whatever the ManaPotionIcon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        buyOrUseManaPotion();
    }

    /**
     * If clicked in shop, the ManaPotionIcon will add one health potion to your inventory, if you have enough gold
     * and you have less than 5 health potions stocked. If you press escape ManaPotionIcon is removed from the screen. 
     */
    public void buyOrUseManaPotion()
    {
        if(Greenfoot.isKeyDown("escape"))
        {
            //System.out.println("ManaPotionX = "+getX()+" and ManaPotionY = "+getY());
            getWorld().removeObject(this);
        }
        if(Greenfoot.mouseClicked(this) && getWorld() instanceof Shop)
        {
            if(MainWorld.gold >= MainWorld.manaPotionPrice && MainWorld.manaPotion <= 4)
            {
                MainWorld.gold -= MainWorld.manaPotionPrice;
                MainWorld.manaPotion += 1;
                potion.play();
            }
        }
    }
}