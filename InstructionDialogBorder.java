import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Border for world dialog boxes.
 * 
 * @author Anthony Neeser
 * @version 5/6/18
 */
public class InstructionDialogBorder extends InstructionParts
{
    /**
     * InstructionDialogBorder displays a border around the instructions when player presses "i".
     */
    public InstructionDialogBorder(int width, int height) 
    {
        GreenfootImage dialog = new GreenfootImage("UI/originalborder.png");
        dialog.scale(width, height);
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
