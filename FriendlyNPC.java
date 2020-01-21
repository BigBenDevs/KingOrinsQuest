import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Superclass of friendly NPCs. Acts as a separator to keep enemy npcs and friendly npcs separate in the actor tree.
 * Also used to grant generic dialog and some specific dialog to npcs who call its methods. 
 * 
 * @author Anthony Neeser
 * @version 4/28/18
 */
public class FriendlyNPC extends NPC
{
    /**
     * Generic dialog is basic messages that villagers will say when you click on them. A random message will display with each click.
     */
    public void genericDialog()
    {
        int choose = Greenfoot.getRandomNumber(8);
        if(Greenfoot.mouseClicked(this) && genericWorldDialog() && worldDialog() && shopDialog())
        {
            switch(choose)
            {
                case 0:  generateDialog("world", "It's so nice out today.\n\nDon't you think so?");break;
                case 1:  generateDialog("world", "The princess is so lovely!\n\nThe kingdom is so lucky to have her!");break;
                case 2:  generateDialog("world", "Gosh I hope I never have to deal with the Pirate!");break;
                case 3:  generateDialog("world", "Have you explored the whole kingdom?");break;
                case 4:  generateDialog("world", "The shopkeeper has some great items..\n\nYou should pay him a visit!");break;
                case 5:  generateDialog("world", "Did you know that buying a shield helps keep you alive?\n\nMight be handy in a fight!");break;
                case 6:  generateDialog("world", "I heard that if you take out enemies,\nthey drop gold!");break;
                case 7:  generateDialog("world", "You look really strong!\n\nAre you a hero?");break;
                case 8:  generateDialog("world", "");break;
                case 9:  generateDialog("world", "");break;
                case 10: generateDialog("world", "");break;
                case 11: generateDialog("world", "");break;
                case 12: generateDialog("world", "");break;
                case 13: generateDialog("world", "");break;
                case 14: generateDialog("world", "");break;
                case 15: generateDialog("world", "");break;
                case 16: generateDialog("world", "");break;
                case 17: generateDialog("world", "");break;
                case 18: generateDialog("world", "");break;
                case 19: generateDialog("world", "");break;
            }
        }
    }

    /**
     * This generic dialog method allows for villagers to recomment buying health potions if your health is low,
     * and for specific npcs to say personalized messages to the player. 
     */
    public void genericDialog(String option)
    {
        if(Greenfoot.mouseClicked(this) && genericWorldDialog() && worldDialog() && shopDialog())
        {
            switch(option)
            {
                case "health": 
                if(MainWorld.playerHealth < 30)
                {
                    generateDialog("world", "You're looking pretty beat up!\n\nYou should go buy some health potions!");
                }
                else
                {
                    genericDialog();
                }
                break;
                
                case "chloe": 
                generateDialog("world", "- Chloe -\n\n\nWow, I see you've collected "+MainWorld.mushroomCount+" mushrooms!\nThat's really cool!");
                break;
                
                case "knight": 
                if(MainWorld.playerHealth < 30)
                {
                    generateDialog("world", "You look weary...\n\nIf you're injured, you should patch\nyourself up with a health potion.");
                }
                else
                {
                    generateDialog("world", "Citizen, take care.\nThere are many enemies throughout the land.\nKeep your inventory full and your eyes keen.");
                }
                break;
                
                case "james": 
                generateDialog("world", "- James - \n\nBoy, are my fingers tired...\nSo much typing...\nOh, typing? It's uh, hard to explain...");
                break;
                
                case "c": 
                generateDialog("world", "");
                break;
            }
        }
    }

    /**
     * Checks if a world dialog is in the world. 
     */
    public boolean worldDialog() 
    {
        return getWorld().getObjects(WorldDialog.class).isEmpty();
    }

    /**
     * Checks if a generic world dialog is in the world. 
     */
    public boolean genericWorldDialog() 
    {
        return getWorld().getObjects(GenericWorldDialog.class).isEmpty();
    }

    /**
     * Checks if a shop dialog is in the world. 
     */
    public boolean shopDialog() 
    {
        return getWorld().getObjects(ShopDialog.class).isEmpty();
    }
}