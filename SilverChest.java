import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Contains items to help you on your journey.
 * 
 * @author (Matt Marler) 
 * @version (5/10/18)
 */
public class SilverChest extends Interactables
{
    private GreenfootImage silverchestclosed, silverchestopen1, silverchestopen2, silverchestopen3;
    GreenfootSound open = new GreenfootSound("effects/chest.mp3");
    private int world8 = 0;
    private int world13 = 0;
    public SilverChest(int width, int height)
    {
        silverchestclosed = new GreenfootImage("Interactables/silverchestclosed.png");
        silverchestclosed.scale(width, height);
        silverchestopen1 = new GreenfootImage("Interactables/silverchestopen1.png");
        silverchestopen1.scale(52, 52);
        silverchestopen2 = new GreenfootImage("Interactables/silverchestopen2.png");
        silverchestopen2.scale(52, 52);
        silverchestopen3 = new GreenfootImage("Interactables/silverchestopen3.png");
        silverchestopen3.scale(52, 52);
        setImage(silverchestclosed);
    }

    public boolean chestFar()
    {
        return getObjectsInRange(200, Player.class).isEmpty();
    }

    public void interact()
    {
        //World8
        if(Greenfoot.mouseClicked(this) && getWorld() instanceof World8 && !chestFar() && world8 == 0)
        {
            generateDialog("world","You have found a health potion!");
            MainWorld.healthPotion++;
            world8 = 1;
            setImage(silverchestopen1);
            if(getImage() == silverchestopen1)
            {
                setImage(silverchestopen2);
            }
            if(getImage() == silverchestopen2)
            {
                setImage(silverchestopen3);
            }
        }
        //World13
        if(Greenfoot.mouseClicked(this) && getWorld() instanceof World13 && !chestFar() && world13 == 0)
        {
            generateDialog("world","You have found a health potion!");
            MainWorld.healthPotion++;
            world13 = 1;
            setImage(silverchestopen1);
            if(getImage() == silverchestopen1)
            {
                setImage(silverchestopen2);
            }
            if(getImage() == silverchestopen2)
            {
                setImage(silverchestopen3);
            }
        }
    }

    /**
     * Act - do whatever the TreasureChest wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        interact();
    }    
}
