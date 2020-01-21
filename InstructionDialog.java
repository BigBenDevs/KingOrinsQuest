import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * World dialog for displaying text in world.
 * 
 * @author Anthony Neeser
 * @version 5/6/18
 */
public class InstructionDialog extends InstructionParts
{
    /**
     * InstructionDialog displays instruction text when player presses "i".
     */
    public InstructionDialog(String text, Color fG, Color bG) 
    {
        GreenfootImage dialog = new GreenfootImage(text, 24, fG, bG);
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
