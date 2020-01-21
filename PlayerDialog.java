import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Displays text in Player information bar. 
 * 
 * @author Anthony Neeser
 * @version 5/6/18
 */
public class PlayerDialog extends DialogText
{
    /**
     * PlayerDialog displays player information in infobar at bottom of screen.
     */
    public PlayerDialog(String text, Color fG, Color bG) 
    {
        GreenfootImage playerDialog = new GreenfootImage(text, 24, fG, bG);
        setImage(playerDialog);
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
