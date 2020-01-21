import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the treetop constructor.  it is used so that the player can walk behind the top of the tree, while
 * not being able to walk behind the tree-trunk.  This adds a level of 3d detail to the world.  
 * 
 * @author (Benjamin Presley) 
 * @version (04/26/2018)
 */
public class Treetop extends WorldConstruct
{
    public Treetop()
    {
        //setImage(getSprite(new GreenfootImage("world/Grassland.png"), 1, 704, 320, 896, 128, 128));
        setImage(new GreenfootImage("world/tree/treetop.png"));
        getImage().scale(105,120);
    }
}
