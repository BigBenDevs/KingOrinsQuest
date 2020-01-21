import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Creates a colored box to display text on. 
 * 
 * @author Anthony Neeser
 * @version 5/6/18
 */
public class InstructionDialogBox extends InstructionParts
{
    /**
     * InstructionDialogBox creates a backdrop for instruction text when player presses "i".
     */
    public InstructionDialogBox(int width, int height, Color color)
    {
        GreenfootImage dialog = new GreenfootImage(width, height);
        dialog.setColor(color);
        dialog.fillRect(0, 0, width, height);
        setImage(dialog);
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
