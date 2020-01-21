import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * This world is one of many in this game.
 * 
 * @author (Ben Presley), Anthony Neeser
 * @version (5/8/2018)
 */
public class World1 extends World
{
    private boolean angry;
    private int bX;
    private int bY;
    public static int archerCount = 0;
    public static int spearmanCount = 0;
    public static int blackKnightCount = 0;
    public static int fighterCount = 0;
    /**
     * Constructor for objects of class World1.
     * 
     */
    public World1()
    {    
        super(1080, 920, 1); 

        MainWorld.topWorldID = 99;
        MainWorld.leftWorldID = 99;
        MainWorld.rightWorldID = 2;
        MainWorld.bottomWorldID = 6;
        prepare();
        setup();
        spawnPlayer();
        setPaintOrder(InstructionParts.class, Icons.class, DialogParts.class, MusicButton.class, Treetop.class, Player.class, 
            JimboSubSystem.class, MattsSubSystem.class, Loot.class, Treebase.class, Shadow.class, BG.class, Barrier.class, ShopDoorExit.class); 
    }

    /**
     * Controls the spawning position of player when transfering worlds.
     */
    public void spawnPlayer()
    {
        if (MainWorld.spawn == 1)
        {
            Player hawthorne = new Player();
            addObject(hawthorne, MainWorld.playerX,MainWorld.playerY);
        }
        //Returning from Castle
        if (MainWorld.spawn == 32)
        {
            Player hawthorne = new Player();
            addObject(hawthorne, 483,170);
        }
        MainWorld.state = 1;
    }
    
    /**
     * Upon starting the game, or if Player dies, this handles resetting the world to the starting zone. States are also set to initial values.
     */
    public void reset()
    {
        if(MainWorld.start == 0)
        {
            Greenfoot.setWorld(new World6());
        }
    }

    /**
     * Monitor world state.
     */
    public void act()
    {
        reset();
        archerCount = getObjects(Archer.class).size();
        spearmanCount = getObjects(Spearman.class).size();
        blackKnightCount = getObjects(BlackKnight.class).size();
        fighterCount = getObjects(Fighter.class).size();
    }
    
    /**
     * Setup handles enemy generation away from barriers.
     * @author Anthony Neeser
     */
    private void setup()
    {
        List<Barrier> barriers = getObjects(Barrier.class);
        for(Barrier boundary : barriers)
        {
            bX = boundary.getX();
            bY = boundary.getY();
        }
        int a = 0;
        while(a < archerCount)
        {
            if(getObjectsAt(bX, bY, Barrier.class) != null)
            {
                if(Greenfoot.getRandomNumber(6) <= 2)
                {
                    angry = true;
                }
                int x = Greenfoot.getRandomNumber(450);
                int y = Greenfoot.getRandomNumber(450);
                addObject(new Archer(angry), x, y);
                a++;
            }
        }
        int b = 0;
        while(b < spearmanCount)
        {
            if(getObjectsAt(bX, bY, Barrier.class) != null)
            {
                if(Greenfoot.getRandomNumber(6) <= 2)
                {
                    angry = true;
                }
                int x = Greenfoot.getRandomNumber(450);
                int y = Greenfoot.getRandomNumber(450);
                addObject(new Spearman(angry), x, y);
                b++;
            }
        }
        int c = 0;
        while(c < blackKnightCount)
        {
            if(getObjectsAt(bX, bY, Barrier.class) != null)
            {
                if(Greenfoot.getRandomNumber(6) <= 2)
                {
                    angry = true;
                }
                int x = Greenfoot.getRandomNumber(450);
                int y = Greenfoot.getRandomNumber(450);
                addObject(new BlackKnight(angry), x, y);
                c++;
            }
        }
        int d = 0;
        while(d < fighterCount)
        {
            if(getObjectsAt(bX, bY, Barrier.class) != null)
            {
                if(Greenfoot.getRandomNumber(6) <= 2)
                {
                    angry = true;
                }
                int x = Greenfoot.getRandomNumber(450);
                int y = Greenfoot.getRandomNumber(450);
                addObject(new Fighter(angry), x, y);
                d++;
            }
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        World1BG world1bg = new World1BG();
        addObject(world1bg,521,527);
        world1bg.setLocation(540,460);
        Knight knight = new Knight();
        addObject(knight,377,179);
        knight.setLocation(390,153);
        Knight knight2 = new Knight();
        addObject(knight2,547,159);
        knight2.setLocation(541,152);
        CastleEntrance castleentrance = new CastleEntrance();
        addObject(castleentrance,483,111);
        Barrier barrier = new Barrier();
        addObject(barrier,838,501);
        barrier.setLocation(829,472);
        Barrier barrier2 = new Barrier();
        addObject(barrier2,916,480);
        barrier2.setLocation(905,472);
        Barrier barrier3 = new Barrier();
        addObject(barrier3,973,471);
        barrier3.setLocation(971,473);
        Barrier barrier4 = new Barrier();
        addObject(barrier4,987,418);
        barrier4.setLocation(981,407);
        Barrier barrier5 = new Barrier();
        addObject(barrier5,982,326);
        barrier5.setLocation(982,333);
        Barrier barrier6 = new Barrier();
        addObject(barrier6,1035,482);
        barrier6.setLocation(982,258);
        Barrier barrier7 = new Barrier();
        addObject(barrier7,977,191);
        barrier7.setLocation(982,186);
        Barrier barrier8 = new Barrier();
        addObject(barrier8,981,106);
        barrier8.setLocation(982,111);
        Barrier barrier9 = new Barrier();
        addObject(barrier9,989,31);
        barrier9.setLocation(982,36);
        Barrier barrier10 = new Barrier();
        addObject(barrier10,928,66);
        barrier10.setLocation(925,67);
        Barrier barrier11 = new Barrier();
        addObject(barrier11,865,60);
        barrier11.setLocation(859,67);
        Barrier barrier12 = new Barrier();
        addObject(barrier12,796,71);
        barrier12.setLocation(794,66);
        Barrier barrier13 = new Barrier();
        addObject(barrier13,721,68);
        barrier13.setLocation(721,65);
        Barrier barrier14 = new Barrier();
        addObject(barrier14,660,73);
        barrier14.setLocation(646,67);
        Barrier barrier15 = new Barrier();
        addObject(barrier15,575,65);
        barrier15.setLocation(575,67);
        Barrier barrier16 = new Barrier();
        addObject(barrier16,386,66);
        barrier16.setLocation(384,63);
        Barrier barrier17 = new Barrier();
        addObject(barrier17,440,24);
        barrier17.setLocation(440,19);
        Barrier barrier18 = new Barrier();
        addObject(barrier18,495,16);
        barrier18.setLocation(510,20);
        Barrier barrier19 = new Barrier();
        addObject(barrier19,297,59);
        barrier19.setLocation(309,64);
        Barrier barrier20 = new Barrier();
        addObject(barrier20,232,73);
        barrier20.setLocation(238,65);
        Barrier barrier21 = new Barrier();
        addObject(barrier21,147,61);
        barrier21.setLocation(168,64);
        Barrier barrier22 = new Barrier();
        addObject(barrier22,84,65);
        barrier22.setLocation(98,65);
        Barrier barrier23 = new Barrier();
        addObject(barrier23,29,69);
        barrier23.setLocation(29,65);
        Barrier barrier24 = new Barrier();
        addObject(barrier24,17,125);
        barrier24.setLocation(17,125);
        barrier24.setLocation(17,125);
        barrier24.setLocation(17,125);
        barrier24.setLocation(17,125);
        barrier24.setLocation(17,125);
        barrier24.setLocation(17,125);
        barrier24.setLocation(6,124);
        Barrier barrier25 = new Barrier();
        addObject(barrier25,21,205);
        barrier25.setLocation(6,200);
        Barrier barrier26 = new Barrier();
        addObject(barrier26,1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1065,11);
        barrier26.setLocation(1050,10);
        Barrier barrier27 = new Barrier();
        addObject(barrier27,14,279);
        barrier27.setLocation(14,279);
        barrier27.setLocation(14,279);
        barrier27.setLocation(14,279);
        barrier27.setLocation(14,279);
        barrier27.setLocation(14,279);
        barrier27.setLocation(14,279);
        barrier27.setLocation(14,279);
        barrier27.setLocation(14,279);
        barrier27.setLocation(14,279);
        barrier27.setLocation(14,279);
        barrier27.setLocation(14,279);
        barrier27.setLocation(14,279);
        barrier27.setLocation(5,276);
        Barrier barrier28 = new Barrier();
        addObject(barrier28,16,354);
        barrier28.setLocation(16,354);
        barrier28.setLocation(16,354);
        barrier28.setLocation(16,354);
        barrier28.setLocation(4,350);
        Barrier barrier29 = new Barrier();
        addObject(barrier29,23,422);
        barrier29.setLocation(3,424);
        Barrier barrier30 = new Barrier();
        addObject(barrier30,27,503);
        barrier30.setLocation(27,503);
        barrier30.setLocation(27,503);
        barrier30.setLocation(27,503);
        barrier30.setLocation(27,503);
        barrier30.setLocation(27,503);
        barrier30.setLocation(27,503);
        barrier30.setLocation(27,503);
        barrier30.setLocation(27,503);
        barrier30.setLocation(27,503);
        barrier30.setLocation(27,503);
        barrier30.setLocation(27,503);
        barrier30.setLocation(27,503);
        barrier30.setLocation(27,503);
        barrier30.setLocation(27,503);
        barrier30.setLocation(27,503);
        barrier30.setLocation(27,503);
        barrier30.setLocation(27,503);
        barrier30.setLocation(27,503);
        barrier30.setLocation(27,503);
        barrier30.setLocation(27,503);
        barrier30.setLocation(27,503);
        barrier30.setLocation(27,503);
        barrier30.setLocation(27,503);
        barrier30.setLocation(27,503);
        barrier30.setLocation(27,503);
        barrier30.setLocation(27,503);
        barrier30.setLocation(27,503);
        barrier30.setLocation(27,503);
        barrier30.setLocation(27,503);
        barrier30.setLocation(27,503);
        barrier30.setLocation(27,503);
        barrier30.setLocation(27,503);
        barrier30.setLocation(27,503);
        barrier30.setLocation(27,503);
        barrier30.setLocation(27,503);
        barrier30.setLocation(27,503);
        barrier30.setLocation(27,503);
        barrier30.setLocation(27,503);
        barrier30.setLocation(27,503);
        barrier30.setLocation(27,503);
        barrier30.setLocation(2,488);
        Barrier barrier31 = new Barrier();
        addObject(barrier31,53,488);
        Barrier barrier32 = new Barrier();
        addObject(barrier32,122,490);
        barrier32.setLocation(122,488);
        Barrier barrier33 = new Barrier();
        addObject(barrier33,186,491);
        barrier33.setLocation(197,488);
        Barrier barrier34 = new Barrier();
        addObject(barrier34,275,497);
        barrier34.setLocation(272,488);
        Barrier barrier35 = new Barrier();
        addObject(barrier35,352,499);
        barrier35.setLocation(347,488);
        Barrier barrier36 = new Barrier();
        addObject(barrier36,414,486);
        barrier36.setLocation(422,488);
        Barrier barrier37 = new Barrier();
        addObject(barrier37,502,484);
        barrier37.setLocation(498,488);
        Barrier barrier38 = new Barrier();
        addObject(barrier38,569,491);
        barrier38.setLocation(574,487);
        Barrier barrier39 = new Barrier();
        addObject(barrier39,603,492);
        barrier39.setLocation(593,486);
    }
}
