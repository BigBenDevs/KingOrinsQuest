import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Border for shop dialog boxes.
 * 
 * @author Anthony Neeser
 * @version 5/6/18
 */
public class ShopDialogBorder extends DialogBorder
{
    /**
     * ShopDialogBorder creates a border for shop dialog. 
     */
    public ShopDialogBorder(int width, int height) 
    {
        GreenfootImage shopDialogBorder = new GreenfootImage("UI/originalborder.png");
        shopDialogBorder.scale(width, height);
        setImage(shopDialogBorder);
    }    
    
    /**
     * Act - do whatever the DialogBox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.isKeyDown("escape"))
        {
            getWorld().removeObject(this);
        }
    }    
}
