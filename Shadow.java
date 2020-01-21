import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Shadow is used under NPCs to add a little realism.
 * 
 * @author Anthony Neeser
 * @version 4/30/18
 */
public class Shadow extends Actor
{
    private GreenfootImage shadow;
    private Color shadowGray;
    /**
     * Shadow constructor sets values for x, y, width, height, of shadows, and sets their image. 
     */
    public Shadow(int sW, int sH, int xOff, int yOff, int w, int h) 
    {
        shadow = new GreenfootImage(sW, sH);
        shadowGray = new Color(0,0,0,75);
        shadow.setColor(shadowGray);
        shadow.fillOval(xOff, yOff, w, h);
        setImage(shadow);
    }    

    /**
     * Act - do whatever the Shadow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
            getWorld().removeObject(this);
    }
}
