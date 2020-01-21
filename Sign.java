import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Signs help you navigate through the world. 
 * 
 * @author Matt Marler, Anthony Neeser
 * @version 5/10/18
 */
public class Sign extends Interactables
{
    /**
     * Sign constructor. Sets image for sign. 
     */
    public Sign()
    {
        setImage("Interactables/Sign.png");
    }

    /**
     * Checks how close a player is to the sign object. 
     */
    public boolean signFar()
    {
        return getObjectsInRange(200, Player.class).isEmpty();
    }

    /**
     * Act - do whatever the Sign wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * 
     * @author Matt Marler (Sign generation, sign content, sign placement).
     * @author Anthony Neeser (Quadrant booleans).
     */
    public void act() 
    {
        //Quadrant A
        boolean aA = getX() > 0 && getX() < 269 && getY() > 0 && getY() < 229;
        boolean aB = getX() > 269 && getX() < 539&& getY() > 0&& getY() < 229;
        boolean aC = getX() > 0 && getX() < 269 && getY() > 229 && getY() < 459;
        boolean aD = getX() > 269 && getX() < 539 && getY() > 229 && getY() < 459;

        //Quadrant B
        boolean bA = getX() > 539 && getX() < 809 && getY() > 0 && getY() < 229;
        boolean bB = getX() > 809 && getX() < 1080 && getY() > 0 && getY() < 229;
        boolean bC = getX() > 539 && getX() < 809 && getY() > 229 && getY() < 459;
        boolean bD = getX() > 809 && getX() < 1080 && getY() > 229 && getY() < 459;

        //Quadrant C
        boolean cA = getX() > 0 && getX() < 269 && getY() > 459 && getY() < 689;
        boolean cB = getX() > 269 && getX() < 539 && getY() > 459 && getY() < 689;
        boolean cC = getX() > 0 && getX() < 269 && getY() > 689 && getY() < 920;
        boolean cD = getX() > 269 && getX() < 539 && getY() > 689 && getY() < 920;

        //Quadrant D
        boolean dA = getX() > 539 && getX() < 809 && getY() > 459 && getY() < 689;
        boolean dB = getX() > 809 && getX() < 1080 && getY() > 459 && getY() < 689;
        boolean dC = getX() > 539 && getX() < 809 && getY() > 689 && getY() < 920;
        boolean dD = getX() > 809 && getX() < 1080 && getY() > 689 && getY() < 920;

        //World 6
        if(Greenfoot.mouseClicked(this) && !signFar() && getWorld() instanceof World6 && genericWorldDialog() && worldDialog() && shopDialog() && cC)
        {
            generateDialog("sign", "Shop");
        } 

        //World 13
        if(Greenfoot.mouseClicked(this) && !signFar() && getWorld() instanceof World13 && genericWorldDialog() && worldDialog() && shopDialog() && bB)
        {
            generateDialog("sign", "↖\n\nCastle\n\n↖");
        }

        //World 14
        if(Greenfoot.mouseClicked(this) && !signFar() && getWorld() instanceof World14 && genericWorldDialog() && worldDialog() && shopDialog() && aB)
        {
            generateDialog("sign", "Mines");
        }
    }      

    /**
     * Checks if a generic dialog border is in the world. 
     */
    public boolean genericWorldDialog() 
    {
        return getWorld().getObjects(GenericWorldDialog.class).isEmpty();
    }

    /**
     * Checks if a world dialog is in the world. 
     */
    public boolean worldDialog() 
    {
        return getWorld().getObjects(WorldDialog.class).isEmpty();
    }

    /**
     * Checks if a shop dialog is in the world. 
     */
    public boolean shopDialog() 
    {
        return getWorld().getObjects(ShopDialog.class).isEmpty();
    }
}
