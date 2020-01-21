import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Health potion icon is a stand in for a health potion. If clicked in the shop, it can add a 
 * health potion to your inventory. 
 * 
 * @author Anthony Neeser (Art by Ben Presley)
 * @version 5/7/18
 */
public class HealthPotionIcon extends Icons
{
    GreenfootSound potion;
    /**
     * Health potion icon constructor sets image for health potion icon. 
     */
    public HealthPotionIcon(int size)
    {
        potion = new GreenfootSound("effects/potionSelect.mp3");
        GreenfootImage health = new GreenfootImage("UI/iconHealthPotionColor.png");
        health.scale(size, size);
        setImage(health);
    }

    /**
     * Act - do whatever the HealthPotionIcon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        buyOrUseHealthPotion();
    }

    /**
     * If clicked in shop, the HealthPotionIcon will add one health potion to your inventory, if you have enough gold
     * and you have less than 5 health potions stocked. If you press escape HealthPotionIcon is removed from the screen. 
     */
    public void buyOrUseHealthPotion()
    {
        if(Greenfoot.isKeyDown("escape"))
        {
            //System.out.println("HealthPotionX = "+getX()+" and HealthPotionY = "+getY());
            getWorld().removeObject(this);
        }

        if(Greenfoot.mouseClicked(this) && getWorld() instanceof Shop)
        {
            if(MainWorld.gold >= MainWorld.healthPotionPrice && MainWorld.healthPotion <= 4)
            {
                MainWorld.gold -= MainWorld.healthPotionPrice;
                MainWorld.healthPotion += 1;
                //Greenfoot.playSound("effects/potionSelect.mp3");
                potion.play();
            }
        }
    }
}
