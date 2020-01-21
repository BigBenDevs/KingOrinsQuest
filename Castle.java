import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * This world is one of many in this game.
 * 
 * @author (Ben Presley)
 * @version (5/8/2018)
 */
public class Castle extends World
{
    private boolean angry;
    private int bX;
    private int bY;
    public static int archerCount = 0;
    public static int spearmanCount = 0;
    public static int blackKnightCount = 0;
    public static int fighterCount = 0;
    /**
     * Constructor for objects of class Castle.
     * 
     */
    public Castle()
    {    
        super(1080, 920, 1);
        prepare();
        setup();
        spawnPlayer();
        setPaintOrder(Icons.class, DialogParts.class, MusicButton.class, Treetop.class, Player.class, KingOrin.class,  
            JimboSubSystem.class, BensSubSystem.class, MattsSubSystem.class, Loot.class, Treebase.class, Shadow.class, BG.class, Barrier.class, ShopDoorExit.class, CastleExit.class, InstructionParts.class);
    }

    /**
     * Controls the spawning position of player when transfering worlds.
     */
    public void spawnPlayer()
    {
        if (MainWorld.spawn == 26)
        {
            Player hawthorne = new Player();
            addObject(hawthorne, 505,760);
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
        CastleBG castlebg = new CastleBG();
        addObject(castlebg,525,493);
        castlebg.setLocation(540,461);
        KingOrin kingorin = new KingOrin();
        addObject(kingorin,527,400);
        kingorin.setLocation(528,378);
        CastleExit castleexit = new CastleExit();
        addObject(castleexit,505,836);
        Barrier barrier = new Barrier();
        addObject(barrier,970,792);
        barrier.setLocation(613,853);
        Barrier barrier2 = new Barrier();
        addObject(barrier2,550,897);
        barrier2.setLocation(551,907);
        Barrier barrier3 = new Barrier();
        addObject(barrier3,493,902);
        barrier3.setLocation(480,907);
        Barrier barrier4 = new Barrier();
        addObject(barrier4,410,869);
        barrier4.setLocation(410,878);
        Barrier barrier5 = new Barrier();
        addObject(barrier5,387,851);
        barrier5.setLocation(410,858);
        Barrier barrier6 = new Barrier();
        addObject(barrier6,344,850);
        barrier6.setLocation(341,858);
        Barrier barrier7 = new Barrier();
        addObject(barrier7,269,852);
        barrier7.setLocation(268,859);
        Barrier barrier8 = new Barrier();
        addObject(barrier8,197,859);
        barrier7.setLocation(268,858);
        barrier8.setLocation(196,857);
        barrier8.setLocation(196,858);
        Barrier barrier9 = new Barrier();
        addObject(barrier9,137,862);
        barrier9.setLocation(125,857);
        Barrier barrier10 = new Barrier();
        addObject(barrier10,90,799);
        barrier10.setLocation(96,792);
        Barrier barrier11 = new Barrier();
        addObject(barrier11,112,710);
        barrier11.setLocation(98,719);
        Barrier barrier12 = new Barrier();
        addObject(barrier12,108,638);
        barrier12.setLocation(101,645);
        Barrier barrier13 = new Barrier();
        addObject(barrier13,107,581);
        barrier13.setLocation(101,573);
        Barrier barrier14 = new Barrier();
        addObject(barrier14,112,498);
        barrier14.setLocation(101,498);
        Barrier barrier15 = new Barrier();
        addObject(barrier15,117,422);
        barrier15.setLocation(101,424);
        Barrier barrier16 = new Barrier();
        addObject(barrier16,115,344);
        barrier16.setLocation(101,349);
        Barrier barrier17 = new Barrier();
        addObject(barrier17,109,266);
        barrier17.setLocation(100,274);
        Barrier barrier18 = new Barrier();
        addObject(barrier18,123,203);
        barrier18.setLocation(101,198);
        Barrier barrier19 = new Barrier();
        addObject(barrier19,114,131);
        barrier19.setLocation(105,123);
        Barrier barrier20 = new Barrier();
        addObject(barrier20,192,124);
        barrier20.setLocation(181,110);
        Barrier barrier21 = new Barrier();
        addObject(barrier21,243,126);
        barrier21.setLocation(228,126);
        Barrier barrier22 = new Barrier();
        addObject(barrier22,301,122);
        barrier22.setLocation(301,108);
        Barrier barrier23 = new Barrier();
        addObject(barrier23,370,113);
        barrier23.setLocation(375,108);
        Barrier barrier24 = new Barrier();
        addObject(barrier24,440,112);
        barrier24.setLocation(447,107);
        Barrier barrier25 = new Barrier();
        addObject(barrier25,524,112);
        barrier25.setLocation(520,109);
        Barrier barrier26 = new Barrier();
        addObject(barrier26,587,119);
        barrier26.setLocation(595,109);
        Barrier barrier27 = new Barrier();
        addObject(barrier27,685,115);
        barrier27.setLocation(669,110);
        Barrier barrier28 = new Barrier();
        addObject(barrier28,735,116);
        barrier28.setLocation(739,110);
        Barrier barrier29 = new Barrier();
        addObject(barrier29,817,123);
        barrier29.setLocation(813,110);
        Barrier barrier30 = new Barrier();
        addObject(barrier30,828,137);
        barrier30.setLocation(823,134);
        Barrier barrier31 = new Barrier();
        addObject(barrier31,881,128);
        barrier31.setLocation(888,110);
        Barrier barrier32 = new Barrier();
        addObject(barrier32,957,134);
        barrier32.setLocation(962,130);
        Barrier barrier33 = new Barrier();
        addObject(barrier33,965,209);
        barrier33.setLocation(966,206);
        Barrier barrier34 = new Barrier();
        addObject(barrier34,968,304);
        barrier34.setLocation(967,282);
        Barrier barrier35 = new Barrier();
        addObject(barrier35,946,360);
        barrier35.setLocation(967,355);
        Barrier barrier36 = new Barrier();
        addObject(barrier36,975,486);
        barrier36.setLocation(966,431);
        Barrier barrier37 = new Barrier();
        addObject(barrier37,969,538);
        barrier37.setLocation(966,507);
        Barrier barrier38 = new Barrier();
        addObject(barrier38,966,603);
        barrier38.setLocation(964,581);
        Barrier barrier39 = new Barrier();
        addObject(barrier39,961,657);
        barrier39.setLocation(963,656);
        Barrier barrier40 = new Barrier();
        addObject(barrier40,961,745);
        barrier40.setLocation(963,732);
        Barrier barrier41 = new Barrier();
        addObject(barrier41,968,812);
        barrier41.setLocation(963,808);
        Barrier barrier42 = new Barrier();
        addObject(barrier42,924,862);
        barrier42.setLocation(914,852);
        Barrier barrier43 = new Barrier();
        addObject(barrier43,850,867);
        barrier43.setLocation(847,853);
        Barrier barrier44 = new Barrier();
        addObject(barrier44,758,842);
        barrier44.setLocation(775,851);
        Barrier barrier45 = new Barrier();
        addObject(barrier45,707,859);
        barrier45.setLocation(705,852);
        Barrier barrier46 = new Barrier();
        addObject(barrier46,663,862);
        barrier46.setLocation(662,853);
        Barrier barrier47 = new Barrier();
        addObject(barrier47,696,354);
        barrier47.setLocation(691,338);
        Barrier barrier48 = new Barrier();
        addObject(barrier48,392,339);
        barrier48.setLocation(392,336);
        barrier47.setLocation(693,336);
        if(MainWorld.pirateDead == 1)
        {
            PrincessAnna princessanna = new PrincessAnna();
            addObject(princessanna,609,393);
            princessanna.setLocation(613,381);
        }
    }
}