import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Shop dialog for displaying text and numbers in Shop. 
 * 
 * @author Anthony Neeser
 * @version 5/6/18
 */
public class ShopDialog extends DialogText
{
    /**
     * Constructor for displaying shop prices. 
     */
    public ShopDialog(int price, String gold, Color fG, Color bG) 
    {
        GreenfootImage shopDialog = new GreenfootImage(String.valueOf(price), 24, fG, bG);
        setImage(shopDialog);
    }    
    
    /**
     * Constructor for displaying shop text.
     */
    public ShopDialog(String text, Color fG, Color bG) 
    {
        GreenfootImage shopDialog = new GreenfootImage(text, 24, fG, bG);
        setImage(shopDialog);
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
