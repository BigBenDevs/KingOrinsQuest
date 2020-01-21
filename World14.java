import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * This world is one of many in this game.
 * 
 * @author (Ben Presley), Anthony Neeser
 * @version (5/8/2018)
 */
public class World14 extends World
{
    FrontPage fP = new FrontPage();
    private boolean angry;
    private int bX;
    private int bY;
    public static int archerCount = 0;
    public static int spearmanCount = 0;
    public static int blackKnightCount = 0;
    public static int fighterCount = 5;
    /**
     * Constructor for objects of class World14.
     * 
     */
    public World14()
    {    
        super(1080, 920, 1); 

        //Variables for adjacent worlds.  used for world transfering.
        MainWorld.topWorldID = 9;
        MainWorld.leftWorldID = 13;
        MainWorld.rightWorldID =15;
        MainWorld.bottomWorldID = 19;
        prepare();
        setup();
        spawnPlayer();
        setPaintOrder(FrontPage.class, InstructionParts.class, Icons.class, DialogParts.class, Slash.class, MusicButton.class, Treetop.class, Player.class, KingOrin.class,  
            JimboSubSystem.class, MattsSubSystem.class, Loot.class, Treebase.class, Shadow.class, BG.class, Barrier.class, ShopDoorExit.class);
        //Start the background music for the world IF mute is not set to 1
        if(MainWorld.mute != 1)
        {
            //MainWorld.myworldMusic.playLoop();
        }
    }

    /**
     * Controls the spawning position of player when transfering worlds.
     */
    public void spawnPlayer()
    {
        //Add player back to world when returning from Cave 1
        if (MainWorld.spawn == 33)
        {
            Player hawthorne = new Player();
            addObject(hawthorne, 596,200);
        }
        
        if (MainWorld.spawn == 14)
        {
            Player hawthorne = new Player();
            addObject(hawthorne, MainWorld.playerX ,MainWorld.playerY);
        }
        MainWorld.state = 1;
    }
    
    /**
     * Upon starting the game, or if Player dies, this handles resetting the world to the starting zone. States are also set to initial values.
     */
    public void reset()
    {
        if(MainWorld.spawn == 0)
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
        removeObject(fP);
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
        //Music button
        //MusicButton musicbutton = new MusicButton();
        //addObject(musicbutton,1053,893);

        //Everything else
        addObject(new Sign(), 525, 191);
        
        addObject(fP, 540,460);
        addObject(new MyWorldBG(), 540, 460);
        
        Barrier barrier = new Barrier();
        addObject(barrier,718,213);
        barrier.setLocation(736,217);
        Barrier barrier2 = new Barrier();
        addObject(barrier2,733,297);
        barrier2.setLocation(736,291);
        Barrier barrier3 = new Barrier();
        addObject(barrier3,734,364);
        barrier3.setLocation(736,366);
        Barrier barrier4 = new Barrier();
        addObject(barrier4,739,426);
        barrier4.setLocation(736,442);
        Barrier barrier5 = new Barrier();
        addObject(barrier5,741,528);
        barrier5.setLocation(736,515);
        Barrier barrier6 = new Barrier();
        addObject(barrier6,745,582);
        barrier6.setLocation(736,589);
        Barrier barrier7 = new Barrier();
        addObject(barrier7,816,579);
        barrier7.setLocation(811,588);
        Barrier barrier8 = new Barrier();
        addObject(barrier8,891,581);
        barrier8.setLocation(887,588);
        Barrier barrier9 = new Barrier();
        addObject(barrier9,885,511);
        barrier9.setLocation(888,512);
        barrier9.setLocation(887,514);
        Barrier barrier10 = new Barrier();
        addObject(barrier10,895,444);
        barrier10.setLocation(887,441);
        Barrier barrier11 = new Barrier();
        addObject(barrier11,887,353);
        barrier11.setLocation(887,369);
        Barrier barrier12 = new Barrier();
        addObject(barrier12,939,340);
        barrier12.setLocation(929,330);
        Barrier barrier13 = new Barrier();
        addObject(barrier13,946,262);
        barrier13.setLocation(929,254);
        barrier12.setLocation(938,329);
        barrier13.setLocation(938,253);
        Barrier barrier14 = new Barrier();
        addObject(barrier14,930,187);
        barrier14.setLocation(938,177);
        Barrier barrier15 = new Barrier();
        addObject(barrier15,1008,161);
        barrier15.setLocation(1006,146);
        Barrier barrier16 = new Barrier();
        addObject(barrier16,1067,162);
        barrier16.setLocation(1061,145);
        Barrier barrier17 = new Barrier();
        addObject(barrier17,1052,113);
        barrier17.setLocation(1056,107);
        Barrier barrier18 = new Barrier();
        addObject(barrier18,997,108);
        barrier18.setLocation(986,107);
        Barrier barrier19 = new Barrier();
        addObject(barrier19,959,42);
        barrier19.setLocation(950,37);
        barrier19.setLocation(969,33);
        Barrier barrier20 = new Barrier();
        addObject(barrier20,770,29);
        barrier20.setLocation(777,27);
        Barrier barrier21 = new Barrier();
        addObject(barrier21,777,97);
        barrier21.setLocation(777,101);
        Barrier barrier22 = new Barrier();
        addObject(barrier22,712,117);
        barrier22.setLocation(707,100);
        Barrier barrier23 = new Barrier();
        addObject(barrier23,672,115);
        barrier23.setLocation(668,100);
        Barrier barrier24 = new Barrier();
        addObject(barrier24,665,166);
        barrier24.setLocation(667,147);
        Barrier barrier25 = new Barrier();
        addObject(barrier25,733,163);
        barrier25.setLocation(741,159);
        Barrier barrier26 = new Barrier();
        addObject(barrier26,521,162);
        barrier26.setLocation(527,146);
        Barrier barrier27 = new Barrier();
        addObject(barrier27,588,91);
        barrier27.setLocation(592,97);
        Barrier barrier28 = new Barrier();
        addObject(barrier28,539,108);
        barrier28.setLocation(525,47);
        Barrier barrier29 = new Barrier();
        addObject(barrier29,463,112);
        barrier29.setLocation(452,101);
        Barrier barrier30 = new Barrier();
        addObject(barrier30,419,19);
        barrier30.setLocation(419,19);
        barrier30.setLocation(419,19);
        barrier30.setLocation(419,19);
        barrier30.setLocation(419,19);
        barrier30.setLocation(417,2);
        Barrier barrier31 = new Barrier();
        addObject(barrier31,374,128);
        barrier31.setLocation(378,101);
        Barrier barrier32 = new Barrier();
        addObject(barrier32,299,101);
        barrier32.setLocation(306,101);
        Barrier barrier33 = new Barrier();
        addObject(barrier33,212,105);
        barrier33.setLocation(230,101);
        Barrier barrier34 = new Barrier();
        addObject(barrier34,165,102);
        barrier34.setLocation(154,101);
        Barrier barrier35 = new Barrier();
        addObject(barrier35,84,93);
        barrier35.setLocation(80,101);
        Barrier barrier36 = new Barrier();
        addObject(barrier36,31,102);
        barrier36.setLocation(28,101);
        Barrier barrier37 = new Barrier();
        addObject(barrier37,204,42);
        barrier37.setLocation(199,38);
        Barrier barrier38 = new Barrier();
        addObject(barrier38,30,166);
        barrier38.setLocation(29,150);
        Barrier barrier39 = new Barrier();
        addObject(barrier39,96,169);
        barrier39.setLocation(101,148);
        Barrier barrier40 = new Barrier();
        addObject(barrier40,175,161);
        barrier40.setLocation(173,148);
        Barrier barrier41 = new Barrier();
        addObject(barrier41,247,157);
        barrier41.setLocation(246,148);
        Barrier barrier42 = new Barrier();
        addObject(barrier42,341,165);
        barrier42.setLocation(320,149);
        Barrier barrier43 = new Barrier();
        addObject(barrier43,392,157);
        barrier43.setLocation(392,148);
        Barrier barrier44 = new Barrier();
        addObject(barrier44,470,159);
        barrier44.setLocation(455,147);
        Barrier barrier45 = new Barrier();
        addObject(barrier45,514,192);
        barrier45.setLocation(521,204);
        Barrier barrier46 = new Barrier();
        addObject(barrier46,71,206);
        barrier46.setLocation(62,204);
        Barrier barrier47 = new Barrier();
        addObject(barrier47,351,618);
        barrier47.setLocation(352,618);
        Barrier barrier48 = new Barrier();
        addObject(barrier48,362,802);
        barrier48.setLocation(362,796);
        Barrier barrier49 = new Barrier();
        addObject(barrier49,322,760);
        barrier49.setLocation(336,771);
        Barrier barrier50 = new Barrier();
        addObject(barrier50,298,730);
        barrier50.setLocation(294,732);
        barrier50.setLocation(283,723);
        Barrier barrier51 = new Barrier();
        addObject(barrier51,222,664);
        barrier51.setLocation(226,677);
        Barrier barrier52 = new Barrier();
        addObject(barrier52,194,637);
        barrier52.setLocation(207,655);
        Barrier barrier53 = new Barrier();
        addObject(barrier53,167,614);
        barrier53.setLocation(177,621);
        Barrier barrier54 = new Barrier();
        addObject(barrier54,121,563);
        barrier54.setLocation(137,597);
        Barrier barrier55 = new Barrier();
        addObject(barrier55,108,551);
        barrier55.setLocation(107,551);
        Barrier barrier56 = new Barrier();
        addObject(barrier56,44,550);
        barrier56.setLocation(39,550);
        Barrier barrier57 = new Barrier();
        addObject(barrier57,13,700);
        barrier57.setLocation(23,694);
        Barrier barrier58 = new Barrier();
        addObject(barrier58,60,769);
        barrier58.setLocation(39,768);
        Barrier barrier59 = new Barrier();
        addObject(barrier59,93,797);
        barrier59.setLocation(85,794);
        Barrier barrier60 = new Barrier();
        addObject(barrier60,153,810);
        barrier60.setLocation(154,797);
        Barrier barrier61 = new Barrier();
        addObject(barrier61,118,870);
        barrier61.setLocation(116,856);
        Barrier barrier62 = new Barrier();
        addObject(barrier62,215,812);
        barrier62.setLocation(219,797);
        Barrier barrier63 = new Barrier();
        addObject(barrier63,281,802);
        barrier63.setLocation(294,798);
        Barrier barrier64 = new Barrier();
        addObject(barrier64,753,789);
        barrier64.setLocation(746,781);
        Barrier barrier65 = new Barrier();
        addObject(barrier65,812,783);
        barrier65.setLocation(818,782);
        Barrier barrier66 = new Barrier();
        addObject(barrier66,904,791);
        barrier66.setLocation(891,783);
        Barrier barrier67 = new Barrier();
        addObject(barrier67,789,849);
        barrier67.setLocation(797,853);
        Barrier barrier68 = new Barrier();
        addObject(barrier68,899,845);
        barrier68.setLocation(889,853);
        Barrier barrier69 = new Barrier();
        addObject(barrier69,936,898);
        barrier69.setLocation(935,893);
        Barrier barrier70 = new Barrier();
        addObject(barrier70,797,906);
        barrier70.setLocation(801,898);
        Barrier barrier71 = new Barrier();
        addObject(barrier71,1072,414);
        barrier71.setLocation(1072,414);
        Barrier barrier72 = new Barrier();
        addObject(barrier72,261,694);
        barrier24.setLocation(679,146);
        barrier26.setLocation(522,143);
        barrier27.setLocation(592,84);
        barrier23.setLocation(668,84);
        barrier28.setLocation(526,48);
        barrier8.setLocation(887,570);
        barrier7.setLocation(812,570);
        barrier6.setLocation(737,570);
        barrier71.setLocation(1072,414);
        barrier12.setLocation(915,318);
        barrier13.setLocation(916,252);
        barrier61.setLocation(112,836);
        barrier47.setLocation(353,599);
        barrier44.setLocation(457,136);
        barrier43.setLocation(388,136);
        barrier42.setLocation(321,137);
        barrier41.setLocation(245,137);
        barrier40.setLocation(174,137);
        barrier39.setLocation(101,137);
        barrier46.setLocation(64,187);
        barrier38.setLocation(28,140);
        barrier72.setLocation(222,716);
        barrier50.setLocation(284,738);
        barrier49.setLocation(317,760);
        barrier48.setLocation(359,787);
        barrier63.setLocation(293,786);
        barrier62.setLocation(221,786);
        barrier60.setLocation(162,785);
        barrier61.setLocation(112,829);
        ShopDoorEntrance shopdoorentrance = new ShopDoorEntrance();
        addObject(shopdoorentrance,596,151);
        shopdoorentrance.setLocation(597,114);
        shopdoorentrance.setLocation(597,144);
        Treebase treebase = new Treebase();
        addObject(treebase,370,637);
        treebase.setLocation(492,629);
        removeObject(treebase);
        Treebase treebase2 = new Treebase();
        addObject(treebase2,363,627);
        treebase2.setLocation(356,628);
        treebase2.setLocation(354,629);
        Treetop treetop = new Treetop();
        addObject(treetop,487,540);
        treetop.setLocation(355,529);
        Treebase treebase3 = new Treebase();
        addObject(treebase3,66,221);
        treebase3.setLocation(65,221);
        treebase3.setLocation(66,219);
        Treetop treetop2 = new Treetop();
        addObject(treetop2,132,125);
        treetop2.setLocation(69,122);
        Treebase treebase4 = new Treebase();
        addObject(treebase4,194,39);
        treebase4.setLocation(200,35);
        treebase4.setLocation(203,36);
        Treebase treebase5 = new Treebase();
        addObject(treebase5,414,21);
        treebase5.setLocation(417,20);
        treebase5.setLocation(416,19);
        Treebase treebase6 = new Treebase();
        addObject(treebase6,534,40);
        treebase6.setLocation(526,37);
        Treebase treebase7 = new Treebase();
        addObject(treebase7,1069,420);
        treebase7.setLocation(1069,420);
        treebase7.setLocation(1074,421);
        Treetop treetop3 = new Treetop();
        addObject(treetop3,1071,334);
        treetop3.setLocation(1071,334);
        treetop3.setLocation(1077,320);
        Treebase treebase8 = new Treebase();
        addObject(treebase8,116,872);
        treebase8.setLocation(113,871);
        Treetop treetop4 = new Treetop();
        addObject(treetop4,121,776);
        treetop4.setLocation(114,775);
        Cave1Entrance cave1entrance = new Cave1Entrance();
        addObject(cave1entrance,599,155);
    }
}
