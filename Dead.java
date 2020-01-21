import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Dead appears when the Player has died. Resets health, armor, arrows, gold, shield, sword, bow, and health potions to initial values. 
 * 
 * @author Anthony Neeser
 * @version 5/5/18
 */
public class Dead extends Player
{
    /**
     * Constructor of the dead. Sails the Player over the river Styx, and resets his stats. 
     */
    public Dead() 
    {
        GreenfootImage dead = new GreenfootImage("char/Skeleman/Skeleman_Right_Standing.png");
        dead.rotate(270);
        setImage(dead);
        MainWorld.start = 0;
        MainWorld.playerHealth = 100;
        MainWorld.playerArmor = 0;
        MainWorld.arrowCount = 0;
        MainWorld.gold = 100;
        MainWorld.shield = 0;
        MainWorld.sword = 0;
        MainWorld.bow = 0;
        MainWorld.healthPotion = 0;
        MainWorld.manaPotion = 0;
        MainWorld.spawn = 99;
    }    
}
