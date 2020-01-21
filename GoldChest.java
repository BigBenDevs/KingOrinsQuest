import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Contains items to help you on your journey.
 * 
 * @author (Matt Marler) 
 * @version (5/10/18)
 */
public class GoldChest extends Interactables
{
    private GreenfootImage goldchestclosed, goldchestopen1, goldchestopen2, goldchestopen3;
    GreenfootSound open = new GreenfootSound("effects/chest.mp3");
    private int cave1 = 0;

    public GoldChest(int width, int height)
    {
        goldchestclosed = new GreenfootImage("Interactables/goldchestclosed.png");
        goldchestclosed.scale(width, height);
        goldchestopen1 = new GreenfootImage("Interactables/goldchestopen1.png");
        goldchestopen1.scale(52, 52);
        goldchestopen2 = new GreenfootImage("Interactables/goldchestopen2.png");
        goldchestopen2.scale(52, 52);
        goldchestopen3 = new GreenfootImage("Interactables/goldchestopen3.png");
        goldchestopen3.scale(52, 52);
        setImage(goldchestclosed);
    }

    public boolean chestFar()
    {
        return getObjectsInRange(200, Player.class).isEmpty();
    }

    public void interact()
    {
        //Cave1
        if(Greenfoot.mouseClicked(this) && getWorld() instanceof Cave1 && !chestFar() && cave1 == 0)
        {
            generateDialog("world","You have found a sword and a suit of armor!");
            MainWorld.suit = 1;
            MainWorld.sword = 1;
            cave1 = 1;
            setImage(goldchestopen1);
            if(getImage() == goldchestopen1)
            {
                setImage(goldchestopen2);
            }
            if(getImage() == goldchestopen2)
            {
                setImage(goldchestopen3);
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
