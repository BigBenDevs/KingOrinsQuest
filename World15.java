import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * This world is one of many in this game.
 * 
 * @author (Ben Presley), Anthony Neeser
 * @version (5/8/2018)
 */
public class World15 extends World
{
    private boolean angry;
    private int bX;
    private int bY;
    public static int archerCount = 3;
    public static int spearmanCount = 0;
    public static int blackKnightCount = 0;
    public static int fighterCount = 1;
    /**
     * Constructor for objects of class World15.
     * 
     */
    public World15()
    {    
        super(1080, 920, 1); 
        
        MainWorld.topWorldID = 10;
        MainWorld.leftWorldID = 14;
        MainWorld.rightWorldID = 99;
        MainWorld.bottomWorldID = 20;
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
        if (MainWorld.spawn == 15)
        {
            Player hawthorne = new Player();
            addObject(hawthorne, MainWorld.playerX,MainWorld.playerY);
        }
        //Returning from Cave2
        if (MainWorld.spawn == 34)
        {
            Player hawthorne = new Player();
            addObject(hawthorne, 228,230);
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
        World15BG world15bg = new World15BG();
        addObject(world15bg,443,502);
        world15bg.setLocation(540,460);
        Barrier barrier = new Barrier();
        addObject(barrier,1069,613);
        barrier.setLocation(1043,598);
        Barrier barrier2 = new Barrier();
        addObject(barrier2,1046,519);
        barrier2.setLocation(1043,522);
        Barrier barrier3 = new Barrier();
        addObject(barrier3,1044,449);
        barrier3.setLocation(1043,448);
        Barrier barrier4 = new Barrier();
        addObject(barrier4,1048,376);
        barrier4.setLocation(1043,372);
        Barrier barrier5 = new Barrier();
        addObject(barrier5,1048,293);
        barrier5.setLocation(1044,297);
        Barrier barrier6 = new Barrier();
        addObject(barrier6,1045,221);
        barrier6.setLocation(1043,223);
        Barrier barrier7 = new Barrier();
        addObject(barrier7,1039,167);
        barrier7.setLocation(1043,163);
        Barrier barrier8 = new Barrier();
        addObject(barrier8,984,172);
        barrier8.setLocation(976,164);
        Barrier barrier9 = new Barrier();
        addObject(barrier9,980,215);
        barrier9.setLocation(977,213);
        Barrier barrier10 = new Barrier();
        addObject(barrier10,919,168);
        barrier10.setLocation(910,164);
        Barrier barrier11 = new Barrier();
        addObject(barrier11,914,219);
        barrier11.setLocation(933,216);
        barrier11.setLocation(933,214);
        barrier11.setLocation(933,215);
        Barrier barrier12 = new Barrier();
        addObject(barrier12,871,167);
        barrier12.setLocation(855,164);
        Barrier barrier13 = new Barrier();
        addObject(barrier13,854,112);
        barrier13.setLocation(855,88);
        Barrier barrier14 = new Barrier();
        addObject(barrier14,856,49);
        barrier14.setLocation(855,26);
        Barrier barrier15 = new Barrier();
        addObject(barrier15,324,152);
        barrier15.setLocation(301,187);
        Barrier barrier16 = new Barrier();
        addObject(barrier16,320,140);
        barrier16.setLocation(300,130);
        Barrier barrier17 = new Barrier();
        addObject(barrier17,368,133);
        barrier17.setLocation(375,129);
        Barrier barrier18 = new Barrier();
        addObject(barrier18,442,124);
        barrier18.setLocation(439,129);
        Barrier barrier19 = new Barrier();
        addObject(barrier19,453,56);
        barrier19.setLocation(439,53);
        Barrier barrier20 = new Barrier();
        addObject(barrier20,435,21);
        barrier20.setLocation(439,17);
        Barrier barrier21 = new Barrier();
        addObject(barrier21,218,90);
        barrier21.setLocation(227,86);
        Barrier barrier22 = new Barrier();
        addObject(barrier22,143,104);
        barrier22.setLocation(154,88);
        Barrier barrier23 = new Barrier();
        addObject(barrier23,97,141);
        barrier23.setLocation(118,129);
        Barrier barrier24 = new Barrier();
        addObject(barrier24,38,134);
        barrier24.setLocation(43,130);
        Treebase treebase = new Treebase();
        addObject(treebase,184,50);
        treebase.setLocation(151,58);
        Treetop treetop = new Treetop();
        addObject(treetop,173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(173,16);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(243,5);
        treetop.setLocation(653,394);
        removeObject(treetop);
        treebase.setLocation(159,29);
        Treebase treebase2 = new Treebase();
        addObject(treebase2,240,33);
        treebase2.setLocation(237,31);
        Treetop treetop2 = new Treetop();
        addObject(treetop2,889,741);
        treetop2.setLocation(871,724);
        Treetop treetop3 = new Treetop();
        addObject(treetop3,976,728);
        treetop3.setLocation(980,711);
        Treetop treetop4 = new Treetop();
        addObject(treetop4,1061,754);
        treetop4.setLocation(1057,693);
        Treetop treetop5 = new Treetop();
        addObject(treetop5,1031,805);
        treetop5.setLocation(1031,781);
        Treetop treetop6 = new Treetop();
        addObject(treetop6,884,867);
        treetop6.setLocation(845,816);
        Treetop treetop7 = new Treetop();
        addObject(treetop7,1021,889);
        treetop7.setLocation(900,854);
        Treetop treetop8 = new Treetop();
        addObject(treetop8,1033,868);
        treetop8.setLocation(1021,854);
        Treebase treebase3 = new Treebase();
        addObject(treebase3,976,783);
        treebase3.setLocation(982,799);
        Treebase treebase4 = new Treebase();
        addObject(treebase4,917,800);
        treebase4.setLocation(878,811);
        Treebase treebase5 = new Treebase();
        addObject(treebase5,966,896);
        treetop8.setLocation(1037,842);
        treetop7.setLocation(906,864);
        treetop8.setLocation(1034,835);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(966,896);
        treebase5.setLocation(848,904);
        Treetop treetop9 = new Treetop();
        addObject(treetop9,1010,892);
        treetop9.setLocation(1018,875);
        Treetop treetop10 = new Treetop();
        addObject(treetop10,925,586);
        Treebase treebase6 = new Treebase();
        addObject(treebase6,940,675);
        treetop3.setLocation(982,711);
        treetop3.setLocation(981,710);
        treetop2.setLocation(873,724);
        treebase6.setLocation(928,675);
        Barrier barrier73 = new Barrier();
        addObject(barrier73,861,875);
        Barrier barrier74 = new Barrier();
        addObject(barrier74,883,780);
        Barrier barrier75 = new Barrier();
        addObject(barrier75,926,690);
        Barrier barrier76 = new Barrier();
        addObject(barrier76,984,787);
        Barrier barrier77 = new Barrier();
        addObject(barrier77,1044,898);
        Barrier barrier78 = new Barrier();
        addObject(barrier78,1046,819);
        Cave2Entrance cave2entrance = new Cave2Entrance();
        addObject(cave2entrance,228,169);
    }
}
