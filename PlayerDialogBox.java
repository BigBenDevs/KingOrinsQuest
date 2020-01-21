import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Creates a colored box to display text on in Player information bar. 
 * 
 * @author Anthony Neeser
 * @version 5/6/18
 */
public class PlayerDialogBox extends DialogBox
{
    /**
     * PlayerDialogBox constructs the colored box that serves as a backdrop for the infobar at bottom of screen. 
     */
    public PlayerDialogBox(int width, int height, Color color)
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
        getWorld().removeObject(this);
    }    
}
