import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Player here.
 * 
 * @author (Benjamin Presley), Anthony Neeser 
 * @version (5/10/2018)
 */
public class Player extends BensSubSystem
{
    private int imageCount, stopped, useTimer;
    private GreenfootSound potion, armorEquip, swordSelect, bowSelect;
    private GreenfootImage left1, left2, left, right1, right2, right, up1, up2, back, down1, down2, front;
    private String[] armorWeapon = {"NoneNone", "NoneBow", "NoneSword", "SuitNone", "SuitBow", "SuitSword"};

    //Track world
    public int spawn = 0;

    //Shadow specifications
    private int shadowImageWidth = 64;
    private int shadowImageHeight = 128;
    private int shadowX = 17;
    private int shadowY = 82;
    private int shadowWidth = 35;
    private int shadowHeight = 20;

    private int counter = 15;
    /**
     *  Sets playable character images, and scales to proper size.. 
     */
    public Player() 
    {
        potion = new GreenfootSound("effects/potionUse.mp3");
        armorEquip = new GreenfootSound("effects/armorEquip.mp3");
        swordSelect = new GreenfootSound("effects/swordSelect.wav");
        bowSelect = new GreenfootSound("effects/bowSelect.mp3");
        initializeImages(armorWeapon[0]);
        setImage(front);
        MainWorld.start = 1;
    }

    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        getWorld().addObject(new Shadow(shadowImageWidth, shadowImageHeight, shadowX, shadowY, shadowWidth, shadowHeight), getX(), getY());
        if(imageCount ==10)
        {
            imageCount = 0;
        }
        checkKeys();
        newState();        
        imageCount++;
        stopAtBarrier();
        enterDoor();
        checkWeapon();
        transferWorlds();
        infoBar();
        reset();
        dying(); 
    }  

    /**
     * Tracks important information, such as health, armor, and mana.
     * @author Anthony Neeser
     */
    public void infoBar()
    {
        generateDialog("Health: "+MainWorld.playerHealth, "   Mana: "+ MainWorld.playerMana, "Shield: "+MainWorld.playerArmor, "Arrows: "+MainWorld.arrowCount, 
            "   H.Potions: "+MainWorld.healthPotion, "   M.Potions: "+MainWorld.manaPotion, " Gold: "+MainWorld.gold, "World: "+MainWorld.spawn);
    }

    /**
     * Method checks for key presses to move character or interact with world.
     * @author Benjamin Presley, Anthony Neeser
     */
    private void checkKeys() //added WASD for my own sanity -James
    {
        if(Greenfoot.isKeyDown("up")||Greenfoot.isKeyDown("w"))
        {
            setLocation(getX(), getY()-1);
            if(imageCount == 1)
            {
                if(getImage() == up1)
                {
                    setImage(up2);
                }
                else
                {
                    setImage(up1);
                }
                stopped = 3;
            }
        }
        if(Greenfoot.isKeyDown("down")||Greenfoot.isKeyDown("s"))
        {
            setLocation(getX(), getY()+1);
            if(imageCount == 1)
            {
                if(getImage() == down1)
                {
                    setImage(down2);
                }
                else
                {
                    setImage(down1);
                }
                stopped = 1;
            }
        }
        if(Greenfoot.isKeyDown("right")||Greenfoot.isKeyDown("d"))
        {
            setLocation(getX()+1, getY());
            if(imageCount == 1)
            {
                if(getImage() == right1)
                {
                    setImage(right2);
                }
                else
                {
                    setImage(right1);
                }
                stopped = 4;
            }
        }
        if(Greenfoot.isKeyDown("left")||Greenfoot.isKeyDown("a"))
        {
            setLocation(getX()-1, getY());
            if(imageCount == 1)
            {
                if(getImage() == left1)
                {
                    setImage(left2);
                }
                else
                {
                    setImage(left1);
                }
                stopped = 2;
            }
        }
        if(!Greenfoot.isKeyDown("up")&&!Greenfoot.isKeyDown("down")&&!Greenfoot.isKeyDown("right")&&!Greenfoot.isKeyDown("left"))
        {
            if(!Greenfoot.isKeyDown("w")&&!Greenfoot.isKeyDown("a")&&!Greenfoot.isKeyDown("s")&&!Greenfoot.isKeyDown("d"))
            {
                switch(stopped)
                {
                    case 3: setImage(back); break;
                    case 1: setImage(front); break;
                    case 4: setImage(right); break;
                    case 2: setImage(left); break;
                }
            }
        }

        //Use mana potion
        if(Greenfoot.isKeyDown("m") && useTimer > 50)
        {
            if(MainWorld.manaPotion == 1)
            {
                potion.play();
                MainWorld.playerMana += 50;
                MainWorld.manaPotion--;
                useTimer = 0;
            }
            else if(MainWorld.manaPotion > 1 && MainWorld.playerMana < 100)
            {
                potion.play();
                MainWorld.manaPotion--;
                MainWorld.playerMana += 50;
                useTimer = 0;
            }
        }
        if(MainWorld.playerMana > 100)
        {
            MainWorld.playerMana = 100;
        }

        //Use health potion
        if(Greenfoot.isKeyDown("h") && useTimer > 50)
        {
            if(MainWorld.healthPotion == 1)
            {
                potion.play();
                MainWorld.playerHealth += 50;
                MainWorld.healthPotion--;
                useTimer = 0;
            }
            else if(MainWorld.healthPotion > 1 && MainWorld.playerHealth < 100)
            {
                potion.play();
                MainWorld.healthPotion--;
                MainWorld.playerHealth += 50;
                useTimer = 0;
            }
        }
        if(MainWorld.playerHealth > 100)
        {
            MainWorld.playerHealth = 100;
        }
        useTimer++;

        //Weapon change
        if(Greenfoot.isKeyDown("1") && MainWorld.sword == 1)
        {
            swordSelect.play();
            MainWorld.swordActive = true;
            if(MainWorld.bowActive == true)
            {
                MainWorld.bowActive = false;
            }
            MainWorld.state = 1;
        }
        if(Greenfoot.isKeyDown("2") && MainWorld.bow == 1)
        {
            bowSelect.play();
            MainWorld.bowActive = true;
            if(MainWorld.swordActive == true)
            {
                MainWorld.swordActive = false;
            }
            MainWorld.state = 1;
        }

        //Suit change
        if(Greenfoot.isKeyDown("9") && MainWorld.suit == 1)
        {
            armorEquip.play();
            MainWorld.suitActive = true;
            MainWorld.state = 1;
        }
        if(Greenfoot.isKeyDown("0"))
        {
            armorEquip.play();
            MainWorld.suitActive = false;
            MainWorld.state = 1;
        }

        //Reset function
        if(Greenfoot.isKeyDown("backspace"))
        {
            MainWorld.spawn = 99;
            MainWorld.start = 0;
        }

        //Instructions
        if(Greenfoot.isKeyDown("i") && getWorld().getObjects(InstructionDialog.class).isEmpty())
        {
            instructions("\n\n- Welcome to King Orin's Quest! - \n\n1. There are twenty five main worlds, in five rows of five. \n The world numbers start at one\nat the top left, and end with twenty five on the bottom right.\n\n2. In addition to the twenty five worlds, there is also a shop, \ncaves, castle, and house that you can enter.\n\n3. Clicking on signs and NPCs will return dialog that will \n help guide you on your journey.\n\n4. Visit the shop to purchase items such as weapons and potions. \n\n5. If you have equipped a weapon, you can press -space- to \n attack in the direction of your mouse cursor.\n\n6. If magic is available and a spell is selected, press -f-\n to cast a fireball, or -c- to cast an iceball in the direction of your cursor.\n\n7. Press -h- to use a health potion, which will restore 50 points of health.\n\n8. Press -m- to use a mana potion, which will restore 50 points of mana.\n\n9. If you become stuck, press -backspace- to return to your \n original starting position.\n\n10. If you die, click -run- to reset stats and restart the game.\n\n\nMost importantly, have fun! \n If you like the game, please vote, follow, and tell your friends!\n\n(Press escape to exit instructions)");
        }
    }

    /**
     * Method identifies if player is touching barrier object and prevents player
     * from moving further in the direction of the barrier.
     */
    public void stopAtBarrier()
    {
        if ( isTouching(Barrier.class) && Greenfoot.isKeyDown("up") || isTouching(Barrier.class) && Greenfoot.isKeyDown("w"))
        {
            setLocation(getX(), getY()+1);
        } 
        if ( isTouching(Barrier.class) && Greenfoot.isKeyDown("down") || isTouching(Barrier.class) && Greenfoot.isKeyDown("s"))
        {
            setLocation(getX(), getY()-1);
        } 
        if ( isTouching(Barrier.class) && Greenfoot.isKeyDown("left") || isTouching(Barrier.class) && Greenfoot.isKeyDown("a"))
        {
            setLocation(getX()+1, getY());
        } 
        if (isTouching(Barrier.class) && Greenfoot.isKeyDown("right") || isTouching(Barrier.class) && Greenfoot.isKeyDown("d"))
        {
            setLocation(getX()-1, getY());
        } 
    }

    /**
     * Identifies when the player has made contact with the door entrance and transfers the 
     * player to the appropriate world.  Also starts the playing of the music.
     */
    public void enterDoor()
    {
        //Castle
        if(isTouching(CastleEntrance.class))
        {
            MainWorld.spawn = 26;
            //MainWorld.?.pause();
            Greenfoot.setWorld(new Castle());
            if(MainWorld.mute !=1)
            {
                //MainWorld.?.playLoop();
            }
        }
        if(isTouching(CastleExit.class))
        {
            MainWorld.spawn = 32;
            //MainWorld.?.pause();
            Greenfoot.setWorld(new World1());
            if(MainWorld.mute !=1)
            {
                //MainWorld.?.playLoop();
            }
        }

        //Shop
        if(isTouching(ShopDoorEntrance.class))
        {
            MainWorld.spawn = 27;
            MainWorld.myworldMusic.pause();
            Greenfoot.setWorld(new Shop());
            if(MainWorld.mute != 1)
            {
                MainWorld.caveworldMusic.playLoop();
            }
        }
        if(isTouching(ShopDoorExit.class))
        {
            MainWorld.spawn = 31;
            //MainWorld.spawn = 33;
            MainWorld.caveworldMusic.pause();
            Greenfoot.setWorld(new World6());
            //Greenfoot.setWorld(new World6());
            if(MainWorld.mute !=1)
            {
                MainWorld.myworldMusic.playLoop();
            }
        }

        //Cave1
        if(isTouching(Cave1Entrance.class))
        {
            MainWorld.spawn = 28;
            //MainWorld.caveworldMusic.pause();
            Greenfoot.setWorld(new Cave1());
            if(MainWorld.mute !=1)
            {
                //MainWorld.?.playLoop();
            }
        }
        if(isTouching(Cave1Exit.class))
        {
            MainWorld.spawn = 33;
            //MainWorld.?.pause();
            Greenfoot.setWorld(new World14());
            if(MainWorld.mute !=1)
            {
                //MainWorld.?.playLoop();
            }
        }

        //Cave2
        if(isTouching(Cave2Entrance.class))
        {
            MainWorld.spawn = 29;
            //MainWorld.?.pause();
            Greenfoot.setWorld(new Cave2());
            if(MainWorld.mute !=1)
            {
                //MainWorld.?.playLoop();
            }
        }
        if(isTouching(Cave2Exit.class))
        {
            MainWorld.spawn = 34;
            //MainWorld.?.pause();
            Greenfoot.setWorld(new World15());
            if(MainWorld.mute !=1)
            {
                //MainWorld.?.playLoop();
            }
        }

        //OldManHouse
        if(isTouching(OldManHouseEntrance.class))
        {
            MainWorld.spawn = 30;
            //MainWorld.?.pause();
            Greenfoot.setWorld(new OldManHouse());
            if(MainWorld.mute !=1)
            {
                //MainWorld.?.playLoop();
            }
        }
        if(isTouching(OldManHouseExit.class))
        {
            MainWorld.spawn = 35;
            //MainWorld.?.pause();
            Greenfoot.setWorld(new World25());
            if(MainWorld.mute !=1)
            {
                //MainWorld.?.playLoop();
            }
        }
    }

    /**
     * The transferWorlds method is used to detect when a player is at the edge of the screen, and store needed data for 
     * transfering to the appropriate world.  This information is used by the new world to determine the player location
     * after creation.
     */
    public void transferWorlds()
    {
        if ( getX() == 0)
        {
            if(MainWorld.leftWorldID != 99)
            {
                MainWorld.playerX = 1075;
                MainWorld.playerY = getY();
                MainWorld.spawn = MainWorld.leftWorldID;
                MainWorld.worldDirection = "right";
                MainWorld.lastWorld = MainWorld.rightWorldID;
                spawnWorld();
            }
        }
        if ( getX() == 1079)
        {
            if(MainWorld.rightWorldID != 99)
            {
                MainWorld.playerX = 10;
                MainWorld.playerY = getY();
                MainWorld.spawn = MainWorld.rightWorldID;
                MainWorld.worldDirection = "left";
                MainWorld.lastWorld = MainWorld.leftWorldID;
                spawnWorld();
            }
        }
        if ( getY() == 0)
        {
            if(MainWorld.topWorldID != 99)
            {
                MainWorld.playerX = getX();
                MainWorld.playerY = 910;
                MainWorld.spawn = MainWorld.topWorldID;
                MainWorld.worldDirection = "bottom";
                MainWorld.lastWorld = MainWorld.topWorldID;
                spawnWorld();
            }
        }
        if ( getY() == 918)
        {
            if(MainWorld.bottomWorldID != 99)
            {
                MainWorld.playerX = getX();
                MainWorld.playerY = 10;
                MainWorld.spawn = MainWorld.bottomWorldID;
                MainWorld.worldDirection = "top";
                MainWorld.lastWorld = MainWorld.bottomWorldID;
                spawnWorld();
            }
        }
    }

    /**
     * The spawnWorld method takes the spawn variable from MainWorld and uses it to create the appropriate world.
     */
    public void spawnWorld()
    {
        if(MainWorld.spawn == 1)
        {
            Greenfoot.setWorld(new World1());
        }
        if(MainWorld.spawn == 2)
        {
            Greenfoot.setWorld(new World2());
        }
        if(MainWorld.spawn == 3)
        {
            Greenfoot.setWorld(new World3());
        }
        if(MainWorld.spawn == 4)
        {
            Greenfoot.setWorld(new World4());
        }
        if(MainWorld.spawn == 5)
        {
            Greenfoot.setWorld(new World5());
        }
        if(MainWorld.spawn == 6)
        {
            Greenfoot.setWorld(new World6());
        }
        if(MainWorld.spawn == 7)
        {
            Greenfoot.setWorld(new World7());
        }
        if(MainWorld.spawn == 8)
        {
            Greenfoot.setWorld(new World8());
        }
        if(MainWorld.spawn == 9)
        {
            Greenfoot.setWorld(new World9());
        }
        if(MainWorld.spawn == 10)
        {
            Greenfoot.setWorld(new World10());
        }
        if(MainWorld.spawn == 11)
        {
            Greenfoot.setWorld(new World11());
        }
        if(MainWorld.spawn == 12)
        {
            Greenfoot.setWorld(new World12());
        }
        if(MainWorld.spawn == 13)
        {
            Greenfoot.setWorld(new World13());
        }
        if(MainWorld.spawn == 14)
        {
            Greenfoot.setWorld(new World14());
        }
        if(MainWorld.spawn == 15)
        {
            Greenfoot.setWorld(new World15());
        }
        if(MainWorld.spawn == 16)
        {
            Greenfoot.setWorld(new World16());
        }
        if(MainWorld.spawn == 17)
        {
            Greenfoot.setWorld(new World17());
        }
        if(MainWorld.spawn == 18)
        {
            Greenfoot.setWorld(new World18());
        }
        if(MainWorld.spawn == 19)
        {
            Greenfoot.setWorld(new World19());
        }
        if(MainWorld.spawn == 20)
        {
            Greenfoot.setWorld(new World20());
        }
        if(MainWorld.spawn == 21)
        {
            Greenfoot.setWorld(new World21());
        }
        if(MainWorld.spawn == 22)
        {
            Greenfoot.setWorld(new World22());
        }
        if(MainWorld.spawn == 23)
        {
            Greenfoot.setWorld(new World23());
        }
        if(MainWorld.spawn == 24)
        {
            Greenfoot.setWorld(new World24());
        }
        if(MainWorld.spawn == 25)
        {
            Greenfoot.setWorld(new World25());
        }
        if(MainWorld.spawn == 26)
        {
            Greenfoot.setWorld(new Castle());
        }
        if(MainWorld.spawn == 27)
        {
            Greenfoot.setWorld(new Shop());
        }
        if(MainWorld.spawn == 28)
        {
            Greenfoot.setWorld(new Cave1());
        }
        if(MainWorld.spawn == 29)
        {
            Greenfoot.setWorld(new Cave2());
        }
        if(MainWorld.spawn == 30)
        {
            Greenfoot.setWorld(new OldManHouse());
        }
        //These statements are for returning from the worlds outside the main map.  
        //Instead of simply returning to the world they departed from, the world 
        //will spawn the character at a specific location outside the entrances 
        //to these worlds.  

        //Returning from Cave 1
        if(MainWorld.spawn == 31) 
        {
            Greenfoot.setWorld(new World6());
        }
        //Returning from Castle
        if(MainWorld.spawn == 32) 
        {
            Greenfoot.setWorld(new World1());
        }
        //Returning from Town Shop
        if(MainWorld.spawn == 33) 
        {
            Greenfoot.setWorld(new World6());
        }
        //Returning from Cave 2
        if(MainWorld.spawn == 34) 
        {
            Greenfoot.setWorld(new World15());
        }
        //Returning from Old Man's House
        if(MainWorld.spawn == 35) 
        {
            Greenfoot.setWorld(new World25());
        }
    }

    /**
     * This controls the action taken when a player dies.
     * Resets variables to 0, and creates the ending dialog with instructions for restarting game.
     */
    public void dying()
    {
        if(MainWorld.playerHealth <= 0)
        {
            MainWorld.start = 0;
            MainWorld.spawn = 0;
            if(MainWorld.start == 0)
            {
                getWorld().addObject(new Dead(), getX(), getY()+32);
                generateDialog("How could this happen...?","You have died...","Click Run to try again.");
                getWorld().removeObject(this);
            }
            Greenfoot.stop();
        }
    }

    //Shoot variables
    private String ammo;
    private int reloadTime;
    private int shootCounter;
    private int speed;
    private int ammoWidth;
    private int ammoHeight;
    private int countdown;
    private int clickedX;
    private int clickedY;
    /**
     * Checks which weapon can be used.
     * @author Anthony Neeser 
     */
    public void checkWeapon()
    {
        if(MainWorld.bow == 1)
        {
            if(MainWorld.arrowCount > 0)
            {
                if(MainWorld.bowActive)
                {
                    if(Greenfoot.isKeyDown("space"))
                    {
                        ammo = "arrow";
                        reloadTime = 50;
                        speed = 10;
                        ammoWidth = 18;
                        ammoHeight = 7;
                        countdown = 25;
                        shoot();
                    }
                }
            }
        }

        if(MainWorld.sword == 1)
        {
            if(MainWorld.swordActive ==true)
            {
                if(Greenfoot.isKeyDown("space"))
                {
                    ammo = "sword";
                    reloadTime = 35;
                    speed = 5;
                    ammoWidth = 18;
                    ammoHeight = 50;
                    countdown = 20;
                    shoot();
                }
            }
        }

        if(Greenfoot.isKeyDown("f"))
        {
            if(MainWorld.playerMana >= 10)
            {   
                ammo = "fireball";
                reloadTime = 40;
                speed = 10;
                ammoWidth = 20;
                ammoHeight = 20;
                countdown = 25;
                shoot();
            }
        }

        if(Greenfoot.isKeyDown("c"))
        {
            if(MainWorld.playerMana >= 10)
            {   
                ammo = "iceball";
                reloadTime = 40;
                speed = 10;
                ammoWidth = 20;
                ammoHeight = 20;
                countdown = 25;
                shoot();
            }
        }
    }

    /**
     * Handles projectile use by player. Checks for mouse clicks in the world, converts click location to 
     * projectile rotation to send projectiles in specific direction. 
     * @author  Anthony Neeser
     */
    private void shoot()
    {
        if(dialog())
        {
            clickedX = Greenfoot.getMouseInfo().getX();
            clickedY = Greenfoot.getMouseInfo().getY();

            double dx = clickedX -  getX();
            double dy = clickedY - getY();
            double rotation = Math.atan2(dy,dx)*180.0/Math.PI;
            int miss = Greenfoot.getRandomNumber(17)-8;
            if(shootCounter>reloadTime)
            {
                switch(ammo)
                {
                    case "fireball": Greenfoot.playSound("effects/fireball.mp3");getWorld().addObject(new PlayerFireball(speed, (int)rotation, ammoWidth, ammoHeight, countdown), getX(), getY());MainWorld.playerMana-=10; break;
                    case "iceball": Greenfoot.playSound("effects/iceball.mp3");getWorld().addObject(new PlayerIceball(speed, (int)rotation, ammoWidth, ammoHeight, countdown), getX(), getY());MainWorld.playerMana-=10; break;
                    case "arrow": Greenfoot.playSound("effects/bowShot.mp3");getWorld().addObject(new PlayerArrow(speed, (int)rotation, ammoWidth, ammoHeight, countdown), getX(), getY()); MainWorld.arrowCount--; break;
                    case "sword": Greenfoot.playSound("effects/swordSwing.mp3");getWorld().addObject(new PlayerSlash(speed, stopped*90-1, ammoWidth, ammoHeight, countdown), getX(), getY()); break;
                }
                shootCounter=0;
            }
            shootCounter++;
        }
    }

    /**
     * Checks if shop dialog is open. 
     * @author Anthony Neeser
     */
    public boolean dialog() 
    {
        return getWorld().getObjects(ShopDialogBorder.class).isEmpty();
    }

    /**
     * State change of player will call intialize images to set new images;
     * @author Anthony Neeser
     */
    public void newState()
    {
        //"NoneNone", "NoneBow", "NoneSword", "SuitNone", "SuitBow", "SuitSword"
        if(MainWorld.state == 1)
        {
            if(MainWorld.suitActive == false && MainWorld.bowActive == false && MainWorld.swordActive == false)
            {
                initializeImages(armorWeapon[0]);
                MainWorld.state = 0;
            }
            if(MainWorld.suitActive == false && MainWorld.bowActive)
            {
                //initializeImages(armorWeapon[1]);
                initializeImages(armorWeapon[0]);
                MainWorld.state = 0;
            }
            if(MainWorld.suitActive == false && MainWorld.swordActive)
            {
                initializeImages(armorWeapon[2]);
                MainWorld.state = 0;
            }
            if(MainWorld.suitActive && MainWorld.bowActive == false && MainWorld.swordActive == false)
            {
                initializeImages(armorWeapon[3]);
                MainWorld.state = 0;
            }
            if(MainWorld.suitActive && MainWorld.bowActive)
            {
                //initializeImages(armorWeapon[4]);
                MainWorld.state = 0;
            }
            if(MainWorld.suitActive && MainWorld.swordActive)
            {
                //initializeImages(armorWeapon[5]);
                MainWorld.state = 0;
            }
        }
    }

    /**
     * Called to intialized images based on state of character and what items he has. 
     * @author Anthony Neeser
     */
    public void initializeImages(String state)
    {
        left1= new GreenfootImage("char/Player/"+state+"/Player"+state+"left1.png");
        left2= new GreenfootImage("char/Player/"+state+"/Player"+state+"left2.png");
        left= new GreenfootImage("char/Player/"+state+"/Player"+state+"left.png");
        right1= new GreenfootImage("char/Player/"+state+"/Player"+state+"right1.png");
        right2= new GreenfootImage("char/Player/"+state+"/Player"+state+"right2.png");
        right= new GreenfootImage("char/Player/"+state+"/Player"+state+"right.png");
        up1= new GreenfootImage("char/Player/"+state+"/Player"+state+"up1.png");
        up2= new GreenfootImage("char/Player/"+state+"/Player"+state+"up2.png");
        back= new GreenfootImage("char/Player/"+state+"/Player"+state+"back.png");
        down1= new GreenfootImage("char/Player/"+state+"/Player"+state+"down1.png");
        down2= new GreenfootImage("char/Player/"+state+"/Player"+state+"down2.png");
        front= new GreenfootImage("char/Player/"+state+"/Player"+state+"front.png");
    }

    /**
     * Reset allows player to reset game to initial values. 
     */
    public void reset()
    {
        if(Greenfoot.isKeyDown("p"))
        {
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
            MainWorld.spawn = 0;
        }
    }
}
