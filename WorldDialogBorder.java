import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Border for world dialog boxes.
 * 
 * @author Anthony Neeser
 * @version 5/6/18
 */
public class WorldDialogBorder extends DialogBorder
{
    private int counter = MainWorld.dB;
    /**
     * WorldDialogBorder creates a border for world dialog. 
     */
    public WorldDialogBorder(int width, int height) 
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
        counter--;
        if (Greenfoot.isKeyDown("escape") || counter == 0)
        {
            getWorld().removeObject(this);
        }
    }    
}
