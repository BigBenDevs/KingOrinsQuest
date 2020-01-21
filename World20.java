import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * This world is one of many in this game.
 * 
 * @author (Ben Presley), Anthony Neeser
 * @version (5/8/2018)
 */
public class World20 extends World
{
    private boolean angry;
    private int bX;
    private int bY;
    public static int archerCount = 1;
    public static int spearmanCount = 0;
    public static int blackKnightCount = 0;
    public static int fighterCount = 3;
    /**
     * Constructor for objects of class World20.
     * 
     */
    public World20()
    {    
        super(1080, 920, 1); 
        
        MainWorld.topWorldID = 15;
        MainWorld.leftWorldID = 19;
        MainWorld.rightWorldID = 99;
        MainWorld.bottomWorldID = 25;
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
        if (MainWorld.spawn == 20)
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
        World20BG world20bg = new World20BG();
        addObject(world20bg,473,431);
        world20bg.setLocation(540,460);
        Barrier barrier = new Barrier();
        addObject(barrier,1046,38);
        Barrier barrier2 = new Barrier();
        addObject(barrier2,1059,119);
        barrier2.setLocation(1059,119);
        barrier2.setLocation(1059,119);
        barrier2.setLocation(1059,119);
        barrier2.setLocation(1059,119);
        barrier2.setLocation(1059,119);
        barrier2.setLocation(1059,119);
        barrier2.setLocation(1059,119);
        barrier2.setLocation(1059,119);
        barrier2.setLocation(1059,119);
        barrier2.setLocation(1059,119);
        barrier2.setLocation(1059,119);
        barrier2.setLocation(1059,119);
        barrier2.setLocation(1059,119);
        barrier2.setLocation(1059,119);
        barrier2.setLocation(1059,119);
        barrier2.setLocation(1046,113);
        Barrier barrier3 = new Barrier();
        addObject(barrier3,1036,187);
        barrier3.setLocation(1046,147);
        Barrier barrier4 = new Barrier();
        addObject(barrier4,1039,214);
        barrier4.setLocation(1046,220);
        Barrier barrier5 = new Barrier();
        addObject(barrier5,969,210);
        barrier5.setLocation(977,215);
        Barrier barrier6 = new Barrier();
        addObject(barrier6,903,208);
        barrier6.setLocation(904,215);
        Barrier barrier7 = new Barrier();
        addObject(barrier7,846,232);
        barrier7.setLocation(842,215);
        Barrier barrier8 = new Barrier();
        addObject(barrier8,782,230);
        barrier8.setLocation(774,215);
        Barrier barrier9 = new Barrier();
        addObject(barrier9,792,300);
        barrier9.setLocation(774,265);
        Barrier barrier10 = new Barrier();
        addObject(barrier10,771,311);
        barrier10.setLocation(774,303);
        Barrier barrier11 = new Barrier();
        addObject(barrier11,844,312);
        barrier11.setLocation(849,303);
        Barrier barrier12 = new Barrier();
        addObject(barrier12,916,315);
        barrier12.setLocation(919,303);
        Barrier barrier13 = new Barrier();
        addObject(barrier13,978,309);
        barrier13.setLocation(995,303);
        Barrier barrier14 = new Barrier();
        addObject(barrier14,1027,366);
        barrier14.setLocation(1031,366);
        Barrier barrier15 = new Barrier();
        addObject(barrier15,1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,388);
        barrier15.setLocation(1074,437);
        Barrier barrier16 = new Barrier();
        addObject(barrier16,540,323);
        barrier16.setLocation(557,305);
        Barrier barrier17 = new Barrier();
        addObject(barrier17,548,243);
        barrier17.setLocation(557,242);
        Barrier barrier18 = new Barrier();
        addObject(barrier18,573,227);
        barrier18.setLocation(557,222);
        Barrier barrier19 = new Barrier();
        addObject(barrier19,463,199);
        barrier19.setLocation(481,220);
        barrier19.setLocation(481,222);
        Barrier barrier20 = new Barrier();
        addObject(barrier20,403,237);
        barrier20.setLocation(406,222);
        Barrier barrier21 = new Barrier();
        addObject(barrier21,331,229);
        barrier21.setLocation(331,221);
        barrier21.setLocation(330,222);
        Barrier barrier22 = new Barrier();
        addObject(barrier22,246,220);
        barrier22.setLocation(256,222);
        Barrier barrier23 = new Barrier();
        addObject(barrier23,190,226);
        barrier23.setLocation(182,222);
        Barrier barrier24 = new Barrier();
        addObject(barrier24,125,223);
        barrier24.setLocation(120,222);
        Barrier barrier25 = new Barrier();
        addObject(barrier25,114,159);
        barrier25.setLocation(118,160);
        Barrier barrier26 = new Barrier();
        addObject(barrier26,47,166);
        barrier26.setLocation(47,160);
        Barrier barrier27 = new Barrier();
        addObject(barrier27,24,169);
        barrier27.setLocation(24,159);
        barrier27.setLocation(24,160);
        Barrier barrier28 = new Barrier();
        addObject(barrier28,24,229);
        barrier28.setLocation(28,232);
        Barrier barrier29 = new Barrier();
        addObject(barrier29,80,241);
        barrier29.setLocation(103,232);
        Barrier barrier30 = new Barrier();
        addObject(barrier30,130,285);
        barrier30.setLocation(148,300);
        Barrier barrier31 = new Barrier();
        addObject(barrier31,224,306);
        barrier31.setLocation(224,301);
        Barrier barrier32 = new Barrier();
        addObject(barrier32,287,295);
        barrier32.setLocation(300,301);
        Barrier barrier33 = new Barrier();
        addObject(barrier33,370,309);
        barrier33.setLocation(374,301);
        Barrier barrier34 = new Barrier();
        addObject(barrier34,447,312);
        barrier34.setLocation(450,301);
        Barrier barrier35 = new Barrier();
        addObject(barrier35,500,303);
        barrier35.setLocation(507,302);
        Treetop treetop = new Treetop();
        addObject(treetop,871,530);
        treetop.setLocation(844,405);
        Treetop treetop2 = new Treetop();
        addObject(treetop2,906,434);
        Treetop treetop3 = new Treetop();
        addObject(treetop3,1060,525);
        treetop3.setLocation(1045,520);
        Treetop treetop4 = new Treetop();
        addObject(treetop4,976,480);
        treetop4.setLocation(975,465);
        Treetop treetop5 = new Treetop();
        addObject(treetop5,864,522);
        treetop5.setLocation(836,505);
        Treetop treetop6 = new Treetop();
        addObject(treetop6,953,556);
        treetop6.setLocation(916,555);
        Treetop treetop7 = new Treetop();
        addObject(treetop7,1003,571);
        treetop7.setLocation(995,554);
        Treetop treetop8 = new Treetop();
        addObject(treetop8,835,649);
        treetop8.setLocation(1045,620);
        Treetop treetop9 = new Treetop();
        addObject(treetop9,905,633);
        treetop9.setLocation(905,637);
        Treetop treetop10 = new Treetop();
        addObject(treetop10,977,623);
        treetop10.setLocation(977,629);
        Treetop treetop11 = new Treetop();
        addObject(treetop11,835,616);
        treetop11.setLocation(836,609);
        Treebase treebase = new Treebase();
        addObject(treebase,919,509);
        treetop6.setLocation(917,611);
        treebase.setLocation(913,515);
        treetop6.setLocation(933,546);
        Treetop treetop12 = new Treetop();
        addObject(treetop12,865,767);
        treetop12.setLocation(1022,797);
        Treebase treebase2 = new Treebase();
        addObject(treebase2,847,710);
        treebase2.setLocation(837,695);
        treetop12.setLocation(867,699);
        Treetop treetop13 = new Treetop();
        addObject(treetop13,954,697);
        treetop13.setLocation(951,695);
        Treetop treetop14 = new Treetop();
        addObject(treetop14,1037,742);
        treetop14.setLocation(1047,805);
        Treebase treebase3 = new Treebase();
        addObject(treebase3,1061,709);
        treebase3.setLocation(1048,709);
        treetop14.setLocation(1015,732);
        Treetop treetop15 = new Treetop();
        addObject(treetop15,936,776);
        treetop15.setLocation(931,766);
        Treetop treetop16 = new Treetop();
        addObject(treetop16,861,792);
        treetop16.setLocation(842,768);
        Treetop treetop17 = new Treetop();
        addObject(treetop17,1053,808);
        treetop17.setLocation(1051,788);
        Treebase treebase4 = new Treebase();
        addObject(treebase4,934,896);
        treebase4.setLocation(1012,820);
        Treetop treetop18 = new Treetop();
        addObject(treetop18,999,847);
        treetop18.setLocation(990,847);
        Treebase treebase5 = new Treebase();
        addObject(treebase5,1079,903);
        treebase5.setLocation(1063,877);
        Treetop treetop19 = new Treetop();
        addObject(treetop19,868,867);
        treetop19.setLocation(902,848);
        Treebase treebase6 = new Treebase();
        addObject(treebase6,762,866);
        treebase6.setLocation(845,857);
        treetop19.setLocation(872,846);
        Treebase treebase7 = new Treebase();
        addObject(treebase7,740,869);
        treebase7.setLocation(928,852);
        Treetop treetop20 = new Treetop();
        addObject(treetop20,924,855);
        treetop20.setLocation(863,908);
        Treetop treetop21 = new Treetop();
        addObject(treetop21,930,900);
        treetop21.setLocation(955,905);
        Treetop treetop22 = new Treetop();
        addObject(treetop22,1039,898);
        treetop22.setLocation(1052,887);
        Barrier barrier36 = new Barrier();
        addObject(barrier36,856,451);
        barrier36.setLocation(848,375);
        Barrier barrier37 = new Barrier();
        addObject(barrier37,862,459);
        barrier37.setLocation(850,449);
        Barrier barrier38 = new Barrier();
        addObject(barrier38,863,530);
        barrier38.setLocation(850,524);
        Barrier barrier39 = new Barrier();
        addObject(barrier39,873,606);
        barrier39.setLocation(851,598);
        Barrier barrier40 = new Barrier();
        addObject(barrier40,873,693);
        barrier40.setLocation(852,672);
        Barrier barrier41 = new Barrier();
        addObject(barrier41,853,762);
        barrier41.setLocation(853,747);
        Barrier barrier42 = new Barrier();
        addObject(barrier42,853,819);
        barrier42.setLocation(852,822);
        Barrier barrier43 = new Barrier();
        addObject(barrier43,850,883);
        barrier43.setLocation(852,896);
        Barrier barrier44 = new Barrier();
        addObject(barrier44,942,887);
        Barrier barrier45 = new Barrier();
        addObject(barrier45,1025,890);
        Barrier barrier46 = new Barrier();
        addObject(barrier46,1049,762);
        Barrier barrier47 = new Barrier();
        addObject(barrier47,961,769);
        Barrier barrier48 = new Barrier();
        addObject(barrier48,1031,646);
        Barrier barrier49 = new Barrier();
        addObject(barrier49,950,659);
        Barrier barrier50 = new Barrier();
        addObject(barrier50,1042,551);
        Barrier barrier51 = new Barrier();
        addObject(barrier51,951,549);
        Barrier barrier52 = new Barrier();
        addObject(barrier52,952,450);
        Barrier barrier53 = new Barrier();
        addObject(barrier53,953,379);
    }
}
