import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Border for Player information bar. 
 * 
 * @author Anthony Neeser
 * @version 5/6/18
 */
public class PlayerDialogBorder extends DialogBorder
{
    /**
     * PlayerDialogBorder creates a border for the infobar at bottom of screen. 
     */
    public PlayerDialogBorder(int width, int height) 
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
        getWorld().removeObject(this);
    }    
}
