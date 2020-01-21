import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the tree base sprite sheet constructor class.  This is used so that we can designate the base of
 * the tree object as something that needs to stay BEHIND the player/nps's.  
 * 
 * @author (Benjamin Presley) 
 * @version (04/26/2018)
 */
public class Treebase extends WorldConstruct
{
    public Treebase()
    {
        //setImage(getSprite(new GreenfootImage("world/Grassland.png"), 1, 896, 256, 1024, 100, 64));
        setImage(new GreenfootImage("world/tree/treebase.png"));
        getImage().scale(80,64);
    }
}
