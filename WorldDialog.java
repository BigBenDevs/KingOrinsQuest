import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * World dialog for displaying text in world.
 * 
 * @author Anthony Neeser
 * @version 5/6/18
 */
public class WorldDialog extends DialogText
{
    private int counter = MainWorld.dB;
    /**
     * WorldDialog constructor sets values for displaying world dialog text.
     */
    public WorldDialog(String text, Color fG, Color bG) 
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
        counter--;
        if (Greenfoot.isKeyDown("escape") || counter == 0)
        {
            getWorld().removeObject(this);
        }
    }    
}
