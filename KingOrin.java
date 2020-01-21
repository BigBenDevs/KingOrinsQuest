import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the sad king.
 * 
 * @author (Ben Presley) 
 * @version (5/9/18)
 */
public class KingOrin extends BensSubSystem
{
    //Dialog prompt
    private int counter = 0;
    private int set = 0;
    private int dbCount = MainWorld.dBKing + 1;
    private GreenfootImage kingOrinImage;
    public KingOrin()
    {
        kingOrinImage = new GreenfootImage("char/King/KingFront.png");
        setImage(kingOrinImage);
    }

    /**
     * Act - do whatever the KingOrin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this) && set != 1 && worldDialog())
        {
            dialog1();
            set = 1;
        }
        if(set == 1 && counter < dbCount)
        {
            counter++;
        }
        dialog2();
        //generateDialog("world", "Thank you for coming Hawthorn. /n  I need your help now more than ever.");
    }  

    public void dialog1()
    {
        if(MainWorld.pirateDead == 0)
        {
            generateDialog("world", "Thank you for coming Hawthorn. \n  I need your help now more than ever. \n That terrible pirate has taken my daughter!");
        }
        if(MainWorld.pirateDead == 1)
        {
            generateDialog("world", "Thank you for saving my Daughter! \n  You are truly the greatest hero in the land.");
        }
    }

    public void dialog2()
    {
        if(counter == dbCount)
        {
            if(MainWorld.pirateDead == 0 && MainWorld.quest == 0)
            {
                generateDialog("world", "Find her and bring her back to me. \n The shop keep in town will outfit you.");
                MainWorld.quest = 1;
            }
            if(MainWorld.pirateDead == 1 && MainWorld.quest == 1)
            {
                generateDialog("world", "Take this as a token of my grattitude.");
                MainWorld.gold = MainWorld.gold + 1000;
                MainWorld.quest = 2;
            }
            counter = 0;
            set = 0;
            
            //System.out.println(MainWorld.quest);
        }
    }

    /**
     * Checks if a world dialog is in the world. 
     */
    public boolean worldDialog() 
    {
        return getWorld().getObjects(WorldDialog.class).isEmpty();
    }
}
