import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * This world is one of many in this game.
 * 
 * @author (Ben Presley), Anthony Neeser
 * @version (5/8/2018)
 */
public class World11 extends World
{
    private boolean angry;
    private int bX;
    private int bY;
    public static int archerCount = 0;
    public static int spearmanCount = 0;
    public static int blackKnightCount = 0;
    public static int fighterCount = 0;
    /**
     * Constructor for objects of class World11.
     * 
     */
    public World11()
    {    
        super(1080, 920, 1); 
        
        MainWorld.topWorldID = 6;
        MainWorld.leftWorldID = 99;
        MainWorld.rightWorldID = 12;
        MainWorld.bottomWorldID = 16;
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
        if (MainWorld.spawn == 11)
        {
            Player hawthorne = new Player();
            addObject(hawthorne, MainWorld.playerX,MainWorld.playerY);
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
        World11BG world11bg = new World11BG();
        addObject(world11bg,492,461);
        world11bg.setLocation(540,461);
        Barrier barrier = new Barrier();
        addObject(barrier,823,457);
        barrier.setLocation(822,412);
        Barrier barrier2 = new Barrier();
        addObject(barrier2,827,346);
        barrier2.setLocation(822,336);
        Barrier barrier3 = new Barrier();
        addObject(barrier3,813,288);
        barrier3.setLocation(827,282);
        barrier2.setLocation(827,338);
        barrier.setLocation(828,412);
        Barrier barrier4 = new Barrier();
        addObject(barrier4,856,322);
        barrier4.setLocation(838,317);
        Barrier barrier5 = new Barrier();
        addObject(barrier5,601,445);
        barrier5.setLocation(599,433);
        Barrier barrier6 = new Barrier();
        addObject(barrier6,390,441);
        barrier6.setLocation(397,416);
        Barrier barrier7 = new Barrier();
        addObject(barrier7,338,420);
        barrier7.setLocation(322,417);
        Barrier barrier8 = new Barrier();
        addObject(barrier8,256,420);
        barrier8.setLocation(253,416);
        Barrier barrier9 = new Barrier();
        addObject(barrier9,216,421);
        barrier9.setLocation(193,416);
        Barrier barrier10 = new Barrier();
        addObject(barrier10,187,352);
        barrier10.setLocation(185,344);
        Barrier barrier11 = new Barrier();
        addObject(barrier11,171,283);
        barrier11.setLocation(175,272);
        Barrier barrier12 = new Barrier();
        addObject(barrier12,164,201);
        barrier12.setLocation(172,197);
        Barrier barrier13 = new Barrier();
        addObject(barrier13,177,139);
        barrier13.setLocation(173,121);
        Barrier barrier14 = new Barrier();
        addObject(barrier14,221,77);
        barrier14.setLocation(214,81);
        Barrier barrier15 = new Barrier();
        addObject(barrier15,248,42);
        barrier15.setLocation(258,55);
        Barrier barrier16 = new Barrier();
        addObject(barrier16,302,39);
        Barrier barrier17 = new Barrier();
        addObject(barrier17,343,62);
        barrier17.setLocation(343,55);
        Barrier barrier18 = new Barrier();
        addObject(barrier18,393,94);
        barrier18.setLocation(378,103);
        Barrier barrier19 = new Barrier();
        addObject(barrier19,435,143);
        barrier19.setLocation(422,151);
        Barrier barrier20 = new Barrier();
        addObject(barrier20,424,210);
        barrier20.setLocation(421,218);
        Barrier barrier21 = new Barrier();
        addObject(barrier21,430,288);
        barrier21.setLocation(421,290);
        Barrier barrier22 = new Barrier();
        addObject(barrier22,418,348);
        barrier22.setLocation(421,349);
        Barrier barrier23 = new Barrier();
        addObject(barrier23,447,399);
        barrier23.setLocation(443,399);
        barrier5.setLocation(602,416);
        Treetop treetop5 = new Treetop();
        addObject(treetop5,299,736);
        treetop5.setLocation(250,722);
        Treetop treetop6 = new Treetop();
        addObject(treetop6,551,750);
        treetop6.setLocation(539,719);
        Treetop treetop7 = new Treetop();
        addObject(treetop7,778,736);
        treetop7.setLocation(790,720);
        Treetop treetop8 = new Treetop();
        addObject(treetop8,1011,726);
        treetop8.setLocation(1012,722);
        Treebase treebase9 = new Treebase();
        addObject(treebase9,1026,820);
        treebase9.setLocation(1016,811);
        Treebase treebase10 = new Treebase();
        addObject(treebase10,801,803);
        treebase10.setLocation(796,808);
        Treebase treebase11 = new Treebase();
        addObject(treebase11,551,812);
        treebase11.setLocation(542,807);
        Treebase treebase12 = new Treebase();
        addObject(treebase12,257,808);
        treebase12.setLocation(255,810);
        Barrier barrier73 = new Barrier();
        addObject(barrier73,1020,764);
        Barrier barrier74 = new Barrier();
        addObject(barrier74,800,754);
        Barrier barrier75 = new Barrier();
        addObject(barrier75,543,751);
        Barrier barrier76 = new Barrier();
        addObject(barrier76,255,751);
        Villager11 villager11 = new Villager11();
        addObject(villager11,713,358);
        Villager10 villager10 = new Villager10();
        addObject(villager10,277,583);
    }
}
