import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Creates a colored box to display text on for generic world dialog. 
 * 
 * @author Anthony Neeser
 * @version 5/6/18
 */
public class GenericWorldDialogBox extends DialogBox
{
    private int counter = MainWorld.genericDB;
    /**
     * GenericWorldDialogBox constructs the colored box that serves as a backdrop for generic world dialog text. 
     */
    public GenericWorldDialogBox(int width, int height, Color color)
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
        counter--;
        if (Greenfoot.isKeyDown("escape") || counter == 0)
        {
            getWorld().removeObject(this);
        }
    }    
}
