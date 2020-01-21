import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Superclass of NPCs. Handles variables passed from unique subclasses of EnemyNPC and FriendlyNPC to set images, 
 * image sizes, animation speed, walk speed, when to change walking directions, saves last known walking 
 * direction to display a corresponding image during resting periods, works to move an NPC when they encounter 
 * a barrier, changes NPC directions when they bump into each other, stops movement when certain dialog boxes are open,
 * and handles what happens when friendly npcs become angry, .  
 * 
 * In the case of EnemyNPC: NPC handles detection of main character, movement to main character, stopping to 
 * face main character, and shooting projectiles at main character.  
 * 
 * @author Anthony Neeser
 * @version 5/5/18
 */
public class NPC extends JimboSubSystem
{
    private int moveCount, walkCount, imageCount, moveWhich, stepCounter, walkCountChange, actorImageCount, mcX, mcY, mcDistance, stopped, direction, shootCounter;
    private boolean walk;
    private String filePath;

    /**
     * NPC constructor. Parses variables passed by npcs. 
     */
    public void variablePass(String pathPass, int unused, int shadowImageWidth, int shadowImageHeight, int shadowX, int shadowY, int shadowWidth, int shadowHeight, 
    int stepDelay, int dirSwitch, int mcRange, boolean angry, String classType, String projectile, int projectileWidth, int projectileHeight, int shotSpeed, 
    int removalCount, int reloadDelay)
    {
        getWorld().addObject(new Shadow(shadowImageWidth, shadowImageHeight, shadowX, shadowY, shadowWidth, shadowHeight), getX(), getY());
        varCycle(stepDelay, dirSwitch, mcRange);
        mcXY();
        if(angry ==true)
        {
            pickClassType(projectile, projectileWidth, projectileHeight, shotSpeed, reloadDelay, removalCount, classType);
        }
        else
        {
            if(!barrierFar() || isAtEdge())
            {            
                moveChange();
                barrier();
            }
            if(!npcFar())
            {
                npc();
            }
            if(barrierFar()||npcFar())
            {
                movement();
            }
        }
        filePath = pathPass;
    }

    /**
     * Sets npc class type. Useful for turning friendly npcs into enemies when certain conditions are met. 
     */
    public void pickClassType(String p, int pW, int pH, int sS, int rD, int rC, String cT )
    {
        String projectile = p;
        int projectileWidth = pW; 
        int projectileHeight = pH; 
        int shotSpeed = sS;
        int reloadDelay = rD;
        int removalCount = rC;
        String classType = cT;

        switch(classType)
        {
            case "archer": followMcWithGap();shoot(projectile, projectileWidth, projectileHeight, shotSpeed, reloadDelay, removalCount);break;

            case "spearman": followMcWithGap();shoot(projectile, projectileWidth, projectileHeight, shotSpeed, reloadDelay, removalCount);break;

            case "melee": followMcClose();shoot(projectile, projectileWidth, projectileHeight, shotSpeed, reloadDelay, removalCount);break;
            
            case "wizard": followMcWithGap();shoot(projectile, projectileWidth, projectileHeight, shotSpeed, reloadDelay, removalCount);break;
        }
    }

    /**
     * Shoot a specified projectile of ammo type, speed, delay between shots. 
     */
    public void shoot(String ammo, int ammoWidth, int ammoHeight, int speed, int reloadTime, int countdown)
    {
        double dx = mcX - getX();
        double dy = mcY - getY();
        double rotation = Math.atan2(dy,dx)*180.0/Math.PI;
        int miss = Greenfoot.getRandomNumber(17)-8;
        if(Greenfoot.getRandomNumber(10)+1 > 5)
        {
            rotation+=miss;
        }
        if(!mcFar())
        {
            if(shootCounter>reloadTime)
            {
                switch(ammo)
                {
                    case "fireball": Greenfoot.playSound("effects/fireball.mp3");getWorld().addObject(new Fireball(speed, (int)rotation, ammoWidth, ammoHeight, countdown), getX(), getY()); break;
                    case "iceball": Greenfoot.playSound("effects/iceball.mp3");getWorld().addObject(new Iceball(speed, (int)rotation, ammoWidth, ammoHeight, countdown), getX(), getY()); break;
                    case "arrow": Greenfoot.playSound("effects/bowShot.mp3");getWorld().addObject(new Arrow(speed, (int)rotation, ammoWidth, ammoHeight, countdown), getX(), getY()); break;
                    case "spear": Greenfoot.playSound("effects/spear.mp3");getWorld().addObject(new Spear(speed, (int)rotation, ammoWidth, ammoHeight, countdown), getX(), getY()); break;
                    case "sword": Greenfoot.playSound("effects/swordSwing.mp3");getWorld().addObject(new Slash(speed, (int)rotation, ammoWidth, ammoHeight, countdown), getX(), getY()); break;
                }
                shootCounter=0;
            }
        }
        shootCounter++;
    }

    /**
     * Continuously collects main character coordinates and passes them to mcX and mcY variables. 
     */
    public void mcXY()
    {
        //Change instances of "Rabbit" and "Rabbit.class" to main character values.
        List<Player> mainChar = getWorld().getObjects(Player.class);
        for(Player player : mainChar)
        {
            mcX = player.getX();
            mcY = player.getY();
        }
    }

    /**
     * Checks distance of NPC from main character. Integer is pixel distance. 
     */
    public boolean mcFar() 
    {
        return getObjectsInRange(mcDistance, Player.class).isEmpty();
    }

    /**
     * Checks if a barrier is within set range.
     */
    public boolean barrierFar() 
    {
        return getObjectsInRange(73, Barrier.class).isEmpty();
    }

    /**
     * Checks if a barrier is within set range.
     */
    public boolean npcFar() 
    {
        return getObjectsInRange(64, FriendlyNPC.class).isEmpty();
    }

    /**
     * Moves character and changes direction when contacting a barrier.
     */
    public void barrier()
    {
        switch(stopped)//direction
        {
            case 1: setLocation(getX()+1, getY()); break; //left
            case 2: setLocation(getX()-1, getY()); break; //right
            case 3: setLocation(getX(), getY()+1); break; //up
            case 4: setLocation(getX(), getY()-1); break; //down
        }

        switch(moveWhich)
        {
            case 1: moveWhich = 4; break;
            case 2: moveWhich = 3; break;
            case 3: moveWhich = 2; break;
            case 4: moveWhich = 1; break;
        }
    }

    /**
     * Switch directions when contacting another npc.
     */
    public void npc()
    {
        switch(moveWhich)
        {
            case 1: moveWhich = 4; break;
            case 2: moveWhich = 3; break;
            case 3: moveWhich = 2; break;
            case 4: moveWhich = 1; break;
        }
    }

    /**
     * Resets direction.
     */
    public void moveChange()
    {
        moveCount = 1;
    }

    /**
     * Handles cycling of variables so that they keep counting as necessary.
     */
    public void varCycle(int step, int moveSwitch, int mcNear)
    {
        if(moveCount == 1)
        {
            moveWhich = Greenfoot.getRandomNumber(5)+1;
        }
        //Image change timer resets to zero when reaching user set variable. 
        if(imageCount == 21)
        {
            imageCount = 0;
        }
        //Direction change timer resets to zero upon reaching user set variable. 
        if(moveCount == moveSwitch)
        {
            moveCount = 0;
        }
        //Walking sequence reset after 50 cycles
        if(walkCount == 50)
        {
            walkCount = 0;
        }
        //Step Counter reset to zero when reaching user set variable. 
        if(stepCounter == step)
        {
            stepCounter = 0;
        }
        walkCountChange++;
        walkCount++;
        moveCount++;
        stepCounter++;
        imageCount++;
        mcDistance = mcNear;
    }

    /**
     * Follow the main character closely. 
     */
    public void followMcClose()
    {
        mcXY();
        if(!mcFar())
        {
            if(getX() > mcX+40) //walking left
            { 
                if(imageCount == 1)
                {
                    setImage(filePath+"Left2.png");
                }
                if(imageCount == 11)
                {
                    setImage(filePath+"Left1.png");
                }
                if(stepCounter==1)//Slows movement when step counter is increased
                {
                    setLocation(getX()-1, getY());
                }
                stopped = 1;
            }
            else if(getX() < mcX-40) //walking right
            { 
                if(imageCount == 1)
                {
                    setImage(filePath+"Right2.png");
                }
                if(imageCount == 11)
                {
                    setImage(filePath+"Right1.png");
                }
                if(stepCounter==1)//Slows movement when step counter is increased
                {
                    setLocation(getX()+1, getY());
                }
                stopped = 2;
            }
            else if(getY() < mcY-40) //walking up
            { 
                if(imageCount == 1)
                {
                    setImage(filePath+"Down2.png");
                }
                if(imageCount == 11)
                {
                    setImage(filePath+"Down1.png");
                }
                if(stepCounter==1)//Slows movement when step counter is increased
                {
                    setLocation(getX(), getY()+1);
                }
                stopped = 3;
            }
            else if(getY() > mcY+40) //walking down
            { 
                if(imageCount == 1)
                {
                    setImage(filePath+"Up2.png");
                }
                if(imageCount == 11)
                {
                    setImage(filePath+"Up1.png");
                }
                if(stepCounter==1)//Slows movement when step counter is increased
                {
                    setLocation(getX(), getY()-1);
                }
                stopped = 4;
            }
            else
            {
                if(imageCount == 1)
                {
                    switch(stopped)
                    {
                        case 1:  setImage(filePath+"Left_Standing.png"); break;//left
                        case 2:  setImage(filePath+"Right_Standing.png"); break;//right
                        case 3:  setImage(filePath+"Front.png"); break;//down
                        case 4:  setImage(filePath+"Back.png"); break;//up
                    }
                }
            }
        }
        else
        {
            movement();
        }
    }

    /**
     * Follow the main character at an individual npc-set distance. 
     */
    public void followMcWithGap()
    {
        mcXY();
        if(!barrierFar())
        {
            barrier();
        }
        else if(!mcFar())
        {
            if(getX() > mcX+mcDistance/2) //walking left
            {
                if(imageCount == 1)
                {
                    setImage(filePath+"Left2.png");
                }
                if(imageCount == 11)
                {
                    setImage(filePath+"Left1.png");
                }
                if(stepCounter==1)//Slows movement when step counter is increased
                {
                    setLocation(getX()-1, getY());
                }
                stopped = 1;
            }
            else if(getX() < mcX-mcDistance/2) //walking right
            { 
                if(imageCount == 1)
                {
                    setImage(filePath+"Right2.png");
                }
                if(imageCount == 11)
                {
                    setImage(filePath+"Right1.png");
                }
                if(stepCounter==1)//Slows movement when step counter is increased
                {
                    setLocation(getX()+1, getY());
                }
                stopped = 2;
            }
            else if(getY() > mcY+mcDistance/2) //walking up
            { 
                if(imageCount == 1)
                {
                    setImage(filePath+"Up2.png");
                }
                if(imageCount == 11)
                {
                    setImage(filePath+"Up1.png");
                }
                if(stepCounter==1)//Slows movement when step counter is increased
                {
                    setLocation(getX(), getY()-1);
                }
                stopped = 3;
            }
            else if(getY() < mcY-mcDistance/2) //walking down
            { 
                if(imageCount == 1)
                {
                    setImage(filePath+"Down2.png");
                }
                if(imageCount == 11)
                {
                    setImage(filePath+"Down1.png");
                }
                if(stepCounter==1)//Slows movement when step counter is increased
                {
                    setLocation(getX(), getY()+1);
                }
                stopped = 4;
            }
            else
            {
                if(imageCount == 1)
                {
                    switch(stopped)
                    {
                        case 1:  setImage(filePath+"Left_Standing.png"); break;//left
                        case 2:  setImage(filePath+"Right_Standing.png"); break;//right
                        case 3:  setImage(filePath+"Back.png"); break;//up
                        case 4:  setImage(filePath+"Front.png"); break;//down
                    }
                }
            }
        }
        else
        {
            movement();
        }
    }

    /**
     * Move around normally. 
     */
    public void movement()
    {        
        walk = walkCount < 50;//Check if finished with walking sequence
        switch(moveWhich)
        {
            case 1: //walking left
            if(walk)
            {
                if(imageCount == 1)
                {
                    setImage(filePath+"Left2.png");
                }
                if(imageCount == 11)
                {
                    setImage(filePath+"Left1.png");
                }
                if(stepCounter==1)//Slows movement when step counter is increased
                {
                    setLocation(getX()-1, getY());
                }
                stopped = 1;
            }
            break;

            case 2: //walking right
            if(walk)
            {
                if(imageCount == 1)
                {
                    setImage(filePath+"Right2.png");
                }
                if(imageCount == 11)
                {
                    setImage(filePath+"Right1.png");
                }
                if(stepCounter==1)//Slows movement when step counter is increased
                {
                    setLocation(getX()+1, getY());
                }
                stopped = 2;
            }
            break;

            case 3: //walking up
            if(walk)
            {
                if(imageCount == 1)
                {
                    setImage(filePath+"Up2.png");
                }
                if(imageCount == 11)
                {
                    setImage(filePath+"Up1.png");
                }
                if(stepCounter==1)//Slows movement when step counter is increased
                {
                    setLocation(getX(), getY()-1);
                }
                stopped = 3;
            }
            break;

            case 4: //walking down
            if(walk)
            {
                if(imageCount == 1)
                {
                    setImage(filePath+"Down2.png");
                }
                if(imageCount == 11)
                {
                    setImage(filePath+"Down1.png");
                }
                if(stepCounter==1)//Slows movement when step counter is increased
                {
                    setLocation(getX(), getY()+1);
                }
                stopped = 4;
            }

            break;
            case 5: //standing still
            if(walk)
            {
                if(imageCount == 1)
                {
                    switch(stopped)
                    {
                        case 1:  setImage(filePath+"Left_Standing.png"); break;//left
                        case 2:  setImage(filePath+"Right_Standing.png"); break;//right
                        case 3:  setImage(filePath+"Back.png"); break;//up
                        case 4:  setImage(filePath+"Front.png"); break;//down
                    }
                }
            }
            break;
        }
    }
}    