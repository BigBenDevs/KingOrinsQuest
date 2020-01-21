import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * This world is one of many in this game.
 * 
 * @author (Ben Presley)
 * @version (5/8/2018)
 */
public class Cave1 extends World
{
    private boolean angry;
    private int bX;
    private int bY;
    public static int archerCount = 0;
    public static int spearmanCount = 0;
    public static int blackKnightCount = 1;
    public static int fighterCount = 0;
    /**
     * Constructor for objects of class Cave1.
     * 
     */
    public Cave1()
    {    
        super(1080, 920, 1);
        prepare();
        setup();
        spawnPlayer();
        setPaintOrder(Icons.class, DialogParts.class, MusicButton.class, Treetop.class, Player.class, 
            JimboSubSystem.class, MattsSubSystem.class, Loot.class, Treebase.class, Shadow.class, BG.class, Barrier.class, ShopDoorExit.class, InstructionParts.class);
    }
    
    /**
     * Controls the spawning position of player when transfering worlds.
     */
    public void spawnPlayer()
    {
        if (MainWorld.spawn == 28)
        {
            Player hawthorne = new Player();
            addObject(hawthorne, 508,670);
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
        Cave1BG cave1bg = new Cave1BG();
        addObject(cave1bg,528,487);
        cave1bg.setLocation(541,460);
        Cave1Exit cave1exit2 = new Cave1Exit();
        addObject(cave1exit2,508,729);
        Barrier barrier = new Barrier();
        addObject(barrier,605,737);
        barrier.setLocation(604,756);
        Barrier barrier2 = new Barrier();
        addObject(barrier2,682,758);
        barrier2.setLocation(680,757);
        Barrier barrier3 = new Barrier();
        addObject(barrier3,651,688);
        barrier3.setLocation(657,682);
        Barrier barrier4 = new Barrier();
        addObject(barrier4,659,616);
        barrier4.setLocation(657,609);
        Barrier barrier5 = new Barrier();
        addObject(barrier5,668,530);
        barrier5.setLocation(658,534);
        Barrier barrier6 = new Barrier();
        addObject(barrier6,659,460);
        barrier6.setLocation(659,460);
        Barrier barrier7 = new Barrier();
        addObject(barrier7,668,405);
        barrier7.setLocation(661,390);
        Barrier barrier8 = new Barrier();
        addObject(barrier8,721,376);
        barrier8.setLocation(737,390);
        barrier7.setLocation(661,384);
        barrier8.setLocation(735,384);
        Barrier barrier9 = new Barrier();
        addObject(barrier9,807,384);
        barrier9.setLocation(811,385);
        barrier9.setLocation(811,384);
        Barrier barrier10 = new Barrier();
        addObject(barrier10,897,392);
        barrier10.setLocation(886,384);
        Barrier barrier11 = new Barrier();
        addObject(barrier11,908,335);
        barrier11.setLocation(913,326);
        Barrier barrier12 = new Barrier();
        addObject(barrier12,911,250);
        barrier12.setLocation(912,253);
        Barrier barrier13 = new Barrier();
        addObject(barrier13,920,174);
        barrier13.setLocation(913,183);
        Barrier barrier14 = new Barrier();
        addObject(barrier14,908,99);
        barrier14.setLocation(912,115);
        Barrier barrier15 = new Barrier();
        addObject(barrier15,904,61);
        barrier15.setLocation(870,67);
        Barrier barrier16 = new Barrier();
        addObject(barrier16,800,79);
        barrier16.setLocation(798,66);
        Barrier barrier17 = new Barrier();
        addObject(barrier17,710,67);
        barrier17.setLocation(723,67);
        Barrier barrier18 = new Barrier();
        addObject(barrier18,652,79);
        barrier18.setLocation(648,66);
        Barrier barrier19 = new Barrier();
        addObject(barrier19,564,80);
        barrier19.setLocation(574,68);
        Barrier barrier20 = new Barrier();
        addObject(barrier20,507,79);
        barrier20.setLocation(501,68);
        Barrier barrier21 = new Barrier();
        addObject(barrier21,429,77);
        barrier21.setLocation(425,67);
        Barrier barrier22 = new Barrier();
        addObject(barrier22,336,69);
        barrier22.setLocation(353,68);
        Barrier barrier23 = new Barrier();
        addObject(barrier23,346,137);
        barrier23.setLocation(351,136);
        Barrier barrier24 = new Barrier();
        addObject(barrier24,359,246);
        barrier24.setLocation(351,209);
        Barrier barrier25 = new Barrier();
        addObject(barrier25,349,314);
        barrier25.setLocation(351,281);
        Barrier barrier26 = new Barrier();
        addObject(barrier26,370,378);
        barrier26.setLocation(351,354);
        Barrier barrier27 = new Barrier();
        addObject(barrier27,362,459);
        barrier27.setLocation(351,424);
        Barrier barrier28 = new Barrier();
        addObject(barrier28,357,510);
        barrier28.setLocation(352,499);
        Barrier barrier29 = new Barrier();
        addObject(barrier29,364,581);
        barrier29.setLocation(351,571);
        Barrier barrier30 = new Barrier();
        addObject(barrier30,353,660);
        barrier30.setLocation(351,644);
        Barrier barrier31 = new Barrier();
        addObject(barrier31,369,730);
        barrier31.setLocation(348,717);
        barrier31.setLocation(351,713);
        Barrier barrier32 = new Barrier();
        addObject(barrier32,410,759);
        barrier32.setLocation(407,756);
        Barrier barrier33 = new Barrier();
        addObject(barrier33,470,813);
        Barrier barrier34 = new Barrier();
        addObject(barrier34,536,805);
        barrier34.setLocation(545,813);
        Fighter fighter = new Fighter(true);
        addObject(fighter,478,210);
        Fighter fighter2 = new Fighter(true);
        addObject(fighter2,693,277);
        GoldChest goldchest = new GoldChest(64, 64);
        addObject(goldchest,787,227);
    }
}