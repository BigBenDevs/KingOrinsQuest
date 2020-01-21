import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * This world is one of many in this game.
 * 
 * @author (Ben Presley), Anthony Neeser
 * @version (5/8/2018)
 */
public class World12 extends World
{
    private boolean angry;
    private int bX;
    private int bY;
    public static int archerCount = 0;
    public static int spearmanCount = 0;
    public static int blackKnightCount = 0;
    public static int fighterCount = 0;
    /**
     * Constructor for objects of class World12.
     * 
     */
    public World12()
    {    
        super(1080, 920, 1); 
        
        MainWorld.topWorldID = 7;
        MainWorld.leftWorldID = 11;
        MainWorld.rightWorldID = 13;
        MainWorld.bottomWorldID = 17;
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
        if (MainWorld.spawn == 12)
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
        World12BG world12bg = new World12BG();
        addObject(world12bg,478,468);
        world12bg.setLocation(540,460);
        Barrier barrier = new Barrier();
        addObject(barrier,853,831);
        barrier.setLocation(855,819);
        Barrier barrier2 = new Barrier();
        addObject(barrier2,786,823);
        barrier2.setLocation(784,819);
        Barrier barrier3 = new Barrier();
        addObject(barrier3,703,818);
        barrier3.setLocation(708,818);
        barrier3.setLocation(711,819);
        Barrier barrier4 = new Barrier();
        addObject(barrier4,656,826);
        barrier4.setLocation(640,820);
        Barrier barrier5 = new Barrier();
        addObject(barrier5,601,747);
        barrier5.setLocation(601,744);
        Barrier barrier6 = new Barrier();
        addObject(barrier6,591,677);
        barrier6.setLocation(586,673);
        Barrier barrier7 = new Barrier();
        addObject(barrier7,584,604);
        barrier7.setLocation(577,598);
        Barrier barrier8 = new Barrier();
        addObject(barrier8,576,552);
        barrier8.setLocation(576,554);
        Barrier barrier9 = new Barrier();
        addObject(barrier9,647,551);
        barrier9.setLocation(649,555);
        Barrier barrier10 = new Barrier();
        addObject(barrier10,720,548);
        barrier10.setLocation(723,555);
        Barrier barrier11 = new Barrier();
        addObject(barrier11,782,554);
        barrier11.setLocation(798,555);
        Barrier barrier12 = new Barrier();
        addObject(barrier12,845,559);
        barrier12.setLocation(856,556);
        Barrier barrier13 = new Barrier();
        addObject(barrier13,841,628);
        barrier13.setLocation(851,632);
        Barrier barrier14 = new Barrier();
        addObject(barrier14,841,699);
        barrier14.setLocation(847,708);
        Barrier barrier15 = new Barrier();
        addObject(barrier15,838,769);
        barrier15.setLocation(850,771);
        barrier14.setLocation(850,705);
        Barrier barrier16 = new Barrier();
        addObject(barrier16,262,771);
        barrier16.setLocation(265,776);
        Barrier barrier17 = new Barrier();
        addObject(barrier17,264,791);
        barrier17.setLocation(268,802);
        Barrier barrier18 = new Barrier();
        addObject(barrier18,222,476);
        barrier18.setLocation(233,447);
        Barrier barrier19 = new Barrier();
        addObject(barrier19,164,450);
        barrier19.setLocation(162,447);
        Barrier barrier20 = new Barrier();
        addObject(barrier20,141,447);
        barrier20.setLocation(140,447);
        Barrier barrier21 = new Barrier();
        addObject(barrier21,151,388);
        barrier21.setLocation(140,378);
        Barrier barrier22 = new Barrier();
        addObject(barrier22,132,319);
        barrier22.setLocation(140,327);
        Barrier barrier23 = new Barrier();
        addObject(barrier23,207,339);
        Barrier barrier24 = new Barrier();
        addObject(barrier24,243,389);
        Barrier barrier25 = new Barrier();
        addObject(barrier25,306,373);
        barrier25.setLocation(314,393);
        barrier25.setLocation(314,371);
        Barrier barrier26 = new Barrier();
        addObject(barrier26,378,367);
        barrier26.setLocation(366,366);
        Barrier barrier27 = new Barrier();
        addObject(barrier27,405,335);
        barrier27.setLocation(388,336);
        Barrier barrier28 = new Barrier();
        addObject(barrier28,403,271);
        barrier28.setLocation(399,263);
        Barrier barrier29 = new Barrier();
        addObject(barrier29,314,258);
        barrier29.setLocation(325,264);
        Barrier barrier30 = new Barrier();
        addObject(barrier30,306,267);
        barrier30.setLocation(306,265);
        Barrier barrier31 = new Barrier();
        addObject(barrier31,300,310);
        barrier31.setLocation(311,320);
        Barrier barrier32 = new Barrier();
        addObject(barrier32,303,230);
        barrier32.setLocation(306,245);
        Barrier barrier33 = new Barrier();
        addObject(barrier33,362,228);
        barrier33.setLocation(380,245);
        Barrier barrier34 = new Barrier();
        addObject(barrier34,402,242);
        barrier34.setLocation(399,248);
        Treebase treebase = new Treebase();
        addObject(treebase,108,216);
        treebase.setLocation(120,214);
        Treetop treetop = new Treetop();
        addObject(treetop,113,135);
        treetop.setLocation(117,126);
        Treetop treetop2 = new Treetop();
        addObject(treetop2,231,89);
        treetop2.setLocation(241,68);
        Treebase treebase2 = new Treebase();
        addObject(treebase2,255,144);
        treebase2.setLocation(244,156);
        Treebase treebase3 = new Treebase();
        addObject(treebase3,999,852);
        Treetop treetop3 = new Treetop();
        addObject(treetop3,1002,776);
        treetop3.setLocation(994,764);
        Treetop treetop4 = new Treetop();
        addObject(treetop4,1055,678);
        treetop4.setLocation(1060,685);
        Treebase treebase4 = new Treebase();
        addObject(treebase4,1070,791);
        treebase4.setLocation(1069,774);
        Barrier barrier35 = new Barrier();
        addObject(barrier35,999,822);
        barrier35.setLocation(1001,805);
        Barrier barrier36 = new Barrier();
        addObject(barrier36,1067,751);
        barrier36.setLocation(1067,751);
        barrier36.setLocation(1067,751);
        barrier36.setLocation(1067,751);
        barrier36.setLocation(1067,751);
        barrier36.setLocation(1067,751);
        barrier36.setLocation(1067,751);
        Barrier barrier37 = new Barrier();
        addObject(barrier37,127,172);
        barrier37.setLocation(120,176);
        Barrier barrier38 = new Barrier();
        addObject(barrier38,240,136);
        barrier38.setLocation(250,110);
        Villager12 villager12 = new Villager12();
        addObject(villager12,585,427);
        Villager6 villager6 = new Villager6();
        addObject(villager6,228,565);
        Villager7 villager7 = new Villager7();
        addObject(villager7,353,156);
        Villager9 villager9 = new Villager9();
        addObject(villager9,701,218);
        villager6.setLocation(139,533);
        villager12.setLocation(383,467);
        villager9.setLocation(959,560);
    }
}
