import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Music Button is a visual mute button placed in the world to allow the player to mute the background music
 * GREEN = ON
 * RED = MUTED
 * 
 * @author (Benjamin Presley) 
 * @version (04/30/18)
 */
public class MusicButton extends BensSubSystem
{
    public static int soundmute = 0;
    public MusicButton()
    {
        if(MainWorld.mute == 0) //Check what the global mute variable is set at before deciding what color button to create
        {
            setImage (new GreenfootImage("ui/ButtonGreen.png"));
        }
        else{
            setImage (new GreenfootImage("ui/ButtonRed.png"));
        }
    }

    /**
     * Act - do whatever the MusicButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        buttonClick();
    }    

    /**
     * Check if the button waas clicked.  If so, either mute or un-mute.  
     * Change global mute variable depending on muted or un-muted.
     */
    public void buttonClick()
    {
        if(Greenfoot.mouseClicked(this) && soundmute != 1)
        {
            MainWorld.myworldMusic.stop();
            setImage(new GreenfootImage("ui/ButtonRed.png"));
            soundmute = 1;
            MainWorld.mute = 1;
        }
        else if(Greenfoot.mouseClicked(this) && soundmute == 1)
        {
            MainWorld.myworldMusic.playLoop();
            setImage(new GreenfootImage("ui/ButtonGreen.png"));
            soundmute = 2;
            MainWorld.mute = 0;
        }
    }
}
