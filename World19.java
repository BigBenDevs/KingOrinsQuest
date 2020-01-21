import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * This world is one of many in this game.
 * 
 * @author (Ben Presley), Anthony Neeser
 * @version (5/8/2018)
 */
public class World19 extends World
{
    private boolean angry;
    private int bX;
    private int bY;
    public static int archerCount = 1;
    public static int spearmanCount = 4;
    public static int blackKnightCount = 0;
    public static int fighterCount = 0;
    /**
     * Constructor for objects of class World19.
     * 
     */
    public World19()
    {    
        super(1080, 920, 1); 
        
        MainWorld.topWorldID = 14;
        MainWorld.leftWorldID = 18;
        MainWorld.rightWorldID = 20;
        MainWorld.bottomWorldID = 24;
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
        if (MainWorld.spawn == 19)
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
        World19BG world19bg = new World19BG();
        addObject(world19bg,461,498);
        world19bg.setLocation(540,461);
        Barrier barrier = new Barrier();
        addObject(barrier,440,727);
        barrier.setLocation(420,725);
        Barrier barrier2 = new Barrier();
        addObject(barrier2,460,723);
        barrier2.setLocation(453,725);
        Barrier barrier3 = new Barrier();
        addObject(barrier3,823,50);
        barrier3.setLocation(840,34);
        Barrier barrier4 = new Barrier();
        addObject(barrier4,839,109);
        Barrier barrier5 = new Barrier();
        addObject(barrier5,835,176);
        barrier5.setLocation(840,184);
        barrier5.setLocation(839,185);
        Barrier barrier6 = new Barrier();
        addObject(barrier6,858,233);
        barrier6.setLocation(839,239);
        Barrier barrier7 = new Barrier();
        addObject(barrier7,925,249);
        barrier7.setLocation(915,240);
        Barrier barrier8 = new Barrier();
        addObject(barrier8,978,238);
        barrier8.setLocation(990,240);
        Barrier barrier9 = new Barrier();
        addObject(barrier9,1058,242);
        barrier9.setLocation(1062,240);
        Barrier barrier10 = new Barrier();
        addObject(barrier10,927,49);
        barrier10.setLocation(934,36);
        Barrier barrier11 = new Barrier();
        addObject(barrier11,933,108);
        barrier11.setLocation(936,127);
        barrier10.setLocation(934,37);
        barrier11.setLocation(934,72);
        Barrier barrier12 = new Barrier();
        addObject(barrier12,995,128);
        barrier12.setLocation(971,141);
        Barrier barrier13 = new Barrier();
        addObject(barrier13,1032,136);
        barrier13.setLocation(1046,141);
        Barrier barrier14 = new Barrier();
        addObject(barrier14,331,42);
        barrier14.setLocation(326,33);
        Barrier barrier15 = new Barrier();
        addObject(barrier15,278,88);
        barrier15.setLocation(304,62);
        Barrier barrier16 = new Barrier();
        addObject(barrier16,253,102);
        barrier16.setLocation(260,79);
        Barrier barrier17 = new Barrier();
        addObject(barrier17,260,138);
        barrier17.setLocation(265,137);
        Barrier barrier18 = new Barrier();
        addObject(barrier18,253,200);
        barrier18.setLocation(265,213);
        Barrier barrier19 = new Barrier();
        addObject(barrier19,270,287);
        barrier19.setLocation(264,287);
        Barrier barrier20 = new Barrier();
        addObject(barrier20,260,364);
        barrier20.setLocation(264,360);
        Barrier barrier21 = new Barrier();
        addObject(barrier21,189,370);
        barrier21.setLocation(189,361);
        Barrier barrier22 = new Barrier();
        addObject(barrier22,114,367);
        barrier22.setLocation(116,361);
        Barrier barrier23 = new Barrier();
        addObject(barrier23,45,361);
        barrier23.setLocation(47,361);
        Barrier barrier24 = new Barrier();
        addObject(barrier24,27,371);
        barrier24.setLocation(26,361);
        Barrier barrier25 = new Barrier();
        addObject(barrier25,26,221);
        barrier25.setLocation(22,208);
        Barrier barrier26 = new Barrier();
        addObject(barrier26,95,220);
        barrier26.setLocation(94,208);
        Barrier barrier27 = new Barrier();
        addObject(barrier27,163,215);
        barrier27.setLocation(170,208);
        Barrier barrier28 = new Barrier();
        addObject(barrier28,177,173);
        barrier28.setLocation(173,187);
        Barrier barrier29 = new Barrier();
        addObject(barrier29,187,137);
        barrier29.setLocation(193,137);
        Treetop treetop = new Treetop();
        addObject(treetop,154,638);
        Treebase treebase = new Treebase();
        addObject(treebase,184,736);
        treebase.setLocation(155,726);
        Treetop treetop2 = new Treetop();
        addObject(treetop2,292,847);
        treetop2.setLocation(285,810);
        Treebase treebase2 = new Treebase();
        addObject(treebase2,283,898);
        treebase2.setLocation(286,899);
        Treetop treetop3 = new Treetop();
        addObject(treetop3,635,683);
        treetop3.setLocation(607,636);
        Treebase treebase3 = new Treebase();
        addObject(treebase3,605,731);
        treebase3.setLocation(608,725);
        Treetop treetop4 = new Treetop();
        addObject(treetop4,326,571);
        treetop4.setLocation(327,554);
        Treebase treebase4 = new Treebase();
        addObject(treebase4,340,641);
        treebase4.setLocation(330,643);
        Treetop treetop5 = new Treetop();
        addObject(treetop5,897,761);
        Treebase treebase5 = new Treebase();
        addObject(treebase5,895,859);
        treebase5.setLocation(899,849);
        Barrier barrier30 = new Barrier();
        addObject(barrier30,900,815);
        barrier30.setLocation(900,806);
        Barrier barrier31 = new Barrier();
        addObject(barrier31,339,620);
        barrier31.setLocation(329,600);
        Barrier barrier32 = new Barrier();
        addObject(barrier32,616,702);
        barrier32.setLocation(612,683);
        Barrier barrier33 = new Barrier();
        addObject(barrier33,291,871);
        barrier33.setLocation(289,859);
        Barrier barrier34 = new Barrier();
        addObject(barrier34,169,708);
        barrier34.setLocation(155,684);
    }
}
