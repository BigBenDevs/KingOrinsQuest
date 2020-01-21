import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Creates a colored box to display text on. 
 * 
 * @author Anthony Neeser
 * @version 5/6/18
 */
public class ShopDialogBox extends DialogBox
{
    /**
     * ShopDialogBox constructs the colored box that serves as a backdrop for the shop dialog text and icons. 
     */
    public ShopDialogBox(int width, int height, Color color)
    {
        GreenfootImage dialogBox = new GreenfootImage(width, height);
        dialogBox.setColor(color);
        dialogBox.fillRect(0, 0, width, height);
        setImage(dialogBox);
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
