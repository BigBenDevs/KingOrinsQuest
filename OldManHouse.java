import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * This world is one of many in this game.
 * 
 * @author (Ben Presley)
 * @version (5/8/2018)
 */
public class OldManHouse extends World
{
    private boolean angry;
    private int bX;
    private int bY;
    public static int archerCount = 0;
    public static int spearmanCount = 0;
    public static int blackKnightCount = 0;
    public static int fighterCount = 0;
    /**
     * Constructor for objects of class World22.
     * 
     */
    public OldManHouse()
    {    
        super(1080, 920, 1);
        prepare();
        setup();
        spawnPlayer();
        setPaintOrder(Icons.class, DialogParts.class, MusicButton.class, Treetop.class, Player.class, 
            JimboSubSystem.class, MattsSubSystem.class, Loot.class, Treebase.class, Shadow.class, BG.class, Barrier.class, ShopDoorExit.class);
    }
    
    /**
     * Controls the spawning position of player when transfering worlds.
     */
    public void spawnPlayer()
    {
        if (MainWorld.spawn == 30)
        {
            Player hawthorne = new Player();
            addObject(hawthorne, 455,700);
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
        blackKnightCount = getObjects(Archer.class).size();
        fighterCount = getObjects(Spearman.class).size();
    }
    
    /**
     * Setup handles enemy generation.
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
        OldManHouseBG oldmanhousebg = new OldManHouseBG();
        addObject(oldmanhousebg,533,492);
        oldmanhousebg.setLocation(540,460);
        OldManHouseExit oldmanhouseexit = new OldManHouseExit();
        addObject(oldmanhouseexit,455,752);
        Barrier barrier = new Barrier();
        addObject(barrier,344,753);
        barrier.setLocation(361,764);
        Barrier barrier2 = new Barrier();
        addObject(barrier2,281,763);
        barrier2.setLocation(286,764);
        Barrier barrier3 = new Barrier();
        addObject(barrier3,209,731);
        barrier3.setLocation(234,729);
        Barrier barrier4 = new Barrier();
        addObject(barrier4,242,649);
        barrier4.setLocation(237,653);
        barrier3.setLocation(237,730);
        barrier3.setLocation(237,727);
        Barrier barrier5 = new Barrier();
        addObject(barrier5,241,584);
        barrier5.setLocation(237,585);
        Barrier barrier6 = new Barrier();
        addObject(barrier6,253,502);
        barrier6.setLocation(239,509);
        barrier6.setLocation(237,511);
        Barrier barrier7 = new Barrier();
        addObject(barrier7,265,443);
        barrier7.setLocation(237,436);
        Barrier barrier8 = new Barrier();
        addObject(barrier8,252,371);
        barrier8.setLocation(237,360);
        Barrier barrier9 = new Barrier();
        addObject(barrier9,300,392);
        barrier9.setLocation(287,392);
        Barrier barrier10 = new Barrier();
        addObject(barrier10,365,395);
        barrier10.setLocation(362,392);
        Barrier barrier11 = new Barrier();
        addObject(barrier11,392,335);
        barrier11.setLocation(420,357);
        Barrier barrier12 = new Barrier();
        addObject(barrier12,483,366);
        barrier12.setLocation(483,357);
        Barrier barrier13 = new Barrier();
        addObject(barrier13,510,371);
        barrier13.setLocation(511,357);
        Barrier barrier14 = new Barrier();
        addObject(barrier14,516,317);
        barrier14.setLocation(513,310);
        Barrier barrier15 = new Barrier();
        addObject(barrier15,579,298);
        barrier15.setLocation(582,289);
        Barrier barrier16 = new Barrier();
        addObject(barrier16,647,303);
        barrier16.setLocation(655,292);
        Barrier barrier17 = new Barrier();
        addObject(barrier17,682,336);
        barrier17.setLocation(660,315);
        Barrier barrier18 = new Barrier();
        addObject(barrier18,735,336);
        barrier18.setLocation(726,327);
        Barrier barrier19 = new Barrier();
        addObject(barrier19,753,333);
        barrier19.setLocation(788,326);
        Barrier barrier20 = new Barrier();
        addObject(barrier20,856,372);
        barrier20.setLocation(852,373);
        Barrier barrier21 = new Barrier();
        addObject(barrier21,853,450);
        barrier21.setLocation(852,443);
        Barrier barrier22 = new Barrier();
        addObject(barrier22,867,539);
        barrier22.setLocation(852,518);
        Barrier barrier23 = new Barrier();
        addObject(barrier23,864,622);
        barrier23.setLocation(853,591);
        Barrier barrier24 = new Barrier();
        addObject(barrier24,855,670);
        barrier24.setLocation(852,665);
        Barrier barrier25 = new Barrier();
        addObject(barrier25,852,737);
        Barrier barrier26 = new Barrier();
        addObject(barrier26,750,772);
        barrier26.setLocation(782,763);
        Barrier barrier27 = new Barrier();
        addObject(barrier27,731,772);
        barrier27.setLocation(724,764);
        Barrier barrier28 = new Barrier();
        addObject(barrier28,645,763);
        barrier28.setLocation(650,763);
        Barrier barrier29 = new Barrier();
        addObject(barrier29,576,762);
        barrier29.setLocation(579,762);
        Barrier barrier30 = new Barrier();
        addObject(barrier30,542,768);
        barrier30.setLocation(542,761);
        Barrier barrier31 = new Barrier();
        addObject(barrier31,281,632);
        barrier31.setLocation(302,640);
        Barrier barrier32 = new Barrier();
        addObject(barrier32,672,626);
        barrier32.setLocation(679,609);
        Barrier barrier33 = new Barrier();
        addObject(barrier33,700,592);
        barrier33.setLocation(680,580);
        barrier32.setLocation(679,603);
        Barrier barrier34 = new Barrier();
        addObject(barrier34,714,599);
        barrier34.setLocation(714,603);
        Barrier barrier35 = new Barrier();
        addObject(barrier35,731,585);
        barrier35.setLocation(712,580);
        Barrier barrier36 = new Barrier();
        addObject(barrier36,790,415);
        barrier36.setLocation(788,393);
        Barrier barrier37 = new Barrier();
        addObject(barrier37,398,818);
        Barrier barrier38 = new Barrier();
        addObject(barrier38,482,827);
        barrier38.setLocation(472,820);
        Barrier barrier39 = new Barrier();
        addObject(barrier39,510,834);
        barrier39.setLocation(531,826);
        Walter walter = new Walter();
        addObject(walter,583,527);
        walter.setLocation(573,501);
        walter.setLocation(557,486);
    }
}