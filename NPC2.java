import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Superclass of NPCs. Handles variables passed from unique subclasses HelpfulNPCs to set images, 
 * animation speed, walk speed, when to change walking directions, saves last known walking 
 * direction to display a corresponding image during resting periods, works to move an NPC when they encounter 
 * a barrier, changes NPC directions when they bump into each other, stops movement when certain dialog boxes are open,
 * and handles what happens when friendly npcs become angry, .  
 * 
 * 
 * @author Anthony Neeser
 * @version 5/5/18
 */
public class NPC2 extends MattsSubSystem
{
    private int moveCount, walkCount, imageCount, moveWhich, stepCounter, walkCountChange, actorImageCount, mcX, mcY, mcDistance, stopped, direction, shootCounter;
    private boolean walk;
    private boolean dialogStopMovement;
    public GreenfootImage left1, left2, right1, right2, up1, up2, down1, down2, standingFront, standingBack, standingRight, standingLeft;

    /**
     * Variable pass parses variables passed from helpful npcs to NPC2. Sends variables to appropriate methods. 
     */
    public void variablePass(int sizeMultiplier, GreenfootImage left1, GreenfootImage left2, GreenfootImage right1, GreenfootImage right2, GreenfootImage up1, 
    GreenfootImage up2, GreenfootImage down1, GreenfootImage down2, GreenfootImage front, GreenfootImage back, GreenfootImage left, GreenfootImage right, 
    int imgChangeDelay, int width, int height, int shadowImageWidth, int shadowImageHeight, int shadowX, int shadowY, int shadowWidth, int shadowHeight, 
    int stepDelay, int dirSwitch, int mcRange, boolean angry, String classType, String projectile, int projectileWidth, int projectileHeight, int shotSpeed, 
    int removalCount, int reloadDelay)
    {
        imageChange(left1, left2, right1, right2, up1, up2, down1, down2, front, back, left, right, imgChangeDelay);
        getWorld().addObject(new Shadow(shadowImageWidth, shadowImageHeight, shadowX, shadowY, shadowWidth, shadowHeight), getX(), getY());
        varCycle(stepDelay, dirSwitch, imgChangeDelay, mcRange);

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
            case "archer": 
            shoot(projectile, projectileWidth, projectileHeight, shotSpeed, reloadDelay, removalCount);
            followMcWithGap();
            break;

            case "spearman": 
            shoot(projectile, projectileWidth, projectileHeight, shotSpeed, reloadDelay, removalCount);
            break;

            case "melee": followMcClose(); 
            break;
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
                    case "fireball": getWorld().addObject(new Fireball(speed, (int)rotation, ammoWidth, ammoHeight, countdown), getX(), getY()); break;
                    case "iceball": getWorld().addObject(new Iceball(speed, (int)rotation, ammoWidth, ammoHeight, countdown), getX(), getY()); break;
                    case "arrow": getWorld().addObject(new Arrow(speed, (int)rotation, ammoWidth, ammoHeight, countdown), getX(), getY()); break;
                    case "spear": getWorld().addObject(new Spear(speed, (int)rotation, ammoWidth, ammoHeight, countdown), getX(), getY()); break;
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
     * Sets and scales each image, and sets image change delay. All values passed from subclasses. 
     * @param l1        First walking left image.
     * @param l2        Second walking left image.
     * @param r1        First walking right image.
     * @param r2        Second walking right image.
     * @param u1        First walking up image.
     * @param u2        Second walking up image.
     * @param d1        First NPC walking down image.
     * @param d2        Second NPC walking down image.
     * @param front     NPC facing front image.
     * @param back      NPC facing away image.
     * @param imgCount  Set image delay during animation.
     * @param width     Width of image.
     * @param height    Height of image.
     */
    public void imageChange(GreenfootImage l1, GreenfootImage l2, GreenfootImage r1, GreenfootImage r2, GreenfootImage u1, 
    GreenfootImage u2, GreenfootImage d1, GreenfootImage d2, GreenfootImage front, GreenfootImage back, GreenfootImage standLeft, 
    GreenfootImage standRight, int imgCount)
    {
        //Set pictures
        left1 = l1;
        left2 = l2;
        right1 = r1;
        right2 = r2;
        up1 = u1;
        up2 = u2;
        down1 = d1;
        down2 = d2;
        standingFront = front; 
        standingBack = back;
        standingLeft = standLeft;
        standingRight = standRight;

        actorImageCount = imgCount;
    }

    /**
     * Handles cycling of variables so that they keep counting as necessary.
     */
    public void varCycle(int step, int moveSwitch, int imgChange, int mcNear)
    {
        /*
         * When moveCount = 1, sets new walking direction for NPC. 
         * Includes:
         * - Up
         * - Down
         * - Left
         * - Right
         * - Standing still
         */
        if(moveCount == 1)
        {
            moveWhich = Greenfoot.getRandomNumber(5)+1;
        }

        //Image change timer resets to zero when reaching user set variable. 
        if(imageCount == actorImageCount)
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
     * Movement via Superclass
     * 
     * @param step Amount of act cycles between each step forward.
     * @param moveSwitch The amount of time to wait before switching directions. 
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
                    if(getImage() == left1)
                    {
                        setImage(left2);
                    }
                    else
                    {
                        setImage(left1);
                    }
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
                    if(getImage() == right1)
                    {
                        setImage(right2);
                    }
                    else
                    {
                        setImage(right1);
                    }
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
                    if(getImage() == up1)
                    {
                        setImage(up2);
                    }
                    else
                    {
                        setImage(up1);
                    }
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
                    if(getImage() == down1)
                    {
                        setImage(down2);
                    }
                    else
                    {
                        setImage(down1);
                    }
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
                        case 1:  setImage(standingLeft); break;//left
                        case 2:  setImage(standingRight); break;//right
                        case 3:  setImage(standingBack); break;//up
                        case 4:  setImage(standingFront); break;//down
                    }
                }
            }
            break;
        }
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
                    stopped = 1;
                }
            }
            else if(getX() < mcX-40) //walking right
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
                    stopped = 2;
                }
            }
            else if(getY() > mcY+40) //walking up
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
            else if(getY() < mcY-40) //walking down
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
                    stopped = 4;
                }
            }
            else
            {
                if(imageCount == 1)
                {
                    switch(stopped)
                    {
                        case 1:  setImage(standingLeft); break;//left
                        case 2:  setImage(standingRight); break;//right
                        case 3:  setImage(standingBack); break;//up
                        case 4:  setImage(standingFront); break;//down
                    }
                }
            }
        }
    }

    /**
     * Follow the main character at a user-set distance. 
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
                    stopped = 1;
                }
            }
            else if(getX() < mcX-mcDistance/2) //walking right
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
                    stopped = 2;
                }
            }
            else if(getY() > mcY+mcDistance/2) //walking up
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
            else if(getY() < mcY-mcDistance/2) //walking down
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
                    stopped = 4;
                }
            }
            else
            {
                if(imageCount == 1)
                {
                    switch(stopped)
                    {
                        case 1:  setImage(standingLeft); break;//left
                        case 2:  setImage(standingRight); break;//right
                        case 3:  setImage(standingBack); break;//up
                        case 4:  setImage(standingFront); break;//down
                    }
                }
            }
        }
        else
        {
            movement();
        }
    }

    public void act()
    {
        mcXY();
    }
}    