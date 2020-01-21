import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This object is for detecting player leaving the Castle
 * 
 * @author (Benjamin Presley) 
 * @version (04/30/18)
 */
public class CastleExit extends Exits
{
    public CastleExit()
    {
        GreenfootImage g = new GreenfootImage("world/Barrier2.png"); 
        g.scale(g.getWidth() + 10, g.getHeight() + 10);
        setImage(g); 
    }

    /**
     * Act - do whatever the Barrier wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
